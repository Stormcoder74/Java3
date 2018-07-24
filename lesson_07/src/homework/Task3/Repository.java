package homework.Task3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Repository {

    public void add(Connection conn, Student student) {
        try (PreparedStatement prStat = conn.prepareStatement(
                "INSERT INTO students (id, family, mark) VALUES (?, ?, ?);")) {
            prStat.setInt(1, student.getId());
            prStat.setString(2, student.getFamily());
            prStat.setInt(3, student.getMark());
            prStat.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Connection conn, Student student) {
        String query = "UPDATE students SET mark = ?  WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, student.getMark());
            ps.setInt(2, student.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Student get(Connection conn, int id) {
        String query = "SELECT * FROM students WHERE id = ?";
        Student student = null;
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    student = new Student(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getInt(3));
                } else {
                    System.out.println("Такого студента нет");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public void remove(Connection conn, int id) {
        String query = "DELETE FROM students WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
