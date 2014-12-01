package br.furb.guniver.ui.admin;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AlunoFragment extends Fragment {
	private JTable tableAlunos;
	public AlunoFragment() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JScrollPane scrollPaneTable = new JScrollPane();
		GridBagConstraints gbc_scrollPaneTable = new GridBagConstraints();
		gbc_scrollPaneTable.insets = new Insets(5, 5, 5, 5);
		gbc_scrollPaneTable.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneTable.gridx = 0;
		gbc_scrollPaneTable.gridy = 0;
		add(scrollPaneTable, gbc_scrollPaneTable);
		
		tableAlunos = new JTable();
		tableAlunos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"C\u00F3digo", "Nome", "Usu\u00E1rio", "Senha"
			}
		) {
			Class[] columnTypes = new Class[] {
				Long.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableAlunos.getColumnModel().getColumn(1).setPreferredWidth(150);
		tableAlunos.getColumnModel().getColumn(2).setPreferredWidth(100);
		tableAlunos.getColumnModel().getColumn(3).setPreferredWidth(100);
		scrollPaneTable.setViewportView(tableAlunos);
		
		JButton btnRemover = new JButton("Remover");
		GridBagConstraints gbc_btnRemover = new GridBagConstraints();
		gbc_btnRemover.anchor = GridBagConstraints.EAST;
		gbc_btnRemover.insets = new Insets(0, 5, 5, 5);
		gbc_btnRemover.gridx = 0;
		gbc_btnRemover.gridy = 1;
		add(btnRemover, gbc_btnRemover);
	}

}
