package dam.tema9.concesionario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Clase para los metodos de conexion con la base de datos
 * @author cumpli
 * @version 1.0
 */

public class DatabaseConnection {
	private Connection connection;
	
	/**
	 * Metodo para realizar la conexion con la base de datos
	 * @param connectionString contendra el conector de la conexion
	 * @return en caso de que venga vacio se devolvera false y en caso contrario true
	 */
	public boolean connect(@NonNull String connectionString) {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			this.connection = DriverManager.getConnection(connectionString);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection==null?false:true;
	}

	/**
	 * Metodo para la desconexion
	 * @return 
	 */
	public boolean disconnect () {
		try {
			this.connection.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	/**
	 * Metodo para obtener el conector de la conexion
	 * @return el valor de connection
	 */
	public Connection getConnection() {
		return this.connection;
	}


	/**
	 * Metodo para comprobar si esta conectado
	 * @return 
	 */
	public boolean isConnected() {
		try {
			return !this.connection.isClosed();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
