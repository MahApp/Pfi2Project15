package se.mah.k3.pfi2.project.dummypanel;

import java.awt.BorderLayout;

import javax.sound.sampled.Line;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import se.mah.k3.pfi2.project.main.controller.ModuleInterface;

import java.awt.Color;

public class DummyPanel extends JPanel implements ModuleInterface {
	private JTable table; 
	/**
	 * Create the panel.
	 */
	public DummyPanel() {
	//	HttpWebRequest reqFp = (HttpWebRequest)HttpWebRequest.Create(KronosServerUrl);
	//	reqFp.Method = "POST";
	//	reqFp.ContentType = "text/xml";
		
		setBackground(Color.GRAY);
		setLayout(new BorderLayout(0, 0));
		table = new JTable();
		table.setRowSelectionAllowed(false);
		add(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Dummy",null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
	}
	@Override
	public int getExpectedPriority() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getPreferdNumberOfRows() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getMinNumberOfRows() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean showNumberOfRows(int start, int end) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void repaintPanel() {
		// TODO Auto-generated method stub
		
	}
}
