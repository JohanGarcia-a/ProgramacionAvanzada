package Tarea11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.text.*;

public class FlashCardMath extends JFrame {
	JLabel etiquetaIntentos = new JLabel();
	JTextField campoIntentos = new JTextField();
	JLabel etiquetaCorrectos = new JLabel();
	JTextField campoCorrectos = new JTextField();
	JLabel etiquetaProblema = new JLabel();
	JLabel etiquetaDivisor = new JLabel();
	JPanel panelTipo = new JPanel();
	JCheckBox[] casillasTipo = new JCheckBox[4];
	JPanel panelFactor = new JPanel();
	ButtonGroup grupoFactor = new ButtonGroup();
	JRadioButton[] botonesFactor = new JRadioButton[11];
	JPanel panelTemporizador = new JPanel();
	ButtonGroup grupoTemporizador = new ButtonGroup();
	JRadioButton[] botonesTemporizador = new JRadioButton[3];
	JTextField campoTemporizador = new JTextField();
	JScrollBar barraTemporizador = new JScrollBar();
	JButton botonIniciar = new JButton();
	JButton botonSalir = new JButton();
	Timer temporizadorProblemas;

	Font miFuente = new Font("Arial", Font.PLAIN, 18);
	Color azulClaro = new Color(192, 192, 255);
	Random aleatorio = new Random();
	int intentos, correctos;
	int respuestaCorrecta, digitosRespuesta;
	String problema;
	String tuRespuesta;
	int digitoActual;
	int tiempoProblema;

	public static void main(String args[]) {

		new FlashCardMath().show();
	}

	public FlashCardMath() {

		setTitle("Flash Card Math");
		getContentPane().setBackground(new Color(255, 255, 192));
		setResizable(false);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				salir(evt);
			}
		});

		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints restricciones;

		etiquetaIntentos.setText("Intentos:");
		etiquetaIntentos.setFont(miFuente);
		restricciones = new GridBagConstraints();
		restricciones.gridx = 0;
		restricciones.gridy = 0;
		restricciones.anchor = GridBagConstraints.WEST;
		restricciones.insets = new Insets(10, 10, 0, 10);
		getContentPane().add(etiquetaIntentos, restricciones);

		campoIntentos.setText("0");
		campoIntentos.setPreferredSize(new Dimension(90, 30));
		campoIntentos.setEditable(false);
		campoIntentos.setBackground(Color.RED);
		campoIntentos.setForeground(Color.YELLOW);
		campoIntentos.setHorizontalAlignment(SwingConstants.CENTER);
		campoIntentos.setFont(miFuente);
		restricciones = new GridBagConstraints();
		restricciones.gridx = 1;
		restricciones.gridy = 0;
		restricciones.insets = new Insets(10, 0, 0, 0);
		getContentPane().add(campoIntentos, restricciones);

		etiquetaCorrectos.setText("Correctos:");
		etiquetaCorrectos.setFont(miFuente);
		restricciones = new GridBagConstraints();
		restricciones.gridx = 2;
		restricciones.gridy = 0;
		restricciones.anchor = GridBagConstraints.EAST;
		restricciones.insets = new Insets(10, 10, 0, 10);
		getContentPane().add(etiquetaCorrectos, restricciones);

		campoCorrectos.setText("0");
		campoCorrectos.setPreferredSize(new Dimension(90, 30));
		campoCorrectos.setEditable(false);
		campoCorrectos.setBackground(Color.RED);
		campoCorrectos.setForeground(Color.YELLOW);
		campoCorrectos.setHorizontalAlignment(SwingConstants.CENTER);
		campoCorrectos.setFont(miFuente);
		restricciones = new GridBagConstraints();
		restricciones.gridx = 3;
		restricciones.gridy = 0;
		restricciones.insets = new Insets(10, 0, 0, 0);
		getContentPane().add(campoCorrectos, restricciones);

		etiquetaProblema.setText("");
		etiquetaProblema.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		etiquetaProblema.setPreferredSize(new Dimension(450, 100));
		etiquetaProblema.setBackground(Color.WHITE);
		etiquetaProblema.setOpaque(true);
		etiquetaProblema.setFont(new Font("Comic Sans MS", Font.PLAIN, 48));
		etiquetaProblema.setHorizontalAlignment(SwingConstants.CENTER);
		restricciones = new GridBagConstraints();
		restricciones.gridx = 0;
		restricciones.gridy = 1;
		restricciones.gridwidth = 5;
		restricciones.insets = new Insets(10, 10, 0, 10);
		getContentPane().add(etiquetaProblema, restricciones);
		etiquetaProblema.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				teclaPresionada(e);
			}
		});

		etiquetaDivisor.setPreferredSize(new Dimension(450, 10));
		etiquetaDivisor.setBackground(Color.RED);
		etiquetaDivisor.setOpaque(true);
		restricciones = new GridBagConstraints();
		restricciones.gridx = 0;
		restricciones.gridy = 2;
		restricciones.gridwidth = 5;
		restricciones.insets = new Insets(10, 10, 10, 10);
		getContentPane().add(etiquetaDivisor, restricciones);

		UIManager.put("TitledBorder.font", new Font("Arial", Font.BOLD, 14));
		panelTipo.setPreferredSize(new Dimension(130, 130));
		panelTipo.setBorder(BorderFactory.createTitledBorder("Tipo:"));
		panelTipo.setBackground(azulClaro);
		panelTipo.setLayout(new GridBagLayout());
		restricciones.gridx = 0;
		restricciones.gridy = 3;
		restricciones.gridwidth = 2;
		restricciones.anchor = GridBagConstraints.NORTH;
		getContentPane().add(panelTipo, restricciones);

		for (int i = 0; i < 4; i++) {
			casillasTipo[i] = new JCheckBox();
			casillasTipo[i].setBackground(azulClaro);
			restricciones = new GridBagConstraints();
			restricciones.gridx = 0;
			restricciones.gridy = i;
			restricciones.anchor = GridBagConstraints.WEST;
			panelTipo.add(casillasTipo[i], restricciones);
			casillasTipo[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					accionCasillaTipo(e);
				}
			});
		}

		casillasTipo[0].setText("Suma");
		casillasTipo[1].setText("Resta");
		casillasTipo[2].setText("Multiplicación");
		casillasTipo[3].setText("División");
		casillasTipo[0].setSelected(true);

		panelFactor.setPreferredSize(new Dimension(130, 130));
		panelFactor.setBorder(BorderFactory.createTitledBorder("Factor:"));
		panelFactor.setBackground(azulClaro);
		panelFactor.setLayout(new GridBagLayout());
		restricciones = new GridBagConstraints();
		restricciones.gridx = 2;
		restricciones.gridy = 3;
		restricciones.gridwidth = 2;
		restricciones.anchor = GridBagConstraints.NORTH;
		getContentPane().add(panelFactor, restricciones);

		int x = 2;
		int y = 0;
		for (int i = 0; i < 11; i++) {
			botonesFactor[i] = new JRadioButton();
			botonesFactor[i].setText(String.valueOf(i));
			botonesFactor[i].setBackground(azulClaro);
			grupoFactor.add(botonesFactor[i]);
			restricciones = new GridBagConstraints();
			if (i < 10) {
				restricciones.gridx = x;
				restricciones.gridy = y;
			} else {
				restricciones.gridx = 0;
				restricciones.gridy = 0;
				restricciones.gridwidth = 2;
			}
			restricciones.anchor = GridBagConstraints.WEST;
			panelFactor.add(botonesFactor[i], restricciones);
			botonesFactor[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					accionBotonFactor(e);
				}
			});
			x++;
			if (x > 2) {
				x = 0;
				y++;
			}
		}

		botonesFactor[10].setText("Aleatorio");
		botonesFactor[10].setSelected(true);

		panelTemporizador.setPreferredSize(new Dimension(130, 130));
		panelTemporizador.setBorder(BorderFactory.createTitledBorder("Temporizador:"));
		panelTemporizador.setBackground(azulClaro);
		panelTemporizador.setLayout(new GridBagLayout());
		restricciones = new GridBagConstraints();
		restricciones.gridx = 4;
		restricciones.gridy = 3;
		restricciones.insets = new Insets(0, 0, 0, 10);
		restricciones.anchor = GridBagConstraints.NORTH;
		getContentPane().add(panelTemporizador, restricciones);

		for (int i = 0; i < 3; i++) {
			botonesTemporizador[i] = new JRadioButton();
			botonesTemporizador[i].setBackground(azulClaro);
			grupoTemporizador.add(botonesTemporizador[i]);
			restricciones = new GridBagConstraints();
			restricciones.gridx = 0;
			restricciones.gridy = i;
			restricciones.gridwidth = 2;
			restricciones.anchor = GridBagConstraints.WEST;
			panelTemporizador.add(botonesTemporizador[i], restricciones);
			botonesTemporizador[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					accionBotonTemporizador(e);
				}
			});
		}

		botonesTemporizador[0].setText("Apagado");
		botonesTemporizador[1].setText("Contar Arriba");
		botonesTemporizador[2].setText("Contar Abajo");
		botonesTemporizador[0].setSelected(true);

		campoTemporizador.setText("Apagado");
		campoTemporizador.setPreferredSize(new Dimension(90, 25));
		campoTemporizador.setEditable(false);
		campoTemporizador.setBackground(Color.WHITE);
		campoTemporizador.setForeground(Color.RED);
		campoTemporizador.setHorizontalAlignment(SwingConstants.CENTER);
		campoTemporizador.setFont(miFuente);
		restricciones = new GridBagConstraints();
		restricciones.gridx = 0;
		restricciones.gridy = 3;
		restricciones.anchor = GridBagConstraints.WEST;
		restricciones.insets = new Insets(5, 0, 0, 0);
		panelTemporizador.add(campoTemporizador, restricciones);

		barraTemporizador.setPreferredSize(new Dimension(20, 25));
		barraTemporizador.setMinimum(1);
		barraTemporizador.setMaximum(60);
		barraTemporizador.setValue(1);
		barraTemporizador.setBlockIncrement(1);
		barraTemporizador.setUnitIncrement(1);
		barraTemporizador.setOrientation(JScrollBar.VERTICAL);
		barraTemporizador.setEnabled(false);
		restricciones = new GridBagConstraints();
		restricciones.gridx = 1;
		restricciones.gridy = 3;
		restricciones.anchor = GridBagConstraints.WEST;
		restricciones.insets = new Insets(5, 0, 0, 0);
		panelTemporizador.add(barraTemporizador, restricciones);
		barraTemporizador.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent e) {
				cambioValorBarra(e);
			}
		});

		botonIniciar.setText("Iniciar Práctica");
		restricciones = new GridBagConstraints();
		restricciones.gridx = 0;
		restricciones.gridy = 4;
		restricciones.gridwidth = 2;
		restricciones.insets = new Insets(10, 0, 10, 0);
		getContentPane().add(botonIniciar, restricciones);
		botonIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBotonIniciar(e);
			}
		});

		botonSalir.setText("Salir");
		restricciones = new GridBagConstraints();
		restricciones.gridx = 2;
		restricciones.gridy = 4;
		restricciones.gridwidth = 2;
		restricciones.insets = new Insets(10, 0, 10, 0);
		getContentPane().add(botonSalir, restricciones);
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBotonSalir(e);
			}
		});

		temporizadorProblemas = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionTemporizador(e);
			}
		});

		pack();
		Dimension tamanoPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int) (0.5 * (tamanoPantalla.width - getWidth())),
				(int) (0.5 * (tamanoPantalla.height - getHeight())), getWidth(), getHeight());
	}

	private void salir(WindowEvent evt) {
		System.exit(0);
	}

	private void accionCasillaTipo(ActionEvent e) {
		int casillasMarcadas;
		int casillaClicada = 0;

		String s = e.getActionCommand();
		if (s.equals("Suma"))
			casillaClicada = 0;
		else if (s.equals("Resta"))
			casillaClicada = 1;
		else if (s.equals("Multiplicación"))
			casillaClicada = 2;
		else if (s.equals("División"))
			casillaClicada = 3;

		casillasMarcadas = 0;
		if (casillasTipo[0].isSelected())
			casillasMarcadas++;
		if (casillasTipo[1].isSelected())
			casillasMarcadas++;
		if (casillasTipo[2].isSelected())
			casillasMarcadas++;
		if (casillasTipo[3].isSelected()) {
			casillasMarcadas++;
			if (botonesFactor[0].isSelected())
				botonesFactor[1].doClick();
			botonesFactor[0].setEnabled(false);
		} else {
			botonesFactor[0].setEnabled(true);
		}

		if (casillasMarcadas == 0)
			casillasTipo[casillaClicada].setSelected(true);
		etiquetaProblema.requestFocus();
	}

	private void accionBotonFactor(ActionEvent e) {
		etiquetaProblema.requestFocus();
	}

	private void accionBotonTemporizador(ActionEvent e) {
		if (botonesTemporizador[0].isSelected()) {
			campoTemporizador.setText("Apagado");
			barraTemporizador.setEnabled(false);
		} else if (botonesTemporizador[1].isSelected()) {
			tiempoProblema = 0;
			campoTemporizador.setText(obtenerTiempo(tiempoProblema));
			barraTemporizador.setEnabled(false);
		} else if (botonesTemporizador[2].isSelected()) {
			tiempoProblema = 30 * barraTemporizador.getValue();
			campoTemporizador.setText(obtenerTiempo(tiempoProblema));
			barraTemporizador.setEnabled(true);
		}
	}

	private void cambioValorBarra(AdjustmentEvent e) {
		campoTemporizador.setText(obtenerTiempo(30 * barraTemporizador.getValue()));
	}

	private void accionBotonIniciar(ActionEvent e) {
		int puntuacion;
		String mensaje = "";
		if (botonIniciar.getText().equals("Iniciar Práctica")) {
			botonIniciar.setText("Detener Práctica");
			botonSalir.setEnabled(false);
			intentos = 0;
			correctos = 0;
			campoIntentos.setText("0");
			campoCorrectos.setText("0");
			botonesTemporizador[0].setEnabled(false);
			botonesTemporizador[1].setEnabled(false);
			botonesTemporizador[2].setEnabled(false);
			barraTemporizador.setEnabled(false);
			if (botonesTemporizador[0].isSelected()) {
				if (botonesTemporizador[1].isSelected())
					tiempoProblema = 0;
				else
					tiempoProblema = 30 * barraTemporizador.getValue();
				campoTemporizador.setText(obtenerTiempo(tiempoProblema));
				temporizadorProblemas.start();
			}
			etiquetaProblema.setText(generarProblema());
		} else {
			botonesTemporizador[0].setEnabled(true);
			botonesTemporizador[1].setEnabled(true);
			botonesTemporizador[2].setEnabled(true);
			if (botonesTemporizador[2].isSelected())
				barraTemporizador.setEnabled(true);
			temporizadorProblemas.stop();
			botonIniciar.setText("Iniciar Práctica");
			botonSalir.setEnabled(true);
			etiquetaProblema.setText("");
			if (intentos > 0) {
				puntuacion = (int) (100 * (double) (correctos) / intentos);
				mensaje = "Problemas Intentados: " + String.valueOf(intentos) + "\n";
				mensaje += "Problemas Correctos: " + String.valueOf(correctos) + " (" + String.valueOf(puntuacion)
						+ "%)" + "\n";
				if (botonesTemporizador[0].isSelected()) {
					mensaje += "Temporizador Apagado";
				} else {
					if (botonesTemporizador[2].isSelected()) {
						tiempoProblema = 30 * barraTemporizador.getValue() - tiempoProblema;
					}
					mensaje += "Tiempo Transcurrido: " + obtenerTiempo(tiempoProblema) + "\n";
					mensaje += "Tiempo por Problema: "
							+ new DecimalFormat("0.00").format((double) (tiempoProblema) / intentos) + " seg";
				}
				JOptionPane.showConfirmDialog(null, mensaje, "Resultados", JOptionPane.DEFAULT_OPTION,
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private void accionBotonSalir(ActionEvent e) {
		System.exit(0);
	}

	private void teclaPresionada(KeyEvent e) {
		if (botonIniciar.getText().equals("Iniciar Práctica"))
			return;
		if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
			tuRespuesta += e.getKeyChar();
			etiquetaProblema.setText(problema + tuRespuesta);
			if (digitoActual != digitosRespuesta) {
				digitoActual++;
				etiquetaProblema.setText(etiquetaProblema.getText() + "?");
				return;
			} else {
				intentos++;

				if (Integer.valueOf(tuRespuesta).intValue() == respuestaCorrecta) {
					correctos++;
				}
				campoIntentos.setText(String.valueOf(intentos));
				campoCorrectos.setText(String.valueOf(correctos));
				etiquetaProblema.setText(generarProblema());
			}
		}
	}

	private void accionTemporizador(ActionEvent e) {
		if (botonesTemporizador[1].isSelected()) {
			tiempoProblema++;
			campoTemporizador.setText(obtenerTiempo(tiempoProblema));
			if (tiempoProblema >= 1800) {
				botonIniciar.doClick();
				return;
			}
		} else {
			tiempoProblema--;
			campoTemporizador.setText(obtenerTiempo(tiempoProblema));
			if (tiempoProblema == 0) {
				botonIniciar.doClick();
				return;
			}
		}
	}

	private String generarProblema() {
		int tipoProblema, p, numero, factor;
		p = 0;
		do {
			tipoProblema = aleatorio.nextInt(4) + 1;
			if (tipoProblema == 1 && casillasTipo[0].isSelected()) {

				p = tipoProblema;
				numero = aleatorio.nextInt(10);
				factor = obtenerFactor(1);
				respuestaCorrecta = numero + factor;
				problema = String.valueOf(numero) + " + " + String.valueOf(factor) + " = ";
			} else if (tipoProblema == 2 && casillasTipo[1].isSelected()) {
				p = tipoProblema;
				factor = obtenerFactor(2);
				respuestaCorrecta = aleatorio.nextInt(10);
				numero = respuestaCorrecta + factor;
				problema = String.valueOf(numero) + " - " + String.valueOf(factor) + " = ";
			} else if (tipoProblema == 3 && casillasTipo[2].isSelected()) {
				p = tipoProblema;
				numero = aleatorio.nextInt(10);
				factor = obtenerFactor(3);
				respuestaCorrecta = numero * factor;
				problema = String.valueOf(numero) + " x " + String.valueOf(factor) + " = ";
			} else if (tipoProblema == 4 && casillasTipo[3].isSelected()) {
				p = tipoProblema;
				factor = obtenerFactor(4);
				respuestaCorrecta = aleatorio.nextInt(10);
				numero = respuestaCorrecta * factor;
				problema = String.valueOf(numero) + " / " + String.valueOf(factor) + " = ";
			}
		} while (p == 0);

		tuRespuesta = "";
		digitoActual = 1;
		etiquetaProblema.requestFocus();
		if (respuestaCorrecta < 10) {
			digitosRespuesta = 1;
			return (problema + "?");
		} else {
			digitosRespuesta = 2;
			return (problema + "??");
		}
	}

	private int obtenerFactor(int p) {
		if (botonesFactor[10].isSelected()) {
			if (p == 4)
				return (aleatorio.nextInt(9) + 1);
			else
				return (aleatorio.nextInt(10));
		} else {
			for (int i = 0; i < 10; i++) {
				if (botonesFactor[i].isSelected())
					return (i);
			}
			return (0);
		}
	}

	private String obtenerTiempo(int s) {
		int minutos, segundos;
		String ms, ss;
		minutos = (int) (s / 60);
		segundos = s - 60 * minutos;
		ms = String.valueOf(minutos);
		ss = String.valueOf(segundos);
		if (segundos < 10)
			ss = "0" + ss;
		return (ms + ":" + ss);
	}
}