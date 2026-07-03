#include "eval5_operator_cpp_pkg/eval5_operator_node.hpp"

#include <chrono>
#include <functional>
#include <future>
#include <thread>

using CallbackReturn = rclcpp_lifecycle::node_interfaces::LifecycleNodeInterface::CallbackReturn;

namespace eval5_operator_cpp_pkg
{

Eval5OperatorNode::Eval5OperatorNode(const rclcpp::NodeOptions & options)
: rclcpp_lifecycle::LifecycleNode("eval5_operator_node", options)
{
  RCLCPP_INFO(this->get_logger(), "[Constructor] Node created.");
  declare_parameters();
}

// ============================================================
// Parameter handling
// ============================================================

void Eval5OperatorNode::declare_parameters()
{
  rcl_interfaces::msg::ParameterDescriptor desc_command_speed;
  desc_command_speed.description = "Commanded linear speed.";
  this->declare_parameter("command_speed", 0.5, desc_command_speed);
  param_cb_handle_ = this->add_on_set_parameters_callback(std::bind(&Eval5OperatorNode::on_set_parameters, this, std::placeholders::_1));
}

rcl_interfaces::msg::SetParametersResult Eval5OperatorNode::on_set_parameters(const std::vector<rclcpp::Parameter> & params)
{
  rcl_interfaces::msg::SetParametersResult result;
  result.successful = true;

  for (const auto & param : params) {
    if (param.get_name() == "command_speed") {
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

CallbackReturn Eval5OperatorNode::on_configure(const rclcpp_lifecycle::State &)
{
  RCLCPP_INFO(this->get_logger(), "[on_configure] called.");
  // TODO: このLifecycle遷移で必要な初期化処理を実装する。
  // Topic Publisher: cmd_vel
  // Type: geometry_msgs/msg/Twist
  // Summary: Publish velocity command.
  cmd_vel_pub_ = this->create_publisher<geometry_msgs::msg::Twist>("cmd_vel", rclcpp::QoS(10).reliable());
  robot_status_sub_ = this->create_subscription<std_msgs::msg::String>("robot_status", rclcpp::QoS(10).reliable(), std::bind(&Eval5OperatorNode::robot_status_callback, this, std::placeholders::_1));
  call_set_mode_ = this->create_client<eval5_operator_cpp_pkg_interfaces::srv::SetMode>("set_mode");
  move_to_target_client_ = rclcpp_action::create_client<MoveToTarget>(this, "move_to_target");
  // Timer: command_timer
  // Period: 1.0 sec
  // Callback: command_timer_callback()
  // Description: Send commands periodically.
  timer_0_ = this->create_wall_timer(std::chrono::milliseconds(1000), std::bind(&Eval5OperatorNode::command_timer_callback, this));
  timer_0_->cancel();
  return CallbackReturn::SUCCESS;
}

CallbackReturn Eval5OperatorNode::on_activate(const rclcpp_lifecycle::State &)
{
  RCLCPP_INFO(this->get_logger(), "[on_activate] called.");
  // TODO: Active状態で開始する処理を実装する。
  if (cmd_vel_pub_) { cmd_vel_pub_->on_activate(); }
  if (timer_0_) { timer_0_->reset(); }
  return CallbackReturn::SUCCESS;
}

CallbackReturn Eval5OperatorNode::on_deactivate(const rclcpp_lifecycle::State &)
{
  RCLCPP_INFO(this->get_logger(), "[on_deactivate] called.");
  // TODO: Inactive状態へ戻る際に停止する処理を実装する。
  if (cmd_vel_pub_) { cmd_vel_pub_->on_deactivate(); }
  if (timer_0_) { timer_0_->cancel(); }
  return CallbackReturn::SUCCESS;
}

// 任意: on_cleanup. 使う場合はhpp側の宣言も有効化する
// CallbackReturn Eval5OperatorNode::on_cleanup(const rclcpp_lifecycle::State &)
// {
//   RCLCPP_INFO(this->get_logger(), "[on_cleanup] called.");
//   // TODO: Cleanup時に解放するリソースを実装する。
//   cmd_vel_pub_.reset();
//   robot_status_sub_.reset();
//   call_set_mode_.reset();
//   move_to_target_client_.reset();
//   timer_0_.reset();
//   return CallbackReturn::SUCCESS;
// }

// 任意: on_shutdown. 使う場合はhpp側の宣言も有効化する
// CallbackReturn Eval5OperatorNode::on_shutdown(const rclcpp_lifecycle::State &)
// {
//   RCLCPP_INFO(this->get_logger(), "[on_shutdown] called.");
//   // TODO: Shutdown時に必要な終了処理を実装する。
//   return CallbackReturn::SUCCESS;
// }

// 任意: on_error. 使う場合はhpp側の宣言も有効化する
// CallbackReturn Eval5OperatorNode::on_error(const rclcpp_lifecycle::State &)
// {
//   RCLCPP_INFO(this->get_logger(), "[on_error] called.");
//   // TODO: Error時の復旧・停止処理を実装する。
//   return CallbackReturn::SUCCESS;
// }

// ============================================================
// Topic callbacks
// ============================================================

void Eval5OperatorNode::robot_status_callback(const std_msgs::msg::String::SharedPtr msg)
{
  // Topic Subscriber callback: robot_status
  // Type: std_msgs/msg/String
  // Summary: Receive robot status.
  // TODO: 受信したmsgを使って、このノードの処理を実装する。
  // Note: このcallbackは対象Topicにメッセージが届くたびに呼ばれる。
  (void)msg;
}

// ============================================================
// Service callbacks and clients
// ============================================================

void Eval5OperatorNode::call_set_mode_service()
{
  // Service Client call: set_mode
  // Type: eval5_operator_cpp_pkg_interfaces/srv/SetMode
  // Summary: Request robot operation mode.
  // Service Client helper: requestを作成してServerへ非同期送信する。
  if (!call_set_mode_) {
    RCLCPP_WARN(this->get_logger(), "Service client is not configured.");
    return;
  }
  auto request = std::make_shared<eval5_operator_cpp_pkg_interfaces::srv::SetMode::Request>();
  // TODO: このService呼び出し関数を呼び出すタイミングを実装する。
  // TODO: 使用するService型に合わせてrequestフィールドを設定する。
  // Note: request設定後、async_send_request()でService Serverへ送信する。
  auto future = call_set_mode_->async_send_request(request);
  (void)future;
}

// ============================================================
// Action callbacks and clients
// ============================================================

void Eval5OperatorNode::send_move_to_target_goal()
{
  // Action Client goal sender: move_to_target
  // Type: eval5_operator_cpp_pkg_interfaces/action/MoveToTarget
  // Summary: Send move target goal.
  // Action Client helper: Goalを作成してAction Serverへ送信する。
  if (!move_to_target_client_) {
    RCLCPP_WARN(this->get_logger(), "Action client is not configured.");
    return;
  }
  // TODO: このGoal送信関数を呼び出すタイミングを実装する。
  // Note: Action型ごとにGoalフィールドが異なるため、生成器では具体値を設定しない。
  // TODO: Goalを作成し、response / feedback / result callbackを設定して送信する。
  RCLCPP_WARN(this->get_logger(), "Goal send skeleton is disabled. Implement goal send code before use.");
  return;
}

void Eval5OperatorNode::send_move_to_target_goal_response(rclcpp_action::ClientGoalHandle<MoveToTarget>::SharedPtr goal_handle)
{
  // Action Client goal response callback: move_to_target
  // Type: eval5_operator_cpp_pkg_interfaces/action/MoveToTarget
  // Summary: Send move target goal.
  if (!goal_handle) {
    RCLCPP_ERROR(this->get_logger(), "Goal rejected");
    return;
  }
  RCLCPP_INFO(this->get_logger(), "Goal accepted");
}

void Eval5OperatorNode::send_move_to_target_goal_feedback(rclcpp_action::ClientGoalHandle<MoveToTarget>::SharedPtr, const std::shared_ptr<const MoveToTarget::Feedback> feedback)
{
  // Action Client feedback callback: move_to_target
  // Type: eval5_operator_cpp_pkg_interfaces/action/MoveToTarget
  // Summary: Send move target goal.
  // TODO: 必要に応じてFeedbackを使った処理を実装する。
  (void)feedback;
}

void Eval5OperatorNode::send_move_to_target_goal_result(const rclcpp_action::ClientGoalHandle<MoveToTarget>::WrappedResult & result)
{
  // Action Client result callback: move_to_target
  // Type: eval5_operator_cpp_pkg_interfaces/action/MoveToTarget
  // Summary: Send move target goal.
  // TODO: 必要に応じてResultを使った処理を実装する。
  (void)result;
}

// ============================================================
// Timer callbacks
// ============================================================

void Eval5OperatorNode::command_timer_callback()
{
  // Timer: command_timer
  // Period: 1.0 sec
  // Callback: command_timer_callback()
  // Description: Send commands periodically.
  // TODO: 上記の周期処理を実装する。
}

}  // namespace eval5_operator_cpp_pkg
