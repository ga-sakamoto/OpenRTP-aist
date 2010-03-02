package jp.go.aist.rtm.toolscommon.ui.views.propertysheetview;

import jp.go.aist.rtm.toolscommon.model.component.Component;
import jp.go.aist.rtm.toolscommon.model.component.PortConnector;
import jp.go.aist.rtm.toolscommon.model.manager.RTCManager;
import jp.go.aist.rtm.toolscommon.synchronizationframework.LocalObject;
import jp.go.aist.rtm.toolscommon.util.AdapterUtil;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.views.properties.PropertiesMessages;
import org.eclipse.ui.part.IPageBookViewPage;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.views.properties.IPropertySheetEntry;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.IPropertySourceProvider;

/**
 * Rtc専用のプロパティシートページクラス
 * <p>
 * Rtcの場合だけ、特殊なプロパティページを表示する それ以外の場合には、通常のプロパティページを表示する
 * このクラスには、コンポーネント以外のIPropertySourceを持ったオブジェクトも表示できるようdefaultDelegateを作成していたが、画面がチカチカするため廃止した。
 */
public class RtcPropertySheetPage implements IPropertySheetPage,
		IPageBookViewPage {

	private StackLayout stackLayout;

	private Composite composite;

	private Tree componentView;

	private TreeViewer componentViewer;

	private IPageSite pageSite;

	/**
	 * {@inheritDoc}
	 */
	public void createControl(Composite parent) {
		composite = new Composite(parent, SWT.BORDER);

		stackLayout = new StackLayout();
		composite.setLayout(stackLayout);

		componentViewer = new TreeViewer(composite, SWT.FULL_SELECTION
				| SWT.SINGLE | SWT.HIDE_SELECTION);

		componentViewer.setContentProvider(new PropertySheetContentProvider());
		componentViewer.setLabelProvider(new PropertySheetLabelProvider());
		componentViewer.setAutoExpandLevel(4);

		componentView = componentViewer.getTree();
		componentView.setLinesVisible(true);
		componentView.setHeaderVisible(true);

		pageSite.setSelectionProvider(new ISelectionProvider() {
			public void addSelectionChangedListener(
					ISelectionChangedListener listener) {
			}

			public ISelection getSelection() {
				StructuredSelection result = null;
				if (componentViewer.getInput() != null
						&& componentViewer.getInput() instanceof ComponentWrapper) {
					result = new StructuredSelection(
							((ComponentWrapper) componentViewer.getInput())
									.getComponent());
				}

				return result;
			}

			public void removeSelectionChangedListener(
					ISelectionChangedListener listener) {
			}

			public void setSelection(ISelection selection) {
			}
		});

		TreeColumn propertyColumn = new TreeColumn(componentView, SWT.NONE);
		propertyColumn.setText(PropertiesMessages.PropertyViewer_property);
		propertyColumn.setWidth(150);
		TreeColumn valueColumn = new TreeColumn(componentView, SWT.NONE);
		valueColumn.setText(PropertiesMessages.PropertyViewer_value);
		valueColumn.setWidth(150);
	}

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
		composite.dispose();
	}

	/**
	 * {@inheritDoc}
	 */
	public Control getControl() {
		return composite;
	}

	/**
	 * 委譲
	 * 
	 * @param selection
	 */
	public void handleEntrySelection(ISelection selection) {
	}

	/**
	 * 委譲
	 * 
	 * @param pageSite
	 */
	public void init(IPageSite pageSite) {
		this.pageSite = pageSite;
	}

	/**
	 * 委譲
	 * 
	 * @param menuManager
	 * @param toolBarManager
	 * @param statusLineManager
	 */
	public void makeContributions(IMenuManager menuManager,
			IToolBarManager toolBarManager, IStatusLineManager statusLineManager) {
	}

	/**
	 * 委譲
	 */
	public void refresh() {
	}
	
	private LocalObject prevComponent;
	
	/**
	 * {@inheritDoc}
	 * <p>
	 * 
	 * Rtcの場合だけ、特殊なページを表示するようにする
	 * また、このページでは、RTC以外オブジェクトを触っても、それがIPropertySouceを持っていない場合には（Propertyiesページを表示できない場合には）RTCを表示し続ける。（これは、selectionChangedを無視することで実現している）
	 */
	@SuppressWarnings("unchecked")
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection sSelection = (IStructuredSelection) selection;

			LocalObject component = getDisplayObject(sSelection.getFirstElement());		
			if (component == prevComponent) return;
			prevComponent = component;

			String kind = null;
			if (component instanceof Component) {
				Component c = (Component) component;
				c.synchronizeManually();
				if (c.isCompositeComponent()) {
					kind = "composite";
				}

				componentViewer.setInput(new ComponentWrapper(component));
				componentViewer.reveal(component);// 表示後、上にスクロールする
				stackLayout.topControl = componentView;
			} else if (component instanceof PortConnector) {
				componentViewer.setInput(new PortConnectorWrapper(component));
				componentViewer.reveal(component);// 表示後、上にスクロールする
				stackLayout.topControl = componentView;

			} else if (component instanceof RTCManager) {
				RTCManager m = (RTCManager) component;
				m.synchronizeManually();
				prevComponent = null;

				componentViewer.setInput(new RTCManagerWrapper(component));
				componentViewer.reveal(component);// 表示後、上にスクロールする
				stackLayout.topControl = componentView;

			} else {
				componentViewer.setInput(null);
			}
			composite.layout();

			switchView(component, kind);
		}
	}

	private void switchView(LocalObject component, String kind) {
		String viewId = OpenView.getViewId(component, kind);
		if (viewId != null) {
			try {
				IWorkbenchWindow window = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow();
				IWorkbenchPage page = window.getActivePage();
				page.showView(viewId, null, IWorkbenchPage.VIEW_VISIBLE);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unchecked")
	private LocalObject getDisplayObject(Object firstElement) {
		for (Class displayClass : PropertysheetpageExtentionpoint
				.getDisplayclassList()) {
			Object obj = AdapterUtil.getAdapter(firstElement,	displayClass);
			if (obj != null) {
				return (LocalObject) obj;
			}
		}
		return null;
	}

	/**
	 * 委譲
	 * 
	 * @param actionBars
	 */
	public void setActionBars(IActionBars actionBars) {
	}

	/**
	 * {@inheritDoc}
	 */
	public void setFocus() {
		composite.setFocus();
	}

	/**
	 * 委譲
	 * 
	 * @param newProvider
	 */
	public void setPropertySourceProvider(IPropertySourceProvider newProvider) {
	}

	/**
	 * 委譲
	 * 
	 * @param entry
	 */
	public void setRootEntry(IPropertySheetEntry entry) {
	}

	public IPageSite getSite() {
		return pageSite;
	}

}
