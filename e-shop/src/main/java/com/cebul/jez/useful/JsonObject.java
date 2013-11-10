package com.cebul.jez.useful;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.mapping.Array;

import com.cebul.jez.entity.Produkty;

public class JsonObject 
{
	private String produkty[];

	public String[] getProdukty() {
		return produkty;
	}

	public void setProdukty(String[] produkty) {
		this.produkty = produkty;
	}
	public void generateProdukty(List<String> p)
	{
		int size = p.size();
		produkty = p.toArray(new String[size]);
	}
	
}
