package task.io;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.nio.file.Files.write;

public class ReadWriteFileExceptionHandling {
    public static void main(String[] args) throws IOException {
        // TODO: Напишите программу, которая создает новый файл и записывает в него данные, которые передаются
        //  строкой
        String string = "Dune 2 выйдет в кинотеатрах России с 7 марта 2024 года";
        try (FileWriter writer = new FileWriter("Writer.txt")) {
            writer.write(string);
        } catch (IOException exception) {
            exception.getStackTrace();
        }

        // TODO: Напишите программу, в которой при запуске приложения вы вводите в консоль текст и на основе
        //  введенного текста создается файл
        System.out.println("Ведите пожалуйста текс");
        Scanner scanner = new Scanner(System.in);
        String stringScanner = scanner.nextLine();
        try (FileWriter writer = new FileWriter("WriterScanner.txt")) {
            writer.write(stringScanner);
        } catch (IOException exception) {
            exception.getStackTrace();
        }
        scanner.close();

        System.out.println(quotientOfTwoNumbers(5, 0));

        // TODO: Напишите программу, которая считывает число с клавиатуры и выводит его квадрат. Обработайте
        //  исключение, если введено не число
        System.out.println("Введите число, которое нужно возвести в квадрат:");
        Scanner scannerNumber = new Scanner(System.in);
        try {
            double number = scannerNumber.nextDouble();
            System.out.println("Число в квадрате: " + number * number);
        } catch (InputMismatchException exception) {
            System.out.println(exception);
        }
        scannerNumber.close();

        // TODO: Напишите программу, которая считывает данные из файла и выводит их на экран. Обработайте
        //  исключение, если файл не найден.
        try (FileReader reader = new FileReader("Writer.txt")) {
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
        } catch (FileNotFoundException exception) {
            System.out.println(exception);
        } finally {
            System.out.println();
        }

        System.out.println(convertsStringToNumber("156"));

        // TODO: Напишите программу, которая делит одно число на другое и выводит результат. Обработайте
        //  исключение, если введены некорректные данные (например, вместо числа введена строка).
        System.out.println("Нахождение частного двух чисел. Введите два числа:");
        Scanner scannerTwoNumber = new Scanner(System.in);
        try {
            double firstNumber = scannerTwoNumber.nextDouble();
            double secondNumber = scannerTwoNumber.nextDouble();
            System.out.println("Частное этих двух чисел = " + firstNumber / secondNumber);
        } catch (InputMismatchException exception) {
            System.out.println(exception);
        }

        // TODO: Напишите программу, которая создает файл из текста, который подается строкой, а потом
        //  считывает первое слово из файла
        try (FileWriter writerLine = new FileWriter("Text.txt")) {
            Scanner scannerLine = new Scanner(System.in);
            writerLine.write(scannerLine.nextLine());
        } catch (IOException exception) {
            System.out.println(exception);
        }

        try (FileReader readerWord = new FileReader("Text.txt")) {
            int character;
            while ((character = readerWord.read()) != ' ') {
                System.out.print((char) character);
            }
        } catch (IOException exception) {
            System.out.println(exception);
        } finally {
            System.out.println();
        }


    }
//
    // Реализуйте функциональность согласно описанию


    // TODO: Создайте метод, который делит два числа и возвращает результат. Обработайте исключение,
    //  если второе число равно нулю
    public static double quotientOfTwoNumbers(int firstNumber, int twoNumber) {
        double result = 0;
        try {
            result = firstNumber / twoNumber;
        } catch (ArithmeticException exception) {
            System.out.println(exception);
        }
        return result;
    }

    // TODO: Создайте метод, который преобразует строку в число. Обработайте исключение, если строка не
    //  может быть преобразована в число.
    public static double convertsStringToNumber(String string) {
        double result = 0;
        try {
            result = Double.parseDouble(string);
        } catch (NumberFormatException exception) {
            System.out.println(exception);
        }
        return result;
    }
}