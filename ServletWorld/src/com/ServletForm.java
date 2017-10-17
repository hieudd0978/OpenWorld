package com;

import java.io.*;
import java.util.Enumeration;
import java.util.Iterator;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServletForm extends HttpServlet {


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        String title = "Using POST Method to read Form data";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
        Enumeration paramNames = request.getParameterNames();

        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "<b>Things that you have ordered:</b>: "

        );
        while(paramNames.hasMoreElements()){
            String paramName = paramNames.nextElement().toString();

            out.println("<li>"+paramName+"\n");
        }
        out.println("</ul>\n" +"</body></html>");
    }

}
