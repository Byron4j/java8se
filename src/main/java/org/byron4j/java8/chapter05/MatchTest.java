package org.byron4j.java8.chapter05;

import org.byron4j.beans.Dish;

import java.util.Arrays;
import java.util.List;

/**
 * 查找和匹配
 * anyMatch
 * noneMatch
 * allMatch
 * findFirst
 * findAny
 */
public class MatchTest {
    public static void main(String[] args) {
        // anyMatch 匹配一个即返回
        System.out.println(Dish.menu().stream().anyMatch(ele -> {
            if (ele.isVegetarian()){
                System.out.println(ele);
                return true;
            }
            return false;
        }));

        // allMatch 全匹配；
        System.out.println(Dish.menu().stream().allMatch(ele -> ele.getCalories() < 1000));

        // noneMatch 一个都不匹配；
        System.out.println(Dish.menu().stream().noneMatch(ele -> ele.getCalories() < 1000));

        // findAny 找到任意一个;
        Dish.menu().stream().filter(Dish::isVegetarian).findAny().ifPresent(ele -> System.out.println(ele));

        // findFirst 找到第一个，会排序； 如果对顺序不要求请使用 findAny 在使用并行流时提升性能
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        integers.stream().map(num -> num * num).filter(ele -> ele % 3 == 0).findFirst()
                .ifPresent(System.out::println);

        
    }
}
