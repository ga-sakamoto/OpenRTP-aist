cmake_minimum_required(VERSION 3.8)
project(eval1_minimal_cpp_pkg)

if(CMAKE_COMPILER_IS_GNUCXX OR CMAKE_CXX_COMPILER_ID MATCHES "Clang")
  add_compile_options(-Wall -Wextra -Wpedantic)
endif()

find_package(ament_cmake REQUIRED)
# Core dependencies
find_package(lifecycle_msgs REQUIRED)
find_package(rclcpp REQUIRED)
find_package(rclcpp_lifecycle REQUIRED)
add_library(${PROJECT_NAME}_lib src/eval1_minimal_node.cpp)
target_include_directories(${PROJECT_NAME}_lib PUBLIC
  $<BUILD_INTERFACE:${CMAKE_CURRENT_SOURCE_DIR}/include>
  $<INSTALL_INTERFACE:include>
)
ament_target_dependencies(${PROJECT_NAME}_lib
  lifecycle_msgs
  rclcpp
  rclcpp_lifecycle
)

add_executable(eval1_minimal_node src/main.cpp)
target_link_libraries(eval1_minimal_node ${PROJECT_NAME}_lib)

install(TARGETS ${PROJECT_NAME}_lib eval1_minimal_node
  ARCHIVE DESTINATION lib
  LIBRARY DESTINATION lib
  RUNTIME DESTINATION lib/${PROJECT_NAME}
)
install(DIRECTORY include/ DESTINATION include)
install(DIRECTORY launch/ DESTINATION share/${PROJECT_NAME}/launch)
install(DIRECTORY config/ DESTINATION share/${PROJECT_NAME}/config)

install(FILES LICENSE README.md DESTINATION share/${PROJECT_NAME})

ament_package()
