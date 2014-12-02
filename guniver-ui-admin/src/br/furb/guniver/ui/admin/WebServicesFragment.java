package br.furb.guniver.ui.admin;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class WebServicesFragment extends Fragment {
	private JTextField txtAcademico;
	private JTextField txtCadastro;
	private JTextField txtCentraldoaluno;
	private JTextField txtFinanceiro;
	public WebServicesFragment() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblAcadmico = new JLabel("Acadêmico:");
		GridBagConstraints gbc_lblAcadmico = new GridBagConstraints();
		gbc_lblAcadmico.anchor = GridBagConstraints.EAST;
		gbc_lblAcadmico.insets = new Insets(5, 5, 5, 5);
		gbc_lblAcadmico.gridx = 0;
		gbc_lblAcadmico.gridy = 0;
		add(lblAcadmico, gbc_lblAcadmico);
		
		txtAcademico = new JTextField();
		GridBagConstraints gbc_txtAcademico = new GridBagConstraints();
		gbc_txtAcademico.insets = new Insets(5, 0, 5, 5);
		gbc_txtAcademico.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAcademico.gridx = 1;
		gbc_txtAcademico.gridy = 0;
		add(txtAcademico, gbc_txtAcademico);
		txtAcademico.setColumns(10);
		
		JLabel lblCadastro = new JLabel("Cadastro:");
		GridBagConstraints gbc_lblCadastro = new GridBagConstraints();
		gbc_lblCadastro.anchor = GridBagConstraints.EAST;
		gbc_lblCadastro.insets = new Insets(0, 5, 5, 5);
		gbc_lblCadastro.gridx = 0;
		gbc_lblCadastro.gridy = 1;
		add(lblCadastro, gbc_lblCadastro);
		
		txtCadastro = new JTextField();
		GridBagConstraints gbc_txtCadastro = new GridBagConstraints();
		gbc_txtCadastro.insets = new Insets(0, 0, 5, 5);
		gbc_txtCadastro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCadastro.gridx = 1;
		gbc_txtCadastro.gridy = 1;
		add(txtCadastro, gbc_txtCadastro);
		txtCadastro.setColumns(10);
		
		JLabel lblCentralDoAluno = new JLabel("Central do Aluno");
		GridBagConstraints gbc_lblCentralDoAluno = new GridBagConstraints();
		gbc_lblCentralDoAluno.anchor = GridBagConstraints.EAST;
		gbc_lblCentralDoAluno.insets = new Insets(0, 5, 5, 5);
		gbc_lblCentralDoAluno.gridx = 0;
		gbc_lblCentralDoAluno.gridy = 2;
		add(lblCentralDoAluno, gbc_lblCentralDoAluno);
		
		txtCentraldoaluno = new JTextField();
		GridBagConstraints gbc_txtCentraldoaluno = new GridBagConstraints();
		gbc_txtCentraldoaluno.insets = new Insets(0, 0, 5, 5);
		gbc_txtCentraldoaluno.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCentraldoaluno.gridx = 1;
		gbc_txtCentraldoaluno.gridy = 2;
		add(txtCentraldoaluno, gbc_txtCentraldoaluno);
		txtCentraldoaluno.setColumns(10);
		
		JLabel lblFinanceiro = new JLabel("Financeiro:");
		GridBagConstraints gbc_lblFinanceiro = new GridBagConstraints();
		gbc_lblFinanceiro.anchor = GridBagConstraints.EAST;
		gbc_lblFinanceiro.insets = new Insets(0, 5, 5, 5);
		gbc_lblFinanceiro.gridx = 0;
		gbc_lblFinanceiro.gridy = 3;
		add(lblFinanceiro, gbc_lblFinanceiro);
		
		txtFinanceiro = new JTextField();
		GridBagConstraints gbc_txtFinanceiro = new GridBagConstraints();
		gbc_txtFinanceiro.insets = new Insets(0, 0, 5, 5);
		gbc_txtFinanceiro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFinanceiro.gridx = 1;
		gbc_txtFinanceiro.gridy = 3;
		add(txtFinanceiro, gbc_txtFinanceiro);
		txtFinanceiro.setColumns(10);
		
		JPanel panelAcoes = new JPanel();
		GridBagConstraints gbc_panelAcoes = new GridBagConstraints();
		gbc_panelAcoes.insets = new Insets(0, 0, 5, 0);
		gbc_panelAcoes.fill = GridBagConstraints.BOTH;
		gbc_panelAcoes.gridx = 1;
		gbc_panelAcoes.gridy = 4;
		add(panelAcoes, gbc_panelAcoes);
		panelAcoes.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 0));
		
		JButton btnForarAtualizao = new JButton("Forçar Atualização");
		panelAcoes.add(btnForarAtualizao);
		
		JButton btnAtualizar = new JButton("Definir");
		panelAcoes.add(btnAtualizar);
	}

}
