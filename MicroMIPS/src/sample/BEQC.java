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

    @Override
    public int getIR21to25(){
        return 0;
    }

    @Override
    public int getIR16to20(){
        return 0;
    }

    @Override
    public String getR15to0(){
        return "";
    }
}
