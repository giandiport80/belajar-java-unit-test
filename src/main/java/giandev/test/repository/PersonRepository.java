package giandev.test.repository;

import giandev.test.data.Person;

public interface PersonRepository {
    Person selectById(String id);

    void insert(Person person);
}
