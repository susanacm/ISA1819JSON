package salud.isa.gson.example;

import java.io.IOException;

import com.google.gson.stream.JsonReader;

public class ReadMedicines4 extends CadenaMando4{

	private static final String MEDICINES_TAGNAME = "medicines";
	private static final String NAME_FIELD_TAGNAME = "name";
	
	public ReadMedicines4(CadenaMando4 rm) {
		asignarSiguienteCategoria(rm);
	}
	
	public StringBuffer LeerCategoria(JsonReader jsonFileName, String name) throws IOException {
		
		StringBuffer readData = new StringBuffer();
	
		if (name.equals(MEDICINES_TAGNAME)) {
			
			jsonFileName.beginArray();
			
			while(jsonFileName.hasNext()) {
				jsonFileName.beginObject();
				readData.append(leerElemento(jsonFileName));
				jsonFileName.endObject();
			}
			readData.append("\n");
			jsonFileName.endArray();
		}else if(cadenaM != null){
			readData = cadenaM.LeerCategoria(jsonFileName, name);
		}else {
			System.err.println("si que he entrado");
			jsonFileName.skipValue();	
		}
		return readData;	
	}

	public StringBuffer leerElemento(JsonReader jsonFileName) throws IOException{
		String nombre = null;
		StringBuffer leerDatos = new StringBuffer();
		
		try {
			while(jsonFileName.hasNext()) {
				String name = jsonFileName.nextName();
				if(name.equals(NAME_FIELD_TAGNAME)) {
					nombre = jsonFileName.nextString();
					leerDatos.append(nombre);
				}else {
					asignarSiguienteCategoria(cadenaM);
				}
				leerDatos.append("\n");
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		return leerDatos;
	}
}
