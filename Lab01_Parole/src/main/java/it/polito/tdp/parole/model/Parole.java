package it.polito.tdp.parole.model;

import java.util.List;
import java.util.ArrayList;

public class Parole {
	private List<String> parole;
		
	public Parole() {
		this.parole = new ArrayList<String>();
	}
	
	public void addParola(String p) {
		this.parole.add(p);
	}
	
	public List<String> getElenco() {
		return this.parole;
	}
	
	public void reset() {
		this.parole = new ArrayList<String>();
	}

}
