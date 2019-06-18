package DataObject;

import java.sql.Connection;

abstract public class DataObject {
    //The id of the object
    int objectId;
    
    //Returns the objectId
    public int getId() {
        return objectId;
    }
    
    //Sends the object to the Database
    abstract public void sendToDB(Connection connection);
}
