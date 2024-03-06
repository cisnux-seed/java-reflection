package dev.cisnux.reflection;

import dev.cisnux.reflection.data.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class MethodTest {
    @Test
    void testGetMethods() {
        final var personClass = Person.class;
        final var methods = personClass.getDeclaredMethods();

        for (final var method : methods) {
            System.out.println(method.getName());
            System.out.println(method.getReturnType());
            System.out.println(Arrays.toString(method.getParameterTypes()));
            System.out.println(Arrays.toString(method.getExceptionTypes()));
            System.out.println("===============");
        }
    }

    @Test
    void testGetMethodValue() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        final var personClass = Person.class;
        final var getFirstName = personClass.getDeclaredMethod("getFirstName");

        Person person = new Person("Fajra", "Risqulla");
        String firstName = (String) getFirstName.invoke(person);
        System.out.println(firstName);
    }
}
