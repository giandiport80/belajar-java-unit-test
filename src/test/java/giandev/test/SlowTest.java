package giandev.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

/**
 * JUnit memiliki fitur timeout, yaitu memastikan bahwa unit test berjalan tidak lebih dari waktu yang ditentukan,
 * jika melebihi waktu yang ditentukan, secara otomatis unit test tersebut akan gagal
 * Kita bisa menggunakan annotation @Timeout untuk melakukan hal tersebut
 */
public class SlowTest {
    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void testSlow() throws InterruptedException {
//        Thread.sleep(10_000);
    }
}
