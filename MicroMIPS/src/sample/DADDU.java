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
        setFunc("10101");
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

    public String getIR21to25() {
        String big = new BigInteger(hex, 16).toString(2);

        return "";
    }

    public String getIR16to20() {
        return "";
    }

    public String getR15to0() {
        return "";
    }
}
