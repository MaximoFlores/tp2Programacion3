package utilidades;

import java.io.FileWriter;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import grafo.Grafo;
import model.Agente;


public class Save {

	public static void saveGrafo(Grafo grafo) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(grafo);
        try {
            FileWriter writer = new FileWriter("src/utilidades/Grafo.json");
            writer.write(json);
            writer.close();
        } catch (Exception e) {
        }
    }
	
	public static void saveAgentes(HashMap<Integer, Agente> agentes) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(agentes);
        try {
            FileWriter writer = new FileWriter("src/utilidades/Agentes.json");
            writer.write(json);
            writer.close();
        } catch (Exception e) {
        }
	}
	
	
}
