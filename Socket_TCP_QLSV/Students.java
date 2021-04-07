package Socket_TCP_QLSV;

public class Students {
    private String Name;
    private String DateOfBirth;
    private String MSV;
    private String Address;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getMSV() {
        return MSV;
    }

    public void setMSV(String MSV) {
        this.MSV = MSV;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public String toString() {
        return
                "Name='" + Name + '\'' +
                ", DateOfBirth='" + DateOfBirth + '\'' +
                ", MSV='" + MSV + '\'' +
                ", Address='" + Address
                ;
    }
}
