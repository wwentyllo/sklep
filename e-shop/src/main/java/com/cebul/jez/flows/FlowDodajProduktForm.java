package com.cebul.jez.flows;

import java.io.Serializable;
import java.util.List;

import com.cebul.jez.entity.Kategoria;

public class FlowDodajProduktForm implements Serializable
{
	private String decyzja;
	
	private List<Kategoria> katDodaj;
	
	

	public List<Kategoria> getKatDodaj() {
		return katDodaj;
	}

	public void setKatDodaj(List<Kategoria> katDodaj) {
		this.katDodaj = katDodaj;
	}

	public String getDecyzja() {
		return decyzja;
	}

	public void setDecyzja(String decyzja) {
		this.decyzja = decyzja;
	}
	
}
