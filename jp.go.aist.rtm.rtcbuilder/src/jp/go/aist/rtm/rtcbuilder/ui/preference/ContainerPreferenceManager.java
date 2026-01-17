package jp.go.aist.rtm.rtcbuilder.ui.preference;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import jp.go.aist.rtm.rtcbuilder.RtcBuilderPlugin;

public class ContainerPreferenceManager {
	private static ContainerPreferenceManager __instance = new ContainerPreferenceManager();
	protected PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(
			this);

	/**
	 * コンストラクタ
	 * 
	 * @return シングルトン
	 */
	public static ContainerPreferenceManager getInstance() {
		return __instance;
	}

	/**
	 * コンテナ設定 ROS名前のキー
	 */
	public static final String Generate_Container_ROS_Name = ContainerPreferenceManager.class.getName()
			+ "GENERATE_CONTAINER_ROS_NAME";

	/**
	 * コンテナ設定 OSリストのキー
	 */
	public static final String Generate_Container_OS_List = ContainerPreferenceManager.class.getName()
			+ "GENERATE_CONTAINER_OS_LIST";

	public static final String DEFAULT_ROS_NAMES = "aaa,bbb,ccc";
	public static final String DEFAULT_OS_LIST = "Windows:11:32bit|Windows:11:64bit|Ubunto:24.20:64bit";

	public String getROS_Names() {
		RtcBuilderPlugin.getDefault().getPreferenceStore().setDefault(Generate_Container_ROS_Name, "");

		String resultTemp = RtcBuilderPlugin.getDefault().getPreferenceStore().getString(Generate_Container_ROS_Name);
		String result;
		if (resultTemp.equals("") ) { // defaultvalue
			result = DEFAULT_ROS_NAMES;
		} else {
			result = resultTemp;
		}
		return result;
	}
	public void setROS_Names(String defaultROSNames) {
		String oldROSNames = getROS_Names();
		RtcBuilderPlugin.getDefault().getPreferenceStore().setValue(Generate_Container_ROS_Name, defaultROSNames);
		propertyChangeSupport.firePropertyChange(Generate_Container_ROS_Name, oldROSNames, defaultROSNames);
	}

	public String getOS_List() {
		RtcBuilderPlugin.getDefault().getPreferenceStore().setDefault(Generate_Container_OS_List, "");

		String resultTemp = RtcBuilderPlugin.getDefault().getPreferenceStore().getString(Generate_Container_OS_List);
		String result;
		if (resultTemp.equals("") ) { // defaultvalue
			result = DEFAULT_OS_LIST;
		} else {
			result = resultTemp;
		}
		return result;
	}
	public void setOS_List(String defaultOSList) {
		String oldROSList = getOS_List();
		RtcBuilderPlugin.getDefault().getPreferenceStore().setValue(Generate_Container_OS_List, defaultOSList);
		propertyChangeSupport.firePropertyChange(Generate_Container_OS_List, oldROSList, defaultOSList);
	}

	/**
	 * @see PropertyChangeSupport#addPropertyChangeListener(java.beans.PropertyChangeListener)
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(listener);
	}

	/**
	 * @see PropertyChangeSupport#removePropertyChangeListener(java.beans.PropertyChangeListener)
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}
}
