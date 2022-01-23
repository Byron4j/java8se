package org.byron4j.java8.chapter05;

import org.byron4j.beans.Dish;

/**
 * 规约操作reduce；
 * 将流中所有元素反复结合，得到一个值
 */
public class ReduceTest {
    public static void main(String[] args) {
        /*
        菜的个数
         */
        Integer totalCnt = Dish.menu().stream()
                .map(ele -> 1)
                // reduce 接收一个初始值、一个二元表达BinaryOperator（运行时是BiFunction#apply）
                .reduce(0, (a, b) -> a + b);
        System.out.println(totalCnt);
        System.out.println(Dish.menu().stream().count());

        // 最大卡路里
        Integer maxCalories = Dish.menu().stream()
                .map(ele -> ele.getCalories())
                .reduce(0, (a, b) -> a > b ? a : b);
        System.out.println(maxCalories);
        Integer maxCalories2 = Dish.menu().stream()
                .map(ele -> ele.getCalories())
                .reduce(0, Integer::max);
        System.out.println(maxCalories2);
    }
}
