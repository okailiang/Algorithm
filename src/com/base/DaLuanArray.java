package com.base;

import com.util.IntUtils;
import com.util.ResultUtil;

import java.util.Random;
import java.util.Scanner;

/**
 * 随机打乱数组
 *
 * @author oukailiang
 * @create 2017-10-17 下午9:01
 */

public class DaLuanArray {

    /**
     * 随机打乱数组
     *
     * @param a
     */
    public static void upsetArray(int[] a) {
        if (a == null) {
            return;
        }
        int len = a.length;
        Random random = new Random();
        int randInt;
        for (int i = 0; i < len; i++) {
            //随机取i到len-1数组下标
            randInt = random.nextInt(len) % (len - i) + i;
            //当前数不变
            if (randInt == i) {
                continue;
            } else {
                //交换
                IntUtils.swap(a, i, randInt);
            }
        }
        //输出
        ResultUtil.print(a);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String str = scanner.nextLine();
            String[] strArray = str.split(" ");
            int[] a = new int[strArray.length];
            for (int i = 0; i < strArray.length; i++) {
                a[i] = Integer.parseInt(strArray[i]);
            }
            //随机打乱数组
            upsetArray(a);
        }

    }
}
