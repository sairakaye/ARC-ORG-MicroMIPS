package sample;

public class BC extends Instruction {

    BC(String line) {

        setOPCode("110010");


        // TODO fix this
        setVariable("");

    }

    @Override
    //TODO: FIX TOHEX ALGO
    public String toHex() {
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
