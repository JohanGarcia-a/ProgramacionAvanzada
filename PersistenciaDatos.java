package Tarea013;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaDatos<T> {

	public void guardarCSV(List<T> items, String archivo) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
			for (T item : items) {
				writer.write(item.toString());
				writer.newLine();
			}
		}
	}

	public List<T> cargarCSV(String archivo, Class<T> tipo) throws IOException {
		List<T> items = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
			String linea;
			while ((linea = reader.readLine()) != null) {
				T item = convertirDesdeCSV(linea, tipo);
				if (item != null) {
					items.add(item);
				}
			}
		}
		return items;
	}

	private T convertirDesdeCSV(String linea, Class<T> tipo) {
		if (tipo.equals(Producto.class)) {
		} else if (tipo.equals(Venta.class)) {
			return (T) Venta.fromCSV(linea);
		}
		return null;
	}

}