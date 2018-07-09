package homework.task2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class Stapler {
    private static final int FILE_SIZE = 100;

    public static void main(String[] args) {
//        createFiles();

        List<InputStream> list = new ArrayList<>();

        for (int i = 1; i < 6; i++) {
            File file = new File("file" + i + ".task2");
            try {
                list.add(new FileInputStream(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        Enumeration<InputStream> inEnum = Collections.enumeration(list);
        File file = new File("file6.task2");

        try (SequenceInputStream seqIS = new SequenceInputStream(inEnum);// закрооются ли InputStream_ы в seqIS входящие? Наверное должны
             FileOutputStream fileOS = new FileOutputStream(file)) {
            byte buf;
            while ((buf = (byte) seqIS.read()) != -1){
                fileOS.write(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createFiles() {
        for (int j = 1; j < 6; j++) {
            File file = new File("file" + j + ".task2");

            try (OutputStream fileOS = new FileOutputStream(file)) {
                for (byte i = 0; i < FILE_SIZE; i++) {
                    fileOS.write(i);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
