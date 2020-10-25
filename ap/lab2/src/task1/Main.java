package task1;

public class Main {
    public static void main(String[] args) {
        HerbivorousAnimal cow = new HerbivorousAnimal(1);
        СarnivorousAnimal dog = new СarnivorousAnimal(10);

        Plant nettle = new Plant(100);
        Meal brisket = new Meal(300);

        System.out.println("Cow eats plant: " + cow.eat(nettle));
        System.out.println("Cow eats meal: " + cow.eat(brisket));
        System.out.println("Dog eats plant: " + dog.eat(nettle));
        System.out.println("Dog eats meal: " + dog.eat(brisket));

        Animal[] animals = { cow, dog };

        for (Animal animal: animals) animal.run();
    }
}
