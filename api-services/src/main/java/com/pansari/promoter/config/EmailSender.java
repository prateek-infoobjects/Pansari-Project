package com.pansari.promoter.config;

import org.springframework.stereotype.Component;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Arrays;
import java.util.Properties;

@Component
public class EmailSender {

  private static final String password = "";

  public static void main(String args[]) throws AddressException,
          MessagingException {

    sendEmail("/Users/pagarwal/Desktop/1.xlsx");
  }


  public static void sendEmail(String fileName) throws AddressException, MessagingException {
    String emailPort = "587";//gmail's smtp port

    Properties emailProperties = System.getProperties();
    emailProperties.put("mail.smtp.port", emailPort);
    emailProperties.put("mail.smtp.auth", "true");
    emailProperties.put("mail.smtp.starttls.enable", "true");
    String[] toEmails = {"agarwal.prateek10@gmail.com"};
    String emailSubject = fileName;
    String emailBody = "PFA attached " + fileName;

    Session mailSession = Session.getDefaultInstance(emailProperties, null);
    MimeMessage emailMessage = new MimeMessage(mailSession);

    for (int i = 0; i < toEmails.length; i++) {
      emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails[i]));
    }

    emailMessage.setSubject(emailSubject);

    // Create the message part
    BodyPart messageBodyPart = new MimeBodyPart();

    // Now set the actual message
    messageBodyPart.setText(emailBody);

    // Create a multipar message
    Multipart multipart = new MimeMultipart();

    // Set text message part
    multipart.addBodyPart(messageBodyPart);

    // Part two is attachment
    messageBodyPart = new MimeBodyPart();
    DataSource source = new FileDataSource(fileName);
    messageBodyPart.setDataHandler(new DataHandler(source));
    messageBodyPart.setFileName(fileName);
    multipart.addBodyPart(messageBodyPart);

    // Send the complete message parts
    emailMessage.setContent(multipart);
//    emailMessage.setContent(emailBody, "text/html");//for a html email
    //emailMessage.setText(emailBody);// for a text email
    String emailHost = "smtp.gmail.com";
    String fromUser = "volcanicprateek@gmail.com";//just the id alone without @gmail.com
    String fromUserEmailPassword = password;

    Transport transport = mailSession.getTransport("smtp");

    transport.connect(emailHost, fromUser, fromUserEmailPassword);
    transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
    transport.close();
    System.out.println("Email sent successfully to " + Arrays.asList(emailMessage.getAllRecipients()));
  }

}
