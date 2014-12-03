package br.furb.guniver.ui.portal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import br.furb.guniver.central_do_aluno.stubs.Aluno;
import br.furb.guniver.central_do_aluno.stubs.Curso;
import br.furb.guniver.central_do_aluno.stubs.Disciplina;
import br.furb.guniver.central_do_aluno.stubs.Horario;
import br.furb.guniver.central_do_aluno.stubs.Prova;
import br.furb.guniver.central_do_aluno.stubs.Turma;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	private static final String CODIGO_PATTERN = "(%d)";
	private static final String CURSO_PATTERN = "%s (%d)";
	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtUsuario;
	private JTextField txtNome;
	private JTable tableProvas;
	private JTable tableHorario;

	private PortalController portalController;
	private Aluno aluno;
	private List<Turma> turmas = new LinkedList<>();
	private Turma selectedTurma;
	private DefaultListModel<Integer> turmasListModel;
	private JLabel lblNomeDisciplina;
	private JLabel lblCodigoDisciplina;
	private JLabel lblDetalhesCurso;
	private DefaultTableModel provasModel;
	private List<Horario> horarios = new LinkedList<>();
	private List<Prova> provas = new LinkedList<>();
	private DefaultTableModel horariosModel;

	/**
	 * Create the frame.
	 * 
	 * @param portalController
	 */
	public MainWindow(PortalController portalController) {
		this.portalController = portalController;
		portalController.setMainWindow(this);
		setTitle("Portal Acadêmico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 150, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JPanel panelInfoAluno = new JPanel();
		panelInfoAluno.setBorder(UIManager.getBorder("TitledBorder.border"));
		GridBagConstraints gbc_panelInfoAluno = new GridBagConstraints();
		gbc_panelInfoAluno.anchor = GridBagConstraints.NORTH;
		gbc_panelInfoAluno.gridwidth = 2;
		gbc_panelInfoAluno.insets = new Insets(0, 0, 5, 5);
		gbc_panelInfoAluno.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelInfoAluno.gridx = 0;
		gbc_panelInfoAluno.gridy = 0;
		contentPane.add(panelInfoAluno, gbc_panelInfoAluno);
		GridBagLayout gbl_panelInfoAluno = new GridBagLayout();
		gbl_panelInfoAluno.columnWidths = new int[] { 0, 50, 0, 50, 0 };
		gbl_panelInfoAluno.rowHeights = new int[] { 0, 0, 0 };
		gbl_panelInfoAluno.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelInfoAluno.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panelInfoAluno.setLayout(gbl_panelInfoAluno);

		JLabel lblCdigo = new JLabel("Código:");
		GridBagConstraints gbc_lblCdigo = new GridBagConstraints();
		gbc_lblCdigo.anchor = GridBagConstraints.EAST;
		gbc_lblCdigo.insets = new Insets(5, 5, 5, 5);
		gbc_lblCdigo.gridx = 0;
		gbc_lblCdigo.gridy = 0;
		panelInfoAluno.add(lblCdigo, gbc_lblCdigo);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		GridBagConstraints gbc_txtCodigo = new GridBagConstraints();
		gbc_txtCodigo.insets = new Insets(5, 0, 5, 0);
		gbc_txtCodigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCodigo.gridx = 1;
		gbc_txtCodigo.gridy = 0;
		panelInfoAluno.add(txtCodigo, gbc_txtCodigo);
		txtCodigo.setColumns(10);

		JLabel lblUsuario = new JLabel("Usuário:");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.insets = new Insets(5, 10, 5, 5);
		gbc_lblUsuario.gridx = 2;
		gbc_lblUsuario.gridy = 0;
		panelInfoAluno.add(lblUsuario, gbc_lblUsuario);

		txtUsuario = new JTextField();
		txtUsuario.setEditable(false);
		GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
		gbc_txtUsuario.insets = new Insets(5, 0, 5, 5);
		gbc_txtUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsuario.gridx = 3;
		gbc_txtUsuario.gridy = 0;
		panelInfoAluno.add(txtUsuario, gbc_txtUsuario);
		txtUsuario.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 5, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 1;
		panelInfoAluno.add(lblNome, gbc_lblNome);

		txtNome = new JTextField();
		txtNome.setEditable(false);
		GridBagConstraints gbc_txtNome = new GridBagConstraints();
		gbc_txtNome.insets = new Insets(0, 0, 5, 5);
		gbc_txtNome.gridwidth = 3;
		gbc_txtNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNome.gridx = 1;
		gbc_txtNome.gridy = 1;
		panelInfoAluno.add(txtNome, gbc_txtNome);
		txtNome.setColumns(10);

		JPanel panelBotoes = new JPanel();
		GridBagConstraints gbc_panelBotoes = new GridBagConstraints();
		gbc_panelBotoes.insets = new Insets(0, 0, 5, 0);
		gbc_panelBotoes.fill = GridBagConstraints.BOTH;
		gbc_panelBotoes.gridx = 2;
		gbc_panelBotoes.gridy = 0;
		contentPane.add(panelBotoes, gbc_panelBotoes);
		GridBagLayout gbl_panelBotoes = new GridBagLayout();
		gbl_panelBotoes.columnWidths = new int[] { 97, 0 };
		gbl_panelBotoes.rowHeights = new int[] { 23, 0, 0, 0 };
		gbl_panelBotoes.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panelBotoes.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelBotoes.setLayout(gbl_panelBotoes);

		JButton btnMensalidades = new JButton("Mensalidades");
		GridBagConstraints gbc_btnMensalidades = new GridBagConstraints();
		gbc_btnMensalidades.insets = new Insets(0, 0, 5, 0);
		gbc_btnMensalidades.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMensalidades.anchor = GridBagConstraints.NORTH;
		gbc_btnMensalidades.gridx = 0;
		gbc_btnMensalidades.gridy = 0;
		panelBotoes.add(btnMensalidades, gbc_btnMensalidades);

		JButton btnHorrios = new JButton("Horários");
		GridBagConstraints gbc_btnHorrios = new GridBagConstraints();
		gbc_btnHorrios.insets = new Insets(0, 0, 5, 0);
		gbc_btnHorrios.anchor = GridBagConstraints.NORTH;
		gbc_btnHorrios.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnHorrios.gridx = 0;
		gbc_btnHorrios.gridy = 1;
		panelBotoes.add(btnHorrios, gbc_btnHorrios);

		JButton btnCompromissos = new JButton("Compromissos");
		GridBagConstraints gbc_btnCompromissos = new GridBagConstraints();
		gbc_btnCompromissos.anchor = GridBagConstraints.NORTH;
		gbc_btnCompromissos.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCompromissos.gridx = 0;
		gbc_btnCompromissos.gridy = 2;
		panelBotoes.add(btnCompromissos, gbc_btnCompromissos);

		JPanel panelTurmas = new JPanel();
		panelTurmas.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Turmas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panelTurmas = new GridBagConstraints();
		gbc_panelTurmas.gridheight = 2;
		gbc_panelTurmas.insets = new Insets(0, 0, 0, 5);
		gbc_panelTurmas.fill = GridBagConstraints.BOTH;
		gbc_panelTurmas.gridx = 0;
		gbc_panelTurmas.gridy = 1;
		contentPane.add(panelTurmas, gbc_panelTurmas);
		panelTurmas.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPaneListaTurmas = new JScrollPane();
		panelTurmas.add(scrollPaneListaTurmas);

		turmasListModel = new DefaultListModel<>();
		final JList<Integer> listTurmas = new JList<>(turmasListModel);
		DefaultListSelectionModel selectionModel = new DefaultListSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int index = listTurmas.getSelectedIndex();
					setSelectedTurma(index < 0 ? null : turmas.get(index));
				}
			}
		});
		listTurmas.setSelectionModel(selectionModel);
		listTurmas.setBackground(new Color(245, 245, 245));
		scrollPaneListaTurmas.setViewportView(listTurmas);

		JPanel panelTurmaInfoWrapper = new JPanel();
		panelTurmaInfoWrapper.setBorder(new TitledBorder(null, "Informa\u00E7\u00F5es da Turma", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelTurmaInfoWrapper = new GridBagConstraints();
		gbc_panelTurmaInfoWrapper.gridwidth = 2;
		gbc_panelTurmaInfoWrapper.gridheight = 2;
		gbc_panelTurmaInfoWrapper.insets = new Insets(0, 0, 0, 5);
		gbc_panelTurmaInfoWrapper.fill = GridBagConstraints.BOTH;
		gbc_panelTurmaInfoWrapper.gridx = 1;
		gbc_panelTurmaInfoWrapper.gridy = 1;
		contentPane.add(panelTurmaInfoWrapper, gbc_panelTurmaInfoWrapper);
		GridBagLayout gbl_panelTurmaInfoWrapper = new GridBagLayout();
		gbl_panelTurmaInfoWrapper.columnWidths = new int[] { 0, 0, 0 };
		gbl_panelTurmaInfoWrapper.rowHeights = new int[] { 0, 0, 0 };
		gbl_panelTurmaInfoWrapper.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_panelTurmaInfoWrapper.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panelTurmaInfoWrapper.setLayout(gbl_panelTurmaInfoWrapper);

		JPanel panelDetalheTurma = new JPanel();
		GridBagConstraints gbc_panelDetalheTurma = new GridBagConstraints();
		gbc_panelDetalheTurma.gridwidth = 2;
		gbc_panelDetalheTurma.fill = GridBagConstraints.BOTH;
		gbc_panelDetalheTurma.insets = new Insets(0, 0, 5, 0);
		gbc_panelDetalheTurma.gridx = 0;
		gbc_panelDetalheTurma.gridy = 0;
		panelTurmaInfoWrapper.add(panelDetalheTurma, gbc_panelDetalheTurma);
		GridBagLayout gbl_panelDetalheTurma = new GridBagLayout();
		gbl_panelDetalheTurma.columnWidths = new int[] { 0, 0 };
		gbl_panelDetalheTurma.rowHeights = new int[] { 0, 0, 0 };
		gbl_panelDetalheTurma.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panelDetalheTurma.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panelDetalheTurma.setLayout(gbl_panelDetalheTurma);

		JPanel panelTurmaDetailDisciplina = new JPanel();
		GridBagConstraints gbc_panelTurmaDetailDisciplina = new GridBagConstraints();
		gbc_panelTurmaDetailDisciplina.anchor = GridBagConstraints.NORTHWEST;
		gbc_panelTurmaDetailDisciplina.gridx = 0;
		gbc_panelTurmaDetailDisciplina.gridy = 0;
		panelDetalheTurma.add(panelTurmaDetailDisciplina, gbc_panelTurmaDetailDisciplina);
		panelTurmaDetailDisciplina.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 0));

		lblNomeDisciplina = new JLabel("Nome Disciplina");
		lblNomeDisciplina.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		panelTurmaDetailDisciplina.add(lblNomeDisciplina);

		lblCodigoDisciplina = new JLabel("(Codigo)");
		panelTurmaDetailDisciplina.add(lblCodigoDisciplina);

		lblDetalhesCurso = new JLabel("Nome Curso (Codigo)");
		GridBagConstraints gbc_lblDetalhesCurso = new GridBagConstraints();
		gbc_lblDetalhesCurso.insets = new Insets(0, 10, 0, 0);
		gbc_lblDetalhesCurso.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblDetalhesCurso.gridx = 0;
		gbc_lblDetalhesCurso.gridy = 1;
		panelDetalheTurma.add(lblDetalhesCurso, gbc_lblDetalhesCurso);

		JPanel panelProvas = new JPanel();
		panelProvas.setBorder(new TitledBorder(null, "Provas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelProvas = new GridBagConstraints();
		gbc_panelProvas.insets = new Insets(0, 0, 0, 5);
		gbc_panelProvas.fill = GridBagConstraints.BOTH;
		gbc_panelProvas.gridx = 0;
		gbc_panelProvas.gridy = 1;
		panelTurmaInfoWrapper.add(panelProvas, gbc_panelProvas);
		panelProvas.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPaneProvas = new JScrollPane();
		panelProvas.add(scrollPaneProvas);

		tableProvas = new JTable();
		provasModel = new DefaultTableModel(new Object[][] {}, new String[] { "Descri\u00E7\u00E3o", "Nota" }) {

			Class[] columnTypes = new Class[] { String.class, Double.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableProvas.setModel(provasModel);
		tableProvas.setColumnSelectionAllowed(true);
		tableProvas.setCellSelectionEnabled(true);
		tableProvas.setFillsViewportHeight(true);
		scrollPaneProvas.setViewportView(tableProvas);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Hor\u00E1rio", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		panelTurmaInfoWrapper.add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPaneHorario = new JScrollPane();
		panel.add(scrollPaneHorario, BorderLayout.CENTER);

		tableHorario = new JTable();
		horariosModel = new DefaultTableModel(new Object[][] {}, new String[] { "Hor\u00E1rio", "Sala" }) {

			Class[] columnTypes = new Class[] { String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		tableHorario.setModel(horariosModel);
		tableHorario.setColumnSelectionAllowed(true);
		tableHorario.setCellSelectionEnabled(true);
		tableHorario.setShowVerticalLines(false);
		tableHorario.setFillsViewportHeight(true);
		scrollPaneHorario.setViewportView(tableHorario);
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
		txtCodigo.setText(String.valueOf(aluno.getCodigo()));
		txtUsuario.setText(aluno.getNomeUsuario());
		txtNome.setText(aluno.getNome());
	}

	public void setTurmas(Collection<Turma> turmas) {
		this.turmas.clear();
		this.turmas.addAll(turmas);

		turmasListModel.clear();
		for (Turma turma : turmas) {
			turmasListModel.addElement(turma.getCodigo());
		}
	}

	public void updateTurma(Turma downloadedEntity) {
		setTurmas(new ArrayList<>(turmas));
	}

	private void setSelectedTurma(Turma turma) {
		if (this.selectedTurma == turma) {
			return;
		}
		this.selectedTurma = turma;
		boolean turmaIsNotNull = turma != null;
		lblCodigoDisciplina.setVisible(turmaIsNotNull);
		lblDetalhesCurso.setVisible(turmaIsNotNull);
		lblNomeDisciplina.setVisible(turmaIsNotNull);
		if (turmaIsNotNull) {
			Disciplina disciplina = turma.getDisciplina();
			lblCodigoDisciplina.setText(String.format(CODIGO_PATTERN, disciplina.getCodigo()));
			lblNomeDisciplina.setText(disciplina.getNome());
			Curso curso = disciplina.getCurso();
			lblDetalhesCurso.setText(String.format(CURSO_PATTERN, curso.getDescricao(), curso.getCodigo()));

			portalController.downloadProvas(turma, aluno);
			portalController.downloadHorario(turma);
		} else {
			setProvas(null);
			setHorarios(null);
		}
	}

	public void setHorarios(Collection<Horario> horarios) {
		this.horarios.clear();
		Vector<Vector<Object>> dataVector = horariosModel.getDataVector();
		dataVector.clear();
		if (horarios != null) {
			this.horarios.addAll(horarios);

			for (Horario horario : horarios) {
				Vector<Object> row = new Vector<>();
				row.add(horario.getHorario());
				row.add(horario.getSala());
				dataVector.add(row);
			}
		}

		horariosModel.fireTableDataChanged();
	}

	public void setProvas(Collection<Prova> provas) {
		this.provas.clear();
		Vector<Vector<Object>> dataVector = provasModel.getDataVector();
		dataVector.clear();
		if (provas != null) {
			this.provas.addAll(provas);

			for (Prova prova : provas) {
				Vector<Object> row = new Vector<>();
				row.add(prova.getDescricao());
				row.add(prova.getNota());
				dataVector.add(row);
			}
		}

		provasModel.fireTableDataChanged();
	}

}
