package homework.task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        MFU mfu = new MFU();
        Random rnd = new Random();

        for(int i = 1; i < 6; i++){
            Document doc = new Document("doc" + i + ".txt",
                    rnd.nextInt(5) + 3);
            mfu.print(doc);
        }

        List<Document> scanDocs = new ArrayList<>();
        for(int i = 1; i < 6; i++){
            scanDocs.add(mfu.scan("scandoc" + i + ".txt",
                    rnd.nextInt(5) + 3));
        }
        System.out.println("Отсканированные документы: "
                + Arrays.toString(scanDocs.toArray()));
    }
}


