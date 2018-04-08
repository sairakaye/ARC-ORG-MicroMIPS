package sample;

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
}
