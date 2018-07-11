package homework.task2;

import java.io.*;

public class Task2 {
    public static void main(String args[]) {
        File file = new File("file.task2");
        Thread thread;
        try (BufferedWriter bufWriter = new BufferedWriter(new FileWriter(file))) {
            MyFileWriter writer = new MyFileWriter(bufWriter);
            for (int i = 1; i <= 3; i++) {
                thread = new Thread(new PrintChar(i, writer));
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MyFileWriter {
    private BufferedWriter bufWriter;

    public MyFileWriter(BufferedWriter bufWriter) {
        this.bufWriter = bufWriter;
    }

    synchronized void write(String output) {
        try {
            bufWriter.write(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class PrintChar implements Runnable {
    private int threadNumber;
    private MyFileWriter writer;

    PrintChar(int threadNumber, MyFileWriter writer) {
        this.threadNumber = threadNumber;
        this.writer = writer;
    }

    public void run() {
        long time1 = System.currentTimeMillis();
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long time2 = System.currentTimeMillis();
            String output = "Запись " + i + " потока " + threadNumber +
                    " через " + (time2 - time1) + " мс\n";
            writer.write(output);
            time1 = time2;
        }
    }
}