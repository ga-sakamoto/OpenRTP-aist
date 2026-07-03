#include "eval2_cmd_source_cpp_pkg/eval2_cmd_source_node.hpp"

#include <chrono>
#include <functional>
#include <future>
#include <thread>

using CallbackReturn = rclcpp_lifecycle::node_interfaces::LifecycleNodeInterface::CallbackReturn;

namespace eval2_cmd_source_cpp_pkg
{

Eval2CmdSourceNode::Eval2CmdSourceNode(const rclcpp::NodeOptions & options)
: rclcpp_lifecycle::LifecycleNode("eval2_cmd_source_node", options)
{
  RCLCPP_INFO(this->get_logger(), "[Constructor] Node created.");
}

// ============================================================
// Lifecycle callbacks
// ============================================================

CallbackReturn Eval2CmdSourceNode::on_configure(const rclcpp_lifecycle::State &)
{
  RCLCPP_INFO(this->get_logger(), "[on_configure] called.");
  // TODO: このLifecycle遷移で必要な初期化処理を実装する。
  // Topic Publisher: cmd_vel
  // Type: geometry_msgs/msg/Twist
  // Summary: Publish velocity command.
  cmd_vel_pub_ = this->create_publisher<geometry_msgs::msg::Twist>("cmd_vel", rclcpp::QoS(10).reliable());
  robot_status_sub_ = this->create_subscription<std_msgs::msg::String>("robot_status", rclcpp::QoS(10).reliable(), std::bind(&Eval2CmdSourceNode::robot_status_callback, this, std::placeholders::_1));
  // Timer: cmd_timer
  // Period: 1.0 sec
  // Callback: cmd_timer_callback()
  // Description: Publish velocity command periodically.
  cmd_timer_ = this->create_wall_timer(std::chrono::milliseconds(1000), std::bind(&Eval2CmdSourceNode::cmd_timer_callback, this));
  cmd_timer_->cancel();
  return CallbackReturn::SUCCESS;
}

CallbackReturn Eval2CmdSourceNode::on_activate(const rclcpp_lifecycle::State &)
{
  RCLCPP_INFO(this->get_logger(), "[on_activate] called.");
  // TODO: Active状態で開始する処理を実装する。
  if (cmd_vel_pub_) { cmd_vel_pub_->on_activate(); }
  if (cmd_timer_) { cmd_timer_->reset(); }
  return CallbackReturn::SUCCESS;
}

CallbackReturn Eval2CmdSourceNode::on_deactivate(const rclcpp_lifecycle::State &)
{
  RCLCPP_INFO(this->get_logger(), "[on_deactivate] called.");
  // TODO: Inactive状態へ戻る際に停止する処理を実装する。
  if (cmd_vel_pub_) { cmd_vel_pub_->on_deactivate(); }
  if (cmd_timer_) { cmd_timer_->cancel(); }
  return CallbackReturn::SUCCESS;
}

// CallbackReturn Eval2CmdSourceNode::on_cleanup(const rclcpp_lifecycle::State &)
// {
//   RCLCPP_INFO(this->get_logger(), "[on_cleanup] called.");
//   // TODO: Cleanup時に解放するリソースを実装する。
//   cmd_vel_pub_.reset();
//   robot_status_sub_.reset();
//   cmd_timer_.reset();
//   return CallbackReturn::SUCCESS;
// }

// CallbackReturn Eval2CmdSourceNode::on_shutdown(const rclcpp_lifecycle::State &)
// {
//   RCLCPP_INFO(this->get_logger(), "[on_shutdown] called.");
//   // TODO: Shutdown時に必要な終了処理を実装する。
//   return CallbackReturn::SUCCESS;
// }

// CallbackReturn Eval2CmdSourceNode::on_error(const rclcpp_lifecycle::State &)
// {
//   RCLCPP_INFO(this->get_logger(), "[on_error] called.");
//   // TODO: Error時の復旧・停止処理を実装する。
//   return CallbackReturn::SUCCESS;
// }

// ============================================================
// Topic callbacks
// ============================================================

void Eval2CmdSourceNode::robot_status_callback(const std_msgs::msg::String::SharedPtr msg)
{
  // Topic Subscriber callback: robot_status
  // Type: std_msgs/msg/String
  // Summary: Receive robot status text.
  // TODO: 受信したmsgを使って、このノードの処理を実装する。
  // Note: このcallbackは対象Topicにメッセージが届くたびに呼ばれる。
  (void)msg;
}

// ============================================================
// Timer callbacks
// ============================================================

void Eval2CmdSourceNode::cmd_timer_callback()
{
  // Timer: cmd_timer
  // Period: 1.0 sec
  // Callback: cmd_timer_callback()
  // Description: Publish velocity command periodically.
  // TODO: 上記の周期処理を実装する。
}

}  // namespace eval2_cmd_source_cpp_pkg
