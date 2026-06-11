# ==============================================================================
# ROS Dockerfile
# ==============================================================================

# 1. Base Image
FROM docker.io/osrf/ros:noetic-desktop-full

# 2. Multi-Architecture and Metadata
ARG TARGETARCH
LABEL org.opencontainers.image.architecture="${TARGETARCH:-amd64}"
# Metadata
LABEL org.opencontainers.image.authors="Open Robotics"
LABEL org.opencontainers.image.description="ROS 1 image_pipeline package. Includes camera_calibration (Python) and image_proc (C++)."


# 3. Environment Variables
ENV DEBIAN_FRONTEND=noninteractive
ENV ROS_DISTRO=noetic

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
    python3-catkin-tools \
    python3-opencv \
    python3-pip \
    python3-rosdep \
    python3-rosinstall \
    python3-rosinstall-generator \
    python3-wstool \
    ros-noetic-camera-calibration-parsers \
    ros-noetic-camera-info-manager \
    ros-noetic-cv-bridge \
    ros-noetic-eigen-conversions \
    ros-noetic-image-geometry \
    ros-noetic-image-transport \
    ros-noetic-rospy \
    ros-noetic-sensor-msgs \
    ros-noetic-std-msgs \
    ros-noetic-tf2 \
    ros-noetic-tf2-geometry-msgs \
    ros-noetic-tf2-ros \
    x11-apps \
    && rm -rf /var/lib/apt/lists/*

# 5. Install Python Dependencies
RUN pip3 install --no-cache-dir imutils

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
    echo "if [ -f /workspace/catkin_ws/devel/setup.bash ]; then source /workspace/catkin_ws/devel/setup.bash; fi" >> /home/$USERNAME/.bashrc

# 7. Setup Workspace
RUN sudo mkdir -p /workspace/catkin_ws/src \
    && sudo chown -R $USERNAME:$USERNAME /workspace
WORKDIR /workspace/catkin_ws/src

# 8. Clone and Build Source Code
RUN git clone -b noetic https://github.com/ros-perception/image_pipeline.git

WORKDIR /workspace/catkin_ws
RUN rosdep init || true && rosdep update && sudo apt-get update && rosdep install -r -y -i --from-paths src
RUN catkin init && bash -c "source /opt/ros/${ROS_DISTRO}/setup.bash && catkin build -j2" 

# 9. Setup Entrypoint
RUN echo '#!/bin/bash' > /workspace/entrypoint.sh && \
    echo 'set -e' >> /workspace/entrypoint.sh && \
    echo 'source /opt/ros/${ROS_DISTRO}/setup.bash' >> /workspace/entrypoint.sh && \
    echo 'if [ -f /workspace/catkin_ws/devel/setup.bash ]; then source /workspace/catkin_ws/devel/setup.bash; fi' >> /workspace/entrypoint.sh && \
    echo 'exec "$@"' >> /workspace/entrypoint.sh && \
    sudo chmod +x /workspace/entrypoint.sh

WORKDIR /workspace/catkin_ws

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
