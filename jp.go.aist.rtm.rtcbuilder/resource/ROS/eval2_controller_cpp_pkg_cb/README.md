# eval2_controller_cpp_pkg

C++ controller node with cmd_vel subscription, robot_status publisher, timer, and max_speed parameter.

## Package Summary

- Package: `eval2_controller_cpp_pkg`
- Node executable: `eval2_controller_node`
- Node class: `Eval2ControllerNode`
- Language: `C++`
- License: `Apache-2.0`


## Generated Files

- `package.xml`
- `LICENSE`
- `README.md`
- `launch/eval2_controller_node.launch.py`
- `config/params.yaml`
- `CMakeLists.txt`
- `include/eval2_controller_cpp_pkg/eval2_controller_node.hpp`
- `src/eval2_controller_node.cpp`
- `src/main.cpp`

## Build

From the generated workspace directory:

```bash
cd ./generated_sample_template_package/eval2_controller_cpp_pkg/cpp/template
colcon build --merge-install --symlink-install --packages-select eval2_controller_cpp_pkg
source install/setup.bash
```

## Run

```bash
ros2 launch eval2_controller_cpp_pkg eval2_controller_node.launch.py
```

## Lifecycle Operation

This package generates a ROS 2 Lifecycle node. After launch, configure and activate it:

```bash
ros2 lifecycle get /eval2_controller_node
ros2 lifecycle set /eval2_controller_node configure
ros2 lifecycle set /eval2_controller_node activate
```

To stop active publishers and timers:

```bash
ros2 lifecycle set /eval2_controller_node deactivate
```

## Topics

| Direction | Name | Type | QoS | Callback / Variable | Summary |
| --- | --- | --- | --- | --- | --- |
| Publish | robot_status | std_msgs/msg/String | Reliable, Keep Last, depth=10 | Publisher variable: robot_status_pub | Publish robot status text. |
| Subscribe | cmd_vel | geometry_msgs/msg/Twist | Reliable, Keep Last, depth=10 | Callback: cmd_vel_callback | Receive velocity command. |

Useful commands:

```bash
ros2 topic list
ros2 topic info robot_status
ros2 topic echo robot_status
ros2 topic info cmd_vel
# ros2 topic pub cmd_vel geometry_msgs/msg/Twist '<yaml-message>'
```

## Services

None.

## Actions

None.

## Parameters

| Name | Type | Default | ReadOnly | Min | Max | Step | Summary |
| --- | --- | --- | --- | --- | --- | --- | --- |
| max_speed | double | 1.0 | false | 0.0 | 5.0 | 0.1 | Maximum linear speed used by the controller. |

Parameter values are generated in `config/params.yaml`.

`min`, `max`, and `step` are preserved as ROS Profile / documentation information only. They are
not used for automatic runtime checks in the generated node. If the node must reject out-of-range
values, implement the required validation manually in `on_set_parameters()`.

Useful commands:

```bash
ros2 param list /eval2_controller_node
ros2 param dump /eval2_controller_node
# ros2 param set /eval2_controller_node <parameter_name> <value>
```

## Timers

| Name | Period | Callback | Description |
| --- | --- | --- | --- |
| status_timer | 1.0 sec | status_timer_callback | Publish status periodically. |

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
colcon build --merge-install --symlink-install --packages-select eval2_controller_cpp_pkg
source install/setup.bash
ros2 launch eval2_controller_cpp_pkg eval2_controller_node.launch.py
ros2 lifecycle set /eval2_controller_node configure
ros2 lifecycle set /eval2_controller_node activate
```
