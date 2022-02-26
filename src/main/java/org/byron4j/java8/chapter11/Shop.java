package org.byron4j.java8.chapter11;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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

    /**
     * 异步化
     *//*
    public Future<Double> getPriceAsync(String product){
        CompletableFuture<Double> future
                = new CompletableFuture<>();
        // 耗时操作新线程操作
        new Thread(
                () -> {
                    double v = calculatorPrice(product);
                    int i = 1 / 0;
                    future.complete(v);
                }
        ).start();
        return future;
    }*/

    /**
     * 异步化
     */
    public Future<Double> getPriceAsync(String product){
        // 使用静态工厂方法创建 CompletableFuture
        CompletableFuture<Double> future =
                CompletableFuture.supplyAsync(() -> calculatorPrice(product));
        return future;
    }

    public static void main(String[] args) {
        Shop shop = new Shop();
        Future<Double> cookie = shop.getPriceAsync("Cookie");
        Double aDouble = null;
        try {
            aDouble = cookie.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(aDouble);
    }
}
