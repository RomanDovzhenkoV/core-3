package task.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class Stream {
    public static void main(String[] args) {
        sumTwoNumbers(5.8, 3.3);
        List<String> list = List.of("Roma", "Akim", "Vadim", "Vlad", "Kirill");
        filterListWordsByLetter(list, "V");
        List<Double> list1 = List.of(0.5, 5.6, 6.5, 9.8, 7.5, 8.9);
        System.out.println("___________________________________");
        printListOfLinesInUppercase(list);
        System.out.println("___________________________________");
        getListSquaresOfNumbers(list1);
// TODO: Найти сумму всех чисел в списке. Описание: Напишите программу, которая принимает список целых чисел в качестве
//  входных данных и вычисляет их сумму с использованием стримов.
        List<Integer> listInteger = List.of(5, 1, 65, 45, 1, 3, 6, 4, 6);
        System.out.println("Список целых чисел: " + listInteger);
        int sum = listInteger.stream().reduce(0, (x, y) -> x + y);
        System.out.println("Сумма элементов списка целых чисел = " + sum);

// TODO: Найти среднее значение всех чисел в списке. Описание: Напишите программу, которая принимает список чисел в качестве
//  входных данных и вычисляет их среднее значение с использованием стримов.
//        OptionalDouble averageOptional=listInteger.stream().mapToInt(x->x).average();
//        double average=0;
//        if (averageOptional.isPresent()){
//            average=averageOptional.getAsDouble();
//        }
        double average = listInteger.stream().mapToInt(x -> x).average().getAsDouble();
        System.out.println("Среднее значение элементов списка целых чисел = " + average);


// TODO: Найти наибольшее число в списке. Описание: Напишите программу, которая принимает список чисел в качестве входных
//  данных и находит наибольшее число с использованием стримов.
        int max = listInteger.stream().max(Integer::compareTo).get();
        System.out.println("Максимальные элемент элементов списка целых чисел = " + max);


// TODO: Найти наименьшее число в списке. Описание: Напишите программу, которая принимает список чисел в качестве входных
//  данных и находит наименьшее число с использованием стримов.
        int min = listInteger.stream().min(Integer::compareTo).get();
        System.out.println("Минимальный элемент элементов списка целых чисел = " + min);


// TODO: Проверить, содержит ли список определенное значение. Описание: Напишите программу, которая принимает список
//  элементов и определенное значение в качестве входных данных и проверяет, содержит ли список это значение с использованием
//  стримов.
        int element = 45;
        List<Integer> list2 = listInteger.stream().filter(x -> x.equals(element)).toList();
        if (list2.contains(element)) {
            System.out.println("Элемент " + element + " содержится в списке");
        }

// TODO: Удалить дубликаты из списка. Описание: Напишите программу, которая принимает список элементов в качестве входных
//  данных и удаляет все дубликаты, оставляя только уникальные элементы с использованием стримов.
        listInteger = listInteger.stream().distinct().toList();
        System.out.println("Список целых чисел без дубликатов: " + listInteger);

// TODO: Преобразовать список строк в список их длин. Описание: Напишите программу, которая принимает список строк в
//  качестве входных данных и преобразует его в список их длин с использованием стримов.
        List<String> listString = List.of("Akim", "Vadim", "Roman", "Denis");
        List<Integer> listLength = listString.stream().map(el -> el.length()).toList();
        System.out.println("Список строк: " + listString + ", список длин строк: " + listLength);

// TODO: Соединить все строки из списка в одну строку. Описание: Напишите программу, которая принимает список строк в
//  качестве входных данных и соединяет их все в одну строку с использованием стримов.
        String concatLines = listString.stream().reduce("", (string, string2) -> string.concat(string2));
        System.out.println(concatLines);

// TODO: Отфильтровать список чисел, оставив только четные числа. Описание: Напишите программу, которая принимает список
//  чисел в качестве входных данных и фильтрует его, оставляя только четные числа с использованием стримов.
        listInteger = listInteger.stream().filter(x -> x % 2 == 0).toList();
        System.out.println("Список четных чисел: " + listInteger);

    }

    //Реализуйте функциональность согласно описанию

    // TODO: Напишите метод, который принимает два числа от пользователя и использует функциональный интерфейс BinaryOperator
    //  для сложения этих чисел и вывода результата.
    public static void sumTwoNumbers(double firstNumber, double twoNumber) {
        BinaryOperator<Double> binaryOperator = (x, z) -> x + z;
        System.out.println("Сумма чисел " + firstNumber + " и " + twoNumber + " равна " + binaryOperator.apply(firstNumber, twoNumber));
    }


    // TODO: Напишите метод, который принимает список слов от пользователя и использует функциональный интерфейс Predicate
    //  для фильтрации слов, начинающихся с определенной буквы, и вывода отфильтрованного списка.
    public static void filterListWordsByLetter(List<String> list, String letter) {
        Predicate<String> predicate = el -> el.startsWith(letter);
        List<String> filterWords = new ArrayList<>();
        for (String word : list) {
            if (predicate.test(word)) {
                filterWords.add(word);
            }
        }
        System.out.println(filterWords);
    }

    // TODO: Напишите метод, который принимает список чисел от пользователя и использует функциональный интерфейс Function
    //  для преобразования каждого числа в его квадрат и вывода списка квадратов.
    public static void getListSquaresOfNumbers(List<Double> listNumbers) {
        Function<Double, Double> function = x -> x * x;
        List<Double> listSquaresOfNumbers = new ArrayList<>();
        for (Double element : listNumbers) {
            listSquaresOfNumbers.add(function.apply(element));
        }
        System.out.println(listSquaresOfNumbers);
    }


    // TODO: Напишите метод, который принимает список строк от пользователя и использует функциональный интерфейс Consumer
    //  для вывода каждой строки в верхнем регистре.
    public static void printListOfLinesInUppercase(List<String> listString) {
        Consumer<String> toUpperCase = str -> System.out.print(str.toUpperCase() + " ");
        listString.forEach(toUpperCase);
        System.out.println();
    }


}