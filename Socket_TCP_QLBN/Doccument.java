package Socket_TCP_QLBN;

public class Doccument {
    private String sonha;
    private String giaban;
    private String tinhtrang;

    public String getSonha() {
        return sonha;
    }

    public void setSonha(String sonha) {
        this.sonha = sonha;
    }

    public String getGiaban() {
        return giaban;
    }

    public void setGiaban(String giaban) {
        this.giaban = giaban;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    @Override
    public String toString() {
        return
                "sonha='" + sonha + '\'' +
                ", giaban='" + giaban + '\'' +
                ", tinhtrang='" + tinhtrang ;
    }
}
