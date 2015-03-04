package se.mah.k3.pfi2.project.Frame.view.panels;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import se.mah.k3.pfi2.project.Frame.controller.ModuleInterface;
import java.awt.Color;

public class DummyPanel extends JPanel implements ModuleInterface {
	private JTable table; 
	/**
	 * Create the panel.
	 */
	public DummyPanel() {
		setBackground(Color.GRAY);
		setLayout(new BorderLayout(0, 0));
		table = new JTable();
		table.setRowSelectionAllowed(false);
		add(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
	}
	@Override
	public int getPreferedPriority() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getPreferdNumberOfRows() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getPreferdHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

}
