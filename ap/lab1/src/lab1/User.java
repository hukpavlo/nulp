package lab1;

import java.util.Objects;

public class User {
  final int age;
  final String email;
  final String lastName;
  final String firstName;

  public static void main(String[] args) {
    User firstUser = new User("Pavlo", "Huk", "pavlo.huk@icloud.com", 19);
    User secondUser = new User("Pavlo", "Huk", "pavlo.huk@icloud.com", 19);

    System.out.println("Equals result: " + firstUser.equals(secondUser));
    System.out.println("First user hash: : " + firstUser.hashCode());
    System.out.println("Second user hash: : " + secondUser.hashCode());
  }

  User(String firstName, String lastName, String email, int age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.age = age;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (this.getClass() != obj.getClass()) return false;

    User user = (User) obj;

    return this.firstName == user.firstName &&
            this.lastName == user.lastName &&
            this.email == user.email &&
            this.age == user.age;
  }

  @Override
  public int hashCode() {
    return Objects.hash(age, email, lastName, firstName);
  }
}
