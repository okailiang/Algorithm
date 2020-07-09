package com.demo;

import com.demo.model.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * @author oukailiang
 * @create 2017-04-07 上午11:08
 */

public class BigDataSum {

    private static int parallelSum(List<Order> orders) {
        int sum = orders.parallelStream().mapToInt(Order::getShopCount).sum();
        return sum;
    }

    private static int sum(List<Order> orders) {
        int sum = orders.stream().mapToInt(Order::getShopCount).sum();
        return sum;
    }

    private static int forSum(List<Order> orders) {
        int sum = 0;
        for (Order order : orders) {
            sum = sum + order.getShopCount();
        }
//        for (int i = 0; i < 100000000; i++) {
//            sum = sum + orders.get(i).getShopCount();
//        }

        return sum;
    }

    public static void main(String[] args) {
        List<Order> orders = new ArrayList<Order>();
        Order order;
        long start = System.currentTimeMillis();
        for (int i = 0; i < 20000000; i++) {
            order = new Order();
            order.setShopCount(1);
            order.setUserCount(2);
            orders.add(order);
        }
        System.out.println("create time = " + (System.currentTimeMillis() - start));

        long startParallSum = System.currentTimeMillis();
        System.out.println(parallelSum(orders));
        System.out.println("parall sum time = " + (System.currentTimeMillis() - startParallSum));

        long startSum = System.currentTimeMillis();
//        System.out.println(sum(orders));
        System.out.println("sum time = " + (System.currentTimeMillis() - startSum));


        long startForSum = System.currentTimeMillis();
//        System.out.println(forSum(orders));
        System.out.println("for sum time = " + (System.currentTimeMillis() - startForSum));

    }
}
