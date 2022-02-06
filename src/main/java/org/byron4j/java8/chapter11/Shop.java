package org.byron4j.java8.chapter11;

import java.util.Random;

/**
 * 在线商店
 */
public class Shop {
    /**
     * 获取商品的价格
     * @param product
     * @return
     */
    public double getPrice( String product ){
        return calculatorPrice(product);
    }

    private double calculatorPrice(String product){
        delay();
        double v = new Random().nextDouble() * product.charAt(0) + product.charAt(1);
        return v;
    }

    /**
     * 模拟耗时
     */
    public static void delay(){
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
