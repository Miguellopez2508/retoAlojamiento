package TratamientoDatos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import Modelo.AlojamientoDB;

public class TratarJson {
	
	public boolean arraylistAlojamientostoJson(List<AlojamientoDB> lista) {		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = "";
		
		for (int i = 0; i < lista.size(); i++) {
			json += gson.toJson(lista.get(i));
		}
		
        try {
        	FileWriter fr = new FileWriter("datos.json");
			fr.write(json);
			fr.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
        return false;
	}	
}
