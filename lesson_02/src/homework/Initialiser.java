package homework;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Initialiser {
    private static final int AMOUNT = 10_000;

    public static void createData() {
        try (Connection conn = MyConnection.getConnection()) {
            assert conn != null;
            try (Statement stat = conn.createStatement()) {
                stat.execute("CREATE TABLE products " +
                        "(id INTEGER not NULL, " +
                        " prodid INTEGER, " +
                        " title VARCHAR(64), " +
                        " cost FLOAT, " +
                        " PRIMARY KEY ( id ))");
            }

            try (PreparedStatement prStat = conn.prepareStatement(
                    "INSERT INTO products (prodid, title, cost) " +
                            "VALUES (?, ?, ?);")) {
                conn.setAutoCommit(false);
                long time = System.currentTimeMillis();
                for (int i = 1; i <= AMOUNT; i++) {
                    prStat.setInt(1, i);
                    prStat.setString(2, "товар" + i);
                    prStat.setFloat(3, (float) i * 10);
                    prStat.addBatch();
                }
                prStat.executeBatch();
                conn.commit();
                conn.setAutoCommit(true);
                System.out.println((System.currentTimeMillis() - time) / 1000);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void dropData() {
        try (Connection conn = MyConnection.getConnection()) {
            assert conn != null;
            try (Statement stat = conn.createStatement()) {
                stat.execute("DROP TABLE products ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
