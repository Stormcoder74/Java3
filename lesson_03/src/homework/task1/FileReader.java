package homework.task1;

import java.io.*;
import java.util.Arrays;

public class FileReader {

    private static final int FILE_SIZE = 50;

    public static void main(String[] args) {
        File file = new File("file.task1");

        try (OutputStream fileOS = new FileOutputStream(file)) {
            for(byte i = 0; i < FILE_SIZE; i++){
                fileOS.write(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] byteArr = new byte[FILE_SIZE];

        try (InputStream fileIS = new FileInputStream(file)) {
            for(int i = 0; i < FILE_SIZE; i++){
                byteArr[i] = (byte) fileIS.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(Arrays.toString(byteArr));
    }


}
