package com.nowcoder.program1;

import java.util.Scanner;


import java.util.Scanner;

/**
 * @author oukailiang
 * @create 2017-09-13 下午4:59
 */

public class XuanShuo {

    private static String test(int[] arr) {
        int m = arr.length;

        if (m == 1 || m == 2) {
            return "true";
        }
        if(m==3){
            if(arr[1] + arr[2]>arr[3]){
                return "true";
            }else {
                return "false";
            }
        }
        int total = 0;
        for (int i = 0; i < m; i++) {
            total = total + arr[i];
        }
        int avg = total / m;
        for (int i = 0; i < m; i++) {

        }


        return "true";
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
