package dam.tema9.concesionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;

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
	// METODOS PARA TABALA CLIENTE

	/**
	 * Metodo para listar todo el listado de la tabla cliete
	 * @return devuelve una lista de todos los clientes
	 */
	public ArrayList<Cliente> getClientes(){
		ArrayList<Cliente> clientes = null;
		try {
			PreparedStatement ps= this.connection.prepareStatement(
					"SELECT id,nombre,apellidouno,apellidodos,email FROM cliente");
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


	public ArrayList<Cliente> getClientes(HashMap<String,Object> filter){
		ArrayList<Cliente> clientes = null;
		int i=0, type=Types.VARCHAR;
		String whereData="";
		try {

			for(String key:filter.keySet()) {
				whereData+=key+"=? AND ";
			}
			whereData = whereData.substring(0,whereData.length()-5);

			PreparedStatement ps = this.connection.prepareStatement("SELECT id, nombre,apellidouno,"+
					"apellidodos,email FROM cliente WHERE " + whereData);

			for(Object value:filter.values()) {
				if(value instanceof Integer) {
					type = Types.INTEGER;
				}else if(value instanceof Float) {
					type = Types.FLOAT;
				}else if(value instanceof Double) {
					type = Types.DOUBLE;
				}if(value instanceof String) {
					type = Types.VARCHAR;
				}
				ps.setObject(++i, value,type);
			}

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
	
	

	// METODOS PARA TABALA COCHE

	/**
	 * Metodo para listar todo el listado de la tabla coche
	 * @return devuelve una lista de todos los coches
	 */
	public ArrayList<Coche> getCoches(){
		ArrayList<Coche> coches = null;
		try {
			PreparedStatement ps= this.connection.prepareStatement(
					"SELECT id,modelo,precio,fabricante,anio,km,matricula FROM coche");
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


	public ArrayList<Coche> getCoche(HashMap<String,Object> filter){
		ArrayList<Coche> coches = null;
		int i=0, type=Types.VARCHAR;
		String whereData="";
		try {

			for(String key:filter.keySet()) {
				whereData+=key+"=? AND ";
			}
			whereData = whereData.substring(0,whereData.length()-5);

			PreparedStatement ps = this.connection.prepareStatement("SELECT id,modelo,precio,"+
					"fabricante,anio,km,matricula FROM coche WHERE " + whereData);

			for(Object value:filter.values()) {
				if(value instanceof Integer) {
					type = Types.INTEGER;
				}else if(value instanceof Float) {
					type = Types.FLOAT;
				}else if(value instanceof Double) {
					type = Types.DOUBLE;
				}if(value instanceof String) {
					type = Types.VARCHAR;
				}
				ps.setObject(++i, value,type);
			}

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


	// METODOS PARA TABALA VENTAS

	/**
	 * Metodo para listar todo el listado de la tabla ventas
	 * @return devuelve una lista de todas las ventas
	 */
	public ArrayList<Ventas> getVentas(){
		ArrayList<Ventas> ventas = null;
		try {
			PreparedStatement ps= this.connection.prepareStatement(
					"SELECT id,id_cliente,id_coche,fecha_de_compra FROM ventas");
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
	
	public ArrayList<Ventas> getVentas(HashMap<String,Object> filter){
		ArrayList<Ventas> ventas = null;
		int i=0, type=Types.VARCHAR;
		String whereData="";
		try {

			for(String key:filter.keySet()) {
				whereData+=key+"=? AND ";
			}
			whereData = whereData.substring(0,whereData.length()-5);

			PreparedStatement ps = this.connection.prepareStatement("SELECT id,id_cliente,id_coche,"+
			"fecha_de_compra FROM ventas WHERE " + whereData);

			for(Object value:filter.values()) {
				if(value instanceof Integer) {
					type = Types.INTEGER;
				}else if(value instanceof Float) {
					type = Types.FLOAT;
				}else if(value instanceof Double) {
					type = Types.DOUBLE;
				}if(value instanceof String) {
					type = Types.VARCHAR;
				}
				ps.setObject(++i, value,type);
			}

			ResultSet rs = ps.executeQuery();
			ventas= new ArrayList<Ventas>();
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