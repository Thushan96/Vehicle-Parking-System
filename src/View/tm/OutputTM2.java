package View.tm;

public class OutputTM2 {
    private String Vno;
    private String Vtype;
    private String Pslot;
    private String Ptime;

    public OutputTM2(String vno, String vtype, String pslot, String ptime) {
        setVno(vno);
        setVtype(vtype);
        setPslot(pslot);
        setPtime(ptime);
    }

    public OutputTM2() {
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

    public String getPslot() {
        return Pslot;
    }

    public void setPslot(String pslot) {
        Pslot = pslot;
    }

    public String getPtime() {
        return Ptime;
    }

    public void setPtime(String ptime) {
        Ptime = ptime;
    }
}
