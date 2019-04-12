package salud.isa.gson.example;

import java.io.IOException;

import com.google.gson.stream.JsonReader;

public class ReadRescueMedicinePresentations4 extends CadenaMando4{

	private static final String RESCUEMEDPRES_TAGNAME = "rescueMedicinePresentations";
	private static final String MEDREF_FIELD_TAGNAME = "medicineRef";
	private static final String ACTINGREF_FIELD_TAGNAME = "activeIngRef";
	private static final String INHREF_FIELD_TAGNAME = "inhalerRef";
	private static final String DOSE_FIELD_TAGNAME = "dose";
	private static final String FIELD_SEPARATOR = ";";
	
	public ReadRescueMedicinePresentations4(CadenaMando4 rmp) {
		asignarSiguienteCategoria(rmp);
	}

	public StringBuffer LeerCategoria(JsonReader jsonFileName, String name) throws IOException {
		
		StringBuffer readData = new StringBuffer();
	
		if(name.equals(RESCUEMEDPRES_TAGNAME)) {
			jsonFileName.beginArray();
			while(jsonFileName.hasNext()) {
				jsonFileName.beginObject();
				readData.append(leerElemento(jsonFileName));
				//readData.append(leerElementoConcreto(jsonFileName));
				jsonFileName.endObject();
			}
			readData.append("\n");
			jsonFileName.endArray();
		}else if(cadenaM != null){
			readData = cadenaM.LeerCategoria(jsonFileName, name);
		}else {
			jsonFileName.skipValue();
		}		
		return readData;
	}
	
	StringBuffer leerElemento(JsonReader jsonFileName) throws IOException {

		String medicineRef = null;
		String activeIngRef = null;
		String inhalerRef = null;
		String dose = null;
		StringBuffer leerDatos = new StringBuffer();
		
		try {
			while(jsonFileName.hasNext()) {
				String name = jsonFileName.nextName();
				if(name.equals(MEDREF_FIELD_TAGNAME)) {
					medicineRef = jsonFileName.nextString();
					leerDatos.append(medicineRef).append(FIELD_SEPARATOR);
				}else if(name.equals(ACTINGREF_FIELD_TAGNAME)) {	
					activeIngRef = jsonFileName.nextString();
					leerDatos.append(activeIngRef).append(FIELD_SEPARATOR);
				}else if(name.equals(INHREF_FIELD_TAGNAME)) {
					inhalerRef = jsonFileName.nextString();
					leerDatos.append(inhalerRef).append(FIELD_SEPARATOR);
				}else if(name.equals(DOSE_FIELD_TAGNAME)){
					dose = jsonFileName.nextString();
					leerDatos.append(dose).append(FIELD_SEPARATOR);
					leerDatos.append("\n");	
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
	