package sample;

public abstract class Instruction {

    public String getOPCode() {
        return OPCode;
    }

    public void setOPCode(String OPCode) {
        this.OPCode = OPCode;
    }

    public String getRs() {
        return Rs;
    }

    public void setRs(String rs) {
        StringBuilder rsBuilder = new StringBuilder(rs);
        while (rsBuilder.length() < 5){
            rsBuilder.insert(0, "0");
        }
        rs = rsBuilder.toString();
        Rs = rs;
    }

    public String getRt() {
        return Rt;
    }

    public void setRt(String rt) {
        StringBuilder rtBuilder = new StringBuilder(rt);
        while (rtBuilder.length() < 5){
            rtBuilder.insert(0, "0");
        }
        rt = rtBuilder.toString();
        Rt = rt;
    }

    public String getImm() {
        return Imm;
    }

    public void setImm(String imm) {
        Imm = imm;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getRd() {
        return Rd;
    }

    public void setRd(String rd) {
        StringBuilder rdBuilder = new StringBuilder(rd);
        while (rdBuilder.length() < 5){
            rdBuilder.insert(0, "0");
        }
        rd = rdBuilder.toString();
        Rd = rd;
    }

    public String getSa() {
        return Sa;
    }

    public void setSa(String sa) {
        Sa = sa;
    }

    public String getFunc() {
        return Func;
    }

    public void setFunc(String func) {
        Func = func;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

//    public abstract int getIR21to25();
//
//    public abstract int getIR16to20();
//
//    public abstract String getR15to0();

    public abstract String toHex();

    protected String OPCode;
    protected String Rs;
    protected String Rt;
    protected String Rd;
    protected String Imm;
    protected String Sa;
    protected String Func;
    protected String Address;
    protected String variable;
    protected String hex;
}
