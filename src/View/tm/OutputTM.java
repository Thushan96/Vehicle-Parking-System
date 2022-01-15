package View.tm;

public class OutputTM {
    private String Vno;
    private String Vtype;
    private String PDname;
    private String Ptime;

    public OutputTM(String vno, String vtype, String PDname, String ptime) {
        setVno(vno);
        setVtype(vtype);
        this.setPDname(PDname);
        setPtime(ptime);
    }

    public OutputTM() {
    }

    public String getVno() {
        return Vno;
    }

    public void setVno(String vno) {
        Vno = vno;
    }

    public String getVtype() {
        return Vtype;
    }

    public void setVtype(String vtype) {
        Vtype = vtype;
    }

    public String getPDname() {
        return PDname;
    }

    public void setPDname(String PDname) {
        this.PDname = PDname;
    }

    public String getPtime() {
        return Ptime;
    }

    public void setPtime(String ptime) {
        Ptime = ptime;
    }
}
