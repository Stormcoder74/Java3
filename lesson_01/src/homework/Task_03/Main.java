package homework.Task_03;

public class Main {
    public static void main(String[] args) {
        Box<Apple> box1 = new Box<>();
        Box<Orange> box2 = new Box<>();
        Box<Apple> box3 = new Box<>();

        Apple apple = new Apple();
        Orange orange = new Orange();

        for (int i = 0; i < 10; i++) {
            box1.add(apple);        // для примера будем класть одно и то же яблоко
            box2.add(orange);       // и апельсин, а не создавать на каждой итерации
            if (i < 5)
                box3.add(apple);
        }

        System.out.println(box2.compare(box3));
        System.out.println(box2.getWeight());
        System.out.println(box3.getWeight());

        box1.pourout(box3);

        System.out.println(box2.compare(box3));
        System.out.println(box2.getWeight());
        System.out.println(box3.getWeight());
    }
}




