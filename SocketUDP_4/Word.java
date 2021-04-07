package SocketUDP_4;

public class Word {
    private String EN,VN;

    public String getEN() {
        return EN;
    }

    public void setEN(String EN) {
        this.EN = EN;
    }

    public String getVN() {
        return VN;
    }

    public void setVN(String VN) {
        this.VN = VN;
    }

    @Override
    public String toString() {
        return "Word{" +
                "EN='" + EN + '\'' +
                ", VN='" + VN + '\'' +
                '}';
    }
}
