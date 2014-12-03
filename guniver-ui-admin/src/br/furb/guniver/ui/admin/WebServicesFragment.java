package br.furb.guniver.ui.admin;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.furb.guniver.ui.Fragment;
import br.furb.guniver.ui.utils.UIUtils;

@SuppressWarnings("serial")
public class WebServicesFragment extends Fragment {

	private JTextField txtAcademico;
	private JTextField txtCadastro;
	private Controller controller;

	private final JTextField[] urlFields;
	private String[] originalUrls = new String[2];

	public WebServicesFragment(Controller controller) {
		this.controller = controller;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(5, 5, 5, 5);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblAcadmico = new JLabel("Acadêmico:");
		GridBagConstraints gbc_lblAcadmico = new GridBagConstraints();
		gbc_lblAcadmico.anchor = GridBagConstraints.EAST;
		gbc_lblAcadmico.insets = new Insets(0, 0, 5, 5);
		gbc_lblAcadmico.gridx = 0;
		gbc_lblAcadmico.gridy = 0;
		panel.add(lblAcadmico, gbc_lblAcadmico);

		txtAcademico = new JTextField();
		GridBagConstraints gbc_txtAcademico = new GridBagConstraints();
		gbc_txtAcademico.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAcademico.insets = new Insets(0, 0, 5, 0);
		gbc_txtAcademico.gridx = 1;
		gbc_txtAcademico.gridy = 0;
		panel.add(txtAcademico, gbc_txtAcademico);
		txtAcademico.setColumns(10);

		JLabel lblCadastro = new JLabel("Cadastro:");
		GridBagConstraints gbc_lblCadastro = new GridBagConstraints();
		gbc_lblCadastro.anchor = GridBagConstraints.EAST;
		gbc_lblCadastro.insets = new Insets(0, 0, 5, 5);
		gbc_lblCadastro.gridx = 0;
		gbc_lblCadastro.gridy = 1;
		panel.add(lblCadastro, gbc_lblCadastro);

		txtCadastro = new JTextField();
		GridBagConstraints gbc_txtCadastro = new GridBagConstraints();
		gbc_txtCadastro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCadastro.insets = new Insets(0, 0, 5, 0);
		gbc_txtCadastro.gridx = 1;
		gbc_txtCadastro.gridy = 1;
		panel.add(txtCadastro, gbc_txtCadastro);
		txtCadastro.setColumns(10);

		JPanel panelAcoes = new JPanel();
		GridBagConstraints gbc_panelAcoes = new GridBagConstraints();
		gbc_panelAcoes.insets = new Insets(0, 0, 5, 0);
		gbc_panelAcoes.fill = GridBagConstraints.BOTH;
		gbc_panelAcoes.gridx = 0;
		gbc_panelAcoes.gridy = 1;
		add(panelAcoes, gbc_panelAcoes);
		panelAcoes.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 0));

		JButton btnForarAtualizao = new JButton("Forçar Atualização");
		btnForarAtualizao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				forceUpdate();
			}
		});
		panelAcoes.add(btnForarAtualizao);

		JButton btnAtualizar = new JButton("Definir");
		btnAtualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setURLs();
			}
		});
		panelAcoes.add(btnAtualizar);

		urlFields = new JTextField[] { txtAcademico, txtCadastro };
	}

	@Override
	public void onEnter() {
		super.onEnter();
		originalUrls = readURLs();
	}

	@Override
	public boolean canExit() {
		if (hasUnsavedUrls()) {
			if (UIUtils.promptConfirmation(controller.getMainWindow(), //
					"Existem URLs alteradas não definidas. Deseja descartá-las?", // 
					"Confirmação")) {
				for (int i = 0; i < urlFields.length; i++) {
					urlFields[i].setText(originalUrls[i]);
				}
				return true;
			}
			return false;
		}
		return true;
	}

	public boolean hasUnsavedUrls() {
		return !Arrays.equals(originalUrls, readURLs());
	}

	private String[] readURLs() {
		String[] urls = new String[urlFields.length];
		for (int i = 0; i < urlFields.length; i++) {
			urls[i] = urlFields[i].getText().trim();
		}
		return urls;
	}

	private void setURLs() {
		if (hasUnsavedUrls()) {
			if (UIUtils.promptConfirmation(controller.getMainWindow(), // 
					"Isso irá interromper todas as comunicações ativas. Tem certeza de que deseja continuar?", // 
					"Alterar URLs")) {
				String[] urls = readURLs();
				controller.changeUrls( //
						urls[0], // Academico
						urls[1]);// Cadastro
				originalUrls = urls;
			}
		}
	}

	private void forceUpdate() {
		controller.downloadAll();
	}

	@Override
	public String getTitle() {
		return "Web Services";
	}

}
