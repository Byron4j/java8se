package org.byron4j.java8._1basic.defaultInterface;

import org.junit.Test;

/**
 * @program: java8se
 * @author: Byron
 * @create: 2019/07/25
 */
public class PersonTest {

    @Test
    public void test(){
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Li", "Bai");
        System.out.println(person);
    }
}
