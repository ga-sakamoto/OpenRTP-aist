package jp.go.aist.rtm.rtcbuilder.ui.preference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import jp.go.aist.rtm.rtcbuilder.RtcBuilderPlugin;
import jp.go.aist.rtm.rtcbuilder.nl.Messages;
import jp.go.aist.rtm.rtcbuilder.ui.parts.SingleLabelItem;

public class CodeGenerateContainerPreferencePage extends PreferencePage implements
							IWorkbenchPreferencePage {
	static final int EXEC_BUTTON_WIDTH = 90;

    private List<SingleLabelItem> rosNameList = new ArrayList<SingleLabelItem>();
    private List<OSInfo> osList = new ArrayList<OSInfo>();
	
	TableViewer rosTableViewer;
	Button addROSButton;	
	Button deleteROSButton;

	TableViewer osTableViewer;
	Button addOSButton;	
	Button deleteOSButton;

	@Override
	protected Control createContents(Composite parent) {
		String rosNames = ContainerPreferenceManager.getInstance().getROS_Names();
		buildROSNames(rosNames);
		String osListStr = ContainerPreferenceManager.getInstance().getOS_List();
		buildOSList(osListStr);
		//////////
		GridLayout gl;
		GridData gd;

		Composite composite = new Composite(parent, SWT.NULL);
		composite.setLayout(new GridLayout(2, false));
		
		rosTableViewer = new TableViewer(composite, SWT.FULL_SELECTION
				| SWT.SINGLE | SWT.BORDER);
		rosTableViewer.setContentProvider(new ArrayContentProvider());
		
		Table tableROS = rosTableViewer.getTable();
		tableROS.setLinesVisible(true);
		tableROS.setHeaderVisible(true);
		gd = new GridData();
		gd.verticalAlignment = SWT.FILL;
		gd.horizontalAlignment = SWT.FILL;
		gd.grabExcessVerticalSpace = true;
		gd.grabExcessHorizontalSpace = true;
		tableROS.setLayoutData(gd);

		TableViewerColumn ROSNameColumn = createColumn(rosTableViewer, "Name", 300);
		ROSNameColumn.setEditingSupport(new ROSTableCellModifier(rosTableViewer));
		rosTableViewer.setLabelProvider(new ROSLabelProvider());
		rosTableViewer.setInput(rosNameList);

		Composite buttonComposite = new Composite(composite, SWT.NONE);
		gl = new GridLayout(1, false);
		gd = new GridData();
		gd.verticalAlignment = SWT.TOP;
		buttonComposite.setLayout(gl);
		buttonComposite.setLayoutData(gd);

		addROSButton = new Button(buttonComposite, SWT.PUSH);
		addROSButton.setText(Messages.getString("IPreferenceMessageConstants.CONFIG_BTN_ADD"));
		gd = new GridData();
		gd.widthHint = EXEC_BUTTON_WIDTH;
		addROSButton.setLayoutData(gd);
		addROSButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				SingleLabelItem elem = new SingleLabelItem("new Item");
				rosNameList.add(elem);
				rosTableViewer.refresh();
			}
		});
		
		deleteROSButton = new Button(buttonComposite, SWT.PUSH);
		deleteROSButton.setText(Messages.getString("IPreferenceMessageConstants.CONFIG_BTN_DELETE"));
		gd = new GridData();
		gd.widthHint = EXEC_BUTTON_WIDTH;
		deleteROSButton.setLayoutData(gd);
		deleteROSButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int selectionIndex = rosTableViewer.getTable().getSelectionIndex();
				if (0 <= selectionIndex
						&& selectionIndex + 1 <= ((List) rosTableViewer.getInput()).size()) {
					rosNameList.remove(selectionIndex);
					rosTableViewer.refresh();
				}
			}
		});
		//////////
		osTableViewer = new TableViewer(composite, SWT.FULL_SELECTION
				| SWT.SINGLE | SWT.BORDER);
		osTableViewer.setContentProvider(new ArrayContentProvider());
		
		Table tableOS = osTableViewer.getTable();
		tableOS.setLinesVisible(true);
		tableOS.setHeaderVisible(true);
		gd = new GridData();
		gd.verticalAlignment = SWT.FILL;
		gd.horizontalAlignment = SWT.FILL;
		gd.grabExcessVerticalSpace = true;
		gd.grabExcessHorizontalSpace = true;
		tableOS.setLayoutData(gd);

		TableViewerColumn OSNameColumn = createColumn(osTableViewer, "Name", 100);
		OSNameColumn.setEditingSupport(new OSNameCellModifier(osTableViewer));
		
		TableViewerColumn OSVersionColumn = createColumn(osTableViewer, "Version", 100);
		OSVersionColumn.setEditingSupport(new OSVersionCellModifier(osTableViewer));
		
		TableViewerColumn OSBitsColumn = createColumn(osTableViewer, "Bits", 100);
		OSBitsColumn.setEditingSupport(new OSBitsCellModifier(osTableViewer));

		osTableViewer.setLabelProvider(new OSLabelProvider());
		osTableViewer.setInput(osList);

		Composite buttonCompositeOS = new Composite(composite, SWT.NONE);
		gl = new GridLayout(1, false);
		gd = new GridData();
		gd.verticalAlignment = SWT.TOP;
		buttonCompositeOS.setLayout(gl);
		buttonCompositeOS.setLayoutData(gd);

		addOSButton = new Button(buttonCompositeOS, SWT.PUSH);
		addOSButton.setText(Messages.getString("IPreferenceMessageConstants.CONFIG_BTN_ADD"));
		gd = new GridData();
		gd.widthHint = EXEC_BUTTON_WIDTH;
		addOSButton.setLayoutData(gd);
		addOSButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				OSInfo elem = new OSInfo();
				elem.name = "new Item";
				osList.add(elem);
				osTableViewer.refresh();
			}
		});
		
		deleteOSButton = new Button(buttonCompositeOS, SWT.PUSH);
		deleteOSButton.setText(Messages.getString("IPreferenceMessageConstants.CONFIG_BTN_DELETE"));
		gd = new GridData();
		gd.widthHint = EXEC_BUTTON_WIDTH;
		deleteOSButton.setLayoutData(gd);
		deleteOSButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int selectionIndex = osTableViewer.getTable().getSelectionIndex();
				if (0 <= selectionIndex
						&& selectionIndex + 1 <= ((List) osTableViewer.getInput()).size()) {
					osList.remove(selectionIndex);
					osTableViewer.refresh();
				}
			}
		});

		return composite;
	}

	private void buildROSNames(String source) {
		rosNameList.clear();
		List<String> rosNamelist = Arrays.asList(source.split(","));
		for(String each : rosNamelist) {
			SingleLabelItem elem = new SingleLabelItem(each);
			rosNameList.add(elem);
		}
	}
	
	private void buildOSList(String source) {
		osList.clear();
		String[] elemlist = source.split("\\|");
		for(String each : elemlist) {
			OSInfo elem = new OSInfo();
			elem.parseStr(each);
			osList.add(elem);
		}
	}

	private TableViewerColumn createColumn(TableViewer viewer, String title, int width) {
		TableViewerColumn col;
		col = new TableViewerColumn(viewer, SWT.NONE);
		col.getColumn().setText(title);
		col.getColumn().setWidth(width);
		col.getColumn().setResizable(true);
		col.getColumn().setMoveable(false);
		return col;
	}

	@Override
	public void init(IWorkbench workbench) {
		IPreferenceStore store = RtcBuilderPlugin.getDefault().getPreferenceStore();
		storeContainerROSSetting(store);
	}

	@Override
	public boolean performOk() {
		StringBuilder builderROS = new StringBuilder();
		for(SingleLabelItem each : rosNameList) {
			if(0 < builderROS.length()) {
				builderROS.append(",");
			}
			builderROS.append(each.getLabeltext());
		}
		String resultROS = builderROS.toString();
		ContainerPreferenceManager.getInstance().setROS_Names(resultROS);
		/////
		StringBuilder builderOS = new StringBuilder();
		for(OSInfo each : osList) {
			if(0 < builderOS.length()) {
				builderOS.append("|");
			}
			builderOS.append(each.convStr());
		}
		String resultOS = builderOS.toString();
		ContainerPreferenceManager.getInstance().setOS_List(resultOS);

		return super.performOk();
	}

	@Override
	protected void performDefaults() {
		String defaultValROS = ContainerPreferenceManager.DEFAULT_ROS_NAMES;
		buildROSNames(defaultValROS);
		rosTableViewer.refresh();

		String defaultValOS = ContainerPreferenceManager.DEFAULT_OS_LIST;
		buildOSList(defaultValOS);
		osTableViewer.refresh();

		super.performDefaults();
	}
	
	private void storeContainerROSSetting(IPreferenceStore store) {
		store.setDefault(ContainerPreferenceManager.Generate_Container_ROS_Name, ContainerPreferenceManager.DEFAULT_ROS_NAMES);
		store.setDefault(ContainerPreferenceManager.Generate_Container_OS_List, ContainerPreferenceManager.DEFAULT_OS_LIST);
	}
	//////////
	private class ROSLabelProvider extends LabelProvider implements ITableLabelProvider {
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof SingleLabelItem == false) return null;
			SingleLabelItem elem = (SingleLabelItem) element;
			if (columnIndex == 0) {
				return elem.getLabeltext();
			} else {
				return "";
			}
		}
	}
	
	private class ROSTableCellModifier extends EditingSupport {
		private CellEditor editor;

		public ROSTableCellModifier(ColumnViewer viewer) {
			super(viewer);
			editor = new TextCellEditor(((TableViewer) viewer).getTable());
		}

		@Override
		protected boolean canEdit(Object element) {
			return true;
		}

		@Override
		protected CellEditor getCellEditor(Object element) {
			return editor;
		}

		@Override
		protected Object getValue(Object element) {
			if (element instanceof SingleLabelItem == false) return null;
			SingleLabelItem elem = (SingleLabelItem) element;
			return elem.getLabeltext();
		}

		@Override
		protected void setValue(Object element, Object value) {
			if (element instanceof SingleLabelItem == false) return;
			SingleLabelItem elem = (SingleLabelItem) element;

			elem.setLabeltext((String) value);
			getViewer().update(element, null);

		}
	}
	/////////
	private class OSInfo {
		public String name;
		public String version;
		public String bit;
		
		public OSInfo() {
			this.name = "";
			this.version = "";
			this.bit = "";
		}
		
		public void parseStr(String source) {
			String[] elems = source.split(":");
			if(0<elems.length) {
				this.name = elems[0];
			}
			if(1<elems.length) {
				this.version = elems[1];
			}
			if(2<elems.length) {
				this.bit = elems[2];
			}
		}
		
		public String convStr() {
			StringBuilder builder = new StringBuilder();
			builder.append(this.name).append(":");
			builder.append(this.version).append(":");
			builder.append(this.bit);
			return builder.toString();
		}
	}
	
	private class OSLabelProvider extends LabelProvider implements ITableLabelProvider {
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof OSInfo == false) return null;
			OSInfo elem = (OSInfo) element;
			if (columnIndex == 0) {
				return elem.name;
			} else if (columnIndex == 1) {
				return elem.version;
			} else if (columnIndex == 2) {
				return elem.bit;
			} else {
				return "";
			}
		}
	}
	
	private class OSNameCellModifier extends EditingSupport {
		private CellEditor editor;

		public OSNameCellModifier(ColumnViewer viewer) {
			super(viewer);
			editor = new TextCellEditor(((TableViewer) viewer).getTable());
		}

		@Override
		protected boolean canEdit(Object element) {
			return true;
		}

		@Override
		protected CellEditor getCellEditor(Object element) {
			return editor;
		}

		@Override
		protected Object getValue(Object element) {
			if (element instanceof OSInfo == false) return null;
			OSInfo elem = (OSInfo) element;
			return elem.name;
		}

		@Override
		protected void setValue(Object element, Object value) {
			if (element instanceof OSInfo == false) return;
			OSInfo elem = (OSInfo) element;

			elem.name =(String) value;
			getViewer().update(element, null);

		}
	}
	
	private class OSVersionCellModifier extends EditingSupport {
		private CellEditor editor;

		public OSVersionCellModifier(ColumnViewer viewer) {
			super(viewer);
			editor = new TextCellEditor(((TableViewer) viewer).getTable());
		}

		@Override
		protected boolean canEdit(Object element) {
			return true;
		}

		@Override
		protected CellEditor getCellEditor(Object element) {
			return editor;
		}

		@Override
		protected Object getValue(Object element) {
			if (element instanceof OSInfo == false) return null;
			OSInfo elem = (OSInfo) element;
			return elem.version;
		}

		@Override
		protected void setValue(Object element, Object value) {
			if (element instanceof OSInfo == false) return;
			OSInfo elem = (OSInfo) element;

			elem.version =(String) value;
			getViewer().update(element, null);

		}
	}
	
	private class OSBitsCellModifier extends EditingSupport {
		private CellEditor editor;

		public OSBitsCellModifier(ColumnViewer viewer) {
			super(viewer);
			editor = new TextCellEditor(((TableViewer) viewer).getTable());
		}

		@Override
		protected boolean canEdit(Object element) {
			return true;
		}

		@Override
		protected CellEditor getCellEditor(Object element) {
			return editor;
		}

		@Override
		protected Object getValue(Object element) {
			if (element instanceof OSInfo == false) return null;
			OSInfo elem = (OSInfo) element;
			return elem.bit;
		}

		@Override
		protected void setValue(Object element, Object value) {
			if (element instanceof OSInfo == false) return;
			OSInfo elem = (OSInfo) element;

			elem.bit =(String) value;
			getViewer().update(element, null);

		}
	}
}
