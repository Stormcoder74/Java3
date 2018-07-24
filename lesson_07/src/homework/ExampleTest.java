package homework;

public class ExampleTest {

    private Example example;

    public ExampleTest(){
        System.out.println("Создание системы тестирования");
        System.out.println();
    }

    @BeforeSuite
    public void SetUp() {
        System.out.println("Подготовка системы тестирования");
        System.out.println();
        example = new Example(345, "Testing");
    }

    /*@BeforeSuite  // проверка на дубль BeforeSuite
    public void SetUpp() {
        System.out.println("Подготовка системы тестирования");
        System.out.println();
        example = new Example(345, "Testing");
    }*/

    @AfterSuite
    public void SetDown() {
        System.out.println("Завершение работы системы тестирования");
        System.out.println();
    }

    @Test(priority = 2)
    public void testMethod1() {
        System.out.println("Тестируем работу метода 1");
        System.out.println("Метод 1 вернул " + example.method1(34));
        System.out.println();
    }

    @Test(priority = 4)
    public void testMethod2() {
        System.out.println("Тестируем работу метода 2");
        System.out.println("Метод 2 вернул " + example.method2("строка"));
        System.out.println();
    }

    @Test(priority = 8)
    public void testMethod3() {
        System.out.println("Тестируем работу метода 3");
        System.out.println("Метод 3 вернул " + example.method3());
        System.out.println();
    }

    @Test
    public void testMethod4() {
        System.out.println("Тестируем работу метода 4");
        System.out.println("Метод 4 вернул " + example.method4());
        System.out.println();
    }

    @Test
    public void testMethod5() {
        System.out.println("Тестируем работу метода 5");
        example.method5();
        System.out.println();
    }
}
