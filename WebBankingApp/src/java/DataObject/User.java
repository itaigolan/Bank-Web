package DataObject;

abstract public class User extends DataObject{
    
    //Attributes of Customers and Employees
    String userType;
    String firstName;
    String lastName;
    String email;
    
    //Setter methods
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
}
