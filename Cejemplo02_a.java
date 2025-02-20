package a2231330029_tareas_Unidad01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Cejemplo02_a {
	static Ejemplo02_a ejemplo02;
	// static Lista lista
	static String[] nombotones = { "Agregar", "Salir" };
	static JButton[] botones;

	public static void main(String[] args) {
		// lista=new Lista();

		ejemplo02 = new Ejemplo02_a(nombotones);
		ejemplo02.setVisible(true);
		botones = ejemplo02.botones();
		
		botones[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ejemplo02.dispose();
			}

		});// fin ejemplo01.salir
		botones[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Cpersona nodo = new Cpersona(ejemplo02.getT1(), ejemplo02.getT2());
				// lista.insertar(nodo);
				ejemplo02.limpiarText();
				ejemplo02.setTr(null);

			}

		});
	}
}
