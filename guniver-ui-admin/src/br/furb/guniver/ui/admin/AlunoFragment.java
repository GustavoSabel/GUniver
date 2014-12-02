package br.furb.guniver.ui.admin;

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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import br.furb.guniver.modelo.Aluno;
import br.furb.guniver.ui.utils.UIUtils;

@SuppressWarnings("serial")
public class AlunoFragment extends Fragment {

	private JTable tableAlunos;
	private DefaultTableModel dataModel;
	private List<Aluno> alunos = new ArrayList<>();
	private Controller controller;

	private boolean fChangingData;
	private Aluno selectedAluno;
	private JButton btnRemover;

	public AlunoFragment(Controller controller) {
		this.controller = controller;
		controller.setAlunoFragment(this);
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

		tableAlunos = new JTable();
		dataModel = new DefaultTableModel(new Object[][] { { null, null, null, null }, }, new String[] { "C\u00F3digo", "Nome", "Usu\u00E1rio", "Senha" }) {
			Class<?>[] columnTypes = new Class[] { Long.class, String.class, String.class, String.class };

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		};

		dataModel.addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				if (!fChangingData && e.getType() == TableModelEvent.UPDATE) {
					int row = e.getFirstRow();
					int col = e.getColumn();
					Aluno aluno;
					boolean newAluno;
					if (row == alunos.size()) {
						aluno = new Aluno();
						newAluno = true;
					} else {
						aluno = alunos.get(row);
						newAluno = false;
					}
					Object newValue = dataModel.getValueAt(row, col);
					Object oldValue;
					switch (col) {
					case 0:
						oldValue = aluno.getCodigo();
						aluno.setCodigo(((Long) newValue).intValue());
						break;
					case 1:
						oldValue = aluno.getNome();
						aluno.setNome((String) newValue);
						break;
					case 2:
						oldValue = aluno.getNomeUsuario();
						aluno.setNomeUsuario((String) newValue);
						break;
					case 3:
						oldValue = aluno.getSenha();
						aluno.setSenha((String) newValue);
						break;
					default:
						oldValue = new Object(); // always differente
						break;
					}
					if (!newValue.equals(oldValue)) {
						if (newAluno) {
							alunos.add(aluno);
							reloadTable();
						}
						AlunoFragment.this.controller.uploadAluno(aluno);
					}
				}
			}
		});

		DefaultListSelectionModel selectionModel = new DefaultListSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int index = e.getFirstIndex();
				if (index < 0 || index >= alunos.size()) {
					selectedAluno = null;
				} else {
					selectedAluno = alunos.get(index);
				}
			}
		});
		tableAlunos.setSelectionModel(selectionModel);

		tableAlunos.setModel(dataModel);
		tableAlunos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableAlunos.getColumnModel().getColumn(1).setPreferredWidth(150);
		tableAlunos.getColumnModel().getColumn(2).setPreferredWidth(100);
		tableAlunos.getColumnModel().getColumn(3).setPreferredWidth(100);
		scrollPaneTable.setViewportView(tableAlunos);

		btnRemover = new JButton("Remover");
		btnRemover.setVisible(false);
		btnRemover.setEnabled(false);
		btnRemover.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				UIUtils.showMessage(AlunoFragment.this.controller.getMainWindow(), "Função não implementada. Consulte os devs ;)", "Ops!", JOptionPane.WARNING_MESSAGE);
			}
		});

		setPickUpMode(false);
	}

	@SuppressWarnings("unchecked")
	public void setAlunos(Collection<Aluno> alunos) {
		fChangingData = true;
		this.alunos.clear();
		this.alunos.addAll(alunos);
		Vector<Vector<?>> dataVector = dataModel.getDataVector();
		dataVector.clear();

		for (Aluno a : alunos) {
			Vector<Object> row = new Vector<>();
			row.add(a.getCodigo());
			row.add(a.getNome());
			row.add(a.getNomeUsuario());
			row.add(a.getSenha());
			dataVector.add(row);
		}
		// empty row
		dataVector.add(new Vector<>(Arrays.asList(null, null, null, null)));

		dataModel.fireTableDataChanged();
		fChangingData = false;
	}

	public void reloadTable() {
		setAlunos(new ArrayList<>(alunos));
	}

	public void updateAluno(Aluno uploadedEntity) {
		int row = this.alunos.indexOf(uploadedEntity);
		fChangingData = true;
		dataModel.fireTableRowsUpdated(row, row);
		fChangingData = false;
	}

	public Aluno getSelectedAluno() {
		return selectedAluno;
	}

	public void setPickUpMode(boolean pickingUp) {
		if (pickingUp) {
			remove(btnRemover);
		} else {
			GridBagConstraints gbc_btnRemover = new GridBagConstraints();
			gbc_btnRemover.anchor = GridBagConstraints.EAST;
			gbc_btnRemover.insets = new Insets(0, 5, 5, 5);
			gbc_btnRemover.gridx = 0;
			gbc_btnRemover.gridy = 1;
			add(btnRemover, gbc_btnRemover);
		}
	}

	@Override
	public String getTitle() {
		return "Alunos";
	}

}
