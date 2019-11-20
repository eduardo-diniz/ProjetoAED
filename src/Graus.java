import org.graphstream.graph.*;
import org.graphstream.algorithm.Algorithm;

public class Graus implements Algorithm {
	
	Graph grafo;
	int menorGrau, maiorGrau, mediaGrau;

	public void init(Graph grafo) {
		this.grafo = grafo;
		
	}
	public void compute() {
		this.mediaGrau = 0;
		this.menorGrau = Integer.MAX_VALUE;
		this.maiorGrau = 0;
		
		for(Node n : grafo.getEachNode())
		{
			int grau = n.getDegree();
			System.out.println(grau);
			
			menorGrau = Math.min(menorGrau, grau);
			maiorGrau = Math.max(maiorGrau, grau);
			mediaGrau += grau;
		}
		
		mediaGrau /= grafo.getNodeCount();
		
	}
	
	public int getMenorGrau() {
		return menorGrau;
	}
	public int getMaiorGrau() {
		return maiorGrau;
	}
	public int getMediaGrau() {
		return mediaGrau;
	}

	

	

}
