package com.cebul.jez.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cebul.jez.entity.Kategoria;
import com.cebul.jez.service.KategorieService;
import com.cebul.jez.useful.JsonKat;
import com.cebul.jez.useful.JsonObject;

@Controller
@RequestMapping("/dodajProdukt/podkategorie.json")
public class DodajProduktyController 
{
	@Autowired
	private KategorieService kategorieService;
	
	@RequestMapping(method = RequestMethod.GET, params="podkategory")
	public @ResponseBody JsonKat znajdzWyszukiwarka(Model model, @RequestParam Integer podkategory) 
	{
		List<Kategoria> r = kategorieService.getPodKategory(podkategory);
		JsonKat jso = new JsonKat();
		jso.generateKategorie(r);
		
		return jso;
	}
}
