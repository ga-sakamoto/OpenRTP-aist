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
	 * コンテナ設定 キー
	 */
	public static final String Generate_Container_Settings = ContainerPreferenceManager.class.getName()
			+ "GENERATE_CONTAINER_SETTINGS";

	public static final String DEFAULT_SETTINGS = "";

	public String getSettings() {
		RtcBuilderPlugin.getDefault().getPreferenceStore().setDefault(Generate_Container_Settings, "");

		String resultTemp = RtcBuilderPlugin.getDefault().getPreferenceStore().getString(Generate_Container_Settings);
		String result;
		if (resultTemp.equals("") ) { // defaultvalue
			result = DEFAULT_SETTINGS;
		} else {
			result = resultTemp;
		}
		return result;
	}
	public void setSettings(String defaultSettings) {
		String oldSettings = getSettings();
		RtcBuilderPlugin.getDefault().getPreferenceStore().setValue(Generate_Container_Settings, defaultSettings);
		propertyChangeSupport.firePropertyChange(Generate_Container_Settings, oldSettings, defaultSettings);
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
