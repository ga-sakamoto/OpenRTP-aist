#include "eval3_service_client_cpp_pkg/eval3_service_client_node.hpp"

#include <chrono>
#include <functional>
#include <future>
#include <thread>

using CallbackReturn = rclcpp_lifecycle::node_interfaces::LifecycleNodeInterface::CallbackReturn;

namespace eval3_service_client_cpp_pkg
{

Eval3ServiceClientNode::Eval3ServiceClientNode(const rclcpp::NodeOptions & options)
: rclcpp_lifecycle::LifecycleNode("eval3_service_client_node", options)
{
  RCLCPP_INFO(this->get_logger(), "[Constructor] Node created.");
}

// ============================================================
// Lifecycle callbacks
// ============================================================

CallbackReturn Eval3ServiceClientNode::on_configure(const rclcpp_lifecycle::State &)
{
  RCLCPP_INFO(this->get_logger(), "[on_configure] called.");
  // TODO: このLifecycle遷移で必要な初期化処理を実装する。
  call_reset_ = this->create_client<std_srvs::srv::Trigger>("reset");
  call_set_bool_ = this->create_client<std_srvs::srv::SetBool>("set_bool");
  // Timer: service_call_timer
  // Period: 2.0 sec
  // Callback: service_call_timer_callback()
  // Description: Call services periodically.
  service_call_timer_ = this->create_wall_timer(std::chrono::milliseconds(2000), std::bind(&Eval3ServiceClientNode::service_call_timer_callback, this));
  service_call_timer_->cancel();
  return CallbackReturn::SUCCESS;
}

CallbackReturn Eval3ServiceClientNode::on_activate(const rclcpp_lifecycle::State &)
{
  RCLCPP_INFO(this->get_logger(), "[on_activate] called.");
  // TODO: Active状態で開始する処理を実装する。
  if (service_call_timer_) { service_call_timer_->reset(); }
  return CallbackReturn::SUCCESS;
}

CallbackReturn Eval3ServiceClientNode::on_deactivate(const rclcpp_lifecycle::State &)
{
  RCLCPP_INFO(this->get_logger(), "[on_deactivate] called.");
  // TODO: Inactive状態へ戻る際に停止する処理を実装する。
  if (service_call_timer_) { service_call_timer_->cancel(); }
  return CallbackReturn::SUCCESS;
}

// CallbackReturn Eval3ServiceClientNode::on_cleanup(const rclcpp_lifecycle::State &)
// {
//   RCLCPP_INFO(this->get_logger(), "[on_cleanup] called.");
//   // TODO: Cleanup時に解放するリソースを実装する。
//   call_reset_.reset();
//   call_set_bool_.reset();
//   service_call_timer_.reset();
//   return CallbackReturn::SUCCESS;
// }

// CallbackReturn Eval3ServiceClientNode::on_shutdown(const rclcpp_lifecycle::State &)
// {
//   RCLCPP_INFO(this->get_logger(), "[on_shutdown] called.");
//   // TODO: Shutdown時に必要な終了処理を実装する。
//   return CallbackReturn::SUCCESS;
// }

// CallbackReturn Eval3ServiceClientNode::on_error(const rclcpp_lifecycle::State &)
// {
//   RCLCPP_INFO(this->get_logger(), "[on_error] called.");
//   // TODO: Error時の復旧・停止処理を実装する。
//   return CallbackReturn::SUCCESS;
// }

// ============================================================
// Service callbacks and clients
// ============================================================

void Eval3ServiceClientNode::call_reset_service()
{
  // Service Client call: reset
  // Type: std_srvs/srv/Trigger
  // Summary: Call reset service.
  // Service Client helper: requestを作成してServerへ非同期送信する。
  if (!call_reset_) {
    RCLCPP_WARN(this->get_logger(), "Service client is not configured.");
    return;
  }
  auto request = std::make_shared<std_srvs::srv::Trigger::Request>();
  // TODO: このService呼び出し関数を呼び出すタイミングを実装する。
  // TODO: 使用するService型に合わせてrequestフィールドを設定する。
  // Note: request設定後、async_send_request()でService Serverへ送信する。
  auto future = call_reset_->async_send_request(request);
  (void)future;
}

void Eval3ServiceClientNode::call_set_bool_service()
{
  // Service Client call: set_bool
  // Type: std_srvs/srv/SetBool
  // Summary: Call set_bool service.
  // Service Client helper: requestを作成してServerへ非同期送信する。
  if (!call_set_bool_) {
    RCLCPP_WARN(this->get_logger(), "Service client is not configured.");
    return;
  }
  auto request = std::make_shared<std_srvs::srv::SetBool::Request>();
  // TODO: このService呼び出し関数を呼び出すタイミングを実装する。
  // TODO: 使用するService型に合わせてrequestフィールドを設定する。
  // Note: request設定後、async_send_request()でService Serverへ送信する。
  auto future = call_set_bool_->async_send_request(request);
  (void)future;
}

// ============================================================
// Timer callbacks
// ============================================================

void Eval3ServiceClientNode::service_call_timer_callback()
{
  // Timer: service_call_timer
  // Period: 2.0 sec
  // Callback: service_call_timer_callback()
  // Description: Call services periodically.
  // TODO: 上記の周期処理を実装する。
}

}  // namespace eval3_service_client_cpp_pkg
