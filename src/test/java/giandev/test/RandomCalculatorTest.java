package giandev.test;

import giandev.test.resolver.RandomParameterResolver;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Random;

/**
 * Tidak ada magic di JUnit, sebenarnya fitur TestInfo yang sebelumnya kita bahas adalah bagian dari dependency injection di JUnit
 * Dependency Injection sederhananya adalah bagaimana kita bisa memasukkan dependency (object/instance)
 * -> ke dalam unit test secara otomatis tanpa proses manual
 * Saat kita menambah parameter di function unit test, sebenarnya kita bisa secara otomatis
 * memasukkan parameter tersebut dengan bantuan ParameterResolver
 * Contohnya TestInfo yang kita bahas sebelumya, sebenarnya objectnya dibuat oleh TestInfoParameterResolver
 */

public class RandomCalculatorTest extends AbstractCalculatorTest {
    @Test
    void testRandom(Random random, TestInfo info) {
        var a = random.nextInt();
        final var name = "gian";
        var b = random.nextInt();

        var result = calculator.add(a, b);
        var expected = a + b;

        Assertions.assertEquals(expected, result);
    }

    @RepeatedTest(
            value = 10,
            name = "{displayName} ke {currentRepetition} dari {totalRepetitions}"
    )
    @DisplayName("Test random calculator")
    void testRandomRepeat(Random random, TestInfo info) {
        var a = random.nextInt();
        final var name = "gian";
        var b = random.nextInt();

        var result = calculator.add(a, b);
        var expected = a + b;

        Assertions.assertEquals(expected, result);
    }


    @RepeatedTest(value = 10, name = "{displayName}")
    @DisplayName("Test random calculator")
    void testRandomRepeatInfo(Random random, TestInfo info, RepetitionInfo repetitionInfo) {
        System.out.println(info.getDisplayName() + " ke " + repetitionInfo.getCurrentRepetition() + " dari " + repetitionInfo.getTotalRepetitions());
        var a = random.nextInt();
        final var name = "gian";
        var b = random.nextInt();

        var result = calculator.add(a, b);
        var expected = a + b;

        Assertions.assertEquals(expected, result);
    }

    /**
     * Sebelumnya kita sudah tau jika ingin menambahkan parameter di function unit test, maka kita perlu membuat ParameterResolver
     * Namun jika terlalu banyak membuat ParameterResolver juga agak menyulitkan kita
     * JUnit memiliki fitur yang bernama @ParameterizedTest, dimana jenis unit test ini memang khusus dibuat agar dapat menerima parameter
     * Yang perlu kita lakukan adalah dengan mengganti @Test menjadi @ParameterizedTest
     */
    @DisplayName("Tes calculator")
    @ParameterizedTest(name = "{displayName} dengan parameter {0}")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7})
    void testWithParameter(int value) {
        var expected = value + value;
        var result = calculator.add(value, value);

        Assertions.assertEquals(expected, result);
    }

    public static List<Integer> parameterSource() {
        return List.of(1, 2, 3, 4, 5);
    }

    @DisplayName("Tes calculator")
    @ParameterizedTest(name = "{displayName} dengan parameter {0}")
    @MethodSource("parameterSource")
    void testWithMethodSource(Integer value) {
        var expected = value + value;
        var result = calculator.add(value, value);

        Assertions.assertEquals(expected, result);
    }
}
