package com.basesort;

import com.util.IntUtils;
import com.util.ResultUtil;

import java.util.Scanner;

/**
 * 简单选择排序
 * 基本思想:每一趟从待排序的数据元素中选择最小（或最大）的一个元素作为首元素，直到所有元素排完为止，
 * 简单选择排序是不稳定排序
 *
 * 结果总结：简单选择排序通过上面优化之后，无论数组原始排列如何，比较次数是不变的；
 * 对于交换操作，
 * 在最好情况下也就是数组完全有序的时候，无需任何交换移动，
 * 在最差情况下，也就是数组倒序的时候，交换次数为n-1次。综合下来，时间复杂度为O(n2)
 *
 * @author oukailiang
 * @create 2017-10-09 下午4:20
 */

public class SelectSort {

    public static void selectSort(int[] a) {
        if (a == null) {
            return;
        }
        int len = a.length;
        //最后一个不比较
        for (int i = 0; i < len - 1; i++) {
            //每一趟循环比较时，min用于存放较小元素的数组下标
            int min = i;
            //找到最小元素下标
            for (int j = i + 1; j < len; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            //最小值发生变化时进行交换
            if (min != i) {
                IntUtils.swap(a, i, min);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int[] a = IntUtils.toInArray(line, " ");
        //简单选择排序
        selectSort(a);
        //打印结果
        ResultUtil.print(a);
    }

}
