package jp.go.aist.rtm.rtcbuilder.ros.ui.editors;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import jp.go.aist.rtm.rtcbuilder.IRtcBuilderConstants;
import jp.go.aist.rtm.rtcbuilder.generator.param.DataPortParam;
import jp.go.aist.rtm.rtcbuilder.generator.param.RtcParam;
import jp.go.aist.rtm.rtcbuilder.nl.Messages;
import jp.go.aist.rtm.rtcbuilder.ros.param.ActionParam;
import jp.go.aist.rtm.rtcbuilder.ros.param.ROSParam;
import jp.go.aist.rtm.rtcbuilder.ui.editors.AbstractEditorFormPage;
import jp.go.aist.rtm.rtcbuilder.ui.editors.IMessageConstants;
import jp.go.aist.rtm.rtcbuilder.util.StringUtil;
import jp.go.aist.rtm.rtcbuilder.util.ValidationUtil;

/**
 * Actionページ
 */
public class ActionEditorFormPage extends AbstractEditorFormPage {

	private TableViewer serverTableViewer;
	private Button serverAddButton;
	private Button serverDeleteButton;
	//
	private TableViewer clientTableViewer;
	private Button clientAddButton;
	private Button clientDeleteButton;
	//
	private Text actionNameText;
	private Combo actionTypeCombo;
	private Text callbackNameText;
	
	private Text descriptionText;
	private Text goalText;
	private Text feedbackText;
	private Text resultText;
	//
	private ActionParam preSelection;
	private ActionParam selectParam;
	//
//	private String defaultPortName;
//	private String defaultPortType;
//	private String defaultPortVarName;
//	private String[] defaultTypeList;
//	
//	private List<DataParam> typeList = new ArrayList<DataParam>();
//	private List<DataParam> currentList = new ArrayList<DataParam>();

	public void setDefaultTypeList(String[] defaultTypeList) {
//		this.defaultTypeList = defaultTypeList;
	}
	/**
	 * コンストラクタ
	 *
	 * @param editor
	 *            親のエディタ
	 */
	public ActionEditorFormPage(ROSBuilderEditor editor) {
		super(editor, "id", Messages.getString("IMC.ROS_ACTION_SECTION"));
		//
		preSelection = null;
		
//		IPreferenceStore store = RtcBuilderPlugin.getDefault().getPreferenceStore();
//		defaultPortName = ComponentPreferenceManager.getInstance().getDataPort_Name();
//		defaultPortType = store.getString(ComponentPreferenceManager.Generate_DataPort_Type);
//		defaultPortVarName = store.getString(ComponentPreferenceManager.Generate_DataPort_VarName);
	}

	public void updateDefaultValue() {
//		IPreferenceStore store = RtcBuilderPlugin.getDefault().getPreferenceStore();
//		defaultPortName = ComponentPreferenceManager.getInstance().getDataPort_Name();
//		defaultPortType = store.getString(ComponentPreferenceManager.Generate_DataPort_Type);
//		defaultPortVarName = store.getString(ComponentPreferenceManager.Generate_DataPort_VarName);
//		//
//		defaultTypeList = super.extractDataTypes();
	}

	/**
	 * {@inheritDoc}
	 */
	protected void createFormContent(IManagedForm managedForm) {
		ScrolledForm form = super.createBase(managedForm, Messages.getString("IMC.ROS_ACTION_SECTION"));
		FormToolkit toolkit = managedForm.getToolkit();
		//
		final Composite composite = createSectionBaseWithLabel(toolkit, form,
				Messages.getString("IMC.ROS_ACTION_TITLE"), Messages.getString("IMC.ROS_ACTION_EXPL"), 4);
		serverTableViewer = createPortSection(toolkit, composite,
				IMessageConstants.REQUIRED + Messages.getString("IMC.ROS_ACTION_TBLLBL_SERVER"), 0, true);
		clientTableViewer = createPortSection(toolkit, composite,
				IMessageConstants.REQUIRED + Messages.getString("IMC.ROS_ACTION_TBLLBL_CLENT"), 1, false);
		createHintSection(toolkit, form);

		createDetailSection(toolkit, form);
		//
		// 言語・環境ページより先にこのページが表示された場合、ここで言語を判断する
		editor.setEnabledInfoByLang();

		load();
	}

	private void createHintSection(FormToolkit toolkit, ScrolledForm form) {
		Composite composite = createHintSectionBase(toolkit, form, 2);
		//
		createHintLabel(Messages.getString("IMC.ROS_ACTION_HINT_ACTION_TITLE"), IMessageConstantsROS.ACTION_HINT_ACTION_EXPL, toolkit, composite);
		createHintLabel(Messages.getString("IMC.ROS_ACTION_HINT_SERVER_TITLE"), Messages.getString("IMC.ROS_ACTION_HINT_SERVER_DESC_"), toolkit, composite);
		createHintLabel(Messages.getString("IMC.ROS_ACTION_HINT_CLIENT_TITLE"), Messages.getString("IMC.ROS_ACTION_HINT_CLIENT_DESC"), toolkit, composite);
		createHintSpace(toolkit, composite);
		createHintSpace(toolkit, composite);
		createHintSpace(toolkit, composite);
		createHintLabel(Messages.getString("IMC.ROS_ACTION_LBL_ACTIONNAME"), Messages.getString("IMC.ROS_ACTION_HINT_ACTION_NAME_DESC"), toolkit, composite);
		createHintLabel(Messages.getString("IMC.ROS_ACTION_LBL_ACTIONTYPE"), Messages.getString("IMC.ROS_ACTION_HINT_ACTION_TYPE_DESC"), toolkit, composite);
		createHintLabel(Messages.getString("IMC.ROS_ACTION_LBL_CALLBACK"), IMessageConstantsROS.ACTION_HINT_CALLBACK_EXPL, toolkit, composite);
		//
		createHintSpace(toolkit, composite);
		createHintLabel(Messages.getString("IMC.HINT_DOCUMENT_TITLE"), "", toolkit, composite);
		createHintLabel(Messages.getString("IMC.DATAPORT_LBL_DESCRIPTION"), Messages.getString("IMC.ROS_ACTION_HINT_DESCRIPTION_DESC"), toolkit, composite);
		createHintLabel(Messages.getString("IMC.ROS_ACTION_LBL_GAOL"), Messages.getString("IMC.ROS_ACTION_HINT_GOAL_DESC"), toolkit, composite);
		createHintLabel(Messages.getString("IMC.ROS_ACTION_LBL_FEEDBACK"), Messages.getString("IMC.ROS_ACTION_HINT_FEEDBACK_DESC"), toolkit, composite);
		createHintLabel(Messages.getString("IMC.ROS_ACTION_LBL_RESULT"), Messages.getString("IMC.ROS_ACTION_HINT_RESULT_DESC"), toolkit, composite);
	}

	private void createDetailSection(FormToolkit toolkit, ScrolledForm form) {
		Composite composite = createSectionBaseWithLabel(toolkit, form,
				"Detail", IMessageConstantsROS.ACTION_DOCUMENT_EXPL, 2, 2);
		//
		actionNameText = createLabelAndRefText(toolkit, composite,
				Messages.getString("IMC.ROS_ACTION_LBL_ACTIONNAME"), SWT.BORDER, 1);
		//
		Group detailGroup = new Group(composite, SWT.SHADOW_ETCHED_IN);
		detailGroup.setLayout(new GridLayout(4, false));
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		detailGroup.setLayoutData(gd);
		//
		Label label = toolkit.createLabel(detailGroup, IMessageConstants.REQUIRED + Messages.getString("IMC.ROS_ACTION_LBL_ACTIONTYPE"));
		label.setForeground(getSite().getShell().getDisplay().getSystemColor(SWT.COLOR_RED));
		actionTypeCombo = new Combo(detailGroup, SWT.DROP_DOWN);
		/////
//		List<DataTypeParam> dataTypes = editor.getGeneratorParam().getDataTypeParams();
//		typeList.clear();
//		for(DataTypeParam each : dataTypes) {
//			for(String eachType : each.getDefinedTypes()) {
//				typeList.add(new DataParam(eachType, each.getDispPath()));
//			}
//		}
//		Collections.sort(typeList, new DataParamComparator());
//		currentList.clear();
//		currentList.addAll(typeList);
//		for(DataParam item : currentList) {
//			actionTypeCombo.add(item.typeName);
//		}
		/////
		actionTypeCombo.setText("");
		actionTypeCombo.addKeyListener(new KeyListener() {
			public void keyReleased(KeyEvent e) {
//				String target = actionTypeCombo.getText();
//				String[] keyList = target.split(" ");
//				currentList.clear();
//				for (DataParam each : typeList) {
//					boolean isHit = true;
//					for(String itemKey: keyList) {
//					  if (each.typeName.contains(itemKey)==false) {
//						  isHit = false;
//						  break;
//					  }
//					}
//					if (isHit) {
//						currentList.add(each);
//					}
//				}
//				Collections.sort(currentList, new DataParamComparator());
//				actionTypeCombo.removeAll();
//				for(DataParam item : currentList) {
//					actionTypeCombo.add(item.typeName);
//				}
//				actionTypeCombo.setText(target);
//				actionTypeCombo.setSelection(new Point(actionTypeCombo.getText().length(), actionTypeCombo.getText().length()) );
			}
			public void keyPressed(KeyEvent e) { }
		});
		GridData gdcombo = new GridData(GridData.FILL_HORIZONTAL);
		gdcombo.horizontalSpan = 2;
		actionTypeCombo.setLayoutData(gdcombo);

		Button selectButton = toolkit.createButton(detailGroup, "Select", SWT.PUSH);
		selectButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
//				defaultTypeList = extractDataTypes();
//				/////
//				List<DataTypeParam> dataTypes = editor.getGeneratorParam().getDataTypeParams();
//				typeList.clear();
//				actionTypeCombo.removeAll();
//				for(DataTypeParam each : dataTypes) {
//					for(String eachType : each.getDefinedTypes()) {
//						typeList.add(new DataParam(eachType, each.getDispPath()));
//					}
//				}
//				Collections.sort(typeList, new DataParamComparator());
//				currentList.clear();
//				currentList.addAll(typeList);
//				for(DataParam item : currentList) {
//					actionTypeCombo.add(item.typeName);
//				}
			}
		});
		/////
		callbackNameText = createLabelAndText(toolkit, detailGroup,
				Messages.getString("IMC.ROS_ACTION_LBL_CALLBACK"), SWT.NONE, SWT.COLOR_BLACK, 2, 2);

		/////
		Group documentGroup = new Group(composite, SWT.SHADOW_ETCHED_IN);
		documentGroup.setLayout(new GridLayout(2, false));
		documentGroup.setText("Documentation");
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		documentGroup.setLayoutData(gd);
		//
		descriptionText = createLabelAndText(toolkit, documentGroup,
				Messages.getString("IMC.DATAPORT_LBL_DESCRIPTION"), SWT.MULTI | SWT.V_SCROLL | SWT.WRAP | SWT.BORDER);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.heightHint = 50;
		descriptionText.setLayoutData(gridData);
		goalText = createLabelAndText(toolkit, documentGroup,
				Messages.getString("IMC.ROS_ACTION_LBL_GAOL"), SWT.BORDER);
		feedbackText = createLabelAndText(toolkit, documentGroup,
				Messages.getString("IMC.ROS_ACTION_LBL_FEEDBACK"), SWT.MULTI | SWT.V_SCROLL | SWT.WRAP | SWT.BORDER);
		feedbackText.setLayoutData(gridData);
		resultText = createLabelAndText(toolkit, documentGroup,
				Messages.getString("IMC.ROS_ACTION_LBL_RESULT"), SWT.MULTI | SWT.V_SCROLL | SWT.WRAP | SWT.BORDER);
		resultText.setLayoutData(gridData);
	}

	private TableViewer createPortSection(FormToolkit toolkit, Composite parent,
			String columnLabel, final int initSel, boolean isInPort) {

		final TableViewer actionTableViewer = createTableViewer(toolkit,	parent, 70);

		final TableViewerColumn col = super.createColumn(actionTableViewer, columnLabel, IRtcBuilderConstants.SINGLE_COLUMN_WIDTH);
		col.setEditingSupport(new ActionEditingSuport(actionTableViewer));
//		col.getColumn().setResizable(false);
		actionTableViewer.setLabelProvider(new ActionParamLabelProvider());
		//
		parent.addControlListener(new ControlAdapter() {
			public void controlResized(ControlEvent e) {
				Point size = actionTableViewer.getControl().getSize();
				ScrollBar vBar = actionTableViewer.getTable().getVerticalBar();
				col.getColumn().setWidth(size.x- vBar.getSize().x*2);
			}
		});
		//
		Composite buttonComposite = toolkit.createComposite(parent, SWT.NONE);
		GridLayout gl = new GridLayout();
		gl.marginWidth = 1;
		buttonComposite.setLayout(gl);
		GridData gd = new GridData();
		gd.verticalAlignment = SWT.BEGINNING;
		gd.widthHint = 50;
		buttonComposite.setLayoutData(gd);

		Button addButton = toolkit.createButton(buttonComposite, "Add", SWT.PUSH);
		addButton.addSelectionListener(new SelectionAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void widgetSelected(SelectionEvent e) {
				String selected = actionTypeCombo.getText();
				updateDefaultValue();
				ActionParam selectParam = new ActionParam();
				selectParam.setName("new_action");
				((List) actionTableViewer.getInput()).add(selectParam);
				actionTableViewer.refresh();
				update();
				actionTableViewer.setSelection(new StructuredSelection(selectParam), true);
				actionTypeCombo.setText(selected);
			}
		});
		gd = new GridData(GridData.FILL_HORIZONTAL);
		addButton.setLayoutData(gd);
		//
		Button deleteButton = toolkit.createButton(buttonComposite, "Delete", SWT.PUSH);
		deleteButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int selectionIndex = actionTableViewer.getTable()
						.getSelectionIndex();
				if (selectionIndex >= 0
						&& ((List) actionTableViewer.getInput()).size() >= selectionIndex + 1) {
					((List) actionTableViewer.getInput())
							.remove(selectionIndex);
					actionTableViewer.refresh();
					preSelection = null;
					clearText();
					update();
				}
			}
		});
		gd = new GridData(GridData.FILL_HORIZONTAL);
		deleteButton.setLayoutData(gd);
		//
		actionTableViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				setDocumentContents();
				StructuredSelection selection = (StructuredSelection)event.getSelection();
				selectParam = (ActionParam)selection.getFirstElement();
				if( selectParam != null ) {
					StringBuffer portName = new StringBuffer(selectParam.getName());
					if(event.getSource().equals(serverTableViewer)) {
						portName.append(" (ActionServer)");
					} else {
						portName.append(" (ActionClient)");
					}
					actionNameText.setText(portName.toString());
					actionTypeCombo.setText(selectParam.getType());
					callbackNameText.setText(selectParam.getCallbackName());
					descriptionText.setText(StringUtil.getDisplayDocText(selectParam.getDocDescription()));
					goalText.setText(StringUtil.getDisplayDocText(selectParam.getDocGoal()));
					feedbackText.setText(StringUtil.getDisplayDocText(selectParam.getDocFeedback()));
					resultText.setText(StringUtil.getDisplayDocText(selectParam.getDocResult()));
					preSelection = selectParam;
				}
			}
		});

		if( isInPort ) {
			serverAddButton = addButton;
			serverDeleteButton = deleteButton;
		} else {
			clientAddButton = addButton;
			clientDeleteButton = deleteButton;
		}

		return actionTableViewer;
	}

	public void update() {
		if (selectParam != null) {
			selectParam.setType(actionTypeCombo.getText());
			selectParam.setCallbackName(callbackNameText.getText());
			
			selectParam.setDocDescription(StringUtil.getDocText(descriptionText.getText()));
			selectParam.setDocGoal(StringUtil.getDocText(goalText.getText()));
			selectParam.setDocFeedback(StringUtil.getDocText(feedbackText.getText()));
			selectParam.setDocResult(StringUtil.getDocText(resultText.getText()));
		}
		//
		ROSParam rosParam = ((ROSBuilderEditor)editor).getROSParam();
		((ROSBuilderEditor)editor).updateEMFPorts(
				rosParam.getTopicSubscribes(), rosParam.getTopicPublishes(),
				rosParam.getServiceServers(), rosParam.getServiceClients(),
				rosParam.getActionServers(), rosParam.getActionClients());
		((ROSBuilderEditor)editor).updateDirty();
	}

	public void updateForOutput() {
		update();
		setDocumentContents();
	}

	private void setDocumentContents() {
		if( preSelection != null ) {
			preSelection.setType(actionTypeCombo.getText());
			preSelection.setCallbackName(callbackNameText.getText());
			//
			preSelection.setDocDescription(StringUtil.getDocText(descriptionText.getText()));
			preSelection.setDocGoal(StringUtil.getDocText(goalText.getText()));
			preSelection.setDocFeedback(StringUtil.getDocText(feedbackText.getText()));
			preSelection.setDocResult(StringUtil.getDocText(resultText.getText()));
		}
	}

	private void clearText() {
		actionNameText.setText("");
		actionTypeCombo.select(0);
		callbackNameText.setText("");
		
		descriptionText.setText("");
		goalText.setText("");
		feedbackText.setText("");
		resultText.setText("");
	}

	/**
	 * データをロードする
	 */
	public void load() {
		if (serverTableViewer == null) return;
		
		ROSParam rosParam = ((ROSBuilderEditor)editor).getROSParam();
		clientTableViewer.setInput(rosParam.getActionClients());
		serverTableViewer.setInput(rosParam.getActionServers());
		//Mac版では列の幅が最小化してしまうため，再度列幅を設定
		clientTableViewer.getTable().getColumn(0).setWidth(IRtcBuilderConstants.SINGLE_COLUMN_WIDTH);
		serverTableViewer.getTable().getColumn(0).setWidth(IRtcBuilderConstants.SINGLE_COLUMN_WIDTH);
		//
		StructuredSelection selection = (StructuredSelection) clientTableViewer
				.getSelection();
		ActionParam outParam = (ActionParam) selection.getFirstElement();
		selection = (StructuredSelection) serverTableViewer.getSelection();
		ActionParam inParam = (ActionParam) selection.getFirstElement();
		if (outParam == null && inParam == null) clearText();
		//
		((ROSBuilderEditor)editor).updateEMFPorts(
				rosParam.getTopicSubscribes(), rosParam.getTopicPublishes(),
				rosParam.getServiceServers(), rosParam.getServiceClients(),
				rosParam.getActionServers(), rosParam.getActionClients());
	}

	public String validateParam() {
		String result = null;

		RtcParam rtcParam = editor.getRtcParam();
		Set<String> checkSet = new HashSet<String>();
		Set<String> checkVarSet = new HashSet<String>();

		for(DataPortParam dataport : rtcParam.getInports()) {
			result = checkDataPort(dataport, checkSet, checkVarSet);
			if( result != null) return result;
		}
		//
		for(DataPortParam dataport : rtcParam.getOutports()) {
			result = checkDataPort(dataport, checkSet, checkVarSet);
			if( result != null) return result;
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	private String checkDataPort(DataPortParam dataport, Set checkSet, Set checkVarSet) {
		String result = ValidationUtil.validateDataPort(dataport);
		if( result!=null ) return result;
		//名称重複
		if( checkSet.contains(dataport.getName()) ) {
			return IMessageConstants.DATAPORT_VALIDATE_DUPLICATE;
		}
		checkSet.add(dataport.getName());
		//変数名重複
		if( checkVarSet.contains(dataport.getTmplVarName()) ) {
			return IMessageConstants.DATAPORT_VALIDATE_VAR_DUPLICATE;
		}
		checkVarSet.add(dataport.getTmplVarName());
		//型存在チェック
//		if(Arrays.asList(defaultTypeList).contains(dataport.getType().trim())==false) {
//			return IMessageConstants.DATAPORT_VALIDATE_PORTTYPE_INVALID;
//		}
		return null;
	}

	private class ActionParamLabelProvider extends LabelProvider implements ITableLabelProvider {
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof ActionParam == false) return null;
			ActionParam param = (ActionParam) element;
			return param.getName();
		}
	}

	private class ActionEditingSuport extends EditingSupport {
		private CellEditor editor;

		public ActionEditingSuport(ColumnViewer viewer) {
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
			if (element instanceof ActionParam == false) return null;
			ActionParam param = (ActionParam) element;
			return param.getName();
		}

		@Override
		protected void setValue(Object element, Object value) {
			if (element instanceof ActionParam == false) return;
			ActionParam param = (ActionParam) element;

			param.setName((String) value);
			StringBuffer portName = new StringBuffer(param.getName());
			if( this.getViewer()==serverTableViewer ) {
				portName.append(" (ActionServer)");
			} else {
				portName.append(" (ActionClient)");
			}
			actionNameText.setText(portName.toString());

			getViewer().update(element, null);
			update();
		}
	}

	/**
	 * DataPortフォーム内の要素の有効/無効を設定します。
	 * <ul>
	 * <li>dataport.inPort.table : InPortセクションのテーブル</li>
	 * <li>dataport.inPort.addButton : InPortセクションの Addボタン</li>
	 * <li>dataport.inPort.deleteButton : InPortセクションの Deleteボタン</li>
	 * <li>dataport.outPort.table : OutPortセクションのテーブル</li>
	 * <li>dataport.outPort.addButton : OutPortセクションの Addボタン</li>
	 * <li>dataport.outPort.deleteButton : OutPortセクションの Deleteボタン</li>
	 * </ul>
	 */
	public void setEnabledInfo(WidgetInfo widgetInfo, boolean enabled) {
		if (widgetInfo.matchSection("inPort")) {
			if (serverTableViewer != null) {
				if (widgetInfo.matchWidget("table"))        setViewerEnabled(serverTableViewer, enabled);
				if (widgetInfo.matchWidget("addButton"))    setButtonEnabled(serverAddButton, enabled);
				if (widgetInfo.matchWidget("deleteButton")) setButtonEnabled(serverDeleteButton, enabled);
			}
		}
		if (widgetInfo.matchSection("outPort")) {
			if (clientTableViewer != null) {
				if (widgetInfo.matchWidget("table"))        setViewerEnabled(clientTableViewer, enabled);
				if (widgetInfo.matchWidget("addButton"))    setButtonEnabled(clientAddButton, enabled);
				if (widgetInfo.matchWidget("deleteButton")) setButtonEnabled(clientDeleteButton, enabled);
			}
		}
	}
	
	private class DataParam {
		private String typeName;
		private String idlPath;
		
		public DataParam(String typeName, String idlPath) {
			this.typeName = typeName;
			this.idlPath = idlPath;
		}
	}
	private class DataParamComparator implements Comparator<DataParam> {
		@Override
		public int compare(DataParam p1, DataParam p2) {
			return p1.typeName.compareTo(p2.typeName);
		}
	}}
