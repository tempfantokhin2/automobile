package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Car testCar1 = new Car("", "", "");
        testCar1.doNoise();

        Car[] testCars1 = createTestCars();
        System.out.println(Arrays.toString(testCars1));
        Car[] testCars2 = readCarListFromFile(new File("test_cars.txt"));
        System.out.println(Arrays.toString(testCars2));
        writeCarListToFile(testCars1, new File("output.txt"));

    }

    public static Car[] createTestCars() {
        Car[] testCars = new Car[4];
        testCars[0] = new Car("racer", "red", "pickup");
        testCars[1] = new Car("amigo", "blue", "pickup");
        testCars[2] = new Car("rozeto", "yellow", "pickup");
        testCars[3] = new Car("temp", "purple", "sedan");
        return testCars;
    }


    public static void writeCarListToFile(Car[] cars, File outputFile) {
        try (FileWriter writer = new FileWriter(outputFile)) {
            for (Car car : cars) {
                writer.write(car.dumpCar());
                writer.write("\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public static Car[] readCarListFromFile(File sourceFile) {
        ArrayList<Car> cars = new ArrayList<>();
        try (Scanner scanner = new Scanner(sourceFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                cars.add(new Car(parts[0].trim(), parts[1].trim(), parts[2].trim()));
            }
        } catch (IOException e) {
            System.err.println("File not found: " +  e.getMessage());
        }
        return cars.toArray(new Car[cars.size()]);
    }
}