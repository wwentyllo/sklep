package com.cebul.jez.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="ProduktyKupTeraz")
@PrimaryKeyJoinColumn(name="Id")
public class ProduktyKupTeraz extends Produkty
{
	
	@Column(name="DataKupna")
	private Date dataKupna;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IdKupca")
	private User kupiec;
	
	public ProduktyKupTeraz() {
		
	}
	public ProduktyKupTeraz(String nazwa, String opis, Double cena, Date data, Kategoria kategoria,
			Zdjecie zdjecie, User user)
	{
		super(nazwa, opis, cena, data, kategoria, zdjecie, user);
		this.dataKupna = null;
		this.kupiec = null;
	}
	public User getKupiec() {
		return kupiec;
	}
	public void setKupiec(User kupiec) {
		this.kupiec = kupiec;
	}
	public Date getDataKupna() {
		return dataKupna;
	}
	public void setDataKupna(Date dataKupna) {
		this.dataKupna = dataKupna;
	}
	
	
	
}
