package org.byron4j.java8._1basic.defaultInterface;

/**
 * 基础学习
 * @program: java8se
 * @author: Byron
 * @create: 2019/07/25
 */
@FunctionalInterface
public interface IBasic {

    void sing();

    default void sayHello(){
        System.out.println("Hello");
    }
}
