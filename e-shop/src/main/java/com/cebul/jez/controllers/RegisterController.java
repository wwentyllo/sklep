package com.cebul.jez.controllers;

import javax.mail.MessagingException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cebul.jez.entity.User;
import com.cebul.jez.service.UserService;
import com.cebul.jez.useful.Mail;

@Controller
public class RegisterController 
{

	@Autowired
	UserService userService;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private Mail mail;
	
	@RequestMapping(value = "/rejestracja")
	public String regForm(Model model,  HttpSession session) 
	{
		if(isUserLogged(session))
			return "redirect:/home";
		
		model.addAttribute(new User());
		return "rejestracja";
	}
	@RequestMapping(value = "/rejestracja/active", method=RequestMethod.GET)
	public String confirmReg(Model model, @RequestParam Integer userId,  HttpSession session) 
	{
		if(isUserLogged(session))
			return "redirect:/home";
		
		userService.activeUser(userId);
		return "confirmReg";
	}
	@RequestMapping(value="/rejestracja", method=RequestMethod.POST)
	public String addUserForForm(@Valid User user, BindingResult bindingResult, Model model, HttpServletRequest request,  HttpSession session) throws Exception
	{
		if(isUserLogged(session))
			return "redirect:/home";
		
		if(bindingResult.hasErrors())
		{
			//System.out.println("hasło has error: "+user.getPass());
			return "/rejestracja";
		}
		//System.out.println("hasło: "+user.getPass());
		boolean itsDone = userService.addUser(user);
		if(!itsDone)
		{
			return "/rejestracja";
		}
		
		// jesli wszytsko jest ok to wyslij maila
		try {
			String [] t = {user.getEmail()};
			String str = request.getScheme() +"://"+ request.getServerName()+ ":"+
					request.getServerPort() +request.getContextPath()+
					"/rejestracja/active?userId="+user.getId(); 
			mail.sendMimeMessage(str,"eshoptest123@gmail.com", t, "Rejestracja e-shop", "takie sobie cos tam");
		
			// ustawienie sessji
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return "redirect:/home/";
	}
	public boolean isUserLogged(HttpSession session)
	{
		User u = (User) session.getAttribute("sessionUser");
		if(u != null)
			return true;
		return false;
	}
	
}
