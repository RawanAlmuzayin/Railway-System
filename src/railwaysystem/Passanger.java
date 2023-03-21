package railwaysystem;

public class Passanger {

    private String firstName, lastName, phone, city, address, sex, email, seatClass, passangerTicket;
    private static int TicketNo = 0;

    public Passanger(String firstName, String lastName, String phone, String city, String address, String sex, String email, String seatClass) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.city = city;
        this.address = address;
        this.sex = sex;
        this.email = email;
        this.seatClass = seatClass;
        generateTicketNo();
        this.passangerTicket = String.valueOf(TicketNo);
    }

    public void generateTicketNo() {
        TicketNo++;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }

    public String getPassangerTicket() {
        return passangerTicket;
    }

    @Override
    public String toString() {
        String format = String.format("----------------------------------------\n");
        format += String.format("%-10s %s\n", "Ticket NO:", getPassangerTicket());
        format += String.format("%-10s %s\n", "Seat Class:", getSeatClass());
        format += String.format("%-10s %s\n", "Name:", getFirstName() + " " + getLastName());
        format += String.format("%-10s %s\n", "Gender:", getSex());
        format += String.format("%-10s %s\n", "Email:", getEmail());
        format += String.format("%-10s %s\n", "Phone:", getPhone());
        format += String.format("%-10s %s\n", "City:", getCity());
        format += String.format("%-10s %s\n", "Address:", getAddress());
        format += String.format("----------------------------------------\n");
        return format;
    }

}
