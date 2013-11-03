package com.cebul.jez.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Komentarze")
public class Komentarz 
{

	@Id
	@GeneratedValue
	@Column(name="Id")
	private Integer id;
	
	@Column(name="IdNadaw")
	private Integer idNad;
	
	@Column(name="IdOdb")
	private Integer idOdb;
	
	@Column(name="Komentarz", columnDefinition="TEXT")
	private String komentarz;
	
	@Column(name="Ocena")
	private Integer ocena;
	
	
	@OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="Id")
	private User nadawca;
	
	@OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="Id")
	private User odbiorca;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdNad() {
		return idNad;
	}
	public void setIdNad(Integer idNad) {
		this.idNad = idNad;
	}
	public Integer getIdOdb() {
		return idOdb;
	}
	public void setIdOdb(Integer idOdb) {
		this.idOdb = idOdb;
	}
	public String getKomentarz() {
		return komentarz;
	}
	public void setKomentarz(String komentarz) {
		this.komentarz = komentarz;
	}
	public Integer getOcena() {
		return ocena;
	}
	public void setOcena(Integer ocena) {
		this.ocena = ocena;
	}
	
	
}
