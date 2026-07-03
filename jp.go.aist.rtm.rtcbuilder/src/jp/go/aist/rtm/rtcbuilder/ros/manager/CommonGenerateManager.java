package jp.go.aist.rtm.rtcbuilder.ros.manager;

import static jp.go.aist.rtm.rtcbuilder.util.RTCUtil.form;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.go.aist.rtm.rtcbuilder.IRtcBuilderConstants;
import jp.go.aist.rtm.rtcbuilder.ParamBase;
import jp.go.aist.rtm.rtcbuilder.fsm.StateParam;
import jp.go.aist.rtm.rtcbuilder.generator.GeneratedResult;
import jp.go.aist.rtm.rtcbuilder.generator.param.RtcParam;
import jp.go.aist.rtm.rtcbuilder.manager.GenerateManager;
import jp.go.aist.rtm.rtcbuilder.ros.param.ROSParam;
import jp.go.aist.rtm.rtcbuilder.ros.template.TemplateHelperROS;
import jp.go.aist.rtm.rtcbuilder.template.TemplateHelper;
import jp.go.aist.rtm.rtcbuilder.template.TemplateUtil;

/**
 * 一般ファイルの出力を制御するマネージャ
 */
public class CommonGenerateManager extends GenerateManager {

	static final String TEMPLATE_PATH = "jp/go/aist/rtm/rtcbuilder/ros/template";

	static final String MSG_ERROR_GENERATE_FILE = "Common generation error. [{0}]";

	@Override
	public String getManagerKey() {
		return "Common";
	}

	@Override
	public String getLangArgList() {
		return null;
	}

	@Override
	public String getTargetMiddleware() {
		return IRtcBuilderConstants.MIDDLEWARE_ROS;
	}

	/**
	 * ファイルを出力する
	 *
	 * @param generatorParam
	 * @return 出力結果のリスト
	 */
	public List<GeneratedResult> generateTemplateCode(ParamBase param) {
		ROSParam rosParam = (ROSParam)param;
		
		Map<String, Object> contextMap = new HashMap<String, Object>();
		contextMap.put("template", TEMPLATE_PATH);
		contextMap.put("rosParam", rosParam);
		contextMap.put("tmpltHelper", new TemplateHelperROS());

		return generateTemplateCode(contextMap);
	}

	public List<GeneratedResult> generateTemplateCode(
			Map<String, Object> contextMap) {
		List<GeneratedResult> result = new ArrayList<GeneratedResult>();
		ROSParam rosParam = (ROSParam) contextMap.get("rosParam");

		result.add(generateREADME(contextMap));
		result.add(generatePackageXML(contextMap));
		result.add(generateLICENSE(contextMap));
		result.add(generateConfigParams(contextMap));
		result.add(generateLaunch(contextMap));

		return result;
	}

	public GeneratedResult generatePackageXML(Map<String, Object> contextMap) {
		String outfile = "package.xml";
		String infile = "";
		infile = "common/Packcage.xml.vsl";
		return generate(infile, outfile, contextMap);
	}

	public GeneratedResult generateREADME(Map<String, Object> contextMap) {
		String outfile = "README.md";
		String infile = "";
		infile = "common/README.vsl";
		return generate(infile, outfile, contextMap);
	}

	public GeneratedResult generateLICENSE(Map<String, Object> contextMap) {
		ROSParam rosParam = (ROSParam) contextMap.get("rosParam");
		String outfile = "LICENSE";
		String infile = "";
		infile = "common/LICENSE.apache.vsl";
		return generate(infile, outfile, contextMap);
	}

	public GeneratedResult generateConfigParams(Map<String, Object> contextMap) {
		String outfile = "config/params.yaml";
		String infile = "";
		infile = "common/Params.yaml.vsl";
		return generate(infile, outfile, contextMap);
	}

	public GeneratedResult generateLaunch(Map<String, Object> contextMap) {
		ROSParam rosParam = (ROSParam) contextMap.get("rosParam");

		String outfile = "launch/" + rosParam.getNodeName() + ".launch.py";
		String infile = "";
		infile = "common/Launch.py.vsl";
		return generate(infile, outfile, contextMap);
	}

	public GeneratedResult generate(String infile, String outfile,
			Map<String, Object> contextMap) {
		try {
			String template = TEMPLATE_PATH + "/" + infile;
			ClassLoader cl = Thread.currentThread().getContextClassLoader();
			GeneratedResult gr = null;
			try( InputStream ins = cl.getResourceAsStream(template) ) {
				gr = TemplateUtil.createGeneratedResult(ins, contextMap, outfile);
			}
			return gr;
		} catch (Exception e) {
			throw new RuntimeException(form(MSG_ERROR_GENERATE_FILE,
					new String[] { outfile }), e);
		}
	}

}
