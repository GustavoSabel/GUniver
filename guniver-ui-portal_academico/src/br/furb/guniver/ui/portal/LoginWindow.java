package br.furb.guniver.ui.portal;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.furb.guniver.ui.utils.UIUtils;

@SuppressWarnings("serial")
public class LoginWindow extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField pwdPassword;
	private PortalController controller;
	private JLabel lblWebServiceUrl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIUtils.changeLookAndFeelIfPossible(UIUtils.SupportedLookAndFeel.SYSTEM_DEFAULT);

					PortalController controller = new PortalController();
					LoginWindow frame = new LoginWindow(controller);
					frame.setVisible(true);

					UIUtils.centerOnScreen(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginWindow(PortalController controller) {
		this.controller = controller;
		setTitle("Portal Acadêmico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 319, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelCenter = new JPanel();
		contentPane.add(panelCenter);
		GridBagLayout gbl_panelCenter = new GridBagLayout();
		gbl_panelCenter.columnWidths = new int[] { 0, 131, 0, 0 };
		gbl_panelCenter.rowHeights = new int[] { 130, 0, 0 };
		gbl_panelCenter.columnWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelCenter.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panelCenter.setLayout(gbl_panelCenter);

		JPanel panelLogin = new JPanel();
		GridBagConstraints gbc_panelLogin = new GridBagConstraints();
		gbc_panelLogin.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelLogin.anchor = GridBagConstraints.NORTH;
		gbc_panelLogin.gridx = 1;
		gbc_panelLogin.gridy = 0;
		panelCenter.add(panelLogin, gbc_panelLogin);
		GridBagLayout gbl_panelLogin = new GridBagLayout();
		gbl_panelLogin.columnWidths = new int[] { 0, 0, 0 };
		gbl_panelLogin.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panelLogin.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelLogin.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelLogin.setLayout(gbl_panelLogin);

		JLabel lblBemVindo = new JLabel("Bem vindo!");
		lblBemVindo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		GridBagConstraints gbc_lblBemVindo = new GridBagConstraints();
		gbc_lblBemVindo.insets = new Insets(0, 0, 20, 0);
		gbc_lblBemVindo.gridwidth = 2;
		gbc_lblBemVindo.gridx = 0;
		gbc_lblBemVindo.gridy = 0;
		panelLogin.add(lblBemVindo, gbc_lblBemVindo);

		JLabel lblUsuario = new JLabel("Usuário:");
		GridBagConstraints gbc_lblUsurio = new GridBagConstraints();
		gbc_lblUsurio.anchor = GridBagConstraints.EAST;
		gbc_lblUsurio.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsurio.gridx = 0;
		gbc_lblUsurio.gridy = 1;
		panelLogin.add(lblUsuario, gbc_lblUsurio);

		txtUsuario = new JTextField();
		GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
		gbc_txtUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_txtUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsuario.gridx = 1;
		gbc_txtUsuario.gridy = 1;
		panelLogin.add(txtUsuario, gbc_txtUsuario);
		txtUsuario.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		GridBagConstraints gbc_lblSenha = new GridBagConstraints();
		gbc_lblSenha.anchor = GridBagConstraints.EAST;
		gbc_lblSenha.insets = new Insets(0, 0, 5, 5);
		gbc_lblSenha.gridx = 0;
		gbc_lblSenha.gridy = 2;
		panelLogin.add(lblSenha, gbc_lblSenha);

		pwdPassword = new JPasswordField();
		GridBagConstraints gbc_pwdPassword = new GridBagConstraints();
		gbc_pwdPassword.insets = new Insets(0, 0, 5, 0);
		gbc_pwdPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwdPassword.gridx = 1;
		gbc_pwdPassword.gridy = 2;
		panelLogin.add(pwdPassword, gbc_pwdPassword);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = txtUsuario.getText();
				String password = new String(pwdPassword.getPassword());
				try {
					LoginWindow.this.controller.login(username, password);
				} catch (Exception ex) {
					UIUtils.showError(rootPane, ex);
				}
			}
		});
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.insets = new Insets(10, 0, 0, 0);
		gbc_btnLogin.gridwidth = 2;
		gbc_btnLogin.gridx = 0;
		gbc_btnLogin.gridy = 3;
		panelLogin.add(btnLogin, gbc_btnLogin);

		lblWebServiceUrl = new JLabel("<sem web service>");
		lblWebServiceUrl.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblWebServiceUrl = new GridBagConstraints();
		gbc_lblWebServiceUrl.gridwidth = 3;
		gbc_lblWebServiceUrl.insets = new Insets(0, 0, 0, 5);
		gbc_lblWebServiceUrl.gridx = 0;
		gbc_lblWebServiceUrl.gridy = 1;
		panelCenter.add(lblWebServiceUrl, gbc_lblWebServiceUrl);

		JPanel panelNorth = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelNorth.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panelNorth, BorderLayout.NORTH);

		JButton btnConfigurl = new JButton("");
		btnConfigurl.setPreferredSize(new Dimension(35, 35));
		btnConfigurl.setIcon(new ImageIcon("res/geography-26.png"));
		btnConfigurl.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String newUrl = JOptionPane.showInputDialog(rootPane, "Alterar a URL de conexão com o Web Service do Central do Aluno:", "Alterar URL",
						JOptionPane.INFORMATION_MESSAGE);
				if (newUrl != null && !newUrl.trim().equals(LoginWindow.this.controller.getWebServiceUrl())) {
					try {
						LoginWindow.this.controller.setWebServiceUrl(newUrl.trim());
						lblWebServiceUrl.setText(LoginWindow.this.controller.getWebServiceUrl());
					} catch (Exception ex) {
						UIUtils.showError(rootPane, ex);
					}
				}
			}
		});
		panelNorth.add(btnConfigurl);
		controller.setLoginWindow(this);
	}

}
