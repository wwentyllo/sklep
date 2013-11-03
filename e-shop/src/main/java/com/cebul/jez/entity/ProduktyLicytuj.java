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
@Table(name="ProduktyLicytuj")
@PrimaryKeyJoinColumn(name="Id")
public class ProduktyLicytuj extends Produkty
{
	@Column(name="DataZakonczenia")
	private Date dataZakonczenia;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IdNabywcy")
	private User nabywca;

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
