package addressBook;

public class Person {
    private String firstName;

    private String lastName;

    private String address;

    private String city;

    private String state;

    private int zip;

    private long phoneNumber;

    public Person(String firstName, String lastName, String address, String city, String state, int zip, long phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
    }
    public Person(){

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getInformation(){
        return "First Name-\t"+this.getFirstName()+"\nLast Name-\t"+this.getLastName()+"\nAddress\t-\t"+this.getAddress()+"\nCity\t-\t"+this.getCity()+"\nState\t-\t"+this.getState()+"\nZip\t-\t"+this.getZip()+"\nPhone Number-\t"+this.getPhoneNumber();
    }
}
