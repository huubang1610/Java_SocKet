package SocketUDP_3;

public class Person3 {
    protected String Fullname;
    protected String ID;
    protected String Arrdess;
    protected String Birth;
    protected float mon1;
    protected float mon2;
    protected float mon3;

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String fullname) {
        Fullname = fullname;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getArrdess() {
        return Arrdess;
    }

    public void setArrdess(String arrdess) {
        Arrdess = arrdess;
    }

    public String getBirth() {
        return Birth;
    }

    public void setBirth(String birth) {
        Birth = birth;
    }

    public float getMon1() {
        return mon1;
    }

    public void setMon1(float mon1) {
        this.mon1 = mon1;
    }

    public float getMon2() {
        return mon2;
    }

    public void setMon2(float mon2) {
        this.mon2 = mon2;
    }

    public float getMon3() {
        return mon3;
    }

    public void setMon3(float mon3) {
        this.mon3 = mon3;
    }

    @Override
    public String toString() {
        return "Person3{" +
                "Fullname='" + Fullname + '\'' +
                ", ID='" + ID + '\'' +
                ", Arrdess='" + Arrdess + '\'' +
                ", Birth='" + Birth + '\'' +
                ", mon1=" + mon1 +
                ", mon2=" + mon2 +
                ", mon3=" + mon3 +
                '}';
    }
}
