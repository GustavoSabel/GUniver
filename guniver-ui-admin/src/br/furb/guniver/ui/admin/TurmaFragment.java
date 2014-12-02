package br.furb.guniver.ui.admin;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import br.furb.guniver.modelo.Turma;

@SuppressWarnings("serial")
public class TurmaFragment extends Fragment {

	private JTable tableTurmas;
	private Controller controller;
	private Turma selectedTurma;

	public TurmaFragment(Controller controller) {
		this.controller = controller;
		controller.setTurmaFragment(this);
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
		tableTurmas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
		btnAlterarDisciplina.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (selectedTurma != null) {
					changeTurma();
				}
			}
		});
		panelManageTurmas.add(btnAlterarDisciplina);
	}

	private void changeTurma() {
		// TODO
	}

	public void setTurmas(Collection<Turma> entities) {
		// TODO Auto-generated method stub

	}

	public void updateTurma(Turma downloadedEntity) {
		// TODO Auto-generated method stub

	}

}
