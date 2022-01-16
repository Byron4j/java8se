package org.byron4j.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Dish {
    private String name;
    private boolean vegetarian;
    private int calories;
    private Type type;
    public enum Type{
        MEAT, FISH, OTHER
    }

    public static List<Dish> menu(){
        return Arrays.asList(
                Dish.builder().name("pork").vegetarian(false)
                        .calories(800).type(Type.MEAT)
                        .build(),
                Dish.builder().name("beef").vegetarian(false)
                        .calories(700).type(Type.MEAT)
                        .build(),
                Dish.builder().name("chicken").vegetarian(false)
                        .calories(400).type(Type.MEAT)
                        .build(),
                Dish.builder().name("french fries").vegetarian(true)
                        .calories(530).type(Type.OTHER)
                        .build(),
                Dish.builder().name("rice").vegetarian(true)
                        .calories(350).type(Type.OTHER)
                        .build(),
                Dish.builder().name("season fruit").vegetarian(true)
                        .calories(120).type(Type.OTHER)
                        .build(),
                Dish.builder().name("pizza").vegetarian(true)
                        .calories(550).type(Type.OTHER)
                        .build(),
                Dish.builder().name("prawns").vegetarian(false)
                        .calories(300).type(Type.FISH)
                        .build(),
                Dish.builder().name("salmon").vegetarian(false)
                        .calories(450).type(Type.FISH)
                        .build()
        );
    }
}

