package sample;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {
    String MySQLURL = "jdbc:mysql://localhost:3306/supplychain?useSSL=false";
    String databseUserName = "root";
    String databasePassword = "12345678";
    Connection con = null;

    DatabaseConnection(){
        try {
            con = DriverManager.getConnection(MySQLURL, databseUserName, databasePassword);
            if (con != null) {
                System.out.println("Database connection is successful !!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query){
        ResultSet ans = null;
        try{
            Statement statement = con.createStatement();
            ans = statement.executeQuery(query);
            return ans;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return ans;
    }

    public int executeUpdate(String query){
        int ans = 0;
        try{
            Statement statement = con.createStatement();
            ans = statement.executeUpdate(query);
            return ans;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return ans;
    }


}
