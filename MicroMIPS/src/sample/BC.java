package sample;

import java.math.BigInteger;

public class BC extends Instruction {
    private int addr;

    public int getAddr() {
        return addr;
    }

    BC(String line, int dist) {

        setOPCode("110010");
        addr = (dist + 1) * 4;
        // TODO fix this
        String binString = Integer.toBinaryString(dist);
        if (binString.length() > 26){
            binString = binString.substring(0, 26);
        } else {
            while (binString.length() < 26)
                binString = "0" + binString;
        }
        setVariable(binString);
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
        return Integer.parseInt(getVariable().substring(0, 5));
    }

    @Override
    public int getIR16to20(){
        return Integer.parseInt(getVariable().substring(5, 10));
    }

    @Override
    public String getR15to0(){
        return getVariable().substring(10, 25);
    }
}
