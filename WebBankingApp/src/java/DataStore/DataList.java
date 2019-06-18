package DataStore;

import DataObject.DataObject;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public abstract class DataList{
    
    HashMap list;
    FileReader inputStream = null;
    String objectType;
    
    public <O extends DataObject> O get(int id){
        O object = (O)this.list.get(id);
        return object;
    }
    
    //Adds an instance of type DataObject to list with its id as its key
    public <O extends DataObject> void add(O object){
        this.list.put(object.getId(),object);
    }
    
    public <O extends DataObject> void save() {
      
    }
}