package utilidades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import grafo.Grafo;
import model.Agente;

public class Load {
	public static Grafo loadGrafo() {
		Gson gson = new Gson();
		Grafo ret = null;

		try{
			BufferedReader br = new BufferedReader(new FileReader("src/utilidades/Grafo.json"));
			ret =  gson.fromJson(br, Grafo.class);
		}
		catch (Exception e) {}
		return ret;
	}
	
	public static HashMap<Integer, Agente> loadAgentes() {
		Gson gson = new Gson();
		HashMap<Integer, Agente> ret = null;
		
		try{
			BufferedReader br = new BufferedReader(new FileReader("src/utilidades/Agentes.json"));
			Type agentesListType = new TypeToken<HashMap<Integer, Agente>>(){}.getType();
	        ret = gson.fromJson(br, agentesListType);
		}
		catch (Exception e) {}
		return ret;
	}
	
}
