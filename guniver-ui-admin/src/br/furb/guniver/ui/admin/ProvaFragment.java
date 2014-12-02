package br.furb.guniver.ui.admin;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import br.furb.guniver.modelo.Aluno;
import br.furb.guniver.modelo.Prova;
import br.furb.guniver.modelo.Turma;

@SuppressWarnings("serial")
public class ProvaFragment extends Fragment {

	private JTable tableProvas;
	private Controller controller;
	private DefaultTableModel dataModel;
	private List<Prova> provas = new ArrayList<>();
	private boolean fChangingData;
	private Prova selectedProva;

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
		dataModel = new DefaultTableModel(new Object[][] { { null, null, null, null }, }, new String[] { "Aluno", "Turma", "Nota", "Descri\u00E7\u00E3o" }) {
			Class[] columnTypes = new Class[] { String.class, Long.class, Float.class, String.class };
			boolean[] columnEditable = { false, false, true, true };

			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditable[column];
			}

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		};

		dataModel.addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				if (!fChangingData && e.getType() == TableModelEvent.UPDATE) {
					int row = e.getFirstRow();
					int col = e.getColumn();
					Prova prova;
					boolean newAluno;
					if (row == provas.size()) {
						prova = new Prova();
						newAluno = true;
					} else {
						prova = provas.get(row);
						newAluno = false;
					}
					Object newValue = dataModel.getValueAt(row, col);
					Object oldValue;
					switch (col) {
					case 2:
						oldValue = prova.getNota();
						prova.setNota((Float) newValue);
						break;
					case 3:
						oldValue = prova.getDescricao();
						prova.setDescricao((String) newValue);
						break;
					default:
						oldValue = new Object(); // always different
						break;
					}
					if (!newValue.equals(oldValue)) {
						if (newAluno) {
							provas.add(prova);
							reloadTable();
						}
						ProvaFragment.this.controller.uploadProva(prova);
					}
				}
			}
		});

		DefaultListSelectionModel selModel = new DefaultListSelectionModel();
		selModel.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int index = e.getFirstIndex();
				if (index < 0) {
					selectedProva = null;
				} else {
					selectedProva = provas.get(index);
				}
			}
		});
		tableProvas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableProvas.setSelectionModel(selModel);

		tableProvas.setModel(dataModel);
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
		btnAlterarAluno.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (selectedProva != null) {
					changeAluno(selectedProva);
				}
			}
		});
		panelManageProva.add(btnAlterarAluno);

		JButton btnAlterarTurma = new JButton("Alterar Turma");
		btnAlterarTurma.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (selectedProva != null) {
					changeTurma(selectedProva);
				}
			}
		});
		panelManageProva.add(btnAlterarTurma);
	}

	@SuppressWarnings("unchecked")
	public void setProvas(Collection<Prova> provas) {
		fChangingData = true;
		this.provas.clear();
		this.provas.addAll(provas);
		Vector<Vector<?>> dataVector = dataModel.getDataVector();
		dataVector.clear();

		for (Prova p : provas) {
			Vector<Object> row = new Vector<>();
			row.add(p.getAluno().getNome());
			row.add(p.getTurma().getCodigo());
			row.add(p.getNota());
			row.add(p.getDescricao());
			dataVector.add(row);
		}
		// empty row
		dataVector.add(new Vector<>(Arrays.asList(null, null, null, null)));

		dataModel.fireTableDataChanged();
		fChangingData = false;
	}

	public void reloadTable() {
		setProvas(new ArrayList<>(provas));
	}

	public void updateProva(Prova uploadedEntity) {
		reloadTable();
	}

	private void changeAluno(Prova prova) {
		Aluno pickedAluno = controller.pickAluno();
		if (pickedAluno != null) {
			prova.setAluno(pickedAluno);
			updateProva(prova);
		}
	}

	private void changeTurma(Prova prova) {
		Turma turma = controller.pickTurma();
		if (turma != null) {
			prova.setTurma(turma);
			updateProva(prova);
		}
	}

	@Override
	public String getTitle() {
		return "Provas";
	}

}
