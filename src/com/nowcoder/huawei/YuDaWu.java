package com.nowcoder.huawei;

import java.util.Scanner;
/**
 * class:ReverseAdd   <br/>
 * Description:nowcoder网->17年校招华为: 整数翻转 <br/>
 * 题目描述：。<br/>
 * <br/>
 * <p>
 * 输入描述：
 * <p>
 * <br/>
 * <p>
 * 输出描述：。 <br/>
 * <br/>
 * <p>
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <p>
 * 当差遇到大雾
 * 2
 * 4
 * <p>
 * 6
 * [5,1,2]
 *
 * @author oukailiang
 * @create 2017-03-24 下午8:51
 */

public class YuDaWu {

    private static void chuChai(int x, int y) {
        int start = 5;

        if (x == start) {
            System.out.println(0);
            System.out.println("[5]");
        }
        int a[][] = {
                {0, 2, 10, 5, 3, 1000},
                {1000, 0, 12, 1000, 1000, 10},
                {1000, 1000, 0, 1000, 7, 1000},
                {2, 1000, 1000, 0, 2, 1000},
                {4, 1000, 1000, 1, 0, 1000},
                {3, 1000, 1, 1000, 2, 0}
        };
        int index = 0;
        int len = a.length;
        //将其有雾城市置为1000
        while (index < len) {
            if (a[y - 1][index] != 0) {
                a[y - 1][index] = 1000;
            }
            if (a[index][y - 1] != 0) {
                a[index][y - 1] = 1000;
            }
            index++;
        }

        index = 0;
        int small = a[start - 1][index];

        while (index < len) {

            if (a[start - 1][index] != 0 && a[start - 1][index] != 1000) {
                start = index;
            }
        }
        if (a[4][x] == 1000) {
            System.out.println(1000);
            System.out.println("[]");
        }

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        chuChai(a, b);
    }
}
