package com.nowcoder.program1;

import com.Timing;

import java.util.Scanner;

/**
 * class:ContinuousInteger   <br/>
 * Description:nowcoder网->17年校招统一模拟一: 连续整数 <br/>
 * 题目描述：牛牛的好朋友羊羊在纸上写了n+1个整数，羊羊接着抹除掉了一个整数，给牛牛猜他抹除掉的数字是什么。<br/>
 * 牛牛知道羊羊写的整数神排序之后是一串连续的正整数，牛牛现在要猜出所有可能是抹除掉的整数。<br/>
 * 例如：
 * 10 7 12 8 11 那么抹除掉的整数只可能是9
 * 5 6 7 8 那么抹除掉的整数可能是4也可能是9<br/>
 * <p>
 * 输入描述：输入包括2行：
 * 第一行为整数n(1 <= n <= 50)，即抹除一个数之后剩下的数字个数
 * 第二行为n个整数num[i] (1 <= num[i] <= 1000000000)。</=><br/>
 * <p>
 * 输出描述：在一行中输出所有可能是抹除掉的数,从小到大输出,用空格分割,行末无空格。如果没有可能的数，则输出mistake <br/>
 * <p>
 * 输入例子：<br/>
 * 2
 * 3 6   <br/>
 * 输出例子： <br/>
 * mistake <br/>
 * <p>
 * 题目分析：
 * 解题思路：
 *
 * @author oukailiang
 * @create 2017-03-24 下午12:31
 */

public class ContinuousInteger {
    /**
     * 输出连续的数
     *
     * @param n   剩余数的个数
     * @param num 剩余的数
     * @return
     */
    private static String continuousInt(int n, int[] num) {
        //先进行排序
        quickSort(num, 0, n - 1);

        String result = num[0] == 1 ? String.valueOf((num[n - 1] + 1)) : (num[0] - 1) + " " + (num[n - 1] + 1);
        int flag = 0;
        for (int i = 1; i < n; i++) {
            int temp = num[i] - num[i - 1];
            if (temp == 1) {
                continue;
            }
            if (temp == 2) {
                //有两个以上也是不正确的
                if (++flag > 1) {
                    result = "mistake";
                    break;
                }
                result = String.valueOf(num[i] - 1);
            } else if (temp > 2 || temp == 0) {
                result = "mistake";
                break;
            }
        }
        return result;
    }

    /**
     * 快速排序
     *
     * @param a
     * @param left
     * @param right
     */
    private static void quickSort(int[] a, int left, int right) {
        if (left < right) {
            int key = a[left];
            int low = left, high = right;
            while (low < high) {
                while (low < high && key <= a[high]) {
                    high--;
                }
                a[low] = a[high];
                while (low < high && key >= a[low]) {
                    low++;
                }
                a[high] = a[low];
            }
            a[low] = key;
            quickSort(a, left, low - 1);
            quickSort(a, low + 1, right);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//输入两个字符创空格隔开
        int[] strArray = new int[n];
        for (int i = 0; i < n; i++) {
            strArray[i] = in.nextInt();
        }
        System.out.println(continuousInt(n, strArray));
    }
}
