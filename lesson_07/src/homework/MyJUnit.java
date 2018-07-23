package homework;

// Артем, задание еще не готово,
// обязательно доделаю проверь пожалуйста позже


import java.lang.reflect.Constructor;

public class MyJUnit {
    private static Class tester;

    public static void start(String className) {
        try {
            tester = Class.forName(className);
            Constructor constructor = tester.getConstructor();
            System.out.println(constructor.getName());

            tester.getClass() tester2 =
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
