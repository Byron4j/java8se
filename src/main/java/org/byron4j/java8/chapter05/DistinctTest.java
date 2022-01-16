package org.byron4j.java8.chapter05;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DistinctTest {
    public static void main(String[] args) {
        /*
        distinct 去重
         */
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 7, 8, 8, 9);
        List<Integer> collect = numbers.stream().filter(i -> i % 2 == 0) // 获取所有偶数
                .distinct() // 并去重
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
