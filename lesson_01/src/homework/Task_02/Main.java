package homework.Task_02;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        String[] strings = {"123", "456", "789"};

        ArrayList<String> stringArrayList = getArrayList(strings);

        for (String s : stringArrayList)
            System.out.println(s);

        Integer[] ints = {1, 2, 3, 4, 5, 6};

        ArrayList<Integer> intArrayList = getArrayList(ints);

        for (int i : intArrayList)
            System.out.println(i);
    }

    public static <T> ArrayList<T> getArrayList(T... array) {
        ArrayList<T> arrayList = new ArrayList<>();
        for (T a : array)
            arrayList.add(a);
        return arrayList;
    }
}
