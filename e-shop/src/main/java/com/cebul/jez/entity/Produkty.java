package com.cebul.jez.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Produkty")
@Inheritance(strategy=InheritanceType.JOINED)
public class Produkty {
	
	@Id
	@GeneratedValue
	@Column(name="Id")
	private Integer id;
	
	@Column(name="Nazwa")
	private String nazwa;
	
	@Column(name="Opis")
	private String opis;
	
	@Column(name="IdKat")
	private Integer idKat;
	
	@Column(name="IdZdjGlow")
	private Integer idZdjGlow;
	
	@Column(name="IdWlas")
	private Integer idWlas;
	
	@Column(name="Cena")
	private Integer cena;
	
	@Column(name="DataDodania")
	private Date dataDodania;
	
	@OneToOne(fetch=FetchType.EAGER)
	private Kategoria kategorie;
	
	@OneToOne(fetch=FetchType.LAZY)
	private Zdjecie zdjecie;
	
	@OneToOne(fetch=FetchType.LAZY)
	private User user;

	
	
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

	public Integer getIdKat() {
		return idKat;
	}

	public void setIdKat(Integer idKat) {
		this.idKat = idKat;
	}

	public Integer getIdZdjGlow() {
		return idZdjGlow;
	}

	public void setIdZdjGlow(Integer idZdjGlow) {
		this.idZdjGlow = idZdjGlow;
	}

	public Integer getIdWlas() {
		return idWlas;
	}

	public void setIdWlas(Integer idWlas) {
		this.idWlas = idWlas;
	}

	public Integer getCena() {
		return cena;
	}

	public void setCena(Integer cena) {
		this.cena = cena;
	}

	public Date getDataDodania() {
		return dataDodania;
	}

	public void setDataDodania(Date dataDodania) {
		this.dataDodania = dataDodania;
	}
	
	
	
	
}
