package homework;

public class Task2 {

    public boolean checkFor1And4(int[] inArr) {
        boolean exist1 = false;
        boolean exist4 = false;
        for (int i : inArr) {
            if (1 == i) exist1 = true;
            if (4 == i) exist4 = true;
            if (exist1 && exist4) return true;
        }
        return false;
    }
}
