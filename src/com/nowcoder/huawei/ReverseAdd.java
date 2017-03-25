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
 * 题目分析：
 * 解题思路：
 *
 * @author oukailiang
 * @create 2017-03-24 下午7:19
 */

public class ReverseAdd {
    private static int reverseAdd(int a, int b) {
        if (a < 1 || a > 70000) {
            return -1;
        }
        if (b < 1 || b > 70000) {
            return -1;
        }
        int afterA = 1;
        int afterB = 1;
        afterA = a % 10;

        while (a >= 10) {
            a = a / 10;
            afterA = afterA * 10 + a % 10;
        }
        afterB = b % 10;
        while (b >= 10) {
            b = b / 10;
            afterB = afterB * 10 + b % 10;
        }

        return afterA + afterB;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] strArr = str.split(",");
        int a = Integer.parseInt(strArr[0]);
        int b = Integer.parseInt(strArr[1]);
        System.out.println(reverseAdd(a, b));
    }
}
