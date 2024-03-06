package dev.cisnux.reflection;

import dev.cisnux.reflection.data.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class ParameterTypeTest {
    @Test
    void testFieldGeneric() throws NoSuchMethodException, NoSuchFieldException {
        Class<Person> personClass = Person.class;
        Field hobbies = personClass.getDeclaredField("hobbies");
        hobbies.setAccessible(true);

        Type type = hobbies.getGenericType();
        System.out.println(type.getClass());

        if (type instanceof ParameterizedType parameterizedType) {
            System.out.println(parameterizedType.getRawType());
            System.out.println(parameterizedType.getOwnerType());
            System.out.println(Arrays.toString(parameterizedType.getActualTypeArguments()));
        }
    }

    @Test
    void getGetMethodGeneric() throws NoSuchMethodException {
        final Class<Person> personClass = Person.class;
        final Method getHobbies = personClass.getDeclaredMethod("getHobbies");

        final Type type = getHobbies.getGenericReturnType();
        System.out.println(type.getClass());

        if (type instanceof ParameterizedType parameterizedType) {
            System.out.println(parameterizedType.getRawType());
            System.out.println(parameterizedType.getOwnerType());
            System.out.println(Arrays.toString(parameterizedType.getActualTypeArguments()));
        }
    }

    @Test
    void getGetMethodParameterGeneric() throws NoSuchMethodException {
        final Class<Person> personClass = Person.class;
        final Method getHobbies = personClass.getDeclaredMethod("setHobbies", List.class);

        final Type[] types = getHobbies.getGenericParameterTypes();
        for (Type type : types) {
            System.out.println(type.getClass());

            if (type instanceof ParameterizedType parameterizedType) {
                System.out.println(parameterizedType.getRawType());
                System.out.println(parameterizedType.getOwnerType());
                System.out.println(Arrays.toString(parameterizedType.getActualTypeArguments()));
            }
        }
    }
}
