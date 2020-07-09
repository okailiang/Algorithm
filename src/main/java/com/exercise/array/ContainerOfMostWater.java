package com.exercise.array;


/**
 * Class:ContainerOfMostWater<br/>
 * Description:array-leetcode<br/>
 * <p>
 * 题目描述: 给定n个非负整数a1，a2，…，an，其中每个数字表示坐标(i, ai)处的一个点。以（i，ai）和（i，0）（i=1,2,3...n）为端点画出n条直线。
 * 你可以从中选择两条线与x轴一起构成一个容器，最大的容器能装多少水？
 * 注意：你不能倾斜容器 <br/>
 * 输入 [1,8,6,2,5,4,8,3,7] <br/>
 * 输出: 49 <br/>
 * 题目翻译简述：单链表排序，要求时间复杂度O(nlog n)，空间复杂度为常数。 <br/>
 * <p>
 * 题目分析：<br/>
 * 解题思路： <br/>
 * <p>
 * Copyright: USTC
 *
 * @author Oukailiang
 * @version 1.0.0
 */
public class ContainerOfMostWater {

    //输入 [1,8,6,2,5,4,8,3,7]
    //输出: 49
    public int maxArea(int[] height) {
        // write code here
        int[] result = new int[height.length];
        int left = 1;
        int right = 7;
        for (int i = 0; i < height.length - 1; i++) {
            if (height[i + 1] - height[i] > i + 1 - left) {

            }

        }


        return 0;
    }

    public static void main(String[] args) {

    }


}
