package com.cebul.jez.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cebul.jez.entity.Kategoria;
import com.cebul.jez.entity.Produkty;
import com.cebul.jez.entity.Zdjecie;
import com.cebul.jez.service.KategorieService;
import com.cebul.jez.service.ProduktyService;

@Controller
public class ProduktyController 
{
	@Autowired
	private ProduktyService produktyService;
	
	@Autowired
	private KategorieService kategorieService;
	
	@RequestMapping(value = {"/produkty/{produktId}/"}, method = RequestMethod.GET)
	public String infoProdukt(@PathVariable Integer produktId, Model model, HttpSession session){
		
		Produkty produkt = produktyService.getProdukt(produktId);
		//Collection<Zdjecie> zdjecia = produkt.getZdjecia();
		Collection<Integer> zdjecia = produktyService.getZdjeciaId(produkt); 
		
		Kategoria katGlow = kategorieService.getMainKategory(produkt.getKategorie().getParentKategory());
		String path = katGlow.getNazwa()+" >>> "+produkt.getKategorie().getNazwa();
		List<Kategoria> podkategorie = kategorieService.getPodKategory(katGlow.getId());
		
		model.addAttribute("podkategorie", podkategorie);
		model.addAttribute("produkt", produkt);
		model.addAttribute("path", path);
		model.addAttribute("zdjecia", zdjecia);
		
		return "produkt";
	}
	@RequestMapping(value = {"/produkty"})
	public String ksadka(Model model)
	{
		return "produkt";
	}
	@ResponseBody
	@RequestMapping(value = "/prodimag/{prodimageId}", method = RequestMethod.GET, produces="prodimag/*")
	public void getProdImage(@PathVariable Integer prodimageId, HttpServletResponse response, HttpServletRequest request, 
			HttpSession session, Model model) throws IOException {
	    response.setContentType("image/jpeg");
	    
	    Zdjecie requestedImage = produktyService.getZdjecie(prodimageId);

		    InputStream in= new ByteArrayInputStream(requestedImage.getZdjecie()); 
		    //System.out.println("input: "+in);
		    if (in != null) {
		        IOUtils.copy(in, response.getOutputStream());  
		    }
	   
	}
}
