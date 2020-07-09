package com.nowcoder.huawei;

import java.util.Scanner;

/**
 * @author oukailiang
 * @create 2017-03-24 下午5:40
 */

public class APlusB {


    private static int[] sort(int[] array, int len) {
        int k = 0;
        int index = 0;
        //先找到0和对应的下标
        while (k < len) {
            if (array[k] == k) {
                continue;
            } else if (array[k] == 0) {
                index = k;
                break;
            }
            k++;
        }
        if (k == len) {
            return array;
        }


        while (array[index] == index) {
            for (int i = 0; i < len; i++) {
                if (array[i] == index) {
                    //i
                    index = i;
                    break;
                }
            }

        }

        return array;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {//注意while处理多个case
//            int a = in.nextInt();
//            int b = in.nextInt();
//            System.out.println(a + b);
//        }
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();

        }
        System.out.println(sort(array, n));
    }
}

