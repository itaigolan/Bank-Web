package DataStore;

import DataObject.Account;
import DataObject.Customer;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;


public class AccountList extends DataList{
    
    //Used to create user specific account lists
    public AccountList(){
        list = new HashMap<Integer, Account>();
    }

    public Account createAccount(int id, int customerId, BigDecimal amount) {
        Account account = null;
        //If a user with the provided id already exists it returns false
        if(list.get(id)!=null){
            System.out.println("The account with the id " + id + " already exists.");
        } 
        else {
            account = new Account(id, customerId,amount);
            this.list.put(id,account);
        }
        return account;
    }

    //Removes the account with the id from the list
    public void remove(int id) {
        list.remove(id);
    }
}
