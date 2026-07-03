#include <memory>
#include "rclcpp/rclcpp.hpp"
#include "eval6_image_cpp_pkg/eval6_image_node.hpp"

int main(int argc, char ** argv)
{
  rclcpp::init(argc, argv);
  auto node = std::make_shared<eval6_image_cpp_pkg::Eval6ImageNode>();
  rclcpp::spin(node->get_node_base_interface());
  rclcpp::shutdown();
  return 0;
}
