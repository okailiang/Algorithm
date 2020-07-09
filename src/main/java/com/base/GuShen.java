package com.base;

import java.util.Scanner;

/**
 * 股神
 * 说明：经过严密的计算，小赛买了一支股票，他知道从他买股票的那天开始，
 * 股票会有以下变化：第一天不变，以后涨一天，跌一天，涨两天，跌一天，涨三天，跌一天...依此类推。
 * 为方便计算，假设每次涨和跌皆为1，股票初始单价也为1，请计算买股票的第n天每股股票值多少钱？
 *
 * @author oukailiang
 * @create 2017-10-11 上午10:09
 */

public class GuShen {

    public static void gushen(int[] a) {
        if (a == null) {
            return;
        }
        int len = a.length;
        int result = 1;
        int zhangMax = 0;
        int zhangIndex = 0;
        boolean flag = true;
        System.out.println(result);
        for (int i = 1; i < len; ) {

            if (flag) {
                zhangMax++;
                while (++zhangIndex <= zhangMax) {
                    result = result + 1;
                    System.out.println(result);
                }
                i = i + zhangMax;
                flag = false;
            } else {
                zhangIndex = 0;
                result = result - 1;
                i++;
                flag = true;
                System.out.println(result);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strArray = str.split(" ");
        int[] a = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            a[i] = Integer.parseInt(strArray[i]);
        }
        gushen(a);
    }
}
