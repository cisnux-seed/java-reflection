package dev.cisnux.reflection.data;

import dev.cisnux.reflection.annotations.NotBlank;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

final public class Person implements Nameable, Serializable {
    @NotBlank
    private String firstName;

    @NotBlank(isBlank = true)
    private String lastName;

    private List<String> hobbies;

    private int age;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return getAge() == person.getAge() && Objects.equals(getFirstName(), person.getFirstName()) && Objects.equals(getLastName(), person.getLastName()) && Objects.equals(getHobbies(), person.getHobbies());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getHobbies(), getAge());
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", hobbies=" + hobbies +
                ", age=" + age +
                '}';
    }
}
