package homework;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class MyJUnit {
    private static Object tester;

    private static Method beforeSuite;
    private static Method afterSuite;
    private static Method before;
    private static Method after;
    private static ArrayList<Method> tests;

    static {
        tests = new ArrayList<>();
    }

    public static void start(String className) {
        try {
            Class clazz = Class.forName(className);
            Constructor constructor = clazz.getConstructor();
            tester = constructor.newInstance();

            parseClass();

            if (beforeSuite != null) {
                beforeSuite.invoke(tester);
            }
            for (Method m : tests) {
                if (before != null)
                    before.invoke(tester);

                m.invoke(tester);

                if (after != null)
                    after.invoke(tester);
            }
            if (afterSuite != null) {
                afterSuite.invoke(tester);
            }

        } catch (ClassNotFoundException |
                NoSuchMethodException |
                InvocationTargetException |
                IllegalAccessException |
                InstantiationException e) {
            e.printStackTrace();
        }finally {
            tester = null;
            beforeSuite = null;
            afterSuite = null;
            before = null;
            after = null;
            tests.clear();
        }
    }

    private static void parseClass() {
        Method[] methods = tester.getClass().getDeclaredMethods();
        for (Method m : methods) {
            if (m.getAnnotation(BeforeSuite.class) != null) {
                if (beforeSuite == null) {
                    beforeSuite = m;
                } else {
                    throw new RuntimeException("Не может быть больше одного метода с аннотацией BeforeSuite");
                }
            }
            if (m.getAnnotation(AfterSuite.class) != null) {
                if (afterSuite == null) {
                    afterSuite = m;
                } else {
                    throw new RuntimeException("Не может быть больше одного метода с аннотацией AfterSuite");
                }
            }
            if (m.getAnnotation(Before.class) != null) {
                if (before == null) {
                    before = m;
                } else {
                    throw new RuntimeException("Не может быть больше одного метода с аннотацией Before");
                }
            }
            if (m.getAnnotation(After.class) != null) {
                if (after == null) {
                    after = m;
                } else {
                    throw new RuntimeException("Не может быть больше одного метода с аннотацией After");
                }
            }
            if (m.getAnnotation(Test.class) != null) {
                tests.add(m);
            }
        }
        tests.sort((o1, o2) -> o2.getAnnotation(Test.class).priority() -
                o1.getAnnotation(Test.class).priority());
    }
}
