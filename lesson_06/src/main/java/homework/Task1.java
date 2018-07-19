package homework;

import java.util.ArrayList;
import java.util.List;

public class Task1 {

    public int[] afterLast4(int[] inArr) {
        List<Integer> receiver = new ArrayList<>();
        boolean exist4 = false;

        for (int i : inArr) {
            if (i == 4) {
                exist4 = true;
                receiver.clear();
            } else
                receiver.add(i);
        }

        if (!exist4) throw new RuntimeException();

        // Не нашел я простого способа конвертировать
        // receiver в массив int[], подскажите, если есть такой

        int length = receiver.size();
        int[] outArr = new int[length];

        for (int i = 0; i < length; i++) {
            outArr[i] = receiver.get(i);
        }

        return outArr;
    }
}
