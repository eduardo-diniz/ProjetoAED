
import java.util.Collection;
import java.util.Iterator;

import org.graphstream.algorithm.generator.Generator;
import org.graphstream.algorithm.generator.RandomGenerator;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.graph.implementations.SingleGraph;

public class GS {

	public static void main(String[] args) {
		
Graph Europa = new SingleGraph("grafo");
		
		Europa.addNode("Sevilha");
		Europa.addNode("Berlim");
		Europa.addNode("Fårö");
		Europa.addNode("Helsinque");
		Europa.addNode("Dublin");
		Europa.addNode("Amsterdã");
		
		Europa.setStrict(false);
		Europa.setAutoCreate( true);
		
		Europa.addEdge("Sevilha-Berlim", "Sevilha", "Berlim");
		Europa.addEdge("Berlim-Amsterdã", "Berlim", "Amsterdã");
		Europa.addEdge("Amsterdã-Dublin", "Amsterdã", "Dublin");
		//Europa.addEdge("Dublin-Helsinque", "Dublin", "Helsinque");
		//Europa.addEdge("Helsinque-Fårö", "Helsinque", "Fårö");
		//Europa.addEdge("Fårö-Praga", "Fårö", "Praga");// criado
		int nodesCount = Europa.getNodeCount();
		
		
		/*Node A = Europa.getNode("Sevilha");
		Edge E = Europa.getEdge("Helsinque-Fårö");
		System.out.println(A.getDegree());
		System.out.println(A.getId());
		System.out.println(A.hasEdgeToward("Amsterdã"));
		System.out.println(E.isDirected());*/
		/*for(Edge n:Europa.getEachEdge())
		{
			System.out.println(n.getId());
		}*/
		
		Collection<Node> nodes = Europa.getNodeSet();//read only copy
		Collection<Edge> edges = Europa.getEdgeSet();
		//System.out.println(nodes);
		//System.out.println(edges + "\n");
		
		/*Iterator<? extends Node> nodes2 = Europa.getNodeIterator();
		while(nodes2.hasNext())
		{
			Node node = nodes2.next();
			System.out.println(node);
		}*/
		Iterator<? extends Edge> edgesIt = Europa.getEdgeIterator();//read only copy
		while(edgesIt.hasNext())
		{
			Edge edge = edgesIt.next();
			//System.out.println(edge);
		}
		
		for(int i = 0; i < Europa.getNodeCount(); i++)
		{
			Node node = Europa.getNode(i);
			//System.out.println(node);
		}
		MATRIZ_ADJ adjunta = new MATRIZ_ADJ();
		adjunta.criarMatriz(Europa, Europa.getNodeCount());
		adjunta.imprimirMatriz();
		


	}

}
