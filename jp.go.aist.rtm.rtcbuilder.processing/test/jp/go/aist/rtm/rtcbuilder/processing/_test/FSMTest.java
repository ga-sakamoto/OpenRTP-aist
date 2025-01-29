package jp.go.aist.rtm.rtcbuilder.processing._test;

import java.util.List;

import jp.go.aist.rtm.rtcbuilder.Generator;
import jp.go.aist.rtm.rtcbuilder.fsm.ScXMLHandler;
import jp.go.aist.rtm.rtcbuilder.fsm.StateParam;
import jp.go.aist.rtm.rtcbuilder.generator.GeneratedResult;
import jp.go.aist.rtm.rtcbuilder.generator.ProfileHandler;
import jp.go.aist.rtm.rtcbuilder.generator.param.GeneratorParam;
import jp.go.aist.rtm.rtcbuilder.processing.IRtcBuilderConstantsProcessing;
import jp.go.aist.rtm.rtcbuilder.processing.manager.ProcessingGenerateManager;

public class FSMTest extends TestBase {

	protected void setUp() throws Exception {
	}

	private List<GeneratedResult> generateCode(String rtcProfile, String fsmProfile) throws Exception {
		ProfileHandler handler = new ProfileHandler(true);
		handler.addManager(new ProcessingGenerateManager());
		GeneratorParam genParam = handler.restorefromXMLFile(rtcProfile, true);
		genParam.getRtcParam().setLanguage(IRtcBuilderConstantsProcessing.LANG_PROCESSING);
		genParam.getRtcParam().setLanguageArg(IRtcBuilderConstantsProcessing.LANG_PROCESSING_ARG);
		genParam.getRtcParam().setIsTest(true);
		
		ScXMLHandler scHandler = new ScXMLHandler();
		StringBuffer buffer = new StringBuffer();
		StateParam rootState = scHandler.parseSCXML(fsmProfile, buffer);
		if(rootState!=null) {
			genParam.getRtcParam().setFsmParam(rootState);
			genParam.getRtcParam().setFsmContents(buffer.toString());
			genParam.getRtcParam().parseEvent();
			
		}
		
		Generator generator = new Generator();
		generator.addGenerateManager(new ProcessingGenerateManager());
		List<GeneratedResult> result = generator.generateTemplateCode(genParam);
		return result;
	}

	private void checkGeneratedCode(List<GeneratedResult> result, String resourceDir, String moduleName) {
		checkCode(result, resourceDir, "README.md");
		checkCode(result, resourceDir, "build_ModuleName.xml");
		
		checkCode(result, resourceDir, moduleName + "Main/ModuleName.pde");
		checkCode(result, resourceDir, moduleName + "Main/ModuleNameComp.pde");
		checkCode(result, resourceDir, moduleName + "Main/ModuleNameImpl.pde");
		checkCode(result, resourceDir, moduleName + "Main/ModuleNameProtocol.pde");
		checkCode(result, resourceDir, moduleName + "Main/State01.pde");
		checkCode(result, resourceDir, moduleName + "Main/State02.pde");
		checkCode(result, resourceDir, moduleName + "Main/FinalState.pde");
		checkCode(result, resourceDir, moduleName + "Main/Top.pde");
		
		checkCode(result, resourceDir, "test/src/" + moduleName + "TestMain/ModuleNameTest.pde");
		checkCode(result, resourceDir, "test/src/" + moduleName + "TestMain/ModuleNameTestComp.pde");
		checkCode(result, resourceDir, "test/src/" + moduleName + "TestMain/ModuleNameTestImpl.pde");
	}

	public void testBasic() throws Exception {
		String rtcProfile = rootPath + "resource/FSM/basic/RTC.xml";
		String fsmProfile = rootPath + "resource/FSM/basic/ModuleNameFSM.scxml";
		String resourceDir = rootPath + "/resource/FSM/basic/";
		
		List<GeneratedResult> result = generateCode(rtcProfile, fsmProfile);
		checkGeneratedCode(result, resourceDir, "ModuleName");
	}
	
	public void testStateName() throws Exception {
		String rtcProfile = rootPath + "resource/FSM/stateName/RTC.xml";
		String fsmProfile = rootPath + "resource/FSM/stateName/ModuleNameFSM.scxml";
		String resourceDir = rootPath + "/resource/FSM/stateName/";
		
		List<GeneratedResult> result = generateCode(rtcProfile, fsmProfile);
		
		checkCode(result, resourceDir, "README.md");
		checkCode(result, resourceDir, "build_ModuleName.xml");
		
		checkCode(result, resourceDir, "ModuleNameMain/ModuleName.pde");
		checkCode(result, resourceDir, "ModuleNameMain/ModuleNameComp.pde");
		checkCode(result, resourceDir, "ModuleNameMain/ModuleNameImpl.pde");
		checkCode(result, resourceDir, "ModuleNameMain/ModuleNameProtocol.pde");
		checkCode(result, resourceDir, "ModuleNameMain/State_01.pde");
		checkCode(result, resourceDir, "ModuleNameMain/State_02.pde");
		checkCode(result, resourceDir, "ModuleNameMain/FinalState.pde");
		checkCode(result, resourceDir, "ModuleNameMain/Top.pde");
		
		checkCode(result, resourceDir, "test/src/ModuleNameTestMain/ModuleNameTest.pde");
		checkCode(result, resourceDir, "test/src/ModuleNameTestMain/ModuleNameTestComp.pde");
		checkCode(result, resourceDir, "test/src/ModuleNameTestMain/ModuleNameTestImpl.pde");
	}
//	public void testPortName() throws Exception {
//		String rtcProfile = rootPath + "resource/FSM/portName/RTC.xml";
//		String fsmProfile = rootPath + "resource/FSM/portName/ModuleNameFSM.scxml";
//		String resourceDir = rootPath + "/resource/FSM/portName/";
//		
//		List<GeneratedResult> result = generateCode(rtcProfile, fsmProfile);
//		checkGeneratedCode(result, resourceDir);
//	}
	
	public void testEventName() throws Exception {
		String rtcProfile = rootPath + "resource/FSM/eventName/RTC.xml";
		String fsmProfile = rootPath + "resource/FSM/eventName/ModuleNameFSM.scxml";
		String resourceDir = rootPath + "/resource/FSM/eventName/";
		
		List<GeneratedResult> result = generateCode(rtcProfile, fsmProfile);
		checkGeneratedCode(result, resourceDir, "ModuleName");
	}
	
	public void testEventCond() throws Exception {
		String rtcProfile = rootPath + "resource/FSM/eventCond/RTC.xml";
		String fsmProfile = rootPath + "resource/FSM/eventCond/ModuleNameFSM.scxml";
		String resourceDir = rootPath + "/resource/FSM/eventCond/";
		
		List<GeneratedResult> result = generateCode(rtcProfile, fsmProfile);
		checkGeneratedCode(result, resourceDir, "ModuleName");
	}
	
//	public void testEventType() throws Exception {
//		String rtcProfile = rootPath + "resource/FSM/eventType/RTC.xml";
//		String fsmProfile = rootPath + "resource/FSM/eventType/ModuleNameFSM.scxml";
//		String resourceDir = rootPath + "/resource/FSM/eventType/";
//		
//		List<GeneratedResult> result = generateCode(rtcProfile, fsmProfile);
//		checkGeneratedCode(result, resourceDir, "ModuleName");
//	}
//	
//	public void testEventDoc() throws Exception {
//		String rtcProfile = rootPath + "resource/FSM/eventDoc/RTC.xml";
//		String fsmProfile = rootPath + "resource/FSM/eventDoc/ModuleNameFSM.scxml";
//		String resourceDir = rootPath + "/resource/FSM/eventDoc/";
//		
//		List<GeneratedResult> result = generateCode(rtcProfile, fsmProfile);
//		checkGeneratedCode(result, resourceDir, "ModuleName");
//	}
//	
	public void testStateEntry() throws Exception {
		String rtcProfile = rootPath + "resource/FSM/stateEntry/RTC.xml";
		String fsmProfile = rootPath + "resource/FSM/stateEntry/ModuleNameFSM.scxml";
		String resourceDir = rootPath + "/resource/FSM/stateEntry/";
		
		List<GeneratedResult> result = generateCode(rtcProfile, fsmProfile);
		checkGeneratedCode(result, resourceDir, "ModuleName");
	}
}
