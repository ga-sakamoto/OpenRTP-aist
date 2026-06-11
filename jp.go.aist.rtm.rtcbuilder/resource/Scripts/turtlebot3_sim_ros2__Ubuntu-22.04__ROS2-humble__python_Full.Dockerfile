# ==============================================================================
# ROS Dockerfile
# ==============================================================================

# 1. Base Image
FROM docker.io/osrf/ros:humble-desktop-full

# 2. Multi-Architecture and Metadata
ARG TARGETARCH
LABEL org.opencontainers.image.architecture="${TARGETARCH:-amd64}"
# Metadata
LABEL org.opencontainers.image.authors="ROBOTIS"
LABEL org.opencontainers.image.description="TurtleBot3 Simulations for ROS 2"


# 3. Environment Variables
ENV DEBIAN_FRONTEND=noninteractive
ENV ROS_DISTRO=humble

# 4. Install System Dependencies
RUN apt-get update && apt-get install -y \
    sudo \
    build-essential \
    cmake \
    git \
    libboost-all-dev \
    libgl1-mesa-dri \
    libgl1-mesa-glx \
    mesa-utils \
    python3-colcon-common-extensions \
    python3-pip \
    python3-rosdep \
    python3-setuptools \
    ros-humble-ament-cmake \
    ros-humble-gazebo-ros-pkgs \
    ros-humble-rclpy \
    ros-humble-rviz2 \
    ros-humble-tf2 \
    ros-humble-turtlebot3-bringup \
    ros-humble-turtlebot3-description \
    ros-humble-turtlebot3-msgs \
    ros-humble-turtlebot3-teleop \
    ros-humble-xacro \
    x11-apps \
    && rm -rf /var/lib/apt/lists/*

# 6. Create Non-root User
ARG USERNAME=container_user
ARG USER_UID=1000
ARG USER_GID=$USER_UID
ARG USER_PASSWORD=container_user

RUN (userdel -r ubuntu || true) \
    && groupadd --gid $USER_GID $USERNAME \
    && useradd --uid $USER_UID --gid $USER_GID -m -s /bin/bash $USERNAME \
    && echo "$USERNAME:$USER_PASSWORD" | chpasswd \
    && usermod -aG sudo $USERNAME \
    && echo "$USERNAME ALL=(root) NOPASSWD:ALL" > /etc/sudoers.d/$USERNAME \
    && chmod 0440 /etc/sudoers.d/$USERNAME

USER $USERNAME

RUN echo "source /opt/ros/${ROS_DISTRO}/setup.bash" >> /home/$USERNAME/.bashrc && \
    echo "if [ -f /workspace/colcon_ws/install/setup.bash ]; then source /workspace/colcon_ws/install/setup.bash; fi" >> /home/$USERNAME/.bashrc

# 7. Setup Workspace
RUN sudo mkdir -p /workspace/colcon_ws/src \
    && sudo chown -R $USERNAME:$USERNAME /workspace
WORKDIR /workspace/colcon_ws/src

# 8. Clone and Build Source Code
RUN git clone -b humble https://github.com/ROBOTIS-GIT/turtlebot3_simulations.git

WORKDIR /workspace/colcon_ws
RUN sudo apt-get update && rosdep update && rosdep install -r -y -i --from-paths src
RUN bash -c "source /opt/ros/${ROS_DISTRO}/setup.bash && MAKEFLAGS='-j2' colcon build --symlink-install --executor sequential" 

# 9. Setup Entrypoint
RUN echo '#!/bin/bash' > /workspace/entrypoint.sh && \
    echo 'set -e' >> /workspace/entrypoint.sh && \
    echo 'source /opt/ros/${ROS_DISTRO}/setup.bash' >> /workspace/entrypoint.sh && \
    echo 'if [ -f /workspace/colcon_ws/install/setup.bash ]; then source /workspace/colcon_ws/install/setup.bash; fi' >> /workspace/entrypoint.sh && \
    echo 'exec "$@"' >> /workspace/entrypoint.sh && \
    sudo chmod +x /workspace/entrypoint.sh

WORKDIR /workspace/colcon_ws

# 10. Setup Volume for Logs
RUN mkdir -p /home/$USERNAME/.ros/log \
    && sudo chown -R $USERNAME:$USERNAME /home/$USERNAME/.ros
VOLUME ["/home/$USERNAME/.ros/log"]

# 11. Security: Revoke Sudo Privileges
RUN sudo rm -f /etc/sudoers.d/$USERNAME
    && test ! -f /etc/sudoers.d/$USERNAME

# 12. Execution Command
STOPSIGNAL SIGINT
ENTRYPOINT ["/workspace/entrypoint.sh"]
CMD ["bash"]
