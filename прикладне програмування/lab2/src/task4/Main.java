package task4;

import task1.Animal;
import task1.HerbivorousAnimal;
import task1.СarnivorousAnimal;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        HerbivorousAnimal cow = new HerbivorousAnimal(1);
        СarnivorousAnimal dog = new СarnivorousAnimal(10);

        ArrayList<Animal> animals = new ArrayList<Animal>();

        animals.add(cow);
        animals.add(dog);

        for (Animal animal: animals) animal.run();
    }
}
