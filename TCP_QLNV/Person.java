package TCP_QLNV;

public class Person {
    private String Name;
    private String DateOfBirth;
    private String Title;

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

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    @Override
    public String toString() {
        return "Name='" + Name + '\'' +
                ", DateOfBirth='" + DateOfBirth + '\'' +
                ", Title='" + Title + '\''
                ;
    }
}
