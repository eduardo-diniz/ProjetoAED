import org.graphstream.graph.Graph;

public class MATRIZ_ADJ {
	
	private int nodeCount;
	private Graph grafo;
	private byte adjMatriz[][];

	public void criarMatriz(Graph grafo, int tam)
	{
		setNodeCount(tam);
		this.adjMatriz = new byte[getNodeCount()][getNodeCount()];
		for(int i = 0; i < getNodeCount(); i++)
		{
			for(int j = 0; j < getNodeCount(); j++)
			{
				this.adjMatriz[i][j] = (byte) (grafo.getNode(i).hasEdgeBetween(j) ? 1 : 0);
			}
		}
	}
	
	public void imprimirMatriz()
	{
		for(int i = 0; i < getNodeCount(); i++)
		{
			for(int j = 0; j < getNodeCount(); j++)
			{
				System.out.print(adjMatriz[i][j] + " ");
			}
			System.out.println();
		}
			
	}

	public int getNodeCount() {
		return nodeCount;
	}

	public void setNodeCount(int nodeCount) {
		this.nodeCount = nodeCount;
	}

	public Graph getGrafo() {
		return grafo;
	}

	public void setGrafo(Graph grafo) {
		this.grafo = grafo;
	}

	public byte[][] getAdjMatriz() {
		return adjMatriz;
	}

	public void setAdjMatriz(byte[][] adjMatriz) {
		this.adjMatriz = adjMatriz;
	}

	/* int adj = Europa.getNodeCount();
	 byte adjMatriz[][] = new byte[adj][adj];
	for(int i = 0; i < adj; i++)
	{
		for(int j = 0; j < adj; j++)
		{
			adjMatriz[i][j] = (byte) (Europa.getNode(i).hasEdgeBetween(j) ? 1 : 0);
		}
	}
	for(int i = 0; i < adj; i++)
	{
		for(int j = 0; j < adj; j++)
		{
			System.out.print(adjMatriz[i][j] + " ");
		}
		System.out.println();
	}*/
	
	
	
	

}
