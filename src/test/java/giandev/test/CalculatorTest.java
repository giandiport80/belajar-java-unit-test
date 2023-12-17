package giandev.test;


import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    /**
     * konvensi penamaan
     * test method Add dengan skenario success
     */
    @Test
    public void testAddSuccess() {
        Integer result = calculator.add(10, 20);
    }
}
