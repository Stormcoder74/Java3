package homework;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class Task1Test {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{3, 4, 3, 5, 7, 1, 4, 5, 0, 7, 5}, new int[]{5, 7, 7, 5}},
                {new int[]{4, 3, 8, 5, 7, 3, 5, 2, 4, 9, 6}, new int[]{9, 6}},
                {new int[]{3, 4, 3, 5, 0, 1, 4, 5, 7, 8, 4}, new int[]{}},
                {new int[]{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, new int[]{}}
        });
    }

    private Task1 task1;
    private int[] inArr;
    private int[] expected;

    public Task1Test(int[] inArr, int[] expected) {
        this.inArr = inArr;
        this.expected = expected;
    }

    @Before
    public void setUp() {
        task1 = new Task1();
    }

    @Test
    public void checkArrayAfterLast4() {
        int[] actual = task1.afterLast4(inArr);
        assertArrayEquals(expected, actual);
    }

    @Test(expected = RuntimeException.class)
    public void checkException() {
        int[] arr = {3, 0, 6, 7, 5};
        task1.afterLast4(arr);
    }
}