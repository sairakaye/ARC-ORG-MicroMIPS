package sample;

import java.math.BigInteger;

public class XORI extends Instruction {

    XORI(String line) {
        int in;

        setOPCode("001110");

        String[] reg = line.split(",");

        String rs = reg[1].replaceAll("\\D+", "");
        in = Integer.parseInt(rs);
        setRs(Integer.toString(in, 2));

        String[] immediate = null;

        if (reg[2].indexOf("#") > 0)
            immediate = reg[2].split("#");
        else if (reg[2].indexOf("x") > 0)
            immediate = reg[2].split("x");

        String imm = Integer.toString(Integer.parseInt(immediate[1], 16), 2);
        while (imm.length() < 16){
            imm = "0" + imm;
        }
        setImm(imm);

//        StringBuilder imm = new StringBuilder(Integer.toString(Integer.parseInt(reg[0].replaceAll("\\D+", ""), 16), 2));
//        while (imm.length() < 16){
//            imm.insert(0, "0");
//        }
//        setImm(imm.toString());

        String[] first = reg[0].split(" ");

        String rt = first[1].replaceAll("\\D+", "");

        in = Integer.parseInt(rt);
        setRt(Integer.toString(in, 2));

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
//        String nString = "";
//
//        while (nString.length() < 12){
//            nString = nString + "0";
//        }
//        nString += hex.substring(4, 8);
//
//        return nString;
    }
}