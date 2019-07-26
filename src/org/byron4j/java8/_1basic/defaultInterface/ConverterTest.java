package org.byron4j.java8._1basic.defaultInterface;

import org.junit.Test;

/**
 * @program: java8se
 * @author: Byron
 * @create: 2019/07/25
 */
public class ConverterTest {
    @Test
    public void test(){
        // 使用lambda表达式获取一个匿名内部类对象
        //Converter<Integer, String> converter = (arg) -> {return Integer.valueOf(arg);};
        // 单行的方法体可以省略return 以及  {}吧。
        //Converter<Integer, String> converter = (arg) -> Integer.valueOf(arg);
        // 静态方法引用更简洁
        Converter<Integer, String> converter = Integer::valueOf;

        // 使用该匿名内部类对象
        Integer convert = converter.convert("123");
        System.out.println(convert);
    }
}
