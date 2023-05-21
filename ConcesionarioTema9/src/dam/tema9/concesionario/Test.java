package dam.tema9.concesionario;


import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		//se instancia un gestor de conexion de la libreria
		DatabaseConnection databaseConnection = new DatabaseConnection("jdbc:mysql://localhost/concesionario?" + 
				"user=cumpli&password=ubuntu");
		//se instancia un gestor de datos de la libreria
		DatabaseManager databaseManager = new DatabaseManager(databaseConnection);

		//se pone a prueba el metodo de la obtencion de datos de la tabla cliente
		//Prueba apartado 2-1
		ArrayList<Cliente> clientes = databaseManager.getClientes();
		clientes.stream().forEach(b->System.out.println(b));
		//
		//			//Prueba apartado 2-2
		//
		//
		//			//Prueba apartado 2-3
		//			ArrayList<Venta> ventas = databaseManager.getVentas(new ColumnOrder (1,"asc"));
		//			ventas.stream().forEach(b->System.out.println(b));
		//
		//			//Prueba apartado 2-4
		//			Venta in = new Venta(2,1, 2,new java.sql.Date(2019-01-03));
		//			databaseManager.updateVenta(in);
		//Prueba apartado 2-5
		//			Venta insert = new Venta(6,1, 2,new java.sql.Date(2019-01-03));
		//			databaseManager.addVenta(insert);
		//			
		//			//Prueba apartado 2-6
		//			databaseManager.deleteVenta(5);


	}

}
