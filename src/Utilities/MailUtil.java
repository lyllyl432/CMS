/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author HP
 */
public class MailUtil {
    public static void sendMail(String recepient) throws MessagingException{
         final String username = "lyllyl432@gmail.com";
        final String password = "psucotsmvnaezjhv";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
            Message message = prepareMessage(session, username, recepient);
            Transport.send(message);
            System.out.println("Message send successfully");
   }
     private static Message prepareMessage(Session session, String my_account_email,String recepient) throws MessagingException{
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(my_account_email));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("first email from java");
            message.setText("hello world");
            return message;
        } catch (AddressException ex) {
            java.util.logging.Logger.getLogger(MailUtil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return null;
    }

}
