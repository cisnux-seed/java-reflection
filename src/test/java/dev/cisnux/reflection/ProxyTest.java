package dev.cisnux.reflection;

import dev.cisnux.reflection.data.Car;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyTest {
    @Test
    void testProxy() {
        InvocationHandler invocationHandler = (proxy, method, args) -> {
            if(method.getName().equals("getName")){
                return "Car Proxy";
            }

            if(method.getName().equals("run")){
                System.out.println("Car is running");
            }

            if (method.getName().equals("getTiles"))
                return 4;

            return null;
        };

        Car car = (Car) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{Car.class}, invocationHandler);

        System.out.println(car.getClass());
        System.out.println(car.getName());

        car.run();
        System.out.println(car.getTiles());
    }
}
