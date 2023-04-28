package dam.tema9.concesionario;

import java.util.Date;

public class Ventas {
	private int id;
	private int idCliente;
	private int idCoche;
	private Date fechaDeCompra;
	
	public Ventas(int id, int idCliente, int idCoche, Date fechaDeCompra) {
		this.id = id;
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

	public Date getFechaDeCompra() {
		return fechaDeCompra;
	}

	public void setFechaDeCompra(Date fechaDeCompra) {
		this.fechaDeCompra = fechaDeCompra;
	}

	@Override
	public String toString() {
		return "Ventas [id=" + id + ", idCliente=" + idCliente + ", idCoche=" + idCoche + ", fechaDeCompra="
				+ fechaDeCompra + "]";
	}
	
}