package homework.task3;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Commander {
    private final int PAGE_SIZE;

    public Commander(int PAGE_SIZE) {
        this.PAGE_SIZE = PAGE_SIZE;
    }

    public void run() {
        File file = new File("file.task3");

        try (Scanner scanner = new Scanner(System.in)) {
            try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
                String[] commands;
                int pageNumber = 0;
                do {
                    System.out.println("Введите номер страницы или нажмите Enter для перехода к следующей");
                    commands = scanner.nextLine().split(" ", 0);
                    if (commands[0].equals("/выход")) {
                        System.out.println("Выход");
                        break;
                    }

                    try {
                        pageNumber = Integer.parseInt(commands[0]) - 1;
                        showPage(raf, pageNumber);
                    } catch (NumberFormatException e) {
                        showPage(raf, ++pageNumber);
                    }
                } while (true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showPage(RandomAccessFile raf, int pageNumber) {
        try {
            int position = PAGE_SIZE * pageNumber;
            raf.seek(position);
            for (int i = 1; i <= PAGE_SIZE; i++) {
                if (position + i <= raf.length()) {
                    System.out.print((char) raf.read());
                    if(i % 100 == 0)
                        System.out.println();
                } else {
                    System.out.println("Конец файла");
                    break;
                }
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
