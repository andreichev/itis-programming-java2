package ru.itis.serialization_example.model;

import java.io.Serializable;

public class User implements Serializable {
    private String firstName;
    private String lastName;
    private int age;
    private String group;
    private Car car;

    public User(String firstName, String lastName, int age, String group, Car car) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.group = group;
        this.car = car;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
