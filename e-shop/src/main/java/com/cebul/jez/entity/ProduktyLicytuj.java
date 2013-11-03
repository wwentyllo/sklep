package com.cebul.jez.entity;

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
public class ProduktyLicytuj extends Produkty
{
	@Column(name="DataZakonczenia")
	@NotNull
	private Date dataZakonczenia;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IdNabywcy")
	private User nabywca;

	public ProduktyLicytuj()
	{
		
	}
	public ProduktyLicytuj(String nazwa, String opis, Double cena, Date data, Kategoria kategoria,
			Zdjecie zdjecie, User user)
	{
		super(nazwa, opis, cena, data, kategoria, zdjecie, user);
		this.dataZakonczenia = new Date();
		this.nabywca = null;
	}
	
	public Date getDataZakonczenia() {
		return dataZakonczenia;
	}

	public void setDataZakonczenia(Date dataZakonczenia) {
		this.dataZakonczenia = dataZakonczenia;
	}

	public User getNabywca() {
		return nabywca;
	}

	public void setNabywca(User nabywca) {
		this.nabywca = nabywca;
	}
	
	
	
}
