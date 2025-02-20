package Tarea013;

import java.util.ArrayList;
import java.util.List;

public class Inventario {

	private List<Producto> productos;

	public Inventario() {
		productos = new ArrayList<>(); // Inicializa la lista de productos
	}

	public void agregarProducto(Producto producto) {
		productos.add(producto); // Agrega el producto a la lista
	}

	public List<Producto> listarProductos() {
		return productos; // Retorna la lista de productos
	}

	public Producto buscarProducto(String id) {
		for (Producto producto : productos) {
			if (producto.getId().equals(id)) {
				return producto; // Retorna el producto si lo encuentra
			}
		}
		return null; // Retorna null si no encuentra el producto
	}

	public boolean eliminarProducto(String id) {
		Producto producto = buscarProducto(id);
		if (producto != null) {
			productos.remove(producto); // Elimina el producto si existe
			return true;
		}
		return false;
	}

	public void agregarStock(String id, int cantidad) {
		Producto producto = buscarProducto(id);
		if (producto != null) {
			producto.setStock(producto.getStock() + cantidad);
		}
	}

	public void reducirStock(String id, int cantidad) {
		Producto producto = buscarProducto(id);
		if (producto != null && producto.getStock() >= cantidad) {
			producto.setStock(producto.getStock() - cantidad);
		}
	}
}