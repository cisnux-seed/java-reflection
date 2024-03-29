package dev.cisnux.reflection;

import dev.cisnux.reflection.data.Nameable;
import dev.cisnux.reflection.data.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class InterfaceTest {
    @Test
    void testClass() {
        final Class<Nameable> nameableClass = Nameable.class;

        System.out.println(nameableClass.getName());
        System.out.println(nameableClass.isInterface());
        System.out.println(nameableClass.getSuperclass());
        System.out.println(Arrays.toString(nameableClass.getInterfaces()));
        System.out.println(Arrays.toString(nameableClass.getDeclaredFields()));
        System.out.println(Arrays.toString(nameableClass.getDeclaredMethods()));
        System.out.println(Arrays.toString(nameableClass.getDeclaredConstructors()));
    }

    @Test
    void testSuperInterfaces() {
        final Class<Person> personClass = Person.class;

        System.out.println(Arrays.toString(personClass.getInterfaces()));
    }
}
