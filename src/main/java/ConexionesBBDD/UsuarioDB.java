package ConexionesBBDD;

public class UsuarioDB {
	public String DNI;
	public String Nombre;
	public String Apellido;
	public String email;
	
	
	public UsuarioDB(String dNI, String nombre, String apellido, String email) {
		this.DNI = dNI;
		this.Nombre = nombre;
		this.Apellido = apellido;
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
	
	public String getApellido() {
		return Apellido;
	}
	
	public void setApellido(String Apellido) {
		this.Apellido = Apellido;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
}