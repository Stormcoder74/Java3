package homework.task1;

public class Task1 {
    public static void main(String args[]) {
        CharPrinter synch = new CharPrinter();
        for (char ch = 'A'; ch < 'D'; ch++)
            new Thread(new PrintChar(ch, synch)).start();
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
        while (lastChar != checkChar) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Exception");
            }
        }
        System.out.println(outputChar);
        lastChar = outputChar;
        notifyAll();
    }
}

class PrintChar implements Runnable {
    private char outputChar;
    private CharPrinter synch;

    PrintChar(char c, CharPrinter synch) {
        this.outputChar = c;
        this.synch = synch;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            synch.checkLast(outputChar);
        }
    }
}