package br.furb.guniver.ui.admin;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import br.furb.guniver.modelo.Disciplina;

@SuppressWarnings("serial")
public class DisciplinaFragment extends Fragment {

	private JTable tableDisciplinas;
	private Controller controller;
	private DefaultTableModel dataModel;
	private boolean fChangingData;
	private List<Disciplina> disciplinas = new ArrayList<>();
	private JButton btnRemover;
	private Disciplina selectedDisciplina;

	public DisciplinaFragment(Controller controller) {
		this.controller = controller;
		controller.setDisciplinaFragment(this);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JScrollPane scrollPaneTable = new JScrollPane();
		GridBagConstraints gbc_scrollPaneTable = new GridBagConstraints();
		gbc_scrollPaneTable.insets = new Insets(5, 5, 5, 5);
		gbc_scrollPaneTable.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneTable.gridx = 0;
		gbc_scrollPaneTable.gridy = 0;
		add(scrollPaneTable, gbc_scrollPaneTable);

		tableDisciplinas = new JTable();
		dataModel = new DefaultTableModel(new Object[][] { { null, null }, }, new String[] { "C\u00F3digo", "Nome" }) {
			Class[] columnTypes = new Class[] { Long.class, String.class };

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
					Disciplina disciplina;
					boolean newDisciplina;
					if (row == disciplinas.size()) {
						disciplina = new Disciplina(0, null, null);
						newDisciplina = true;
					} else {
						disciplina = disciplinas.get(row);
						newDisciplina = false;
					}
					Object newValue = dataModel.getValueAt(row, col);
					Object oldValue;
					switch (col) {
					case 0:
						oldValue = disciplina.getCodigo();
						disciplina.setCodigo(((Long) newValue).intValue());
						break;
					case 1:
						oldValue = disciplina.getNome();
						disciplina.setNome((String) newValue);
						break;
					default:
						oldValue = new Object(); // always differente
						break;
					}
					if (!newValue.equals(oldValue)) {
						if (newDisciplina) {
							disciplinas.add(disciplina);
							reloadTable();
						}
						DisciplinaFragment.this.controller.uploadDisciplina(disciplina);
					}
				}
			}
		});

		tableDisciplinas.setModel(dataModel);

		DefaultListSelectionModel selectionModel = new DefaultListSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int index = e.getFirstIndex();
				if (index < 0) {
					selectedDisciplina = null;
				} else {
					selectedDisciplina = disciplinas.get(index);
				}
			}
		});
		tableDisciplinas.setSelectionModel(selectionModel);
		tableDisciplinas.getColumnModel().getColumn(1).setPreferredWidth(150);
		scrollPaneTable.setViewportView(tableDisciplinas);

		btnRemover = new JButton("Remover");

		setPickUpMode(false);
	}

	public void setDisciplinas(Collection<Disciplina> disciplinas) {
		fChangingData = true;
		this.disciplinas.clear();
		this.disciplinas.addAll(disciplinas);

		@SuppressWarnings("unchecked")
		Vector<Vector<?>> dataVector = dataModel.getDataVector();
		dataVector.clear();

		for (Disciplina d : disciplinas) {
			Vector<Object> row = new Vector<>();
			row.add(d.getCodigo());
			row.add(d.getNome());
			dataVector.add(row);
		}
		// empty row
		dataVector.add(new Vector<>(Arrays.asList(null, null)));

		dataModel.fireTableDataChanged();
		fChangingData = false;
	}

	public void reloadTable() {
		setDisciplinas(new ArrayList<>(disciplinas));
	}

	public void updateDisciplina(Disciplina disciplina) {
		int row = this.disciplinas.indexOf(disciplina);
		fChangingData = true;
		dataModel.fireTableRowsUpdated(row, row);
		fChangingData = false;
	}

	public void setPickUpMode(boolean picking) {
		if (picking) {
			remove(btnRemover);
		} else {
			GridBagConstraints gbc_btnRemover = new GridBagConstraints();
			gbc_btnRemover.insets = new Insets(0, 5, 5, 5);
			gbc_btnRemover.anchor = GridBagConstraints.EAST;
			gbc_btnRemover.gridx = 0;
			gbc_btnRemover.gridy = 1;
			add(btnRemover, gbc_btnRemover);
		}
	}

	public Disciplina getSelectedDisciplina() {
		return selectedDisciplina;
	}

	@Override
	public String getTitle() {
		return "Disciplinas";
	}

}
