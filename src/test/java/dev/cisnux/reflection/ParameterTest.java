package dev.cisnux.reflection;

import dev.cisnux.reflection.data.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

public class ParameterTest {
    @Test
    void getGetParameters() {
        final var personClass = Person.class;
        final var methods = personClass.getDeclaredMethods();
        for (final var method : methods) {
            System.out.println(method.getName());
            final var parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println("Parameter Name : " + parameter.getName());
                System.out.println("Parameter Type : " + parameter.getType());
            }
            System.out.println("===========");
        }
    }


    @Test
    void testInvokeMethodWithParameter() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        final var personClass = Person.class;
        final var setFirstName = personClass.getDeclaredMethod("setFirstName", String.class);

        Person person = new Person("Fajra", "Risqulla");
        setFirstName.invoke(person, "Cisnux");

        System.out.println(person.getFirstName());
    }
}
