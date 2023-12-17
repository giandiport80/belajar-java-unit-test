package giandev.test;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * MethodName: diurutkan berdasarkan nama method
 * Random: diurutkan secara random
 * OrderAnnotation: diurutkan sesuai @Order
 */
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class OrderedTest {
    @Test
    @Order(1)
    void test3() {

    }

    @Test
    @Order(2)
    void test2() {
    }

    @Test
    @Order(3)
    void test1() {
    }
}
