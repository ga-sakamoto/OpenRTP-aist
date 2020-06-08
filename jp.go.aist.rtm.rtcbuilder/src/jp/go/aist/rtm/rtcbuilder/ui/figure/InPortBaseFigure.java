package jp.go.aist.rtm.rtcbuilder.ui.figure;

import org.eclipse.draw2d.XYLayout;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.PlatformUI;

import jp.go.aist.rtm.rtcbuilder.model.component.DataInPort;
import jp.go.aist.rtm.rtcbuilder.util.RTCUtil;

public class InPortBaseFigure extends PortFigureBase {
	private InPortFigure inPortFig;

	public InPortBaseFigure(DataInPort inPort, int direction) {
		RGB color = RTCUtil.defaultRGBMap.get(RTCUtil.COLOR_DATAPORT);
		inPortFig = new InPortFigure(inPort, direction,
				new Color(PlatformUI.getWorkbench().getDisplay(), color));
		setLayoutManager(new XYLayout());
		add(inPortFig);
	}

	public InPortFigure getInnerFigure() {
		return this.inPortFig;
	}

	public void setInnerFigure(InPortFigure figure) {
		this.inPortFig = figure;
	}
}
