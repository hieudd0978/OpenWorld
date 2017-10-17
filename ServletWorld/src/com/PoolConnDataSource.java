package com;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import javax.naming.directory.*;
import java.util.Hashtable;


public class PoolConnDataSource {
    public static void main(String arg[])
    {
        try{
            //setting up a data source reference
            //Connection pool data source


            String jdbc_Driver = "org.postgresql.Driver";
            String db_Name = "jdbc:postgresql://localhost:5433/postgres";
            String login = "postgres";
            String password = "Eagle123";

            DataSource ds = (DataSource) new InitialContext().lookup("jdbc/LocalDataSource");

        }
        catch (Exception e)
        {

        }
    }


}
