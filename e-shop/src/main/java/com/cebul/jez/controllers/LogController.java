package com.cebul.jez.controllers;



import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cebul.jez.entity.User;
import com.cebul.jez.model.UserDao;

@Controller
public class LogController
{

	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value = "/logowanie")
	public String home(Model model, HttpSession session) 
	{
		if(isUserLogged(session))
			return "redirect:/home";
		
		return "logowanie";
	}
	@RequestMapping(value = "/logowanie/setUserSession")
	public String setSessionUser(Model model, HttpSession session, HttpServletRequest request) 
	{
		if(isUserLogged(session))
			return "redirect:/home";
		
		Principal principal = request.getUserPrincipal();
		String userName = principal.getName();
		User u = userDao.getUser(userName);
		session.setAttribute("sessionUser", u);
		return "redirect:/home";
	}
	@RequestMapping(value = "/login", method=RequestMethod.GET, params="login_error" )
	public String errorLogin(@RequestParam String login_error, HttpSession session)
	{
		if(isUserLogged(session))
			return "redirect:/home";
		
		return "loginError";
	}
	public boolean isUserLogged(HttpSession session)
	{
		User u = (User) session.getAttribute("sessionUser");
		if(u != null)
			return true;
		return false;
	}
}
