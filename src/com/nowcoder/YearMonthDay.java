package com.nowcoder;

import java.util.Scanner;

/**
 * 输入年月日判断是一年中的第几天
 * @author oukailiang
 * @create 2017-09-23 下午3:07
 */

public class YearMonthDay {
    private static int test(int year, int month, int day) {
        int result = 0;
        //表示月份
        int[] monthArr = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        //闰年
        if (isRunYear(year, month)) {
            monthArr[2] = 29;
        }
        for (int i = 1; i < month; i++) {
            result += monthArr[i];
        }
        result += day;
        return result;
    }

    /**
     * 是闰年月份大于2
     *
     * @param year
     * @param month
     * @return
     */
    private static Boolean isRunYear(int year, int month) {

        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) && month > 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String str = sc.nextLine();
            if ("".equals(str.trim())) {
                break;
            }
            String[] strArr = str.split(" ");
            System.out.println(test(Integer.parseInt(strArr[0]), Integer.parseInt(strArr[1]), Integer.parseInt(strArr[2])));
        }


    }
}
