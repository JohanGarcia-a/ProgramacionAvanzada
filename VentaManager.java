package Tarea013;

import java.util.ArrayList;
import java.util.List;

public class VentaManager {
	private List<Venta> ventas;
	private Inventario inventario;

	public VentaManager(Inventario inventario) {
		this.ventas = new ArrayList<>();
		this.inventario = inventario;
	}

	public void agregarVenta(Venta venta) {
		ventas.add(venta);
		inventario.reducirStock(venta.getId(), venta.getCantidad());
	}

	public List<Venta> listarVentas() {
		return new ArrayList<>(ventas);
	}

	public String generarTicket() {
		StringBuilder ticket = new StringBuilder();
		double subtotal = 0;
		for (Venta venta : ventas) {
			subtotal += venta.getTotal();
			ticket.append(venta.toString()).append("\n");
		}
		double iva = subtotal * 0.16;
		double total = subtotal + iva;
		ticket.append("Subtotal: $").append(String.format("%.2f", subtotal)).append("\n");
		ticket.append("IVA (16%): $").append(String.format("%.2f", iva)).append("\n");
		ticket.append("Total: $").append(String.format("%.2f", total)).append("\n");
		return ticket.toString();
	}

	public Ticket generarTicket(String id, String fecha) {
		return new Ticket(id, fecha, ventas);
	}
}
