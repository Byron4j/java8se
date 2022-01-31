package org.byron4j.java8.chapter05;

import org.byron4j.beans.Dish;

import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 数值流
 */
public class NumberValueStream {
    public static void main(String[] args) {
        // 映射到数值流
        IntStream intStream = Dish.menu().stream()
                .mapToInt(Dish::getCalories);
        System.out.println(intStream.sum());

        // 数值流转回对象流
        Stream<Integer> boxed = Dish.menu().stream()
                .mapToInt(Dish::getCalories).boxed();
        
        // 数值流获取最大值
        OptionalInt optionalInt = Dish.menu().stream()
                .mapToInt(Dish::getCalories).max();
        int max = optionalInt.orElse(1); // 没有则返回1

        // 数值范围
        IntStream.rangeClosed(1, 100)
                .filter(i->i%3==0)
                .forEach(ele-> System.out.print(ele + " "));



    }
}
