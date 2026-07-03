# eval3_service_client_cpp_pkg

C++ service client node that calls reset and set_bool services periodically.

## Package Summary

- Package: `eval3_service_client_cpp_pkg`
- Node executable: `eval3_service_client_node`
- Node class: `Eval3ServiceClientNode`
- Language: `C++`
- License: `BSD-3-Clause`


## Generated Files

- `package.xml`
- `LICENSE`
- `README.md`
- `launch/eval3_service_client_node.launch.py`
- `config/params.yaml`
- `CMakeLists.txt`
- `include/eval3_service_client_cpp_pkg/eval3_service_client_node.hpp`
- `src/eval3_service_client_node.cpp`
- `src/main.cpp`

## Build

From the generated workspace directory:

```bash
cd ./generated_sample_template_package/eval3_service_client_cpp_pkg/cpp/template
colcon build --merge-install --symlink-install --packages-select eval3_service_client_cpp_pkg
source install/setup.bash
```

## Run

```bash
ros2 launch eval3_service_client_cpp_pkg eval3_service_client_node.launch.py
```

## Lifecycle Operation

This package generates a ROS 2 Lifecycle node. After launch, configure and activate it:

```bash
ros2 lifecycle get /eval3_service_client_node
ros2 lifecycle set /eval3_service_client_node configure
ros2 lifecycle set /eval3_service_client_node activate
```

To stop active publishers and timers:

```bash
ros2 lifecycle set /eval3_service_client_node deactivate
```

## Topics

None.

## Services

| Role | Name | Type | Callback / Variable | Summary |
| --- | --- | --- | --- | --- |
| Client | reset | std_srvs/srv/Trigger | call_reset | Call reset service. |
| Client | set_bool | std_srvs/srv/SetBool | call_set_bool | Call set_bool service. |

Useful commands:

```bash
ros2 service list
ros2 service type reset
ros2 service type set_bool
```

## Actions

None.

## Parameters

None.

This package does not define user parameters.

## Timers

| Name | Period | Callback | Description |
| --- | --- | --- | --- |
| service_call_timer | 2.0 sec | service_call_timer_callback | Call services periodically. |

Timers are created during `on_configure`, started during `on_activate`, and stopped during `on_deactivate`.

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
colcon build --merge-install --symlink-install --packages-select eval3_service_client_cpp_pkg
source install/setup.bash
ros2 launch eval3_service_client_cpp_pkg eval3_service_client_node.launch.py
ros2 lifecycle set /eval3_service_client_node configure
ros2 lifecycle set /eval3_service_client_node activate
```
