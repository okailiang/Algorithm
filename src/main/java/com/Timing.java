package com;

/**
 * 计算程序运算时间
 *
 * @author oukailiang
 * @create 2017-03-23 下午1:43
 */

public class Timing {

    private static long startTime;
    private static long startNanoTime;

    public static long startTime() {
        return startTime = System.currentTimeMillis();
    }

    public static long startNanoTime() {
        return startNanoTime = System.nanoTime();
    }

    public static long endTime() {
        return System.currentTimeMillis();
    }

    public static long endNanoTime() {
        return System.nanoTime();
    }

    public static void printTime() {
        System.out.println("Total running time = " + (System.currentTimeMillis() - startTime));

    }

    public static void printNanoTime() {
        System.out.println("Total running nanoTime = " + (System.nanoTime() - startNanoTime));
    }

}
