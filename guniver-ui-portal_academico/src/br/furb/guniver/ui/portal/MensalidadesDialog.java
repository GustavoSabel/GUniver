package br.furb.guniver.ui.portal;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.furb.guniver.central_do_aluno.stubs.Mensalidade;

@SuppressWarnings("serial")
public class MensalidadesDialog extends JDialog {

	private JTable tableMensalidades;
	private PortalController controller;
	private Collection<Mensalidade> mensalidades = new LinkedList<>();
	private DefaultTableModel mensalidadesDataModel;

	/**
	 * Create the dialog.
	 */
	public MensalidadesDialog(PortalController controller) {
		this.controller = controller;
		setTitle("Mensalidades");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		{
			JScrollPane scrollPaneMensalidades = new JScrollPane();
			getContentPane().add(scrollPaneMensalidades, BorderLayout.CENTER);
			{
				tableMensalidades = new JTable();
				mensalidadesDataModel = new DefaultTableModel(new Object[][] {}, new String[] { "Data", "Situa\u00E7\u00E3o", "Valor", "Descri\u00E7\u00E3o" }) {
					Class[] columnTypes = new Class[] { Object.class, String.class, Float.class, String.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}

					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};
				tableMensalidades.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Compet\u00EAncia", "Situa\u00E7\u00E3o", "Valor", "Descri\u00E7\u00E3o" }) {
					Class[] columnTypes = new Class[] { Object.class, String.class, Float.class, String.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
				tableMensalidades.setFillsViewportHeight(true);
				scrollPaneMensalidades.setViewportView(tableMensalidades);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

	@Override
	public void setVisible(boolean b) {
		super.setVisible(b);
		if (b) {
			controller.setOpenMensalidadesDialog(this);
		} else {
			controller.setOpenMensalidadesDialog(null);
		}
	}

	public void reloadTable() {
		setMensalidades(new ArrayList<>(mensalidades));
	}

	private SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/yyyy");

	public void setMensalidades(Collection<Mensalidade> entities) {
		this.mensalidades.clear();
		this.mensalidades.addAll(entities);

		Vector<Vector<Object>> vector = mensalidadesDataModel.getDataVector();
		vector.clear();
		for (Mensalidade mensalidade : entities) {
			Vector<Object> row = new Vector<>();
			row.add(DATE_FORMAT.format(mensalidade.getData()));
			row.add(mensalidade.getSituacao());
			row.add(mensalidade.getValor());
			row.add(mensalidade.getDescricao());
			vector.add(row);
		}

		mensalidadesDataModel.fireTableDataChanged();
	}

}
