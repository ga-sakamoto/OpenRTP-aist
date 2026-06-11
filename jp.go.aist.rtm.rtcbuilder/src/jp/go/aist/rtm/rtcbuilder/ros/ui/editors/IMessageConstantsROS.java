package jp.go.aist.rtm.rtcbuilder.ros.ui.editors;

import jp.go.aist.rtm.rtcbuilder.nl.Messages;
import jp.go.aist.rtm.rtcbuilder.util.StringUtil;

public interface IMessageConstantsROS {
	public static final String BASIC_HINT_PACKCGENAME_DESC = StringUtil.connectMessageWithSepalator( new String[]{
			Messages.getString("IMC.ROS_BASIC_HINT_PACKAGENAME_DESC_P1"),
			Messages.getString("IMC.ROS_BASIC_HINT_PACKAGENAME_DESC_P2")});
	public static final String BASIC_HINT_CATEGORY_DESC = StringUtil.connectMessageWithSepalator( new String[]{
			Messages.getString("IMC.ROS_BASIC_HINT_CATEGORY_DESC_P1"),
			Messages.getString("IMC.ROS_BASIC_HINT_CATEGORY_DESC_P2")});
	public static final String BASIC_HINT_DEPENDENCY_DESC = StringUtil.connectMessageWithSepalator( new String[]{
			Messages.getString("IMC.ROS_BASIC_HINT_DEPENDENCY_DESC_P1"),
			Messages.getString("IMC.ROS_BASIC_HINT_DEPENDENCY_DESC_P2")});

	public static final String BASIC_HINT_LANGUAGE_DESC = StringUtil.connectMessageWithSepalator( new String[]{
			Messages.getString("IMC.ROS_BASIC_HINT_LANGUAGE_DESC_P1"),
			Messages.getString("IMC.ROS_BASIC_HINT_LANGUAGE_DESC_P2"),
			Messages.getString("IMC.ROS_BASIC_HINT_LANGUAGE_DESC_P3")});
	
	public static final String ACTIVITY_DOCUMENT_EXPL = StringUtil.connectMessageWithSepalator( new String[]{
			Messages.getString("IMC.ROS_DOCUMENT_EXPL_P1"),
			Messages.getString("IMC.ROS_DOCUMENT_EXPL_P2")});

	public static final String TIMER_DOCUMENT_EXPL = StringUtil.connectMessageWithSepalator( new String[]{
			Messages.getString("IMC.ROS_LIFECYCLE_HINT_TIMER_DESC_P1"),
			Messages.getString("IMC.ROS_LIFECYCLE_HINT_TIMER_DESC_P2")});

	public static final String TOPIC_DOCUMENT_EXPL = StringUtil.connectMessageWithSepalator( new String[]{
			Messages.getString("IMC.ROS_TOPIC_DOCUMENT_EXPL_P1"),
			Messages.getString("IMC.ROS_TOPIC_DOCUMENT_EXPL_P2")
	});

	public static final String TOPIC_HINT_TOPIC_EXPL = StringUtil.connectMessageWithSepalator( new String[]{
			Messages.getString("IMC.ROS_TOPIC_HINT_TOPIC_DESC_P1"),
			Messages.getString("IMC.ROS_TOPIC_HINT_TOPIC_DESC_P2")
	});
	public static final String TOPIC_HINT_SUBSCRIBE_EXPL = StringUtil.connectMessageWithSepalator( new String[]{
			Messages.getString("IMC.ROS_TOPIC_HINT_SUBSCRIBE_DESC_P1"),
			Messages.getString("IMC.ROS_TOPIC_HINT_SUBSCRIBE_DESC_P2")
	});
	public static final String TOPIC_HINT_TOPIC_NAME_EXPL = StringUtil.connectMessageWithSepalator( new String[]{
			Messages.getString("IMC.ROS_TOPIC_HINT_TOPIC_NAME_DESC_P1"),
			Messages.getString("IMC.ROS_TOPIC_HINT_TOPIC_NAME_DESC_P2")
	});
	public static final String TOPIC_HINT_RELIABILITY_EXPL = StringUtil.connectMessageWithSepalator( new String[]{
			Messages.getString("IMC.ROS_TOPIC_HINT_RELIABILITY_DESC_P1"),
			Messages.getString("IMC.ROS_TOPIC_HINT_RELIABILITY_DESC_P2")
	});
	public static final String TOPIC_HINT_HISTORY_EXPL = StringUtil.connectMessageWithSepalator( new String[]{
			Messages.getString("IMC.ROS_TOPIC_HINT_HISTORY_DESC_P1"),
			Messages.getString("IMC.ROS_TOPIC_HINT_HISTORY_DESC_P2")
	});
	public static final String TOPIC_HINT_VARNAME_PUBLISH_EXPL = StringUtil.connectMessageWithSepalator( new String[]{
			Messages.getString("IMC.ROS_TOPIC_HINT_VARNAME_PUBLISH_DESC_P1"),
			Messages.getString("IMC.ROS_TOPIC_HINT_VARNAME_PUBLISH_DESC_P2")
	});
	public static final String TOPIC_HINT_DOC_OCCUR_EXPL = StringUtil.connectMessageWithSepalator( new String[]{
			Messages.getString("IMC.ROS_TOPIC_HINT_DOC_OCCUR_P1"),
			Messages.getString("IMC.ROS_TOPIC_HINT_DOC_OCCUR_P2"),
			Messages.getString("IMC.ROS_TOPIC_HINT_DOC_OCCUR_P3"),
			Messages.getString("IMC.ROS_TOPIC_HINT_DOC_OCCUR_P4")
	});
	
	public static final String SERVICE_DOCUMENT_EXPL = StringUtil.connectMessageWithSepalator( new String[]{
			Messages.getString("IMC.ROS_SERVICE_DOCUMENT_EXPL_P1"),
			Messages.getString("IMC.ROS_SERVICE_DOCUMENT_EXPL_P2")
	});
	public static final String SERVICE_HINT_SERVICE_EXPL = StringUtil.connectMessageWithSepalator( new String[]{
			Messages.getString("IMC.ROS_SERVICE_HINT_SERVICE_DESC_P1"),
			Messages.getString("IMC.ROS_SERVICE_HINT_SERVICE_DESC_P2")
	});
	public static final String SERVICE_HINT_VAR_CLIENT_EXPL = StringUtil.connectMessageWithSepalator( new String[]{
			Messages.getString("IMC.ROS_SERVICE_HINT_VARNAME_CLIENT_DESC_P1"),
			Messages.getString("IMC.ROS_SERVICE_HINT_VARNAME_CLIENT_DESC_P2")
	});
	public static final String SERVICE_HINT_ARGUMENT_EXPL = StringUtil.connectMessageWithSepalator( new String[]{
			Messages.getString("IMC.ROS_SERVICE_HINT_ARGUMEN_DESC_P1"),
			Messages.getString("IMC.ROS_SERVICE_HINT_ARGUMEN_DESC_P2"),
			Messages.getString("IMC.ROS_SERVICE_HINT_ARGUMEN_DESC_P3")
	});
	public static final String SERVICE_HINT_RETURN_EXPL = StringUtil.connectMessageWithSepalator( new String[]{
			Messages.getString("IMC.ROS_SERVICE_HINT_RETURN_DESC_P1"),
			Messages.getString("IMC.ROS_SERVICE_HINT_RETURN_DESC_P2"),
			Messages.getString("IMC.ROS_SERVICE_HINT_RETURN_DESC_P3")
	});

	public static final String ACTION_DOCUMENT_EXPL = StringUtil.connectMessageWithSepalator( new String[]{
			Messages.getString("IMC.ROS_ACTION_DOCUMENT_EXPL_P1"),
			Messages.getString("IMC.ROS_ACTION_DOCUMENT_EXPL_P2")
	});
	public static final String ACTION_HINT_ACTION_EXPL = StringUtil.connectMessageWithSepalator( new String[]{
			Messages.getString("IMC.ROS_ACTION_HINT_ACTION_DESC_P1"),
			Messages.getString("IMC.ROS_ACTION_HINT_ACTION_DESC_P2"),
			Messages.getString("IMC.ROS_ACTION_HINT_ACTION_DESC_P3")
	});
	public static final String ACTION_HINT_CALLBACK_EXPL = StringUtil.connectMessageWithSepalator( new String[]{
			Messages.getString("IMC.ROS_ACTION_HINT_CALLBACK_DESC_P1"),
			Messages.getString("IMC.ROS_ACTION_HINT_CALLBACK_DESC_P2"),
			Messages.getString("IMC.ROS_ACTION_HINT_CALLBACK_DESC_P3"),
			Messages.getString("IMC.ROS_ACTION_HINT_CALLBACK_DESC_P4"),
			Messages.getString("IMC.ROS_ACTION_HINT_CALLBACK_DESC_P5"),
			Messages.getString("IMC.ROS_ACTION_HINT_CALLBACK_DESC_P6"),
			Messages.getString("IMC.ROS_ACTION_HINT_CALLBACK_DESC_P7")
	});
	
	public static final String PARAMETER_DOCUMENT_EXPL = StringUtil.connectMessageWithSepalator( new String[]{
			Messages.getString("IMC.ROS_PARAMETER_DOCUMENT_EXPL_P1"),
			Messages.getString("IMC.ROS_PARAMETER_DOCUMENT_EXPL_P2")
	});
	public static final String PARAMETER_HINT_PARAMETER_EXPL = StringUtil.connectMessageWithSepalator( new String[]{
			Messages.getString("IMC.ROS_PARAMETER_HINT_PARAMETER_DESC_P1"),
			Messages.getString("IMC.ROS_PARAMETER_HINT_PARAMETER_DESC_P2")
	});
	public static final String PARAMETER_HINT_DEFAULT_EXPL = StringUtil.connectMessageWithSepalator( new String[]{
			Messages.getString("IMC.ROS_PARAMETER_HINT_DEFAULT_DESC_P1"),
			Messages.getString("IMC.ROS_PARAMETER_HINT_DEFAULT_DESC_P2")
	});

	public static final String ROSXML_CAUTION = StringUtil.connectMessageWithSepalator( new String[]{
			Messages.getString("IMC.ROSXML_CAUTION_P1"),
			Messages.getString("IMC.ROSXML_CAUTION_P2")
	});

}
