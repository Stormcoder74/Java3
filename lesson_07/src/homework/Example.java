package homework;

public class Example {

    private int field1;
    private String field2;

    public Example(int field1, String field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    public int method1(int num){
        System.out.println("Работа метода 1");
        System.out.println("Вывод метода 1 " + num);
        return field1;
    }

    public int method2(String string){
        System.out.println("Работа метода 2");
        System.out.println("Вывод метода 2 " + string);
        return field1;
    }

    public String method3(){
        System.out.println("Работа метода 3");
        return field2;
    }

    public String method4(){
        System.out.println("Работа метода 4");
        return field2;
    }

    public void method5(){
        System.out.println("Работа метода 5");
    }
}
