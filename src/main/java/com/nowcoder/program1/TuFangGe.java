package com.nowcoder.program1;

import java.util.Scanner;

/**
 * @author oukailiang
 * @create 2017-09-10 下午8:17
 */

public class TuFangGe {

    private static int tu(char[] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        int len = array.length;
        int rCount = 0;
        int gCount = 0;

        for (int i = 0; i < len; i++) {
            if (array[i] == 'G') {
                gCount++;
            }
            if (gCount > 0 && array[i] == 'R') {
                rCount++;
            }

        }


        if (array[0] == 'G') {
            if (rCount <= gCount) {
                return rCount+1;
            } else {
                return gCount;
            }

        } else {
            if (rCount <= gCount) {
                return rCount;
            } else {
                return gCount + 1;
            }
        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        char a[] = new char[m];
        for (int j = 0; j < m; j++) {
            a[j] = sc.next().charAt(0);
        }
        System.out.println(tu(a));

    }
}
