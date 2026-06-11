package jp.go.aist.rtm.rtcbuilder._test.container;

import junit.framework.Test;
import junit.framework.TestSuite;

public class ContainerAllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Test for jp.go.aist.rtm.rtcbuilder._test");
		//$JUnit-BEGIN$
		//Common
		suite.addTestSuite(ContainerROS1CppTest.class);
		suite.addTestSuite(ContainerROS1PythonTest.class);
		suite.addTestSuite(ContainerROS2CppTest.class);
		suite.addTestSuite(ContainerROS2PythonTest.class);
		
		suite.addTestSuite(ContainerRTCCppTest.class);
		suite.addTestSuite(ContainerRTCPythonTest.class);
		//$JUnit-END$
		return suite;
	}

}
