package giandev.test;

import org.junit.jupiter.api.*;

/**
 * Informasi test
 * kita juga bisa mendapatkan informasi test yang sedang berjalan menggunakan interface TestInfo
 * Kita bisa menambahkan TestInfo sebagai parameter di function unit test
 */
@DisplayName("information test")
public class InformationTest {
    @Test
    @Tags({
            @Tag("One"),
            @Tag("Two")
    })
    @DisplayName("this is test 1")
    void test1(TestInfo info) {
        System.out.println(info.getDisplayName());
        System.out.println(info.getTags());
        System.out.println(info.getTestClass().orElse(null));
        System.out.println(info.getTestMethod().orElse(null));
    }
}
