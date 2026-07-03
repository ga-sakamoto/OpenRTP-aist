#include "eval3_service_server_cpp_pkg/eval3_service_server_node.hpp"

#include <chrono>
#include <functional>
#include <future>
#include <thread>

using CallbackReturn = rclcpp_lifecycle::node_interfaces::LifecycleNodeInterface::CallbackReturn;

namespace eval3_service_server_cpp_pkg
{

Eval3ServiceServerNode::Eval3ServiceServerNode(const rclcpp::NodeOptions & options)
: rclcpp_lifecycle::LifecycleNode("eval3_service_server_node", options)
{
  RCLCPP_INFO(this->get_logger(), "[Constructor] Node created.");
}

// ============================================================
// Lifecycle callbacks
// ============================================================

CallbackReturn Eval3ServiceServerNode::on_configure(const rclcpp_lifecycle::State &)
{
  RCLCPP_INFO(this->get_logger(), "[on_configure] called.");
  // TODO: このLifecycle遷移で必要な初期化処理を実装する。
  reset_srv_ = this->create_service<std_srvs::srv::Trigger>("reset", std::bind(&Eval3ServiceServerNode::reset_callback, this, std::placeholders::_1, std::placeholders::_2));
  set_bool_srv_ = this->create_service<std_srvs::srv::SetBool>("set_bool", std::bind(&Eval3ServiceServerNode::set_bool_callback, this, std::placeholders::_1, std::placeholders::_2));
  return CallbackReturn::SUCCESS;
}

CallbackReturn Eval3ServiceServerNode::on_activate(const rclcpp_lifecycle::State &)
{
  RCLCPP_INFO(this->get_logger(), "[on_activate] called.");
  // TODO: Active状態で開始する処理を実装する。
  return CallbackReturn::SUCCESS;
}

CallbackReturn Eval3ServiceServerNode::on_deactivate(const rclcpp_lifecycle::State &)
{
  RCLCPP_INFO(this->get_logger(), "[on_deactivate] called.");
  // TODO: Inactive状態へ戻る際に停止する処理を実装する。
  return CallbackReturn::SUCCESS;
}

// CallbackReturn Eval3ServiceServerNode::on_cleanup(const rclcpp_lifecycle::State &)
// {
//   RCLCPP_INFO(this->get_logger(), "[on_cleanup] called.");
//   // TODO: Cleanup時に解放するリソースを実装する。
//   reset_srv_.reset();
//   set_bool_srv_.reset();
//   return CallbackReturn::SUCCESS;
// }

// CallbackReturn Eval3ServiceServerNode::on_shutdown(const rclcpp_lifecycle::State &)
// {
//   RCLCPP_INFO(this->get_logger(), "[on_shutdown] called.");
//   // TODO: Shutdown時に必要な終了処理を実装する。
//   return CallbackReturn::SUCCESS;
// }

// CallbackReturn Eval3ServiceServerNode::on_error(const rclcpp_lifecycle::State &)
// {
//   RCLCPP_INFO(this->get_logger(), "[on_error] called.");
//   // TODO: Error時の復旧・停止処理を実装する。
//   return CallbackReturn::SUCCESS;
// }

// ============================================================
// Service callbacks and clients
// ============================================================

void Eval3ServiceServerNode::reset_callback(const std::shared_ptr<std_srvs::srv::Trigger::Request> request, std::shared_ptr<std_srvs::srv::Trigger::Response> response)
{
  // Service Server callback: reset
  // Type: std_srvs/srv/Trigger
  // Summary: Reset internal state.
  // TODO: requestを読み取り、Serviceで実行する処理を実装する。
  // TODO: responseに返す値を設定する。
  (void)request;
  (void)response;
}

void Eval3ServiceServerNode::set_bool_callback(const std::shared_ptr<std_srvs::srv::SetBool::Request> request, std::shared_ptr<std_srvs::srv::SetBool::Response> response)
{
  // Service Server callback: set_bool
  // Type: std_srvs/srv/SetBool
  // Summary: Accept boolean command for evaluation.
  // TODO: requestを読み取り、Serviceで実行する処理を実装する。
  // TODO: responseに返す値を設定する。
  (void)request;
  (void)response;
}

}  // namespace eval3_service_server_cpp_pkg
