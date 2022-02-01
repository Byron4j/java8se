package org.byron4j.java8.chapter06;

import org.byron4j.beans.Dish;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class GroupingByTest {
    public static void main(String[] args) {
        // 对菜进行按类型分组
        Map<Dish.Type, List<Dish>> collect = Dish.menu().stream()
                .collect(Collectors.groupingBy(Dish::getType));
        System.out.println(collect);

        // 不到400低热量、400-700中热量，700以上高热量 进行分组
        Map<String, List<Dish>> caloriesCollect = Dish.menu().stream()
                .collect(Collectors.groupingBy(dish -> {
                    if (dish.getCalories() < 400) {
                        return "低热量";
                    }
                    if (dish.getCalories() >= 400 && dish.getCalories() <= 700) {
                        return "中热量";
                    }
                    return "高热量";
                }));
        System.out.println(caloriesCollect);
        
        // 多级分组
        // 先按类型分组再按热量分组
        Map<Dish.Type, Map<String, List<Dish>>> multiGroup = Dish.menu().stream()
                .collect(Collectors.groupingBy(Dish::getType,
                        Collectors.groupingBy(dish -> {
                            if (dish.getCalories() < 400) {
                                return "低热量";
                            }
                            if (dish.getCalories() >= 400 && dish.getCalories() <= 700) {
                                return "中热量";
                            }
                            return "高热量";
                        })));
        System.out.println(multiGroup);

        // 每组中最高热量
        Map<Dish.Type, Optional<Dish>> max = Dish.menu().stream()
                .collect(Collectors.groupingBy(Dish::getType,
                        Collectors.maxBy(Comparator.comparing(Dish::getCalories))));
        System.out.println(max);

        // 将收集器结果转换为另一种类型
        Map<Dish.Type, Dish> maxCollect = Dish.menu().stream()
                .collect(Collectors.groupingBy(Dish::getType,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(Dish::getCalories)),
                                Optional::get
                        )));
        System.out.println(maxCollect);
    }
}
