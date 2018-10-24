package Dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
public Connection connection;
    public Connection getConnection(){

        String dbName="VATdb";
        String userName="root";
        String password="";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,password);

        } catch (Exception e){
            e.printStackTrace();
        }


        return null;
    }
}
