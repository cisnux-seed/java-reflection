package dev.cisnux.reflection;

import dev.cisnux.reflection.data.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ClassTest {
    @Test
    void testCreateClass() throws ClassNotFoundException {

        final var personClass1 = Person.class;

        final var personClass2 = Class.forName("dev.cisnux.reflection.data.Person");

        Person person = new Person();
        final Class<? extends Person> personClass3 = person.getClass();
    }

    @Test
    void testClassMethod() {
        final var personClass = Person.class;

        System.out.println(personClass.getSuperclass());
        System.out.println(Arrays.toString(personClass.getInterfaces()));
        System.out.println(Arrays.toString(personClass.getDeclaredConstructors()));
        System.out.println(Arrays.toString(personClass.getDeclaredMethods()));
        System.out.println(Arrays.toString(personClass.getDeclaredFields()));
        System.out.println(personClass.getModifiers());
        System.out.println(personClass.getPackage());
        System.out.println(personClass.getName());
        System.out.println(personClass.getSimpleName());
    }
}
