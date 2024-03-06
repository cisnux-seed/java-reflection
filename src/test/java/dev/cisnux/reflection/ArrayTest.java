package dev.cisnux.reflection;

import dev.cisnux.reflection.data.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayTest {
    @Test
    void testArrayClass() {
        final Class<String[]> stringArrayClass = String[].class;
        final Class<int[]> intArrayClass = int[].class;
        final Class<Person> personClass = Person.class;

        System.out.println(stringArrayClass.isArray());
        System.out.println(intArrayClass.isArray());
        System.out.println(personClass.isArray());
    }

    @Test
    void testArrayMember() {
        final Class<String[]> stringArrayClass = String[].class;

        System.out.println(Arrays.toString(stringArrayClass.getDeclaredFields()));
        System.out.println(Arrays.toString(stringArrayClass.getDeclaredConstructors()));
        System.out.println(Arrays.toString(stringArrayClass.getDeclaredMethods()));
        System.out.println(stringArrayClass.getComponentType());

    }

    @Test
    void testArrayManipulation() {
        final Class<String[]> stringArrayClass = String[].class;
        final String[] array = (String[]) Array.newInstance(stringArrayClass.getComponentType(), 10);

        System.out.println(Arrays.toString(array));

        Array.set(array, 0, "Fajra");
        Array.set(array, 1, "Risqulla");
        Array.set(array, 2, "Cisnux");

        System.out.println(Arrays.toString(array));

        System.out.println(Array.get(array, 0));
        System.out.println(Array.get(array, 1));
        System.out.println(Array.get(array, 2));
    }
}
