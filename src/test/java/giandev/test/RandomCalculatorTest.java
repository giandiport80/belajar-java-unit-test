package giandev.test;

import giandev.test.resolver.RandomParameterResolver;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;

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
}
