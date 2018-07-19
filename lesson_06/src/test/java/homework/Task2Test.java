package homework;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class Task2Test {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{3, 5, 1, 3, 4, 7, 4, 6},
                        new int[]{3, 5, 6, 4, 7, 8, 5, 6}},
                {new int[]{4, 4, 4, 4, 4, 4, 4, 1},
                        new int[]{3, 5, 6, 14, 7, 8, 5, 6}},
                {new int[]{4, 1, 1, 1, 1, 1, 1, 1},
                        new int[]{1, 1, 1, 1, 1, 1, 1, 1}},
                {new int[]{3 - 2, 5, 0, 3, 0, 7, 8, 2 * 2},
                        new int[]{4, 4, 4, 4, 4, 4, 4, 4}}
        });
    }

    private Task2 task2;
    private final int[] existArr;
    private final int[] absentArr;

    public Task2Test(int[] existArr, int[] absentArr) {
        this.existArr = existArr;
        this.absentArr = absentArr;
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