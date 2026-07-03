# eval1_minimal_cpp_pkg

Minimal C++ Lifecycle Node sample.

## Package Summary

- Package: `eval1_minimal_cpp_pkg`
- Node executable: `eval1_minimal_node`
- Node class: `Eval1MinimalNode`
- Language: `C++`
- License: `Apache-2.0`


## Generated Files

- `package.xml`
- `LICENSE`
- `README.md`
- `launch/eval1_minimal_node.launch.py`
- `config/params.yaml`
- `CMakeLists.txt`
- `include/eval1_minimal_cpp_pkg/eval1_minimal_node.hpp`
- `src/eval1_minimal_node.cpp`
- `src/main.cpp`

## Build

From the generated workspace directory:

```bash
cd ./generated_sample_template_package/eval1_minimal_cpp_pkg/cpp/template
colcon build --merge-install --symlink-install --packages-select eval1_minimal_cpp_pkg
source install/setup.bash
```

## Run

```bash
ros2 launch eval1_minimal_cpp_pkg eval1_minimal_node.launch.py
```

## Lifecycle Operation

This package generates a ROS 2 Lifecycle node. After launch, configure and activate it:

```bash
ros2 lifecycle get /eval1_minimal_node
ros2 lifecycle set /eval1_minimal_node configure
ros2 lifecycle set /eval1_minimal_node activate
```

To stop active publishers and timers:

```bash
ros2 lifecycle set /eval1_minimal_node deactivate
```

## Topics

None.

## Services

None.

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
colcon build --merge-install --symlink-install --packages-select eval1_minimal_cpp_pkg
source install/setup.bash
ros2 launch eval1_minimal_cpp_pkg eval1_minimal_node.launch.py
ros2 lifecycle set /eval1_minimal_node configure
ros2 lifecycle set /eval1_minimal_node activate
```
