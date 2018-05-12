package homework.Task_01;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] iarr = {1, 2, 3, 4, 5, 6, 7, 8};
        replaceItems(2, 5, iarr);
        System.out.println(Arrays.toString(iarr));

        String[] sarr = {"123", "rty", "qwe", "456", ":::"};
        replaceItems(1, 3, sarr);
        System.out.println(Arrays.toString(sarr));
    }

    public static <T> void replaceItems(int item1, int item2, T... array) {
        T tmp = array[item1];
        array[item1] = array[item2];
        array[item2] = tmp;
    }
}
