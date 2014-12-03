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

import br.furb.guniver.central_do_aluno.stubs.Disciplina;
import br.furb.guniver.central_do_aluno.stubs.Turma;
import br.furb.guniver.ui.Fragment;

@SuppressWarnings("serial")
public class TurmaFragment extends Fragment {

	private JTable tableTurmas;
	private Controller controller;
	private DefaultTableModel dataModel;
	private List<Turma> turmas = new ArrayList<>();
	private boolean fChangingData;
	private Turma selectedTurma;
	private JPanel panelManageTurmas;
	private boolean isPicking;

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
		dataModel = new DefaultTableModel(new Object[][] { { null, null, null, null }, }, new String[] { "C\u00F3digo", "Ano", "Semestre", "Disciplina" }) {
			Class[] columnTypes = new Class[] { Long.class, Short.class, Byte.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				return !isPicking && column != 3;
			}
		};

		dataModel.addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				if (!fChangingData && e.getType() == TableModelEvent.UPDATE) {
					int row = e.getFirstRow();
					int col = e.getColumn();
					Turma turma;
					boolean newTurma;
					if (row == turmas.size()) {
						turma = new Turma();
						newTurma = true;
					} else {
						turma = turmas.get(row);
						newTurma = false;
					}
					Object newValue = dataModel.getValueAt(row, col);
					Object oldValue;
					switch (col) {
					case 0:
						oldValue = turma.getCodigo();
						turma.setCodigo(((Long) newValue).intValue());
						break;
					case 1:
						oldValue = turma.getAno();
						turma.setAno((Short) newValue);
						break;
					case 2:
						oldValue = turma.getSemestre();
						turma.setSemestre((Byte) newValue);
						break;
					default:
						oldValue = new Object(); // always different
						break;
					}
					if (!newValue.equals(oldValue)) {
						if (newTurma) {
							turmas.add(turma);
							reloadTable();
						}
						TurmaFragment.this.controller.uploadTurma(turma);
					}
				}
			}
		});
		tableTurmas.setModel(dataModel);

		DefaultListSelectionModel selModel = new DefaultListSelectionModel();
		selModel.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int index = e.getFirstIndex();
				if (index < 0 || index >= turmas.size()) {
					selectedTurma = null;
				} else {
					selectedTurma = turmas.get(index);
				}
			}
		});
		tableTurmas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableTurmas.setSelectionModel(selModel);

		tableTurmas.getColumnModel().getColumn(1).setPreferredWidth(50);
		tableTurmas.getColumnModel().getColumn(2).setPreferredWidth(60);
		tableTurmas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneTurmas.setViewportView(tableTurmas);

		panelManageTurmas = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelManageTurmas.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setAlignment(FlowLayout.RIGHT);

		JButton btnRemover = new JButton("Remover");
		btnRemover.setVisible(false);
		btnRemover.setEnabled(false);
		panelManageTurmas.add(btnRemover);

		JButton btnAlterarDisciplina = new JButton("Alterar Disciplina");
		btnAlterarDisciplina.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (selectedTurma != null) {
					changeDisciplina(selectedTurma);
				}
			}
		});
		panelManageTurmas.add(btnAlterarDisciplina);

		setPickUpMode(false);
	}

	public void reloadTable() {
		setTurmas(new ArrayList<>(turmas));
	}

	@SuppressWarnings("unchecked")
	public void setTurmas(Collection<Turma> turmas) {
		fChangingData = true;
		this.turmas.clear();
		this.turmas.addAll(turmas);
		Vector<Vector<?>> dataVector = dataModel.getDataVector();
		dataVector.clear();

		for (Turma t : turmas) {
			Vector<Object> row = new Vector<>();
			row.add(t.getCodigo());
			row.add(t.getAno());
			row.add(t.getSemestre());
			row.add(t.getDisciplina() == null ? "--" : t.getDisciplina().getNome());
			dataVector.add(row);
		}
		// empty row
		dataVector.add(new Vector<>(Arrays.asList(null, null, null, null)));

		dataModel.fireTableDataChanged();
		fChangingData = false;
	}

	public void updateTurma(Turma downloadedEntity) {
		reloadTable();
	}

	private void changeDisciplina(Turma turma) {
		Disciplina disciplinaPicked = controller.pickDisciplina();
		if (disciplinaPicked != null) {
			turma.setDisciplina(disciplinaPicked);
			updateTurma(turma);
			TurmaFragment.this.controller.uploadTurma(turma);
		}
	}

	public void setPickUpMode(boolean isPicking) {
		this.isPicking = isPicking;
		if (isPicking) {
			remove(panelManageTurmas);
		} else {
			GridBagConstraints gbc_panelManageTurmas = new GridBagConstraints();
			gbc_panelManageTurmas.insets = new Insets(0, 5, 5, 0);
			gbc_panelManageTurmas.anchor = GridBagConstraints.NORTHEAST;
			gbc_panelManageTurmas.gridx = 0;
			gbc_panelManageTurmas.gridy = 1;
			add(panelManageTurmas, gbc_panelManageTurmas);
		}
	}

	public Turma getSelectedTurma() {
		return selectedTurma;
	}

	@Override
	public String getTitle() {
		return "Turmas";
	}

}
