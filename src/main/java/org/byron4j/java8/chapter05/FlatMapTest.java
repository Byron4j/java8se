package org.byron4j.java8.chapter05;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapTest {
    public static void main(String[] args) {
        /*
        给定列表 ["Hello", "World"]
        得到互不相同的字符列表 ["H", "e", "l", "l", "o", "W", "r", "l", "d"]
         */
        // 得到的是数组
        List<String> words = Arrays.asList("Hello", "World");
        List<String[]> collect = words.stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect);

        // 使用扁平流处理
        List<String> list = words.stream()
                .map(word -> word.split(""))
                // Arrays.stream 获取指定数组形成的流
                // flatMap 将多个流合成一个流
                .flatMap(ele -> Arrays.stream(ele))
                .distinct()
                .collect(Collectors.toList());
        System.out.println(list);

    }
}
