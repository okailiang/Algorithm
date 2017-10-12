package com.nowcoder.meidian;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author oukailiang
 * @create 2017-09-14 下午8:44
 */

public class ZhengChuShuo {
    private static long test(int[] arr) {
        long len = arr.length;
        long total = 0;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len && i != j; j++) {
                if (chuSeven(arr[i], arr[j])) {
                    total++;
                }
                if (chuSeven(arr[j], arr[i])) {
                    total++;
                }
            }
        }

        return total;
    }

    private static boolean chuSeven(long a, long b) {
        long combine = a * getMaxBit(b) + b;
        if (combine % 7 == 0) {
            return true;
        }
        return false;
    }

    private static long getMaxBit(long num) {
        long result = 10;
        while (num / 10 > 0) {
            num = num / 10;
            result = result * 10;
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int j = 0; j < n; j++) {
            a[j] = sc.nextInt();
        }
        System.out.println(test(a));
    }
}
