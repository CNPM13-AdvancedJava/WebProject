/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import model.entities.UserDetail;

/**
 *
 * @author Linh
 */
public class EmailSender {
    
    private static final String EMAIL = "cskh@vmtiamo.vn";
    private static final String HOST = "mail.vmtiamo.vn";
    
    public static void sendProductKey(UserDetail user, List<String> lstProduct){
        Properties properties = System.getProperties();
        properties.put("mail.smtp.from", EMAIL);
        properties.put("mail.smtp.host", HOST);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.fallback", "false");
        properties.put("mail.smtp.starttls.enable", "true");
        
        Session mailSession = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("cskh@vmtiamo.vn", "rTlxPEnvKRxvYBHDaC2E");
            }
        });

        try {
            MimeMessage message = new MimeMessage(mailSession);
            message.setFrom(new InternetAddress(EMAIL));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
            message.setSubject("Danh sách mã kích hoạt bạn đã mua từ trang KeyStore");
            message.setText("This is actual message");
            Transport.send(message);
            System.err.println("Sent message successfully....");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
}
