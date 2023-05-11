package dam.tema9.concesionario;


import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		DatabaseConnection databaseConnection = new DatabaseConnection();

		if(databaseConnection.connect("jdbc:mysql://localhost/concesionario?" + 
				"user=cumpli&password=ubuntu")){

			DatabaseManager databaseManager = new DatabaseManager(databaseConnection.getConnection());

			System.out.println(databaseConnection.isConnected());

			//Prueba apartado 2-1
			ArrayList<Cliente> clientes = databaseManager.getClientes();
			clientes.stream().forEach(b->System.out.println(b));

			//Prueba apartado 2-2


			//Prueba apartado 2-3
			ArrayList<Venta> ventas = databaseManager.getVentas(new ColumnOrder (1,"asc"));
			ventas.stream().forEach(b->System.out.println(b));

			//Prueba apartado 2-4

			//Prueba apartado 2-5
			Venta insert = new Venta(6,1, 2,new java.sql.Date(2019-01-03));
			databaseManager.addVenta(insert);
			ventas.stream().forEach(b->System.out.println(b));
			
			//Prueba apartado 2-6
			databaseManager.deleteVenta(5);
			ventas.stream().forEach(b->System.out.println(b));
		}

	}

}
