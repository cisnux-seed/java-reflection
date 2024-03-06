package dev.cisnux.reflection;

import dev.cisnux.reflection.data.Person;
import org.junit.jupiter.api.Test;

public class SuperClassTest {
    @Test
    void testGetSuperClass() {
        final Class<Person> personClass = Person.class;
        System.out.println(personClass);

        final Class<? super Person> objectClass = personClass.getSuperclass();
        System.out.println(objectClass);

        final Class<? super Person> nullClass = objectClass.getSuperclass();
        System.out.println(nullClass);
    }
}
