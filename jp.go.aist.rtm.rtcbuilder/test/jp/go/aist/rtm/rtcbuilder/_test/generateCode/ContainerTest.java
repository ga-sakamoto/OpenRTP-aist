package jp.go.aist.rtm.rtcbuilder._test.generateCode;

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

public class ContainerTest extends TestBase {

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
		}
	}
	
	private void createLibraries(ContainerParam param, List<String> libraries) {
		for(String each : libraries) {
			LibraryParam lib01 = new LibraryParam();
			lib01.setName(each);
			param.getLibraries().add(lib01);
		}
	}

	public void testROS01() throws Exception {
//		MikataArm__Ubuntu-20.04__ROS1-noetic__cpp_Min.Dockerfile
		rtcParam.setName("MikataArm");
		rtcParam.setDescription("MikataArm sample");
		rtcParam.setVersion("1.0.1");
		rtcParam.setVender("GA");
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
				"build-essential", "cmake", "cmake_modules", "git", "libboost-all-dev", "eigen",
				"libgl1-mesa-dri", "libgl1-mesa-glx", "mesa-utils", "python3-catkin-tools", "python3-pip",
				"python3-rosdep", "python3-rosinstall", "python3-rosinstall-generator", "python3-wstool", "ros-noetic-actionlib",
				"ros-noetic-dynamixel-workbench-toolbox", "ros-noetic-gazebo-ros-control", "gazebo_ros_pkgs", "ros-noetic-joint-state-publisher-gui", "moveit",
				"moveit_core", "moveit_ros_planning", "moveit_ros_planning_interface", "ros-noetic-robot-state-publisher", "ros-noetic-robotis-manipulator",
				"ros-noetic-rviz", "ros-noetic-urdf", "ros-noetic-xacro", "x11-apps"
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

	public void testROS02() throws Exception {
//		crane_plus__Ubuntu-22.04__ROS2-humble__cpp_Min.Dockerfile
		rtcParam.setName("crane_plus");
		rtcParam.setDescription("crane_plus Sample");
		rtcParam.setVersion("1.0.1");
		rtcParam.setVender("GA");
		rtcParam.setCategory("Sample");
		
		ContainerParam param = new ContainerParam();
		param.setMiddleware("ROS 2");
		param.setMdlVersion("Humble");
		param.setOsVersion("Ubuntu 22.04 (Jammy)");
		param.setWorkspace("colcon_ws");
		param.setLanguage("C++");
		param.setConfiguration("Min");
		rtcParam.getContainerSettings().add(param);
		
		List<String> libraries = Arrays.asList(
				"build-essential", "cmake", "git", "libboost-all-dev", "libgl1-mesa-dri",
				"libgl1-mesa-glx", "opencv2", "udev", "mesa-utils", "python3-colcon-common-extensions",
				"python3-pip", "python3-rosdep", 
				"controller_manager", "cv_bridge", "dynamixel_sdk", "gazebo_ros_pkgs",
				"ros-humble-gazebo-ros2-control", "ros-humble-geometry-msgs", "ros-humble-gripper-controllers", "ros-humble-gz-ros2-control",
				"ros-humble-hardware-interface", "ros-humble-ign-ros2-control",
				"image_geometry",
				"ros-humble-joint-state-publisher", "ros-humble-joint-state-publisher-gui",
				"ros-humble-moveit-configs-utils",
				"moveit_core",
				"ros-humble-moveit-kinematics", "ros-humble-moveit-planners",
				"moveit_ros_move_group", "moveit_ros_planning_interface",
				"ros-humble-moveit-ros-visualization", "ros-humble-moveit-ros-warehouse", "ros-humble-moveit-setup-assistant", "ros-humble-moveit-simple-controller-manager",
				"ros-humble-pluginlib", 
				"rclcpp",
				"ros-humble-robot-state-publisher", "ros-humble-ros-gz",
				"ros_gz_bridge",
				"ros-humble-ros-gz-sim", "ros-humble-ros2-control", "ros-humble-ros2-controllers", "ros-humble-ros2controlcli", "ros-humble-rviz-common",
				"ros-humble-rviz-default-plugins", "ros-humble-rviz2",
				"tf2", "ros-humble-tf2-geometry-msgs", "tf2_ros",
				"ros-humble-usb-cam", "vision_opencv", "ros-humble-xacro", "x11-apps"
				);
		createLibraries(param, libraries);
		/////
		/////
		RepositoryParam rep1 = new RepositoryParam();
		rep1.setURL("https://github.com/rt-net/crane_plus.git");
		rep1.setBranch("humble");
		param.getRepositories().add(rep1);
		
		RepositoryParam rep2 = new RepositoryParam();
		rep2.setURL("https://github.com/ROBOTIS-GIT/DynamixelSDK.git");
		rep2.setBranch("main");
		param.getRepositories().add(rep2);

		Generator generator = new Generator();
		List<GeneratedResult> result = generator.generateTemplateCode(genParam);

		String resourceDir = rootPath + "/resource/";
		checkCode(result, resourceDir, "scripts/crane_plus__Ubuntu-22.04__ROS2-humble__cpp_Min.Dockerfile");
	}
	
	public void testROS03() throws Exception {
//		MikataArm__Ubuntu-20.04__ROS1-noetic__cpp_Full.Dockerfile
		rtcParam.setName("MikataArm");
		rtcParam.setDescription("MikataArm sample 20.04");
		rtcParam.setVersion("1.0.1");
		rtcParam.setVender("GA");
		rtcParam.setCategory("Sample");
		
		ContainerParam param = new ContainerParam();
		param.setMiddleware("ROS 1");
		param.setMdlVersion("Noetic");
		param.setOsVersion("Ubuntu 20.04 (Focal)");
		param.setWorkspace("catkin_ws");
		param.setLanguage("C++");
		param.setConfiguration("Full");
		rtcParam.getContainerSettings().add(param);
		
		List<String> libraries = Arrays.asList(
				"build-essential", "cmake", "git", "libboost-all-dev", "eigen",
				"libgl1-mesa-dri", "libgl1-mesa-glx", "mesa-utils", "python3-catkin-tools", "python3-pip",
				"python3-rosdep", "python3-rosinstall", "python3-rosinstall-generator", "python3-wstool", "ros-noetic-actionlib",
				"cmake_modules", 
				"ros-noetic-dynamixel-workbench-toolbox", "ros-noetic-gazebo-ros-control",
				"gazebo_ros_pkgs", "ros-noetic-joint-state-publisher-gui",
				"moveit", "moveit_core", "moveit_ros_planning", "moveit_ros_planning_interface",
				"ros-noetic-robot-state-publisher", "ros-noetic-robotis-manipulator",
				"ros-noetic-rviz", "ros-noetic-urdf", "ros-noetic-xacro", "x11-apps"
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
	
	public void testROS04() throws Exception {
//		crane_plus__Ubuntu-22.04__ROS2-humble__cpp_Full.Dockerfile
		rtcParam.setName("crane_plus");
		rtcParam.setDescription("crane_plus 22.04 Sample");
		rtcParam.setVersion("1.0.1");
		rtcParam.setVender("GA");
		rtcParam.setCategory("Sample");
		
		ContainerParam param = new ContainerParam();
		param.setMiddleware("ROS 2");
		param.setMdlVersion("Humble");
		param.setOsVersion("Ubuntu 22.04 (Jammy)");
		param.setWorkspace("colcon_ws");
		param.setLanguage("C++");
		param.setConfiguration("Full");
		rtcParam.getContainerSettings().add(param);
		
		List<String> libraries = Arrays.asList(
				"build-essential", "cmake", "git", "libboost-all-dev", "libgl1-mesa-dri",
				"libgl1-mesa-glx", 
				"opencv2",
				"udev", "mesa-utils", "python3-colcon-common-extensions",
				"python3-pip", "python3-rosdep", 
				"controller_manager", "cv_bridge", "dynamixel_sdk", "gazebo_ros_pkgs",
				"ros-humble-gazebo-ros2-control", "ros-humble-geometry-msgs", "ros-humble-gripper-controllers", "ros-humble-gz-ros2-control",
				"ros-humble-hardware-interface", "ros-humble-ign-ros2-control", 
				"image_geometry",
				"ros-humble-joint-state-publisher", "ros-humble-joint-state-publisher-gui",
				"ros-humble-moveit-configs-utils", 
				"moveit_core", "ros-humble-moveit-kinematics", "ros-humble-moveit-planners",
				"moveit_ros_move_group", "moveit_ros_planning_interface",
				"ros-humble-moveit-ros-visualization", "ros-humble-moveit-ros-warehouse", "ros-humble-moveit-setup-assistant", "ros-humble-moveit-simple-controller-manager",
				"ros-humble-pluginlib", 
				"rclcpp",
				"ros-humble-robot-state-publisher", "ros-humble-ros-gz", 
				"ros_gz_bridge",
				"ros-humble-ros-gz-sim", "ros-humble-ros2-control", "ros-humble-ros2-controllers", "ros-humble-ros2controlcli", "ros-humble-rviz-common",
				"ros-humble-rviz-default-plugins", "ros-humble-rviz2", 
				"tf2", "ros-humble-tf2-geometry-msgs", "tf2_ros",
				"ros-humble-usb-cam", "vision_opencv", "ros-humble-xacro", "x11-apps"
				);
		createLibraries(param, libraries);
		/////
		/////
		RepositoryParam rep1 = new RepositoryParam();
		rep1.setURL("https://github.com/rt-net/crane_plus.git");
		rep1.setBranch("humble");
		param.getRepositories().add(rep1);
		
		RepositoryParam rep2 = new RepositoryParam();
		rep2.setURL("https://github.com/ROBOTIS-GIT/DynamixelSDK.git");
		rep2.setBranch("main");
		param.getRepositories().add(rep2);

		Generator generator = new Generator();
		List<GeneratedResult> result = generator.generateTemplateCode(genParam);

		String resourceDir = rootPath + "/resource/";
		checkCode(result, resourceDir, "scripts/crane_plus__Ubuntu-22.04__ROS2-humble__cpp_Full.Dockerfile");
	}
	
	public void testOpenRTM_Cpp01() throws Exception {
//		MikataArmRTC__Ubuntu-20.04__OpenRTM-1.2.0__cpp_Std.Dockerfile
		rtcParam.setName("MikataArmRTC");
		rtcParam.setDescription("MikataArmRTC Sample");
		rtcParam.setVersion("1.0.1");
		rtcParam.setVender("GA");
		rtcParam.setCategory("Sample");
		
		ContainerParam param = new ContainerParam();
		param.setMiddleware("OpenRTM");
		param.setMdlVersion("1.2.0");
		param.setOsVersion("Ubuntu 20.04 (Focal)");
		param.setWorkspace("workspace");
		param.setLanguage("C++");
		param.setConfiguration("Std");
		rtcParam.getContainerSettings().add(param);
		
		List<String> libraries = Arrays.asList(
				"build-essential", "cmake", "doxygen", "git", "libboost-all-dev", "eigen",
				"libomniorb4-dev", "omniidl", "omniorb-nameserver", "openrtm-aist", "python-is-python3",
				"python3-dev", "python3-omniorb", "python3-pip"
				);
		createLibraries(param, libraries);
		/////
		RepositoryParam rep1 = new RepositoryParam();
		rep1.setURL("https://github.com/ogata-lab-admin/MikataArmRTC.git");
		rep1.setBranch("main");
		param.getRepositories().add(rep1);
		
		Generator generator = new Generator();
		List<GeneratedResult> result = generator.generateTemplateCode(genParam);

		String resourceDir = rootPath + "/resource/";
		checkCode(result, resourceDir, "scripts/MikataArmRTC__Ubuntu-20.04__OpenRTM-1.2.0__cpp_Std.Dockerfile");
	}
	
	public void testOpenRTM_Cpp02() throws Exception {
//		MikataArmRTC__Ubuntu-22.04__OpenRTM-1.2.0__cpp_Std.Dockerfile
		rtcParam.setName("MikataArmRTC");
		rtcParam.setDescription("MikataArmRTC 22.04 Sample");
		rtcParam.setVersion("1.0.1");
		rtcParam.setVender("GA");
		rtcParam.setCategory("Sample");
		
		ContainerParam param = new ContainerParam();
		param.setMiddleware("OpenRTM");
		param.setMdlVersion("1.2.0");
		param.setOsVersion("Ubuntu 22.04 (Jammy)");
		param.setWorkspace("workspace2");
		param.setLanguage("C++");
		param.setConfiguration("Std");
		rtcParam.getContainerSettings().add(param);
		
		List<String> libraries = Arrays.asList(
				"build-essential", "cmake", "doxygen", "git", "libboost-all-dev", "eigen",
				"libomniorb4-dev", "omniidl", "omniorb-nameserver", "openrtm-aist", "python-is-python3",
				"python3-dev", "python3-omniorb", "python3-pip"
				);
		createLibraries(param, libraries);
		/////
		RepositoryParam rep1 = new RepositoryParam();
		rep1.setURL("https://github.com/ogata-lab-admin/MikataArmRTC.git");
		rep1.setBranch("main");
		param.getRepositories().add(rep1);
		
		Generator generator = new Generator();
		List<GeneratedResult> result = generator.generateTemplateCode(genParam);

		String resourceDir = rootPath + "/resource/";
		checkCode(result, resourceDir, "scripts/MikataArmRTC__Ubuntu-22.04__OpenRTM-1.2.0__cpp_Std.Dockerfile");
	}
	
	public void testOpenRTM_Cpp03() throws Exception {
//		MikataArmRTC__Ubuntu-18.04__OpenRTM-1.2.0__cpp_Std.Dockerfile
		rtcParam.setName("MikataArmRTC");
		rtcParam.setDescription("MikataArmRTC 18.04 Sample");
		rtcParam.setVersion("1.0.1");
		rtcParam.setVender("GA");
		rtcParam.setCategory("Sample");
		
		ContainerParam param = new ContainerParam();
		param.setMiddleware("OpenRTM");
		param.setMdlVersion("1.2.0");
		param.setOsVersion("Ubuntu 18.04 (Bionic)");
		param.setWorkspace("workspace");
		param.setLanguage("C++");
		param.setConfiguration("Std");
		rtcParam.getContainerSettings().add(param);
		
		List<String> libraries = Arrays.asList(
				"build-essential", "cmake", "doxygen", "git", "libboost-all-dev", "eigen",
				"libomniorb4-dev", "omniidl", "omniorb-nameserver", "openrtm-aist", 
				"python3-dev", "python3-omniorb", "python3-pip"
				);
		createLibraries(param, libraries);
		/////
		RepositoryParam rep1 = new RepositoryParam();
		rep1.setURL("https://github.com/ogata-lab-admin/MikataArmRTC.git");
		rep1.setBranch("main");
		param.getRepositories().add(rep1);
		
		Generator generator = new Generator();
		List<GeneratedResult> result = generator.generateTemplateCode(genParam);

		String resourceDir = rootPath + "/resource/";
		checkCode(result, resourceDir, "scripts/MikataArmRTC__Ubuntu-18.04__OpenRTM-1.2.0__cpp_Std.Dockerfile");
	}
	
	public void testOpenRTM_Python01() throws Exception {
//		pymycobot__Ubuntu-20.04__OpenRTM-1.2.0__python_Std.Dockerfile
		rtcParam.setName("pymycobot");
		rtcParam.setDescription("pymycobot Sample");
		rtcParam.setVersion("1.0.1");
		rtcParam.setVender("GA");
		rtcParam.setCategory("Sample");
		
		ContainerParam param = new ContainerParam();
		param.setMiddleware("OpenRTM");
		param.setMdlVersion("1.2.0");
		param.setOsVersion("Ubuntu 20.04 (Focal)");
		param.setWorkspace("workspace");
		param.setLanguage("Python");
		param.setConfiguration("Std");
		rtcParam.getContainerSettings().add(param);
		
		List<String> libraries = Arrays.asList(
				"build-essential", "cmake", "doxygen", "git", "libboost-all-dev",
				"omniidl", "omniorb-nameserver", "openrtm-aist", "python-is-python3", 
				"python3-dev", "python3-omniorb", "python3-pip"
				);
		createLibraries(param, libraries);
		/////
		RepositoryParam rep1 = new RepositoryParam();
		rep1.setURL("https://github.com/elephantrobotics/pymycobot.git");
		rep1.setBranch("main");
		param.getRepositories().add(rep1);
		
		Generator generator = new Generator();
		List<GeneratedResult> result = generator.generateTemplateCode(genParam);

		String resourceDir = rootPath + "/resource/";
		checkCode(result, resourceDir, "scripts/pymycobot__Ubuntu-20.04__OpenRTM-1.2.0__python_Std.Dockerfile");
	}
	
	public void testOpenRTM_Python02() throws Exception {
//		pymycobot__Ubuntu-22.04__OpenRTM-1.2.0__python_Std.Dockerfile
		rtcParam.setName("pymycobot");
		rtcParam.setDescription("pymycobot 22.04 Sample");
		rtcParam.setVersion("1.0.1");
		rtcParam.setVender("GA");
		rtcParam.setCategory("Sample");
		
		ContainerParam param = new ContainerParam();
		param.setMiddleware("OpenRTM");
		param.setMdlVersion("1.2.0");
		param.setOsVersion("Ubuntu 22.04 (Jammy)");
		param.setWorkspace("workspace2");
		param.setLanguage("Python");
		param.setConfiguration("Std");
		rtcParam.getContainerSettings().add(param);
		
		List<String> libraries = Arrays.asList(
				"build-essential", "cmake", "doxygen", "git", "libboost-all-dev",
				"omniidl", "omniorb-nameserver", "openrtm-aist", "python-is-python3", 
				"python3-dev", "python3-omniorb", "python3-pip"
				);
		createLibraries(param, libraries);
		/////
		RepositoryParam rep1 = new RepositoryParam();
		rep1.setURL("https://github.com/elephantrobotics/pymycobot.git");
		rep1.setBranch("main");
		param.getRepositories().add(rep1);
		
		Generator generator = new Generator();
		List<GeneratedResult> result = generator.generateTemplateCode(genParam);

		String resourceDir = rootPath + "/resource/";
		checkCode(result, resourceDir, "scripts/pymycobot__Ubuntu-22.04__OpenRTM-1.2.0__python_Std.Dockerfile");
	}
	
	public void testOpenRTM_Python03() throws Exception {
//		pymycobot__Ubuntu-18.04__OpenRTM-1.2.0__python_Std.Dockerfile
		rtcParam.setName("pymycobot");
		rtcParam.setDescription("pymycobot 18.04 Sample");
		rtcParam.setVersion("1.0.1");
		rtcParam.setVender("GA");
		rtcParam.setCategory("Sample");
		
		ContainerParam param = new ContainerParam();
		param.setMiddleware("OpenRTM");
		param.setMdlVersion("1.2.0");
		param.setOsVersion("Ubuntu 18.04 (Bionic)");
		param.setWorkspace("workspace");
		param.setLanguage("Python");
		param.setConfiguration("Std");
		rtcParam.getContainerSettings().add(param);
		
		List<String> libraries = Arrays.asList(
				"build-essential", "cmake", "doxygen", "git", "libboost-all-dev",
				"omniidl", "omniorb-nameserver", "openrtm-aist", 
				"python3-dev", "python3-omniorb", "python3-pip", "python3-opencv"
				);
		createLibraries(param, libraries);
		/////
		RepositoryParam rep1 = new RepositoryParam();
		rep1.setURL("https://github.com/elephantrobotics/pymycobot.git");
		rep1.setBranch("main");
		param.getRepositories().add(rep1);
		
		Generator generator = new Generator();
		List<GeneratedResult> result = generator.generateTemplateCode(genParam);

		String resourceDir = rootPath + "/resource/";
		checkCode(result, resourceDir, "scripts/pymycobot__Ubuntu-18.04__OpenRTM-1.2.0__python_Std.Dockerfile");
	}
}
