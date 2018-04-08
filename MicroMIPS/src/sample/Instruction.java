package MicroMIPS.src.sample;

public class Instruction {

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
        Rs = rs;
    }

    public String getRt() {
        return Rt;
    }

    public void setRt(String rt) {
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

    private String OPCode;
    private String Rs;
    private String Rt;
    private String Rd;
    private String Imm;
    private String Sa;
    private String Func;
    private String Address;
    private String variable;
}
