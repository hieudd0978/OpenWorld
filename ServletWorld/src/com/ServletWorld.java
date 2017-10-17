package com;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class ServletWorld extends HttpServlet {



    //required initializtion beginning of servlet life cycle
    public void init() throws ServletException{

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        String jdbc_Driver = "org.postgresql.Driver";
        String db_Name = "jdbc:postgresql://localhost:5433/postgres";
        String login = "postgres";
        String password = "Eagle123";
        String pass = request.getParameter("pass").toString();
        String name = request.getParameter("username");


        try {
            Class.forName(jdbc_Driver);
            Connection con = DriverManager.getConnection(db_Name,login,password);
            Statement stmt = con.createStatement();
            String sql;
            sql = "SELECT \"NAME\", \"PASSWORD\" FROM \"Students\" WHERE \"NAME\" =\'"+name+"\' AND \"PASSWORD\"=\'"+pass+"\';";
            ResultSet rs = stmt.executeQuery(sql);
            con.close();

            if(rs.next()){
                //create cookies
                Cookie userName = new Cookie("username",request.getParameter("username"));
                //set expiration date for cookies in seconds
                userName.setMaxAge(60*10);
                //add the cookies in the response header
                response.addCookie(userName);

                response.sendRedirect("Order.jsp");
            }
            else
            {
                response.sendError(403);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public void destroy()
    {
        //end of servlet life cycle
    }

}
