package Tarea013;

import java.util.List;

public class Ticket {
	private String id;
	private String fecha;
	private List<Venta> ventas;

	public Ticket(String id, String fecha, List<Venta> ventas) {
		this.id = id;
		this.fecha = fecha;
		this.ventas = ventas;
	}

	public double getSubtotal() {
		return ventas.stream().mapToDouble(Venta::getTotal).sum();
	}

	public double getIVA() {
		return getSubtotal() * 0.16;
	}

	public double getTotal() {
		return getSubtotal() + getIVA();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Ticket ID: ").append(id).append("\n");
		sb.append("Fecha: ").append(fecha).append("\n");
		for (Venta venta : ventas) {
			sb.append(venta.toString()).append("\n");
		}
		sb.append("Subtotal: $").append(String.format("%.2f", getSubtotal())).append("\n");
		sb.append("IVA: $").append(String.format("%.2f", getIVA())).append("\n");
		sb.append("Total: $").append(String.format("%.2f", getTotal())).append("\n");
		return sb.toString();
	}
}
