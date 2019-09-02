package com.pansari.promoter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.util.Properties;

@Controller
public class HelloController {

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "dashboard";
	}

	@RequestMapping(value = "/index/{name:.+}", method = RequestMethod.GET)
	public ModelAndView index(@PathVariable("name") String name) {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		model.addObject("msg", name);
		return model;
	}

	 @RequestMapping(value = "/robots.txt", method = RequestMethod.GET)
	    public String getRobots(HttpServletRequest request) {
	        return "robotsAllowed" ;
	    }
	 @RequestMapping(value = "/.well-known/acme-challenge/GiRrxDoS8EWNC0o7v6hWiF4aHEFSIzrFRxMZhxMBeTY", method = RequestMethod.GET)
	    public String getHttpsWWW(HttpServletRequest request) {
	        return "www" ;
	    }
	 @RequestMapping(value = "/.well-known/acme-challenge/Afmj7UwdN3JSLazTiySTxUPAP0fxsudcHLrYvAG8Q10", method = RequestMethod.GET)
	    public String getHttps(HttpServletRequest request) {
	        return "https" ;
	    }
	 @RequestMapping(value = "/sendemail", method = RequestMethod.GET)
	 public String sendemail(HttpServletRequest request,String data,ModelMap model) {
	 final String username = "akshayrhundia";
		final String password = "Maxim#1234#";

		// Recipient's email ID needs to be mentioned.
	      String to = "akshayrhundia@gmail.com";//change accordingly

	      // Sender's email ID needs to be mentioned
	      String from = "akshayrhundias@gmail.com";//change accordingly
	     
	      // Assuming you are sending email through relay.jangosmtp.net
	      String host = "smtp.gmail.com";

	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "587");

	      // Get the Session object.
	      Session session = Session.getInstance(props,
	      new javax.mail.Authenticator() {
	         protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	         }
	      });

	      try {
	         // Create a default MimeMessage object.
	         Message message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.setRecipients(Message.RecipientType.TO,
	         InternetAddress.parse(to));

	         // Set Subject: header field
	         message.setSubject("Website call");

	         // Now set the actual message
	         message.setText(data);

	         // Send message
	         Transport.send(message);

	         System.out.println("Sent message successfully....");

	      } catch (MessagingException e) {
	            throw new RuntimeException(e);
	      }
	     // model.addAttribute("message", "Spring 3 MVC Hello World");
	      return "";
	 }

}