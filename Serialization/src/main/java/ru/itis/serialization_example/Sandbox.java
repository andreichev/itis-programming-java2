package ru.itis.serialization_example;

import ru.itis.serialization_example.model.Car;
import ru.itis.serialization_example.model.User;

import java.io.*;

public class Sandbox {
    private static final File file = new File("users/list.txt");

    public static void main(String[] args) {
        Car car = new Car("UAZ Patriot", 2020);
        User user = new User("Yegor", "Ussov", 18, "11-103", car);
        saveUser(user);
        // readUser();
    }

    private static void saveUser(User user) {
        try {
            ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(file));
            stream.writeObject(user);
            System.out.println("User saved");
        } catch (IOException e) {
            System.out.println("ERROR WRITING TO FILE");
        }
    }

    private static void readUser() {
        try {
            ObjectInputStream stream = new ObjectInputStream(new FileInputStream(file));
            User user = (User) stream.readObject();

            System.out.println(user.getFirstName());
            System.out.println(user.getCar().getModel());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERROR READING FROM FILE");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
