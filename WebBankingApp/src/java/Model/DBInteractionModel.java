package Model;

import DataObject.DataObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBInteractionModel {

    public void sendToDB(DataObject obj, String dbConnectionString, String user, String pass) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("com.mysql.jdbc.Driver class not found.");
        }
        Connection con = DriverManager.getConnection(dbConnectionString, user, pass);
        obj.sendToDB(con);
    }
    
    
    
}
