package sample;

public abstract class Instruction {

    Instruction() {

    }

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
        while (rs.length() < 5){
            rs = "0" + rs;
        }
        Rs = rs;
    }

    public String getRt() {
        return Rt;
    }

    public void setRt(String rt) {
        while (rt.length() < 5){
            rt = "0" + rt;
        }
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
        while (rd.length() < 5){
            rd = "0" + rd;
        }
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
}
