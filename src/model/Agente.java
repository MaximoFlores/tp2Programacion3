package model;

import org.openstreetmap.gui.jmapviewer.Coordinate;

public class Agente {
	private static int acumulador;
	
	private String nombre;
	private int ID;
	private Coordinate coordenadas;
	
	public Agente(String nombre, Coordinate coordenadas) {
		this.nombre = nombre;
		this.ID = acumulador++;
		this.coordenadas = coordenadas;
	}
	
	public String getNombre() {
		return nombre;
	}
	public int getID() {
		return ID;
	}
	public Coordinate getCoordenadas() {
		return coordenadas;
	}
	
	
}
