package com.nowcoder.program2;

import java.util.Scanner;

/**
 * class:ContinuousInteger   <br/>
 * Description:nowcoder网->17年校招统一模二: 超级素数幂 <br/>
 * 题目描述：如果一个数字能表示为p^q(^表示幂运算)且p为一个素数,q为大于1的正整数就称这个数叫做超级素数幂。<br/>
 * 现在给出一个正整数n,如果n是一个超级素数幂需要找出对应的p,q。 <br/>
 * <p>
 * 输入描述：
 * 输入一个正整数n(2 ≤ n ≤ 10^18)
 * 第二行为n个整数num[i] (1 <= num[i] <= 1000000000)。</=><br/>
 * <p>
 * 输出描述：如果n是一个超级素数幂则输出p,q,以空格分隔,行末无空格。 <br/>
 * 如果n不是超级素数幂，则输出No <br/>
 * <p>
 * 输入例子：<br/>
 * 27  <br/>
 * 输出例子：<br/>
 * 3 3  <br/>
 * <p>
 * 题目分析：
 * 解题思路：
 *
 * @author oukailiang
 * @create 2017-03-24 下午2:47
 */

public class SuperPrimePower {
    private static String superPrimePower(int num) {
        int p = 2, q = 2;
        while (num <= Math.pow(new Double(p), new Double(p))) {

        }

        return null;
    }

    /**
     * 判断素数
     *
     * @param num
     * @return
     */
    private static boolean isPrime(int num) {
        int k = 2;
        while (k * k <= num) {
            if (num % k == 0) {
                return false;
            }
            k++;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(superPrimePower(n));
    }
}
