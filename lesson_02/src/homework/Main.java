package homework;

public class Main {
    public static void main(String[] args) {
        Initialiser.createData();
        new Commander().run();
        Initialiser.dropData();
    }
}
