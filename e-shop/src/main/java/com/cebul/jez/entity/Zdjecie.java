package com.cebul.jez.entity;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Zdjecia")
public class Zdjecie 
{
	@Id
	@GeneratedValue
	@Column(name="Id")
	private Integer id;
	
	@Column(name="Zdjecie", columnDefinition="BLOB")
	private File zdjecie;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public File getZdjecie() {
		return zdjecie;
	}

	public void setZdjecie(File zdjecie) {
		this.zdjecie = zdjecie;
	}
	
	
}
