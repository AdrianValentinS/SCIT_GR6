import org.junit.Test;

import static org.junit.Assert.*;
public class CalculatorMainTest {

    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {
    }
    @Test
    public void testConvertToMM() {
        int testNum0 = CalculatorMain.convertToMM(10, "cm");
        int testNum1 = CalculatorMain.convertToMM(1, "m");
        int testNum2 = CalculatorMain.convertToMM(10, "mm");
        assertEquals(100, testNum0);
        assertEquals(1000, testNum1);
        assertEquals(10, testNum2);
    }
    @Test
    public void calculateExpressionTest() {
        int testResult = CalculatorMain.doCalculation(0, 10, 1, 10, "cm", "m", "mm", '+', '-');

        assertEquals(1090, testResult);
    }
    @Test
    public void calculateExpressionTestFailureState() {
    }


}