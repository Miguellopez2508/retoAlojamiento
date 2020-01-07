package Modelo;

public class Md5Alojamiento {

	int id;
	String hash;

	public Md5Alojamiento(String hash) {
		this.hash = hash;
	}
	
	public Md5Alojamiento() {
		
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
