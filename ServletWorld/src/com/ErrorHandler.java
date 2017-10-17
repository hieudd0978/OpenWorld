package com;

import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.util.*;

public class ErrorHandler extends HttpServlet {

        public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
            {

                Integer statusCode = (Integer)
                        request.getAttribute("javax.servlet.error.status_code");
                String servletName = (String)
                        request.getAttribute("javax.servlet.error.servlet_name");
                if(servletName == null){
                    servletName = "Unknown";
                }
                String requestUri = (String)
                        request.getAttribute("javax.servlet.error.request_uri");
                if(requestUri == null){
                    requestUri = "Uknown";
                }

                //set response content
                response.setContentType("text/html");
                if(statusCode == 404 || statusCode == 403)
                {
                    String errorpage = "ErrorHandlerPage.jsp";
                    response.sendRedirect(errorpage);
                }
                else
                {
                    PrintWriter out = response.getWriter();
                    String title = "Error/Exception Information";
                    String docType =
                            "<!doctype html public \"-//w3c//dtd html 4.0 " +
                                    "transitional//en\">\n";
                    out.println(docType +
                            "<html>\n" +
                            "<head><title>" + title + "</title></head>\n" +
                            "<body bgcolor = \"#f0f0f0\">\n");
                    if (statusCode == null) {
                        out.println("<h2>Error information is missing</h2>");
                        out.println("Please return to the <a href=\"" +
                                response.encodeURL("http://localhost:8080/") +
                                "\">Home Page</a>.");
                    } else if (statusCode != null) {
                        out.println("The status code : " + statusCode);
                    } else {
                        out.println("<h2>Error information</h2>");
                        out.println("Servlet Name : " + servletName + "</br></br>");
                        out.println("The request URI: " + requestUri + "<br><br>");
                    }
                    out.println("</body>");
                    out.println("</html>");
                }
            }
}
