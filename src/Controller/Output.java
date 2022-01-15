package Controller;

public class Output {
    private String Vno;
    private String Vtype;
    private String name;
    private String sno;
    private String time;
    private Boolean parkedOrDelivery=false;

    /*public Output(String vno, String vType, String name,String sno,String time,Boolean parkedOrDelivery) {
        this.Vno = vno;
        this.vType = vType;
        this.name = name;
        this.sno = sno;
        this.time = time;
        this.parkedOrDelivery = parkedOrDelivery;
    }*/

    public Output(String vno, String vType, String name, String sno, String time, Boolean parkedOrDelivery) {
        this.setVno(vno);
        this.setVtype(vType);
        this.setName(name);
        this.setSno(sno);
        this.setTime(time);
        this.setParkedOrDelivery(parkedOrDelivery);
    }


    public String getVno() {
        return Vno;
    }

    public void setVno(String vno) {
        Vno = vno;
    }

    public String getVType() {
        return Vtype;
    }

    public void setVtype(String vtype) {
        Vtype = vtype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Boolean getParkedOrDelivery() {
        return parkedOrDelivery;
    }

    public void setParkedOrDelivery(Boolean parkedOrDelivery) {
        this.parkedOrDelivery = parkedOrDelivery;
    }


}
