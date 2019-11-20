import java.util.HashMap;

import org.graphstream.algorithm.DynamicAlgorithm;
import org.graphstream.graph.Graph;
import org.graphstream.stream.SinkAdapter;

public class AP extends SinkAdapter implements DynamicAlgorithm  {
	
	private Graph grafo;
	private HashMap<String, Integer> apparitions;
	private double media;
	
	public void init(Graph grafo)
	{
		this.grafo = grafo;
		media = 0;
		grafo.addSink(this);
	}
	
	public void compute()
	{
		this.media = 0;
		for(int a : apparitions.values())
		{
			media += a;
			media /= apparitions.size();
		}
	}
	
	public void terminate()
	{
		this.grafo.removeSink(this);
	}
	
	public double getAverageApparitions() 
	{
		return media;
	}
	
	public int getApparitions(String nodeId) 
	{
		return apparitions.get(nodeId);
	}
	public void nodeAdded(String sourceId, long timeId, String nodeId) 
	{
		int a = 0;
		if (apparitions.containsKey(nodeId))
		{
			a = apparitions.get(nodeId);
		}
		
		apparitions.put(nodeId, a + 1);
	 }
	public void stepBegins(String sourceId, long timeId, double step) 
	{
		compute();
	}
	
	

}
