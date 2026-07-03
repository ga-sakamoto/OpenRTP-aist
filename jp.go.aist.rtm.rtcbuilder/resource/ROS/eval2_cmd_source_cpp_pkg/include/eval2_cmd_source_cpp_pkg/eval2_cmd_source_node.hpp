#ifndef EVAL2_CMD_SOURCE_CPP_PKG__EVAL2_CMD_SOURCE_NODE_HPP_
#define EVAL2_CMD_SOURCE_CPP_PKG__EVAL2_CMD_SOURCE_NODE_HPP_

#include "geometry_msgs/msg/twist.hpp"
#include "rclcpp/rclcpp.hpp"
#include "rclcpp_lifecycle/lifecycle_node.hpp"
#include "rclcpp_lifecycle/lifecycle_publisher.hpp"
#include "std_msgs/msg/string.hpp"
#include <future>
#include <memory>
#include <string>
#include <vector>

namespace eval2_cmd_source_cpp_pkg
{

class Eval2CmdSourceNode : public rclcpp_lifecycle::LifecycleNode
{
public:

  explicit Eval2CmdSourceNode(const rclcpp::NodeOptions & options = rclcpp::NodeOptions());
  ~Eval2CmdSourceNode() override = default;

  // ============================================================
  // Lifecycle callbacks
  // ============================================================

  rclcpp_lifecycle::node_interfaces::LifecycleNodeInterface::CallbackReturn
  on_configure(const rclcpp_lifecycle::State & state) override;

  rclcpp_lifecycle::node_interfaces::LifecycleNodeInterface::CallbackReturn
  on_activate(const rclcpp_lifecycle::State & state) override;

  rclcpp_lifecycle::node_interfaces::LifecycleNodeInterface::CallbackReturn
  on_deactivate(const rclcpp_lifecycle::State & state) override;

  //   rclcpp_lifecycle::node_interfaces::LifecycleNodeInterface::CallbackReturn
  //   on_cleanup(const rclcpp_lifecycle::State & state) override;

  //   rclcpp_lifecycle::node_interfaces::LifecycleNodeInterface::CallbackReturn
  //   on_shutdown(const rclcpp_lifecycle::State & state) override;

  //   rclcpp_lifecycle::node_interfaces::LifecycleNodeInterface::CallbackReturn
  //   on_error(const rclcpp_lifecycle::State & state) override;

private:
  // ============================================================
  // Topic handles and callbacks
  // ============================================================

  rclcpp_lifecycle::LifecyclePublisher<geometry_msgs::msg::Twist>::SharedPtr cmd_vel_pub_;
  rclcpp::Subscription<std_msgs::msg::String>::SharedPtr robot_status_sub_;
  void robot_status_callback(const std_msgs::msg::String::SharedPtr msg);

  // ============================================================
  // Timer handles and callbacks
  // ============================================================

  rclcpp::TimerBase::SharedPtr cmd_timer_;
  void cmd_timer_callback();
};

}  // namespace eval2_cmd_source_cpp_pkg

#endif  // EVAL2_CMD_SOURCE_CPP_PKG__EVAL2_CMD_SOURCE_NODE_HPP_
