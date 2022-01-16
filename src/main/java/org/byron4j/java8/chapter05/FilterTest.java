package org.byron4j.java8.chapter05;

import org.byron4j.beans.Dish;

import java.util.List;
import java.util.stream.Collectors;

public class FilterTest {
    public static void main(String[] args) {
        /*
        获取所有的蔬菜食物
         */
        List<Dish> collect = Dish.menu().stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
