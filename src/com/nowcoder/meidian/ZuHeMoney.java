package com.nowcoder.meidian;

/**
 * @author oukailiang
 * @create 2017-08-31 上午9:28
 */

import java.util.Scanner;

/**
 * class:ZuHeMoney   <br/>
 * Description:nowcoder网->17年校招-美团点评编程题2: 组合钱 <br/>
 * 题目描述：给你六种面额 1、5、10、20、50、100 元的纸币，假设每种币值的数量都足够多， <br/>
 * 编写程序求组成N元（N为0~10000的非负整数）的不同组合的个数。 <br/>
 * <p>
 * <p>
 * 输入描述：输入包括一个整数n(1 ≤ n ≤ 10000)<br/>
 * <p>
 * 输出描述：输出一个整数,表示不同的组合方案数<br/>
 * <p>
 * 输入例子：<br/>
 * 1   <br/>
 * 输出例子： <br/>
 * 1 <br/>
 * <p>
 * 题目分析： 完全背包问题，二维转一纬
 * 解题思路：<br/>
 */
public class ZuHeMoney {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(moneyCount(scanner.nextInt()));
    }

    private static long moneyCount(int n) {

        if (n <= 0) return 0;
        int[] coins = new int[]{1, 5, 10, 20, 50, 100};
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= n; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];//类似斐波那契 后者的种类数基于前者
            }
        }
        return dp[n];

    }
}
