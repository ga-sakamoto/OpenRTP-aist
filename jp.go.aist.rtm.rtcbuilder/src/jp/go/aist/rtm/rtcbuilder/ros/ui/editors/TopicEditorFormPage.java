package jp.go.aist.rtm.rtcbuilder.ros.ui.editors;

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
import org.eclipse.swt.events.SelectionListener;
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
import jp.go.aist.rtm.rtcbuilder.nl.Messages;
import jp.go.aist.rtm.rtcbuilder.ros.param.ROSParam;
import jp.go.aist.rtm.rtcbuilder.ros.param.TopicParam;
import jp.go.aist.rtm.rtcbuilder.ui.editors.AbstractEditorFormPage;
import jp.go.aist.rtm.rtcbuilder.ui.editors.IMessageConstants;
import jp.go.aist.rtm.rtcbuilder.util.StringUtil;

/**
 * Topicページ
 */
public class TopicEditorFormPage extends AbstractEditorFormPage {

	private TableViewer subscribeTableViewer;
	private Button subscribeAddButton;
	private Button subscribeDeleteButton;
	//
	private TableViewer publishTableViewer;
	private Button publishAddButton;
	private Button publishDeleteButton;
	//
	private Text topicNameText;
	private Combo messageTypeCombo;
	private Combo reliabilityCombo;
	private Combo historyCombo;
	private Text depthText;
	private Text variableNameText;
	
	private Text descriptionText;
	private Text typeText;
	private Text semanticsText;
	private Text unitText;
	private Text occurrenceText;
	//
	private TopicParam preSelection;
	private TopicParam selectParam;
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
	public TopicEditorFormPage(ROSBuilderEditor editor) {
		super(editor, "id", Messages.getString("IMC.ROS_TOPIC_SECTION"));
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
		ScrolledForm form = super.createBase(managedForm, Messages.getString("IMC.ROS_TOPIC_SECTION"));
		FormToolkit toolkit = managedForm.getToolkit();
		//
		final Composite composite = createSectionBaseWithLabel(toolkit, form,
				Messages.getString("IMC.ROS_TOPIC_TITLE"), Messages.getString("IMC.ROS_TOPIC_EXPL"), 4);
		subscribeTableViewer = createPortSection(toolkit, composite,
				IMessageConstants.REQUIRED + Messages.getString("IMC.ROS_TOPIC_TBLLBL_INPORTNAME"), 0, true);
		publishTableViewer = createPortSection(toolkit, composite,
				IMessageConstants.REQUIRED + Messages.getString("IMC.ROS_TOPIC_TBLLBL_OUTPORTNAME"), 1, false);
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
		createHintLabel(Messages.getString("IMC.ROS_TOPIC_HINT_TOPIC_TITLE"), IMessageConstantsROS.TOPIC_HINT_TOPIC_EXPL, toolkit, composite);
		createHintLabel(Messages.getString("IMC.ROS_TOPIC_HINT_SUBSCRIBE_TITLE"), IMessageConstantsROS.TOPIC_HINT_SUBSCRIBE_EXPL, toolkit, composite);
		createHintLabel(Messages.getString("IMC.ROS_TOPIC_HINT_PUBLISH_TITLE"), Messages.getString("IMC.ROS_TOPIC_HINT_PUBLISH_DESC"), toolkit, composite);
		createHintSpace(toolkit, composite);
		createHintLabel(Messages.getString("IMC.ROS_TOPIC_LBL_TOPICNAME"), IMessageConstantsROS.TOPIC_HINT_TOPIC_NAME_EXPL, toolkit, composite);
		createHintLabel(Messages.getString("IMC.ROS_TOPIC_LBL_DATATYPE"), Messages.getString("IMC.ROS_TOPIC_HINT_MESSAGE_TYPE_DESC"), toolkit, composite);
		createHintLabel(Messages.getString("IMC.ROS_TOPIC_HINT_QoS_TITLE"), Messages.getString("IMC.ROS_TOPIC_HINT_QoS_DESC"), toolkit, composite);
		createHintLabel(Messages.getString("IMC.ROS_TOPIC_HINT_RELIABILITY_TITLE"), IMessageConstantsROS.TOPIC_HINT_RELIABILITY_EXPL, toolkit, composite);
		createHintLabel(Messages.getString("IMC.ROS_TOPIC_HINT_HISTORY_TITLE"), IMessageConstantsROS.TOPIC_HINT_HISTORY_EXPL, toolkit, composite);
		createHintLabel(Messages.getString("IMC.ROS_TOPIC_LBL_VARNAME"), "", toolkit, composite);
		createHintLabel(Messages.getString("IMC.ROS_TOPIC_HINT_VARNAME_SUBSCRIBE_TITLE"), Messages.getString("IMC.ROS_TOPIC_HINT_VARNAME_SUBSCRIBE_DESC"), toolkit, composite);
		createHintLabel(Messages.getString("IMC.ROS_TOPIC_HINT_VARNAME_PUBLISH_TITLE"), IMessageConstantsROS.TOPIC_HINT_VARNAME_PUBLISH_EXPL, toolkit, composite);
		//
		createHintSpace(toolkit, composite);
		createHintLabel(Messages.getString("IMC.HINT_DOCUMENT_TITLE"), "", toolkit, composite);
		createHintLabel(Messages.getString("IMC.DATAPORT_LBL_DESCRIPTION"), Messages.getString("IMC.ROS_TOPIC_HINT_DOC_OVERVIEW"), toolkit, composite);
		createHintLabel(Messages.getString("IMC.DATAPORT_LBL_PORTTYPE"), Messages.getString("IMC.ROS_TOPIC_HINT_DOC_DATATYPE"), toolkit, composite);
		createHintLabel(Messages.getString("IMC.DATAPORT_LBL_SEMANTICS"), Messages.getString("IMC.ROS_TOPIC_HINT_DOC_DETAIL"), toolkit, composite);
		createHintLabel(Messages.getString("IMC.DATAPORT_LBL_UNIT"), Messages.getString("IMC.ROS_TOPIC_HINT_DOC_UNIT"), toolkit, composite);
		createHintLabel(Messages.getString("IMC.DATAPORT_LBL_OCCUR"), IMessageConstantsROS.TOPIC_HINT_DOC_OCCUR_EXPL, toolkit, composite);
	}

	private void createDetailSection(FormToolkit toolkit, ScrolledForm form) {
		Composite composite = createSectionBaseWithLabel(toolkit, form,
				"Detail", IMessageConstantsROS.TOPIC_DOCUMENT_EXPL, 2, 2);
		//
		topicNameText = createLabelAndRefText(toolkit, composite,
				Messages.getString("IMC.ROS_TOPIC_LBL_TOPICNAME"), SWT.BORDER, 1);
		//
		Group detailGroup = new Group(composite, SWT.SHADOW_ETCHED_IN);
		detailGroup.setLayout(new GridLayout(4, false));
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		detailGroup.setLayoutData(gd);
		//
		Label label = toolkit.createLabel(detailGroup, IMessageConstants.REQUIRED + Messages.getString("IMC.ROS_TOPIC_LBL_DATATYPE"));
		label.setForeground(getSite().getShell().getDisplay().getSystemColor(SWT.COLOR_RED));
		messageTypeCombo = new Combo(detailGroup, SWT.DROP_DOWN);
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
//			messageTypeCombo.add(item.typeName);
//		}
		/////
		messageTypeCombo.setText("");
		messageTypeCombo.addKeyListener(new KeyListener() {
			public void keyReleased(KeyEvent e) {
//				String target = messageTypeCombo.getText();
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
//				messageTypeCombo.removeAll();
//				for(DataParam item : currentList) {
//					messageTypeCombo.add(item.typeName);
//				}
//				messageTypeCombo.setText(target);
//				messageTypeCombo.setSelection(new Point(messageTypeCombo.getText().length(), messageTypeCombo.getText().length()) );
			}
			public void keyPressed(KeyEvent e) { }
		});
		GridData gdcombo = new GridData(GridData.FILL_HORIZONTAL);
		gdcombo.horizontalSpan = 2;
		messageTypeCombo.setLayoutData(gdcombo);

		Button selectButton = toolkit.createButton(detailGroup, "Select", SWT.PUSH);
		selectButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
//				defaultTypeList = extractDataTypes();
//				/////
//				List<DataTypeParam> dataTypes = editor.getGeneratorParam().getDataTypeParams();
//				typeList.clear();
//				messageTypeCombo.removeAll();
//				for(DataTypeParam each : dataTypes) {
//					for(String eachType : each.getDefinedTypes()) {
//						typeList.add(new DataParam(eachType, each.getDispPath()));
//					}
//				}
//				Collections.sort(typeList, new DataParamComparator());
//				currentList.clear();
//				currentList.addAll(typeList);
//				for(DataParam item : currentList) {
//					messageTypeCombo.add(item.typeName);
//				}
			}
		});
		//
		Group qoSGroup = new Group(detailGroup, SWT.SHADOW_ETCHED_IN);
		qoSGroup.setLayout(new GridLayout(6, false));
		qoSGroup.setText("QoS");
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 4;
		qoSGroup.setLayoutData(gd);
		
		reliabilityCombo = createCombo(toolkit, qoSGroup, 
										Messages.getString("IMC.ROS_TOPIC_LBL_RELIABILITY"),
										new String[] {"Reliable", "Best_Effort"});
		historyCombo = createCombo(toolkit, qoSGroup, 
				Messages.getString("IMC.ROS_TOPIC_LBL_HISTORY"),
				new String[] {"KeepLast", "KeepAll"});

		historyCombo.addSelectionListener(new SelectionListener() {
			  public void widgetDefaultSelected(SelectionEvent e){}
			  public void widgetSelected(SelectionEvent e){
				  depthText.setEnabled(historyCombo.getSelectionIndex() == 0);
				  update();
			  }
			});

		depthText = createLabelAndText(toolkit, qoSGroup,
				Messages.getString("IMC.ROS_TOPIC_LBL_DEPTH"), SWT.BORDER);
		/////
		variableNameText = createLabelAndText(toolkit, detailGroup,
				Messages.getString("IMC.ROS_TOPIC_LBL_VARNAME"), SWT.NONE, SWT.COLOR_BLACK, 2, 2);

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
		typeText = createLabelAndText(toolkit, documentGroup,
				Messages.getString("IMC.DATAPORT_LBL_PORTTYPE"), SWT.BORDER);
		semanticsText = createLabelAndText(toolkit, documentGroup,
				Messages.getString("IMC.DATAPORT_LBL_SEMANTICS"), SWT.MULTI | SWT.V_SCROLL | SWT.WRAP | SWT.BORDER);
		semanticsText.setLayoutData(gridData);
		unitText = createLabelAndText(toolkit, documentGroup,
				Messages.getString("IMC.DATAPORT_LBL_UNIT"), SWT.BORDER);
		occurrenceText = createLabelAndText(toolkit, documentGroup,
				Messages.getString("IMC.DATAPORT_LBL_OCCUR"), SWT.MULTI | SWT.V_SCROLL | SWT.WRAP | SWT.BORDER);
		occurrenceText.setLayoutData(gridData);
	}

	private TableViewer createPortSection(FormToolkit toolkit, Composite parent,
			String columnLabel, final int initSel, boolean isInPort) {

		final TableViewer topicTableViewer = createTableViewer(toolkit,	parent, 70);

		final TableViewerColumn col = super.createColumn(topicTableViewer, columnLabel, IRtcBuilderConstants.SINGLE_COLUMN_WIDTH);
		col.setEditingSupport(new TopicEditingSuport(topicTableViewer));
//		col.getColumn().setResizable(false);
		topicTableViewer.setLabelProvider(new TopicParamLabelProvider());
		//
		parent.addControlListener(new ControlAdapter() {
			public void controlResized(ControlEvent e) {
				Point size = topicTableViewer.getControl().getSize();
				ScrollBar vBar = topicTableViewer.getTable().getVerticalBar();
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
				String selected = messageTypeCombo.getText();
				updateDefaultValue();
				TopicParam selectParam = new TopicParam();
				selectParam.setName("new_topic");
				selectParam.setReliabilityType("Reliable");
				selectParam.setHistoryType("KeepLast");
				selectParam.setDepth(10);
				((List) topicTableViewer.getInput()).add(selectParam);
				topicTableViewer.refresh();
				update();
				topicTableViewer.setSelection(new StructuredSelection(selectParam), true);
				messageTypeCombo.setText(selected);
			}
		});
		gd = new GridData(GridData.FILL_HORIZONTAL);
		addButton.setLayoutData(gd);
		//
		Button deleteButton = toolkit.createButton(buttonComposite, "Delete", SWT.PUSH);
		deleteButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int selectionIndex = topicTableViewer.getTable()
						.getSelectionIndex();
				if (selectionIndex >= 0
						&& ((List) topicTableViewer.getInput()).size() >= selectionIndex + 1) {
					((List) topicTableViewer.getInput())
							.remove(selectionIndex);
					topicTableViewer.refresh();
					preSelection = null;
					clearText();
					update();
				}
			}
		});
		gd = new GridData(GridData.FILL_HORIZONTAL);
		deleteButton.setLayoutData(gd);
		//
		topicTableViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				setDocumentContents();
				StructuredSelection selection = (StructuredSelection)event.getSelection();
				selectParam = (TopicParam)selection.getFirstElement();
				if( selectParam != null ) {
					StringBuffer portName = new StringBuffer(selectParam.getName());
					if(event.getSource().equals(subscribeTableViewer)) {
						portName.append(" (Subscribe)");
					} else {
						portName.append(" (Publish)");
					}
					topicNameText.setText(portName.toString());
					messageTypeCombo.setText(selectParam.getMessageType());
					reliabilityCombo.setText(selectParam.getReliabilityType());
					historyCombo.setText(selectParam.getHistoryType());
					depthText.setText(selectParam.getDepth().toString());
					depthText.setEnabled(historyCombo.getSelectionIndex() == 0);
					variableNameText.setText(selectParam.getVar_callback_name());
					
					descriptionText.setText(StringUtil.getDisplayDocText(selectParam.getDoc_description()));
					typeText.setText(StringUtil.getDisplayDocText(selectParam.getDoc_type()));
					semanticsText.setText(StringUtil.getDisplayDocText(selectParam.getDoc_semantics()));
					unitText.setText(StringUtil.getDisplayDocText(selectParam.getDoc_unit()));
					occurrenceText.setText(StringUtil.getDisplayDocText(selectParam.getDoc_occurrence()));
					preSelection = selectParam;
				}
			}
		});

		if( isInPort ) {
			subscribeAddButton = addButton;
			subscribeDeleteButton = deleteButton;
		} else {
			publishAddButton = addButton;
			publishDeleteButton = deleteButton;
		}

		return topicTableViewer;
	}

	public void update() {
		if (selectParam != null) {
			selectParam.setMessageType(messageTypeCombo.getText());

			selectParam.setReliabilityType(reliabilityCombo.getText());
			selectParam.setHistoryType(historyCombo.getText());
			try {
				int depth = 0;
				depth = Integer.parseInt(depthText.getText());
				selectParam.setDepth(depth);
			} catch (Exception ex){
			}
			
			selectParam.setVar_callback_name(variableNameText.getText());

			selectParam.setDoc_description(StringUtil.getDocText(descriptionText.getText()));
			selectParam.setDoc_type(StringUtil.getDocText(typeText.getText()));
			selectParam.setDoc_semantics(StringUtil.getDocText(semanticsText.getText()));
			selectParam.setDoc_unit(StringUtil.getDocText(unitText.getText()));
			selectParam.setDoc_occurrence(StringUtil.getDocText(occurrenceText.getText()));
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
			preSelection.setMessageType(messageTypeCombo.getText());
			
			preSelection.setReliabilityType(reliabilityCombo.getText());
			preSelection.setHistoryType(historyCombo.getText());
			try {
				int depth = 0;
				depth = Integer.parseInt(depthText.getText());
				preSelection.setDepth(depth);
			} catch (Exception ex){
			}
			preSelection.setVar_callback_name(variableNameText.getText());
			//
			preSelection.setDoc_description(StringUtil.getDocText(descriptionText.getText()));
			preSelection.setDoc_type(StringUtil.getDocText(typeText.getText()));
			preSelection.setDoc_semantics(StringUtil.getDocText(semanticsText.getText()));
			preSelection.setDoc_unit(StringUtil.getDocText(unitText.getText()));
			preSelection.setDoc_occurrence(StringUtil.getDocText(occurrenceText.getText()));
		}
	}

	private void clearText() {
		topicNameText.setText("");
		messageTypeCombo.setText("");
		reliabilityCombo.select(0);
		historyCombo.select(0);
		depthText.setText("");
		variableNameText.setText("");
		
		descriptionText.setText("");
		typeText.setText("");
		semanticsText.setText("");
		unitText.setText("");
		occurrenceText.setText("");
	}

	/**
	 * データをロードする
	 */
	public void load() {
		if (subscribeTableViewer == null) return;
		
		ROSParam rosParam = ((ROSBuilderEditor)editor).getROSParam();
		publishTableViewer.setInput(rosParam.getTopicPublishes());
		subscribeTableViewer.setInput(rosParam.getTopicSubscribes());
		//Mac版では列の幅が最小化してしまうため，再度列幅を設定
		publishTableViewer.getTable().getColumn(0).setWidth(IRtcBuilderConstants.SINGLE_COLUMN_WIDTH);
		subscribeTableViewer.getTable().getColumn(0).setWidth(IRtcBuilderConstants.SINGLE_COLUMN_WIDTH);
		//
		StructuredSelection selection = (StructuredSelection) publishTableViewer
				.getSelection();
		TopicParam outParam = (TopicParam) selection.getFirstElement();
		selection = (StructuredSelection) subscribeTableViewer.getSelection();
		TopicParam inParam = (TopicParam) selection.getFirstElement();
		if (outParam == null && inParam == null) clearText();
		//
		((ROSBuilderEditor)editor).updateEMFPorts(
				rosParam.getTopicSubscribes(), rosParam.getTopicPublishes(),
				rosParam.getServiceServers(), rosParam.getServiceClients(),
				rosParam.getActionServers(), rosParam.getActionClients());
	}

	public String validateParam() {
		String result = null;

		ROSParam rosParam = ((ROSBuilderEditor)editor).getROSParam();
		Set<String> checkSet = new HashSet<String>();
		Set<String> checkVarSet = new HashSet<String>();

		for(TopicParam topic : rosParam.getTopicSubscribes()) {
			result = checkTopic(topic, checkSet, checkVarSet);
			if( result != null) return result;
		}
		//
		for(TopicParam topic : rosParam.getTopicPublishes()) {
			result = checkTopic(topic, checkSet, checkVarSet);
			if( result != null) return result;
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	private String checkTopic(TopicParam topic, Set checkSet, Set checkVarSet) {
		if( topic.getName()==null || topic.getName().length()==0 ) {
			return Messages.getString("IMC.VALIDATE_TOPIC_NAME");
		}
//		if( !StringUtil.checkDigitAlphabet(topic.getName()) ) {
//			return IMessageConstants.DATAPORT_VALIDATE_PORTNAME2;
//		}
		//
		if( topic.getMessageType()==null || topic.getMessageType().length()==0 ) {
			return Messages.getString("IMC.VALIDATE_TOPIC_TYPE");
		}
		
		if(topic.getHistoryType().equals("KeepLast")) {
			if(topic.getDepth() < 1) {
				return Messages.getString("IMC.VALIDATE_TOPIC_DEPTH");
			}
		}
		//名称重複
		if( checkSet.contains(topic.getName()) ) {
			return Messages.getString("IMC.VALIDATE_TOPIC_DUPLICATE");
		}
		checkSet.add(topic.getName());
		//変数名重複
//		if( checkVarSet.contains(dataport.getTmplVarName()) ) {
//			return IMessageConstants.DATAPORT_VALIDATE_VAR_DUPLICATE;
//		}
//		checkVarSet.add(dataport.getTmplVarName());
		//型存在チェック
//		if(Arrays.asList(defaultTypeList).contains(dataport.getType().trim())==false) {
//			return IMessageConstants.DATAPORT_VALIDATE_PORTTYPE_INVALID;
//		}
		return null;
	}

	private class TopicParamLabelProvider extends LabelProvider implements ITableLabelProvider {
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof TopicParam == false) return null;
			TopicParam topicParam = (TopicParam) element;
			return topicParam.getName();
		}
	}

	private class TopicEditingSuport extends EditingSupport {
		private CellEditor editor;

		public TopicEditingSuport(ColumnViewer viewer) {
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
			if (element instanceof TopicParam == false) return null;
			TopicParam topicParam = (TopicParam) element;
			return topicParam.getName();
		}

		@Override
		protected void setValue(Object element, Object value) {
			if (element instanceof TopicParam == false) return;
			TopicParam topicParam = (TopicParam) element;

			topicParam.setName((String) value);
			StringBuffer portName = new StringBuffer(topicParam.getName());
			if( this.getViewer()==subscribeTableViewer ) {
				portName.append(" (Subscribe)");
			} else {
				portName.append(" (Publish)");
			}
			topicNameText.setText(portName.toString());

			getViewer().update(element, null);
			update();
		}
	}

//	private class DataParam {
//		private String typeName;
//		private String idlPath;
//		
//		public DataParam(String typeName, String idlPath) {
//			this.typeName = typeName;
//			this.idlPath = idlPath;
//		}
//	}
//	private class DataParamComparator implements Comparator<DataParam> {
//		@Override
//		public int compare(DataParam p1, DataParam p2) {
//			return p1.typeName.compareTo(p2.typeName);
//		}
//	}
}
