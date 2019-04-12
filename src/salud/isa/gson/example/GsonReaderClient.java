package salud.isa.gson.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import com.google.gson.stream.JsonReader;

public class GsonReaderClient {


	public static void main(String[] args) throws IOException {
		
		//Poner correctamente la direccion del fichero de lectura. FileReader()

		try {
		InputStream userIs = new FileInputStream(new File("./datos.json"));
		//InputStream userIs = new FileInputStream(new File("./datosshort.json"));

		JsonReader leerDatos = new JsonReader(new InputStreamReader(userIs, "UTF-8")); 

		//Creamos el orden de la cadena de mando
		
		ReadRescueMedicinePresentations4 rmp = new ReadRescueMedicinePresentations4(null);
		
		ReadMedicines4 rm = new ReadMedicines4(rmp);
		
		CadenaMando4 cmd =  rm;
		
		StringBuffer readData = new StringBuffer();
		try {
			leerDatos.beginObject();
			while(leerDatos.hasNext()) {
				String name= leerDatos.nextName();
				readData.append(name).append(": \n\n");
				readData.append(cmd.LeerCategoria(leerDatos, name));
			}
				leerDatos.endObject();
				System.out.println(readData.toString());
			} finally {
				
			}
		userIs.close();
		leerDatos.close();
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		
	}

}
