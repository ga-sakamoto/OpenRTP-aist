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

public class ContainerROS1CppTest extends TestBase {

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
			byte[] bytes = Files.readAllBytes(Paths.get(rootPath + "/resource/config.json"));
			String content = new String(bytes, StandardCharsets.UTF_8);
			
			containerConfig = mapper.readValue(content, ContainerConfig.class);
			rtcParam.setContainerConfig(containerConfig);
		} catch (Exception ex) {
			int a = 0;
		}
	}
	
	private void createLibraries(ContainerParam param, List<String> libraries) {
		for(String each : libraries) {
			LibraryParam lib01 = new LibraryParam();
			lib01.setName(each);
			param.getLibraries().add(lib01);
		}
	}

	public void testMikataArmMin() throws Exception {
		rtcParam.setName("MikataArm");
		rtcParam.setDescription("既存のMikataArmパッケージで見つかったMoveIt!との統合問題を解決したROS対応OpenManipulatorであり、実機環境とシミュレーション環境の両方でシームレスな操作を可能にするオープンロボットプラットフォームです。");
		rtcParam.setVersion("1.0.1");
		rtcParam.setVender("Darby Lim, Hye-Jong KIM, Ryan Shim, Yong-Ho Na");
		rtcParam.setCategory("Sample");
		
		ContainerParam param = new ContainerParam();
		param.setMiddleware("ROS 1");
		param.setMdlVersion("Noetic");
		param.setOsVersion("Ubuntu 20.04 (Focal)");
		param.setWorkspace("catkin_ws");
		param.setLanguage("C++");
		param.setConfiguration("Min");
		rtcParam.getContainerSettings().add(param);
		/////
		List<String> libraries = Arrays.asList(
				"actionlib", 
				"moveit_core", 
				"moveit_ros_planning", 
				"moveit_ros_planning_interface",  
				"robotis_manipulator",  
				"dynamixel_workbench_toolbox",  
				"cmake_modules", 
				"moveit", 
				"joint_state_publisher_gui", 
				"rviz", 
				"robot_state_publisher", 
				"xacro", 
				"gazebo_ros_pkgs", 
				"gazebo_ros_control", 
				"boost", 
				"eigen", 
				"urdf"  
				);
		createLibraries(param, libraries);
		/////
		RepositoryParam rep1 = new RepositoryParam();
		rep1.setURL("https://github.com/ROBOTIS-GIT/DynamixelSDK.git");
		rep1.setBranch("noetic");
		param.getRepositories().add(rep1);
		
		RepositoryParam rep2 = new RepositoryParam();
		rep2.setURL("https://github.com/ROBOTIS-GIT/dynamixel-workbench.git");
		rep2.setBranch("noetic");
		param.getRepositories().add(rep2);

		RepositoryParam rep3 = new RepositoryParam();
		rep3.setURL("https://github.com/ROBOTIS-GIT/dynamixel-workbench-msgs.git");
		rep3.setBranch("noetic");
		param.getRepositories().add(rep3);
		
		RepositoryParam rep4 = new RepositoryParam();
		rep4.setURL("https://github.com/rsdlab/MikataArm.git");
		rep4.setBranch("main");
		param.getRepositories().add(rep4);

		RepositoryParam rep5 = new RepositoryParam();
		rep5.setURL("https://github.com/ROBOTIS-GIT/robotis_manipulator.git");
		rep5.setBranch("main");
		param.getRepositories().add(rep5);

		Generator generator = new Generator();
		List<GeneratedResult> result = generator.generateTemplateCode(genParam);

		String resourceDir = rootPath + "/resource/";
		checkCode(result, resourceDir, "scripts/MikataArm__Ubuntu-20.04__ROS1-noetic__cpp_Min.Dockerfile");
	}
	
	public void testMikataArmFull() throws Exception {
		rtcParam.setName("MikataArm");
		rtcParam.setDescription("既存のMikataArmパッケージで見つかったMoveIt!との統合問題を解決したROS対応OpenManipulatorであり、実機環境とシミュレーション環境の両方でシームレスな操作を可能にするオープンロボットプラットフォームです。");
		rtcParam.setVersion("1.0.1");
		rtcParam.setVender("Darby Lim, Hye-Jong KIM, Ryan Shim, Yong-Ho Na");
		rtcParam.setCategory("Sample");
		
		ContainerParam param = new ContainerParam();
		param.setMiddleware("ROS 1");
		param.setMdlVersion("Noetic");
		param.setOsVersion("Ubuntu 20.04 (Focal)");
		param.setWorkspace("catkin_ws");
		param.setLanguage("C++");
		param.setConfiguration("Full");
		rtcParam.getContainerSettings().add(param);
		/////
		List<String> libraries = Arrays.asList(
				"actionlib", 
				"moveit_core", 
				"moveit_ros_planning", 
				"moveit_ros_planning_interface",  
				"robotis_manipulator",  
				"dynamixel_workbench_toolbox",  
				"cmake_modules", 
				"moveit", 
				"joint_state_publisher_gui", 
				"rviz", 
				"robot_state_publisher", 
				"xacro", 
				"gazebo_ros_pkgs", 
				"gazebo_ros_control", 
				"boost", 
				"eigen", 
				"urdf"  
				);
		createLibraries(param, libraries);
		/////
		RepositoryParam rep1 = new RepositoryParam();
		rep1.setURL("https://github.com/ROBOTIS-GIT/DynamixelSDK.git");
		rep1.setBranch("noetic");
		param.getRepositories().add(rep1);
		
		RepositoryParam rep2 = new RepositoryParam();
		rep2.setURL("https://github.com/ROBOTIS-GIT/dynamixel-workbench.git");
		rep2.setBranch("noetic");
		param.getRepositories().add(rep2);

		RepositoryParam rep3 = new RepositoryParam();
		rep3.setURL("https://github.com/ROBOTIS-GIT/dynamixel-workbench-msgs.git");
		rep3.setBranch("noetic");
		param.getRepositories().add(rep3);
		
		RepositoryParam rep4 = new RepositoryParam();
		rep4.setURL("https://github.com/rsdlab/MikataArm.git");
		rep4.setBranch("main");
		param.getRepositories().add(rep4);

		RepositoryParam rep5 = new RepositoryParam();
		rep5.setURL("https://github.com/ROBOTIS-GIT/robotis_manipulator.git");
		rep5.setBranch("main");
		param.getRepositories().add(rep5);

		Generator generator = new Generator();
		List<GeneratedResult> result = generator.generateTemplateCode(genParam);

		String resourceDir = rootPath + "/resource/";
		checkCode(result, resourceDir, "scripts/MikataArm__Ubuntu-20.04__ROS1-noetic__cpp_Full.Dockerfile");
	}
	
	public void testSeedMin() throws Exception {
		rtcParam.setName("seed_r7_ros_pkg");
		rtcParam.setDescription("SEED-R7ロボットをROS環境で制御・運用するためのメタパッケージです。ロボットのモデル記述、Gazeboシミュレーション、MoveIt!動作計画、ROSナビゲーション、そして実機制御のためのインターフェースとコントローラーなど、複数のサブパッケージから構成されています。");
		rtcParam.setVersion("1.0.1");
		rtcParam.setVender("hi.kondo, Yasuto Shiigi");
		rtcParam.setCategory("Sample");
		
		ContainerParam param = new ContainerParam();
		param.setMiddleware("ROS 1");
		param.setMdlVersion("Noetic");
		param.setOsVersion("Ubuntu 20.04 (Focal)");
		param.setWorkspace("catkin_ws");
		param.setLanguage("C++");
		param.setConfiguration("Min");
		rtcParam.getContainerSettings().add(param);
		/////
		List<String> libraries = Arrays.asList(
				"roscpp", 
				"rospy", 
				"tf", 
				"tf2_ros", 
				"xacro", 
				"pluginlib", 
				"message_generation", 
				"ros_control", 
				"ros_controllers", 
				"controller_manager", 
				"hardware_interface", 
				"transmission_interface", 
				"joint_limits_interface", 
				"joint_trajectory_controller", 
				"joint_state_controller", 
				"control_toolbox", 
				"realtime_tools", 
				"move_base", 
				"amcl", 
				"map_server", 
				"gmapping", 
				"teb_local_planner", 
				"global_planner", 
				"dwa_local_planner", 
				"nav_msgs", 
				"move_base_msgs", 
				"moveit_core", 
				"moveit_ros_planning", 
				"moveit_ros_planning_interface", 
				"moveit_commander", 
				"moveit_simple_controller_manager", 
				"moveit_fake_controller_manager", 
				"moveit_kinematics", 
				"moveit_planners_ompl", 
				"moveit_ros_visualization", 
				"moveit_setup_assistant", 
				"gazebo_ros", 
				"gazebo_plugins", 
				"gazebo_ros_control", 
				"gazebo_ros_pkgs", 
				"rviz", 
				"rviz_plugin_tutorials", 
				"rqt_gui", 
				"teleop_twist_joy", 
				"joy", 
				"urg_node", 
				"smach_ros", 
				"smach_viewer", 
				"robot_state_publisher", 
				"joint_state_publisher", 
				"joint_state_publisher_gui", 
				"std_msgs", 
				"geometry_msgs", 
				"sensor_msgs", 
				"trajectory_msgs", 
				"control_msgs", 
				"boost", 
				"pyserial", 
				"angles" 
				);
		createLibraries(param, libraries);
		/////
		RepositoryParam rep1 = new RepositoryParam();
		rep1.setURL("https://github.com/seed-solutions/seed_smartactuator_sdk.git");
		rep1.setBranch("master");
		param.getRepositories().add(rep1);
		
		RepositoryParam rep2 = new RepositoryParam();
		rep2.setURL("https://github.com/seed-solutions/seed_r7_ros_pkg.git");
		rep2.setBranch("master");
		param.getRepositories().add(rep2);

		Generator generator = new Generator();
		List<GeneratedResult> result = generator.generateTemplateCode(genParam);

		String resourceDir = rootPath + "/resource/";
		checkCode(result, resourceDir, "scripts/seed_r7_ros_pkg__Ubuntu-20.04__ROS1-noetic__cpp_Min.Dockerfile");
	}
	
	public void testSeedFull() throws Exception {
		rtcParam.setName("seed_r7_ros_pkg");
		rtcParam.setDescription("SEED-R7ロボットをROS環境で制御・運用するためのメタパッケージです。ロボットのモデル記述、Gazeboシミュレーション、MoveIt!動作計画、ROSナビゲーション、そして実機制御のためのインターフェースとコントローラーなど、複数のサブパッケージから構成されています。");
		rtcParam.setVersion("1.0.1");
		rtcParam.setVender("hi.kondo, Yasuto Shiigi");
		rtcParam.setCategory("Sample");
		
		ContainerParam param = new ContainerParam();
		param.setMiddleware("ROS 1");
		param.setMdlVersion("Noetic");
		param.setOsVersion("Ubuntu 20.04 (Focal)");
		param.setWorkspace("catkin_ws");
		param.setLanguage("C++");
		param.setConfiguration("Full");
		rtcParam.getContainerSettings().add(param);
		/////
		List<String> libraries = Arrays.asList(
				"roscpp", 
				"rospy", 
				"tf", 
				"tf2_ros", 
				"xacro", 
				"pluginlib", 
				"message_generation", 
				"ros_control", 
				"ros_controllers", 
				"controller_manager", 
				"hardware_interface", 
				"transmission_interface", 
				"joint_limits_interface", 
				"joint_trajectory_controller", 
				"joint_state_controller", 
				"control_toolbox", 
				"realtime_tools", 
				"move_base", 
				"amcl", 
				"map_server", 
				"gmapping", 
				"teb_local_planner", 
				"global_planner", 
				"dwa_local_planner", 
				"nav_msgs", 
				"move_base_msgs", 
				"moveit_core", 
				"moveit_ros_planning", 
				"moveit_ros_planning_interface", 
				"moveit_commander", 
				"moveit_simple_controller_manager", 
				"moveit_fake_controller_manager", 
				"moveit_kinematics", 
				"moveit_planners_ompl", 
				"moveit_ros_visualization", 
				"moveit_setup_assistant", 
				"gazebo_ros", 
				"gazebo_plugins", 
				"gazebo_ros_control", 
				"gazebo_ros_pkgs", 
				"rviz", 
				"rviz_plugin_tutorials", 
				"rqt_gui", 
				"teleop_twist_joy", 
				"joy", 
				"urg_node", 
				"smach_ros", 
				"smach_viewer", 
				"robot_state_publisher", 
				"joint_state_publisher", 
				"joint_state_publisher_gui", 
				"std_msgs", 
				"geometry_msgs", 
				"sensor_msgs", 
				"trajectory_msgs", 
				"control_msgs", 
				"boost", 
				"pyserial", 
				"angles" 
				);
		createLibraries(param, libraries);
		/////
		RepositoryParam rep1 = new RepositoryParam();
		rep1.setURL("https://github.com/seed-solutions/seed_smartactuator_sdk.git");
		rep1.setBranch("master");
		param.getRepositories().add(rep1);
		
		RepositoryParam rep2 = new RepositoryParam();
		rep2.setURL("https://github.com/seed-solutions/seed_r7_ros_pkg.git");
		rep2.setBranch("master");
		param.getRepositories().add(rep2);

		Generator generator = new Generator();
		List<GeneratedResult> result = generator.generateTemplateCode(genParam);

		String resourceDir = rootPath + "/resource/";
		checkCode(result, resourceDir, "scripts/seed_r7_ros_pkg__Ubuntu-20.04__ROS1-noetic__cpp_Full.Dockerfile");
	}
}
