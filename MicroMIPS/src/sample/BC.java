package sample;

import java.math.BigInteger;

public class BC extends Instruction {

    BC(String line) {

        setOPCode("110010");

        // TODO fix this
        setVariable("");

    }

    @Override
    //TODO: FIX TOHEX ALGO
    public String toHex() {
        BigInteger dec = new BigInteger(getOPCode() + getVariable(), 2);

        hex = dec.toString(16);
        if (hex.length() < 8)
            for (int i = hex.length(); i < 8; i++)
                hex = "0" + hex;

        return hex;
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
