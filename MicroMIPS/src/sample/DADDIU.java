package sample;

import java.math.BigInteger;

class DADDIU extends Instruction{

    DADDIU(String line) {
        int in;

        setOPCode("011001");

        String[] reg = line.split(",");
        String rs = reg[1].replaceAll("\\D+", "");
        in = Integer.parseInt(rs);
        setRs(Integer.toString(in, 2));

        String imm = Integer.toString(Integer.parseInt(reg[0].replaceAll("\\D+",""), 16), 2);
        while (imm.length() < 16){
            imm = "0" + imm;
        }
        setImm(imm);

        String[] first = reg[0].split(" ");

        String rt = first[1].replaceAll("\\D+", "");
        in = Integer.parseInt(rt);
        setRt(Integer.toString(in, 2));

        System.out.println(rs);
        System.out.println(rt);
        System.out.println(Imm);
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
}
