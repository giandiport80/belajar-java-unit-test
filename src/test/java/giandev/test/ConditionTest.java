package giandev.test;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.util.Properties;

/**
 * Sebenarnya kita bisa menggunakan Assumptions untuk menjalankan unit test berdasarkan kondisi tertentu
 * Namun JUnit menyediakan fitur yang lebih mudah untuk pengecekan beberapa kondisi,
 * kondisi sistem operasi, versi java, system property atau environment variable
 * Ini lebih mudah dibandingkan menggunakan Assumptions
 */
@Tags({
        @Tag("integration-test")
})
public class ConditionTest {

    @Test
    void testSystemProperties() {
        Properties properties = System.getProperties();

        properties.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    @Test
    @EnabledOnOs({OS.WINDOWS})
    public void testRunOnlyWindows() {

    }

    @Test
    @DisabledOnOs({OS.WINDOWS})
    public void testDisabledOnWindows() {

    }

    @Test
    @EnabledOnJre({JRE.JAVA_8})
    void testEnabledOnJava8() {
    }

    @Test
    @DisabledOnJre({JRE.JAVA_8})
    void testDisabledOnJava8() {
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_17)
    void testEnabledOnJava11to17() {

    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_17)
    void testDisabledOnJava11to17() {

    }

    @Test
    @EnabledIfSystemProperties({
            @EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    })
    void testEnabledJavaVendorOracle() {

    }

    @Test
    @DisabledIfSystemProperties({
            @DisabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    })
    void testDisabledJavaVendorOracle() {

    }

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    })
    void testEnabledForProfileDev() {
    }

    @Test
    @DisabledIfEnvironmentVariables({
            @DisabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    })
    void testDisabledForProfileDev() {
    }
}
