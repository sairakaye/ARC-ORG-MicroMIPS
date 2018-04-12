package sample;

import javafx.beans.property.SimpleStringProperty;

public class MemDataTableItem {
    private SimpleStringProperty address;
    private SimpleStringProperty representation;

    public MemDataTableItem(String address, String representation){
        this.address = new SimpleStringProperty(address);
        this.representation = new SimpleStringProperty(representation);
    }

    public String getAddress(){
        return address.get();
    }

    public void setAddress(String address){
        this.address.set(address);
    }

    public String getRepresentation(){
        return representation.get();
    }

    public void setRepresentation(String representation){
        this.representation.set(representation);
    }
}
