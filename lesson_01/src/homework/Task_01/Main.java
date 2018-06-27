package homework.Task_01;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] iarr = {1, 2, 3, 4, 5, 6, 7, 8};
        swapItems(2, 5, iarr);
        System.out.println(Arrays.toString(iarr));

        String[] sarr = {"123", "rty", "qwe", "456", ":::"};
        swapItems(1, 3, sarr);
        System.out.println(Arrays.toString(sarr));

        MyClass[] myClasses = new MyClass[3];
        myClasses[0] = new MyClass("Item1", 11);
        myClasses[1] = new MyClass("Item2", 22);
        myClasses[2] = new MyClass("Item3", 33);
        swapItems(0, 2, myClasses);
        System.out.println(Arrays.toString(myClasses));
    }

    public static <T> void swapItems(int item1, int item2, T... array) {
        T tmp = array[item1];
        array[item1] = array[item2];
        array[item2] = tmp;
    }
}

class MyClass{
    String name;
    int age;

    public MyClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " " + age;
    }
}
