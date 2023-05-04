package dam.tema9.concesionario;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		DatabaseConnection databaseConnection = new DatabaseConnection();

		if(databaseConnection.connect("jdbc:mysql://localhost/concesionario?" + 
				"user=cumpli&password=ubuntu")){

			DatabaseManager databaseManager = new DatabaseManager(databaseConnection.getConnection());

		System.out.println(databaseConnection.isConnected());

		ArrayList<Cliente> clientes = databaseManager.getClientes();


		clientes.stream().forEach(b->System.out.println(b));

	}

}

}
