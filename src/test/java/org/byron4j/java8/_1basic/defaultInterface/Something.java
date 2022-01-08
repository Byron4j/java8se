package org.byron4j.java8._1basic.defaultInterface;

import org.junit.Test;

/**
 * @program: java8se
 * @author: Byron
 * @create: 2019/07/25
 */
public class Something {
    String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }

    @Test
    public void test(){
        Something something = new Something();
        Converter<String,String> converter = something::startsWith;
        System.out.println(converter.convert("hello"));
    }
}
