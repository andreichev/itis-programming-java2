package ru.itis.collections.sorting;

public class Student implements CoolComparable<Student> {
    public String name;
    public int height;

    public Student(String name, int height) {
        this.name = name;
        this.height = height;
    }

    @Override
    public int compareTo(Student o) {
        if (height == o.height) {
            return 0;
        }
        if (height > o.height) {
            return 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        return name + " " + height;
    }
}
