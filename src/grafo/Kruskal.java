package grafo;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Kruskal {
	public static Grafo ejecutarKruskal(Grafo g) {
		List<Arista> aristas = g.listaAristas();
		
		Collections.sort(aristas, Comparator.comparingInt(Arista::getPeso));
		
		Grafo ret = new Grafo(); 
		HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer>();

		int index = 0;
		for (Integer vertice : g.vertices()) {
			if(!indexMap.containsKey(vertice))
				indexMap.put(vertice, index++);
		}
		UnionFind uf = new UnionFind(indexMap.size());
		
		for (Arista arista : aristas) {
			int vert1 = indexMap.get(arista.getOrigen());
			int vert2 = indexMap.get(arista.getDestino());

			if(uf.find(vert1) != uf.find(vert2)) {
				uf.union(vert1, vert2);
				ret.agregarArista(arista);
			}
		}
		return ret;
	}

}
