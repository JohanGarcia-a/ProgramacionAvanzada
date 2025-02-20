package a2231330029_tareas_Unidad01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Crelogdual {

	VrelogDual vista;

	public Crelogdual() {
		vista = new VrelogDual();
		vista.setVisible(true);

		vista.getbotonInicio().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (vista.getbotoniniciotexto().compareTo("Iniciar") == 0) {
					vista.setbotonreset(false);
					vista.setbotoninicio("Detener");
					vista.setbotonsalida(false);
				} else {
					vista.setbotonreset(true);
					vista.setbotoninicio("Iniciar");
					vista.setbotonsalida(true);
				}

			}

		});
		vista.getbotonreset().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}

		});
		vista.getbotonsalir().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vista.dispose();
			}

		});

	}
}
