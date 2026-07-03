# eval4_action_client_cpp_pkg

C++ action client node that sends Fibonacci goals periodically.

## Package Summary

- Package: `eval4_action_client_cpp_pkg`
- Node executable: `eval4_action_client_node`
- Node class: `Eval4ActionClientNode`
- Language: `C++`
- License: `Proprietary`


## Generated Files

- `package.xml`
- `LICENSE`
- `README.md`
- `launch/eval4_action_client_node.launch.py`
- `config/params.yaml`
- `CMakeLists.txt`
- `include/eval4_action_client_cpp_pkg/eval4_action_client_node.hpp`
- `src/eval4_action_client_node.cpp`
- `src/main.cpp`

## Build

From the generated workspace directory:

```bash
cd ./generated_sample_template_package/eval4_action_client_cpp_pkg/cpp/template
colcon build --merge-install --symlink-install --packages-select eval4_action_client_cpp_pkg
source install/setup.bash
```

## Run

```bash
ros2 launch eval4_action_client_cpp_pkg eval4_action_client_node.launch.py
```

## Lifecycle Operation

This package generates a ROS 2 Lifecycle node. After launch, configure and activate it:

```bash
ros2 lifecycle get /eval4_action_client_node
ros2 lifecycle set /eval4_action_client_node configure
ros2 lifecycle set /eval4_action_client_node activate
```

To stop active publishers and timers:

```bash
ros2 lifecycle set /eval4_action_client_node deactivate
```

## Topics

None.

## Services

None.

## Actions

| Role | Name | Type | Callback Base | Summary |
| --- | --- | --- | --- | --- |
| Client | fibonacci | example_interfaces/action/Fibonacci | send_fibonacci_goal | Send Fibonacci goal for evaluation. |

Useful commands:

```bash
ros2 action list
ros2 action info fibonacci
```

## Action Client Note

Action Client helper `send_<action_name>_goal()` は自動実行されません。
Timer、Topic、Serviceなど任意の処理から呼び出してください。

## Parameters

None.

This package does not define user parameters.

## Timers

| Name | Period | Callback | Description |
| --- | --- | --- | --- |
| action_goal_timer | 3.0 sec | action_goal_timer_callback | Send action goal periodically. |

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
colcon build --merge-install --symlink-install --packages-select eval4_action_client_cpp_pkg
source install/setup.bash
ros2 launch eval4_action_client_cpp_pkg eval4_action_client_node.launch.py
ros2 lifecycle set /eval4_action_client_node configure
ros2 lifecycle set /eval4_action_client_node activate
```
