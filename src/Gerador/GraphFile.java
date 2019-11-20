package Gerador;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GraphFile {
	private File Arquivo;
	private String Caminho;
	private ArrayList<String> Lista;

	public GraphFile(String caminho) {
		super();
		this.Caminho = caminho;
	}
	
	public boolean setArquivo() {
		
		File file = new File(this.Caminho);
		if(file.exists())
		{
			this.Arquivo = file;
			return true;
		} else {
			return false;
		}
	}
	
	public void imprimirArquivo()
	{
		try 
		{
			Scanner scan = new Scanner(this.Arquivo);
			int indice = 1;
			while(scan.hasNextLine())
			{
				String cidade = scan.nextLine();
				System.out.println("Cidade " + indice + " " + cidade);
				indice++;
			}
			scan.close();
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void setListaNode()
	{
		try 
		{
			Scanner scan = new Scanner(this.Arquivo);
			this.Lista = new ArrayList<String>();
			while(scan.hasNextLine())
			{
				this.Lista.add(scan.nextLine());
			}
			scan.close();
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
	}
	public void imprimirLista()
	{
		System.out.println(this.Lista);		
	}
	
	public void dados()
	{
		if(Arquivo.exists())
		{
			System.out.println("Nome: " + Arquivo.getName());
			System.out.println ("Caminho: " + Arquivo.getAbsolutePath()); 
		    System.out.println("Pode escrever?: " + Arquivo.canWrite());
		    System.out.println("Pode ler?: " + Arquivo.canRead()); 
		    System.out.println("Tamanho em bytes: " + Arquivo.length());
		} else
		{
			System.out.println("Arquivo não existe");
		}
		
	}

	public ArrayList<String> getLista() {
		return Lista;
	}

	

	

}


