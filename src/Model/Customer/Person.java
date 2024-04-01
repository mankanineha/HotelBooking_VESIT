package Model.Customer;

public class Person {
    String first_name;
    String last_name;
    String email;
    String mobile_number;

    public Person(){
        System.out.println("Creating a person:");
    }
    public Person(String first_name, String last_name, String email, String mobile_number)
    {
        this.setFirst_name(first_name);
        this.setLast_name(last_name);
        this.setEmail(email);
        this.setMobile_number(mobile_number);
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile_number() {
        return mobile_number;
    }
    public void display()
    {
        System.out.println("Enter the First Name: "+getFirst_name());
        System.out.println("Enter the Last Name: "+getLast_name());
        System.out.println("Enter the Email: "+getEmail());
        System.out.println("Enter the Mobile number: "+getMobile_number());

    }
}
