package com.nowcoder.program1;

import java.util.Scanner;

public class QuShu {


    private static int test(int[] arr) {
        if (arr == null || arr.length < 4) {
            return 0;
        }
        int len = arr.length;
        int total = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                for (int m = j+1; m < len; m++) {
                    for (int n = m+1; n < len; n++) {
                        if (arr[n] == arr[m] * arr[j] * arr[i]) {
                            total++;
                        }
                    }
                }
            }
        }

        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();

        int a[] = new int[m];
        for (int j = 0; j < m; j++) {
            a[j] = sc.nextInt();
        }
        System.out.println(test(a));

    }
}
