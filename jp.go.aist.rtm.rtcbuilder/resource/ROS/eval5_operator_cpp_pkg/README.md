# eval5_operator_cpp_pkg

C++ operator-side all-in-one sample node that communicates with the robot-side node.

## Package Summary

- Package: `eval5_operator_cpp_pkg`
- Node executable: `eval5_operator_node`
- Node class: `Eval5OperatorNode`
- Language: `C++`
- License: `LGPL-3.0`


This node uses custom interfaces from the companion `eval5_operator_cpp_pkg_interfaces` package. Build both packages from the same workspace.

## Generated Files

- `package.xml`
- `LICENSE`
- `README.md`
- `launch/eval5_operator_node.launch.py`
- `config/params.yaml`
- `CMakeLists.txt`
- `include/eval5_operator_cpp_pkg/eval5_operator_node.hpp`
- `src/eval5_operator_node.cpp`
- `src/main.cpp`

## Build

From the generated workspace directory:

```bash
cd ./generated_sample_template_package/eval5_all_in/cpp/template
colcon build --merge-install --symlink-install --packages-select eval5_operator_cpp_pkg_interfaces eval5_operator_cpp_pkg
source install/setup.bash
```

## Run

```bash
ros2 launch eval5_operator_cpp_pkg eval5_operator_node.launch.py
```

## Lifecycle Operation

This package generates a ROS 2 Lifecycle node. After launch, configure and activate it:

```bash
ros2 lifecycle get /eval5_operator_node
ros2 lifecycle set /eval5_operator_node configure
ros2 lifecycle set /eval5_operator_node activate
```

To stop active publishers and timers:

```bash
ros2 lifecycle set /eval5_operator_node deactivate
```

## Topics

| Direction | Name | Type | QoS | Callback / Variable | Summary |
| --- | --- | --- | --- | --- | --- |
| Publish | cmd_vel | geometry_msgs/msg/Twist | Reliable, Keep Last, depth=10 | Publisher variable: cmd_vel_pub | Publish velocity command. |
| Subscribe | robot_status | std_msgs/msg/String | Reliable, Keep Last, depth=10 | Callback: robot_status_callback | Receive robot status. |

Useful commands:

```bash
ros2 topic list
ros2 topic info cmd_vel
ros2 topic echo cmd_vel
ros2 topic info robot_status
# ros2 topic pub robot_status std_msgs/msg/String '<yaml-message>'
```

## Services

| Role | Name | Type | Callback / Variable | Summary |
| --- | --- | --- | --- | --- |
| Client | set_mode | eval5_operator_cpp_pkg_interfaces/srv/SetMode | call_set_mode | Request robot operation mode. |

Useful commands:

```bash
ros2 service list
ros2 service type set_mode
```

## Actions

| Role | Name | Type | Callback Base | Summary |
| --- | --- | --- | --- | --- |
| Client | move_to_target | eval5_operator_cpp_pkg_interfaces/action/MoveToTarget | send_move_to_target_goal | Send move target goal. |

Useful commands:

```bash
ros2 action list
ros2 action info move_to_target
```

## Action Client Note

Action Client helper `send_<action_name>_goal()` は自動実行されません。
Timer、Topic、Serviceなど任意の処理から呼び出してください。

## Parameters

| Name | Type | Default | ReadOnly | Min | Max | Step | Summary |
| --- | --- | --- | --- | --- | --- | --- | --- |
| command_speed | double | 0.5 | false | - | - | - | Commanded linear speed. |

Parameter values are generated in `config/params.yaml`.

`min`, `max`, and `step` are preserved as ROS Profile / documentation information only. They are
not used for automatic runtime checks in the generated node. If the node must reject out-of-range
values, implement the required validation manually in `on_set_parameters()`.

Useful commands:

```bash
ros2 param list /eval5_operator_node
ros2 param dump /eval5_operator_node
# ros2 param set /eval5_operator_node <parameter_name> <value>
```

## Timers

| Name | Period | Callback | Description |
| --- | --- | --- | --- |
| command_timer | 1.0 sec | command_timer_callback | Send commands periodically. |

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
colcon build --merge-install --symlink-install --packages-select eval5_operator_cpp_pkg_interfaces eval5_operator_cpp_pkg
source install/setup.bash
ros2 launch eval5_operator_cpp_pkg eval5_operator_node.launch.py
ros2 lifecycle set /eval5_operator_node configure
ros2 lifecycle set /eval5_operator_node activate
```
