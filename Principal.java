package Tarea013;

import java.io.IOException;
import java.util.List;

public class Principal {

	private Inventario inventario;
	private PersistenciaDatos<Producto> persistenciaProductos;
	private PersistenciaDatos<Venta> persistenciaVentas;
	private VentaManager ventaManager;

	public Principal() {
		inventario = new Inventario();
		persistenciaProductos = new PersistenciaDatos<>();
		persistenciaVentas = new PersistenciaDatos<>();
		ventaManager = new VentaManager(inventario);
	}

	public void mostrarMenu() throws IOException {
		String opcion;
		do {
			limpiarPantalla();
			System.out.println("=== Menú Principal ===");
			System.out.println("1. Agregar Producto");
			System.out.println("2. Eliminar Producto");
			System.out.println("3. Buscar Producto");
			System.out.println("4. Listar Productos");
			System.out.println("5. Agregar Venta");
			System.out.println("6. Listar Ventas");
			System.out.println("7. Guardar Datos");
			System.out.println("8. Cargar Datos");
			System.out.println("9. Salir");
			opcion = Leer.leer("Seleccione una opción").trim();

			System.out.println("Opción seleccionada: '" + opcion + "'"); // Depuración

			switch (opcion) {
			case "1":
				agregarProducto();
				break;
			case "2":
				eliminarProducto();
				break;
			case "3":
				buscarProducto();
				break;
			case "4":
				listarProductos();
				break;
			case "5":
				agregarVenta();
				break;
			case "6":
				listarVentas();
				break;
			case "7":
				guardarDatos();
				break;
			case "8":
				cargarDatos();
				break;
			case "9":
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opción no válida. Intente de nuevo.");
				pausa();
			}
		} while (!opcion.equals("9"));
	}

	public static void main(String[] args) throws Exception {
		Principal principal = new Principal();
		principal.mostrarMenu();
	}

	public void agregarProducto() throws IOException {
		limpiarPantalla();
		System.out.println("=== Agregar Producto ===");
		String id = Leer.leer("Ingrese el ID del producto:");
		if (inventario.buscarProducto(id) != null) {
			System.out.println("Error: Ya existe un producto con ese ID.");
			pausa();
			return;
		}
		String nombre = Leer.leer("Ingrese el nombre del producto:");
		double precio = leerDouble("Ingrese el precio del producto:");
		int stock = leerEntero("Ingrese el stock inicial del producto:");

		Producto producto = new Producto(id, nombre, precio, stock);
		inventario.agregarProducto(producto);
		System.out.println("Producto agregado correctamente.");
		pausa();
	}

	public void eliminarProducto() throws IOException {
		limpiarPantalla();
		System.out.println("=== Eliminar Producto ===");
		String id = Leer.leer("Ingrese el ID del producto a eliminar:");
		if (inventario.eliminarProducto(id)) {
			System.out.println("Producto eliminado correctamente.");
		} else {
			System.out.println("Error: No se encontró un producto con ese ID.");
		}
		pausa();
	}

	public void buscarProducto() throws IOException {
		limpiarPantalla();
		System.out.println("=== Buscar Producto ===");
		String id = Leer.leer("Ingrese el ID del producto a buscar:");
		Producto producto = inventario.buscarProducto(id);
		if (producto != null) {
			System.out.println("Producto encontrado: " + producto);
		} else {
			System.out.println("Error: Producto no encontrado.");
		}
		pausa();
	}

	public void listarProductos() {
		limpiarPantalla();
		System.out.println("=== Lista de Productos ===");
		List<Producto> productos = inventario.listarProductos();
		if (productos.isEmpty()) {
			System.out.println("No hay productos registrados.");
		} else {
			for (Producto producto : productos) {
				System.out.println(producto);
			}
		}
		pausa();
	}

	public void agregarVenta() throws IOException {
		limpiarPantalla();
		System.out.println("=== Agregar Venta ===");
		String idProducto = Leer.leer("Ingrese el ID del producto a vender:");
		int cantidad = leerEntero("Ingrese la cantidad a vender:");

		Producto producto = inventario.buscarProducto(idProducto);
		if (producto != null) {
			if (producto.getStock() >= cantidad) {
				Venta venta = new Venta(producto.getId(), producto.getNombre(), producto.getPrecio(), cantidad);
				ventaManager.agregarVenta(venta);
				System.out.println("Venta registrada correctamente.");
				System.out.println("=== Ticket de Venta ===");
				System.out.println(ventaManager.generarTicket());
			} else {
				System.out.println("Error: No hay suficiente stock para realizar la venta.");
			}
		} else {
			System.out.println("Error: Producto no encontrado.");
		}
		pausa();
	}

	public void listarVentas() {
		limpiarPantalla();
		System.out.println("=== Lista de Ventas ===");
		List<Venta> ventas = ventaManager.listarVentas();
		if (ventas.isEmpty()) {
			System.out.println("No hay ventas registradas.");
		} else {
			for (Venta venta : ventas) {
				System.out.println(venta);
			}
		}
		pausa();
	}

	public void guardarDatos() {
		limpiarPantalla();
		System.out.println("=== Guardar Datos ===");
		try {
			persistenciaProductos.guardarCSV(inventario.listarProductos(), "productos.csv");
			persistenciaVentas.guardarCSV(ventaManager.listarVentas(), "ventas.csv");
			System.out.println("Datos guardados correctamente.");
		} catch (IOException e) {
			System.out.println("Error al guardar datos: " + e.getMessage());
		}
		pausa();
	}

	public void cargarDatos() {
		limpiarPantalla();
		System.out.println("=== Cargar Datos ===");
		try {
			List<Producto> productosCargados = persistenciaProductos.cargarCSV("productos.csv", Producto.class);
			inventario = new Inventario(); // Reinicia el inventario
			for (Producto producto : productosCargados) {
				inventario.agregarProducto(producto);
			}

			List<Venta> ventasCargadas = persistenciaVentas.cargarCSV("ventas.csv", Venta.class);
			ventaManager = new VentaManager(inventario); // Reinicia el gestor de ventas
			for (Venta venta : ventasCargadas) {
				ventaManager.agregarVenta(venta);
			}

			System.out.println("Datos cargados correctamente.");
		} catch (IOException e) {
			System.out.println("Error al cargar datos: " + e.getMessage());
		}
		pausa();
	}

	// Métodos auxiliares
	private void limpiarPantalla() {
		System.out.print("\033[H\033[2J"); // Código para limpiar la pantalla en consola
		System.out.flush();
	}

	private void pausa() {
		System.out.println("\nPresione Enter para continuar...");
		try {
			System.in.read(); // Consume el salto de línea sobrante
			System.in.skip(System.in.available()); // Limpia el buffer de entrada
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private int leerEntero(String mensaje) throws IOException {
		while (true) {
			try {
				return Integer.parseInt(Leer.leer(mensaje));
			} catch (NumberFormatException e) {
				System.out.println("Error: Ingrese un número entero válido.");
			}
		}
	}

	private double leerDouble(String mensaje) throws IOException {
		while (true) {
			try {
				return Double.parseDouble(Leer.leer(mensaje));
			} catch (NumberFormatException e) {
				System.out.println("Error: Ingrese un número válido.");
			}
		}
	}
}