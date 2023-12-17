package giandev.test;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

/**
 * tag
 * memilih tag dengan maven
 * Dengan menambahkan tag ke dalam unit test, kita bisa fleksibel ketika menjalan unit test,
 * bisa memilih tag mana yang mau di include atau di exclude
 * mvn test -Dgroups=integration-test
 */
@Tags({
        @Tag("integration-test")
})
public class SampleIntegrationTest {
    @Test
    void test1() {
    }

    @Test
    void test2() {
    }
}
