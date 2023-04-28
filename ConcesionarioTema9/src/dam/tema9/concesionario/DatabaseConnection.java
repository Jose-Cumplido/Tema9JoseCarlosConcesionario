package dam.tema9.concesionario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.eclipse.jdt.annotation.NonNull;

public class DatabaseConnection {
	private Connection connection;

	public boolean connect(@NonNull String conectionString) {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			this.connection = DriverManager.getConnection(conectionString);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection==null?true:false;
	}
	
	public Connection getConnection() {
		return this.connection;
	}
	
	public boolean isConnected() {
		try {
			return !this.connection.isClosed();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
