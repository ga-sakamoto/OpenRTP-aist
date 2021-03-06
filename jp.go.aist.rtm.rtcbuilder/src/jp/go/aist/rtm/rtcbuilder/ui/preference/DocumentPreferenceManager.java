package jp.go.aist.rtm.rtcbuilder.ui.preference;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

import jp.go.aist.rtm.rtcbuilder.IRtcBuilderConstants;
import jp.go.aist.rtm.rtcbuilder.RtcBuilderPlugin;

public class DocumentPreferenceManager {
	
	private static DocumentPreferenceManager __instance = new DocumentPreferenceManager();
	private static final String Separator = ":";

	
	public static DocumentPreferenceManager getInstance() {
		return __instance;
	}
	
	static final String Document_Value_Key = DocumentPreferenceManager.class.getName() + "DOCUMENT_VALUE_KEY";
	static final String Document_Creator = DocumentPreferenceManager.class.getName() + "DOCUMENT_CREATOR_KEY";
	static final String Document_Licence = DocumentPreferenceManager.class.getName() + "DOCUMENT_LICENSE_KEY";
	
	public static ArrayList<String> defaultDocumentValue = new ArrayList<String>();
	
	protected PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(	this);
	
	public static ArrayList<String> getDefaultDocumentValue() {
		defaultDocumentValue = new ArrayList<String>();
		for (int intIdx = 0; intIdx < IRtcBuilderConstants.ACTION_TYPE_ITEMS.length; intIdx++) {
			defaultDocumentValue.add("false");
		}
		return defaultDocumentValue;
	}
	public static ArrayList<String> getDocumentValue() {
		RtcBuilderPlugin.getDefault().getPreferenceStore().setDefault(Document_Value_Key, "");

		String resultTemp = RtcBuilderPlugin.getDefault().getPreferenceStore().getString(Document_Value_Key);
		ArrayList<String> result = new ArrayList<String>();
		if (resultTemp.equals("")) { // defaultvalue
			result = getDefaultDocumentValue();
		} else {
			result = convertString2ArrayList(resultTemp);
		}
		return result;
	}
	public void setDocumentValue(ArrayList<String> arrayDocument) {
		ArrayList<String> oldArrayDocument = getDefaultDocumentValue();
		RtcBuilderPlugin.getDefault().getPreferenceStore().setValue(Document_Value_Key, convertArrayList2String(arrayDocument));
		propertyChangeSupport.firePropertyChange(Document_Value_Key,oldArrayDocument,arrayDocument);
	}

	public static String getCreatorValue() {
		RtcBuilderPlugin.getDefault().getPreferenceStore().setDefault(Document_Creator, "");
		String resultTemp = RtcBuilderPlugin.getDefault().getPreferenceStore().getString(Document_Creator);
		String result;
		if (resultTemp.equals("")) { // defaultvalue
			result = "";
		} else {
			result = resultTemp;
		}
		return result;
	}
	public void setCreatorValue(String defaultCreatorValue) {
		String oldCreatorValue = getCreatorValue();
		RtcBuilderPlugin.getDefault().getPreferenceStore().setValue(Document_Creator, defaultCreatorValue);
		propertyChangeSupport.firePropertyChange(Document_Creator, oldCreatorValue, defaultCreatorValue);
	}

	public static String getLicenseValue() {
		RtcBuilderPlugin.getDefault().getPreferenceStore().setDefault(Document_Licence, "");
		String resultTemp = RtcBuilderPlugin.getDefault().getPreferenceStore().getString(Document_Licence);
		String result;
		if (resultTemp.equals("")) { // defaultvalue
			result = "";
		} else {
			result = resultTemp;
		}
		return result;
	}
	public void setLicenseValue(String defaultLicenseValue) {
		String oldCreatorValue = getLicenseValue();
		RtcBuilderPlugin.getDefault().getPreferenceStore().setValue(Document_Licence, defaultLicenseValue);
		propertyChangeSupport.firePropertyChange(Document_Licence, oldCreatorValue, defaultLicenseValue);
	}
	
	public static String convertArrayList2String(ArrayList<String> source) {
		StringBuffer resultTemp = new StringBuffer();
		for (int intIdx = 0; intIdx < source.size(); intIdx++) {
			resultTemp.append(source.get(intIdx));
			resultTemp.append(Separator);
		}
		String result = resultTemp.toString();
		if (result.length() == 0) return "";
		return result.substring(0,result.length()-1);
	}

	public static ArrayList<String> convertString2ArrayList(String source) {
		String[] resultTemp = source.split(Separator);
		
		ArrayList<String> result = new ArrayList<String>();
		for(int intIdx=0; intIdx < IRtcBuilderConstants.ACTION_TYPE_ITEMS.length; intIdx++) {
			if(intIdx < resultTemp.length) {
				result.add(resultTemp[intIdx]);
			} else {
				result.add("false");
			}
		}
		return result;
	}

	
}
