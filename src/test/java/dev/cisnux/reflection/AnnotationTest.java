package dev.cisnux.reflection;

import dev.cisnux.reflection.data.Person;
import dev.cisnux.reflection.validator.Validator;
import org.junit.jupiter.api.Test;

public class AnnotationTest {
    @Test
    void testValidateUsingAnnotation() throws IllegalAccessException {
        final var person = new Person("Fajra", " ");
        Validator.validateNotBlank(person);
    }
}
