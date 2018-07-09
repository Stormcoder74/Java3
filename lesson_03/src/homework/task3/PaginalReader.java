package homework.task3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PaginalReader {
    private static final int FILE_SIZE = 10 * 1024 * 1024;
    private static final int PAGE_SIZE = 1800;

    public static void main(String[] args) {
        createFile();
        new Commander(PAGE_SIZE).run();
    }

    private static void createFile() {
        File file = new File("file.task3");
        int fileLength = 0;
        String page;

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
            while (fileLength < FILE_SIZE){
                int pageCount = fileLength / PAGE_SIZE + 1;
                page = "Page" + pageCount;
                bw.write(page);
                fileLength += page.length();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Создан файл размером " + file.length() + " байт");
    }
}
