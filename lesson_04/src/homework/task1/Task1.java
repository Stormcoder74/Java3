package homework.task1;

public class Task1 {
    public static void main(String args[]) {
        CharPrinter printer = new CharPrinter();
        for (char ch = 'A'; ch < 'D'; ch++)
            new Thread(new PrintChar(ch, printer)).start();
    }
}

class CharPrinter {
    private char lastChar = 'C';

    synchronized void checkLast(char outputChar) {
        char checkChar;
        if (outputChar == 'A')
            checkChar = 'C';
        else
            checkChar = (char) (outputChar - 1);
        while (lastChar != checkChar)
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Exception");
            }
        System.out.println(outputChar);
        lastChar = outputChar;
        notifyAll();
    }
}

class PrintChar implements Runnable {
    private char outputChar;
    private CharPrinter printer;

    PrintChar(char outputChar, CharPrinter printer) {
        this.outputChar = outputChar;
        this.printer = printer;
    }

    public void run() {
        for (int i = 0; i < 5; i++)
            printer.checkLast(outputChar);
    }
}