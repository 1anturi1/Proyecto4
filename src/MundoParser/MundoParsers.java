package MundoParser;

import java.util.*;


import proyecto4.*;


public class MundoParsers {

	// Nombres de los Parsers
	private  ArrayList  <String> parsers  = new ArrayList <String> (); 

	// Parser que se est� usando
	private int currentParser;


	public  MundoParsers () {

		// Agreguen al final de esta lista los nombres del nuevo parser

		parsers.add("Bibtex");
	

		currentParser =  0;

	}

	public Bibtex getBibtex(){
		return new Bibtex(System.in);
	}

	public String getStringCurrentParser(){
		return parsers.get(currentParser);
	}

	public int getCurrentParser() {
		return currentParser;
	}

	public void setCurrentParser(int p) {
		currentParser = p;
	}

	public String getParser(int i) {
		return parsers.get(i);
	}

	public int sizeParsers() {
		return parsers.size();
	}

	public String  procesarCadena(String texto) {
		String resp = "";
		if(parsers.get(currentParser).equals("Bibtex"))
		{
			Bibtex bib = getBibtex();			
			bib.ReInit(new java.io.StringReader(texto));
			try {
				int v = bib.one_line(); 
				resp = new String("OK    \n");
			}catch (Exception e) {
				resp = new String ("Error de Sintaxis: "+e.getMessage());
			} catch (Error e) {
				resp = new String ("Error Lexico: "+e.getMessage());
			}
		}

		return "\n SISTEMA " + parsers.get(currentParser) + ": " + resp + "\n";
	}

}
