package br.furb.guniver.ui.portal;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class CompromissosDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CompromissosDialog dialog = new CompromissosDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CompromissosDialog() {
		setTitle("Compromissos");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JScrollPane scrollPaneCompromissos = new JScrollPane();
			GridBagConstraints gbc_scrollPaneCompromissos = new GridBagConstraints();
			gbc_scrollPaneCompromissos.insets = new Insets(0, 0, 5, 0);
			gbc_scrollPaneCompromissos.fill = GridBagConstraints.BOTH;
			gbc_scrollPaneCompromissos.gridx = 0;
			gbc_scrollPaneCompromissos.gridy = 0;
			contentPanel.add(scrollPaneCompromissos, gbc_scrollPaneCompromissos);
			{
				table = new JTable();
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"In\u00EDcio", "Fim", "Dia inteiro", "T\u00EDtulo", "Descri\u00E7\u00E3o"
					}
				) {
					Class[] columnTypes = new Class[] {
						String.class, String.class, String.class, String.class, String.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
					boolean[] columnEditables = new boolean[] {
						false, false, false, false, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				table.setFillsViewportHeight(true);
				scrollPaneCompromissos.setViewportView(table);
			}
		}
		{
			JPanel panelButtons = new JPanel();
			GridBagConstraints gbc_panelButtons = new GridBagConstraints();
			gbc_panelButtons.fill = GridBagConstraints.BOTH;
			gbc_panelButtons.gridx = 0;
			gbc_panelButtons.gridy = 1;
			contentPanel.add(panelButtons, gbc_panelButtons);
			panelButtons.setLayout(new FlowLayout(FlowLayout.TRAILING, 5, 5));
			{
				JButton btnRemover = new JButton("Remover");
				panelButtons.add(btnRemover);
			}
			{
				JButton btnAlterar = new JButton("Criar/Editar");
				panelButtons.add(btnAlterar);
			}
		}
	}

}
