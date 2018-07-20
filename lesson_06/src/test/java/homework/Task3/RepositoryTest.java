package homework.Task3;

import org.junit.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;

public class RepositoryTest {

    private static Connection conn;
    private static int nextRecord;

    private Repository rep;

    @BeforeClass
    public static void initTest() {
        try {
            conn = MyConnection.getConnection();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        assert conn != null;
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM students")) {
            while (rs.next()) {
                nextRecord = rs.getInt(1) + 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void closeTest() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void setUp() {
        rep = new Repository();
    }

    @Test
    public void checkingThePossibilityOfAddingAndReading() {
        Student student = new Student(nextRecord, "Герасимов", 10);
        rep.add(conn, student);
        Student result = rep.get(conn, nextRecord);
        assertEquals(student, result);
        rep.remove(conn, nextRecord);
    }

    @Test
    public void checkingThePossibilityOfUpdate() {
        Student student = new Student(nextRecord, "Герасимов", 10);
        rep.add(conn, student);
        student.setMark(7);
        rep.update(conn, student);
        Student result = rep.get(conn, nextRecord);
        assertEquals(student, result);
        rep.remove(conn, nextRecord);
    }
}