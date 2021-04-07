package Socket_UDP_QLTC;

public class File_Document {
    private String Total;
    private String History;

    public File_Document() {
    }

    public File_Document(String total, String history) {
        Total = total;
        History = history;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }

    public String getHistory() {
        return History;
    }

    public void setHistory(String history) {
        History = history;
    }

    @Override
    public String toString() {
        return "Total='" + Total + '\'' +
                ", History='" + History + '\''
                ;
    }
}
