package com.base;

/**
 * 找数组中2个出现两次的数字
 *
 * @author oukailiang
 * @create 2017-10-10 下午7:48
 */

public class TwoRepeat {

    private static void twoRepeat(int[] a) {
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            result = result ^ a[i]^i;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 6, 4, 4, 5, 3, 7};
        twoRepeat(a);
    }
}
