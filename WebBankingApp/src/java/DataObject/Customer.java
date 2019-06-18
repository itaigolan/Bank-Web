package DataObject;

import DataStore.AccountList;
import java.sql.Connection;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
