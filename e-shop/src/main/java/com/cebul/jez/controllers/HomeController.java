package com.cebul.jez.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cebul.jez.entity.Kategoria;
import com.cebul.jez.entity.Produkty;
import com.cebul.jez.entity.ProduktyKupTeraz;
import com.cebul.jez.entity.User;
import com.cebul.jez.model.UserDao;
import com.cebul.jez.service.KategorieService;
import com.cebul.jez.service.ProduktyService;
import com.cebul.jez.service.TestDataBaseService;
import com.cebul.jez.service.UserService;
import com.cebul.jez.useful.Mail;

/**
 * 
 * @author Mateusz Cebularz
 * Klasa pelniaca zadanie kontrolera w modelu MVC
 * Jej zadaniem jest obsługa rządań z ścieżki "/" oraz "/home"
 * Wykorzystuje mechanizm DI do wstrzykiwania zależnosći
 */
@Controller
public class HomeController {
	
	@Autowired
	private KategorieService kategorieService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TestDataBaseService dbService;
	
	@Autowired
	private ProduktyService produktyService;
	
	@Autowired
	private TestDataBaseService serv;
		
	/**
	 * 
	 * @param model jest to odniesienie do obiektu modelu
	 * @return zwraca logiczną nazwę widoku
	 */
	@RequestMapping(value = {"/", "/home"})
	public String home(Model model, HttpSession session){
		
		//dbService.test1();
		//List<Produkty> r = produktyService.getProduktyLike("drug", 19);
		//System.out.println(r.size());
		//Produkty pro =  r.get(0);
		//System.out.println(pro.getNazwa());
		
		//serv.test1();
		
		//System.out.println(new Date().after(new Date()));
		
		List<Kategoria> kat = kategorieService.getMainKategory();
		//model.addAttribute("kategoryList", kat);
		session.setAttribute("kategoryList", kat);
		
		HashMap<Integer, List<Kategoria>> podkategorie = new HashMap<Integer, List<Kategoria>>();
		for(Kategoria k : kat)
		{
			podkategorie.put(k.getId(), kategorieService.getPodKategory(k.getId()) );
		}
		
		
		//userService.saveUser();
		//System.out.println(kat.get(0).getParentKategory().);
		
		
		return "home";
	}
	
}
