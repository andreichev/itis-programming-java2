package ru.itis.example_reflection_api.json_serializable;

import ru.itis.example_reflection_api.json_serializable.awesome_json_serializer.JsonElement;

public class Car {
    @JsonElement
    private String model;
    @JsonElement
    private String carNumber;
    @JsonElement
    private int probeg;
    @JsonElement
    private String color;

    public Car(String model, String carNumber, int probeg, String color) {
        this.model = model;
        this.carNumber = carNumber;
        this.probeg = probeg;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public int getProbeg() {
        return probeg;
    }

    public void setProbeg(int probeg) {
        this.probeg = probeg;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
