package homework;

public class ExampleTest {

    private Example example;

    public ExampleTest(){
        System.out.println("Создание системы тестирования");
    }

    @BeforeSuite
    public void SetUp() {
        System.out.println("Подготовка системы тестирования");
        example = new Example(345, "Testing");
    }

    @AfterSuite
    public void SetDown() {
        System.out.println("Завершение работы системы тестирования");
    }

    @Test(priority = 2)
    public void testMethod1() {
        System.out.println("Тестируем работу метода 1");
        System.out.println(example.method1());
    }

    @Test(priority = 4)
    public void testMethod2() {
        System.out.println("Тестируем работу метода 2");
        System.out.println(example.method2());
    }

    @Test(priority = 8)
    public void testMethod3() {
        System.out.println("Тестируем работу метода 3");
        System.out.println(example.method3());
    }

    @Test
    public void testMethod4() {
        System.out.println("Тестируем работу метода 4");
        System.out.println(example.method4());
    }

    @Test
    public void testMethod5() {
        System.out.println("Тестируем работу метода 5");
        example.method5();
    }
}
