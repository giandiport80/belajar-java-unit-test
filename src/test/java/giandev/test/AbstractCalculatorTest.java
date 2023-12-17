package giandev.test;

import giandev.test.resolver.RandomParameterResolver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;

/**
 * Pewarisan di test
 * JUnit mendukung pewarisan di test, artinya jika kita membuat class atau interface dan
 * -> menambahkan informasi test disitu, maka ketika kita membuat turunannya
 * ,secara otomatis semuafitur test nya dimiliki oleh turunannya
 */
@Extensions({
        @ExtendWith(RandomParameterResolver.class)
})
public class AbstractCalculatorTest {
    protected Calculator calculator = new Calculator();

    @BeforeEach
    void setUp() {
        System.out.println("Before each");
    }
}
