package jp.go.aist.rtm.toolscommon.fsm.editor.editor.scxml.eleditor;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Point;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.Document;

import com.mxgraph.model.mxCell;

import jp.go.aist.rtm.toolscommon.fsm.editor.SCXMLGraphEditor;
import jp.go.aist.rtm.toolscommon.fsm.editor.editor.fileimportexport.SCXMLEdge;

public class SCXMLTransitionEditor extends SCXMLEditorRoot {

	private static final long serialVersionUID = -6967742868602449986L;

	public SCXMLTransitionEditor(JFrame parent, mxCell en, SCXMLGraphEditor editor, Point pos) {
		super(parent, editor, en);
//		setTitle(mxResources.get("titleNodeEditor"));
		setTitle("Transition Editor");
		setLocation(pos);
		
		SCXMLEdge edge = (SCXMLEdge) en.getValue();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		DocumentChangeListener changeListener = new DocumentChangeListener(editor);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		GridBagLayout gbl = new GridBagLayout();
		panel.setLayout(gbl);
		
        addUIParts(panel, new JLabel("Event"), gbl, 0, 0, 1, 1);
        JTextField txtEvent = new JTextField(edge.getEvent());
        txtEvent.setPreferredSize(new Dimension(300, 20));
        addUIParts(panel, txtEvent, gbl, 1, 0, 2, 1);
        Document docEvent = edge.getEventDoc();
		if (docEvent == null) {
			edge.setEventDoc(docEvent = txtEvent.getDocument());
		}
		docEvent.addDocumentListener(changeListener);
		//
        addUIParts(panel, new JLabel("Condition"), gbl, 0, 1, 1, 1);
        JTextField txtCondition = new JTextField(edge.getCondition());
        txtCondition.setPreferredSize(new Dimension(300, 20));
        addUIParts(panel, txtCondition, gbl, 1, 1, 2, 1);
        Document docCondition = edge.getConditionDoc();
		if (docCondition == null) {
			edge.setConditionDoc(docCondition = txtCondition.getDocument());
		}
		docCondition.addDocumentListener(changeListener);
		
		pack();
		setVisible(true);
	}
}