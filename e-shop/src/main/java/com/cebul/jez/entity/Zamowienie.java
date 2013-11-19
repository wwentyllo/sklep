package com.cebul.jez.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Zamowienie 
{
	@Id
	@GeneratedValue
	@Column(name="Id")
	private Integer id;
	
	@Column(name="Data")
	@NotNull
	private Date data;
	

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="DokumentZamowienia")
	private DokumentZamowienia dokumentZamowienia;
	

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Nabywca")
	private User nabywca;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public DokumentZamowienia getDokumentZamowienia() {
		return dokumentZamowienia;
	}

	public void setDokumentZamowienia(DokumentZamowienia dokumentZamowienia) {
		this.dokumentZamowienia = dokumentZamowienia;
	}

	public User getNabywca() {
		return nabywca;
	}

	public void setNabywca(User nabywca) {
		this.nabywca = nabywca;
	}
	
	
	
}
