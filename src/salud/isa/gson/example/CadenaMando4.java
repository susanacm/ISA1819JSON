package salud.isa.gson.example;

import java.io.IOException;

import com.google.gson.stream.JsonReader;

public abstract class CadenaMando4 {
protected CadenaMando4 cadenaM;
	
	public abstract StringBuffer LeerCategoria(JsonReader jsonFileName,  String name)throws IOException ;
	public void asignarSiguienteCategoria(CadenaMando4 c)
	{
	
		cadenaM = c;
	}
	
//	public CadenaMando4 leerSiguienteCategoria() {
//		return null;
//	}
	//abstract String leerElementoConcreto(JsonReader jsonFileName) throws IOException;
	abstract StringBuffer leerElemento(JsonReader jsonFileName) throws IOException;
	//abstract String leerElemento(JsonReader jsonFileName) throws IOException;
}
