# ==============================================================================
# ROS Dockerfile
# ==============================================================================

# 1. Base Image
FROM docker.io/osrf/ros:noetic-desktop-full

# 2. Multi-Architecture and Metadata
ARG TARGETARCH
LABEL org.opencontainers.image.architecture="${TARGETARCH:-amd64}"
# Metadata
LABEL org.opencontainers.image.authors="hi.kondo, Yasuto Shiigi"
LABEL org.opencontainers.image.description="SEED-R7ロボットをROS環境で制御・運用するためのメタパッケージです。ロボットのモデル記述、Gazeboシミュレーション、MoveIt!動作計画、ROSナビゲーション、そして実機制御のためのインターフェースとコントローラーなど、複数のサブパッケージから構成されています。"


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
    libudev-dev \
    mesa-utils \
    python3-catkin-tools \
    python3-pip \
    python3-rosdep \
    python3-rosinstall \
    python3-rosinstall-generator \
    python3-wstool \
    ros-noetic-amcl \
    ros-noetic-angles \
    ros-noetic-control-msgs \
    ros-noetic-control-toolbox \
    ros-noetic-controller-manager \
    ros-noetic-dwa-local-planner \
    ros-noetic-gazebo-plugins \
    ros-noetic-gazebo-ros \
    ros-noetic-gazebo-ros-control \
    ros-noetic-gazebo-ros-pkgs \
    ros-noetic-geometry-msgs \
    ros-noetic-global-planner \
    ros-noetic-gmapping \
    ros-noetic-hardware-interface \
    ros-noetic-joint-limits-interface \
    ros-noetic-joint-state-controller \
    ros-noetic-joint-state-publisher \
    ros-noetic-joint-state-publisher-gui \
    ros-noetic-joint-trajectory-controller \
    ros-noetic-joy \
    ros-noetic-map-server \
    ros-noetic-message-generation \
    ros-noetic-move-base \
    ros-noetic-move-base-msgs \
    ros-noetic-moveit-commander \
    ros-noetic-moveit-core \
    ros-noetic-moveit-fake-controller-manager \
    ros-noetic-moveit-kinematics \
    ros-noetic-moveit-planners-ompl \
    ros-noetic-moveit-ros-planning \
    ros-noetic-moveit-ros-planning-interface \
    ros-noetic-moveit-ros-visualization \
    ros-noetic-moveit-setup-assistant \
    ros-noetic-moveit-simple-controller-manager \
    ros-noetic-nav-msgs \
    ros-noetic-pluginlib \
    ros-noetic-realtime-tools \
    ros-noetic-robot-state-publisher \
    ros-noetic-ros-control \
    ros-noetic-ros-controllers \
    ros-noetic-roscpp \
    ros-noetic-rospy \
    ros-noetic-rqt-common-plugins \
    ros-noetic-rqt-gui \
    ros-noetic-rviz \
    ros-noetic-rviz-plugin-tutorials \
    ros-noetic-sensor-msgs \
    ros-noetic-smach-ros \
    ros-noetic-smach-viewer \
    ros-noetic-std-msgs \
    ros-noetic-teb-local-planner \
    ros-noetic-teleop-twist-joy \
    ros-noetic-tf \
    ros-noetic-tf2-ros \
    ros-noetic-trajectory-msgs \
    ros-noetic-transmission-interface \
    ros-noetic-urg-node \
    ros-noetic-xacro \
    x11-apps \
    && rm -rf /var/lib/apt/lists/*

# 5. Install Python Dependencies
RUN pip3 install --no-cache-dir pyserial

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
RUN git clone -b master https://github.com/seed-solutions/seed_smartactuator_sdk.git
RUN git clone -b master https://github.com/seed-solutions/seed_r7_ros_pkg.git

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
