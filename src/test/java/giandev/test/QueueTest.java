package giandev.test;

import org.junit.jupiter.api.*;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Saat membuat unit test, ada baiknya ukuran test class nya tidak terlalu besar, karena akan sulit dibaca dan dimengerti.
 * Jika test class sudah semakin besar, ada baiknya kita pecah menjadi beberapa test class
 * , lalu kita grouping sesuai dengan jenis method test nya.
 * JUnit mendukung pembuatan class test di dalam class test, jadi kita bisa memecah sebuah class test
 * , tanpa harus membuat class di file berbeda, kita bisa cukup menggunakan inner class
 * Untuk memberi tahu bahwa inner class tersebut adalah test class, kita bisa menggunakan annotation @Nested
 */
@DisplayName("A Queue")
public class QueueTest {
    private Queue<String> queue;

    @Nested
    @DisplayName("When new")
    public class WhenNew {

        @BeforeEach
        void setUp() {
            queue = new LinkedList<>();
        }

        @Test
        @DisplayName("When offer, size must be 1")
        void offerNewData() {
            queue.offer("Gian");

            Assertions.assertEquals(1, queue.size());
        }

        @Test
        @DisplayName("When offer 2 data, size must be 2")
        void offerMoreData() {
            queue.offer("Indra");
            queue.offer("Kurniawan");

            Assertions.assertEquals(2, queue.size());
        }
    }
}
