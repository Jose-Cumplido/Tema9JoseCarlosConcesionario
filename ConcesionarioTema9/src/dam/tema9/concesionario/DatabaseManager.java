package dam.tema9.concesionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.eclipse.jdt.annotation.NonNull;

public class DatabaseManager {
	private Connection connection = null;
	private Statement statement= null;

	private ArrayList<Cliente> clienteData;

	public DatabaseManager(@NonNull Connection connection) {
		this.connection = connection;
		try {
			this.statement=connection.createStatement();
			this.clienteData= new ArrayList<Cliente>();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
// metodos clientes
	public ArrayList<Cliente> getClientes(){
		ArrayList<Cliente> clientes = null;
		try {
			PreparedStatement ps= this.connection.prepareStatement(
					"SELECT id,nombre,apellidouno,apellidodos,email * FROM cliente");
			ResultSet rs = ps.executeQuery();
			clientes = new ArrayList<Cliente>();
			while(rs.next()) {
				clientes.add(new Cliente(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes;
				
	}
	
	//metodos coches
	public ArrayList<Coche> getCoches(){
		ArrayList<Coche> coches = null;
		try {
			PreparedStatement ps= this.connection.prepareStatement(
					"SELECT id,modelo,precio,fabricante,anio,km,matricula * FROM coche");
			ResultSet rs = ps.executeQuery();
			coches = new ArrayList<Coche>();
			while(rs.next()) {
				coches.add(new Coche(rs.getInt(1),
						rs.getString(2),
						rs.getDouble(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getInt(6),
						rs.getString(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return coches;
				
	}
	//metodos ventas
	public ArrayList<Ventas> getVentas(){
		ArrayList<Ventas> ventas = null;
		try {
			PreparedStatement ps= this.connection.prepareStatement(
					"SELECT id,id_cliente,id_coche,fecha_de_compra * FROM ventas");
			ResultSet rs = ps.executeQuery();
			ventas = new ArrayList<Ventas>();
			while(rs.next()) {
				ventas.add(new Ventas(rs.getInt(1),
						rs.getInt(2),
						rs.getInt(3),
						rs.getDate(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ventas;
				
	}
	

}