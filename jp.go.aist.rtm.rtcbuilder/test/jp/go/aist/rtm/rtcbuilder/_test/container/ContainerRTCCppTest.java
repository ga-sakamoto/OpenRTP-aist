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

public class ContainerRTCCppTest extends TestBase {

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

	public void testMikataArmStd() throws Exception {
		rtcParam.setName("MikataArmRTC");
		rtcParam.setDescription("「Mikata Arm」というロボットアームを制御するためのソフトウェアモジュールである");
		rtcParam.setVersion("1.0.1");
		rtcParam.setVender("Ogata Labratory");
		rtcParam.setCategory("Sample");
		
		ContainerParam param = new ContainerParam();
		param.setMiddleware("OpenRTM");
		param.setMdlVersion("1.2.0");
		param.setOsVersion("Ubuntu 18.04 (Bionic)");
		param.setWorkspace("workspace");
		param.setLanguage("C++");
		param.setConfiguration("Std");
		rtcParam.getContainerSettings().add(param);
		/////
		List<String> libraries = Arrays.asList(
				"OpenRTM-aist", 
				"omniORB", 
				"Eigen", 
				"libdynamixel", 
				"libmikataarm", 
				"libaqua" 
				);
		createLibraries(param, libraries);
		/////
		RepositoryParam rep2 = new RepositoryParam();
		rep2.setURL("https://github.com/ogata-lab-admin/MikataArmRTC.git");
		rep2.setBranch("master");
		param.getRepositories().add(rep2);

		Generator generator = new Generator();
		List<GeneratedResult> result = generator.generateTemplateCode(genParam);

		String resourceDir = rootPath + "/resource/";
		checkCode(result, resourceDir, "scripts/MikataArmRTC__Ubuntu-18.04__OpenRTM-1.2.0__cpp_Std.Dockerfile");
	}
	
	public void testCranePlusStd() throws Exception {
		rtcParam.setName("CraneplusRTC");
		rtcParam.setDescription("CraneplusRTC");
		rtcParam.setVersion("1.0.1");
		rtcParam.setVender("rsdlab");
		rtcParam.setCategory("Sample");
		
		ContainerParam param = new ContainerParam();
		param.setMiddleware("OpenRTM");
		param.setMdlVersion("1.2.0");
		param.setOsVersion("Ubuntu 18.04 (Bionic)");
		param.setWorkspace("workspace");
		param.setLanguage("C++");
		param.setConfiguration("Std");
		rtcParam.getContainerSettings().add(param);
		/////
		List<String> libraries = Arrays.asList(
				"OpenRTM-aist", 
				"omniORB", 
				"DynamixelSDK", 
				"boost", 
				"OpenCV" 
				);
		createLibraries(param, libraries);
		/////
		RepositoryParam rep2 = new RepositoryParam();
		rep2.setURL("https://github.com/masahiro0720/CRANEplusRTC_ver2.git");
		rep2.setBranch("main");
		param.getRepositories().add(rep2);

		Generator generator = new Generator();
		List<GeneratedResult> result = generator.generateTemplateCode(genParam);

		String resourceDir = rootPath + "/resource/";
		checkCode(result, resourceDir, "scripts/CraneplusRTC__Ubuntu-18.04__OpenRTM-1.2.0__cpp_Std.Dockerfile");
	}
}
