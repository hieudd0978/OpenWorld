package com;

import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.activation.*;


public class SendEmail extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{

        String to = "hieudd0978@gmail.com";
        String from = "hieud@irio.com";
        String host = "localhost";
        String pass = "IR@070!!";
        String outlookhost = "smtp-mail.outlook.com";
        //get system properties
        Properties properties = System.getProperties();
        properties.put("mail.smtp.user", from);
        properties.put("mail.smtp.host", outlookhost);
        properties.put("mail.smtp.port","587");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.auth","true");
//        properties.put("mail.smtp.socketFactory.port", "587");
//        properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
//        properties.put("mail.smtp.socketFactory.fallback","true");

        //Setup mail server
        //properties.setProperty("mail.smtp.host",host);
        Session session = Session.getDefaultInstance(properties);


        //set response content
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try
        {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Subject Line Here!");
            message.setText("Text message is entered here");

            Transport transport = session.getTransport("smtp");
            transport.connect(outlookhost, from, pass);
            transport.sendMessage(message, message.getAllRecipients());

            //Transport.send(message);
            String title = "Send Email";
            String res = "Sent message successs.....";
            String docType =
                    "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

            out.println(docType +
                    "<html>\n" +
                    "<head><title>" + title + "</title></head>\n" +
                    "<body bgcolor = \"#f0f0f0\">\n" +
                    "<h1 align = \"center\">" + title + "</h1>\n" +
                    "<p align = \"center\">" + res + "</p>\n" +
                    "</body></html>"
         );



        }
        catch (MessagingException e)
        {
            e.printStackTrace();;
        }
    }

}
