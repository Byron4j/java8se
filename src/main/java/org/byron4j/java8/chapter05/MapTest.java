package org.byron4j.java8.chapter05;

import org.byron4j.beans.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapTest {
    public static void main(String[] args) {
        /**
         * 每道菜的名字
         */
        List<String> collect = Dish.menu().stream()
                .map(Dish::getName) // 每道菜的名字
                .collect(Collectors.toList());
        System.out.println(collect);

        /**
         * 每道菜的名字的长度
         */
        List<Integer> integers = Dish.menu().stream()
                .map(Dish::getName)  // 每道菜的名字
                .map(String::length) // 每道菜的名字的长度
                .collect(Collectors.toList());
        System.out.println(integers);

        /**
         * 给定数字列表，获取每个数的平方列表
         */
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> integerList = numbers.stream()
                .map(num -> num * num)
                .collect(Collectors.toList());
        System.out.println(integerList);

        /**
         * 给定两个数字列表， 如何返回所有的数对
         * 给定 [1, 2, 3] 和列表 [3, 4]
         * 应该返回 (1, 3)、(1, 4)、(2, 3)、(2, 4)、(3, 3)、(3, 4)
         * 数对可以使用2个元素的数组列表表示
         */
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(3, 4);
        // 方式一
        List<List<Integer>> pair = list1.stream()
                .flatMap(i -> list2.stream().map(j -> Arrays.asList(i, j)))
                .collect(Collectors.toList());
        System.out.println(pair);

        // 方式二
        List<List<Integer>> lists = list1.stream()
                .map(i -> list2.stream().map(j -> Arrays.asList(i, j)).collect(Collectors.toList()))
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(lists);

        /**
         * 上面的列表，只返回总和能被3整除的数对
         */
        pair = list1.stream()
                .flatMap(i -> list2.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> Arrays.asList(i, j)))
                .collect(Collectors.toList());
        System.out.println(pair);

        /**
         * 合并多个数字列表，排序，去重
         */
        List<Integer> listA = Arrays.asList(1, 2, 3);
        List<Integer> listB = Arrays.asList(2, 3);
        List<Integer> listC = Arrays.asList(3, 4, 5);
        List<Integer> list = Stream.of(listA, listB, listC)
                .flatMap(List::stream)
                .sorted()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(list);

    }
}
