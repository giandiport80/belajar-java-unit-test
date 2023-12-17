package giandev.test;


import static org.junit.jupiter.api.Assertions.*;

import giandev.test.generator.SimpleDisplayNameGenerator;
import org.junit.jupiter.api.*;
import org.opentest4j.TestAbortedException;

//@DisplayName("Test untuk Calculator class")
@DisplayNameGeneration(SimpleDisplayNameGenerator.class)
public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before All");
    }

    /**
     * Namun kadang kita ingin melakukan sesuatu sebelum semua unit test berjalan, atau setelah semua unit test berjalan
     * Ini bisa dilakukan menggunakan annotation @BeforeAll dan @AfterAll
     * Namun hanya static function yang bisa menggunakan @BeforeAll dan @AfterAll
     */
    @AfterAll
    public static void afterAll() {
        System.out.println("After All");
    }

    /**
     * BeforeEach digunakan untuk menandai function yang akan dieksekusi sebelum unit test dijalankan
     */
    @BeforeEach
    public void setUp() {
        System.out.println("Before Each");
    }

    /**
     * AfterEach digunakan untuk menandai function yang akan dieksekusi sebelum unit test dijalankan
     */
    @AfterEach
    public void tearDown() {
        System.out.println("After Each");
    }

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

    /**
     * Kadang kita ingin membatalkan unit test ketika kondisi tertentu terjadi
     * Untuk membatalkan, kita bisa menggunakan exception TestAbortedException
     * Jika JUnit mendapatkan exception TestAbortedException, secara otomatis test tersebut akan dibatalkan
     */
    @Test
    public void testAborted() {
        var profile = System.getenv("PROFILE");

        if (!"DEV".equals(profile)) {
            throw new TestAbortedException("Test dibatalkan karena bukan DEV");
        }
    }
}
