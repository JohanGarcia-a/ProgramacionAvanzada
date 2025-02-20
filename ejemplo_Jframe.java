package a2231330029_tareas_Unidad01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ejemplo_Jframe extends JFrame {

	static JLabel La, Lb, Lc;
	static JButton Bcalcular, Bsalir;
	static JTextField Ta, Th, Tb;

	public ejemplo_Jframe() {
		this.setLayout(null);
		this.setTitle("Joahan Garcia  ejemplo Jframe");
		this.setBounds(10, 10, 350, 300);
		La = new JLabel("Introduce el valor de la altura");
		La.setBounds(10, 10, 350, 30);
		Lb = new JLabel("Introduce el valor de la base");
		Lb.setBounds(10, 40, 200, 30);
		Lc = new JLabel("El area es igual a -->");
		Lc.setBounds(10, 110, 200, 30);
		Th = new JTextField("");
		Th.setBounds(220, 10, 100, 30);
		Tb = new JTextField("");
		Tb.setBounds(220, 40, 100, 30);
		Ta = new JTextField("");
		Ta.setBounds(220, 110, 100, 30);
		Ta.setEditable(false);

		Bcalcular = new JButton();
		Bcalcular.setText("Calcular");
		Bcalcular.setBounds(10, 60, 100, 30);

		Bcalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				double h, b, a;
				String Sh, Sb;
				Sh = Th.getText();
				Sb = Tb.getText();

				if (!Sh.isEmpty() && !Sb.isEmpty()) {
					h = Double.parseDouble(Sh);
					b = Double.parseDouble(Sb);
					a = (h * b) / 2;

					Ta.setText(String.valueOf(a));
				} else
					JOptionPane.showMessageDialog(null, "lo siento uno o dos textos estan vacios");
			}
		});
		

		Bsalir = new JButton();
		Bsalir.setText("salir");
		Bsalir.setBounds(120, 60, 100, 30);

		Bsalir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}

		});

		this.add(La);
		this.add(Lb);
		this.add(Lc);

		this.add(Bcalcular);
		this.add(Bsalir);
		this.add(Th);
		this.add(Tb);
		this.add(Ta);

	}

	public static void main(String[] args) {
		ejemplo_Jframe ventana = new ejemplo_Jframe();
		ventana.setVisible(true);
	}

}
