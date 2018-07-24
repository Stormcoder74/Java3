package homework.Task3;

import java.util.Objects;

public class Student {
    private int id;
    private String family;
    private int mark;

    public Student(int id, String family, int mark) {
        this.id = id;
        this.family = family;
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                mark == student.mark &&
                Objects.equals(family, student.family);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, family, mark);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
