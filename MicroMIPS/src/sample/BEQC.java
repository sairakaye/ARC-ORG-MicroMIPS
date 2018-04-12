package sample;

import java.math.BigInteger;

public class BEQC extends Instruction {
    BEQC(String line, int dist) {
        int in;

        setOPCode("001000");

        String reg[] = line.split(",");

        String[] temp = reg[0].split(" ");

        // TODO fix this
        String rs = temp[0].replaceAll("\\D+", "");
        in = Integer.parseInt(rs);
        System.out.println();
        setRs(Integer.toString(in, 2));

        String rt = temp[1].replaceAll("\\D+", "");
        in = Integer.parseInt(rt);
        setRt(Integer.toString(in, 2));

        String binString = Integer.toBinaryString(dist);
        if (binString.length() > 16){
            binString = binString.substring(0, 16);
        } else {
            while (binString.length() < 16)
                binString = "0" + binString;
        }
        setImm(binString);

    }

    @Override
    public String toHex(){
        BigInteger dec = new BigInteger(getOPCode() + getRs() + getRt() + getImm(), 2);

        hex = dec.toString(16);
        if (hex.length() < 8)
            for (int i = hex.length(); i < 8; i++)
                hex = "0" + hex;

        return hex;
    }

    @Override
    public int getIR21to25(){
        return Integer.parseInt(getRs(), 2);
    }

    @Override
    public int getIR16to20(){
        return Integer.parseInt(getRt(), 2);
    }

    @Override
    public String getR15to0(){
        String nString = "";

        while (nString.length() < 12){
            nString = nString + "0";
        }
        nString += hex.substring(4, 8);
        if (hex.substring(4,8).charAt(0) >= '8'){
            nString = "";
            while (nString.length() < 12){
                nString = nString + "f";
            }
            nString += hex.substring(4, 8);
        }

        return nString;
    }
}
