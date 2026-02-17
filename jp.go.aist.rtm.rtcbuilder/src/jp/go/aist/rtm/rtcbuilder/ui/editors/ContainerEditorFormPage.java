package jp.go.aist.rtm.rtcbuilder.ui.editors;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ArrayContentProvider;
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
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseWheelListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import com.fasterxml.jackson.databind.ObjectMapper;

import jp.go.aist.rtm.rtcbuilder.RtcBuilderPlugin;
import jp.go.aist.rtm.rtcbuilder.container.param.ContainerParam;
import jp.go.aist.rtm.rtcbuilder.container.param.LibraryParam;
import jp.go.aist.rtm.rtcbuilder.container.param.RepositoryParam;
import jp.go.aist.rtm.rtcbuilder.container.param.setting.ContainerConfig;
import jp.go.aist.rtm.rtcbuilder.container.param.setting.Middleware;
import jp.go.aist.rtm.rtcbuilder.container.param.setting.Version;
import jp.go.aist.rtm.rtcbuilder.generator.param.RecordedList;
import jp.go.aist.rtm.rtcbuilder.generator.param.RtcParam;
import jp.go.aist.rtm.rtcbuilder.nl.Messages;
import jp.go.aist.rtm.rtcbuilder.ui.preference.ContainerPreferenceManager;
import jp.go.aist.rtm.rtcbuilder.util.ValidationUtil;

public class ContainerEditorFormPage extends AbstractEditorFormPage {
	private static final int EXEC_BUTTON_WIDTH = 70;
	private static final String[] LANGUAGE_ITEMS = new String[] {
			"C++", "Python" };
	private static final String[] CONFIGURATION_ITEMS = new String[] {
			"Min", "Max" };

	private String configText;

	private Text moduleNameText;
	private Text descriptionText;

	private TableViewer targetListViewer;
	private Button addTargetButton;	
	private Button deleteTargetButton;
	
	private Combo middlewareCombo;
	private Combo midVersionCombo;
	private Combo osVersionCombo;
	private Text workspaceText;
	private Combo languageCombo;
	private Combo configCombo;

	private TableViewer librariesListViewer;
	private Button addLibraryButton;	
	private Button deleteLibraryButton;

	private Text urlText;
	private Text branchText;
	private TableViewer repositoryListViewer;
	private Button addRepositoryButton;	
	private Button deleteRepositoryButton;

	private ContainerParam selectedParam;
	private ContainerConfig containerSettings;
	private Middleware selectedMiddleware;
	private Version selectedVersion;
	
	private Composite presetComposite;
	private List<Button> presetButtons = new ArrayList<Button>();
	private List<Label> presetLabels = new ArrayList<Label>();
	private Image smallInfo = null;

	private RecordedList<ContainerParam> paramList = new RecordedList<ContainerParam>();
	private List<LibraryParam> librariesList = new ArrayList<LibraryParam>();
	private List<RepositoryParam> repositoriesList = new ArrayList<RepositoryParam>();
	
	private Font cautionFont;
	private Label cautionLabel;

	/**
	 * コンストラクタ
	 * 
	 * @param editor
	 *            親のエディタ
	 */
	public ContainerEditorFormPage(RtcBuilderEditor editor) {
		super(editor, "id", Messages.getString("IMessageConstants.CONTAINER_SECTION"));
		
		configText = ContainerPreferenceManager.getInstance().getSettings();
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			containerSettings = mapper.readValue(configText, ContainerConfig.class);
			selectedMiddleware = containerSettings.getMiddlewares().get(0);
			selectedVersion = selectedMiddleware.getVersions().get(0);
		} catch (Exception e) {
			containerSettings = new ContainerConfig();
			selectedMiddleware = new Middleware();
			selectedVersion = new Version();
		}
		
		URL url = RtcBuilderPlugin.getDefault().getBundle().getEntry("/");
		ImageDescriptor hintIcon;
		try {
			hintIcon = ImageDescriptor.createFromURL(new URL(url ,"icons/question.png"));
			smallInfo = hintIcon.createImage();
		} catch (MalformedURLException e) {
		}
		/////
		paramList = editor.getRtcParam().getContainerSettings();
	}

	/**
	 * {@inheritDoc}
	 */
	protected void createFormContent(IManagedForm managedForm) {
		GridLayout gl = new GridLayout();
		gl.numColumns = 1;

		managedForm.getForm().getBody().setLayout(gl);
		managedForm.getForm().setShowFocusedControl(true);
		FormToolkit toolkit = managedForm.getToolkit();

		ScrolledForm form = toolkit.createScrolledForm(managedForm.getForm().getBody());
		gl = new GridLayout(2, false);
		gl.makeColumnsEqualWidth = true;
		form.setLayout(gl);
		GridData gd = new GridData(GridData.FILL_BOTH);
		form.setLayoutData(gd);

		form.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		toolkit.paintBordersFor(form.getBody());

		form.getBody().setLayout(gl);
		form.addMouseWheelListener(new MouseWheelListener(){
			@Override
			public void mouseScrolled(MouseEvent e) {
				int delta = e.count * 5;
				Point point =managedForm.getForm().getContent().getLocation();
				int margin = managedForm.getForm().getClientArea().height - managedForm.getForm().getContent().getSize().y;
				int newLocation = point.y + delta;
				if( 0<newLocation ) {
					newLocation = 0;
				} else if( newLocation < margin ) {
					newLocation = margin;
				}

				int selection = managedForm.getForm().getVerticalBar().getSelection();
				int newBarVal = selection - delta;
				point.y = newLocation;
				managedForm.getForm().getContent().setLocation(point);
				managedForm.getForm().getVerticalBar().setSelection(newBarVal);
			}
		});
		//
		Composite titleComposite = new Composite(form.getBody(), SWT.NONE);
		gl = new GridLayout(2, false);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		gd.grabExcessHorizontalSpace = true;
		titleComposite.setLayout(gl);
		titleComposite.setLayoutData(gd);
		titleComposite.setBackground(form.getBody().getBackground());
		//
		Label label = toolkit.createLabel(titleComposite, Messages.getString("IMessageConstants.CONTAINER_SECTION"));
		if( titleFont==null ) {
			titleFont = new Font(form.getDisplay(), IMessageConstants.TITLE_FONT, 16, SWT.BOLD);
		}
		label.setFont(titleFont);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		label.setLayoutData(gd);
		//
		Button configButton = new Button(titleComposite, SWT.PUSH);
		configButton.setText(Messages.getString("IMC.CONTAINER_SETTING_BTN"));
		gd = new GridData(SWT.END, SWT.CENTER, true, false);
		gd.widthHint = 150;
		configButton.setLayoutData(gd);
		configButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog dialog = new FileDialog(getSite().getShell(),SWT.OPEN);
		        dialog.setText(Messages.getString("IMC.CONTAINER_SETTING_BTN"));
				String[] names = new String[] { Messages.getString("IMessageConstants.FILETYPE_JSON") };
				String[] exts = new String[] { "*.json" };
				dialog.setFilterNames(names);
				dialog.setFilterExtensions(exts);
				
				String selectedFileName = dialog.open();
				if(selectedFileName==null) return;
				
				ObjectMapper mapper = new ObjectMapper();
				try {
					byte[] bytes = Files.readAllBytes(Paths.get(selectedFileName));
					String content = new String(bytes, StandardCharsets.UTF_8);
//					ContainerPreferenceManager.getInstance().setSettings(content);
					
					containerSettings = mapper.readValue(content, ContainerConfig.class);
					selectedMiddleware = containerSettings.getMiddlewares().get(0);
					selectedVersion = selectedMiddleware.getVersions().get(0);
					
					ContainerPreferenceManager.getInstance().setSettings(content);

					cautionLabel.setVisible(false);
				    GridData gd = (GridData) cautionLabel.getLayoutData();
				    gd.exclude = true;
				    cautionLabel.getParent().layout(true, true);
				    updateEnable(true);
				    
					List<String> midList = new ArrayList<String>();
					for(Middleware each : containerSettings.getMiddlewares()) {
						midList.add(each.getName());
					}
					middlewareCombo.setItems(midList.toArray(new String[0]));
					middlewareCombo.select(0);
					if(0 < paramList.size()) {
						targetListViewer.setSelection(new StructuredSelection(targetListViewer.getElementAt(0)));
					    presetComposite.layout();
					}
					
					MessageDialog.openInformation(getSite().getShell(),
							"Information",
							Messages.getString("IMC.CONTAINER_INFO_SETTING"));
				    
				} catch (Exception ex) {
				    GridData gd = (GridData) cautionLabel.getLayoutData();
				    gd.exclude = false;
				    cautionLabel.setVisible(true);
				    cautionLabel.getParent().layout(true, true);
				    updateEnable(false);
				    
					MessageDialog.openWarning(getSite().getShell(),
							"Error",
							Messages.getString("IMC.CONTAINER_CAUTION_SETTING"));
				}
		    }
		});
		//
		cautionFont = new Font(form.getDisplay(), IMessageConstants.TITLE_FONT, 12, SWT.BOLD);
		cautionLabel = managedForm.getToolkit().createLabel(form.getBody(), Messages.getString("IMC.CONTAINER_SETTING_CAUTION"));
		cautionLabel.setFont(cautionFont);
		cautionLabel.setForeground(getSite().getShell().getDisplay().getSystemColor(SWT.COLOR_RED));
		GridData gridData = new GridData();
		gridData.horizontalSpan = 2;
		cautionLabel.setLayoutData(gridData);
		////////////
		createBasicModelInformationSection(toolkit, form);
		createHintSection(toolkit, form);
		createTargetListSection(toolkit, form);
		createEnvironmentSection(toolkit, form);
		createLibrarySection(toolkit, form);
		createRepositorySection(toolkit, form);
		
		if(0 < paramList.size()) {
			targetListViewer.setSelection(new StructuredSelection(targetListViewer.getElementAt(0)));
		}
		
		if(configText == null || configText.length() == 0) {
			updateEnable(false);
		} else {
			cautionLabel.setVisible(false);
		    gd = (GridData) cautionLabel.getLayoutData();
		    gd.exclude = true;
		    cautionLabel.getParent().layout(true, true);
			middlewareComboSelected(toolkit, false);
		}

		if(paramList.size() == 0) {
			updateEnable(false);
			addTargetButton.setEnabled(true);
		}

		load();
	}
	
	private void updateEnable(boolean enable) {
		targetListViewer.getTable().setEnabled(enable);
		addTargetButton.setEnabled(enable);
		deleteTargetButton.setEnabled(enable);
		
		middlewareCombo.setEnabled(enable);
		midVersionCombo.setEnabled(enable);
		osVersionCombo.setEnabled(enable);
		workspaceText.setEnabled(enable);
		languageCombo.setEnabled(enable);
		configCombo.setEnabled(enable);
		
		librariesListViewer.getTable().setEnabled(enable);
		addLibraryButton.setEnabled(enable);
		deleteLibraryButton.setEnabled(enable);
		for(Button each : presetButtons) {
			if(each.isDisposed() == false) {
				each.setEnabled(enable);
			}
		}
		for(Label each : presetLabels) {
			if(each.isDisposed() == false) {
				each.setEnabled(enable);
			}
		}
		
		urlText.setEnabled(enable);
		branchText.setEnabled(enable);
		repositoryListViewer.getTable().setEnabled(enable);
		addRepositoryButton.setEnabled(enable);
		deleteRepositoryButton.setEnabled(enable);
	}

	private void createHintSection(FormToolkit toolkit, ScrolledForm form) {
		Composite composite = createHintSectionBase(toolkit, form, 6);
		createHintLabel(Messages.getString("IMC.CONTAINER_HINT_MODULE_NAME"),
						IMessageConstants.CONTAINERC_HINT_MODULENAME_DESC,
						toolkit, composite);
		createHintLabel(Messages.getString("IMC.CONTAINER_HINT_DESCRIPTION"),
						IMessageConstants.CONTAINERC_HINT_DESCRIPTION_DESC,
						toolkit, composite);
		
		createHintSpace(toolkit, composite);
		
		createHintLabel(Messages.getString("IMC.CONTAINER_HINT_MIDDLEWARE"),
				Messages.getString("IMC.CONTAINER_HINT_MIDDLEWARE_DESC"),
				toolkit, composite);
		createHintLabel(Messages.getString("IMC.CONTAINER_HINT_MIDDLEWARE_VERSION"),
				Messages.getString("IMC.CONTAINER_HINT_MIDDLEWARE_VERSION_DESC"),
				toolkit, composite);
		createHintLabel(Messages.getString("IMC.CONTAINER_HINT_OS_VERSION"),
				Messages.getString("IMC.CONTAINER_HINT_OS_VERSION_DESC"),
				toolkit, composite);
		createHintLabel(Messages.getString("IMC.CONTAINER_HINT_WORKSPACE"),
				IMessageConstants.CONTAINERC_HINT_WORKSPACE_DESC,
				toolkit, composite);
		createHintLabel(Messages.getString("IMC.CONTAINER_HINT_LANGUAGE"),
				Messages.getString("IMC.CONTAINER_HINT_LANGUAGE_DESC"),
				toolkit, composite);
		createHintLabel(Messages.getString("IMC.CONTAINER_HINT_CONFIGURATION"),
				IMessageConstants.CONTAINERC_HINT_CONFIGURATION_DESC,
				toolkit, composite);

		createHintSpace(toolkit, composite);
		
		createHintLabel(Messages.getString("IMC.CONTAINER_HINT_LIBRARY"),
				IMessageConstants.CONTAINERC_HINT_LIBRARY_DESC,
				toolkit, composite);

		createHintSpace(toolkit, composite);
		
		createHintLabel(Messages.getString("IMC.CONTAINER_HINT_URL"),
				IMessageConstants.CONTAINERC_HINT_URL_DESC,
				toolkit, composite);
		createHintLabel(Messages.getString("IMC.CONTAINER_HINT_BRANCH"),
				Messages.getString("IMC.CONTAINER_HINT_BRANCH_DESC"),
				toolkit, composite);
	}
	
	private void createBasicModelInformationSection(FormToolkit toolkit, ScrolledForm form) {
		Section sctBasicInfo = toolkit.createSection(form.getBody(),
				Section.TITLE_BAR | Section.EXPANDED | Section.TWISTIE);
		sctBasicInfo.setText(Messages.getString("IMC.CONTAINER_TITLE_BASIC"));
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment = GridData.BEGINNING;
		sctBasicInfo.setLayoutData(gridData);
		//
		Composite composite = toolkit.createComposite(sctBasicInfo, SWT.NULL);
		composite.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		toolkit.paintBordersFor(composite);
		GridLayout gl = new GridLayout(2, false);
		composite.setLayout(gl);
		GridData gd = new GridData(GridData.FILL_BOTH);
		composite.setLayoutData(gd);
		sctBasicInfo.setClient(composite);

		gridData = new GridData(GridData.FILL_HORIZONTAL);
		moduleNameText = createLabelAndText(toolkit, composite,
				Messages.getString("IMC.CONTAINER_MODULE_NAME"),
				SWT.NONE, SWT.COLOR_BLACK, 2);
		moduleNameText.setLayoutData(gridData);
		moduleNameText.setText(editor.getRtcParam().getName());
		moduleNameText.setEditable(false);
		moduleNameText.setBackground(getSite().getShell().getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));

		gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.heightHint = 30;
		gridData.widthHint = 100;
		descriptionText = createLabelAndText(toolkit, composite,
				Messages.getString("IMC.BASIC_LBL_DESCRIPTION"), SWT.MULTI | SWT.V_SCROLL | SWT.WRAP);
		descriptionText.setLayoutData(gridData);
		descriptionText.setText(editor.getRtcParam().getDescription());
		descriptionText.setEditable(false);
		descriptionText.setBackground(getSite().getShell().getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
	}

	private void createTargetListSection(FormToolkit toolkit, ScrolledForm form) {
		Section sctTargetList = toolkit.createSection(form.getBody(),
				Section.TITLE_BAR | Section.EXPANDED | Section.TWISTIE);
		sctTargetList.setText(Messages.getString("IMC.CONTAINER_TITLE_TARGET"));
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment = GridData.BEGINNING;
		sctTargetList.setLayoutData(gridData);
		//
		Composite composite = toolkit.createComposite(sctTargetList, SWT.NULL);
		composite.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		toolkit.paintBordersFor(composite);
		GridLayout gl = new GridLayout(2, false);
		composite.setLayout(gl);
		GridData gd = new GridData(GridData.FILL_BOTH);
		composite.setLayoutData(gd);
		sctTargetList.setClient(composite);

		targetListViewer = new TableViewer(composite, SWT.FULL_SELECTION
				| SWT.SINGLE | SWT.BORDER);
		targetListViewer.setContentProvider(new ArrayContentProvider());
		Table targetListTable = targetListViewer.getTable();
		targetListTable.setLinesVisible(true);
		targetListTable.setHeaderVisible(true);
		gd = new GridData();
		gd.verticalAlignment = SWT.FILL;
		gd.horizontalAlignment = SWT.FILL;
		gd.grabExcessVerticalSpace = true;
		gd.grabExcessHorizontalSpace = true;
		gd.heightHint = 80;
		targetListTable.setLayoutData(gd);

		createColumn(targetListViewer, "Middleware", 150);
		createColumn(targetListViewer, "Version", 120);
		createColumn(targetListViewer, "OS Version", 180);

		targetListViewer.setLabelProvider(new TargetLabelProvider());
		targetListViewer.setInput(paramList);
		
		targetListViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				int selectionIndex = targetListViewer.getTable().getSelectionIndex();
				if(selectionIndex < 0) return;
				
				selectedParam = paramList.get(selectionIndex);
				Optional<Middleware> result = containerSettings.getMiddlewares().stream()
											    .filter(item -> item.getName().equals(selectedParam.getMiddleware()))
											    .findFirst();
				if(result.isPresent() == false) {
					return;
				}
				selectedMiddleware = result.get();
				
				Optional<Version> resultVer = selectedMiddleware.getVersions().stream()
											    .filter(item -> item.getId().equals(selectedParam.getMdlVersion()))
											    .findFirst();
				if(resultVer.isPresent() == false) {
					return;
				}
				selectedVersion = resultVer.get();
				
				middlewareCombo.setText(selectedMiddleware.getName());
				middlewareComboSelected(toolkit, false);
				midVersionCombo.setText(selectedVersion.getId());
				midVersionComboSelected();
				
				workspaceText.setText(selectedParam.getWorkspace());
				languageCombo.setText(selectedParam.getLanguage());
				configCombo.setText(selectedParam.getConfiguration());
				/////
				librariesList = selectedParam.getLibraries();
				for(String each : selectedMiddleware.getDefault_libs()) {
					boolean exists = librariesList.stream()
										.anyMatch(item -> each.equals(item.getName()));
					if(exists) continue;
					LibraryParam elem = new LibraryParam();
					elem.setName(each);
					librariesList.add(elem);
				}
				librariesListViewer.setInput(librariesList);
				/////
				urlText.setText("");
				branchText.setText("");
				repositoriesList = selectedParam.getRepositories();
				repositoryListViewer.setInput(repositoriesList);
			}
		});
		
		Composite buttonComposite = new Composite(composite, SWT.NONE);
		gl = new GridLayout(1, false);
		gd = new GridData();
		gd.verticalAlignment = SWT.TOP;
		buttonComposite.setLayout(gl);
		buttonComposite.setLayoutData(gd);

		addTargetButton = new Button(buttonComposite, SWT.PUSH);
		addTargetButton.setText(Messages.getString("IPreferenceMessageConstants.CONFIG_BTN_ADD"));
		gd = new GridData();
		gd.widthHint = EXEC_BUTTON_WIDTH;
		addTargetButton.setLayoutData(gd);
		addTargetButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Middleware newMid = containerSettings.getMiddlewares().get(0);
				Version newVersion = newMid.getVersions().get(0);
				
				ContainerParam elem = new ContainerParam();
				elem.setMiddleware(newMid.getName());
				elem.setMdlVersion(newVersion.getId());
				elem.setOsVersion(newVersion.getOs());
				paramList.add(elem);
				updateEnable(true);
				targetListViewer.refresh();
				targetListViewer.setSelection(new StructuredSelection(targetListViewer.getElementAt(paramList.size() - 1)));
				update();
			}
		});
		
		deleteTargetButton = new Button(buttonComposite, SWT.PUSH);
		deleteTargetButton.setText(Messages.getString("IPreferenceMessageConstants.CONFIG_BTN_DELETE"));
		gd = new GridData();
		gd.widthHint = EXEC_BUTTON_WIDTH;
		deleteTargetButton.setLayoutData(gd);
		deleteTargetButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int selectionIndex = targetListViewer.getTable().getSelectionIndex();
				if (0 <= selectionIndex
						&& selectionIndex + 1 <= ((List) targetListViewer.getInput()).size()) {
					paramList.remove(selectionIndex);
					targetListViewer.refresh();
					if(0 < paramList.size()) {
						targetListViewer.setSelection(new StructuredSelection(targetListViewer.getElementAt(paramList.size() - 1)));
					} else {
						workspaceText.setText("");
						selectedParam = null;
						librariesList.clear();
						repositoriesList.clear();
						librariesListViewer.refresh();;
						repositoryListViewer.refresh();;
						updateEnable(false);
						addTargetButton.setEnabled(true);
					}
					update();
				}
			}
		});
	}
	
	private void createEnvironmentSection(FormToolkit toolkit, ScrolledForm form) {
		Section sctEnv = toolkit.createSection(form.getBody(),
				Section.TITLE_BAR | Section.EXPANDED | Section.TWISTIE);
		sctEnv.setText(Messages.getString("IMC.CONTAINER_TITLE_ENVIRONMENT"));
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment = GridData.BEGINNING;
		sctEnv.setLayoutData(gridData);
		//
		Composite composite = toolkit.createComposite(sctEnv, SWT.NULL);
		composite.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		toolkit.paintBordersFor(composite);
		GridLayout gl = new GridLayout(4, false);
		composite.setLayout(gl);
		GridData gd = new GridData(GridData.FILL_BOTH);
		composite.setLayoutData(gd);
		sctEnv.setClient(composite);

		List<String> midList = new ArrayList<String>();
		for(Middleware each : containerSettings.getMiddlewares()) {
			midList.add(each.getName());
		}
		middlewareCombo = createLabelAndCombo(toolkit, composite,
				Messages.getString("IMC.CONTAINER_MIDDLEWARE_NAME"),
				midList.toArray(new String[0]),
				SWT.COLOR_BLACK, 3);
		middlewareCombo.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
			@Override
			public void widgetSelected(SelectionEvent e) {
				middlewareComboSelected(toolkit, true);
				update();
			}
		});
		
		List<String> versionList = new ArrayList<String>();
		for(Version each : selectedMiddleware.getVersions()) {
			versionList.add(each.getId());
		}
		
		midVersionCombo = createLabelAndCombo(toolkit, composite,
				Messages.getString("IMC.CONTAINER_MIDDLEWARE_Version"),
				versionList.toArray(new String[0]),
				SWT.COLOR_BLACK, 1);
		midVersionCombo.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
			@Override
			public void widgetSelected(SelectionEvent e) {
				midVersionComboSelected();
				update();
			}
		});
		osVersionCombo = createLabelAndCombo(toolkit, composite,
				Messages.getString("IMC.CONTAINER_OS_Version"),
				versionList.toArray(new String[0]),
				SWT.COLOR_BLACK, 1);

		workspaceText = createLabelAndText(toolkit, composite,
				Messages.getString("IMC.CONTAINER_WORKSPACE"), SWT.NONE, SWT.COLOR_BLACK, 3);
		
		languageCombo = createLabelAndCombo(toolkit, composite,
				Messages.getString("IMC.CONTAINER_LANGUAGE"),
				LANGUAGE_ITEMS,
				SWT.COLOR_BLACK, 1);
		configCombo = createLabelAndCombo(toolkit, composite,
				Messages.getString("IMC.CONTAINER_CONFIGURATION"),
				CONFIGURATION_ITEMS,
				SWT.COLOR_BLACK, 1);

	}
	
	private void middlewareComboSelected(FormToolkit toolkit, boolean updateLibs ) {
		int selected = middlewareCombo.getSelectionIndex();
		if(selected < 0) return;
		
		selectedMiddleware = containerSettings.getMiddlewares().get(selected);
		
		midVersionCombo.removeAll();
		List<String> versionList = new ArrayList<String>();
		for(Version each : selectedMiddleware.getVersions()) {
			versionList.add(each.getId());
		}
		midVersionCombo.setItems(versionList.toArray(new String[0]));
		midVersionCombo.select(0);
		midVersionComboSelected();
		
		if(selectedMiddleware.getType().equals("free")) {
			osVersionCombo.removeAll();
			osVersionCombo.setItems(selectedMiddleware.getSupported_os().toArray(new String[0]));
			osVersionCombo.setEnabled(true);
			osVersionCombo.setBackground(getSite().getShell().getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
			osVersionCombo.select(0);
		} else {
			List<String> osList = new ArrayList<String>();
			for(Version each : selectedMiddleware.getVersions()) {
				osList.add(each.getOs());
			}
			osVersionCombo.setItems(osList.toArray(new String[0]));
			osVersionCombo.setEnabled(false);
			osVersionCombo.setBackground(getSite().getShell().getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			osVersionCombo.select(0);
			midVersionComboSelected();
		}
		
		languageCombo.setEnabled(selectedMiddleware.isHas_language_selection());
		languageCombo.removeAll();
		if(selectedMiddleware.isHas_language_selection()) {
			languageCombo.setItems(LANGUAGE_ITEMS);
		} else {
			languageCombo.add("C++");
		}
		languageCombo.select(0);
		
		configCombo.setEnabled(selectedMiddleware.getType().equals("link"));
		configCombo.removeAll();
		if(selectedMiddleware.getType().equals("link")) {
			configCombo.setItems(CONFIGURATION_ITEMS);
		} else {
			configCombo.add("Std");
		}
		configCombo.select(0);
		/////
		Map<String, List<String>> selectedPreset = selectedMiddleware.getFunctional_presets();
		for(Button each : presetButtons) {
			each.dispose();
		}
		for(Label each : presetLabels) {
			each.dispose();
		}
		for (String key : selectedPreset.keySet()) {
			List<String> elems = selectedPreset.get(key);
			Button chkPreset = createRadioCheckButton(toolkit, presetComposite, key, SWT.CHECK);
			if(selectedParam != null && selectedParam.getPreSets().contains(key)) {
				chkPreset.setSelection(true);
			}
			presetButtons.add(chkPreset);
			chkPreset.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					if(chkPreset.getSelection()) {
						if(selectedParam != null) {
							if(selectedParam.getPreSets().contains(key) == false) {
								selectedParam.getPreSets().add(key);
							}
						}
					} else {
						if(selectedParam != null) {
							selectedParam.getPreSets().remove(key);
						}
					}
					for(String each : elems) {
						boolean exists = librariesList.stream()
								.anyMatch(item -> each.equals(item.getName()));
						if(chkPreset.getSelection()) {
							if(exists) continue;
							LibraryParam elem = new LibraryParam();
							elem.resetUpdated();
							elem.setName(each);
							librariesList.add(elem);
							
						} else {
							if(exists==false) continue;
							librariesList.removeIf(item -> each.equals(item.getName()));
						}
					}
					librariesListViewer.refresh();
					update();
				}
			});
			
			StringBuilder builder = new StringBuilder();
			for(String each : elems) {
				if(0 < builder.length()) {
					builder.append(System.lineSeparator());
				}
				builder.append(each);
			}

			Label helpLabel = new Label(presetComposite, SWT.NONE);
			helpLabel.setImage(smallInfo);
			helpLabel.setToolTipText(builder.toString());
			helpLabel.setCursor(getSite().getShell().getDisplay().getSystemCursor(SWT.CURSOR_HAND));
			presetLabels.add(helpLabel);

		}
		presetComposite.layout();
		
		if(updateLibs) {
			librariesList.clear();
			for(String each : selectedMiddleware.getDefault_libs()) {
				boolean exists = librariesList.stream()
						.anyMatch(item -> each.equals(item.getName()));
				if(exists) continue;
				LibraryParam elem = new LibraryParam();
				elem.setName(each);
				librariesList.add(elem);
			}
			librariesListViewer.refresh();
			/////
			repositoriesList.clear();
			repositoryListViewer.refresh();
		}
	}
	
	private void midVersionComboSelected() {
		int selected = midVersionCombo.getSelectionIndex();
		selectedVersion = selectedMiddleware.getVersions().get(selected);
		osVersionCombo.setText(selectedVersion.getOs());
	}

	private void createLibrarySection(FormToolkit toolkit, ScrolledForm form) {
		Composite composite = createSectionBaseWithLabel(toolkit, form,
				Messages.getString("IMC.CONTAINER_TITLE_LIBRARY"),
				Messages.getString("IMC.CONTAINER_TITLE_LIBRARY_EXPL"), 2);

		librariesListViewer = new TableViewer(composite, SWT.FULL_SELECTION
				| SWT.SINGLE | SWT.BORDER);
		librariesListViewer.setContentProvider(new ArrayContentProvider());
		Table librariesListTable = librariesListViewer.getTable();
		librariesListTable.setLinesVisible(true);
		librariesListTable.setHeaderVisible(true);
		GridData gd = new GridData();
		gd.heightHint = 240;
		gd.verticalAlignment = SWT.FILL;
		gd.horizontalAlignment = SWT.FILL;
		gd.grabExcessVerticalSpace = true;
		gd.grabExcessHorizontalSpace = true;
		librariesListTable.setLayoutData(gd);
		
		TableViewerColumn nameColumn = createColumn(librariesListViewer, "Library Name", 200);
		nameColumn.setEditingSupport(new LibraryNameCellModifier(librariesListViewer));

		librariesListViewer.setLabelProvider(new LibraryLabelProvider());
		librariesListViewer.setInput(librariesList);
		
		Composite libraryComposite = new Composite(composite, SWT.NONE);
		GridLayout gl = new GridLayout(2, false);
		gd = new GridData(GridData.FILL_VERTICAL);
		libraryComposite.setLayout(gl);
		libraryComposite.setLayoutData(gd);

		addLibraryButton = new Button(libraryComposite, SWT.PUSH);
		addLibraryButton.setText(Messages.getString("IPreferenceMessageConstants.CONFIG_BTN_ADD"));
		gd = new GridData();
		gd.widthHint = EXEC_BUTTON_WIDTH;
		addLibraryButton.setLayoutData(gd);
		addLibraryButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				LibraryParam elem = new LibraryParam();
				elem.setName("new_lib");
				librariesList.add(elem);
				librariesListViewer.refresh();
				update();
			}
		});
		
		deleteLibraryButton = new Button(libraryComposite, SWT.PUSH);
		deleteLibraryButton.setText(Messages.getString("IPreferenceMessageConstants.CONFIG_BTN_DELETE"));
		gd = new GridData();
		gd.widthHint = EXEC_BUTTON_WIDTH;
		deleteLibraryButton.setLayoutData(gd);
		deleteLibraryButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int selectionIndex = librariesListViewer.getTable().getSelectionIndex();
				if (0 <= selectionIndex
						&& selectionIndex + 1 <= ((List) librariesListViewer.getInput()).size()) {
					librariesList.remove(selectionIndex);
					librariesListViewer.refresh();
					update();
				}
			}
		});
		
		presetComposite = new Composite(libraryComposite, SWT.BORDER);
		gl = new GridLayout(2, false);
		gd = new GridData(GridData.FILL_BOTH);
		gd.horizontalSpan = 2;
		gd.grabExcessVerticalSpace = true;
		presetComposite.setLayout(gl);
		presetComposite.setLayoutData(gd);

		Label lblModule = toolkit.createLabel(presetComposite, Messages.getString("IMC.CONTAINER_MODELES"));
		FontData[] fontData = lblModule.getFont().getFontData();
		for (FontData fd : fontData) {
		    fd.setStyle(SWT.BOLD);
		    fd.setHeight(fd.getHeight() + 2);
		}
		Font boldFont = new Font(lblModule.getDisplay(), fontData);
		lblModule.setFont(boldFont);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		lblModule.setLayoutData(gd);
		lblModule.addDisposeListener(e -> boldFont.dispose());

		Label lblDesc = toolkit.createLabel(presetComposite, Messages.getString("IMC.CONTAINER_MODELES_EXP"));
		lblDesc.setLayoutData(gd);
	}
	
	private void createRepositorySection(FormToolkit toolkit, ScrolledForm form) {
		Composite composite = createSectionBaseWithLabel(toolkit, form,
				Messages.getString("IMC.CONTAINER_TITLE_REPOSITORY"),
				Messages.getString("IMC.CONTAINER_TITLE_REPOSITORY_EXP"), 3);

		urlText = createLabelAndText(toolkit, composite,
				Messages.getString("IMC.CONTAINER_URL"),
				SWT.NONE, SWT.COLOR_BLACK, 2);
		
		branchText = createLabelAndText(toolkit, composite,
				Messages.getString("IMC.CONTAINER_BRANCH"),
				SWT.NONE, SWT.COLOR_BLACK, 1);
		GridData gridData = new GridData();
		gridData.widthHint = 200;
		branchText.setLayoutData(gridData);
		
		addRepositoryButton = new Button(composite, SWT.PUSH);
		addRepositoryButton.setText(Messages.getString("IPreferenceMessageConstants.CONFIG_BTN_ADD"));
		GridData gd = new GridData(SWT.END, SWT.CENTER, true, false);
		gd.widthHint = EXEC_BUTTON_WIDTH;
		addRepositoryButton.setLayoutData(gd);
		addRepositoryButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String urlTxt = urlText.getText();
				if(urlTxt == null || urlTxt.trim().length() == 0) {
					MessageDialog.openWarning(getSite().getShell(),
												"Error",
												Messages.getString("IMC.CONTAINER_CAUTION_URL"));
					urlText.setFocus();
					return;
				}
				String branchTxt = branchText.getText();
				if(branchTxt == null || branchTxt.trim().length() == 0) {
					MessageDialog.openWarning(getSite().getShell(),
												"Error",
												Messages.getString("IMC.CONTAINER_CAUTION_Branch"));
					branchText.setFocus();
					return;
				}
				
				RepositoryParam elem = new RepositoryParam();
				elem.setURL(urlTxt);
				elem.setBranch(branchTxt);
				repositoriesList.add(elem);
				repositoryListViewer.refresh();
				urlText.setText("");
				branchText.setText("");
				update();
			}
		});
		
		repositoryListViewer = new TableViewer(composite, SWT.FULL_SELECTION
				| SWT.SINGLE | SWT.BORDER);
		repositoryListViewer.setContentProvider(new ArrayContentProvider());
		Table repositoryListTable = repositoryListViewer.getTable();
		repositoryListTable.setLinesVisible(true);
		repositoryListTable.setHeaderVisible(true);
		gd = new GridData();
		gd.heightHint = 200;
		gd.horizontalSpan = 2;
		gd.verticalAlignment = SWT.FILL;
		gd.horizontalAlignment = SWT.FILL;
		gd.grabExcessVerticalSpace = true;
		gd.grabExcessHorizontalSpace = true;
		repositoryListTable.setLayoutData(gd);
		
		createColumn(repositoryListViewer, "URL", 400);
		createColumn(repositoryListViewer, "Branch", 80);

		repositoryListViewer.setLabelProvider(new RepositoryLabelProvider());
		repositoryListViewer.setInput(repositoriesList);
		
		Composite buttonComposite = new Composite(composite, SWT.NONE);
		GridLayout gl = new GridLayout(1, false);
		gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		buttonComposite.setLayout(gl);
		buttonComposite.setLayoutData(gd);
		
		deleteRepositoryButton = new Button(buttonComposite, SWT.PUSH);
		deleteRepositoryButton.setText(Messages.getString("IPreferenceMessageConstants.CONFIG_BTN_DELETE"));
		gd = new GridData(SWT.END, SWT.END, true, true);
		gd.widthHint = EXEC_BUTTON_WIDTH;
		deleteRepositoryButton.setLayoutData(gd);
		deleteRepositoryButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int selectionIndex = repositoryListViewer.getTable().getSelectionIndex();
				if (0 <= selectionIndex
						&& selectionIndex + 1 <= ((List) repositoryListViewer.getInput()).size()) {
					repositoriesList.remove(selectionIndex);
					repositoryListViewer.refresh();
				}
			}
		});
	}
	//////////
	private class TargetLabelProvider extends LabelProvider implements ITableLabelProvider {
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof ContainerParam == false) return null;
			ContainerParam elem = (ContainerParam) element;
			if (columnIndex == 0) {
				return elem.getMiddleware();
			} else if (columnIndex == 1) {
				return elem.getMdlVersion();
			} else if (columnIndex == 2) {
				return elem.getOsVersion();
			} else {
				return "";
			}
		}
	}
	//////////
	private class LibraryLabelProvider extends LabelProvider implements ITableLabelProvider {
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof LibraryParam == false) return null;
			LibraryParam elem = (LibraryParam) element;
			if (columnIndex == 0) {
				return elem.getName();
			} else {
				return "";
			}
		}
	}
	private class LibraryNameCellModifier extends EditingSupport {
		private CellEditor editor;

		public LibraryNameCellModifier(ColumnViewer viewer) {
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
			if (element instanceof LibraryParam == false) return null;
			LibraryParam elem = (LibraryParam) element;
			return elem.getName();
		}
		@Override
		protected void setValue(Object element, Object value) {
			if (element instanceof LibraryParam == false) return;
			
			String modified = (String) value;
			boolean exists = librariesList.stream()
					.anyMatch(item -> modified.equals(item.getName()));
			if(exists) return;

			LibraryParam elem = (LibraryParam) element;
			elem.setName((String) value);
			getViewer().update(element, null);
			update();
		}
	}
	//////////
	private class RepositoryLabelProvider extends LabelProvider implements ITableLabelProvider {
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof RepositoryParam == false) return null;
			RepositoryParam elem = (RepositoryParam) element;
			if (columnIndex == 0) {
				return elem.getURL();
			} else if (columnIndex == 1) {
				return elem.getBranch();
			} else {
				return "";
			}
		}
	}
	//////////		
	public void update() {
		if( middlewareCombo != null && selectedParam != null ) {
			selectedParam.setMiddleware(middlewareCombo.getText());
			selectedParam.setMdlVersion(midVersionCombo.getText());
			selectedParam.setOsVersion(osVersionCombo.getText());
			selectedParam.setWorkspace(workspaceText.getText());
			selectedParam.setLanguage(languageCombo.getText());
			selectedParam.setConfiguration(configCombo.getText());
			
			targetListViewer.refresh();
		}
		editor.updateDirty();
	}

	/**
	 * データをロードする
	 */
	public void load() {
		if( middlewareCombo == null ) return;
		
		RtcParam rtcParam = editor.getRtcParam();
		paramList = rtcParam.getContainerSettings();
		targetListViewer.setInput(paramList);

		if(0 < paramList.size()) {
			targetListViewer.setSelection(new StructuredSelection(targetListViewer.getElementAt(0)));
		}
	}

	public String validateParam() {
		String result = null;

		RtcParam rtcParam = editor.getRtcParam();
		
		for(ContainerParam each : rtcParam.getContainerSettings()) {
			result = ValidationUtil.validateContainerSetting(each);
			if( result != null) return result;
		}
		
		return null;
	}
	
	@Override
	public void dispose() {
		if( cautionFont!=null ) cautionFont.dispose();
		super.dispose();
	}
}
