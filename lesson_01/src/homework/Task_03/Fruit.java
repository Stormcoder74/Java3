package homework.Task_03;

abstract class Fruit {
    private float weight;

    public Fruit(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }
}

class Apple extends Fruit {
    public Apple() {
        super(1f);
    }
}

class Orange extends Fruit {
    public Orange() {
        super(1.5f);
    }
}
