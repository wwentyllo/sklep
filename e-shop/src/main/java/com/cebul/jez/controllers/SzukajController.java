package com.cebul.jez.controllers;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cebul.jez.entity.Produkty;
import com.cebul.jez.service.ProduktyService;
import com.cebul.jez.useful.JsonObject;


@Controller
@RequestMapping("/szukaj/szukaj.json")
public class SzukajController 
{
	@Autowired
	private ProduktyService produktyService;
	
	@RequestMapping(method = RequestMethod.GET, params="slowo")
	public @ResponseBody JsonObject znajdzWyszukiwarka(Model model, @RequestParam String slowo) 
	{
		List<String> r = produktyService.getProduktyLike(slowo);
		JsonObject jso = new JsonObject();
		jso.generateProdukty(r);
		
		return jso;
	}
	
}
