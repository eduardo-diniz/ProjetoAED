package Gerador;

import java.util.ArrayList;

import org.graphstream.graph.implementations.MultiGraph;

public class GeradorAresta {
	
	private MultiGraph Mapa;
	private ArrayList<String> Lista;

    public GeradorAresta(MultiGraph multiGraph, ArrayList<String> lista) {
		super();
		this.Mapa = multiGraph;
		this.Lista = lista;
	}
	
    public void setArestas() {
    	
    	for(int i = 0; i < this.Lista.size(); i+=2)
		{
			Mapa.addEdge(Lista.get(i) + "--" + Lista.get(i+1),Lista.get(i), Lista.get(i+1));
		}
		
	}
	
	public MultiGraph getMapa() {
		return Mapa;
	}

}
