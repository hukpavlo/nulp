package task3;

import task2.Address;
import task2.User;

import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Supplier<Stream<User>> users = () -> Stream.of(
                new User("Pavlo", "Huk", "pavlo.huk@gmail.com", 19, new Address("Pustomyty", "Luhova")),
                new User("Anton", "Skorochkin", "anton@gmail.com", 25, new Address("Lviv", "Shevchenka"))
        );

        Supplier<Stream<Address>> addresses = () -> Stream.of(
                new Address("Pustomyty", "Luhova"),
                new Address("Pustomyty", "Luhova")
        );

        System.out.println("Map emails:");
        users.get().map(user -> user.getEmail()).forEach(System.out::println);

        System.out.println("Filter emails:");
        users.get().filter(user -> !user.getEmail().startsWith("pavlo")).forEach(user -> System.out.println(user.getEmail()));

        System.out.println("Distinct count: " + addresses.get().distinct().count());

        System.out.println("Peek emails:");
        users.get().peek(user -> System.out.println("Peeking email: " + user.getEmail())).forEach(user -> System.out.println(user.getEmail()));

        System.out.println("Limit emails:");
        users.get().limit(1).forEach(user -> System.out.println(user.getEmail()));

        System.out.println("Sort by age:");
        users.get().sorted(new UserComparator()).forEach(user -> System.out.println(user.getAge()));

        System.out.println("Find first email: " + users.get().findFirst().get().getEmail());

        System.out.println("Collect emails:");
        List<User> listUsers = users.get().collect(Collectors.toList());

        for(User user : listUsers){
            System.out.println(user.getEmail());
        }

        System.out.println("Reduce users: "+ users.get().reduce("Emails:", (x, y) -> x + " " + y.getEmail(), (x, y) -> x + y));
    }
}

class UserComparator implements Comparator<User> {
    public int compare(User a, User b){
        return a.getAge() > b.getAge() ? 1 : -1;
    }
}