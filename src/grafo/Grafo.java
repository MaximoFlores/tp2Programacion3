package grafo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Grafo {
	private HashMap<Integer,HashSet<Arista>> vecinos;

	public Grafo() {
		this.vecinos = new HashMap<Integer, HashSet<Arista>>();
	}

	public Grafo(HashMap<Integer, HashSet<Arista>> vecinos) {
		this.vecinos = vecinos;
	}
	
	public void agregarArista(Arista arista) {
		if(existeVertice(arista.getOrigen()) && existeVertice(arista.getDestino()) &&
				!existeArista(arista.getOrigen(), arista.getDestino())) {
			
			this.vecinos.get(arista.getOrigen()).add(arista);
			this.vecinos.get(arista.getDestino()).add(new Arista(arista.getDestino(),arista.getOrigen(),arista.getPeso()));
		}
	}

	public void eliminarArista(int vert1,int vert2) {
		if(existeVertice(vert1) && existeVertice(vert2) && existeArista(vert1, vert2)) {
			this.vecinos.get(vert1).removeIf(a -> a.getDestino() == vert2);
			this.vecinos.get(vert2).removeIf(a -> a.getDestino() == vert1);
		}
	}

	public void agregarVertice(int id) {
		this.vecinos.put(id, new HashSet<Arista>() );
	}

	public void eliminarVertice(int id) {
		if(existeVertice(id)) {
			this.vecinos.remove(id);

			for (HashSet<Arista> grupoVecinos : vecinos.values()) {
				Iterator<Arista> it = grupoVecinos.iterator();
				while(it.hasNext()) {
					Arista arista = it.next();
					if(arista.getDestino() == id)
						it.remove();
				}	
			}
		}
	}

	@SuppressWarnings("unchecked")
	public HashSet<Arista> getVecinos(int vert){
		return (HashSet<Arista>) this.vecinos.get(vert).clone();
	}
	
	public List<Arista> listaAristas(){
		List<Arista> ret = new LinkedList<>();
		for (HashSet<Arista> vecinosVert : this.vecinos.values()) {
			ret.addAll(vecinosVert);
		}
		return ret;
	}

	public HashSet<Integer> vertices(){
		return (HashSet<Integer>) this.vecinos.keySet();
	}
	
	private boolean existeVertice(int vert) {
		return this.vecinos.containsKey(vert);
	}

	private boolean existeArista(int vert1, int vert2) {
		boolean ret = contieneArista(this.vecinos.get(vert1), vert2);
		ret = contieneArista(this.vecinos.get(vert2), vert1);
		return ret;
	}

	private boolean contieneArista(HashSet<Arista> listaArista,int vertice) {
		for (Arista arista : listaArista) {
			if(arista.getDestino() == vertice)
				return true;
		}
		return false;
	}

}
