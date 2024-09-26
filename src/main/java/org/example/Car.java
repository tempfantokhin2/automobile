package org.example;

public class Car {
    String brand;
    String color;
    String bodyType;

    public Car(String brand, String color, String bodyType) {
        this.brand = brand;
        this.color = color;
        this.bodyType = bodyType;
    }

    @Override
    public String toString() {
        return "[car] brand: " + brand + ", color: " + color + ", body type: " + bodyType;
    }

    public void doNoise() {
        System.out.println("шшшшш");
    }
}
