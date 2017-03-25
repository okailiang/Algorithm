package com.util;

/**
 * 排序算法
 *
 * @author oukailiang
 * @create 2017-03-24 下午1:24
 */

public class Sorts {

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
}
