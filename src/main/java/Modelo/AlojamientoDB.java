package Modelo;

public class AlojamientoDB {
	
	public String Signatura;
	public String Nombre;
	public String Descripcion;
	public String Telefono;
	public String Direccion;
	public String Email;
	public String Web;
	public String TipoDeAlojamiento;
	public int Capacidad;
	public int CodigoPostal;
	public String Longitud;
	public String Latitud;
	public String Municipio;
	public String Territorio;
	
<<<<<<< HEAD
	public AlojamientoDB(String signatura, String nombre, String descripcion, String telefono, String direccion, String email, String web, String tipoDeAlojamiento, int capacidad, int codigoPostal, String longitud, String latitud, String municipio, String territorio) {
=======
	
	public AlojamientoDB(String signatura, String nombre, String descripcion, String telefono, String direccion, String email, String web, String tipoDeAlojamiento, int capacidad, int codigoPostal, String longitud, String latitud, String Municipio, String Territorio) {
>>>>>>> feeb2da6a31202858464b4d8cba002f63a740be5
		this.Signatura = signatura;
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
<<<<<<< HEAD
		this.Municipio = municipio;
		this.Territorio = territorio;
=======
		this.Municipio = Municipio;
		this.Territorio = Territorio;
>>>>>>> feeb2da6a31202858464b4d8cba002f63a740be5
	}
	
	
	public String getMunicipio() {
		return Municipio;
	}


	public String getTerritorio() {
		return Territorio;
	}


	public void setMunicipio(String municipio) {
		Municipio = municipio;
	}


	public void setTerritorio(String territorio) {
		Territorio = territorio;
	}


	public AlojamientoDB() {

	}
	
	
	
	public String getMunicipio() {
		return Municipio;
	}


	public void setMunicipio(String municipio) {
		Municipio = municipio;
	}


	public String getTerritorio() {
		return Territorio;
	}


	public void setTerritorio(String territorio) {
		Territorio = territorio;
	}


	public String getSignatura() {
		return Signatura;
	}


	public void setSignatura(String signatura) {
		this.Signatura = signatura;
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
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
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