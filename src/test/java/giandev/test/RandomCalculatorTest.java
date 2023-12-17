package giandev.test;

import giandev.test.resolver.RandomParameterResolver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
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
@Extensions({
        @ExtendWith(RandomParameterResolver.class)
})
public class RandomCalculatorTest {
    private Calculator calculator = new Calculator();

    @Test
    void testRandom(Random random, TestInfo info) {
        var a = random.nextInt();
        final var name = "gian";
        var b = random.nextInt();

        var result = calculator.add(a, b);
        var expected = a + b;

        Assertions.assertEquals(expected, result);
    }
}
