import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CalculatorTest {

    @Parameterized.Parameters
    public static Collection<Object []> data(){
        return Arrays.asList(new Object[][]{
                {5, 4, 1,
                        5, 15, 3},
                {7, 3, 4,
                        3, 6, 2},
                {45, 34, 11,
                        30, 150, 5}});
    }

    private int addExp;
    private int addSl1;
    private int addSl2;

    private int divExp;
    private int divDvn;
    private int divDvr;

    public Calculator calc;

    public CalculatorTest(int addExp, int addSl1, int addSl2, int divExp, int divDvn, int divDvr) {
        this.addExp = addExp;
        this.addSl1 = addSl1;
        this.addSl2 = addSl2;
        this.divExp = divExp;
        this.divDvn = divDvn;
        this.divDvr = divDvr;
    }

    @Before
    public void setUp() throws Exception {
        calc = new Calculator();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void add() {
        int a = addSl1;
        int b = addSl2;
        int expect = addExp;
        int actual = calc.add(a, b);
        assertEquals(expect, actual);
    }

    @Test
    public void sub() {
        int a = 7;
        int b = 3;
        int expect = 4;
        int actual = calc.sub(a, b);
        assertEquals(expect, actual);
    }

    @Test
    public void mul() {
        int a = 5;
        int b = 7;
        int expect = 35;
        int actual = calc.mul(a, b);
        assertEquals(expect, actual);
    }

    @Test//(expected = ArithmeticException.class)
    public void div() {
        int a = divDvn;
        int b = divDvr;
        int expect = divExp;
        int actual = calc.div(a, b);
        assertEquals(expect, actual);
    }
}