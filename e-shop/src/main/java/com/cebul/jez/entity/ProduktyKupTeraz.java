package com.cebul.jez.entity;

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
	private Integer dataKupna;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IdKupca")
	private User kupiec;
	
	public ProduktyKupTeraz() {
		
	}
	public ProduktyKupTeraz(String nazwa, String opis, Integer idKat, Integer idZdjglow,
			Integer idWlasci)
	{
		
	}
	public User getKupiec() {
		return kupiec;
	}
	public void setKupiec(User kupiec) {
		this.kupiec = kupiec;
	}
	public Integer getDataKupna() {
		return dataKupna;
	}
	public void setDataKupna(Integer dataKupna) {
		this.dataKupna = dataKupna;
	}
	
	
	
}
