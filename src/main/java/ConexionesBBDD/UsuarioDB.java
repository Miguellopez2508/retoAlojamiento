package ConexionesBBDD;

public class UsuarioDB {
	public int DNI;
	public String Nombre;
	public String Apellido;
	public String email;
	
	public int getDNI() {
		return DNI;
	}
	
	public void setDNI(int DNI) {
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