package dam.tema9.concesionario;



public class Venta {
	private int id;
	private int idCliente;
	private int idCoche;
	private java.sql.Date fechaDeCompra;

	public Venta(int id) {
		this.id = id;
	}

	public Venta(int id, int idCliente, int idCoche, java.sql.Date fechaDeCompra) {
		this(id);
		this.idCliente = idCliente;
		this.idCoche = idCoche;
		this.fechaDeCompra = fechaDeCompra;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdCoche() {
		return idCoche;
	}

	public void setIdCoche(int idCoche) {
		this.idCoche = idCoche;
	}

	public java.sql.Date getFechaDeCompra() {
		return fechaDeCompra;
	}

	public void setFechaDeCompra(java.sql.Date fechaDeCompra) {
		this.fechaDeCompra = fechaDeCompra;
	}

	@Override
	public String toString() {
		return "Ventas [id=" + id + ", idCliente=" + idCliente + ", idCoche=" + idCoche + ", fechaDeCompra="
				+ fechaDeCompra + "]";
	}

}