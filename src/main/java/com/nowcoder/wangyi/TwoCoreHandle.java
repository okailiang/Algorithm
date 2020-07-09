package com.nowcoder.wangyi;

import java.util.Scanner;

/**
 * class: TwoCoreHandle  <br/>
 * Description:nowcoder网->17年校招网易: 双核处理 <br/>
 * 题目描述：一种双核CPU的两个核能够同时的处理任务，现在有n个已知数据量的任务需要交给CPU处理，
 * 假设已知CPU的每个核1秒可以处理1kb，每个核同时只能处理一项任务。n个任务可以按照任意顺序放入CPU进行处理，
 * 现在需要设计一个方案让CPU处理完这批任务所需的时间最少，求这个最小的时间。<br/>
 * <p>
 * 输入描述：.
 * 输入包括两行：
 * 第一行为整数n(1 ≤ n ≤ 50)
 * 第二行为n个整数length[i](1024 ≤ length[i] ≤ 4194304)，表示每个任务的长度为length[i]kb，每个数均为1024的倍数。
 * <p>
 * <br/>
 * <p>
 * 输出描述：输出一个整数，表示最少需要处理的时间 <br/>
 * <br/>
 * <p>
 * 输入例子:
 * 5
 * 3072 3072 7168 3072 1024<br/>
 * 输出例子: 9216 <br/>
 * 解题思路：差值最小就是说两部分的和最接近，而且各部分的和与总和的一半也是最接近的。假设用sum1表示第一部分的和，
 * sum2表示第二部分的和，SUM表示所有数的和，那么sum1+sum2=SUM。假设sum1<sum2 那么SUM/2-sum1 = sum2-SUM/2;
 * 所以我们就有目标了，使得sum1<=SUM/2的条件下尽可能的大。也就是说从n个数中选出某些数，
 * 使得这些数的和尽可能的接近或者等于所有数的和的一般。这其实就是简单的背包问题了：
 * 背包容量是SUM/2. 每个物体的体积是数的大小，然后尽可能的装满背包。
 * dp方程：f[i][V] = max(f[i-1][V-v[i]]+v[i], f[i-1][V] )
 * f[i][V]表示用前i个物体装容量为V的背包能够装下的最大值，f[i-1][V-v[i]]+v[i]表示第i个物体装进背包的情况，f[i-1][V]表示第i件物品不装进背包的情况。
 * <br/>
 *
 * @author oukailiang
 * @create 2017-04-11 下午9:14
 */

public class TwoCoreHandle {
    /**
     * 动态规划，使两个跟接近总数的一半
     * 由于数组元素是1024的倍数，所以先把每个数除以1024，求出总和
     *
     * @param taskArr
     * @return
     */
    private static int twoCoreHandle(int[] taskArr) {
        int len = taskArr.length;
        if (len == 1) {
            return taskArr[0];
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum = sum + taskArr[i];
        }
        int n = len;
        int[] result = new int[sum];
        for (int i = 0; i < n; i++) {
            for (int j = sum / 2; j >= taskArr[i]; --j) {
                //result[j]表示在容量为j的情况可存放的重量
                result[j] = maxValue(result[j], result[j - taskArr[i]] + taskArr[i]);
            }
        }
        return (sum - result[sum / 2]) * 1024;
    }

    public static int maxValue(int x, int y) {
        return x > y ? x : y;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] taskArr = new int[n];
        for (int i = 0; i < n; i++) {
            taskArr[i] = in.nextInt() / 1024;
        }
        System.out.println(twoCoreHandle(taskArr));

    }
}
