package a2231330029_tareas_Unidad01;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

public class Ejemplo01_c extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel PanelPrincipal;
	private JTextField T1, T2;
	private JButton Bsalir, Bagregar;
	private JTextArea Tr;
	private JFrame ventana;

	public Ejemplo01_c() {
		inicializar();
	}

	public void inicializar() {
		ventana = new JFrame();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setBounds(100, 100, 450, 300);
		PanelPrincipal = new JPanel();
		PanelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		ventana.setContentPane(PanelPrincipal);
		PanelPrincipal.setLayout(null);

		JLabel lblnewlabel = new JLabel("Nombre Prfesor");
		lblnewlabel.setBounds(26, 43, 111, 14);
		PanelPrincipal.add(lblnewlabel);

		T1 = new JTextField();
		T1.setBounds(161, 40, 96, 20);
		PanelPrincipal.add(T1);
		T1.setColumns(10);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(26, 80, 111, 14);
		PanelPrincipal.add(lblApellido);

		T2 = new JTextField();
		T2.setBounds(161, 77, 96, 20);
		T2.setColumns(10);
		PanelPrincipal.add(T2);

		Bagregar = new JButton("Agregar");
		Bagregar.setBounds(302, 39, 89, 23);
		PanelPrincipal.add(Bagregar);

		Bsalir = new JButton("Salir");
		Bsalir.setBounds(302, 76, 89, 23);
		PanelPrincipal.add(Bsalir);
		T2 = new JTextField();
		T2.setBounds(161, 77, 96, 20);
		T2.setColumns(10);
		PanelPrincipal.add(T2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(26, 123, 391, 131);
		PanelPrincipal.add(scrollPane);

		Tr = new JTextArea();
		scrollPane.setViewportView(Tr);

	}

	public void crearBotonones(String[] nbotones) {
		if (nbotones.length == 2) {

			Bagregar = new JButton(nbotones[0]);
			Bagregar.setBounds(302, 39, 89, 23);
			this.PanelPrincipal.add(Bagregar);

			Bsalir = new JButton(nbotones[1]);
			Bsalir.setBounds(302, 76, 89, 23);
			this.PanelPrincipal.add(Bsalir);

		}
	}

	public String getT1() {
		return this.T1.getText();
	}

	public String getT2() {
		return this.T2.getText();

	}

	public void setT1(String texto) {
		this.T1.setText(texto);
	}

	public void setT2(String texto) {
		this.T2.setText(texto);
	}

	public void setTr(String texto) {
		this.Tr.setText(texto);
	}

	public JButton bsalir() {
		return this.Bsalir;
	}

	public JButton bagregar() {
		return this.Bagregar;
	}

	public void limpiarText() {
		this.T1.setText("");
		this.T2.setText("");
	}

	public static void main(String[] args) {

	}

}
