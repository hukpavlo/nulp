package task1;

public class HerbivorousAnimal extends Animal {
    public HerbivorousAnimal(int speed) {
        super(speed, Food.Type.Plant);
    }
}
