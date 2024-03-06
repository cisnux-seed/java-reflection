package dev.cisnux.reflection;

import dev.cisnux.reflection.data.Data;
import org.junit.jupiter.api.Test;

import java.lang.reflect.TypeVariable;
import java.util.Arrays;

public class TypeVariableTest {
    @Test
    void testGetTypeVariables() {
        final var dataClass = Data.class;
        final var typeVariables = dataClass.getTypeParameters();

        for (final var variable : typeVariables) {
            System.out.println(variable.getName());
            System.out.println(Arrays.toString(variable.getBounds()));
            System.out.println(variable.getGenericDeclaration());
        }
    }
}
