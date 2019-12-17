package ConexionesBBDD;

public class AlojamientoDB {
	public int ID;
	public String Nombre;
	public String Descripcion;
	public String Longitud;
	public String Latitud;
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String Descripcion) {
		this.Descripcion = Descripcion;
	}
	public String getLongitud() {
		return Longitud;
	}
	public void setLongitud(String Longitud) {
		this.Longitud = Longitud;
	}
	public String getLatitud() {
		return Latitud;
	}
	public void setLatitud(String Latitud) {
		this.Latitud = Latitud;
	}
}