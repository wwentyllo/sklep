package com.cebul.jez.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Produkty")
@Inheritance(strategy=InheritanceType.JOINED)
public class Produkty {
	
	@Id
	@GeneratedValue
	@Column(name="Id")
	private Integer id;
	
	@Column(name="Nazwa")
	@NotNull
	private String nazwa;
	
	@Column(name="Opis", columnDefinition="TEXT")
	@NotNull
	private String opis;
	
	@Column(name="Cena")
	@NotNull
	private Double cena;
	
	@Column(name="DataDodania")
	@NotNull
	private Date dataDodania;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IdKat")
	private Kategoria kategorie;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IdZdjGlow")
	private Zdjecie zdjecie;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IdWlas")
	private User user;

	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(name = "prod_zdj", joinColumns = { @JoinColumn(name = "IdProdukt") }, 
	inverseJoinColumns = { @JoinColumn(name = "IdZdjecia") })
	private Collection<Zdjecie> zdjecia = new ArrayList<Zdjecie>();
	
	public Collection<Zdjecie> getZdjecia() {
		return zdjecia;
	}
	public void setZdjecia(Collection<Zdjecie> zdjecia) {
		this.zdjecia = zdjecia;
	}
	public Produkty()
	{
		
	}
	public Produkty(String nazwa, String opis, Double cena, Date data, Kategoria kategoria,
			Zdjecie zdjecie, User user)
	{
		this.nazwa = nazwa;
		this.opis = opis;
		this.cena= cena;
		this.dataDodania = data;
		this.kategorie = kategoria;
		this.zdjecie = zdjecie;
		this.user = user;
	}
	public Kategoria getKategorie() {
		return kategorie;
	}

	public void setKategorie(Kategoria kategorie) {
		this.kategorie = kategorie;
	}

	public Zdjecie getZdjecie() {
		return zdjecie;
	}

	public void setZdjecie(Zdjecie zdjecie) {
		this.zdjecie = zdjecie;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Double getCena() {
		return cena;
	}

	public void setCena(Double cena) {
		this.cena = cena;
	}

	public Date getDataDodania() {
		return dataDodania;
	}

	public void setDataDodania(Date dataDodania) {
		this.dataDodania = dataDodania;
	}
	
	
	
	
}
