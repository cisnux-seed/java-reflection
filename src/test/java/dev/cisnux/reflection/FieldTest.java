package dev.cisnux.reflection;

import dev.cisnux.reflection.data.Person;
import org.junit.jupiter.api.Test;


public class FieldTest {
    @Test
    void testGetFields() {
        final var personClass = Person.class;

        final var fields = personClass.getDeclaredFields();
        for (final var field : fields) {
            System.out.println(field.getName() + " : " + field.getType().getName());
        }
    }

    @Test
    void testGetFieldValue() throws NoSuchFieldException, IllegalAccessException {
        final var personClass = Person.class;
        final var firstName = personClass.getDeclaredField("firstName");
        firstName.setAccessible(true);

        Person person1 = new Person("Fajra", "Risqulla");
        String result = (String) firstName.get(person1);
        System.out.println(result);

        Person person2 = new Person("Cisnux", "Predator");
        String result2 = (String) firstName.get(person2);
        System.out.println(result2);
    }

    @Test
    void testSetFieldValue() throws NoSuchFieldException, IllegalAccessException {
        final var personClass = Person.class;
        final var firstName = personClass.getDeclaredField("firstName");
        firstName.setAccessible(true);

        Person person1 = new Person("Fajra", "Risqulla");
        System.out.println(person1.getFirstName());
        firstName.set(person1, "fajra@gmail.com"); // person1.setFirstName("Joko");
        System.out.println(person1.getFirstName());

        Person person2 = new Person("Cisnux", "Predator");
        System.out.println(person2.getFirstName());
        firstName.set(person2, "cisnux@gmail.com"); // person2.setFirstName("Tono");
        System.out.println(person2.getFirstName());
    }
}
