package org.byron4j.java8.chapter05;

import org.byron4j.beans.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LimitTest {
    public static void main(String[] args) {
        List<Dish> collect = Dish.menu().stream().filter(dish -> dish.getCalories() > 300)
                .limit(3)  // 获取3个
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
