package com.cebul.jez.controllers;

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
import com.cebul.jez.model.UserDao;
import com.cebul.jez.service.KategorieService;
import com.cebul.jez.service.UserService;
import com.cebul.jez.useful.Mail;

@Controller
public class HomeController {
	
	@Autowired
	private KategorieService kategorieService;
	
	@Autowired
	private UserService userService;
		
	@RequestMapping(value = {"/", "/home"})
	public String home(Model model){
		
		List<Kategoria> kat = kategorieService.getMainKategory();
		model.addAttribute("kategoryList", kat);
		
		HashMap<Integer, List<Kategoria>> podkategorie = new HashMap<Integer, List<Kategoria>>();
		for(Kategoria k : kat)
		{
			podkategorie.put(k.getId(), kategorieService.getPodKategory(k.getNazwa()) );
		}
		
		
		//userService.saveUser();
		//System.out.println(kat.get(0).getParentKategory().);
		
		
		return "home";
	}
	
}
