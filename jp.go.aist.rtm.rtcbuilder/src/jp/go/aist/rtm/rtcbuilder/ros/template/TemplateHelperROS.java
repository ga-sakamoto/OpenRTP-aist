package jp.go.aist.rtm.rtcbuilder.ros.template;

import java.util.ArrayList;
import java.util.List;

import jp.go.aist.rtm.rtcbuilder.ros.param.ActionParam;
import jp.go.aist.rtm.rtcbuilder.ros.param.ROSParam;
import jp.go.aist.rtm.rtcbuilder.ros.param.ServiceParam;

public class TemplateHelperROS {
	public static String getMessageBasename(String fullName) {
		String[] split = fullName.split("/");
		return split[0];
	}
	
	public static String convMessageType(String fullName) {
		return fullName.replaceAll("/", "::");
	}

	public static int toMilliSec(Double rate) {
		return (int) Math.round(rate * 1000);
	}

	public static List<String> getServicePackage(ROSParam source) {
		List<String> result = new ArrayList<String>();
		
		for(ServiceParam each : source.getServiceClients()) {
			String type = each.getType();
			String[] elems = type.split("/");
			if(elems == null || elems.length == 0) continue;
			
			if(result.contains(elems[0])==false) {
				result.add(elems[0]);
			}
		}
		for(ServiceParam each : source.getServiceServers()) {
			String type = each.getType();
			String[] elems = type.split("/");
			if(elems == null || elems.length == 0) continue;
			
			if(result.contains(elems[0])==false) {
				result.add(elems[0]);
			}
		}
		
		return result;
	}
	public static List<String> getActionPackage(ROSParam source) {
		List<String> result = new ArrayList<String>();
		
		for(ActionParam each : source.getActionClients()) {
			String type = each.getType();
			String[] elems = type.split("/");
			if(elems == null || elems.length == 0) continue;
			
			if(result.contains(elems[0])==false) {
				result.add(elems[0]);
			}
		}
		for(ActionParam each : source.getActionServers()) {
			String type = each.getType();
			String[] elems = type.split("/");
			if(elems == null || elems.length == 0) continue;
			
			if(result.contains(elems[0])==false) {
				result.add(elems[0]);
			}
		}
		
		return result;
	}
	
	public static String capitalize(String str) {
	    if (str == null || str.isEmpty()) {
	        return str;
	    }
	    return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	public static String convZero(Double source) {
	    if (source == null) {
	        return "-";
	    }
	    return source.toString();
	}
}
