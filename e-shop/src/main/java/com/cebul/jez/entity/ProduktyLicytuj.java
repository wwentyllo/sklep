package com.cebul.jez.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ProduktyLicytuj")
@PrimaryKeyJoinColumn(name="Id")
public class ProduktyLicytuj extends Produkty implements Serializable
{
	@Column(name="DataZakonczenia")
	@NotNull
	private Date dataZakonczenia;
	

	public ProduktyLicytuj()
	{
		super();
	}
	public ProduktyLicytuj(String nazwa, String opis, Double cena, Date data, Kategoria kategoria,
			Zdjecie zdjecie, User user, Date dataZakonczenia)
	{
		super(nazwa, opis, cena, data, kategoria, zdjecie, user);
		this.dataZakonczenia = dataZakonczenia;
		
	}
	
	public Date getDataZakonczenia() {
		return dataZakonczenia;
	}

	public void setDataZakonczenia(Date dataZakonczenia) {
		this.dataZakonczenia = dataZakonczenia;
	}

	
	
	
	
}
