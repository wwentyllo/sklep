package com.cebul.jez.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="Adresy")
public class Adresy 
{
	@Id
	@GeneratedValue
	@Column(name="Id")
	private Integer id;
	
	@Column(name="Miejscowosc")
	@Size(min=3, max=20, message="Nie ma takiego miejsca.")
	private String miejscowosc;
	
	@Column(name="Kod_Pocztowy")
	@Size(min=6, max=6, message="Niepoprawny kod pocztowy.")
	private String kod_pocztowy;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMiejscowosc() {
		return miejscowosc;
	}

	public void setMiejscowosc(String miejscowosc) {
		this.miejscowosc = miejscowosc;
	}

	public String getKod_pocztowy() {
		return kod_pocztowy;
	}

	public void setKod_pocztowy(String kod_pocztowy) {
		this.kod_pocztowy = kod_pocztowy;
	}
	
	
}
