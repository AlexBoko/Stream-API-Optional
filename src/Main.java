import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Arrays;
import java.util.List;


/**
 * Задание 1
 * Напишите метод public static void findMinMax, который будет находить в стриме минимальный и максимальный элементы в соответствии с порядком,
 * заданным Comparator'ом.Данный метод принимает на вход 3 элемента:
 * Stream <? extends T> stream
 * Comparator <? super T> order
 * BiConsumer <? super T, ? super T> minMaxConsumer
 * Найденные минимальный и максимальный элементы передавайте в minMaxConsumer следующим образом:
 * minMaxConsumer.accept(min, max);
 * Если стрим не содержит элементов, то вызывайте:
 * minMaxConsumer.accept(null, null);
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(13, 312, 8, 4, 52, 4, 2122, 64, 48, 2413, 248, 16);
        Comparator<Integer> numbersComparator = Comparator.comparing(Integer::intValue);
        BiConsumer<Integer, Integer> numbersBiConsumer = (min, max) -> System.out.println("Минимальное число: " + min + ", Максимальное число: " + max);
        findMinMax(numbers, numbersComparator, numbersBiConsumer);
    }

    public static <T> void findMinMax(List<? extends T> list, Comparator<? super T> order, BiConsumer<? super T, ? super T> minMaxConsumer) {
        T min = null;
        T max = null;

        Optional<? extends T> minVal = list.stream().min(order);
        if (minVal.isPresent()) {
            min = minVal.get();
        }

        Optional<? extends T> maxVal = list.stream().max(order);
        if (maxVal.isPresent()) {
            max = maxVal.get();
        }

        minMaxConsumer.accept(min, max);
        System.out.println("===================================");

        /**
         * Задание 2
         * <p>
         * Реализуйте метод, который принимает на вход список целых чисел, определяет в списке количество четных чисел и выводит их в консоль.
         * Решите задание именно с применением Stream API.
         */

        System.out.println("===================================");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        printEvenNumbersCount(numbers);
    }

    public static void printEvenNumbersCount(List<Integer> numbers) {
        Map<Boolean, List<Integer>> partitionedNumbers = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        List<Integer> evenNumbers = partitionedNumbers.get(true);
        System.out.println("Количество четных чисел: " + evenNumbers.size());
        System.out.println(evenNumbers);
    }
}