package homework.Task3;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Initializer {
    private static final int AMOUNT = 5;

    public static void main(String[] args) {
        createData();
    }

    public static void createData() {
        try (Connection conn = MyConnection.getConnection()) {
            assert conn != null;
            try (Statement stat = conn.createStatement()) {
                stat.execute("CREATE TABLE students " +
                        "(id INTEGER not NULL, " +
                        " family VARCHAR(64), " +
                        " mark INTEGER)");
            }

            try (PreparedStatement prStat = conn.prepareStatement(
                    "INSERT INTO students (id, family, mark) VALUES (?, ?, ?)");
                 BufferedReader fReader = new BufferedReader(new FileReader("family.txt"))) {
                conn.setAutoCommit(false);
                for (int i = 1; i <= AMOUNT; i++) {
                    prStat.setInt(1, i);
                    prStat.setString(2, fReader.readLine());
                    prStat.setInt(3, (int) (Math.random() * 10 + 1));
                    prStat.addBatch();
                }
                prStat.executeBatch();
                conn.commit();
                conn.setAutoCommit(true);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
