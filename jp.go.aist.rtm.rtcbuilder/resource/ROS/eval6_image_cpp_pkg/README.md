# eval6_image_cpp_pkg

C++ image lifecycle sample node with sensor_msgs Image topics and cv_bridge dependency.

## Package Summary

- Package: `eval6_image_cpp_pkg`
- Node executable: `eval6_image_node`
- Node class: `Eval6ImageNode`
- Language: `C++ (ament_cmake)`
- License: `LGPL-3.0`


## Generated Files

- `package.xml`
- `LICENSE`
- `README.md`
- `launch/eval6_image_node.launch.py`
- `config/params.yaml`
- `CMakeLists.txt`
- `include/eval6_image_cpp_pkg/eval6_image_node.hpp`
- `src/eval6_image_node.cpp`
- `src/main.cpp`

## Build

From the generated workspace directory:

```bash
cd ./generated_sample_template_package/eval6_image_cv_bridge/cpp/template
colcon build --merge-install --symlink-install --packages-select eval6_image_cpp_pkg
source install/setup.bash
```

## Run

```bash
ros2 launch eval6_image_cpp_pkg eval6_image_node.launch.py
```

## Lifecycle Operation

This package generates a ROS 2 Lifecycle node. After launch, configure and activate it:

```bash
ros2 lifecycle get /eval6_image_node
ros2 lifecycle set /eval6_image_node configure
ros2 lifecycle set /eval6_image_node activate
```

To stop active publishers and timers:

```bash
ros2 lifecycle set /eval6_image_node deactivate
```

## Topics

| Direction | Name | Type | QoS | Callback / Variable | Summary |
| --- | --- | --- | --- | --- | --- |
| Subscribe | image_raw | sensor_msgs/msg/Image | Reliable, Keep Last, depth=10 | Callback: image_callback | Receive raw image input. |
| Publish | image_debug | sensor_msgs/msg/Image | Reliable, Keep Last, depth=10 | Publisher variable: image_debug_pub | Publish debug image output. |

Useful commands:

```bash
ros2 topic list
ros2 topic info image_raw
# ros2 topic pub image_raw sensor_msgs/msg/Image '<yaml-message>'
ros2 topic info image_debug
ros2 topic echo image_debug
```

## Services

None.

## Actions

None.

## Parameters

| Name | Type | Default | Min | Max | Step | Summary |
| --- | --- | --- | --- | --- | --- | --- |
| enable_processing | bool | true | - | - | - | Enable image processing and debug publish. |
| debug_scale | double | 1.0 | 0.1 | 4.0 | 0.1 | Scale factor for debug image processing. |

Parameter values are generated in `config/params.yaml`.

`min`, `max`, and `step` are preserved as ROS Profile / documentation information only. They are
not used for automatic runtime checks in the generated node. If the node must reject out-of-range
values, implement the required validation manually in `on_set_parameters()`.

Useful commands:

```bash
ros2 param list /eval6_image_node
ros2 param dump /eval6_image_node
# ros2 param set /eval6_image_node <parameter_name> <value>
```

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
colcon build --merge-install --symlink-install --packages-select eval6_image_cpp_pkg
source install/setup.bash
ros2 launch eval6_image_cpp_pkg eval6_image_node.launch.py
ros2 lifecycle set /eval6_image_node configure
ros2 lifecycle set /eval6_image_node activate
```
