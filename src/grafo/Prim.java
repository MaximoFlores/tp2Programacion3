package grafo;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Prim {
	public static Grafo ejecutarPrim(Grafo g) {
		HashSet<Integer> vertVisitados = new HashSet<Integer>();
		Grafo ret = new Grafo();	
		PriorityQueue<Arista> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.getPeso()));
		int verticeInicio = g.listaAristas().get(0).getOrigen();

		vertVisitados.add(verticeInicio);
		pq.addAll(g.getVecinos(verticeInicio));
		while (!pq.isEmpty()) {
			Arista aristaPesoMin = pq.poll();

			if (vertVisitados.contains(aristaPesoMin.getDestino())) {
				continue;
			}
			ret.agregarArista(aristaPesoMin);
			vertVisitados.add(aristaPesoMin.getDestino());

			for (Arista arista : g.getVecinos(aristaPesoMin.getDestino())) {
				if (!vertVisitados.contains(arista.getDestino())) 
					pq.offer(arista);

			}
		}
		return ret;
	}
}
