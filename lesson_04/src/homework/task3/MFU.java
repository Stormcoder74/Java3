package homework.task3;


public class MFU {
    public static final int MFU_DELAY = 50;
    private Printer printer;
    private Scanner scanner;

    MFU() {
        printer = new Printer();
        scanner = new Scanner();
    }

    void print(Document doc) {
        new Thread(() -> System.out.println("\nМФУ -> Отпечатано " +
                printer.print(doc) + " страниц документа " + doc.getName() + "\n")).start();
    }

    Document scan(String name, int sheetAmount) {
        ScanTask sTask = new ScanTask(name, sheetAmount);

        Thread thread = new Thread(sTask);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return sTask.getDoc();
    }

    private class Printer {
        synchronized int print(Document doc) {
            int counter;
            for (counter = 1; counter <= doc.getPageAmount(); counter++) {
                try {
                    Thread.sleep(MFU_DELAY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Печать " +
                        counter + " страницы документа " + doc.getName());
            }
            return counter - 1;
        }
    }

    private class Scanner {
        synchronized Document scan(String name, int sheetAmount) {
            int counter;
            for (counter = 1; counter <= sheetAmount; counter++) {
                try {
                    Thread.sleep(MFU_DELAY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Сканирование " +
                        counter + " листа документа " + name);
            }
            return new Document(name, counter - 1);
        }
    }

    private class ScanTask implements Runnable{
        private Document doc;
        private int sheetAmount;
        private String name;

        public ScanTask(String name, int sheetAmount) {
            this.sheetAmount = sheetAmount;
            this.name = name;
        }

        @Override
        public void run() {
            doc = scanner.scan(name, sheetAmount);
            System.out.println("\nМФУ -> Осканировано " +
                    doc.getPageAmount() + " листов в документ " + doc.getName() + "\n");
        }

        public Document getDoc() {
            return doc;
        }
    }
}