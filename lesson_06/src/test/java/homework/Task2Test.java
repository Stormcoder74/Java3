package homework;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class Task2Test {

    private Task2 task2;
    private final int[] existArr;
    private final int[] absentArr;

    public Task2Test() {
        this.existArr = new int[]{3, 5, 1, 3, 4, 7, 4, 6};
        this.absentArr = new int[]{3, 5, 6, 4, 7, 8, 5, 6};
    }

    @Before
    public void setUp() {
        task2 = new Task2();
    }

    @Test
    public void checkExistAbsentFor1And4() {
        assertTrue(task2.checkFor1And4(existArr));
        assertFalse(task2.checkFor1And4(absentArr));
    }
}