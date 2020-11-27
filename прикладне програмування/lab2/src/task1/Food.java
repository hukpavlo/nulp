package task1;

abstract class Food {
    private final Food.Type type;
    private final int weight;

    public static enum Type {
        Plant, Meal,
    }

    public Food(Food.Type type, int weight) {
        this.type = type;
        this.weight = weight;
    }

    public Type getType() {
        return type;
    }
}

class Plant extends Food {
    public Plant(int weight) {
        super(Type.Plant, weight);
    }
}

class Meal extends Food {
    public Meal(int weight) {
        super(Type.Meal, weight);
    }
}
