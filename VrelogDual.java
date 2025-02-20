package a2231330029_tareas_Unidad01;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class VrelogDual extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField runningTimeText;
	private JTextField totaltimetext;
	private JButton startStopButton, resetButton, exitButton;

	public VrelogDual() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();

		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel runningTimeLebel = new JLabel("runningTime");
		GridBagConstraints gbc_runningTimeLebel = new GridBagConstraints();
		gbc_runningTimeLebel.insets = new Insets(0, 0, 5, 5);
		gbc_runningTimeLebel.gridx = 1;
		gbc_runningTimeLebel.gridy = 0;
		contentPane.add(runningTimeLebel, gbc_runningTimeLebel);

		runningTimeText = new JTextField();
		runningTimeText.setBackground(new Color(255, 255, 255));
		runningTimeText.setEditable(false);
		runningTimeText.setPreferredSize(new Dimension(150, 50));
		GridBagConstraints gbc_runningTimeText = new GridBagConstraints();
		gbc_runningTimeText.gridwidth = 2;
		gbc_runningTimeText.insets = new Insets(0, 0, 5, 5);
		gbc_runningTimeText.fill = GridBagConstraints.HORIZONTAL;
		gbc_runningTimeText.gridx = 1;
		gbc_runningTimeText.gridy = 1;
		contentPane.add(runningTimeText, gbc_runningTimeText);
		runningTimeText.setColumns(10);

		JLabel totoltimelabel = new JLabel("TotalTime");
		GridBagConstraints gbc_totoltimelabel = new GridBagConstraints();
		gbc_totoltimelabel.insets = new Insets(0, 0, 5, 5);
		gbc_totoltimelabel.gridx = 1;
		gbc_totoltimelabel.gridy = 2;
		contentPane.add(totoltimelabel, gbc_totoltimelabel);

		totaltimetext = new JTextField();
		totaltimetext.setBackground(new Color(255, 255, 255));
		totaltimetext.setEditable(false);
		totaltimetext.setPreferredSize(new Dimension(150, 50));
		GridBagConstraints gbc_totaltimetext = new GridBagConstraints();
		gbc_totaltimetext.gridwidth = 2;
		gbc_totaltimetext.insets = new Insets(0, 0, 5, 5);
		gbc_totaltimetext.fill = GridBagConstraints.HORIZONTAL;
		gbc_totaltimetext.gridx = 1;
		gbc_totaltimetext.gridy = 3;
		contentPane.add(totaltimetext, gbc_totaltimetext);
		totaltimetext.setColumns(10);

		startStopButton = new JButton("iniciar");
		GridBagConstraints gbc_startStopButton = new GridBagConstraints();
		gbc_startStopButton.insets = new Insets(0, 0, 5, 5);
		gbc_startStopButton.gridx = 1;
		gbc_startStopButton.gridy = 4;
		contentPane.add(startStopButton, gbc_startStopButton);

		resetButton = new JButton("reiniciar");
		GridBagConstraints gbc_resetButton = new GridBagConstraints();
		gbc_resetButton.insets = new Insets(0, 0, 5, 5);
		gbc_resetButton.gridx = 2;
		gbc_resetButton.gridy = 4;
		contentPane.add(resetButton, gbc_resetButton);

		exitButton = new JButton("salir");
		GridBagConstraints gbc_exitButton = new GridBagConstraints();
		gbc_exitButton.insets = new Insets(0, 0, 0, 5);
		gbc_exitButton.gridx = 2;
		gbc_exitButton.gridy = 5;
		contentPane.add(exitButton, gbc_exitButton);
	}

	public void setrunningTimeText(String info) {
		this.totaltimetext.setText(info);
	}

	public void settotaltimetext(String info) {
		this.totaltimetext.setText(info);
	}

	public String getrunningTimeText() {
		return this.totaltimetext.getText();
	}

	public String gettotaltimetext() {
		return this.totaltimetext.getText();
	}

	public JButton getbotonInicio() {
		return this.startStopButton;
	}

	public JButton getbotonreset() {
		return this.resetButton;
	}

	public JButton getbotonsalir() {

		return this.exitButton;
	}

	public void setbotoninicio(JButton boton) {
		this.startStopButton = boton;

	}

	public void setbotonreset(JButton boton) {
		this.resetButton = boton;

	}

	public void setbotonsalir(JButton boton) {
		this.exitButton = boton;

	}

	public void setbotonreset(Boolean estado) {
		this.resetButton.setEnabled(estado);

	}

	public void setbotonreset(String texto) {
		this.resetButton.setText(texto);

	}

	public void setbotonsalida(Boolean estado) {
		this.exitButton.setEnabled(estado);

	}

	public void setbotonsalida(String texto) {
		this.exitButton.setText(texto);

	}
	public void setbotoninicio(Boolean estado) {
		this.startStopButton.setEnabled(estado);

	}

	public void setbotoninicio(String texto) {
		this.startStopButton.setText(texto);

	}

	public String getbotoniniciotexto() {
		return this.startStopButton.getText();
	}
}
