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

public class ContainerROS1PythonTest extends TestBase {

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

	public void testTeleopMin() throws Exception {
		rtcParam.setName("teleop_keyboard_ros1");
		rtcParam.setDescription("Generic Keyboard Teleop for ROS 1");
		rtcParam.setVersion("1.0.1");
		rtcParam.setVender("Austin Hendrix");
		rtcParam.setCategory("Sample");
		
		ContainerParam param = new ContainerParam();
		param.setMiddleware("ROS 1");
		param.setMdlVersion("Noetic");
		param.setOsVersion("Ubuntu 20.04 (Focal)");
		param.setWorkspace("catkin_ws");
		param.setLanguage("Python");
		param.setConfiguration("Min");
		rtcParam.getContainerSettings().add(param);
		/////
		List<String> libraries = Arrays.asList(
				"rospy", 
				"geometry_msgs"
				);
		createLibraries(param, libraries);
		/////
		RepositoryParam rep1 = new RepositoryParam();
		rep1.setURL("https://github.com/ros-teleop/teleop_twist_keyboard.git");
		rep1.setBranch("master");
		param.getRepositories().add(rep1);
		
		Generator generator = new Generator();
		List<GeneratedResult> result = generator.generateTemplateCode(genParam);

		String resourceDir = rootPath + "/resource/";
		checkCode(result, resourceDir, "scripts/teleop_keyboard_ros1__Ubuntu-20.04__ROS1-noetic__python_Min.Dockerfile");
	}
	
	public void testTeleopFull() throws Exception {
		rtcParam.setName("teleop_keyboard_ros1");
		rtcParam.setDescription("Generic Keyboard Teleop for ROS 1");
		rtcParam.setVersion("1.0.1");
		rtcParam.setVender("Austin Hendrix");
		rtcParam.setCategory("Sample");
		
		ContainerParam param = new ContainerParam();
		param.setMiddleware("ROS 1");
		param.setMdlVersion("Noetic");
		param.setOsVersion("Ubuntu 20.04 (Focal)");
		param.setWorkspace("catkin_ws");
		param.setLanguage("Python");
		param.setConfiguration("Full");
		rtcParam.getContainerSettings().add(param);
		/////
		List<String> libraries = Arrays.asList(
				"rospy", 
				"geometry_msgs"
				);
		createLibraries(param, libraries);
		/////
		RepositoryParam rep1 = new RepositoryParam();
		rep1.setURL("https://github.com/ros-teleop/teleop_twist_keyboard.git");
		rep1.setBranch("master");
		param.getRepositories().add(rep1);
		
		Generator generator = new Generator();
		List<GeneratedResult> result = generator.generateTemplateCode(genParam);

		String resourceDir = rootPath + "/resource/";
		checkCode(result, resourceDir, "scripts/teleop_keyboard_ros1__Ubuntu-20.04__ROS1-noetic__python_Full.Dockerfile");
	}
	
	public void testTurtlebot3Min() throws Exception {
		rtcParam.setName("turtlebot3_sim_ros1");
		rtcParam.setDescription("TurtleBot3 Simulations for ROS 1");
		rtcParam.setVersion("1.0.1");
		rtcParam.setVender("ROBOTIS");
		rtcParam.setCategory("Sample");
		
		ContainerParam param = new ContainerParam();
		param.setMiddleware("ROS 1");
		param.setMdlVersion("Noetic");
		param.setOsVersion("Ubuntu 20.04 (Focal)");
		param.setWorkspace("catkin_ws");
		param.setLanguage("Python");
		param.setConfiguration("Min");
		rtcParam.getContainerSettings().add(param);
		/////
		List<String> libraries = Arrays.asList(
				"rospy", 
				"gazebo_ros", 
				"gazebo_plugins", 
				"xacro", 
				"tf", 
				"turtlebot3_description", 
				"turtlebot3_msgs", 
				"turtlebot3_teleop", 
				"turtlebot3_bringup", 
				"rviz" 
				);
		createLibraries(param, libraries);
		/////
		RepositoryParam rep1 = new RepositoryParam();
		rep1.setURL("https://github.com/ROBOTIS-GIT/turtlebot3_simulations.git");
		rep1.setBranch("noetic");
		param.getRepositories().add(rep1);
		
		Generator generator = new Generator();
		List<GeneratedResult> result = generator.generateTemplateCode(genParam);

		String resourceDir = rootPath + "/resource/";
		checkCode(result, resourceDir, "scripts/turtlebot3_sim_ros1__Ubuntu-20.04__ROS1-noetic__python_Min.Dockerfile");
	}
	
	public void testTurtlebot3Full() throws Exception {
		rtcParam.setName("turtlebot3_sim_ros1");
		rtcParam.setDescription("TurtleBot3 Simulations for ROS 1");
		rtcParam.setVersion("1.0.1");
		rtcParam.setVender("ROBOTIS");
		rtcParam.setCategory("Sample");
		
		ContainerParam param = new ContainerParam();
		param.setMiddleware("ROS 1");
		param.setMdlVersion("Noetic");
		param.setOsVersion("Ubuntu 20.04 (Focal)");
		param.setWorkspace("catkin_ws");
		param.setLanguage("Python");
		param.setConfiguration("Full");
		rtcParam.getContainerSettings().add(param);
		/////
		List<String> libraries = Arrays.asList(
				"rospy", 
				"gazebo_ros", 
				"gazebo_plugins", 
				"xacro", 
				"tf", 
				"turtlebot3_description", 
				"turtlebot3_msgs", 
				"turtlebot3_teleop", 
				"turtlebot3_bringup", 
				"rviz" 
				);
		createLibraries(param, libraries);
		/////
		RepositoryParam rep1 = new RepositoryParam();
		rep1.setURL("https://github.com/ROBOTIS-GIT/turtlebot3_simulations.git");
		rep1.setBranch("noetic");
		param.getRepositories().add(rep1);
		
		Generator generator = new Generator();
		List<GeneratedResult> result = generator.generateTemplateCode(genParam);

		String resourceDir = rootPath + "/resource/";
		checkCode(result, resourceDir, "scripts/turtlebot3_sim_ros1__Ubuntu-20.04__ROS1-noetic__python_Full.Dockerfile");
	}
	
	public void testImagePipleineMin() throws Exception {
		rtcParam.setName("image_pipeline_ros1");
		rtcParam.setDescription("ROS 1 image_pipeline package. Includes camera_calibration (Python) and image_proc (C++).");
		rtcParam.setVersion("1.0.1");
		rtcParam.setVender("Open Robotics");
		rtcParam.setCategory("Sample");
		
		ContainerParam param = new ContainerParam();
		param.setMiddleware("ROS 1");
		param.setMdlVersion("Noetic");
		param.setOsVersion("Ubuntu 20.04 (Focal)");
		param.setWorkspace("catkin_ws");
		param.setLanguage("Python");
		param.setConfiguration("Min");
		rtcParam.getContainerSettings().add(param);
		/////
		List<String> libraries = Arrays.asList(
				"cv_bridge", 
				"image_geometry", 
				"rospy", 
				"std_msgs", 
				"sensor_msgs", 
				"image_transport", 
				"camera_info_manager", 
				"camera_calibration_parsers", 
				"eigen_conversions", 
				"tf2", 
				"tf2_ros", 
				"tf2_geometry_msgs", 
				"opencv2", 
				"imutils" 
				);
		createLibraries(param, libraries);
		/////
		RepositoryParam rep1 = new RepositoryParam();
		rep1.setURL("https://github.com/ros-perception/image_pipeline.git");
		rep1.setBranch("noetic");
		param.getRepositories().add(rep1);
		
		Generator generator = new Generator();
		List<GeneratedResult> result = generator.generateTemplateCode(genParam);

		String resourceDir = rootPath + "/resource/";
		checkCode(result, resourceDir, "scripts/image_pipeline_ros1__Ubuntu-20.04__ROS1-noetic__python_Min.Dockerfile");
	}
	
	public void testImagePipleineFull() throws Exception {
		rtcParam.setName("image_pipeline_ros1");
		rtcParam.setDescription("ROS 1 image_pipeline package. Includes camera_calibration (Python) and image_proc (C++).");
		rtcParam.setVersion("1.0.1");
		rtcParam.setVender("Open Robotics");
		rtcParam.setCategory("Sample");
		
		ContainerParam param = new ContainerParam();
		param.setMiddleware("ROS 1");
		param.setMdlVersion("Noetic");
		param.setOsVersion("Ubuntu 20.04 (Focal)");
		param.setWorkspace("catkin_ws");
		param.setLanguage("Python");
		param.setConfiguration("Full");
		rtcParam.getContainerSettings().add(param);
		/////
		List<String> libraries = Arrays.asList(
				"cv_bridge", 
				"image_geometry", 
				"rospy", 
				"std_msgs", 
				"sensor_msgs", 
				"image_transport", 
				"camera_info_manager", 
				"camera_calibration_parsers", 
				"eigen_conversions", 
				"tf2", 
				"tf2_ros", 
				"tf2_geometry_msgs", 
				"opencv2", 
				"imutils" 
				);
		createLibraries(param, libraries);
		/////
		RepositoryParam rep1 = new RepositoryParam();
		rep1.setURL("https://github.com/ros-perception/image_pipeline.git");
		rep1.setBranch("noetic");
		param.getRepositories().add(rep1);
		
		Generator generator = new Generator();
		List<GeneratedResult> result = generator.generateTemplateCode(genParam);

		String resourceDir = rootPath + "/resource/";
		checkCode(result, resourceDir, "scripts/image_pipeline_ros1__Ubuntu-20.04__ROS1-noetic__python_Full.Dockerfile");
	}
}
