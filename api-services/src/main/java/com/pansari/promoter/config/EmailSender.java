package com.pansari.promoter.config;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

import com.pansari.promoter.controller.RealtimeController;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Attachments;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Properties;
import java.util.logging.Logger;

@Component
public class EmailSender {
	
	private static final Logger logger = Logger.getLogger(EmailSender.class.getName());
	private static final Email from = new Email("promoters.pansari@gmail.com");

    
public static void main(String args[]) throws AddressException,
          MessagingException {

//    sendEmail("/Users/pagarwal/Desktop/1.xlsx");
  }


  public static void sendEmail(String fileName, byte[] fileData) throws AddressException, MessagingException {
   
    String emailSubject = fileName;
    String emailBody = "PFA attached " + fileName;
   
    final String sendgridApiKey = System.getenv("SENDGRID_API_KEY");
    final String sendgridSender = System.getenv("SENDGRID_SENDER");
    
    Email to = new Email("agarwal.prateek10@gmail.com");
    Content content = new Content("text/plain", emailBody);
    
    Mail mail = new Mail(from, emailSubject, to, content);

    File file = new File(fileName);
//    byte[] fileData = null;
//    try {
//        fileData = org.apache.commons.io.IOUtils.toByteArray(new FileInputStream(file));
//    } catch (IOException ex) {
//    	logger.warning("Error while reading the file - " + fileName);
//    }

    Attachments attachment = new Attachments();   
    Base64 x = new Base64();
    String imageDataString = x.encodeAsString(fileData);
    attachment.setContent(imageDataString);
    attachment.setType("application/vnd.openxmlformats-officedocument.spreadsheetml.template");//"For xlsx"
    attachment.setFilename(fileName);
    attachment.setDisposition("attachment");
    attachment.setContentId("Banner");
    mail.addAttachments(attachment);
    
    SendGrid sg = new SendGrid(sendgridApiKey);
    Request request = new Request();
    try {
      request.setMethod(Method.POST);
      request.setEndpoint("mail/send");
      request.setBody(mail.build());
      Response response = sg.api(request);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
      int statusCode = response.getStatusCode();
      if (statusCode >= 400 && statusCode <600){
    	  logger.warning("Failed : HTTP error code : "
                  + statusCode + ", entity-content : " + response.getBody());
      }
      else {
    	  logger.info(emailSubject + " Email sent successfully to " + to.getEmail()  +
    			    " from - "+ from.getEmail() + 
    			  " with status code - "+ statusCode);
      }
    } catch (IOException ex) {
    	logger.warning("Error while sending "+emailSubject+
    			 " from - "+ from.getEmail() + 
    			" email to - +" + to.getEmail() +" with error - " +ex.getMessage());
    }

  }
  
  public static void sendTestEmail(String subject) throws AddressException, MessagingException {
	  logger.info("Started ABClog");

	    final String sendgridApiKey = System.getenv("SENDGRID_API_KEY");
	    final String sendgridSender = System.getenv("SENDGRID_SENDER");
	    
	    final String toEmail = "agarwal.prateek10@gmail.com";
	    Email to = new Email(toEmail);
	    Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
	    Mail mail = new Mail(from, subject, to, content);

//	    File file = new File("/Users/pagarwal/code/1.xlsx");
//        byte[] fileData = null;
//        try {
//            fileData = org.apache.commons.io.IOUtils.toByteArray(new FileInputStream(file));
//        } catch (IOException ex) {
//        }

//        Attachments attachments3 = new Attachments();   
//        Base64 x = new Base64();
//        String imageDataString = x.encodeAsString(fileData);
//        attachments3.setContent(imageDataString);
//        attachments3.setType("application/vnd.openxmlformats-officedocument.spreadsheetml.template");//"application/pdf"
//        attachments3.setFilename("x.xlsx");
//        attachments3.setDisposition("attachment");
//        attachments3.setContentId("Banner");
//        mail.addAttachments(attachments3);
//        
	    SendGrid sg = new SendGrid(sendgridApiKey);
	    Request request = new Request();
	    try {
	      request.setMethod(Method.POST);
	      request.setEndpoint("mail/send");
	      request.setBody(mail.build());
	      Response response = sg.api(request);
	      System.out.println(response.getStatusCode());
	      System.out.println(response.getBody());
	      System.out.println(response.getHeaders());
	    } catch (IOException ex) {
	    	logger.info("ABC -"+ex.getMessage());

	    }
	    logger.info("ENDED ABC");
	   
  }

}
