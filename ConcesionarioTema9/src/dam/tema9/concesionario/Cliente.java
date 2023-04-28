package dam.tema9.concesionario;

public class Cliente {
	private int id;
	private String nombre;
	private String apellidouno;
	private String apellidodos;
	private String email;
	
	public Cliente(int id, String nombre, String apellidouno, String apellidodos, String email) {
		this.id = id;
		this.nombre = nombre;
		this.apellidouno = apellidouno;
		this.apellidodos = apellidodos;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidouno() {
		return apellidouno;
	}
	public void setApellidouno(String apellidouno) {
		this.apellidouno = apellidouno;
	}
	public String getApellidodos() {
		return apellidodos;
	}
	public void setApellidodos(String apellidodos) {
		this.apellidodos = apellidodos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellidouno=" + apellidouno + ", apellidodos="
				+ apellidodos + ", email=" + email + "]";
	}
	
}