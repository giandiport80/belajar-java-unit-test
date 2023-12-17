package giandev.test;


import static org.junit.jupiter.api.Assertions.*;

import giandev.test.generator.SimpleDisplayNameGenerator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

//@DisplayName("Test untuk Calculator class")
@DisplayNameGeneration(SimpleDisplayNameGenerator.class)
public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    /**
     * konvensi penamaan
     * test method Add dengan skenario success
     */
    @Test
//    @DisplayName("Test skenario sukses untuk method add(integer, integer)")
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

    /**
     * menonaktifkan test dengan @Disabled
     */
    @Test
    @Disabled
    public void testCommingSoon() {
        
    }
}
