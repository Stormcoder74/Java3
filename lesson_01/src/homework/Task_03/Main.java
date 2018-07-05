package homework.Task_03;

public class Main {
    public static void main(String[] args) {
        Box<Apple> aBox1 = new Box<>();
        Box<Apple> aBox2 = new Box<>();
        Box<Orange> oBox = new Box<>();

        Apple apple = new Apple();
        Orange orange = new Orange();

        for (int i = 0; i < 10; i++) {
            aBox1.add(apple);       // для примера будем класть одно и то же яблоко
            oBox.add(orange);       // и апельсин, а не создавать новые на каждой итерации
            if (i < 5)
                aBox2.add(apple);
        }

        //aBox1.add(new Orange()); //ошибка!

        checkBoxes(aBox1, aBox2, oBox);

        //aBox1.pourOut(oBox); //ошибка!
        aBox1.pourOut(aBox2);
        System.out.println("высыпаем яблоки из первой коробки во вторую");
        System.out.println();

        checkBoxes(aBox1, aBox2, oBox);
    }

    private static void checkBoxes(Box<Apple> aBox1, Box<Apple> aBox2, Box<Orange> oBox) {
        System.out.println("вес первой коробки с яблоками: " + aBox1.getWeight());
        System.out.println("вес второй коробки с яблоками: " + aBox2.getWeight());
        System.out.println("вес коробки с апельсинами: " + oBox.getWeight());
        System.out.println("сравниваем вторую коробку яблок с коробкой апельсинов: " + oBox.compare(aBox2));
        System.out.println();
    }
}



