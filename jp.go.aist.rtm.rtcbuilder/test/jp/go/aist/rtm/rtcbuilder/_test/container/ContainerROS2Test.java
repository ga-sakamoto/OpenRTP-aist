package jp.go.aist.rtm.rtcbuilder._test.container;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;

import com.fasterxml.jackson.databind.ObjectMapper;

import jp.go.aist.rtm.rtcbuilder.Generator;
import jp.go.aist.rtm.rtcbuilder.IRtcBuilderConstants;
import jp.go.aist.rtm.rtcbuilder._test.TestBase;
import jp.go.aist.rtm.rtcbuilder.container.param.ContainerParam;
import jp.go.aist.rtm.rtcbuilder.container.param.LibraryParam;
import jp.go.aist.rtm.rtcbuilder.container.param.RepositoryParam;
import jp.go.aist.rtm.rtcbuilder.container.param.setting.ContainerConfig;
import jp.go.aist.rtm.rtcbuilder.generator.GeneratedResult;
import jp.go.aist.rtm.rtcbuilder.generator.param.GeneratorParam;
import jp.go.aist.rtm.rtcbuilder.generator.param.RtcParam;
import jp.go.aist.rtm.rtcbuilder.ros.manager.ContainerGenerateManager;

public class ContainerROS2Test extends TestBase {

	RtcParam rtcParam;
	GeneratorParam genParam;
	ContainerConfig containerConfig;

	@Before
	protected void setUp() throws Exception {
		genParam = new GeneratorParam();
		rtcParam = new RtcParam(genParam, true);
		rtcParam.setOutputProject(rootPath + "/resource/work");
		rtcParam.setLanguage(IRtcBuilderConstants.LANG_CPP);
		rtcParam.setLanguageArg(IRtcBuilderConstants.LANG_CPP_ARG);
		rtcParam.setRtmVersion("1.0.0");
		rtcParam.setIsTest(true);
		genParam.setRtcParam(rtcParam);
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			byte[] bytes = Files.readAllBytes(Paths.get(rootPath + "/resource/rosbuilder_config.json"));
			String content = new String(bytes, StandardCharsets.UTF_8);
			
			containerConfig = mapper.readValue(content, ContainerConfig.class);
			rtcParam.setContainerConfig(containerConfig);
		} catch (Exception ex) {
			int a = 0;
		}
	}
	
	private void createLibraries(ContainerParam param, List<String> libraries, String installer) {
		for(String each : libraries) {
			LibraryParam lib01 = new LibraryParam();
			lib01.setName(each);
			lib01.setInstaller(installer);
			param.getLibraries().add(lib01);
		}
	}

	public void testCranePlusMinCpp() throws Exception {
		rtcParam.setName("crane_plus");
		rtcParam.setDescription("CRANE+ V2ロボット用のROS 2パッケージスイート。制御、記述、シミュレーション、およびMoveIt!設定ファイルが含まれています。");
		rtcParam.setVersion("1.0.1");
		rtcParam.setVender("Shota Aoki, Atsushi Kuwagata, Yusuke Kato");
		rtcParam.setCategory("Sample");
		
		ContainerParam param = new ContainerParam();
		param.setMiddleware("ROS 2");
		param.setMdlVersion("Jazzy");
		param.setOsVersion("Ubuntu 24.04");
		param.setWorkspace("colcon_ws");
		param.setLanguage("C++");
		param.setConfiguration("Min");
		param.updateDefaultLibs(containerConfig);
		rtcParam.getContainerSettings().add(param);
		/////
		List<String> libraries = Arrays.asList(
				"rclcpp", 
				"pluginlib", 
				"controller_manager", 
				"hardware_interface", 
				"ros2_control", 
				"ros2_controllers", 
				"ros2controlcli", 
				"gazebo_ros2_control", 
				"ign_ros2_control", 
				"gz_ros2_control", 
				"dynamixel_sdk", 
				"gripper_controllers", 
				"ros_gz", 
				"ros_gz_bridge", 
				"ros_gz_sim", 
				"gazebo_ros_pkgs", 
				"moveit_kinematics", 
				"moveit_planners", 
				"moveit_simple_controller_manager", 
				"moveit_configs_utils", 
				"moveit_ros_move_group", 
				"moveit_ros_visualization", 
				"moveit_ros_warehouse", 
				"moveit_setup_assistant", 
				"moveit_ros_planning_interface", 
				"moveit_core", 
				"tf2", 
				"tf2_ros", 
				"tf2_geometry_msgs", 
				"geometry_msgs", 
				"joint_state_publisher", 
				"joint_state_publisher_gui", 
				"robot_state_publisher", 
				"xacro", 
				"rviz2", 
				"rviz_common", 
				"rviz_default_plugins", 
				"opencv2", 
				"cv_bridge", 
				"image_geometry", 
				"usb_cam", 
				"vision_opencv"
				);
		createLibraries(param, libraries, "apt");
		/////
		RepositoryParam rep2 = new RepositoryParam();
		rep2.setURL("https://github.com/rt-net/crane_plus.git");
		rep2.setBranch("jazzy");
		param.getRepositories().add(rep2);

		RepositoryParam rep3 = new RepositoryParam();
		rep3.setURL("https://github.com/ROBOTIS-GIT/DynamixelSDK.git");
		rep3.setBranch("main");
		param.getRepositories().add(rep3);
		
		Generator generator = new Generator();
		generator.clearGenerateManager();
		generator.addGenerateManager(new ContainerGenerateManager());
		List<GeneratedResult> result = generator.generateTemplateCode(genParam);

		String resourceDir = rootPath + "/resource/scripts/ROS/";
		checkCode(result, resourceDir, "crane_plus__Ubuntu-24.04__ROS2-jazzy__cpp_Min.Dockerfile");
	}
	
	public void testCranePlusFullCpp() throws Exception {
		rtcParam.setName("crane_plus");
		rtcParam.setDescription("CRANE+ V2ロボット用のROS 2パッケージスイート。制御、記述、シミュレーション、およびMoveIt!設定ファイルが含まれています。");
		rtcParam.setVersion("1.0.1");
		rtcParam.setVender("Shota Aoki, Atsushi Kuwagata, Yusuke Kato");
		rtcParam.setCategory("Sample");
		
		ContainerParam param = new ContainerParam();
		param.setMiddleware("ROS 2");
		param.setMdlVersion("Jazzy");
		param.setOsVersion("Ubuntu 24.04");
		param.setWorkspace("colcon_ws");
		param.setLanguage("C++");
		param.setConfiguration("Full");
		param.updateDefaultLibs(containerConfig);
		rtcParam.getContainerSettings().add(param);
		/////
		List<String> libraries = Arrays.asList(
				"rclcpp", 
				"pluginlib", 
				"controller_manager", 
				"hardware_interface", 
				"ros2_control", 
				"ros2_controllers", 
				"ros2controlcli", 
				"gazebo_ros2_control", 
				"ign_ros2_control", 
				"gz_ros2_control", 
				"dynamixel_sdk", 
				"gripper_controllers", 
				"ros_gz", 
				"ros_gz_bridge", 
				"ros_gz_sim", 
				"gazebo_ros_pkgs", 
				"moveit_kinematics", 
				"moveit_planners", 
				"moveit_simple_controller_manager", 
				"moveit_configs_utils", 
				"moveit_ros_move_group", 
				"moveit_ros_visualization", 
				"moveit_ros_warehouse", 
				"moveit_setup_assistant", 
				"moveit_ros_planning_interface", 
				"moveit_core", 
				"tf2", 
				"tf2_ros", 
				"tf2_geometry_msgs", 
				"geometry_msgs", 
				"joint_state_publisher", 
				"joint_state_publisher_gui", 
				"robot_state_publisher", 
				"xacro", 
				"rviz2", 
				"rviz_common", 
				"rviz_default_plugins", 
				"opencv2", 
				"cv_bridge", 
				"image_geometry", 
				"usb_cam", 
				"vision_opencv"
				);
		createLibraries(param, libraries, "apt");
		/////
		RepositoryParam rep2 = new RepositoryParam();
		rep2.setURL("https://github.com/rt-net/crane_plus.git");
		rep2.setBranch("jazzy");
		param.getRepositories().add(rep2);

		RepositoryParam rep3 = new RepositoryParam();
		rep3.setURL("https://github.com/ROBOTIS-GIT/DynamixelSDK.git");
		rep3.setBranch("main");
		param.getRepositories().add(rep3);
		
		Generator generator = new Generator();
		generator.clearGenerateManager();
		generator.addGenerateManager(new ContainerGenerateManager());
		List<GeneratedResult> result = generator.generateTemplateCode(genParam);

		String resourceDir = rootPath + "/resource/scripts/ROS/";
		checkCode(result, resourceDir, "crane_plus__Ubuntu-24.04__ROS2-jazzy__cpp_Full.Dockerfile");
	}
	
	public void testMinimalPublisherCpp() throws Exception {
		rtcParam.setName("ros2_minimal_publisher_cpp");
		rtcParam.setDescription("ROS 2公式examplesのJazzy C++ Minimal Publisherビルドサンプル。");
		rtcParam.setVersion("1.0.1");
		rtcParam.setVender("ROS 2 examples maintainers");
		rtcParam.setCategory("Sample");
		
		ContainerParam param = new ContainerParam();
		param.setMiddleware("ROS 2");
		param.setMdlVersion("Jazzy");
		param.setOsVersion("Ubuntu 24.04");
		param.setWorkspace("colcon_ws");
		param.setLanguage("C++");
		param.setConfiguration("Min");
		param.updateDefaultLibs(containerConfig);
		rtcParam.getContainerSettings().add(param);
		/////
		/////
		RepositoryParam rep2 = new RepositoryParam();
		rep2.setURL("https://github.com/ros2/examples.git");
		rep2.setBranch("jazzy");
		param.getRepositories().add(rep2);

		Generator generator = new Generator();
		generator.clearGenerateManager();
		generator.addGenerateManager(new ContainerGenerateManager());
		List<GeneratedResult> result = generator.generateTemplateCode(genParam);

		String resourceDir = rootPath + "/resource/scripts/ROS/";
		checkCode(result, resourceDir, "ros2_minimal_publisher_cpp__Ubuntu-24.04__ROS2-jazzy__cpp_Min.Dockerfile");
	}
	
	public void testMinimalPublisherPython() throws Exception {
		rtcParam.setName("ros2_minimal_publisher_python");
		rtcParam.setDescription("ROS 2公式examplesのJazzy Python Minimal Publisherビルドサンプル。");
		rtcParam.setVersion("1.0.1");
		rtcParam.setVender("ROS 2 examples maintainers");
		rtcParam.setCategory("Sample");
		
		ContainerParam param = new ContainerParam();
		param.setMiddleware("ROS 2");
		param.setMdlVersion("Jazzy");
		param.setOsVersion("Ubuntu 24.04");
		param.setWorkspace("colcon_ws");
		param.setLanguage("Python");
		param.setConfiguration("Min");
		param.updateDefaultLibs(containerConfig);
		rtcParam.getContainerSettings().add(param);
		/////
		List<String> libraries = Arrays.asList(
				"python3-setuptools"
				);
		createLibraries(param, libraries, "apt");
		/////
		RepositoryParam rep2 = new RepositoryParam();
		rep2.setURL("https://github.com/ros2/examples.git");
		rep2.setBranch("jazzy");
		param.getRepositories().add(rep2);

		Generator generator = new Generator();
		generator.clearGenerateManager();
		generator.addGenerateManager(new ContainerGenerateManager());
		List<GeneratedResult> result = generator.generateTemplateCode(genParam);

		String resourceDir = rootPath + "/resource/scripts/ROS/";
		checkCode(result, resourceDir, "ros2_minimal_publisher_python__Ubuntu-24.04__ROS2-jazzy__python_Min.Dockerfile");
	}
	
	public void testManualPython() throws Exception {
		rtcParam.setName("ros2_manual_apt_pip");
		rtcParam.setDescription("ROS 2 Jazzy Python sample that installs JSON-unknown jq and packaging libraries through manually selected apt and pip Installers.");
		rtcParam.setVersion("1.0.1");
		rtcParam.setVender("ROS 2 examples maintainers");
		rtcParam.setCategory("Sample");
		
		ContainerParam param = new ContainerParam();
		param.setMiddleware("ROS 2");
		param.setMdlVersion("Jazzy");
		param.setOsVersion("Ubuntu 24.04");
		param.setWorkspace("colcon_ws");
		param.setLanguage("Python");
		param.setConfiguration("Min");
		param.updateDefaultLibs(containerConfig);
		rtcParam.getContainerSettings().add(param);
		/////
		List<String> libraries = Arrays.asList(
				"python3-setuptools",
				"jq"
				);
		createLibraries(param, libraries, "apt");

		LibraryParam lib02 = new LibraryParam();
		lib02.setName("packaging");
		lib02.setInstaller("pip");
		param.getLibraries().add(lib02);
		/////
		Generator generator = new Generator();
		generator.clearGenerateManager();
		generator.addGenerateManager(new ContainerGenerateManager());
		List<GeneratedResult> result = generator.generateTemplateCode(genParam);

		String resourceDir = rootPath + "/resource/scripts/ROS/";
		checkCode(result, resourceDir, "ros2_manual_apt_pip__Ubuntu-24.04__ROS2-jazzy__python_Min.Dockerfile");
	}
}
