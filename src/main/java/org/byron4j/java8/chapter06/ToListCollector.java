package org.byron4j.java8.chapter06;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.byron4j.beans.Dish;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * 自定义收集器
 *
 * @param <T> 数据类型
 */
public class ToListCollector<T>
        implements Collector<T, List<T>, List<T>> {
    /**
     * 提供器
     * @return
     */
    @Override
    public Supplier<List<T>> supplier() {
        return ArrayList::new;
    }

    /**
     * 累加器（结果器）
     * @return
     */
    @Override
    public BiConsumer<List<T>, T> accumulator() {
        return List::add;
    }

    /**
     * 合并两个结果器
     * @return
     */
    @Override
    public BinaryOperator<List<T>> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    /**
     * 结果转换
     * @return
     */
    @Override
    public Function<List<T>, List<T>> finisher() {
        return Function.identity();
    }

    /**
     * 收集器是否的行为：是否并行规约等的定义
     * @return
     */
    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(Characteristics.IDENTITY_FINISH, Characteristics.CONCURRENT);
    }

    public static void main(String[] args) throws JsonProcessingException {
        List<Dish> collect = Dish.menu().stream()
                .filter(Dish::isVegetarian)
                .collect(new ToListCollector<Dish>());
        System.out.println(collect);
        JsonMapper jsonMapper = new JsonMapper();
        System.out.println(jsonMapper.writeValueAsString(collect));
    }
}
