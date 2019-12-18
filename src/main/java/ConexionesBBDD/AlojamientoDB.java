package ConexionesBBDD;

public class AlojamientoDB {
	
	
	public int ID;
	public String Nombre;
	public String Descripcion;
	public int Telefono;
	public String Direccion;
	public String Email;
	public String Web;
	public String TipoDeAlojamiento;
	public int Capacidad;
	public int CodigoPostal;
	public String Longitud;
	public String Latitud;
	
	
	public AlojamientoDB(int ID, String nombre, String descripcion, int telefono, String direccion, String email, String web, String tipoDeAlojamiento, int capacidad, int codigoPostal, String longitud, String latitud) {
		this.ID = ID;
		this.Nombre = nombre;
		this.Descripcion = descripcion;
		this.Telefono = telefono;
		this.Direccion = direccion;
		this.Email = email;
		this.Web = web;
		this.TipoDeAlojamiento = tipoDeAlojamiento;
		this.Capacidad = capacidad;
		this.CodigoPostal = codigoPostal;
		this.Longitud = longitud;
		this.Latitud = latitud;
	}
	
	public AlojamientoDB() {

	}
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public int getTelefono() {
		return Telefono;
	}
	public void setTelefono(int telefono) {
		Telefono = telefono;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getWeb() {
		return Web;
	}
	public void setWeb(String web) {
		Web = web;
	}
	public String getTipoDeAlojamiento() {
		return TipoDeAlojamiento;
	}
	public void setTipoDeAlojamiento(String tipoDeAlojamiento) {
		TipoDeAlojamiento = tipoDeAlojamiento;
	}
	public int getCapacidad() {
		return Capacidad;
	}
	public void setCapacidad(int capacidad) {
		Capacidad = capacidad;
	}
	public int getCodigoPostal() {
		return CodigoPostal;
	}
	public void setCodigoPostal(int codigoPostal) {
		CodigoPostal = codigoPostal;
	}
	public String getLongitud() {
		return Longitud;
	}
	public void setLongitud(String longitud) {
		Longitud = longitud;
	}
	public String getLatitud() {
		return Latitud;
	}
	public void setLatitud(String latitud) {
		Latitud = latitud;
	}
	
	
	
	
}