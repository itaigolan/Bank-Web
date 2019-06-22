package DataObject;

import DataStore.AccountList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Customer extends User{
    AccountList accountList;
    
    //Parts of the customer's address
    String streetAddress;
    String city;
    String state;
    int zip;
    
    public Customer(int id){
        objectId = id;
        userType = "Customer";
        accountList = new AccountList();
    }
    
    public Customer(String firstName,String lastName,String email){
        userType = "Customer";
        super.firstName = firstName;
        super.lastName = lastName;
        super.email = email;
    }
    
    //Setter methods
    public void setAddress(String address){
        //Splits the full address into its parts
        String [] addressParts = address.split(",");
        try{
            this.streetAddress = addressParts[0];
            this.city = addressParts[1];
            this.state = addressParts[2];
            this.zip = Integer.parseInt(addressParts[3]);
        }
        catch(NumberFormatException e){
        }
    }

    @Override
    public void sendToDB(Connection connection) {
        try {
            Statement stmt = connection.createStatement();
            //Inserts customer to login_table
            String insert = "Insert into login_table Values(default,'password','customer');";
            stmt.executeUpdate(insert);
            
            //Gets userId of new user
            String query = "Select MAX(UserId) From login_table;" ;
            ResultSet queryResult = stmt.executeQuery(query);
            int userId = 0;
            if(queryResult.first()){
                userId = queryResult.getInt(1);
            }
            //Inserts new customer into customer_table
            insert = "Insert into customer_table Values(default,'"+this.firstName + "','" + this.lastName + "');";
            stmt.executeUpdate(insert);
            
            //Gets customerId of new user
            query = "Select MAX(Id) From customer_table;" ;
            queryResult = stmt.executeQuery(query);
            int customerId = 0;
            if(queryResult.first()){
                customerId = queryResult.getInt(1);
            }
 
            //Insert customer into user_table
            insert = "Insert into user_table Values ("+ userId + ",'" + this.firstName + "','" + this.lastName 
                    + "','" + this.email + "," + customerId +"');";
            stmt.executeUpdate(insert);
            
            //Add address to customer_address
            insert = "Insert into customer_address Values ("+ customerId + ",'" + this.streetAddress + "','" + this.city 
                    + "','" + this.state + "," + this.zip +"');";
            stmt.executeUpdate(insert);
            
            stmt.close();
            queryResult.close();
            connection.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
