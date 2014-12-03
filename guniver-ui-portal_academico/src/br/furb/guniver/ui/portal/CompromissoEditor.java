package br.furb.guniver.ui.portal;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.DateFormatter;

@SuppressWarnings("serial")
public class CompromissoEditor extends JDialog {

	private static final int HOUR = 60 * 60 * 1000;
	private final JPanel centerPanel = new JPanel();
	private JTextField txtTitulo;
	private JTextArea txtrDescricao;
	private JFormattedTextField frmtdtxtfldDe;
	private JFormattedTextField frmtdtxtfldDeHora;
	private JFormattedTextField frmtdtxtfldAteHora;
	private JFormattedTextField frmtdtxtfldAte;
	private JList listLembretes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CompromissoEditor dialog = new CompromissoEditor();
			dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CompromissoEditor() {
		setTitle("Edição de Compromisso");
		setBounds(100, 100, 450, 351);
		getContentPane().setLayout(new BorderLayout());
		centerPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(centerPanel, BorderLayout.CENTER);
		GridBagLayout gbl_centerPanel = new GridBagLayout();
		gbl_centerPanel.columnWidths = new int[] { 0, 80, 80, 0, 0 };
		gbl_centerPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_centerPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_centerPanel.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		centerPanel.setLayout(gbl_centerPanel);
		Date now = new Date();
		Date after = new Date(now.getTime() + HOUR);
		{
			JLabel lblTitulo = new JLabel("Título:");
			GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
			gbc_lblTitulo.insets = new Insets(0, 0, 5, 5);
			gbc_lblTitulo.gridx = 0;
			gbc_lblTitulo.gridy = 0;
			centerPanel.add(lblTitulo, gbc_lblTitulo);
		}
		{
			txtTitulo = new JTextField();
			GridBagConstraints gbc_txtTitulo = new GridBagConstraints();
			gbc_txtTitulo.gridwidth = 3;
			gbc_txtTitulo.insets = new Insets(0, 0, 5, 5);
			gbc_txtTitulo.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtTitulo.gridx = 1;
			gbc_txtTitulo.gridy = 0;
			centerPanel.add(txtTitulo, gbc_txtTitulo);
			txtTitulo.setColumns(10);
		}
		{
			JLabel lblDescricao = new JLabel("Descrição:");
			GridBagConstraints gbc_lblDescricao = new GridBagConstraints();
			gbc_lblDescricao.insets = new Insets(0, 0, 5, 5);
			gbc_lblDescricao.gridx = 0;
			gbc_lblDescricao.gridy = 1;
			centerPanel.add(lblDescricao, gbc_lblDescricao);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridwidth = 3;
			gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
			gbc_scrollPane.gridx = 1;
			gbc_scrollPane.gridy = 1;
			centerPanel.add(scrollPane, gbc_scrollPane);
			{
				txtrDescricao = new JTextArea();
				txtrDescricao.setFont(txtTitulo.getFont());
				scrollPane.setViewportView(txtrDescricao);
			}
		}
		{
			JLabel lblDe = new JLabel("De:");
			GridBagConstraints gbc_lblDe = new GridBagConstraints();
			gbc_lblDe.anchor = GridBagConstraints.EAST;
			gbc_lblDe.insets = new Insets(0, 0, 5, 5);
			gbc_lblDe.gridx = 0;
			gbc_lblDe.gridy = 2;
			centerPanel.add(lblDe, gbc_lblDe);
		}
		{
			frmtdtxtfldDe = new JFormattedTextField(new DateFormatter(new SimpleDateFormat("dd/MM/yyyy")));
			frmtdtxtfldDe.setValue(now);
			GridBagConstraints gbc_frmtdtxtfldDe = new GridBagConstraints();
			gbc_frmtdtxtfldDe.fill = GridBagConstraints.HORIZONTAL;
			gbc_frmtdtxtfldDe.insets = new Insets(0, 0, 5, 5);
			gbc_frmtdtxtfldDe.gridx = 1;
			gbc_frmtdtxtfldDe.gridy = 2;
			centerPanel.add(frmtdtxtfldDe, gbc_frmtdtxtfldDe);
		}
		{
			frmtdtxtfldDeHora = new JFormattedTextField(new DateFormatter(new SimpleDateFormat("hh:mm")));
			frmtdtxtfldDeHora.setValue(now);
			GridBagConstraints gbc_frmtdtxtfldDeHora = new GridBagConstraints();
			gbc_frmtdtxtfldDeHora.insets = new Insets(0, 0, 5, 5);
			gbc_frmtdtxtfldDeHora.fill = GridBagConstraints.HORIZONTAL;
			gbc_frmtdtxtfldDeHora.gridx = 2;
			gbc_frmtdtxtfldDeHora.gridy = 2;
			centerPanel.add(frmtdtxtfldDeHora, gbc_frmtdtxtfldDeHora);
		}
		{
			JLabel lblAte = new JLabel("Até:");
			GridBagConstraints gbc_lblAte = new GridBagConstraints();
			gbc_lblAte.anchor = GridBagConstraints.EAST;
			gbc_lblAte.insets = new Insets(0, 0, 5, 5);
			gbc_lblAte.gridx = 0;
			gbc_lblAte.gridy = 3;
			centerPanel.add(lblAte, gbc_lblAte);
		}
		{
			frmtdtxtfldAte = new JFormattedTextField(new DateFormatter(new SimpleDateFormat("dd/MM/yyyy")));
			frmtdtxtfldAte.setValue(after);
			GridBagConstraints gbc_frmtdtxtfldAte = new GridBagConstraints();
			gbc_frmtdtxtfldAte.fill = GridBagConstraints.HORIZONTAL;
			gbc_frmtdtxtfldAte.insets = new Insets(0, 0, 5, 5);
			gbc_frmtdtxtfldAte.gridx = 1;
			gbc_frmtdtxtfldAte.gridy = 3;
			centerPanel.add(frmtdtxtfldAte, gbc_frmtdtxtfldAte);
		}
		{
			frmtdtxtfldAteHora = new JFormattedTextField(new DateFormatter(new SimpleDateFormat("hh:mm")));
			frmtdtxtfldAteHora.setValue(after);
			GridBagConstraints gbc_frmtdtxtfldAteHora = new GridBagConstraints();
			gbc_frmtdtxtfldAteHora.insets = new Insets(0, 0, 5, 5);
			gbc_frmtdtxtfldAteHora.fill = GridBagConstraints.HORIZONTAL;
			gbc_frmtdtxtfldAteHora.gridx = 2;
			gbc_frmtdtxtfldAteHora.gridy = 3;
			centerPanel.add(frmtdtxtfldAteHora, gbc_frmtdtxtfldAteHora);
		}
		{
			JCheckBox chckbxDiaInteiro = new JCheckBox("Dia inteiro");
			GridBagConstraints gbc_chckbxDiaInteiro = new GridBagConstraints();
			gbc_chckbxDiaInteiro.anchor = GridBagConstraints.NORTHWEST;
			gbc_chckbxDiaInteiro.gridwidth = 2;
			gbc_chckbxDiaInteiro.insets = new Insets(0, 0, 5, 5);
			gbc_chckbxDiaInteiro.gridx = 1;
			gbc_chckbxDiaInteiro.gridy = 4;
			centerPanel.add(chckbxDiaInteiro, gbc_chckbxDiaInteiro);
		}
		{
			JPanel panelLembretes = new JPanel();
			panelLembretes.setBorder(new TitledBorder(null, "Lembretes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			GridBagConstraints gbc_panelLembretes = new GridBagConstraints();
			gbc_panelLembretes.anchor = GridBagConstraints.WEST;
			gbc_panelLembretes.insets = new Insets(0, 0, 0, 5);
			gbc_panelLembretes.gridwidth = 4;
			gbc_panelLembretes.fill = GridBagConstraints.VERTICAL;
			gbc_panelLembretes.gridx = 0;
			gbc_panelLembretes.gridy = 5;
			centerPanel.add(panelLembretes, gbc_panelLembretes);
			GridBagLayout gbl_panelLembretes = new GridBagLayout();
			gbl_panelLembretes.columnWidths = new int[] { 173, 0, 0 };
			gbl_panelLembretes.rowHeights = new int[] { 0, 0, 0, 0 };
			gbl_panelLembretes.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
			gbl_panelLembretes.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
			panelLembretes.setLayout(gbl_panelLembretes);
			{
				JScrollPane scrollPane = new JScrollPane();
				GridBagConstraints gbc_scrollPane = new GridBagConstraints();
				gbc_scrollPane.gridheight = 3;
				gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
				gbc_scrollPane.fill = GridBagConstraints.BOTH;
				gbc_scrollPane.gridx = 0;
				gbc_scrollPane.gridy = 0;
				panelLembretes.add(scrollPane, gbc_scrollPane);
				{
					listLembretes = new JList();
					scrollPane.setViewportView(listLembretes);
				}
			}
			{
				JButton btnAdicionar = new JButton("Adicionar");
				GridBagConstraints gbc_btnAdicionar = new GridBagConstraints();
				gbc_btnAdicionar.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnAdicionar.insets = new Insets(0, 0, 5, 0);
				gbc_btnAdicionar.gridx = 1;
				gbc_btnAdicionar.gridy = 0;
				panelLembretes.add(btnAdicionar, gbc_btnAdicionar);
			}
			{
				JButton btnRemover = new JButton("Remover");
				GridBagConstraints gbc_btnRemover = new GridBagConstraints();
				gbc_btnRemover.insets = new Insets(0, 0, 5, 0);
				gbc_btnRemover.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnRemover.gridx = 1;
				gbc_btnRemover.gridy = 1;
				panelLembretes.add(btnRemover, gbc_btnRemover);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setActionCommand("OK");
				buttonPane.add(btnCancelar);
				getRootPane().setDefaultButton(btnCancelar);
			}
			{
				JButton btnAlterar = new JButton("Criar/Alterar");
				btnAlterar.setActionCommand("Cancel");
				buttonPane.add(btnAlterar);
			}
		}
	}

}
