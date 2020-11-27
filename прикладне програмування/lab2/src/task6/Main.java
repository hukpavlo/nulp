package task6;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Pavlo", "Huk", "pavlo@gmail.com", 19);
        User user2 = new User("Pavlo", "Huk", "pavlo.huk@gmail.com", 19);

        Map<String, User> users = new HashMap();

        System.out.println("Only one user:");
        users.put(user1.firstName, user1);
        printMap(users);

        System.out.println("Two users:");
        users.put(user2.firstName, user2);
        printMap(users);

        System.out.println("After remove:");
        users.remove(user2.firstName);
        printMap(users);
    }

    static void printMap(Map<String, User> map) {
        for(Map.Entry<String, User> item : map.entrySet()){

            System.out.printf("Key: %s  Value: %s \n", item.getKey(), item.getValue().firstName);
        }
    }
}
