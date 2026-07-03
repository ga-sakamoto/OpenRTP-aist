#include "eval4_action_client_cpp_pkg/eval4_action_client_node.hpp"

#include <chrono>
#include <functional>
#include <future>
#include <thread>

using CallbackReturn = rclcpp_lifecycle::node_interfaces::LifecycleNodeInterface::CallbackReturn;

namespace eval4_action_client_cpp_pkg
{

Eval4ActionClientNode::Eval4ActionClientNode(const rclcpp::NodeOptions & options)
: rclcpp_lifecycle::LifecycleNode("eval4_action_client_node", options)
{
  RCLCPP_INFO(this->get_logger(), "[Constructor] Node created.");
}

// ============================================================
// Lifecycle callbacks
// ============================================================

CallbackReturn Eval4ActionClientNode::on_configure(const rclcpp_lifecycle::State &)
{
  RCLCPP_INFO(this->get_logger(), "[on_configure] called.");
  // TODO: このLifecycle遷移で必要な初期化処理を実装する。
  fibonacci_client_ = rclcpp_action::create_client<Fibonacci>(this, "fibonacci");
  // Timer: action_goal_timer
  // Period: 3.0 sec
  // Callback: action_goal_timer_callback()
  // Description: Send action goal periodically.
  action_goal_timer_ = this->create_wall_timer(std::chrono::milliseconds(3000), std::bind(&Eval4ActionClientNode::action_goal_timer_callback, this));
  action_goal_timer_->cancel();
  return CallbackReturn::SUCCESS;
}

CallbackReturn Eval4ActionClientNode::on_activate(const rclcpp_lifecycle::State &)
{
  RCLCPP_INFO(this->get_logger(), "[on_activate] called.");
  // TODO: Active状態で開始する処理を実装する。
  if (action_goal_timer_) { action_goal_timer_->reset(); }
  return CallbackReturn::SUCCESS;
}

CallbackReturn Eval4ActionClientNode::on_deactivate(const rclcpp_lifecycle::State &)
{
  RCLCPP_INFO(this->get_logger(), "[on_deactivate] called.");
  // TODO: Inactive状態へ戻る際に停止する処理を実装する。
  if (action_goal_timer_) { action_goal_timer_->cancel(); }
  return CallbackReturn::SUCCESS;
}

// CallbackReturn Eval4ActionClientNode::on_cleanup(const rclcpp_lifecycle::State &)
// {
//   RCLCPP_INFO(this->get_logger(), "[on_cleanup] called.");
//   // TODO: Cleanup時に解放するリソースを実装する。
//   fibonacci_client_.reset();
//   action_goal_timer_.reset();
//   return CallbackReturn::SUCCESS;
// }

// CallbackReturn Eval4ActionClientNode::on_shutdown(const rclcpp_lifecycle::State &)
// {
//   RCLCPP_INFO(this->get_logger(), "[on_shutdown] called.");
//   // TODO: Shutdown時に必要な終了処理を実装する。
//   return CallbackReturn::SUCCESS;
// }

// CallbackReturn Eval4ActionClientNode::on_error(const rclcpp_lifecycle::State &)
// {
//   RCLCPP_INFO(this->get_logger(), "[on_error] called.");
//   // TODO: Error時の復旧・停止処理を実装する。
//   return CallbackReturn::SUCCESS;
// }

// ============================================================
// Action callbacks and clients
// ============================================================

void Eval4ActionClientNode::send_fibonacci_goal()
{
  // Action Client goal sender: fibonacci
  // Type: example_interfaces/action/Fibonacci
  // Summary: Send Fibonacci goal for evaluation.
  // Action Client helper: Goalを作成してAction Serverへ送信する。
  if (!fibonacci_client_) {
    RCLCPP_WARN(this->get_logger(), "Action client is not configured.");
    return;
  }
  // TODO: このGoal送信関数を呼び出すタイミングを実装する。
  // Note: Action型ごとにGoalフィールドが異なるため、生成器では具体値を設定しない。
  // TODO: Goalを作成し、response / feedback / result callbackを設定して送信する。
  RCLCPP_WARN(this->get_logger(), "Goal send skeleton is disabled. Implement goal send code before use.");
  return;
}

void Eval4ActionClientNode::send_fibonacci_goal_response(rclcpp_action::ClientGoalHandle<Fibonacci>::SharedPtr goal_handle)
{
  // Action Client goal response callback: fibonacci
  // Type: example_interfaces/action/Fibonacci
  // Summary: Send Fibonacci goal for evaluation.
  if (!goal_handle) {
    RCLCPP_ERROR(this->get_logger(), "Goal rejected");
    return;
  }
  RCLCPP_INFO(this->get_logger(), "Goal accepted");
}

void Eval4ActionClientNode::send_fibonacci_goal_feedback(rclcpp_action::ClientGoalHandle<Fibonacci>::SharedPtr, const std::shared_ptr<const Fibonacci::Feedback> feedback)
{
  // Action Client feedback callback: fibonacci
  // Type: example_interfaces/action/Fibonacci
  // Summary: Send Fibonacci goal for evaluation.
  // TODO: 必要に応じてFeedbackを使った処理を実装する。
  (void)feedback;
}

void Eval4ActionClientNode::send_fibonacci_goal_result(const rclcpp_action::ClientGoalHandle<Fibonacci>::WrappedResult & result)
{
  // Action Client result callback: fibonacci
  // Type: example_interfaces/action/Fibonacci
  // Summary: Send Fibonacci goal for evaluation.
  // TODO: 必要に応じてResultを使った処理を実装する。
  (void)result;
}

// ============================================================
// Timer callbacks
// ============================================================

void Eval4ActionClientNode::action_goal_timer_callback()
{
  // Timer: action_goal_timer
  // Period: 3.0 sec
  // Callback: action_goal_timer_callback()
  // Description: Send action goal periodically.
  // TODO: 上記の周期処理を実装する。
}

}  // namespace eval4_action_client_cpp_pkg
