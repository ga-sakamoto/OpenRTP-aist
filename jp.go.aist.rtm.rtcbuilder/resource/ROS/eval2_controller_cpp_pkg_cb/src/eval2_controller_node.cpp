#include "eval2_controller_cpp_pkg/eval2_controller_node.hpp"

#include <chrono>
#include <functional>
#include <future>
#include <thread>

using CallbackReturn = rclcpp_lifecycle::node_interfaces::LifecycleNodeInterface::CallbackReturn;

namespace eval2_controller_cpp_pkg
{

Eval2ControllerNode::Eval2ControllerNode(const rclcpp::NodeOptions & options)
: rclcpp_lifecycle::LifecycleNode("eval2_controller_node", options)
{
  RCLCPP_INFO(this->get_logger(), "[Constructor] Node created.");
  declare_parameters();
}

// ============================================================
// Parameter handling
// ============================================================

void Eval2ControllerNode::declare_parameters()
{
  rcl_interfaces::msg::ParameterDescriptor desc_max_speed;
  desc_max_speed.description = "Maximum linear speed used by the controller.";
  this->declare_parameter("max_speed", 1.0, desc_max_speed);
  param_cb_handle_ = this->add_on_set_parameters_callback(std::bind(&Eval2ControllerNode::on_set_parameters, this, std::placeholders::_1));
}

rcl_interfaces::msg::SetParametersResult Eval2ControllerNode::on_set_parameters(const std::vector<rclcpp::Parameter> & params)
{
  rcl_interfaces::msg::SetParametersResult result;
  result.successful = true;

  for (const auto & param : params) {
    if (param.get_name() == "max_speed") {
      // TODO: Parameter変更時に必要な内部状態の更新処理を実装する。
      // Note: min / max / step は自動制約にしない。必要な制約はここで明示的に実装する。
      const double value = param.as_double();
      (void)value;
      // TODO: 必要に応じてParameter値をメンバ変数や処理設定へ反映する。
    }
  }

  return result;
}

// ============================================================
// Lifecycle callbacks
// ============================================================

CallbackReturn Eval2ControllerNode::on_configure(const rclcpp_lifecycle::State &)
{
  RCLCPP_INFO(this->get_logger(), "[on_configure] called.");
  // TODO: このLifecycle遷移で必要な初期化処理を実装する。
  // Topic Publisher: robot_status
  // Type: std_msgs/msg/String
  // Summary: Publish robot status text.
  robot_status_pub_ = this->create_publisher<std_msgs::msg::String>("robot_status", rclcpp::QoS(10).reliable());
  cmd_vel_sub_ = this->create_subscription<geometry_msgs::msg::Twist>("cmd_vel", rclcpp::QoS(10).reliable(), std::bind(&Eval2ControllerNode::cmd_vel_callback, this, std::placeholders::_1));
  // Timer: status_timer
  // Period: 1.0 sec
  // Callback: status_timer_callback()
  // Description: Publish status periodically.
  status_timer_ = this->create_wall_timer(std::chrono::milliseconds(1000), std::bind(&Eval2ControllerNode::status_timer_callback, this));
  status_timer_->cancel();
  return CallbackReturn::SUCCESS;
}

CallbackReturn Eval2ControllerNode::on_activate(const rclcpp_lifecycle::State &)
{
  RCLCPP_INFO(this->get_logger(), "[on_activate] called.");
  // TODO: Active状態で開始する処理を実装する。
  if (robot_status_pub_) { robot_status_pub_->on_activate(); }
  if (status_timer_) { status_timer_->reset(); }
  return CallbackReturn::SUCCESS;
}

CallbackReturn Eval2ControllerNode::on_deactivate(const rclcpp_lifecycle::State &)
{
  RCLCPP_INFO(this->get_logger(), "[on_deactivate] called.");
  // TODO: Inactive状態へ戻る際に停止する処理を実装する。
  if (robot_status_pub_) { robot_status_pub_->on_deactivate(); }
  if (status_timer_) { status_timer_->cancel(); }
  return CallbackReturn::SUCCESS;
}

CallbackReturn Eval2ControllerNode::on_cleanup(const rclcpp_lifecycle::State &)
{
  RCLCPP_INFO(this->get_logger(), "[on_cleanup] called.");
  // TODO: Cleanup時に解放するリソースを実装する。
  robot_status_pub_.reset();
  cmd_vel_sub_.reset();
  status_timer_.reset();
  return CallbackReturn::SUCCESS;
}

CallbackReturn Eval2ControllerNode::on_shutdown(const rclcpp_lifecycle::State &)
{
  RCLCPP_INFO(this->get_logger(), "[on_shutdown] called.");
  // TODO: Shutdown時に必要な終了処理を実装する。
  return CallbackReturn::SUCCESS;
}

CallbackReturn Eval2ControllerNode::on_error(const rclcpp_lifecycle::State &)
{
  RCLCPP_INFO(this->get_logger(), "[on_error] called.");
  // TODO: Error時の復旧・停止処理を実装する。
  return CallbackReturn::SUCCESS;
}

// ============================================================
// Topic callbacks
// ============================================================

void Eval2ControllerNode::cmd_vel_callback(const geometry_msgs::msg::Twist::SharedPtr msg)
{
  // Topic Subscriber callback: cmd_vel
  // Type: geometry_msgs/msg/Twist
  // Summary: Receive velocity command.
  // TODO: 受信したmsgを使って、このノードの処理を実装する。
  // Note: このcallbackは対象Topicにメッセージが届くたびに呼ばれる。
  (void)msg;
}

// ============================================================
// Timer callbacks
// ============================================================

void Eval2ControllerNode::status_timer_callback()
{
  // Timer: status_timer
  // Period: 1.0 sec
  // Callback: status_timer_callback()
  // Description: Publish status periodically.
  // TODO: 上記の周期処理を実装する。
}

}  // namespace eval2_controller_cpp_pkg
