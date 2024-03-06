package dev.cisnux.reflection;

import dev.cisnux.reflection.data.Product;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;

public class RecordTest {
    @Test
    void testClassRecord() {
        final var productClass = Product.class;

        System.out.println(productClass.isRecord());
        System.out.println(Arrays.toString(productClass.getDeclaredFields()));
        System.out.println(Arrays.toString(productClass.getDeclaredMethods()));
        System.out.println(Arrays.toString(productClass.getDeclaredConstructors()));
        System.out.println(Arrays.toString(productClass.getRecordComponents()));
    }

    @Test
    void testGetRecordValue() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        final var productClass = Product.class;
        final var id = productClass.getDeclaredMethod("id");

        Product product = new Product("1", "Apple iPhone", 20000000L);
        System.out.println(id.invoke(product));

    }

    @Test
    void testGetRecordValueByComponent() throws InvocationTargetException, IllegalAccessException {
        final Class<Product> productClass = Product.class;
        final RecordComponent[] components = productClass.getRecordComponents();

        Product product = new Product("1", "Macbook Air M2", 20_000_000L);

        for (RecordComponent component : components) {
            final Method accessor = component.getAccessor();
            System.out.println(accessor.getName());
            System.out.println(accessor.invoke(product));
        }
    }
}
