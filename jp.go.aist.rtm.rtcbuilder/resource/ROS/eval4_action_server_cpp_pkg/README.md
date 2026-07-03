# eval4_action_server_cpp_pkg

C++ action server node using example_interfaces Fibonacci action.

## Package Summary

- Package: `eval4_action_server_cpp_pkg`
- Node executable: `eval4_action_server_node`
- Node class: `Eval4ActionServerNode`
- Language: `C++`
- License: `Proprietary`


## Generated Files

- `package.xml`
- `LICENSE`
- `README.md`
- `launch/eval4_action_server_node.launch.py`
- `config/params.yaml`
- `CMakeLists.txt`
- `include/eval4_action_server_cpp_pkg/eval4_action_server_node.hpp`
- `src/eval4_action_server_node.cpp`
- `src/main.cpp`

## Build

From the generated workspace directory:

```bash
cd ./generated_sample_template_package/eval4_action_server_cpp_pkg/cpp/template
colcon build --merge-install --symlink-install --packages-select eval4_action_server_cpp_pkg
source install/setup.bash
```

## Run

```bash
ros2 launch eval4_action_server_cpp_pkg eval4_action_server_node.launch.py
```

## Lifecycle Operation

This package generates a ROS 2 Lifecycle node. After launch, configure and activate it:

```bash
ros2 lifecycle get /eval4_action_server_node
ros2 lifecycle set /eval4_action_server_node configure
ros2 lifecycle set /eval4_action_server_node activate
```

To stop active publishers and timers:

```bash
ros2 lifecycle set /eval4_action_server_node deactivate
```

## Topics

None.

## Services

None.

## Actions

| Role | Name | Type | Callback Base | Summary |
| --- | --- | --- | --- | --- |
| Server | fibonacci | example_interfaces/action/Fibonacci | fibonacci | Execute Fibonacci action goals. |

Useful commands:

```bash
ros2 action list
ros2 action info fibonacci
# ros2 action send_goal fibonacci example_interfaces/action/Fibonacci '<yaml-goal>' --feedback
```

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
colcon build --merge-install --symlink-install --packages-select eval4_action_server_cpp_pkg
source install/setup.bash
ros2 launch eval4_action_server_cpp_pkg eval4_action_server_node.launch.py
ros2 lifecycle set /eval4_action_server_node configure
ros2 lifecycle set /eval4_action_server_node activate
```
