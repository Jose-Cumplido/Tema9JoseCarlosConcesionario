package dam.tema9.concesionario;

import java.sql.Connection;
import java.sql.Date;
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
	private PreparedStatement pStatement;
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

	/**
	 * Se filtran los datos de cliente al menos por 2 campos
	 * @param filter contendra los campos a filtrar
	 * @return devulve un listado de los datos filtrados por los campos seleccionados
	 */
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
	
	/**
	 * Se pueden ordenada los datos por alguno de los campos seleccionados
	 * @param columnOrder contendra los indices y ordenes de ordenacion
	 * @return devuelve un listado de los datos ordenados por su indice y orden
	 */
	public ArrayList<Cliente> getClientes(ColumnOrder... columnOrder) {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Cliente cliente = null;	
		String order=" ORDER BY ";
		String sqlQuery="SELECT id,nombre,apellidouno,apellidodos,email FROM cliente";
		try {
			for(ColumnOrder column:columnOrder) {
				order+=column.getIndex() + " " + column.getOrden() + ",";
			}
			if(order.length()>10) {
				order = order.substring(0,order.length()-1);
				sqlQuery+=order;
			}
			
			this.pStatement = this.connection.prepareStatement(sqlQuery);
			
			//obtengo el conjunto de resultados porque se que
			//la sentencia ejecutada los ha producido (SELECT			
			ResultSet rs = statement.executeQuery(sqlQuery);
			while(rs.next()) {			
				cliente = new Cliente(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5));			
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return clientes;
	}
	
	/**
	 * Añade un nuevo cliente a la base de datos
	 * @param cliente cliente que se va a añadir
	 * @return True si se consigue añadir el nuevo cliente
	 */
	public boolean addCoche(Cliente cliente) {		
		boolean added=false;
		try {			
			this.pStatement = this.connection.prepareStatement("INSERT INTO venta (nombre,apellidouno,apellidodos,email) VALUES (?,?,?,?)");
			this.pStatement.setString(1, cliente.getNombre());
			this.pStatement.setString(2, cliente.getApellidouno());
			this.pStatement.setString(3, cliente.getApellidodos());
			this.pStatement.setString(4, cliente.getEmail());
			
			added = this.pStatement.executeUpdate()>0;
													
		    return added;
		}catch(SQLException e) {
			return added;
		}
	}
	
	/**
	 * borra un cliente de la base de datos
	 * @param id cliente que se va a borrar
	 * @return True si se consigue borrar el cliente
	 */
	public boolean deleteCliente(int id) {
		boolean deleted=false;
		try {
			this.pStatement = this.connection.prepareStatement("DELETE FROM cliente WHERE id=?");
			this.pStatement.setInt(1, id);
			
			deleted = this.pStatement.executeUpdate()>0;			
		}catch(SQLException e) {
		}
		return deleted;			
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
	
	/**
	 * Se filtran los datos de coche al menos por 2 campos
	 * @param filter contendra los campos a filtrar
	 * @return devulve un listado de los datos filtrados por los campos seleccionados
	 */
	public ArrayList<Coche> getCoches(HashMap<String,Object> filter){
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

	/**
	 * Se pueden ordenada los datos por alguno de los campos seleccionados
	 * @param columnOrder contendra los indices y ordenes de ordenacion
	 * @return devuelve un listado de los datos ordenados por su indice y orden
	 */
	public ArrayList<Coche> getCoches(ColumnOrder... columnOrder) {
		ArrayList<Coche> coches = new ArrayList<Coche>();
		Coche coche = null;	
		String order=" ORDER BY ";
		String sqlQuery="SELECT id,modelo,precio,fabricante,anio,km,matricula FROM coche";
		try {
			for(ColumnOrder column:columnOrder) {
				order+=column.getIndex() + " " + column.getOrden() + ",";
			}
			if(order.length()>10) {
				order = order.substring(0,order.length()-1);
				sqlQuery+=order;
			}
			
			this.pStatement = this.connection.prepareStatement(sqlQuery);
			
			//obtengo el conjunto de resultados porque se que
			//la sentencia ejecutada los ha producido (SELECT			
			ResultSet rs = statement.executeQuery(sqlQuery);
			while(rs.next()) {			
				coche = new Coche(rs.getInt(1),
						rs.getString(2),
						rs.getDouble(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getInt(6),
						rs.getString(7));			
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return coches;
	}
	
	/**
	 * Añade un nuevo coche a la base de datos
	 * @param coche coche que se va a añadir
	 * @return True si se consigue añadir el nuevo coche
	 */
	public boolean addCoche(Coche coche) {		
		boolean added=false;
		try {			
			this.pStatement = this.connection.prepareStatement("INSERT INTO venta (modelo,precio,fabricante,anio,km,matricula) VALUES (?,?,?,?,?,?)");
			this.pStatement.setString(1, coche.getModelo());
			this.pStatement.setDouble(2, coche.getPrecio());
			this.pStatement.setString(3, coche.getFabricante());
			this.pStatement.setInt(4, coche.getAnio());
			this.pStatement.setInt(5, coche.getKm());
			this.pStatement.setString(3, coche.getMatricula());

			added = this.pStatement.executeUpdate()>0;
													
		    return added;
		}catch(SQLException e) {
			return added;
		}
	}
	
	/**
	 * borra un coche de la base de datos
	 * @param id coche que se va a borrar
	 * @return True si se consigue boora el coche
	 */
	public boolean deleteCoche(int id) {
		boolean deleted=false;
		try {
			this.pStatement = this.connection.prepareStatement("DELETE FROM coche WHERE id=?");
			this.pStatement.setInt(1, id);
			
			deleted = this.pStatement.executeUpdate()>0;			
		}catch(SQLException e) {
		}
		return deleted;			
	}

	// METODOS PARA TABALA VENTAS

	/**
	 * Metodo para listar todo el listado de la tabla ventas
	 * @return devuelve una lista de todas las ventas
	 */
	public ArrayList<Venta> getVentas(){
		ArrayList<Venta> ventas = null;
		try {
			PreparedStatement ps= this.connection.prepareStatement(
					"SELECT id,id_cliente,id_coche,fecha_de_compra FROM venta");
			ResultSet rs = ps.executeQuery();
			ventas = new ArrayList<Venta>();
			while(rs.next()) {
				ventas.add(new Venta(rs.getInt(1),
						rs.getInt(2),
						rs.getInt(3),
						rs.getDate(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ventas;

	}

	/**
	 * Se filtran los datos de ventas al menos por 2 campos
	 * @param filter contendra los campos a filtrar
	 * @return devulve un listado de los datos filtrados por los campos seleccionados
	 */
	public ArrayList<Venta> getVentas(HashMap<String,Object> filter){
		ArrayList<Venta> ventas = null;
		int i=0, type=Types.VARCHAR;
		String whereData="";
		try {

			for(String key:filter.keySet()) {
				whereData+=key+"=? AND ";
			}
			whereData = whereData.substring(0,whereData.length()-5);

			PreparedStatement ps = this.connection.prepareStatement("SELECT id,id_cliente,id_coche,"+
					"fecha_de_compra FROM venta WHERE " + whereData);

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
			ventas= new ArrayList<Venta>();
			while(rs.next()) {
				ventas.add(new Venta(rs.getInt(1),
						rs.getInt(2),
						rs.getInt(3),
						rs.getDate(4)));
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ventas;
	}
	
	/**
	 * Se pueden ordenada los datos por alguno de los campos seleccionados
	 * @param columnOrder contendra los indices y ordenes de ordenacion
	 * @return devuelve un listado de los datos ordenados por su indice y orden
	 */
	public ArrayList<Venta> getVentas(ColumnOrder... columnOrder) {
		ArrayList<Venta> ventas = new ArrayList<Venta>();
		Venta venta = null;	
		String order=" ORDER BY ";
		String sqlQuery="SELECT id,id_cliente,id_coche,fecha_de_compra FROM venta";
		try {
			for(ColumnOrder column:columnOrder) {
				order+=column.getIndex() + " " + column.getOrden() + ",";
			}
			if(order.length()>10) {
				order = order.substring(0,order.length()-1);
				sqlQuery+=order;
			}
			
			this.pStatement = this.connection.prepareStatement(sqlQuery);
			
			//obtengo el conjunto de resultados porque se que
			//la sentencia ejecutada los ha producido (SELECT			
			ResultSet rs = statement.executeQuery(sqlQuery);
			while(rs.next()) {			
				venta = new Venta(rs.getInt(1),
						rs.getInt(2),
						rs.getInt(3),
						rs.getDate(4));
				ventas.add(venta);			
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return ventas;
	}
	
	/**
	 * Añade una nueva venta a la base de datos
	 * @param venta venta que se va a añadir
	 * @return True si se consigue añadir la venta
	 */
	public boolean addVenta(Venta venta) {		
		boolean added=false;
		try {			
			this.pStatement = this.connection.prepareStatement("INSERT INTO venta (id_cliente,"
					+ "id_coche, fecha_de_compra VALUES(?,?,?)");
			this.pStatement.setInt(1, venta.getIdCliente());
			this.pStatement.setInt(2, venta.getIdCoche());
			this.pStatement.setDate(3,venta.getFechaDeCompra());
			
			added = this.pStatement.executeUpdate()>0;
													
		    return added;
		}catch(SQLException e) {
			return added;
		}
	}
	
	/**
	 * borra una venta de la base de datos
	 * @param id venta que se va a borrar
	 * @return True si se consigue borrar la venta
	 */
	public boolean deleteVenta(int id) {
		boolean deleted=false;
		try {
			this.pStatement = this.connection.prepareStatement("DELETE FROM venta WHERE id=?");
			this.pStatement.setInt(1, id);
			
			deleted = this.pStatement.executeUpdate()>0;			
		}catch(SQLException e) {
		}
		return deleted;			
	}
	
}