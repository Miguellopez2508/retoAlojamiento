package Main;

import ConexionesBBDD.ControladorUsuarios;

public class Main {

	public static void main(String[] args) {
		ControladorUsuarios miControlador = new ControladorUsuarios();

		miControlador.addUsuarioDB("79066869A", "christian", "von heeren", "dsds@sd.com");
	}

}
