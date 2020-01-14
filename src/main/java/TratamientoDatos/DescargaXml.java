package TratamientoDatos;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;

import Modelo.AlojamientoDB;

public class DescargaXml {

	public void cogerRuta() {
		
		String campings = "http://opendata.euskadi.eus/contenidos/ds_recursos_turisticos/campings_de_euskadi/opendata/alojamientos.xml";
		String alojamientosRurales = "http://opendata.euskadi.eus/contenidos/ds_recursos_turisticos/alojamientos_rurales_euskadi/opendata/alojamientos.xml";
		String albergues = "http://opendata.euskadi.eus/contenidos/ds_recursos_turisticos/albergues_de_euskadi/opendata/alojamientos.xml";
		
	    try {
	    	descargarXml(campings, "campings.xml");
	    } catch (IOException e) {
	    	System.out.println("Error en la descarga del archivo de campings");
	    }
	    
	    try {
	    	descargarXml(alojamientosRurales, "alojamientosRurales.xml");
	    } catch (IOException e){
	    	System.out.println("Error en la descarga del archivo de campings de alojamientos rurales");
	    }
	    
	    try {
	    	descargarXml(albergues, "albergues.xml");
	    } catch (IOException e){
	    	System.out.println("Error en la descarga del archivo de campings de albergues");
	    }

	}
	
	private void descargarXml(String urlStr, String file) throws IOException {
		
        URL url = new URL(urlStr);
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream(file);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        fos.close();
        rbc.close();
    }
	
	
}
