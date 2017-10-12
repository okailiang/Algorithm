package com.basesort;

import com.util.IntUtils;
import com.util.ResultUtil;

import java.util.Scanner;

/**
 * 冒泡排序
 * 基本思想：对相邻的元素进行两两比较，顺序相反则进行交换，这样，每一趟会将最小或最大的元素“浮”到顶端，最终达到完全有序
 *
 * 结果总结：
 * 若原数组本身就是有序的（这是最好情况），仅需n-1次比较就可完成；
 * 若是倒序，比较次数为 n-1+n-2+...+1=n(n-1)/2，交换次数和比较次数等值。
 * 所以，其时间复杂度依然为O(n2）。综合来看，冒泡排序性能还是稍差于选择排序的。
 *
 * @author oukailiang
 * @create 2017-10-09 下午4:50
 */

public class BubbleSort {
    public static void bubbleSort(int[] a) {
        if (a == null) {
            return;
        }
        int len = a.length;
        //最后一个不比较
        for (int i = 0; i < len - 1; i++) {
            //若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已然完成。
            boolean flag = true;
            //上浮的i个数则不比较
            for (int j = 0; j < len - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    //相邻交换
                    IntUtils.swap(a, j, j + 1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int[] a = IntUtils.toInArray(line, " ");
        //冒泡排序
        bubbleSort(a);
        //打印结果
        ResultUtil.print(a);
    }
}
