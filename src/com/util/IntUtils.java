package com.util;

/**
 * @author oukailiang
 * @create 2017-10-09 上午9:56
 */

public class IntUtils {

    public static int[] toInArray(String[] strArray) {
        if (strArray == null) {
            return null;
        }
        int len = strArray.length;
        int[] a = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = Integer.parseInt(strArray[i]);
        }
        return a;
    }

    public static int[] toInArray(String line, String delimiter) {
        if (line == null || delimiter == null) {
            return null;
        }
        String[] strArray = line.split(delimiter);
        return toInArray(strArray);
    }

    public static void swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }

    public static void swap(int[] a, int i, int j) {
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }
}
