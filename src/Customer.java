
public class Customer {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;

    public Customer(int id, String firstName, String lastName,
                    String email, String phone, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public int getId() {
        return id; }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

}
