package Gerador;

import java.util.ArrayList;

import org.graphstream.algorithm.generator.Generator;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.stream.SourceBase;

public class Gerador  {
	
	private MultiGraph Mapa;
	private ArrayList<String> Lista;

    public Gerador(ArrayList<String> lista) {
		super();
		this.Lista = lista;
	}

	public void setMapa() {
		
		Mapa = new MultiGraph("Mapa");
		for(int i = 0; i < this.Lista.size(); i++)
		{
			Mapa.addNode(Lista.get(i));
		}
		
		
	}

	public MultiGraph getMapa() {
		return Mapa;
	}

}
