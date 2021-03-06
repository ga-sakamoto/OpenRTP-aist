package jp.go.aist.rtm.systemeditor.ui.dialog;

import java.util.ArrayList;
import java.util.List;

import jp.go.aist.rtm.toolscommon.model.component.Component;
import jp.go.aist.rtm.toolscommon.model.component.Port;

/**
 * 新規複合コンポーネント作成ダイアログに表示するデータを用意するユーティティクラス
 * 
 */
public class NewCompositeComponentDialogData {

	static String[] getPathComboItems(List<Component> selectedComponents) {
		List<String> paths = new ArrayList<String>();
		for (Component obj : selectedComponents) {
			String path = obj.getPath();
			if (path != null && !paths.contains(path)) {
				paths.add(path);
			}
		}
		return paths.toArray(new String[] {});
	}

	static List<String> getPorts(List<Component> selectedComponents) {
		List<String> ports = new ArrayList<String>();
		for (Component obj : selectedComponents) {
			for (Object element : obj.getPorts()) {
				Port port = (Port) element;
				ports.add(port.getNameL());
			}
		}
		return ports;
	}

}
