package grafo;

public class Arista {
	private int origen, destino, peso;

	public Arista(int vertice1, int vertice2, int peso) {
		this.origen = vertice1;
		this.destino = vertice2;
		this.peso = peso;
	}

	public int getOrigen() {
		return origen;
	}

	public int getDestino() {
		return destino;
	}

	public int getPeso() {
		return peso;
	}
	
	public boolean esReversa(Arista other) {
		return origen == other.getDestino() && destino == other.getOrigen();
	}
}
