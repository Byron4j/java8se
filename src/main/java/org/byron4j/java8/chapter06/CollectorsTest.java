package org.byron4j.java8.chapter06;

import org.byron4j.beans.Dish;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 规约、统计
 */
public class CollectorsTest {
    public static void main(String[] args) {
        // 收集器查看包含多少种菜
        Long dishCnt = Dish.menu().stream().collect(Collectors.counting());
        System.out.println(dishCnt);
        System.out.println(Dish.menu().stream().count());

        // 最大最小卡路里
        Optional<Dish> dish = Dish.menu().stream()
                .collect(Collectors.maxBy(Comparator.comparing(Dish::getCalories)));
        System.out.println(dish.get());

        // 总热量
        System.out.println(Dish.menu().stream()
                .mapToInt(Dish::getCalories)
                .sum());
        System.out.println(Dish.menu().stream()
                .collect(Collectors.summingInt(Dish::getCalories)));

        // 汇总信息
        IntSummaryStatistics intSummaryStatistics = Dish.menu().stream()
                .collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println("sum=" + intSummaryStatistics.getSum() + ", avg=" +
                intSummaryStatistics.getAverage() + ", max=" +
                intSummaryStatistics.getMax() + ", min=" +
                intSummaryStatistics.getMin() + ", count=" +
                intSummaryStatistics.getCount());
    }
}
