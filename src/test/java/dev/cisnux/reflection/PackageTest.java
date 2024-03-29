package dev.cisnux.reflection;

import dev.cisnux.reflection.data.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class PackageTest {
    @Test
    void testGetPackage() {
        final var personClass = Person.class;

        Package aPackage = personClass.getPackage();

        System.out.println(aPackage.getName());
        System.out.println(Arrays.toString(aPackage.getAnnotations()));
    }
}
