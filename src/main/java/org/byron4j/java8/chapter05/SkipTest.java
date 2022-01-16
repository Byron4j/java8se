package org.byron4j.java8.chapter05;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SkipTest {
    public static void main(String[] args) {
        /*
        skip 跳过
         */
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 7, 8, 8, 9);
        List<Integer> collect = numbers.stream()
                .skip(3)  // 跳过前面3个，从第4个还是获取； 如果不足3个则返回空的流
                .collect(Collectors.toList());
        System.out.println(collect);

        numbers = Arrays.asList(2);
        collect = numbers.stream()
                .skip(3)  // 跳过前面3个，从第4个还是获取； 如果不足3个则返回空的流
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
