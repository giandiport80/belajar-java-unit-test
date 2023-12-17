package giandev.test;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * Urutan Eksekusi Test
 * Secara default, urutan eksekusi unit test tidak ditentukan,
 * jadi jangan berharap jika sebuah method berada diatas method lainnya, maka akan dijalankan lebih dulu
 * Hal ini karena memang sebaiknya method unit test itu harus independen, tidak saling ketergantungan
 * Secara default pun, object class unit test akan selalu dibuat ulang tiap method, jadi jangan berharap
 * kita bisa menyimpan data di variable untuk digunakan di unit test method selanjutnya
 */
public class LifeCycleTest {
    private String temp;

    @Test
    void testA() {
        temp = "Gian";
    }

    @Test
    void testB() {
        System.out.println(temp);
    }
}
