package br.furb.guniver.ui.admin;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TurmaFragment extends Fragment {

	private JTable tableTurmas;

	public TurmaFragment() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JScrollPane scrollPaneTurmas = new JScrollPane();
		GridBagConstraints gbc_scrollPaneTurmas = new GridBagConstraints();
		gbc_scrollPaneTurmas.insets = new Insets(5, 5, 5, 5);
		gbc_scrollPaneTurmas.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneTurmas.gridx = 0;
		gbc_scrollPaneTurmas.gridy = 0;
		add(scrollPaneTurmas, gbc_scrollPaneTurmas);

		tableTurmas = new JTable();
		tableTurmas.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, }, new String[] { "C\u00F3digo", "Ano", "Semestre", "Disciplina" }) {
			Class[] columnTypes = new Class[] { Long.class, Short.class, Byte.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableTurmas.getColumnModel().getColumn(1).setPreferredWidth(50);
		tableTurmas.getColumnModel().getColumn(2).setPreferredWidth(60);
		scrollPaneTurmas.setViewportView(tableTurmas);

		JPanel panelManageTurmas = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelManageTurmas.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		GridBagConstraints gbc_panelManageTurmas = new GridBagConstraints();
		gbc_panelManageTurmas.insets = new Insets(0, 5, 5, 0);
		gbc_panelManageTurmas.anchor = GridBagConstraints.NORTHEAST;
		gbc_panelManageTurmas.gridx = 0;
		gbc_panelManageTurmas.gridy = 1;
		add(panelManageTurmas, gbc_panelManageTurmas);

		JButton btnRemover = new JButton("Remover");
		panelManageTurmas.add(btnRemover);

		JButton btnAlterarDisciplina = new JButton("Alterar Disciplina");
		panelManageTurmas.add(btnAlterarDisciplina);
	}

}
