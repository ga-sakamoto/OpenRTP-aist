#include "eval1_minimal_cpp_pkg/eval1_minimal_node.hpp"

#include <chrono>
#include <functional>
#include <future>
#include <thread>

using CallbackReturn = rclcpp_lifecycle::node_interfaces::LifecycleNodeInterface::CallbackReturn;

namespace eval1_minimal_cpp_pkg
{

Eval1MinimalNode::Eval1MinimalNode(const rclcpp::NodeOptions & options)
: rclcpp_lifecycle::LifecycleNode("eval1_minimal_node", options)
{
  RCLCPP_INFO(this->get_logger(), "[Constructor] Node created.");
}

// ============================================================
// Lifecycle callbacks
// ============================================================

CallbackReturn Eval1MinimalNode::on_configure(const rclcpp_lifecycle::State &)
{
  RCLCPP_INFO(this->get_logger(), "[on_configure] called.");
  // TODO: このLifecycle遷移で必要な初期化処理を実装する。
  return CallbackReturn::SUCCESS;
}

CallbackReturn Eval1MinimalNode::on_activate(const rclcpp_lifecycle::State &)
{
  RCLCPP_INFO(this->get_logger(), "[on_activate] called.");
  // TODO: Active状態で開始する処理を実装する。
  return CallbackReturn::SUCCESS;
}

CallbackReturn Eval1MinimalNode::on_deactivate(const rclcpp_lifecycle::State &)
{
  RCLCPP_INFO(this->get_logger(), "[on_deactivate] called.");
  // TODO: Inactive状態へ戻る際に停止する処理を実装する。
  return CallbackReturn::SUCCESS;
}

// CallbackReturn Eval1MinimalNode::on_cleanup(const rclcpp_lifecycle::State &)
// {
//   RCLCPP_INFO(this->get_logger(), "[on_cleanup] called.");
//   // TODO: Cleanup時に解放するリソースを実装する。
//   return CallbackReturn::SUCCESS;
// }

// CallbackReturn Eval1MinimalNode::on_shutdown(const rclcpp_lifecycle::State &)
// {
//   RCLCPP_INFO(this->get_logger(), "[on_shutdown] called.");
//   // TODO: Shutdown時に必要な終了処理を実装する。
//   return CallbackReturn::SUCCESS;
// }

// CallbackReturn Eval1MinimalNode::on_error(const rclcpp_lifecycle::State &)
// {
//   RCLCPP_INFO(this->get_logger(), "[on_error] called.");
//   // TODO: Error時の復旧・停止処理を実装する。
//   return CallbackReturn::SUCCESS;
// }

}  // namespace eval1_minimal_cpp_pkg
