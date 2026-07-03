package jp.go.aist.rtm.rtcbuilder._test.ROS;

import java.util.List;

import jp.go.aist.rtm.rtcbuilder.Generator;
import jp.go.aist.rtm.rtcbuilder.IRtcBuilderConstants;
import jp.go.aist.rtm.rtcbuilder._test.TestBase;
import jp.go.aist.rtm.rtcbuilder.generator.GeneratedResult;
import jp.go.aist.rtm.rtcbuilder.generator.param.GeneratorParam;
import jp.go.aist.rtm.rtcbuilder.ros.IRtcBuilderConstantsROS;
import jp.go.aist.rtm.rtcbuilder.ros.manager.CXXGenerateManager;
import jp.go.aist.rtm.rtcbuilder.ros.manager.CommonGenerateManager;
import jp.go.aist.rtm.rtcbuilder.ros.param.ActionParam;
import jp.go.aist.rtm.rtcbuilder.ros.param.PackageParam;
import jp.go.aist.rtm.rtcbuilder.ros.param.ParameterParam;
import jp.go.aist.rtm.rtcbuilder.ros.param.ROSParam;
import jp.go.aist.rtm.rtcbuilder.ros.param.ServiceParam;
import jp.go.aist.rtm.rtcbuilder.ros.param.TimerParam;
import jp.go.aist.rtm.rtcbuilder.ros.param.TopicParam;

public class BasicTest extends TestBase {

	ROSParam rosParam;
	GeneratorParam genParam;

	protected void setUp() throws Exception {
		genParam = new GeneratorParam();
		rosParam = new ROSParam(genParam);
		rosParam.setOutputProject(rootPath + "/resource/work");
		rosParam.setLanguage(IRtcBuilderConstants.LANG_CPP);
		rosParam.setLanguageArg(IRtcBuilderConstants.LANG_CPP_ARG);
		genParam.setROSParam(rosParam);
	}

	public void testMinimal() throws Exception {
		rosParam.setPackageName("eval1_minimal_cpp_pkg");
		rosParam.setNodeName("eval1_minimal_node");
		rosParam.setClassName("Eval1MinimalNode");
		rosParam.setDescription("Minimal C++ Lifecycle Node sample.");
		rosParam.setVersion("0.0.1");
		rosParam.setMaintainer("rsdlab");
		rosParam.setContactAddress("todo@example.com");
		rosParam.setLicense("Apache-2.0");
		
		Generator generator = new Generator();
		generator.clearGenerateManager();
		generator.addGenerateManager(new CommonGenerateManager());
		generator.addGenerateManager(new CXXGenerateManager());

		List<GeneratedResult> result = generator.generateTemplateCodeROS(genParam);

		String resourceDir = rootPath + "/resource/ROS/eval1_minimal_cpp_pkg/";

		checkCode(result, resourceDir, "README.md");
		checkCode(result, resourceDir, "package.xml");
		checkCode(result, resourceDir, "CMakeLists.txt");
//		checkCode(result, resourceDir, "LICENSE");
		checkCode(result, resourceDir, "config/params.yaml");
		checkCode(result, resourceDir, "launch/eval1_minimal_node.launch.py");
		checkCode(result, resourceDir, "include/eval1_minimal_cpp_pkg/eval1_minimal_node.hpp");
		checkCode(result, resourceDir, "src/main.cpp");
		checkCode(result, resourceDir, "src/eval1_minimal_node.cpp");
	}
	
	public void testCmdSource() throws Exception {
		rosParam.setPackageName("eval2_cmd_source_cpp_pkg");
		rosParam.setNodeName("eval2_cmd_source_node");
		rosParam.setClassName("Eval2CmdSourceNode");
		rosParam.setDescription("C++ command source node that publishes cmd_vel and subscribes robot_status for evaluation.");
		rosParam.setVersion("0.0.1");
		rosParam.setMaintainer("rsdlab");
		rosParam.setContactAddress("todo@example.com");
		rosParam.setLicense("BSD-3-Clause");
		
		TopicParam topic1 = new TopicParam();
		topic1.setName("cmd_vel");
		topic1.setMessageType("geometry_msgs/msg/Twist");
		topic1.setVarCallbackName("cmd_vel_pub");
		topic1.setReliabilityType("Reliable");
		topic1.setHistoryType("Keep Last");
		topic1.setDepth(10);
		topic1.setDocDescription("Publish velocity command.");
		rosParam.getTopicPublishes().add(topic1);
		
		TopicParam topic2 = new TopicParam();
		topic2.setName("robot_status");
		topic2.setMessageType("std_msgs/msg/String");
		topic2.setVarCallbackName("robot_status_callback");
		topic2.setReliabilityType("Reliable");
		topic2.setHistoryType("Keep Last");
		topic2.setDepth(10);
		topic2.setDocDescription("Receive robot status text.");
		rosParam.getTopicSubscribes().add(topic2);
		
		TimerParam timer = new TimerParam();
		timer.setName("cmd_timer");
		timer.setRate(1.0);
		timer.setCallBack("cmd_timer_callback");
		timer.setDescription("Publish velocity command periodically.");
		rosParam.getTimers().add(timer);

		Generator generator = new Generator();
		generator.clearGenerateManager();
		generator.addGenerateManager(new CommonGenerateManager());
		generator.addGenerateManager(new CXXGenerateManager());

		List<GeneratedResult> result = generator.generateTemplateCodeROS(genParam);

		String resourceDir = rootPath + "/resource/ROS/eval2_cmd_source_cpp_pkg/";

		checkCode(result, resourceDir, "README.md");
		checkCode(result, resourceDir, "package.xml");
		checkCode(result, resourceDir, "CMakeLists.txt");
//		checkCode(result, resourceDir, "LICENSE");
		checkCode(result, resourceDir, "config/params.yaml");
		checkCode(result, resourceDir, "launch/eval2_cmd_source_node.launch.py");
		checkCode(result, resourceDir, "include/eval2_cmd_source_cpp_pkg/eval2_cmd_source_node.hpp");
		checkCode(result, resourceDir, "src/main.cpp");
		checkCode(result, resourceDir, "src/eval2_cmd_source_node.cpp");
	}
	
	public void testConrtoller() throws Exception {
		rosParam.setPackageName("eval2_controller_cpp_pkg");
		rosParam.setNodeName("eval2_controller_node");
		rosParam.setClassName("Eval2ControllerNode");
		rosParam.setDescription("C++ controller node with cmd_vel subscription, robot_status publisher, timer, and max_speed parameter.");
		rosParam.setVersion("0.0.1");
		rosParam.setMaintainer("rsdlab");
		rosParam.setContactAddress("todo@example.com");
		rosParam.setLicense("Apache-2.0");
		
		TopicParam topic1 = new TopicParam();
		topic1.setName("robot_status");
		topic1.setMessageType("std_msgs/msg/String");
		topic1.setVarCallbackName("robot_status_pub");
		topic1.setReliabilityType("Reliable");
		topic1.setHistoryType("Keep Last");
		topic1.setDepth(10);
		topic1.setDocDescription("Publish robot status text.");
		rosParam.getTopicPublishes().add(topic1);
		
		TopicParam topic2 = new TopicParam();
		topic2.setName("cmd_vel");
		topic2.setMessageType("geometry_msgs/msg/Twist");
		topic2.setVarCallbackName("cmd_vel_callback");
		topic2.setReliabilityType("Reliable");
		topic2.setHistoryType("Keep Last");
		topic2.setDepth(10);
		topic2.setDocDescription("Receive velocity command.");
		rosParam.getTopicSubscribes().add(topic2);
		
		TimerParam timer = new TimerParam();
		timer.setName("status_timer");
		timer.setRate(1.0);
		timer.setCallBack("status_timer_callback");
		timer.setDescription("Publish status periodically.");
		rosParam.getTimers().add(timer);
		
		ParameterParam param = new ParameterParam();
		param.setName("max_speed");
		param.setType("double");
		param.setDefaultValue("1.0");
		param.setMin(0.0);
		param.setMax(5.0);
		param.setStep(0.1);
		param.setDocDescription("Maximum linear speed used by the controller.");
		rosParam.getParameters().add(param);

		Generator generator = new Generator();
		generator.clearGenerateManager();
		generator.addGenerateManager(new CommonGenerateManager());
		generator.addGenerateManager(new CXXGenerateManager());

		List<GeneratedResult> result = generator.generateTemplateCodeROS(genParam);

		String resourceDir = rootPath + "/resource/ROS/eval2_controller_cpp_pkg/";

		checkCode(result, resourceDir, "README.md");
		checkCode(result, resourceDir, "package.xml");
		checkCode(result, resourceDir, "CMakeLists.txt");
//		checkCode(result, resourceDir, "LICENSE");
		checkCode(result, resourceDir, "config/params.yaml");
		checkCode(result, resourceDir, "launch/eval2_controller_node.launch.py");
		checkCode(result, resourceDir, "include/eval2_controller_cpp_pkg/eval2_controller_node.hpp");
		checkCode(result, resourceDir, "src/main.cpp");
		checkCode(result, resourceDir, "src/eval2_controller_node.cpp");
	}
	
	public void testLifeCycleCallback() throws Exception {
		rosParam.setPackageName("eval2_controller_cpp_pkg");
		rosParam.setNodeName("eval2_controller_node");
		rosParam.setClassName("Eval2ControllerNode");
		rosParam.setDescription("C++ controller node with cmd_vel subscription, robot_status publisher, timer, and max_speed parameter.");
		rosParam.setVersion("0.0.1");
		rosParam.setMaintainer("rsdlab");
		rosParam.setContactAddress("todo@example.com");
		rosParam.setLicense("Apache-2.0");
		
		rosParam.setActionImplemented(IRtcBuilderConstantsROS.ACTIVITY_CLEANUP, true);
		rosParam.setActionImplemented(IRtcBuilderConstantsROS.ACTIVITY_SHUTDOWN, true);
		rosParam.setActionImplemented(IRtcBuilderConstantsROS.ACTIVITY_ERROR, true);
		
		TopicParam topic1 = new TopicParam();
		topic1.setName("robot_status");
		topic1.setMessageType("std_msgs/msg/String");
		topic1.setVarCallbackName("robot_status_pub");
		topic1.setReliabilityType("Reliable");
		topic1.setHistoryType("Keep Last");
		topic1.setDepth(10);
		topic1.setDocDescription("Publish robot status text.");
		rosParam.getTopicPublishes().add(topic1);
		
		TopicParam topic2 = new TopicParam();
		topic2.setName("cmd_vel");
		topic2.setMessageType("geometry_msgs/msg/Twist");
		topic2.setVarCallbackName("cmd_vel_callback");
		topic2.setReliabilityType("Reliable");
		topic2.setHistoryType("Keep Last");
		topic2.setDepth(10);
		topic2.setDocDescription("Receive velocity command.");
		rosParam.getTopicSubscribes().add(topic2);
		
		TimerParam timer = new TimerParam();
		timer.setName("status_timer");
		timer.setRate(1.0);
		timer.setCallBack("status_timer_callback");
		timer.setDescription("Publish status periodically.");
		rosParam.getTimers().add(timer);
		
		ParameterParam param = new ParameterParam();
		param.setName("max_speed");
		param.setType("double");
		param.setDefaultValue("1.0");
		param.setMin(0.0);
		param.setMax(5.0);
		param.setStep(0.1);
		param.setDocDescription("Maximum linear speed used by the controller.");
		rosParam.getParameters().add(param);

		Generator generator = new Generator();
		generator.clearGenerateManager();
		generator.addGenerateManager(new CommonGenerateManager());
		generator.addGenerateManager(new CXXGenerateManager());

		List<GeneratedResult> result = generator.generateTemplateCodeROS(genParam);

		String resourceDir = rootPath + "/resource/ROS/eval2_controller_cpp_pkg_cb/";

		checkCode(result, resourceDir, "README.md");
		checkCode(result, resourceDir, "package.xml");
		checkCode(result, resourceDir, "CMakeLists.txt");
//		checkCode(result, resourceDir, "LICENSE");
		checkCode(result, resourceDir, "config/params.yaml");
		checkCode(result, resourceDir, "launch/eval2_controller_node.launch.py");
		checkCode(result, resourceDir, "include/eval2_controller_cpp_pkg/eval2_controller_node.hpp");
		checkCode(result, resourceDir, "src/main.cpp");
		checkCode(result, resourceDir, "src/eval2_controller_node.cpp");
	}
	
	public void testServiceClient() throws Exception {
		rosParam.setPackageName("eval3_service_client_cpp_pkg");
		rosParam.setNodeName("eval3_service_client_node");
		rosParam.setClassName("Eval3ServiceClientNode");
		rosParam.setDescription("C++ service client node that calls reset and set_bool services periodically.");
		rosParam.setVersion("0.0.1");
		rosParam.setMaintainer("rsdlab");
		rosParam.setContactAddress("todo@example.com");
		rosParam.setLicense("BSD-3-Clause");
		
		ServiceParam service01 = new ServiceParam();
		service01.setName("reset");
		service01.setType("std_srvs/srv/Trigger");
		service01.setVarCallbackName("call_reset");
		service01.setDocDescription("Call reset service.");
		rosParam.getServiceClients().add(service01);
		
		ServiceParam service02 = new ServiceParam();
		service02.setName("set_bool");
		service02.setType("std_srvs/srv/SetBool");
		service02.setVarCallbackName("call_set_bool");
		service02.setDocDescription("Call set_bool service.");
		rosParam.getServiceClients().add(service02);

		TimerParam timer = new TimerParam();
		timer.setName("service_call_timer");
		timer.setRate(2.0);
		timer.setCallBack("service_call_timer_callback");
		timer.setDescription("Call services periodically.");
		rosParam.getTimers().add(timer);
		
		Generator generator = new Generator();
		generator.clearGenerateManager();
		generator.addGenerateManager(new CommonGenerateManager());
		generator.addGenerateManager(new CXXGenerateManager());

		List<GeneratedResult> result = generator.generateTemplateCodeROS(genParam);

		String resourceDir = rootPath + "/resource/ROS/eval3_service_client_cpp_pkg/";

		checkCode(result, resourceDir, "README.md");
		checkCode(result, resourceDir, "package.xml");
		checkCode(result, resourceDir, "CMakeLists.txt");
//		checkCode(result, resourceDir, "LICENSE");
		checkCode(result, resourceDir, "config/params.yaml");
		checkCode(result, resourceDir, "launch/eval3_service_client_node.launch.py");
		checkCode(result, resourceDir, "include/eval3_service_client_cpp_pkg/eval3_service_client_node.hpp");
		checkCode(result, resourceDir, "src/main.cpp");
		checkCode(result, resourceDir, "src/eval3_service_client_node.cpp");
	}
	
	public void testServiceServer() throws Exception {
		rosParam.setPackageName("eval3_service_server_cpp_pkg");
		rosParam.setNodeName("eval3_service_server_node");
		rosParam.setClassName("Eval3ServiceServerNode");
		rosParam.setDescription("C++ service server node with reset and set_bool service servers.");
		rosParam.setVersion("0.0.1");
		rosParam.setMaintainer("rsdlab");
		rosParam.setContactAddress("todo@example.com");
		rosParam.setLicense("BSD-3-Clause");
		
		ServiceParam service01 = new ServiceParam();
		service01.setName("reset");
		service01.setType("std_srvs/srv/Trigger");
		service01.setVarCallbackName("reset_callback");
		service01.setDocDescription("Reset internal state.");
		rosParam.getServiceServers().add(service01);
		
		ServiceParam service02 = new ServiceParam();
		service02.setName("set_bool");
		service02.setType("std_srvs/srv/SetBool");
		service02.setVarCallbackName("set_bool_callback");
		service02.setDocDescription("Accept boolean command for evaluation.");
		rosParam.getServiceServers().add(service02);

		Generator generator = new Generator();
		generator.clearGenerateManager();
		generator.addGenerateManager(new CommonGenerateManager());
		generator.addGenerateManager(new CXXGenerateManager());

		List<GeneratedResult> result = generator.generateTemplateCodeROS(genParam);

		String resourceDir = rootPath + "/resource/ROS/eval3_service_server_cpp_pkg/";

		checkCode(result, resourceDir, "README.md");
		checkCode(result, resourceDir, "package.xml");
		checkCode(result, resourceDir, "CMakeLists.txt");
//		checkCode(result, resourceDir, "LICENSE");
		checkCode(result, resourceDir, "config/params.yaml");
		checkCode(result, resourceDir, "launch/eval3_service_server_node.launch.py");
		checkCode(result, resourceDir, "include/eval3_service_server_cpp_pkg/eval3_service_server_node.hpp");
		checkCode(result, resourceDir, "src/main.cpp");
		checkCode(result, resourceDir, "src/eval3_service_server_node.cpp");
	}
	
	public void testActionClient() throws Exception {
		rosParam.setPackageName("eval4_action_client_cpp_pkg");
		rosParam.setNodeName("eval4_action_client_node");
		rosParam.setClassName("Eval4ActionClientNode");
		rosParam.setDescription("C++ action client node that sends Fibonacci goals periodically.");
		rosParam.setVersion("0.0.1");
		rosParam.setMaintainer("rsdlab");
		rosParam.setContactAddress("todo@example.com");
		rosParam.setLicense("Proprietary");
		
		ActionParam action = new ActionParam();
		action.setName("fibonacci");
		action.setType("example_interfaces/action/Fibonacci");
		action.setCallbackName("send_fibonacci_goal");
		action.setDocDescription("Send Fibonacci goal for evaluation.");
		rosParam.getActionClients().add(action);

		TimerParam timer = new TimerParam();
		timer.setName("action_goal_timer");
		timer.setRate(3.0);
		timer.setCallBack("action_goal_timer_callback");
		timer.setDescription("Send action goal periodically.");
		rosParam.getTimers().add(timer);
		
		Generator generator = new Generator();
		generator.clearGenerateManager();
		generator.addGenerateManager(new CommonGenerateManager());
		generator.addGenerateManager(new CXXGenerateManager());

		List<GeneratedResult> result = generator.generateTemplateCodeROS(genParam);

		String resourceDir = rootPath + "/resource/ROS/eval4_action_client_cpp_pkg/";

		checkCode(result, resourceDir, "README.md");
		checkCode(result, resourceDir, "package.xml");
		checkCode(result, resourceDir, "CMakeLists.txt");
//		checkCode(result, resourceDir, "LICENSE");
		checkCode(result, resourceDir, "config/params.yaml");
		checkCode(result, resourceDir, "launch/eval4_action_client_node.launch.py");
		checkCode(result, resourceDir, "include/eval4_action_client_cpp_pkg/eval4_action_client_node.hpp");
		checkCode(result, resourceDir, "src/main.cpp");
		checkCode(result, resourceDir, "src/eval4_action_client_node.cpp");
	}
	
	public void testActionServer() throws Exception {
		rosParam.setPackageName("eval4_action_server_cpp_pkg");
		rosParam.setNodeName("eval4_action_server_node");
		rosParam.setClassName("Eval4ActionServerNode");
		rosParam.setDescription("C++ action server node using example_interfaces Fibonacci action.");
		rosParam.setVersion("0.0.1");
		rosParam.setMaintainer("rsdlab");
		rosParam.setContactAddress("todo@example.com");
		rosParam.setLicense("Proprietary");
		
		ActionParam action = new ActionParam();
		action.setName("fibonacci");
		action.setType("example_interfaces/action/Fibonacci");
		action.setCallbackName("fibonacci");
		action.setDocDescription("Execute Fibonacci action goals.");
		rosParam.getActionServers().add(action);

		Generator generator = new Generator();
		generator.clearGenerateManager();
		generator.addGenerateManager(new CommonGenerateManager());
		generator.addGenerateManager(new CXXGenerateManager());

		List<GeneratedResult> result = generator.generateTemplateCodeROS(genParam);

		String resourceDir = rootPath + "/resource/ROS/eval4_action_server_cpp_pkg/";

		checkCode(result, resourceDir, "README.md");
		checkCode(result, resourceDir, "package.xml");
		checkCode(result, resourceDir, "CMakeLists.txt");
//		checkCode(result, resourceDir, "LICENSE");
		checkCode(result, resourceDir, "config/params.yaml");
		checkCode(result, resourceDir, "launch/eval4_action_server_node.launch.py");
		checkCode(result, resourceDir, "include/eval4_action_server_cpp_pkg/eval4_action_server_node.hpp");
		checkCode(result, resourceDir, "src/main.cpp");
		checkCode(result, resourceDir, "src/eval4_action_server_node.cpp");
	}
	
//	public void testOperator() throws Exception {
//		rosParam.setPackageName("eval5_operator_cpp_pkg");
//		rosParam.setNodeName("eval5_operator_node");
//		rosParam.setClassName("Eval5OperatorNode");
//		rosParam.setDescription("C++ operator-side all-in-one sample node that communicates with the robot-side node.");
//		rosParam.setVersion("0.0.1");
//		rosParam.setMaintainer("rsdlab");
//		rosParam.setContactAddress("todo@example.com");
//		rosParam.setLicense("LGPL-3.0");
//		
//		TopicParam topic1 = new TopicParam();
//		topic1.setName("cmd_vel");
//		topic1.setMessageType("geometry_msgs/msg/Twist");
//		topic1.setReliabilityType("Reliable");
//		topic1.setHistoryType("Keep Last");
//		topic1.setDepth(10);
//		topic1.setVarCallbackName("cmd_vel_pub");
//		topic1.setDocDescription("Publish velocity command.");
//		rosParam.getTopicPublishes().add(topic1);
//
//		TopicParam topic2 = new TopicParam();
//		topic2.setName("robot_status");
//		topic2.setMessageType("std_msgs/msg/String");
//		topic2.setVarCallbackName("robot_status_callback");
//		topic2.setReliabilityType("Reliable");
//		topic2.setHistoryType("Keep Last");
//		topic2.setDepth(10);
//		topic2.setDocDescription("Receive robot status.");
//		rosParam.getTopicSubscribes().add(topic2);
//		
//		ServiceParam service = new ServiceParam();
//		service.setName("set_mode");
//		service.setType("SetMode.srv");
//		service.setVarCallbackName("call_set_mode");
//		service.setDocDescription("Request robot operation mode.");
//		rosParam.getServiceClients().add(service);
//		
//		ActionParam action = new ActionParam();
//		action.setName("move_to_target");
//		action.setType("MoveToTarget.action");
//		action.setCallbackName("send_move_to_target_goal");
//		action.setDocDescription("Send move target goal.");
//		rosParam.getActionClients().add(action);
//		
//		TimerParam timer = new TimerParam();
//		timer.setName("command_timer");
//		timer.setRate(1.0);
//		timer.setCallBack("command_timer_callback");
//		timer.setDescription("Send commands periodically.");
//		rosParam.getTimers().add(timer);
//		
//		ParameterParam param = new ParameterParam();
//		param.setName("command_speed");
//		param.setType("double");
//		param.setDefaultValue("0.5");
//		param.setDocDescription("Commanded linear speed.");
//		rosParam.getParameters().add(param);
//		
//		PackageParam pack1 = new PackageParam();
//		pack1.setName("geometry_msgs");
//		rosParam.getTargetEnv().getLibraries().add(pack1);
//		
//		PackageParam pack2 = new PackageParam();
//		pack2.setName("std_msgs");
//		rosParam.getTargetEnv().getLibraries().add(pack2);
//
//		Generator generator = new Generator();
//		generator.clearGenerateManager();
//		generator.addGenerateManager(new CommonGenerateManager());
//		generator.addGenerateManager(new CXXGenerateManager());
//
//		List<GeneratedResult> result = generator.generateTemplateCodeROS(genParam);
//
//		String resourceDir = rootPath + "/resource/ROS/eval5_operator_cpp_pkg/";
//
////		checkCode(result, resourceDir, "README.md");
////		checkCode(result, resourceDir, "package.xml");
//		checkCode(result, resourceDir, "CMakeLists.txt");
////		checkCode(result, resourceDir, "LICENSE");
//		checkCode(result, resourceDir, "config/params.yaml");
//		checkCode(result, resourceDir, "launch/eval5_operator_node.launch.py");
//		checkCode(result, resourceDir, "include/eval5_operator_cpp_pkg/eval5_operator_node.hpp");
//		checkCode(result, resourceDir, "src/main.cpp");
//		checkCode(result, resourceDir, "src/eval5_operator_node.cpp");
//	}
}
