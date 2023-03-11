package ru.itis.serialization_example;

import ru.itis.serialization_example.model.Animal;
import ru.itis.serialization_example.model.Cat;
import ru.itis.serialization_example.model.Dog;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Sandbox {
    private static final File file = new File("users/animals.txt");

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            animals.add(new Cat("Boris", 2));
            animals.add(new Cat("Alex", 3));
            animals.add(new Dog("Avakum", 3, "Špitz"));
            outputStream.writeObject(animals);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            animals = (List<Animal>) objectInputStream.readObject();
            System.out.println(animals.get(0));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
