package dev.cisnux.reflection;

import dev.cisnux.reflection.data.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ConstructorTest {
    @Test
    void testGetConstructors() {
        final var personClass = Person.class;
        final Constructor<?>[] constructors = personClass.getDeclaredConstructors();
        for (final Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName());
            System.out.println(Arrays.toString(constructor.getParameterTypes()));
            System.out.println("=========");
        }
    }

    @Test
    void testCreateObjectUsingConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        final var personClass = Person.class;

        final Constructor<Person> constructor = personClass.getConstructor();
        final Constructor<Person> constructorParameters = personClass.getConstructor(String.class, String.class);

        Person person1 = constructor.newInstance();
        Person person2 = constructorParameters.newInstance("Fajra", "Risqulla");

        System.out.println(person1);
        System.out.println(person2);
    }
}
