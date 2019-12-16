package pruebadescargaxml;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class pruebadescargaxml {

	public static void main(String[] args) {
		String alojamiento = "http://opendata.euskadi.eus/contenidos/ds_recursos_turisticos/campings_de_euskadi/opendata/alojamientos.xml";
        
	        try {
	            downloadUsingNIO(alojamiento, "C:\\Temp\\alojamiento.xml");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	}
	private static void downloadUsingNIO(String urlStr, String file) throws IOException {
        URL url = new URL(urlStr);
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream(file);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        fos.close();
        rbc.close();
    }
}
