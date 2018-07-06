/*
К сожалению не успел попробовать Bath запрос
(времени в обрез, обязательно изучу позже), не все
тщательно проверил, но согласно ТЗ, тоесть ДЗ все работает,
да и 10_000 пишет долго ограничелся сотней (настраиается в Initialiser)
 */
package homework;

public class Main {
    public static void main(String[] args) {
        Initialiser.createData();
        new Commander().run();
        Initialiser.dropData();
    }
}
