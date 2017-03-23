package com.nowcoder.program1;

import com.Timing;

import java.util.Scanner;

/**
 * class:PrintListFromTailToHead   <br/>
 * Description:nowcoder网->编程练习: 好多鱼 <br/>
 * 题目描述：牛牛有一个鱼缸。鱼缸里面已经有n条鱼，每条鱼的大小为fishSize[i] (1 ≤ i ≤ n,均为正整数)，
 * 牛牛现在想把新捕捉的鱼放入鱼缸。鱼缸内存在着大鱼吃小鱼的定律。
 * 经过观察，牛牛发现一条鱼A的大小为另外一条鱼B大小的2倍到10倍(包括2倍大小和10倍大小)，
 * 鱼A会吃掉鱼B。考虑到这个，牛牛要放入的鱼就需要保证：
 * 1、放进去的鱼是安全的，不会被其他鱼吃掉
 * 2、这条鱼放进去也不能吃掉其他鱼
 * 鱼缸里面已经存在的鱼已经相处了很久，不考虑他们互相捕食。
 * 现在知道新放入鱼的大小范围[minSize,maxSize](考虑鱼的大小都是整数表示),
 * 牛牛想知道有多少种大小的鱼可以放入这个鱼缸。。 <br/>
 * 输入描述：输入数据包括3行.
 * 第一行为新放入鱼的尺寸范围minSize,maxSize(1 ≤ minSize,maxSize ≤ 1000)，以空格分隔。
 * <p>
 * 第二行为鱼缸里面已经有鱼的数量n(1 ≤ n ≤ 50)
 * <p>
 * 第三行为已经有的鱼的大小fishSize[i](1 ≤ fishSize[i] ≤ 1000)，以空格分隔。
 * <p>
 * 输出描述：输出有多少种大小的鱼可以放入这个鱼缸。考虑鱼的大小都是整数表示
 * <p>
 * <p>
 * <p>
 * 题目分析：
 *
 * @author oukailiang
 * @create 2017-03-23 下午4:35
 */

public class HaoDuoYu {

    public static int haoDuoYu(int minSize, int maxSize, int n, int[] fishSize) {
        int count = 0;
        int len = n + maxSize - minSize;//总鱼数
        int[] newFishSize = new int[len];
        for (int m = 0; m < n; m++) {
            newFishSize[m] = fishSize[m];
        }

        //新放入的鱼下次也要参与计算
        for (; minSize <= maxSize; minSize++) {
            boolean flag = false;
            for (int j = 0; j < len; j++) {
                if (newFishSize[j] == 0) {
                    break;
                }
                if ((minSize / newFishSize[j] >= 2
                        && (minSize / newFishSize[j] < 10 || (minSize / newFishSize[j] == 10 && minSize % newFishSize[j] == 0)))
                        || (newFishSize[j] / minSize >= 2
                        && (newFishSize[j] / minSize < 10 || (newFishSize[j] / minSize == 10 && newFishSize[j] % minSize == 0)))) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                count++;
                //newFishSize[n++] = minSize;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        while (scanner.next() == null) {
        int minSize = scanner.nextInt(); //新放入鱼的最小尺寸1
        int maxSize = scanner.nextInt();//新放入鱼的最大尺寸1000
        int n = scanner.nextInt(); //浴缸里n条鱼(1 ≤ n ≤ 50)
        int fishSize[] = new int[n]; //(1 ≤ fishSize[i] ≤ 1000)
        for (int i = 0; i < n; i++) {
            fishSize[i] = scanner.nextInt();
        }
        Timing.startNanoTime();
        System.out.println(haoDuoYu(minSize, maxSize, n, fishSize));
        Timing.printNanoTime();
    }
}
