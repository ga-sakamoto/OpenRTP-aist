#include "eval6_image_cpp_pkg/eval6_image_node.hpp"

#include <chrono>
#include <functional>
#include <future>
#include <thread>

using CallbackReturn = rclcpp_lifecycle::node_interfaces::LifecycleNodeInterface::CallbackReturn;

namespace eval6_image_cpp_pkg
{

Eval6ImageNode::Eval6ImageNode(const rclcpp::NodeOptions & options)
: rclcpp_lifecycle::LifecycleNode("eval6_image_node", options)
{
  RCLCPP_INFO(this->get_logger(), "[Constructor] Node created.");
  declare_parameters();
}

// ============================================================
// Parameter handling
// ============================================================

void Eval6ImageNode::declare_parameters()
{
  rcl_interfaces::msg::ParameterDescriptor desc_enable_processing;
  desc_enable_processing.description = "Enable image processing and debug publish.";
  this->declare_parameter("enable_processing", true, desc_enable_processing);
  rcl_interfaces::msg::ParameterDescriptor desc_debug_scale;
  desc_debug_scale.description = "Scale factor for debug image processing.";
  this->declare_parameter("debug_scale", 1.0, desc_debug_scale);
  param_cb_handle_ = this->add_on_set_parameters_callback(std::bind(&Eval6ImageNode::on_set_parameters, this, std::placeholders::_1));
}

rcl_interfaces::msg::SetParametersResult Eval6ImageNode::on_set_parameters(const std::vector<rclcpp::Parameter> & params)
{
  rcl_interfaces::msg::SetParametersResult result;
  result.successful = true;

  for (const auto & param : params) {
    if (param.get_name() == "enable_processing") {
      // TODO: Parameter変更時に必要な内部状態の更新処理を実装する。
      // Note: min / max / step は自動制約にしない。必要な制約はここで明示的に実装する。
      const bool value = param.as_bool();
      (void)value;
      // TODO: 必要に応じてParameter値をメンバ変数や処理設定へ反映する。
    }
    if (param.get_name() == "debug_scale") {
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

CallbackReturn Eval6ImageNode::on_configure(const rclcpp_lifecycle::State &)
{
  RCLCPP_INFO(this->get_logger(), "[on_configure] called.");
  // TODO: このLifecycle遷移で必要な初期化処理を実装する。
  image_raw_sub_ = this->create_subscription<sensor_msgs::msg::Image>("image_raw", rclcpp::QoS(10).reliable(), std::bind(&Eval6ImageNode::image_callback, this, std::placeholders::_1));
  // Topic Publisher: image_debug
  // Type: sensor_msgs/msg/Image
  // Summary: Publish debug image output.
  image_debug_pub_ = this->create_publisher<sensor_msgs::msg::Image>("image_debug", rclcpp::QoS(10).reliable());
  return CallbackReturn::SUCCESS;
}

CallbackReturn Eval6ImageNode::on_activate(const rclcpp_lifecycle::State &)
{
  RCLCPP_INFO(this->get_logger(), "[on_activate] called.");
  // TODO: Active状態で開始する処理を実装する。
  if (image_debug_pub_) { image_debug_pub_->on_activate(); }
  return CallbackReturn::SUCCESS;
}

CallbackReturn Eval6ImageNode::on_deactivate(const rclcpp_lifecycle::State &)
{
  RCLCPP_INFO(this->get_logger(), "[on_deactivate] called.");
  // TODO: Inactive状態へ戻る際に停止する処理を実装する。
  if (image_debug_pub_) { image_debug_pub_->on_deactivate(); }
  return CallbackReturn::SUCCESS;
}

// 任意: on_cleanup. 使う場合はhpp側の宣言も有効化する
// CallbackReturn Eval6ImageNode::on_cleanup(const rclcpp_lifecycle::State &)
// {
//   RCLCPP_INFO(this->get_logger(), "[on_cleanup] called.");
//   // TODO: Cleanup時に解放するリソースを実装する。
//   image_raw_sub_.reset();
//   image_debug_pub_.reset();
//   return CallbackReturn::SUCCESS;
// }

// 任意: on_shutdown. 使う場合はhpp側の宣言も有効化する
// CallbackReturn Eval6ImageNode::on_shutdown(const rclcpp_lifecycle::State &)
// {
//   RCLCPP_INFO(this->get_logger(), "[on_shutdown] called.");
//   // TODO: Shutdown時に必要な終了処理を実装する。
//   return CallbackReturn::SUCCESS;
// }

// 任意: on_error. 使う場合はhpp側の宣言も有効化する
// CallbackReturn Eval6ImageNode::on_error(const rclcpp_lifecycle::State &)
// {
//   RCLCPP_INFO(this->get_logger(), "[on_error] called.");
//   // TODO: Error時の復旧・停止処理を実装する。
//   return CallbackReturn::SUCCESS;
// }

// ============================================================
// Topic callbacks
// ============================================================

void Eval6ImageNode::image_callback(const sensor_msgs::msg::Image::SharedPtr msg)
{
  // Topic Subscriber callback: image_raw
  // Type: sensor_msgs/msg/Image
  // Summary: Receive raw image input.
  // TODO: 受信したmsgを使って、このノードの処理を実装する。
  // Note: このcallbackは対象Topicにメッセージが届くたびに呼ばれる。
  (void)msg;
}

}  // namespace eval6_image_cpp_pkg
