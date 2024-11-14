package model;

import java.util.HashMap;
import java.util.HashSet;

import org.openstreetmap.gui.jmapviewer.Coordinate;

import grafo.Arista;
import grafo.Grafo;
import grafo.Kruskal;
import grafo.Prim;

public class GestionDeAgentes {
	Grafo grafo;
	HashMap<Integer, Agente> agentes;
	private HashSet<Observador> observadores;
	
	public GestionDeAgentes() {
		grafo = new Grafo();
		agentes = new HashMap<Integer, Agente>();
		observadores = new HashSet<Observador>();
	}
	
	public void agregarAgente(String nombre, Coordinate coordenadas) {
		Agente agente = new Agente(nombre, coordenadas);
		agentes.put(agente.getID(), agente);
		grafo.agregarVertice(agente.getID());
		notificarObservadores();
	}
	
	public void eliminarAgente(int ID) {
		if (existeAgente(ID)) {
			grafo.eliminarVertice(ID);
			agentes.remove(ID);
			notificarObservadores();
		}
	}
	
	public void agregarEnlace(int ID1, int ID2, int probabilidad) {
		if(existeAgente(ID1) && existeAgente(ID2)) {
			grafo.agregarArista(new Arista(ID1, ID2, probabilidad));
			notificarObservadores();
		}
	}
	
	public void eliminarEnlace(int ID1, int ID2) {
		if(existeAgente(ID1) && existeAgente(ID2)) {
			grafo.eliminarArista(ID1, ID2);
		}
	}
	
	public HashSet<Arista> ejecutarPrim() {
		return listaEnlaces(Prim.ejecutarPrim(grafo));
	}

	public HashSet<Arista> ejecutarKruskal() {
		return listaEnlaces(Kruskal.ejecutarKruskal(grafo));
	}
	
	public void registrarObservadores(Observador obs) {
		this.observadores.add(obs);
	}
	
	private void notificarObservadores() {
		for (Observador observador : observadores) {
			observador.notificar(this);
		}
	}
	
	private boolean existeAgente(int id) {
		return agentes.containsKey(id);
	}
	//Testear - NO SE SI FUNCIONA
	private HashSet<Arista> listaEnlaces(Grafo grafo){
		HashSet<Arista> ret = new HashSet<Arista>();
		for (Arista arista1 : grafo.listaAristas()) {
			for (Arista arista2 : ret) {
				if(!arista1.esReversa(arista2))
					ret.add(arista1);
				else
					break;
			}
		}
		return ret;
	}
	
	
	
}
