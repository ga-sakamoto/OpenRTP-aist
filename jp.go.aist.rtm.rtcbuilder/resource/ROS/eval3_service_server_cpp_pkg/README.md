# eval3_service_server_cpp_pkg

C++ service server node with reset and set_bool service servers.

## Package Summary

- Package: `eval3_service_server_cpp_pkg`
- Node executable: `eval3_service_server_node`
- Node class: `Eval3ServiceServerNode`
- Language: `C++`
- License: `BSD-3-Clause`


## Generated Files

- `package.xml`
- `LICENSE`
- `README.md`
- `launch/eval3_service_server_node.launch.py`
- `config/params.yaml`
- `CMakeLists.txt`
- `include/eval3_service_server_cpp_pkg/eval3_service_server_node.hpp`
- `src/eval3_service_server_node.cpp`
- `src/main.cpp`

## Build

From the generated workspace directory:

```bash
cd ./generated_sample_template_package/eval3_service_server_cpp_pkg/cpp/template
colcon build --merge-install --symlink-install --packages-select eval3_service_server_cpp_pkg
source install/setup.bash
```

## Run

```bash
ros2 launch eval3_service_server_cpp_pkg eval3_service_server_node.launch.py
```

## Lifecycle Operation

This package generates a ROS 2 Lifecycle node. After launch, configure and activate it:

```bash
ros2 lifecycle get /eval3_service_server_node
ros2 lifecycle set /eval3_service_server_node configure
ros2 lifecycle set /eval3_service_server_node activate
```

To stop active publishers and timers:

```bash
ros2 lifecycle set /eval3_service_server_node deactivate
```

## Topics

None.

## Services

| Role | Name | Type | Callback / Variable | Summary |
| --- | --- | --- | --- | --- |
| Server | reset | std_srvs/srv/Trigger | reset_callback | Reset internal state. |
| Server | set_bool | std_srvs/srv/SetBool | set_bool_callback | Accept boolean command for evaluation. |

Useful commands:

```bash
ros2 service list
ros2 service type reset
# ros2 service call reset std_srvs/srv/Trigger '<yaml-request>'
ros2 service type set_bool
# ros2 service call set_bool std_srvs/srv/SetBool '<yaml-request>'
```

## Actions

None.

## Parameters

None.

This package does not define user parameters.

## Timers

None.

## Manual Editing Guide

- Add topic receive logic in generated subscriber callbacks.
- Add publish logic after the lifecycle node is active. Lifecycle publishers should publish after activation.
- Add service server behavior in generated service callback functions.
- Fill service client request fields before calling the generated client helper.
- Fill action goal, feedback, and result fields according to the selected action type.
- Add timer behavior in generated timer callbacks.
- Keep reusable helper functions near the generated callback that uses them, or add a clearly named user helper section.

## Quick Evaluation Checklist

```bash
colcon build --merge-install --symlink-install --packages-select eval3_service_server_cpp_pkg
source install/setup.bash
ros2 launch eval3_service_server_cpp_pkg eval3_service_server_node.launch.py
ros2 lifecycle set /eval3_service_server_node configure
ros2 lifecycle set /eval3_service_server_node activate
```
