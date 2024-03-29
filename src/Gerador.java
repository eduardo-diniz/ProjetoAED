import org.graphstream.algorithm.generator.Generator;
import org.graphstream.graph.Node;
import org.graphstream.stream.SourceBase;

public class Gerador extends SourceBase implements Generator {
	
	
    int currentIndex = 0;
    int edgeId = 0;

    public void begin() {
       addNode();
       
    }

    public boolean nextEvents() {
       addNode();
       
       return true;
    }
 
    public void end() {
       // Nothing to do
    }
 
    protected void addNode() {
       sendNodeAdded(sourceId, Integer.toString(currentIndex));
 
       for(int i = 0; i < currentIndex; i++)
          sendEdgeAdded(sourceId, Integer.toString(edgeId++),
                Integer.toString(i), Integer.toString(currentIndex), false);
 
       currentIndex++;
    }


}
