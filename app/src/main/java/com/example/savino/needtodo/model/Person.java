package com.example.savino.needtodo.model;

public class Person {

    String name;
    String surname;
    int age;
    boolean bool;

    public Person(String name, String surname, int age, boolean bool) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.bool = bool;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public boolean isBool() {
        return bool;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (bool != person.bool) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        return surname != null ? surname.equals(person.surname) : person.surname == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (bool ? 1 : 0);
        return result;
    }
}
