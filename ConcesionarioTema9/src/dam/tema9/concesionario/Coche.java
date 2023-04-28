package dam.tema9.concesionario;

public class Coche {
	private int id;
	private String modelo;
	private double precio;
	private String fabricante;
	private int anio;
	private int km;
	private String matricula;
	
	public Coche(int id, String modelo, double precio, String fabricante, int anio, int km,String matricula) {
		this.id = id;
		this.modelo = modelo;
		this.precio = precio;
		this.fabricante = fabricante;
		this.anio = anio;
		this.km = km;
		this.matricula=matricula;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}
	
	

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Coche [id=" + id + ", modelo=" + modelo + ", precio=" + precio + ", fabricante=" + fabricante
				+ ", anio=" + anio + ", km=" + km + ", matricula=" + matricula + "]";
	}

}