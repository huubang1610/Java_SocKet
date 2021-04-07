package Socket_UDP_QLTV;

public class Document {
    private String masach;
    private String tensach;
    private String nguoimuon;

    public Document() {
    }

    public Document(String masach, String tensach, String nguoimuon) {
        this.masach = masach;
        this.tensach = tensach;
        this.nguoimuon = nguoimuon;
    }

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public String getNguoimuon() {
        return nguoimuon;
    }

    public void setNguoimuon(String nguoimuon) {
        this.nguoimuon = nguoimuon;
    }

    @Override
    public String toString() {
        return "masach='" + masach + '\'' +
                ", tensach='" + tensach + '\'' +
                ", nguoimuon='" + nguoimuon ;
    }
}
