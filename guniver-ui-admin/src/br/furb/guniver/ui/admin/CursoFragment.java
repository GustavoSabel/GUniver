package br.furb.guniver.ui.admin;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class CursoFragment extends Fragment {

	private JTable tableCursos;
	private Controller controller;

	public CursoFragment(Controller controller) {
		this.controller = controller;
		controller.setCursoFragment(this);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 200, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblCursos = new JLabel("Cursos");
		lblCursos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCursos = new GridBagConstraints();
		gbc_lblCursos.anchor = GridBagConstraints.WEST;
		gbc_lblCursos.insets = new Insets(5, 5, 5, 5);
		gbc_lblCursos.gridx = 0;
		gbc_lblCursos.gridy = 0;
		add(lblCursos, gbc_lblCursos);

		JScrollPane scrollPaneCursos = new JScrollPane();
		GridBagConstraints gbc_scrollPaneCursos = new GridBagConstraints();
		gbc_scrollPaneCursos.insets = new Insets(0, 5, 5, 5);
		gbc_scrollPaneCursos.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneCursos.gridx = 0;
		gbc_scrollPaneCursos.gridy = 1;
		add(scrollPaneCursos, gbc_scrollPaneCursos);

		tableCursos = new JTable();
		tableCursos.setModel(new DefaultTableModel(new Object[][] { { null, null }, }, new String[] { "C\u00F3digo", "Nome" }) {
			Class[] columnTypes = new Class[] { Long.class, Object.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableCursos.getColumnModel().getColumn(1).setPreferredWidth(150);
		scrollPaneCursos.setViewportView(tableCursos);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridheight = 3;
		gbc_separator.fill = GridBagConstraints.BOTH;
		gbc_separator.insets = new Insets(5, 0, 0, 5);
		gbc_separator.gridx = 1;
		gbc_separator.gridy = 0;
		add(separator, gbc_separator);

		JLabel lblDisciplinas = new JLabel("Disciplinas");
		lblDisciplinas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDisciplinas = new GridBagConstraints();
		gbc_lblDisciplinas.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblDisciplinas.insets = new Insets(5, 0, 5, 5);
		gbc_lblDisciplinas.gridx = 2;
		gbc_lblDisciplinas.gridy = 0;
		add(lblDisciplinas, gbc_lblDisciplinas);

		JScrollPane scrollPaneDisciplinas = new JScrollPane();
		GridBagConstraints gbc_scrollPaneDisciplinas = new GridBagConstraints();
		gbc_scrollPaneDisciplinas.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPaneDisciplinas.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneDisciplinas.gridx = 2;
		gbc_scrollPaneDisciplinas.gridy = 1;
		add(scrollPaneDisciplinas, gbc_scrollPaneDisciplinas);

		JList listDisciplinas = new JList();
		listDisciplinas.setModel(new AbstractListModel() {
			String[] values = new String[] { "<sem itens>" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPaneDisciplinas.setViewportView(listDisciplinas);

		JButton btnRemoverCurso = new JButton("Remover");
		GridBagConstraints gbc_btnRemoverCurso = new GridBagConstraints();
		gbc_btnRemoverCurso.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnRemoverCurso.insets = new Insets(0, 5, 0, 5);
		gbc_btnRemoverCurso.gridx = 0;
		gbc_btnRemoverCurso.gridy = 2;
		add(btnRemoverCurso, gbc_btnRemoverCurso);

		JPanel panelManageDisciplinas = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelManageDisciplinas.getLayout();
		flowLayout.setVgap(0);
		GridBagConstraints gbc_panelManageDisciplinas = new GridBagConstraints();
		gbc_panelManageDisciplinas.anchor = GridBagConstraints.NORTH;
		gbc_panelManageDisciplinas.insets = new Insets(0, 0, 5, 5);
		gbc_panelManageDisciplinas.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelManageDisciplinas.gridx = 2;
		gbc_panelManageDisciplinas.gridy = 2;
		add(panelManageDisciplinas, gbc_panelManageDisciplinas);

		JButton buttonRemoveDisciplina = new JButton("-");
		panelManageDisciplinas.add(buttonRemoveDisciplina);

		JButton buttonAddDisciplina = new JButton("+");
		panelManageDisciplinas.add(buttonAddDisciplina);
	}

}
