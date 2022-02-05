package org.byron4j.java8.chapter06;
import org.byron4j.beans.Dish;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) throws Exception {
        Optional<Dish> option = Optional.empty();

        Optional<Dish> build = Optional.of(Dish.builder()
                .vegetarian(Boolean.TRUE).name("Fish").build());

        Optional<Dish> o = Optional.ofNullable(null);

        /*
        if build != null
            print build.getName()
         */
        System.out.println(build.map(Dish::getName));

        // get  为空时会存在 NPE
        Dish dish = build.get();
        // orElse 为空则设置默认值
        Dish none = o.orElse(Dish.builder().name("NONE").build());
        // orElseGet 为空则执行 supplier 创造一个对象
        Dish orElseGet = o.orElseGet(Dish::new);
        // orElseThrow 不存在则抛异常
        Dish ex = build.orElseThrow(() -> new Exception("异常"));
        // ifPresent 存在则执行 consumer 内容；否则不执行
        build.ifPresent(ele -> {
            System.out.println("Hi --> " + ele);
        });

        // filter结合ifPresent
        build.filter(Dish::isVegetarian).ifPresent(ele->{
            System.out.println("蔬菜 --> " + ele);
        });
    }
}
