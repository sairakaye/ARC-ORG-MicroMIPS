package sample;

public class BEQC extends Instruction {
    BEQC(String line) {

        setOPCode("001000");


        // TODO fix this
        setVariable("");

    }

    @Override
    public String toHex(){
        return "";
    }
}
