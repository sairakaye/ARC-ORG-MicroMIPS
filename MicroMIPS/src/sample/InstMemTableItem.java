package sample;

import javafx.beans.property.SimpleStringProperty;

public class InstMemTableItem {
    private SimpleStringProperty address;
    private SimpleStringProperty opcodeHex;
    private SimpleStringProperty instruction;

    public InstMemTableItem(String address, String opcodeHex, String instruction) {
        this.address = new SimpleStringProperty(address);
        this.opcodeHex = new SimpleStringProperty(opcodeHex);
        this.instruction = new SimpleStringProperty(instruction);
    }

    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getOpcodeHex() {
        return opcodeHex.get();
    }

    public SimpleStringProperty opcodeHexProperty() {
        return opcodeHex;
    }

    public void setOpcodeHex(String opcodeHex) {
        this.opcodeHex.set(opcodeHex);
    }

    public String getInstruction() {
        return instruction.get();
    }

    public SimpleStringProperty instructionProperty() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction.set(instruction);
    }
}
