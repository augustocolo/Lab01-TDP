package it.polito.tdp.parole.model;

import java.util.List;
import java.util.Collections;
import java.util.LinkedList;

public class Parole {
	private List<String> parole;
		
	public Parole() {
		this.parole = new LinkedList<String>();
	}
	
	public void addParola(String p) {
		this.parole.add(p);
		Collections.sort(this.parole);
	}
	
	public List<String> getElenco() {
		return this.parole;
	}
	
	public void reset() {
		this.parole = new LinkedList<String>();
	}
	
	public boolean cancella(String s) {
		return this.parole.remove(s);
	}

}
