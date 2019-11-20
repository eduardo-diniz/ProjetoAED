package Gerador;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.text.View;

import org.graphstream.graph.Node;
import org.graphstream.ui.swingViewer.ViewPanel;
import org.graphstream.ui.view.Viewer;

import com.sun.jdi.event.Event;

public class Main {
	public static void main(String[] args) {
		System.setProperty("gs.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
		 JFrame frame = new JFrame();
	        frame.setLayout(new GridLayout());
	        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);        
	        frame.setBounds(0, 0, 700, 500);
	        frame.setPreferredSize(new Dimension(700, 500));
            
	        JPanel panel = new JPanel();
	        panel.setLayout(new GridLayout());
	        frame.add(panel);
	        
		GraphFile Nodes = new GraphFile("C:\\Users\\Eduar\\Desktop\\PROJETO AED\\GraphsAED\\CIDADES.txt");
		GraphFile Edges = new GraphFile("C:\\Users\\Eduar\\Desktop\\PROJETO AED\\GraphsAED\\Arestas.txt");
		
		Nodes.setArquivo();
		Nodes.setListaNode();
		Edges.setArquivo();
		Edges.setListaNode();
		//Edges.dados();
		//Edges.imprimirArquivo();
		Gerador geradorNode = new Gerador(Nodes.getLista());
		geradorNode.setMapa();
		GeradorAresta geradorEdge = new GeradorAresta(geradorNode.getMapa(),Edges.getLista());
		geradorNode.getMapa().setStrict(false);
		geradorEdge.setArestas();
		//geradorEdge.getMapa().display();
		for (Node node : geradorNode.getMapa()) {
	        node.addAttribute("ui.label", node.getId());
	        node.addAttribute("ui.class", "important");
	    }


		geradorEdge.getMapa().addAttribute("ui.quality");
		geradorEdge.getMapa().addAttribute("ui.antialias");
			
		Viewer viewer = new Viewer(geradorEdge.getMapa(), Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
		//viewer = geradorEdge.getMapa().display();
		viewer.enableAutoLayout();
		ViewPanel view = viewer.addDefaultView(true);
		Rectangle rec = panel.getBounds();
		view.setBounds(0, 0, rec.width, rec.height);
		view.setPreferredSize(new Dimension(rec.width, rec.height));
		view.getCamera().setViewPercent(0.8);
		panel.add(view);
		frame.setVisible(true);
		
	}

}
