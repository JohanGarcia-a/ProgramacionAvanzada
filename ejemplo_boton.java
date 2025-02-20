package a2231330029_tareas_Unidad01;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ejemplo_boton extends JFrame {

	static JLabel La, Lb;
	static JButton Bboton;

	public ejemplo_boton() {
		getContentPane().setLayout(null);
		this.setBounds(10, 10, 300, 300);
		La = new JLabel("El triengulo de base 5 y de altura 2");
		La.setBounds(10, 10, 200, 30);
		Lb = new JLabel();
		Lb.setBounds(10, 100, 200, 30);
		Bboton = new JButton("Calcular");
		Bboton.setBounds(10, 50, 100, 30);
		getContentPane().add(La);
		getContentPane().add(Lb);
		getContentPane().add(Bboton);
		
	}

	public static void main(String[] args) {
		ejemplo_boton ventana = new ejemplo_boton();
		ventana.setVisible(true);
		Lb.setText("el area del triangulo es 5");
	}
}
