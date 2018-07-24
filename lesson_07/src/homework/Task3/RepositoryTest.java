package homework.Task3;

import homework.AfterSuite;
import homework.Before;
import homework.BeforeSuite;
import homework.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RepositoryTest {

    private static Connection conn;
    private static int nextRecord;

    private Repository rep;

    @BeforeSuite
    public static void initTest() {
        try {
            conn = MyConnection.getConnection();
            assert conn != null;
            conn.setAutoCommit(false);
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

    @AfterSuite
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
        if(student.equals(result)){
            System.out.println("Тест checkingThePossibilityOfAddingAndReading пройден");
        }
        try {
            conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 8)
    public void checkingThePossibilityOfUpdate() {
        Student student = new Student(nextRecord, "Герасимов", 10);
        rep.add(conn, student);
        student.setMark(7);
        rep.update(conn, student);
        Student result = rep.get(conn, nextRecord);
        if(student.equals(result)){
            System.out.println("Тест checkingThePossibilityOfUpdate пройден");
        }
        try {
            conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}