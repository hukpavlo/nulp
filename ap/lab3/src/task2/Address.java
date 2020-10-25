package task2;

import java.util.Objects;

public class Address {
    final String city;
    final String street;

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(city, address.city) &&
                Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street);
    }

    public void validate() throws HttpException {
        if (!this.city.matches("[a-zA-Z]+")) {
            throw new HttpException(HttpStatus.BAD_REQUEST, "Invalid city");
        }

        if (!this.street.matches("[a-zA-Z]*")) {
            throw new HttpException(HttpStatus.BAD_REQUEST, "Invalid street");
        }
    }
}
