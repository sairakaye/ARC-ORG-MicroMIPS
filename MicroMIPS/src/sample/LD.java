package sample;

import java.math.BigInteger;

class LD extends Instruction{

    LD(String line) {
        int in;

        setOPCode("110111");

        String[] reg = line.split(",");

        String[] first = reg[0].split(" ");
        String rt = first[1].replaceAll("\\D+", "");
        in = Integer.parseInt(rt);
        setRt(Integer.toString(in, 2));

        String[] second = reg[1].split("\\(");

        String rs = second[1].replaceAll("\\D+", "");
        in = Integer.parseInt(rs);
        setRs(Integer.toString(in, 2));

        //TODO: fix set imm for LD, it can accept hex letters
        String imm = Integer.toString(Integer.parseInt(second[0].replaceAll("\\D+",""), 16), 2);
        while (imm.length() < 16){
            imm = "0" + imm;
        }
        setImm(imm);
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
