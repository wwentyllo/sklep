package com.cebul.jez.flows;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cebul.jez.entity.Kategoria;
import com.cebul.jez.entity.ProduktyKupTeraz;
import com.cebul.jez.entity.User;
import com.cebul.jez.model.UserDao;
import com.cebul.jez.service.KategorieService;
import com.cebul.jez.service.ProduktyService;
import com.cebul.jez.service.UserService;

@Component("flowDodajProdukt")
public class FlowDodajProdukt implements Serializable
{

	@Autowired
	private UserShortInfo usinfo;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private KategorieService kategorieService;
	
	@Autowired
	private ProduktyService produktyService;
	
	private List<Kategoria> katDodaj;
	
	private Integer kategoriaId;
	
	private Integer podkategoriaId;
	
	private String dezycja;
	
		
	public String getDezycja() {
		return dezycja;
	}
	public void setDezycja(String dezycja) {
		this.dezycja = dezycja;
	}
	public List<Kategoria> getKatDodaj() {
		return katDodaj;
	}
	public void setKatDodaj(List<Kategoria> katDodaj) {
		this.katDodaj = katDodaj;
	}
	public boolean sprawdzUsera()
	{
		if(usinfo.getId() == null)
			return true;
		return true;
	}
	public Date getCurrDate()
	{
		Date dat = new Date();
		SimpleDateFormat simpleDateHere = new SimpleDateFormat("yyyy-MM-dd");
         String d = simpleDateHere.format(dat);
         
		try {
			dat = simpleDateHere.parse(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(d);
		System.out.println(dat);
        return dat;
	}
	public void saveProduktK(ProduktyKupTeraz p)
	{
		produktyService.saveProduktKupTeraz(p);
	}
	public User getUser()
	{
		User u = userService.getUser(usinfo.getId());
		//System.out.println("testy Wywolania w dlowDdoaj "+usinfo.getId());
		return u;
	}
	public List<Kategoria> getMainKategory()
	{
		System.out.println("testy main kategory");
		katDodaj = 	kategorieService.getMainKategory();	
		
		return katDodaj;
	}
	public List<Kategoria> getKat()
	{
		System.out.println("testy innej kategory");
		return new ArrayList<Kategoria>();
	}
}
