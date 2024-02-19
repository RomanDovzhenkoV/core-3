package task.io;

import java.nio.charset.CharacterCodingException;

public class Car {

    // TODO: Создайте класс, который представляет автомобиль. Реализуйте метод для запуска двигателя.
    //  Обработайте исключение, если двигатель уже запущен.

    private String name;
    private String color;
    private double engine;
    private String condition;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getEngine() {
        return engine;
    }

    public void setEngine(double engine) {
        this.engine = engine;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Car(String name, String color, double engine, String condition) {
        this.name = name;
        this.color = color;
        this.engine = engine;
        this.condition = condition;
    }

    public static void startingTheEngine(Car car) {
        if (car.getCondition().equals("The engine is running"))
            throw new IllegalStateException("Двигатель уже запущен");
        System.out.println("Запуск двигателя");
        car.setCondition("The engine is running");
    }

    public static void main(String[] args) {
        Car car = new Car("Niva", "Black", 1.2, "In waiting");
        startingTheEngine(car);
        try {
            startingTheEngine(car);
        } catch (IllegalStateException exception) {
            System.out.println(exception);
        }
    }
}
