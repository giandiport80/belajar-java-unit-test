package giandev.test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    /**
     * konvensi penamaan
     * test method Add dengan skenario success
     */
    @Test
    public void testAddSuccess() {
        Integer result = calculator.add(10, 10);

        assertEquals(20, result);
    }

    @Test
    public void testDivideSuccess() {
        var result = calculator.divide(100, 10);

        // test harus sama
        assertEquals(10, result);
    }

    @Test
    public void testDivideFailed() {
        // test harus throw error
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });
    }
}
