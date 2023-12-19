package giandev.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.concurrent.TimeUnit;

/**
 * Timeout di test
 * JUnit memiliki fitur timeout, yaitu memastikan bahwa unit test berjalan tidak lebih dari waktu yang ditentukan,
 * jika melebihi waktu yang ditentukan, secara otomatis unit test tersebut akan gagal
 * Kita bisa menggunakan annotation @Timeout untuk melakukan hal tersebut
 * ==============
 * Eksekusi Test Secara Paralel
 * Secara default, JUnit tidak mendukung eksekusi unit test secara paralel, artinya unit test akan dijalankan secara sequential satu per satu
 * Namun kadang ada kasus kita ingin mempercepat proses unit test sehingga dijalankan secara paralel,
 * hal ini bisa kita lakukan di JUnit, namun perlu beberapa langkah
 * Tapi ingat, pastikan unit test kita aman ketika dijalankan secara paralel
 * =============
 * Walaupun sudah mengaktifkan fitur paralel, tapi bukan berarti secara otomatis semua unit test
 * berjalan paralel, agar unit test berjalan paralel, kita perlu menggunakan annotation @Execution
 * Lalu memilih jenis execution nya, misal untuk paralel bisa menggunakan ExecutionMode.CONCURRENT
 */
@Execution(ExecutionMode.CONCURRENT)
public class SlowTest {
    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void testSlow1() throws InterruptedException {
        Thread.sleep(4_000);
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void testSlow2() throws InterruptedException {
        Thread.sleep(4_000);
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void testSlow3() throws InterruptedException {
        Thread.sleep(4_000);
    }
}
