package TratamientoDatos;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class DescargaXml {

	public void cogerRuta() {
		
		String campings = "http://opendata.euskadi.eus/contenidos/ds_recursos_turisticos/campings_de_euskadi/opendata/alojamientos.xml";
		String alojamientosRurales = "http://opendata.euskadi.eus/contenidos/ds_recursos_turisticos/alojamientos_rurales_euskadi/opendata/alojamientos.xml";
		String albergues = "http://opendata.euskadi.eus/contenidos/ds_recursos_turisticos/albergues_de_euskadi/opendata/alojamientos.xml";
		
	    if (!descargarXml(campings, "campings.xml")) {
	    	System.out.println("Los campings no se cargaron");
	    }
		
	    if (!descargarXml(alojamientosRurales, "alojamientosRurales.xml")) {
	    	System.out.println("Los alojamientos no se cargaron");
	    }
	    
	    if (!descargarXml(albergues, "albergues.xml")) {
	    	System.out.println("Los albergues no se cargaron");
	    }
	}
	
	public boolean descargarXml(String urlStr, String file)  {
		
		URL url;
		try {
			url = new URL(urlStr);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
			return false;
		}
		
		ReadableByteChannel rbc;
		try {
			rbc = Channels.newChannel(url.openStream());
		} catch (IOException e) {
			e.printStackTrace();
			return false;		
		}
		
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
			
		try {
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			fos.close();
			rbc.close();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		return true;	       
	}	
}
