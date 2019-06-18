package DataObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Employee extends User{
    
    public Employee(int id){
        objectId = id;
        userType = "Employee";
    }

    public Employee(String firstName,String lastName,String email){
        userType = "Employee";
        super.firstName = firstName;
        super.lastName = lastName;
        super.email = email;
    }

    @Override
    public void sendToDB(Connection connection){
        try {
            Statement stmt = connection.createStatement();
            //Inserts employee to login_table
            String insert = "Insert into login_table Values(default,'password','employee');";
            stmt.executeUpdate(insert);
            
            //Gets userId of new user
            String query = "Select MAX(UserId) From login_table;" ;
            ResultSet queryResult = stmt.executeQuery(query);
            int userId = 0;
            if(queryResult.first()){
                userId = queryResult.getInt(1);
            }
            //Insert employee into user_table
            insert = "Insert into user_table (UserId,FirstName,LastName,Email) Values (" 
                    + userId + ",'" + this.firstName + "','" + this.lastName + "','" + this.email +"');";
            stmt.executeUpdate(insert);
        } catch (SQLException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
