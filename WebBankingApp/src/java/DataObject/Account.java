package DataObject;

import java.math.BigDecimal;
import java.sql.Connection;

public class Account extends DataObject{
    int customerId;//The id of the customer that owns the account
    BigDecimal amount;
    
    public Account(int id, int customerId, BigDecimal amount) {
        objectId = id;
        this.customerId = customerId;
        this.amount = amount;
    }
    
    //Getter methods
    public BigDecimal getAmount(){
        return amount;
    }
    
    public int getCustomerId(){
        return customerId;
    }
    
    //Transaction methods
    public void deposit(BigDecimal depositAmount){
        amount = amount.add(depositAmount);  
        System.out.println("You deposited $" + depositAmount +" into account " + objectId + 
                    ", now the account has $" + amount);
    }
    
    public boolean withdraw(BigDecimal withdrawAmount){
        //Ensures that the withdraw amount is not larger than the amount of money in the account
        if(amount.compareTo(withdrawAmount) > -1){
            amount = amount.subtract(withdrawAmount); 
            System.out.println("You withdrew $" + withdrawAmount +" from account " + objectId + 
                    ", now the account has $" + amount);
            return true;
        }
        else{
            System.out.println("You tried to withdraw $" + withdrawAmount +" from account " + objectId + 
                    " but the account only has $" + amount);
            return false;
        }
    }

    @Override
    public void sendToDB(Connection connection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
