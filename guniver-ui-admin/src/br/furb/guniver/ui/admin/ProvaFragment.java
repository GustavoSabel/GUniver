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

@SuppressWarnings("serial")
public class ProvaFragment extends Fragment {

	private JTable tableProvas;
	private Controller controller;

	public ProvaFragment(Controller controller) {
		this.controller = controller;
		controller.setProvaFragment(this);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JScrollPane scrollPaneProvas = new JScrollPane();
		GridBagConstraints gbc_scrollPaneProvas = new GridBagConstraints();
		gbc_scrollPaneProvas.insets = new Insets(5, 5, 5, 5);
		gbc_scrollPaneProvas.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneProvas.gridx = 0;
		gbc_scrollPaneProvas.gridy = 0;
		add(scrollPaneProvas, gbc_scrollPaneProvas);

		tableProvas = new JTable();
		tableProvas.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, }, new String[] { "Aluno", "Turma", "Nota", "Descri\u00E7\u00E3o" }) {
			Class[] columnTypes = new Class[] { String.class, Long.class, Float.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPaneProvas.setViewportView(tableProvas);

		JPanel panelManageProva = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelManageProva.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		flowLayout.setVgap(0);
		GridBagConstraints gbc_panelManageProva = new GridBagConstraints();
		gbc_panelManageProva.insets = new Insets(0, 5, 5, 0);
		gbc_panelManageProva.fill = GridBagConstraints.BOTH;
		gbc_panelManageProva.gridx = 0;
		gbc_panelManageProva.gridy = 1;
		add(panelManageProva, gbc_panelManageProva);

		JButton btnRemover = new JButton("Remover");
		panelManageProva.add(btnRemover);

		JButton btnAlterarAluno = new JButton("Alterar Aluno");
		panelManageProva.add(btnAlterarAluno);

		JButton btnAlterarTurma = new JButton("Alterar Turma");
		panelManageProva.add(btnAlterarTurma);
	}

}
