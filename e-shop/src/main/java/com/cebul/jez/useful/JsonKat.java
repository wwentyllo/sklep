package com.cebul.jez.useful;

import java.util.List;

import com.cebul.jez.entity.Kategoria;

public class JsonKat 
{
	private Kategoria kategorie[];

	public Kategoria[] getKategorie() {
		return kategorie;
	}

	public void setKategorie(Kategoria[] kategorie) {
		this.kategorie = kategorie;
	}
	
	public void generateKategorie(List<Kategoria> k)
	{
		int size = k.size();
		kategorie = k.toArray(new Kategoria[size]);
	}
}
