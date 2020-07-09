package com.basesort;

import com.util.IntUtils;
import com.util.ResultUtil;

import java.util.Scanner;

/**
 * 插入排序
 * 基本思想：每一步将一个待排序的记录，插入到前面已经排好序的有序序列中去，直到插完所有元素为止。
 * <p>
 * 结果总结：在最好情况下，需要比较n-1次，无需交换元素，时间复杂度为O(n);
 * 在最坏情况下，时间复杂度依然为O(n2)。
 * 但是在数组元素随机排列的情况下，插入排序要优于选择和冒泡排序的。
 *
 * @author oukailiang
 * @create 2017-10-09 下午5:03
 */

public class InsertSort {
    public static void insertSort(int[] a) {
        if (a == null) {
            return;
        }
        int len = a.length;

        //跳过第一个元素
        for (int i = 1; i < len; i++) {
            int j = i;
            //从当前位置，在已经排序的数组中找合适的位置插入,小于则前移
            while (j > 0 && a[j] < a[j - 1]) {
                IntUtils.swap(a, j, j - 1);
                j--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int[] a = IntUtils.toInArray(line, " ");
        //插入排序
        insertSort(a);
        //打印结果
        ResultUtil.print(a);
    }
}
