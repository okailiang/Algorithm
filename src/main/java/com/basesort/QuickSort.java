package com.basesort;

import com.util.IntUtils;

import java.util.Scanner;

/**
 * 快速排序(数据量较小时采用插入排序)
 * 思路：选择第一个值作为基数，从后向前比较，在从前向后比较
 *
 * @author oukailiang
 * @create 2017-10-09 上午9:49
 */

public class QuickSort {

    /**
     * 算法思想：基于分治的思想，是冒泡排序的改进型。
     * 首先在数组中选择一个基准点（该基准点的选取可能影响快速排序的效率，后面讲解选取的方法），
     * 然后分别从数组的两端扫描数组，设两个指示标志（lo指向起始位置，hi指向末尾)，
     * 首先从后半部分开始，如果发现有元素比该基准点的值小，就交换lo和hi位置的值，
     * 然后从前半部分开始扫秒，发现有元素大于基准点的值，就交换lo和hi位置的值，
     * 如此往复循环，直到lo>=hi,然后把基准点的值放到hi这个位置。一次排序就完成了。
     * 以后采用递归的方式分别对前半部分和后半部分排序，当前半部分和后半部分均有序时该数组就自然有序了。
     *
     * @param a
     * @param low
     * @param high
     */
    private static void quickSort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        //选择第一个作为基准值
        int key = a[low];
        int left = low, right = high;
        while (left < right) {
            //从后向前比较，大于基准值的不动
            while (left < right && a[right] >= key) {
                right--;
            }
            //小于基准值的交换
            a[left] = a[right];
            //从前向后比较
            while (left < right && a[left] <= key) {
                left++;
            }
            a[right] = a[left];
        }
        a[left] = key;

        //前半部分
        quickSort(a, low, left - 1);
        //后半部分
        quickSort(a, left + 1, high);
    }

    /**
     * 基准位置的选取一般有三种方法：固定切分，随机切分和三取样切分。
     * 固定切分的效率并不是太好，随机切分是常用的一种切分，效率比较高，最坏情况下时间复杂度有可能为O(N2).对于三数取中选择基准点是最理想的一种。
     *
     * @param a
     * @param low
     * @param high
     */
    private static void quickSortOptimize(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        //三数取中
        int mid = (low + high) / 2;
        if (a[mid] > a[high]) {
            swap(a[mid], a[high]);
        }
        if (a[low] > a[high]) {
            swap(a[low], a[high]);
        }
        if (a[mid] > a[low]) {
            swap(a[mid], a[low]);
        }

        //选择第一个作为基准值
        int key = a[low];
        int left = low, right = high;
        while (left < right) {
            //从后向前比较，大于基准值的不动
            while (left < right && a[right] >= key) {
                right--;
            }
            //小于基准值的交换
            a[left] = a[right];
            //从前向后比较
            while (left < right && a[left] <= key) {
                left++;
            }
            a[right] = a[left];
        }
        a[left] = key;

        //前半部分
        quickSort(a, low, left - 1);
        //后半部分
        quickSort(a, left + 1, high);
    }

    private static void swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int[] a = IntUtils.toInArray(line, " ");
        //快速排序
//        quickSort(a, 0, a.length - 1);
        quickSortOptimize(a, 0, a.length - 1);
        //打印结果
        print(a);
    }

    private static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
