package dev.cisnux.reflection.validator;

import dev.cisnux.reflection.annotations.NotBlank;

import java.lang.reflect.Field;

public class Validator {
    public static void validateNotBlank(Object object) throws IllegalAccessException {

        // get class
        final Class<?> aClass = object.getClass();

        // get all fields
        final Field[] fields = aClass.getDeclaredFields();

        // iterate each field
        for (Field field : fields) {

            // get not blank annotation
            final NotBlank notBlank = field.getAnnotation(NotBlank.class);

            // check if @NotBlank is existed
            if (notBlank != null) {

                // get field value
                field.setAccessible(true);
                String value = (String) field.get(object);

                if (notBlank.isBlank())
                    return;

                // check if value is blank
                if (value.trim().isBlank()) {
                    // throw error
                    throw new RuntimeException(field.getName() + " must not be blank");
                }
            }
        }
    }

}
