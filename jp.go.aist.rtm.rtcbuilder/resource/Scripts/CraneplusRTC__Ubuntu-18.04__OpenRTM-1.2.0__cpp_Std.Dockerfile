# ==============================================================================
# OpenRTM Dockerfile
# ==============================================================================

# 1. Base Image
FROM docker.io/library/ubuntu:18.04

# 2. Multi-Architecture and Metadata
ARG TARGETARCH
LABEL org.opencontainers.image.architecture="${TARGETARCH:-amd64}"
# Metadata
LABEL org.opencontainers.image.authors="rsdlab"
LABEL org.opencontainers.image.description="CraneplusRTC"


# 3. Environment Variables
ENV DEBIAN_FRONTEND=noninteractive

# 4. Setup Repositories and Install System Dependencies
RUN apt-get update && apt-get install -y sudo && rm -rf /var/lib/apt/lists/*

RUN apt-get update && apt-get install -y gnupg2 \
    && apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv-keys 4BCE106E087AFAC0 \
    && rm -f /etc/apt/sources.list.d/openrtm.list \
    && echo "deb http://openrtm.org/pub/Linux/ubuntu bionic main" > /etc/apt/sources.list.d/openrtm.list
RUN apt-get update \
    && apt-get install -y --allow-unauthenticated \
    build-essential \
    cmake \
    doxygen \
    git \
    libboost-all-dev \
    libomniorb4-dev \
    libopencv-dev \
    libudev-dev \
    omniidl \
    omniorb-nameserver \
    openrtm-aist \
    openrtm-aist-dev \
    pkg-config \
    python3-dev \
    python3-omniorb \
    python3-pip \
    uuid-dev \
    && apt-get clean \
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

# 7. Setup Workspace
RUN mkdir -p /workspace/workspace && chown -R $USERNAME:$USERNAME /workspace
USER $USERNAME
WORKDIR /workspace/workspace

# 8. Clone and Build Source Code

RUN git clone -b main https://github.com/masahiro0720/CRANEplusRTC_ver2.git \
    && cd CRANEplusRTC_ver2 \
    && git submodule update --init --recursive \
    && mkdir -p build && cd build \
    && cmake .. -DBUILD_DOCUMENTATION=OFF -DCMAKE_POSITION_INDEPENDENT_CODE=ON \
    && make -j2

# 9. Setup Entrypoint
RUN echo '#!/bin/bash' > /workspace/entrypoint.sh && \
    echo 'set -e' >> /workspace/entrypoint.sh && \
    echo '# Add RTM specific environment variables here if needed in the future' >> /workspace/entrypoint.sh && \
    echo 'exec "$@"' >> /workspace/entrypoint.sh && \
    sudo chmod +x /workspace/entrypoint.sh

# 10. Setup Volume for Logs
RUN mkdir -p /workspace/workspace/logs && sudo chown $USERNAME:$USERNAME /workspace/workspace/logs
WORKDIR /workspace/workspace
VOLUME ["/workspace/workspace/logs"]

# 11. Security: Revoke Sudo Privileges
RUN sudo rm -f /etc/sudoers.d/$USERNAME
    && test ! -f /etc/sudoers.d/$USERNAME

# 12. Execution Command
STOPSIGNAL SIGINT
ENTRYPOINT ["/workspace/entrypoint.sh"]
CMD ["bash"]
