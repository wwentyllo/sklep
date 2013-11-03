package com.cebul.jez.useful;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class Mail
{
	@Autowired
	private MailSender mailSender;
	 
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
 
	public void sendMail(String from, String to, String subject, String msg) throws MessagingException {
 
		SimpleMailMessage message = new SimpleMailMessage();
 
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(msg);
		mailSender.send(message);	
		

	}
	public void sendMimeMessage(String url, String from, String[] to, String subject, String msg) throws Exception{
		  MimeMessage mime = ((JavaMailSenderImpl) this.mailSender).createMimeMessage();
		  MimeMessageHelper helper = new MimeMessageHelper(mime, true);
		  helper.setFrom(from);
		  helper.setTo(to);
		  helper.setSubject(subject);
		  
		  //String adress = "http://"+pageContext.request.serverName+":"+pageContext.request.serverPort+pageContext.request.contextPath;
		  String htmlText = "<p>Aby konto zostało aktywowane prosimy kliknąć poniższy link:</p>" +
		  		"<a href='"+url+"'>Aktywuj konto</a>";
		    helper.setText(htmlText,true);
		    ((JavaMailSenderImpl)this.mailSender).send(mime);
		    }
}
