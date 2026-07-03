#ifndef EVAL6_IMAGE_CPP_PKG__EVAL6_IMAGE_NODE_HPP_
#define EVAL6_IMAGE_CPP_PKG__EVAL6_IMAGE_NODE_HPP_

#include "rcl_interfaces/msg/floating_point_range.hpp"
#include "rcl_interfaces/msg/integer_range.hpp"
#include "rcl_interfaces/msg/parameter_descriptor.hpp"
#include "rcl_interfaces/msg/set_parameters_result.hpp"
#include "rclcpp/rclcpp.hpp"
#include "rclcpp_lifecycle/lifecycle_node.hpp"
#include "rclcpp_lifecycle/lifecycle_publisher.hpp"
#include "sensor_msgs/msg/image.hpp"
#include <future>
#include <memory>
#include <string>
#include <vector>

namespace eval6_image_cpp_pkg
{

class Eval6ImageNode : public rclcpp_lifecycle::LifecycleNode
{
public:

  explicit Eval6ImageNode(const rclcpp::NodeOptions & options = rclcpp::NodeOptions());
  ~Eval6ImageNode() override = default;

  // ============================================================
  // Lifecycle callbacks
  // ============================================================

  rclcpp_lifecycle::node_interfaces::LifecycleNodeInterface::CallbackReturn
  on_configure(const rclcpp_lifecycle::State & state) override;

  rclcpp_lifecycle::node_interfaces::LifecycleNodeInterface::CallbackReturn
  on_activate(const rclcpp_lifecycle::State & state) override;

  rclcpp_lifecycle::node_interfaces::LifecycleNodeInterface::CallbackReturn
  on_deactivate(const rclcpp_lifecycle::State & state) override;

  // 任意: on_cleanup. 使う場合は宣言と定義のコメントアウトを外す
  //   rclcpp_lifecycle::node_interfaces::LifecycleNodeInterface::CallbackReturn
  //   on_cleanup(const rclcpp_lifecycle::State & state) override;

  // 任意: on_shutdown. 使う場合は宣言と定義のコメントアウトを外す
  //   rclcpp_lifecycle::node_interfaces::LifecycleNodeInterface::CallbackReturn
  //   on_shutdown(const rclcpp_lifecycle::State & state) override;

  // 任意: on_error. 使う場合は宣言と定義のコメントアウトを外す
  //   rclcpp_lifecycle::node_interfaces::LifecycleNodeInterface::CallbackReturn
  //   on_error(const rclcpp_lifecycle::State & state) override;

private:
  // ============================================================
  // Parameter handling
  // ============================================================

  void declare_parameters();
  rclcpp::node_interfaces::OnSetParametersCallbackHandle::SharedPtr param_cb_handle_;
  rcl_interfaces::msg::SetParametersResult on_set_parameters(const std::vector<rclcpp::Parameter> & params);

  // ============================================================
  // Topic handles and callbacks
  // ============================================================

  rclcpp::Subscription<sensor_msgs::msg::Image>::SharedPtr image_raw_sub_;
  void image_callback(const sensor_msgs::msg::Image::SharedPtr msg);
  rclcpp_lifecycle::LifecyclePublisher<sensor_msgs::msg::Image>::SharedPtr image_debug_pub_;

};

}  // namespace eval6_image_cpp_pkg

#endif  // EVAL6_IMAGE_CPP_PKG__EVAL6_IMAGE_NODE_HPP_
