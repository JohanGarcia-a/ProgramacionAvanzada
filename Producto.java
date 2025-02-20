package Tarea013;

public class Producto extends ItemVenta implements ImpuestoAplicable {
	private int stock;

	public Producto(String id, String nombre, double precio, int stock) {
		super(id, nombre, precio);
		this.stock = stock;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public double calcularIVA() {
		return precio * 0.16;
	}

	@Override
	public double calcularIEPS() {
		return precio * 0.08; // Ejemplo de IEPS
	}

	@Override
	public String toString() {
		return String.format("%s,%s,%.2f,%d", id, nombre, precio, stock);
	}

	public static Producto fromCSV(String linea) {
		String[] partes = linea.split(",");
		if (partes.length == 4) {
			String id = partes[0];
			String nombre = partes[1];
			double precio = Double.parseDouble(partes[2]);
			int stock = Integer.parseInt(partes[3]);
			return new Producto(id, nombre, precio, stock);
		}
		return null;
	}
}