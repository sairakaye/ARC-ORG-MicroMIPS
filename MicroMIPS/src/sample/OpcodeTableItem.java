package sample;

import javafx.beans.property.SimpleStringProperty;

public class OpcodeTableItem {
    private SimpleStringProperty instruction;
    private SimpleStringProperty opcodeHex;
    private SimpleStringProperty bit26to31;
    private SimpleStringProperty bit21to25;
    private SimpleStringProperty bit16to20;
    private SimpleStringProperty bit11to15;
    private SimpleStringProperty bit6to10;
    private SimpleStringProperty bit0to5;

    public OpcodeTableItem(String instruction, String opcodeHex, String bit26to31,
                           String bit21to25, String bit16to20, String bit11to15,
                           String bit6to10, String bit0to5) {
        this.instruction = new SimpleStringProperty("");
        this.opcodeHex = new SimpleStringProperty("");
        this.bit26to31 = new SimpleStringProperty("");
        this.bit21to25 = new SimpleStringProperty("");
        this.bit16to20 = new SimpleStringProperty("");
        this.bit11to15 = new SimpleStringProperty("");
        this.bit6to10 = new SimpleStringProperty("");
        this.bit0to5 = new SimpleStringProperty("");

        setInstruction(instruction);
        setOpcodeHex(opcodeHex);
        setBit0to5(bit0to5);
        setBit6to10(bit6to10);
        setBit11to15(bit11to15);
        setBit16to20(bit16to20);
        setBit21to25(bit21to25);
        setBit26to31(bit26to31);
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

    public String getOpcodeHex() {
        return opcodeHex.get();
    }

    public SimpleStringProperty opcodeHexProperty() {
        return opcodeHex;
    }

    public void setOpcodeHex(String opcodeHex) {
        this.opcodeHex.set(opcodeHex);
    }

    public String getBit26to31() {
        return bit26to31.get();
    }

    public SimpleStringProperty bit26to31Property() {
        return bit26to31;
    }

    public void setBit26to31(String bit26to31) {
        this.bit26to31.set(bit26to31);
    }

    public String getBit21to25() {
        return bit21to25.get();
    }

    public SimpleStringProperty bit21to25Property() {
        return bit21to25;
    }

    public void setBit21to25(String bit21to25) {
        this.bit21to25.set(bit21to25);
    }

    public String getBit16to20() {
        return bit16to20.get();
    }

    public SimpleStringProperty bit16to20Property() {
        return bit16to20;
    }

    public void setBit16to20(String bit16to20) {
        this.bit16to20.set(bit16to20);
    }

    public String getBit11to15() {
        return bit11to15.get();
    }

    public SimpleStringProperty bit11to15Property() {
        return bit11to15;
    }

    public void setBit11to15(String bit11to15) {
        this.bit11to15.set(bit11to15);
    }

    public String getBit6to10() {
        return bit6to10.get();
    }

    public SimpleStringProperty bit6to10Property() {
        return bit6to10;
    }

    public void setBit6to10(String bit6to10) {
        this.bit6to10.set(bit6to10);
    }

    public String getBit0to5() {
        return bit0to5.get();
    }

    public SimpleStringProperty bit0to5Property() {
        return bit0to5;
    }

    public void setBit0to5(String bit0to5) {
        this.bit0to5.set(bit0to5);
    }
}
