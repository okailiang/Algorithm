package com.nowcoder.program2;

import java.util.Scanner;

/**
 * class:BalanceNumber   <br/>
 * Description:nowcoder网->17年校招统一模拟二: 平衡数 <br/>
 * 题目描述：牛牛在烟酒独创平衡数，平衡数的定义是将一个数分成左右两部分，分别称为两个新的数
 * 左右两部分必须满足以下两点：
 * 1.左边和右边至少存在一位
 * 2.左边的数每一位相乘如果等于右边每一位相乘，则这个数称为平衡数。 <br/>
 * 例如：1221这个数，分成12和21 的话，1*2=2*1，则称1221是平衡数。
 * 再如：1236，可分为123和1*2*3=6,所以1236是平衡数。而1234无论怎么分都不满足平衡数
 * 输入描述：输入一个正整数（int范围）
 * 输出描述：如果该数是平衡数输出“YES”，否则输出“NO”。
 * 输入例子：
 * 1221
 * 1234
 * 输出例子：
 * YES
 * NO
 * <p>
 * 题目分析：
 * 解题思路：
 *
 * @author oukailiang
 * @create 2017-03-23 下午8:08
 */

public class BalanceNumber {
    private static String isBalanceNum(int num) {
        if (num <= 10) {
            return "NO";
        }
        int di = 1;
        do {
            int left = 1;
            int right = 1;
            int leftTotal = left, rightTotal = right;

            di = 10 * di;
            left = num / di;
            while (left >= 10) {
                leftTotal = leftTotal * (left % 10);
                left = left / 10;
            }
            leftTotal = leftTotal * left;
            right = num % di;
            while (right >= 10) {
                rightTotal = rightTotal * (right % 10);
                right = right / 10;
            }
            rightTotal = rightTotal * right;
            if (rightTotal == leftTotal) {
                return "YES";
            }
        } while (num / di >= 10);
        return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int a = in.nextInt();
            // int b = in.nextInt();
            System.out.println(isBalanceNum(a));
        }
    }
}