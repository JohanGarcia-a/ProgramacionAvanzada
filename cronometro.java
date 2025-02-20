package a2231330029_tareas_Unidad01;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class cronometro extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel Panelprincipal;
	private JTextField Tinicio, Tdetener, Ttranscurrido;
	private JButton Biniciar, Bdetener, Bsalida;
	private double tiempoinicio, tiempodetener, tiempotranscurrido;

	/**
	 * Create the frame.
	 */
	public cronometro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 190);
		Panelprincipal = new JPanel();
		Panelprincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(Panelprincipal);
		GridBagLayout gbl_panelprincipal = new GridBagLayout();
		gbl_panelprincipal.columnWidths = new int[] { 118, 125, 118, 0 };
		gbl_panelprincipal.rowHeights = new int[] { 37, 37, 37, 0 };
		gbl_panelprincipal.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelprincipal.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		Panelprincipal.setLayout(gbl_panelprincipal);

		Biniciar = new JButton("Iniciar");
		GridBagConstraints gbc_Biniciar = new GridBagConstraints();
		gbc_Biniciar.insets = new Insets(0, 0, 5, 5);
		gbc_Biniciar.gridx = 0;
		gbc_Biniciar.gridy = 0;
		Panelprincipal.add(Biniciar, gbc_Biniciar);
		Biniciar.addActionListener(this);

		JLabel lblNewLabel = new JLabel("Iniciar");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		Panelprincipal.add(lblNewLabel, gbc_lblNewLabel);

		Tinicio = new JTextField();
		GridBagConstraints gbc_tinicio = new GridBagConstraints();
		gbc_tinicio.insets = new Insets(0, 0, 5, 0);
		gbc_tinicio.fill = GridBagConstraints.HORIZONTAL;
		gbc_tinicio.gridx = 2;
		gbc_tinicio.gridy = 0;
		Panelprincipal.add(Tinicio, gbc_tinicio);
		Tinicio.setColumns(10);

		Bdetener = new JButton("detener");
		GridBagConstraints gbc_Bdetener = new GridBagConstraints();
		gbc_Bdetener.insets = new Insets(0, 0, 5, 5);
		gbc_Bdetener.gridx = 0;
		gbc_Bdetener.gridy = 1;
		Panelprincipal.add(Bdetener, gbc_Bdetener);
		Bdetener.addActionListener(this);

		JLabel lblNewLabel_1 = new JLabel("Detenerse");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		Panelprincipal.add(lblNewLabel_1, gbc_lblNewLabel_1);

		Tdetener = new JTextField();
		GridBagConstraints gbc_tdetener = new GridBagConstraints();
		gbc_tdetener.insets = new Insets(0, 0, 5, 0);
		gbc_tdetener.fill = GridBagConstraints.HORIZONTAL;
		gbc_tdetener.gridx = 2;
		gbc_tdetener.gridy = 1;
		Panelprincipal.add(Tdetener, gbc_tdetener);
		Tdetener.setColumns(10);

		Bsalida = new JButton("Salida");
		GridBagConstraints gbc_Bsalida = new GridBagConstraints();
		gbc_Bsalida.insets = new Insets(0, 0, 0, 5);
		gbc_Bsalida.gridx = 0;
		gbc_Bsalida.gridy = 2;
		Panelprincipal.add(Bsalida, gbc_Bsalida);
		Bsalida.addActionListener(this);

		JLabel lblNewLabel_2 = new JLabel("Tiempo transcurrido");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 2;
		Panelprincipal.add(lblNewLabel_2, gbc_lblNewLabel_2);

		Ttranscurrido = new JTextField();
		GridBagConstraints gbc_ttranscurrido = new GridBagConstraints();
		gbc_ttranscurrido.fill = GridBagConstraints.HORIZONTAL;
		gbc_ttranscurrido.gridx = 2;
		gbc_ttranscurrido.gridy = 2;
		Panelprincipal.add(Ttranscurrido, gbc_ttranscurrido);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == Biniciar) {

			this.tiempoinicio = System.currentTimeMillis();
			this.Tinicio.setText(String.valueOf(this.tiempoinicio));
			this.Tdetener.setText("");
			this.Ttranscurrido.setText("");

		} else if (e.getSource() == Bdetener) {

			tiempodetener = System.currentTimeMillis();
			this.Tdetener.setText(String.valueOf(this.tiempodetener));
			this.tiempotranscurrido = (this.tiempodetener - this.tiempoinicio) / 1000;
			this.Ttranscurrido.setText(String.valueOf(this.tiempotranscurrido));

		} else if (e.getSource() == Bsalida) {
			this.dispose();

		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cronometro frame = new cronometro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
