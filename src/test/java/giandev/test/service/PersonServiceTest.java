package giandev.test.service;

import giandev.test.data.Person;
import giandev.test.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@Extensions({
        @ExtendWith(MockitoExtension.class)
})
public class PersonServiceTest {
    @Mock
    private PersonRepository personRepository;

    private PersonService personService;

    @BeforeEach
    void setUp() {
        personService = new PersonService(personRepository);
    }

    @Test
    void testGetPersonNotFound() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            personService.get("Not Found");
        });
    }

    @Test
    void testGetPersonSuccess() {
        // menambah behavior ke mock object
        Mockito.when(personRepository.selectById("gian"))
                .thenReturn(new Person("gian", "Gian Nurwana"));

        var person = personService.get("gian");

        Assertions.assertNotNull(person);
        Assertions.assertEquals("gian", person.getId());
        Assertions.assertEquals("Gian Nurwana", person.getName());
    }

}
