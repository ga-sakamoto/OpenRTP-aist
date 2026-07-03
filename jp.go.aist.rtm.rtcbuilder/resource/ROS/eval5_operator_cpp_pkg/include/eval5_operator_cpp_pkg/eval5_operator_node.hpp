#ifndef EVAL5_OPERATOR_CPP_PKG__EVAL5_OPERATOR_NODE_HPP_
#define EVAL5_OPERATOR_CPP_PKG__EVAL5_OPERATOR_NODE_HPP_

#include "eval5_operator_cpp_pkg_interfaces/action/move_to_target.hpp"
#include "eval5_operator_cpp_pkg_interfaces/srv/set_mode.hpp"
#include "geometry_msgs/msg/twist.hpp"
#include "rcl_interfaces/msg/floating_point_range.hpp"
#include "rcl_interfaces/msg/integer_range.hpp"
#include "rcl_interfaces/msg/parameter_descriptor.hpp"
#include "rcl_interfaces/msg/set_parameters_result.hpp"
#include "rclcpp/rclcpp.hpp"
#include "rclcpp_action/rclcpp_action.hpp"
#include "rclcpp_lifecycle/lifecycle_node.hpp"
#include "rclcpp_lifecycle/lifecycle_publisher.hpp"
#include "std_msgs/msg/string.hpp"
#include <future>
#include <memory>
#include <string>
#include <vector>

namespace eval5_operator_cpp_pkg
{

class Eval5OperatorNode : public rclcpp_lifecycle::LifecycleNode
{
public:
  using MoveToTarget = eval5_operator_cpp_pkg_interfaces::action::MoveToTarget;

  explicit Eval5OperatorNode(const rclcpp::NodeOptions & options = rclcpp::NodeOptions());
  ~Eval5OperatorNode() override = default;

  // ============================================================
  // Lifecycle callbacks
  // ============================================================

  rclcpp_lifecycle::node_interfaces::LifecycleNodeInterface::CallbackReturn
  on_configure(const rclcpp_lifecycle::State & state) override;

  rclcpp_lifecycle::node_interfaces::LifecycleNodeInterface::CallbackReturn
  on_activate(const rclcpp_lifecycle::State & state) override;

  rclcpp_lifecycle::node_interfaces::LifecycleNodeInterface::CallbackReturn
  on_deactivate(const rclcpp_lifecycle::State & state) override;

  // 任意: on_cleanup. 使う場合は宣言と定義のコメントアウトを外す
  //   rclcpp_lifecycle::node_interfaces::LifecycleNodeInterface::CallbackReturn
  //   on_cleanup(const rclcpp_lifecycle::State & state) override;

  // 任意: on_shutdown. 使う場合は宣言と定義のコメントアウトを外す
  //   rclcpp_lifecycle::node_interfaces::LifecycleNodeInterface::CallbackReturn
  //   on_shutdown(const rclcpp_lifecycle::State & state) override;

  // 任意: on_error. 使う場合は宣言と定義のコメントアウトを外す
  //   rclcpp_lifecycle::node_interfaces::LifecycleNodeInterface::CallbackReturn
  //   on_error(const rclcpp_lifecycle::State & state) override;

private:
  // ============================================================
  // Parameter handling
  // ============================================================

  void declare_parameters();
  rclcpp::node_interfaces::OnSetParametersCallbackHandle::SharedPtr param_cb_handle_;
  rcl_interfaces::msg::SetParametersResult on_set_parameters(const std::vector<rclcpp::Parameter> & params);

  // ============================================================
  // Topic handles and callbacks
  // ============================================================

  rclcpp_lifecycle::LifecyclePublisher<geometry_msgs::msg::Twist>::SharedPtr cmd_vel_pub_;
  rclcpp::Subscription<std_msgs::msg::String>::SharedPtr robot_status_sub_;
  void robot_status_callback(const std_msgs::msg::String::SharedPtr msg);

  // ============================================================
  // Service handles and callbacks
  // ============================================================

  rclcpp::Client<eval5_operator_cpp_pkg_interfaces::srv::SetMode>::SharedPtr call_set_mode_;
  void call_set_mode_service();

  // ============================================================
  // Action handles and callbacks
  // ============================================================

  rclcpp_action::Client<MoveToTarget>::SharedPtr move_to_target_client_;
  void send_move_to_target_goal();
  void send_move_to_target_goal_response(rclcpp_action::ClientGoalHandle<MoveToTarget>::SharedPtr goal_handle);
  void send_move_to_target_goal_feedback(rclcpp_action::ClientGoalHandle<MoveToTarget>::SharedPtr, const std::shared_ptr<const MoveToTarget::Feedback> feedback);
  void send_move_to_target_goal_result(const rclcpp_action::ClientGoalHandle<MoveToTarget>::WrappedResult & result);

  // ============================================================
  // Timer handles and callbacks
  // ============================================================

  rclcpp::TimerBase::SharedPtr timer_0_;
  void command_timer_callback();
};

}  // namespace eval5_operator_cpp_pkg

#endif  // EVAL5_OPERATOR_CPP_PKG__EVAL5_OPERATOR_NODE_HPP_
