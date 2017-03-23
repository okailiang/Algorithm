package com.swordoffer.array;

import com.Timing;

/**
 * class:TwoArraySearch   <br/>
 * Description:nowcoder网->剑指offer: 二维数组中查找 <br/>
 * 题目描述：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。 <br/>
 * 题目分析：二维数组可以看为一个矩阵，每一行递增，每一列递增
 * 解题思路：1.循环同时减少一部分已知的判断 2.每行二分查找 3.左下角开始小于向上和大于向右遍历
 *
 * @author oukailiang
 * @create 2017-03-23 上午11:18
 */

public class TwoArraySearch {

    public static boolean find11(int target, int[][] array) {
        if (array == null) {
            return false;
        }
        int rowLen = array.length - 1;
        int colLen = array[0].length - 1;
        if (rowLen < 0 || colLen < 0) {
            return false;
        }
        int index;
        if (array[rowLen][colLen] == target) {
            return true;
        }
        //沿着对角线搜索
        while (rowLen >= 0 || colLen >= 0) {
            if (rowLen != 0) {
                rowLen--;
            }
            if (colLen != 0) {
                colLen--;
            }
            //等于
            if (target == array[rowLen][colLen]) {
                return true;
            }
            //大于
            if (target > array[rowLen][colLen]) {
                //先沿着当前行向后找，即增加列
                index = colLen;
                while ((++index) < array[0].length) {
                    if (target == array[rowLen][index]) {
                        return true;
                    } else if (target < array[rowLen][index]) {
                        break;
                    }
                }
                //先沿着当前列向后找，即增加行
                index = rowLen;
                while ((++index) < array.length) {
                    if (target == array[index][colLen]) {
                        return true;
                    } else if (target < array[index][colLen]) {
                        break;
                    }
                }
            }
            if (rowLen == 0 && colLen == 0) {
                break;
            }
        }
        return false;
    }


    /**
     * 循环同时减少一部分已知的判断
     *
     * @param target
     * @param array
     * @return
     */
    public static boolean find(int target, int[][] array) {
        if (array == null) {
            return false;
        }
        int rowLen = array.length;
        int colLen = array[0].length;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (target == array[i][j]) {
                    return true;
                }
                if (target < array[i][j]) {
                    break;
                }
            }
        }
        return false;
    }

    /**
     * 每行二分查找
     *
     * @param target
     * @param array
     * @return
     */
    public static boolean find1(int target, int[][] array) {
        if (array == null) {
            return false;
        }
        int rowLen = array.length;
        for (int i = 0; i < rowLen; i++) {
            if (twoSearch(target, array[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * 二分查找
     *
     * @param target
     * @param array
     * @return
     */
    private static boolean twoSearch(int target, int[] array) {
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target < array[mid]) {
                high = mid - 1;
            } else if (target > array[mid]) {
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;

    }

    /**
     * 左下角向上遍历
     *
     * @param target
     * @param array
     * @return
     */
    public static boolean find2(int target, int[][] array) {
        if (array == null) {
            return false;
        }
        int row = array.length - 1;
        int col = 0;
        while (row >= 0 && col <= array[0].length -1) {
            if (target < array[row][col]) {
                row--;
            } else if (target > array[row][col]) {
                col++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        Timing.startNanoTime();
        System.out.println(find2(10, array));
        Timing.printNanoTime();
    }
}
