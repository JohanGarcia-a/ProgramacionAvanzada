package Tarea013;

public abstract class ItemVenta {
	protected String id;
	protected String nombre;
	protected double precio;

	public ItemVenta(String id, String nombre, double precio) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}

	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return String.format("%s - %s - $%.2f", id, nombre, precio);
	}

	
}
