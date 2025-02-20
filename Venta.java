package Tarea013;

public class Venta extends ItemVenta {
	private int cantidad;

	public Venta(String id, String nombre, double precio, int cantidad) {
		super(id, nombre, precio);
		this.cantidad = cantidad;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getTotal() {
		return precio * cantidad;
	}

	@Override
	public String toString() {
		return String.format("%s,%s,%.2f,%d", id, nombre, precio, cantidad);
	}

	public static Venta fromCSV(String linea) {
		String[] partes = linea.split(",");
		if (partes.length == 4) {
			String id = partes[0];
			String nombre = partes[1];
			double precio = Double.parseDouble(partes[2]);
			int cantidad = Integer.parseInt(partes[3]);
			return new Venta(id, nombre, precio, cantidad);
		}
		return null;
	}
}