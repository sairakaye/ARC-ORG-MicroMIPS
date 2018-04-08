package MicroMIPS.src.sample;

public class XORI extends Instruction {

    XORI(String line) {
        int in;

        setOPCode("001110");

        String[] reg = line.split(",");
        String rs = reg[1].replaceAll("\\D+", "");
        in = Integer.parseInt(rs);
        setRs(Integer.toString(in, 2));

        setImm(reg[2].replaceAll("\\D+",""));

        String[] first = reg[0].split(" ");

        String rt = first[1].replaceAll("\\D+", "");

        in = Integer.parseInt(rt);
        setRt(Integer.toString(in, 2));

    }
}
