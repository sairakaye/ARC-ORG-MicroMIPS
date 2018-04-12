package sample;

import java.math.BigInteger;

class DADDU extends Instruction{

    DADDU(String line) {
        int in;

        setOPCode("000000");

        String reg[] = line.split(",");

        String[] temp = reg[0].split(" ");

        String rd = temp[1].replaceAll("\\D+", "");
        in = Integer.parseInt(rd);
        setRd(Integer.toString(in, 2));

        String rs = reg[1].replaceAll("\\D+", "");
        in = Integer.parseInt(rs);
        setRs(Integer.toString(in, 2));

        String rt = reg[2].replaceAll("\\D+", "");
        in = Integer.parseInt(rt);
        setRt(Integer.toString(in, 2));

        setSa("00000");
        setFunc("101101");
    }

    @Override
    public String toHex(){
        BigInteger dec = new BigInteger(getOPCode() + getRs() + getRt() + getRd() + getSa() + getFunc(), 2);

        hex = dec.toString(16);
        if (hex.length() < 8)
            for (int i = hex.length(); i < 8; i++)
                hex = "0" + hex;

        return hex;
    }

    // get index for A on 2nd cycle
    public int getIR21to25() {
        return Integer.parseInt(getRs(), 2);

        //return Integer.toString(index);
    }

    // get index for B on 2nd cycle
    public int getIR16to20() {
        return Integer.parseInt(getRt(), 2);

        //return Integer.toString(index);
    }

    // IMM for 2nd Cycle
    public String getR15to0() {
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
