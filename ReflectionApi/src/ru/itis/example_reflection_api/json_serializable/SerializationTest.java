package ru.itis.example_reflection_api.json_serializable;

import ru.itis.example_reflection_api.json_serializable.awesome_json_serializer.JsonSerialization;

public class SerializationTest {
    public static void main(String[] args) throws Exception {
        Car Lada = new Car(
                "X-Ray", "X777XX16", 90000, "Orange"
        );

        JsonSerialization serialization = new JsonSerialization();
        String json = serialization.getJsonString(Lada);

        System.out.println(json);
    }
}
