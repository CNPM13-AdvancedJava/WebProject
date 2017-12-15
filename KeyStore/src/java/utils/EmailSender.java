/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import model.dbentities.ProductDetail;
import model.dbentities.User;
import model.entities.UserDetail;

/**
 *
 * @author Linh
 */
public class EmailSender {
    
    private static final String EMAIL = "cskh@vmtiamo.vn";
    private static final String HOST = "mail.vmtiamo.vn";
    
    static {
        System.setProperty("java.net.preferIPv4Stack" , "true");
    }
    
    public static void sendProductKey(User user, Map<String, ProductDetail> keyMap){
        Properties properties = System.getProperties();
        properties.put("mail.smtp.from", EMAIL);
        properties.put("mail.smtp.host", HOST);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.fallback", "false");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.timeout", 10000);        
        
        Session mailSession = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL, "rTlxPEnvKRxvYBHDaC2E");
            }
        });
        
        try {
            String emailText = createEmailBody(keyMap);
            MimeMessage message = new MimeMessage(mailSession);
            message.setFrom(new InternetAddress(EMAIL));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
            message.setSubject("Danh sách mã kích hoạt bạn đã mua từ trang KeyStore");
            message.setText(emailText);
            long start = System.currentTimeMillis();
            Transport.send(message);
            long end = System.currentTimeMillis();
            long t = end - start;
            System.err.println("Sent message successfully....");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    private static String createEmailBody(Map<String, ProductDetail> keyMap){
        StringBuilder body = new StringBuilder();
        body.append("Đây là danh sách các sản phẩm bạn đã mua từ trang web của chúng tôi: ");
        for (String key : keyMap.keySet()){
            ProductDetail product = keyMap.get(key);
            body.append("\n"+ product.getProductName() +": "+key);
        }
        return body.toString();
    }

}
