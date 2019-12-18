package Modelo;

public class UsuarioDB {
	public String DNI;
	public String Nombre;
	public String Apellidos;
	public String email;
	
	
	public UsuarioDB(String dNI, String nombre, String apellidos, String email) {
		this.DNI = dNI;
		this.Nombre = nombre;
		this.Apellidos = apellidos;
		this.email = email;
	}
	

	public String getDNI() {
		return DNI;
	}
	
	public void setDNI(String DNI) {
		this.DNI = DNI;
	}
	
	public String getNombre() {
		return Nombre;
	}
	
	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}
	
	public String getApellidos() {
		return Apellidos;
	}
	
	public void setApellidos(String Apellidos) {
		this.Apellidos = Apellidos;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
}