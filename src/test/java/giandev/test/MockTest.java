package giandev.test;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

/**
 * Mocking sederhananya adalah membuat object tiruan
 * Hal ini dilakukan agar behavior object tersebut bisa kita tentukan sesuai dengan keinginan kita
 * Dengan mocking, kita bisa membuat request response seolah-olah object tersebut benar dibuat
 */
public class MockTest {
    @Test
    void testMock() {
        List<String> list = Mockito.mock(List.class);

        // menambah behavior
        Mockito.when(list.get(0)).thenReturn("Gian");
        Mockito.when(list.get(100)).thenReturn("Nurwana");

        System.out.println(list.get(0));
        System.out.println(list.get(100));

        Mockito.verify(list, Mockito.times(1)).get(0);
    }
}
