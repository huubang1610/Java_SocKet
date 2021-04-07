package SocketTCP_QLKS;

public class Doccument_Custormer {
    private String ID;
    private String Name;
    private String phanloai;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhanloai() {
        return phanloai;
    }

    public void setPhanloai(String phanloai) {
        this.phanloai = phanloai;
    }

    @Override
    public String toString() {
        return
                "ID='" + ID + '\'' +
                ", Name='" + Name + '\'' +
                ", phanloai=" + phanloai
                ;
    }
}
