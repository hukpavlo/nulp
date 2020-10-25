package task1;

public abstract class Animal {
    private final int speed;
    private final Food.Type type;

    public Animal(int speed, Food.Type type) {
        this.type = type;
        this.speed = speed;
    }

    public boolean eat(Food food) {
        return food.getType() == this.type;
    }

    public void run() {
        System.out.println("Running with speed: " + this.speed);
    }
}

