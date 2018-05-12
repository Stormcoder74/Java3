

public class GenericsDemo1 {
    public static void main(String args[]) {
        TestGeneric<String> wStr = new TestGeneric<String>("Hello");
        wStr.showType();
        String x1 = wStr.getObj();
        System.out.println("x1: " + x1);
        TestGeneric<Integer> wInt = new TestGeneric<Integer>(140);
        wInt.showType();
        Integer x2 = wInt.getObj();
        System.out.println("x2: " + x2);
    }
}
