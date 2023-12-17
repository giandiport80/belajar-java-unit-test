package giandev.test;

import org.junit.jupiter.api.*;

/**
 * MethodName: diurutkan berdasarkan nama method
 * Random: diurutkan secara random
 * OrderAnnotation: diurutkan sesuai @Order
 * secara default lifecycle test adalah PER_METHOD
 * kita bisa ubah menjadi PER_CLASS
 * Salah satu keuntungan saat menggunakan Lifecycle.PER_CLASS adalah, kita bisa menggunakan
 * BeforeAll dan AfterAll di method biasa, tidak harus menggunakan function object / static
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class OrderedTest {

    private int counter = 0;

    @BeforeAll
    void beforeAll() {
        System.out.println("Before All");
    }

    @AfterAll
    void afterAll() {
        System.out.println("After All");
    }

    @Test
    @Order(1)
    void test3() {
        counter++;
        System.out.println(counter);
    }

    @Test
    @Order(2)
    void test2() {
        counter++;
        System.out.println(counter);
    }

    @Test
    @Order(3)
    void test1() {
        counter++;
        System.out.println(counter);
    }
}
