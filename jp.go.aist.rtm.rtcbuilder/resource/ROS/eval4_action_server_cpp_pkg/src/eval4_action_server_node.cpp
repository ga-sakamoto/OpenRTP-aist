#include "eval4_action_server_cpp_pkg/eval4_action_server_node.hpp"

#include <chrono>
#include <functional>
#include <future>
#include <thread>

using CallbackReturn = rclcpp_lifecycle::node_interfaces::LifecycleNodeInterface::CallbackReturn;

namespace eval4_action_server_cpp_pkg
{

Eval4ActionServerNode::Eval4ActionServerNode(const rclcpp::NodeOptions & options)
: rclcpp_lifecycle::LifecycleNode("eval4_action_server_node", options)
{
  RCLCPP_INFO(this->get_logger(), "[Constructor] Node created.");
}

// ============================================================
// Lifecycle callbacks
// ============================================================

CallbackReturn Eval4ActionServerNode::on_configure(const rclcpp_lifecycle::State &)
{
  RCLCPP_INFO(this->get_logger(), "[on_configure] called.");
  // TODO: このLifecycle遷移で必要な初期化処理を実装する。
  fibonacci_server_ = rclcpp_action::create_server<Fibonacci>(this, "fibonacci", std::bind(&Eval4ActionServerNode::handle_goal_fibonacci, this, std::placeholders::_1, std::placeholders::_2), std::bind(&Eval4ActionServerNode::handle_cancel_fibonacci, this, std::placeholders::_1), std::bind(&Eval4ActionServerNode::handle_accepted_fibonacci, this, std::placeholders::_1));
  return CallbackReturn::SUCCESS;
}

CallbackReturn Eval4ActionServerNode::on_activate(const rclcpp_lifecycle::State &)
{
  RCLCPP_INFO(this->get_logger(), "[on_activate] called.");
  // TODO: Active状態で開始する処理を実装する。
  return CallbackReturn::SUCCESS;
}

CallbackReturn Eval4ActionServerNode::on_deactivate(const rclcpp_lifecycle::State &)
{
  RCLCPP_INFO(this->get_logger(), "[on_deactivate] called.");
  // TODO: Inactive状態へ戻る際に停止する処理を実装する。
  return CallbackReturn::SUCCESS;
}

// CallbackReturn Eval4ActionServerNode::on_cleanup(const rclcpp_lifecycle::State &)
// {
//   RCLCPP_INFO(this->get_logger(), "[on_cleanup] called.");
//   // TODO: Cleanup時に解放するリソースを実装する。
//   fibonacci_server_.reset();
//   return CallbackReturn::SUCCESS;
// }

// CallbackReturn Eval4ActionServerNode::on_shutdown(const rclcpp_lifecycle::State &)
// {
//   RCLCPP_INFO(this->get_logger(), "[on_shutdown] called.");
//   // TODO: Shutdown時に必要な終了処理を実装する。
//   return CallbackReturn::SUCCESS;
// }

// CallbackReturn Eval4ActionServerNode::on_error(const rclcpp_lifecycle::State &)
// {
//   RCLCPP_INFO(this->get_logger(), "[on_error] called.");
//   // TODO: Error時の復旧・停止処理を実装する。
//   return CallbackReturn::SUCCESS;
// }

// ============================================================
// Action callbacks and clients
// ============================================================

rclcpp_action::GoalResponse Eval4ActionServerNode::handle_goal_fibonacci(const rclcpp_action::GoalUUID & uuid, std::shared_ptr<const Fibonacci::Goal> goal)
{
  // Action Server goal callback: fibonacci
  // Type: example_interfaces/action/Fibonacci
  // Summary: Execute Fibonacci action goals.
  (void)uuid;
  (void)goal;
  return rclcpp_action::GoalResponse::ACCEPT_AND_EXECUTE;
}

rclcpp_action::CancelResponse Eval4ActionServerNode::handle_cancel_fibonacci(const std::shared_ptr<GoalHandleFibonacci> goal_handle)
{
  // Action Server cancel callback: fibonacci
  // Type: example_interfaces/action/Fibonacci
  // Summary: Execute Fibonacci action goals.
  (void)goal_handle;
  return rclcpp_action::CancelResponse::ACCEPT;
}

void Eval4ActionServerNode::handle_accepted_fibonacci(const std::shared_ptr<GoalHandleFibonacci> goal_handle)
{
  // Action Server accepted callback: fibonacci
  // Type: example_interfaces/action/Fibonacci
  // Summary: Execute Fibonacci action goals.
  std::thread{std::bind(&Eval4ActionServerNode::fibonacci, this, std::placeholders::_1), goal_handle}.detach();
}

void Eval4ActionServerNode::fibonacci(const std::shared_ptr<GoalHandleFibonacci> goal_handle)
{
  // Action Server execute callback: fibonacci
  // Type: example_interfaces/action/Fibonacci
  // Summary: Execute Fibonacci action goals.
  const auto goal = goal_handle->get_goal();
  auto result = std::make_shared<Fibonacci::Result>();

  // TODO: Goalを読み取り、Actionの実行処理を実装する。
  // TODO: 必要に応じてFeedbackとResultを設定する。
  (void)goal;

  goal_handle->succeed(result);
}

}  // namespace eval4_action_server_cpp_pkg
