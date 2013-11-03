package com.cebul.jez.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="kategorie")
public class Kategoria 
{
	@Id
	@GeneratedValue
	@Column(name="Id")
	private int id;
	
	@Column(name="Nazwa")
	@NotNull
	private String Nazwa;
	
	@Column(name="IdParentKat")
	private Integer idParentKat;
	
	@OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="Id")
	private Kategoria parentKategory;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNazwa() {
		return Nazwa;
	}

	public void setNazwa(String nazwa) {
		Nazwa = nazwa;
	}
	
	public Kategoria getParentKategory() {
		return parentKategory;
	}

	public void setParentKategory(Kategoria parentKategory) {
		this.parentKategory = parentKategory;
	}
	
	
}
