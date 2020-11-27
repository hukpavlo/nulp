package task2;

import java.util.Comparator;

public class User {
    final String firstName;
    final String lastName;
    final String email;
    final int age;
    final Address address;

    public String getEmail() {
        return email;
    }

    public User(String firstName, String lastName, String email, int age, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.address = address;
    }

    public static void main(String[] args) {
        new User(
                "",
                "",
                "pavlo.huk@gmail.com",
                19,
                new Address("Pustomyty", "Luhova")
        ).validate();
    }

    public int getAge() {
        return age;
    }

    public void validate() throws HttpException {
        if (!this.firstName.matches("[a-zA-Z]+")) {
            throw new HttpException(HttpStatus.BAD_REQUEST, "Invalid firstName");
        }

        if (!this.lastName.matches("[a-zA-Z]*")) {
            throw new HttpException(HttpStatus.BAD_REQUEST, "Invalid lastName");
        }

        if (!this.email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
            throw new HttpException(HttpStatus.BAD_REQUEST, "Invalid email");
        }

        if (this.age < 0) {
            throw new HttpException(HttpStatus.BAD_REQUEST, "Invalid age");
        }

        this.address.validate();
    }
}
