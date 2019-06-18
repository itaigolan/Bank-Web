package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Operations related to logging in to the application
public class LoginModel {
    //Login
    static public String login(int id, String password) throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            return "com.mysql.jdbc.Driver class not found.";
        }
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quintrixbankdb", "root", "mysql");
        Statement stmt = con.createStatement();
        //Gets the login information for the user with the provided UserId
        //Result set indexes - 1 = Id, 2 = password, 3 = user type 
        ResultSet queryResult = stmt.executeQuery("Select * From login_table where UserId =" + id);
        //Returns true if the query result isn't empty
        if(queryResult.first()){
            //If the entered password is correct it checks for the type of the user
            if(queryResult.getString(2).equals(password)){
                if(queryResult.getString(3).equals("customer")){
                    queryResult.close();
                    stmt.close();
                    con.close();
                    return "customer";
                }
                else{
                    System.out.println("Employee");
                    queryResult.close();
                    stmt.close();
                    con.close();
                    return "employee";
                }
            }
            else{
                queryResult.close();
                stmt.close();
                con.close();
                return "The password entered is incorrect";
            }
            
        }
        else{
            queryResult.close();
            stmt.close();
            con.close();
            String response = "User " + id + " does not exist.";
            return response;
        }
    }
}
