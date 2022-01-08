package org.byron4j.java8._1basic.defaultInterface;

import org.junit.Test;

/**
 * @program: java8se
 * @author: Byron
 * @create: 2019/07/25
 */
public class SubImpl implements IBasic {

    @Test
    public void test(){
        SubImpl sub = new SubImpl();
        sub.sayHello();
    }

    /*@Test
    public void anonymous(){
        IBasic basic = new IBasic() {
            @Override
            public void sayHello() {
                System.out.println("Hello,everyone!");
            }
        };

        basic.sayHello();
    }*/

    @Test
    public void java8(){
        arg(() -> System.out.println("sing...."));
    }

    private void arg(IBasic basic){
        //basic.sayHello();
        basic.sing();
    }

    @Override
    public void sing() {

    }
}
