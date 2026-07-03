#include "eval5_robot_cpp_pkg/eval5_robot_node.hpp"

#include <chrono>
#include <functional>
#include <future>
#include <thread>

using CallbackReturn = rclcpp_lifecycle::node_interfaces::LifecycleNodeInterface::CallbackReturn;

namespace eval5_robot_cpp_pkg
{

Eval5RobotNode::Eval5RobotNode(const rclcpp::NodeOptions & options)
: rclcpp_lifecycle::LifecycleNode("eval5_robot_node", options)
{
  RCLCPP_INFO(this->get_logger(), "[Constructor] Node created.");
  declare_parameters();
}

// ============================================================
// Parameter handling
// ============================================================

void Eval5RobotNode::declare_parameters()
{
  rcl_interfaces::msg::ParameterDescriptor desc_max_speed;
  desc_max_speed.description = "Maximum linear speed.";
  this->declare_parameter("max_speed", 1.0, desc_max_speed);
  param_cb_handle_ = this->add_on_set_parameters_callback(std::bind(&Eval5RobotNode::on_set_parameters, this, std::placeholders::_1));
}

rcl_interfaces::msg::SetParametersResult Eval5RobotNode::on_set_parameters(const std::vector<rclcpp::Parameter> & params)
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

CallbackReturn Eval5RobotNode::on_configure(const rclcpp_lifecycle::State &)
{
  RCLCPP_INFO(this->get_logger(), "[on_configure] called.");
  // TODO: このLifecycle遷移で必要な初期化処理を実装する。
  cmd_vel_sub_ = this->create_subscription<geometry_msgs::msg::Twist>("cmd_vel", rclcpp::QoS(10).reliable(), std::bind(&Eval5RobotNode::cmd_vel_callback, this, std::placeholders::_1));
  // Topic Publisher: robot_status
  // Type: std_msgs/msg/String
  // Summary: Publish robot status.
  robot_status_pub_ = this->create_publisher<std_msgs::msg::String>("robot_status", rclcpp::QoS(10).reliable());
  set_mode_srv_ = this->create_service<eval5_robot_cpp_pkg_interfaces::srv::SetMode>("set_mode", std::bind(&Eval5RobotNode::set_mode_callback, this, std::placeholders::_1, std::placeholders::_2));
  move_to_target_server_ = rclcpp_action::create_server<MoveToTarget>(this, "move_to_target", std::bind(&Eval5RobotNode::handle_goal_move_to_target, this, std::placeholders::_1, std::placeholders::_2), std::bind(&Eval5RobotNode::handle_cancel_move_to_target, this, std::placeholders::_1), std::bind(&Eval5RobotNode::handle_accepted_move_to_target, this, std::placeholders::_1));
  // Timer: status_timer
  // Period: 1.0 sec
  // Callback: status_timer_callback()
  // Description: Publish robot status periodically.
  timer_0_ = this->create_wall_timer(std::chrono::milliseconds(1000), std::bind(&Eval5RobotNode::status_timer_callback, this));
  timer_0_->cancel();
  return CallbackReturn::SUCCESS;
}

CallbackReturn Eval5RobotNode::on_activate(const rclcpp_lifecycle::State &)
{
  RCLCPP_INFO(this->get_logger(), "[on_activate] called.");
  // TODO: Active状態で開始する処理を実装する。
  if (robot_status_pub_) { robot_status_pub_->on_activate(); }
  if (timer_0_) { timer_0_->reset(); }
  return CallbackReturn::SUCCESS;
}

CallbackReturn Eval5RobotNode::on_deactivate(const rclcpp_lifecycle::State &)
{
  RCLCPP_INFO(this->get_logger(), "[on_deactivate] called.");
  // TODO: Inactive状態へ戻る際に停止する処理を実装する。
  if (robot_status_pub_) { robot_status_pub_->on_deactivate(); }
  if (timer_0_) { timer_0_->cancel(); }
  return CallbackReturn::SUCCESS;
}

// 任意: on_cleanup. 使う場合はhpp側の宣言も有効化する
// CallbackReturn Eval5RobotNode::on_cleanup(const rclcpp_lifecycle::State &)
// {
//   RCLCPP_INFO(this->get_logger(), "[on_cleanup] called.");
//   // TODO: Cleanup時に解放するリソースを実装する。
//   cmd_vel_sub_.reset();
//   robot_status_pub_.reset();
//   set_mode_srv_.reset();
//   move_to_target_server_.reset();
//   timer_0_.reset();
//   return CallbackReturn::SUCCESS;
// }

// 任意: on_shutdown. 使う場合はhpp側の宣言も有効化する
// CallbackReturn Eval5RobotNode::on_shutdown(const rclcpp_lifecycle::State &)
// {
//   RCLCPP_INFO(this->get_logger(), "[on_shutdown] called.");
//   // TODO: Shutdown時に必要な終了処理を実装する。
//   return CallbackReturn::SUCCESS;
// }

// 任意: on_error. 使う場合はhpp側の宣言も有効化する
// CallbackReturn Eval5RobotNode::on_error(const rclcpp_lifecycle::State &)
// {
//   RCLCPP_INFO(this->get_logger(), "[on_error] called.");
//   // TODO: Error時の復旧・停止処理を実装する。
//   return CallbackReturn::SUCCESS;
// }

// ============================================================
// Topic callbacks
// ============================================================

void Eval5RobotNode::cmd_vel_callback(const geometry_msgs::msg::Twist::SharedPtr msg)
{
  // Topic Subscriber callback: cmd_vel
  // Type: geometry_msgs/msg/Twist
  // Summary: Receive velocity command.
  // TODO: 受信したmsgを使って、このノードの処理を実装する。
  // Note: このcallbackは対象Topicにメッセージが届くたびに呼ばれる。
  (void)msg;
}

// ============================================================
// Service callbacks and clients
// ============================================================

void Eval5RobotNode::set_mode_callback(const std::shared_ptr<eval5_robot_cpp_pkg_interfaces::srv::SetMode::Request> request, std::shared_ptr<eval5_robot_cpp_pkg_interfaces::srv::SetMode::Response> response)
{
  // Service Server callback: set_mode
  // Type: eval5_robot_cpp_pkg_interfaces/srv/SetMode
  // Summary: Set robot operation mode.
  // TODO: requestを読み取り、Serviceで実行する処理を実装する。
  // TODO: responseに返す値を設定する。
  (void)request;
  (void)response;
}

// ============================================================
// Action callbacks and clients
// ============================================================

rclcpp_action::GoalResponse Eval5RobotNode::handle_goal_move_to_target(const rclcpp_action::GoalUUID & uuid, std::shared_ptr<const MoveToTarget::Goal> goal)
{
  // Action Server goal callback: move_to_target
  // Type: eval5_robot_cpp_pkg_interfaces/action/MoveToTarget
  // Summary: Move robot to target pose.
  (void)uuid;
  (void)goal;
  return rclcpp_action::GoalResponse::ACCEPT_AND_EXECUTE;
}

rclcpp_action::CancelResponse Eval5RobotNode::handle_cancel_move_to_target(const std::shared_ptr<GoalHandleMoveToTarget> goal_handle)
{
  // Action Server cancel callback: move_to_target
  // Type: eval5_robot_cpp_pkg_interfaces/action/MoveToTarget
  // Summary: Move robot to target pose.
  (void)goal_handle;
  return rclcpp_action::CancelResponse::ACCEPT;
}

void Eval5RobotNode::handle_accepted_move_to_target(const std::shared_ptr<GoalHandleMoveToTarget> goal_handle)
{
  // Action Server accepted callback: move_to_target
  // Type: eval5_robot_cpp_pkg_interfaces/action/MoveToTarget
  // Summary: Move robot to target pose.
  std::thread{std::bind(&Eval5RobotNode::move_to_target, this, std::placeholders::_1), goal_handle}.detach();
}

void Eval5RobotNode::move_to_target(const std::shared_ptr<GoalHandleMoveToTarget> goal_handle)
{
  // Action Server execute callback: move_to_target
  // Type: eval5_robot_cpp_pkg_interfaces/action/MoveToTarget
  // Summary: Move robot to target pose.
  const auto goal = goal_handle->get_goal();
  auto result = std::make_shared<MoveToTarget::Result>();

  // TODO: Goalを読み取り、Actionの実行処理を実装する。
  // TODO: 必要に応じてFeedbackとResultを設定する。
  (void)goal;

  goal_handle->succeed(result);
}

// ============================================================
// Timer callbacks
// ============================================================

void Eval5RobotNode::status_timer_callback()
{
  // Timer: status_timer
  // Period: 1.0 sec
  // Callback: status_timer_callback()
  // Description: Publish robot status periodically.
  // TODO: 上記の周期処理を実装する。
}

}  // namespace eval5_robot_cpp_pkg
