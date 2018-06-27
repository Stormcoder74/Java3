package homework.Task_02;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        String[] strings = {"abc", "def", "ghi"};
        ArrayList<String> stringArrayList = toArrayList(strings);
        for (String s : stringArrayList)
            System.out.println(s);

        Integer[] ints = {1, 2, 3, 4, 5, 6};
        ArrayList<Integer> intArrayList = toArrayList(ints);
        for (int i : intArrayList)
            System.out.println(i);
    }

    public static <T> ArrayList<T> toArrayList(T[] array) {
        ArrayList<T> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, array);
        return arrayList;
    }
}
