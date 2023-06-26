package entities;

public class Driver {
    private String fullname;
    private String name;
    private String surname;
//    private int namedCount;

    public Driver(String fullname) {
        this.fullname = fullname;

        String[] parts = fullname.split(" ");
        this.name = parts[0];
        this.surname = parts[1];
    }
    public String getName() {
        return name;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

//    public void driverAppeared() {
//        this.namedCount++;
//    }
//    public int getNamedCount() {
//        return namedCount;
//    }
//
//    public void setNamedCount(int namedCount) {
//        this.namedCount = namedCount;
//    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFullname() {
        return fullname;
    }
}
