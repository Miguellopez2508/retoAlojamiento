package Modelo;
import java.util.Date;

public class ReservasDB {
	public int ID;
	public int DNI;
	public Date Fecha_Inicio;
	public Date Fecha_Fin;
	public int id_alojamiento;
	public int getID() {
		return ID;
	}
	public int getDNI() {
		return DNI;
	}
	public Date getFecha_Inicio() {
		return Fecha_Inicio;
	}
	public Date getFecha_Fin() {
		return Fecha_Fin;
	}
	public int getId_alojamiento() {
		return id_alojamiento;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	public void setDNI(int DNI) {
		this.DNI = DNI;
	}
	public void setFecha_Inicio(Date Fecha_Inicio) {
		this.Fecha_Inicio = Fecha_Inicio;
	}
	public void setFecha_Fin(Date Fecha_Fin) {
		this.Fecha_Fin = Fecha_Fin;
	}
	public void setId_alojamiento(int id_alojamiento) {
		this.id_alojamiento = id_alojamiento;
	}
}