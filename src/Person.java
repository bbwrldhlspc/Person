public class Person extends Record {
    private String firstname;
    private String lastname;
    private String phone;
    private String email;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + getId() +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phone='" + phone + '\'' +
                ", e-mail='" + email + '\'' +
                '}';
    }

    @Override
    public void askUserData() {
        String firstname = Main.askString("First Name: ");
        String lastname = Main.askString("Last Name: ");
        String phone = Main.askString("Phone Number: ");
        String email = Main.askString("E-mail: ");

        setFirstname(firstname);
        setLastname(lastname);
        setPhone(phone);
        setEmail(email);
    }

    @Override
    public boolean contains(String part) {
        return firstname.contains(part)
                || lastname.contains(part)
                || phone.contains(part)
                || email.contains(part);
    }
}
