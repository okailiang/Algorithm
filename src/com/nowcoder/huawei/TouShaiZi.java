package com.nowcoder.huawei;

import java.util.Scanner;

/**
 * class:ReverseAdd   <br/>
 * Description:nowcoder网->17年校招华为: 整数翻转 <br/>
 * 题目描述：。<br/>
 * <br/>
 * <p>
 * 输入描述：
 * <p>
 * <br/>
 * <p>
 * 输出描述：。 <br/>
 * <br/>
 * <p>
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <p>
 * @author oukailiang
 * @create 2017-03-24 下午7:42
 */

public class TouShaiZi {
    private static String touShaiZi(String start, String str) {
        int strLen = str.length();
        if (strLen == 0) {
            return start;
        }
        int index = 0;
        String before, middle, after;

        StringBuilder sb;
        while (index < strLen) {
            sb = new StringBuilder();
            if (str.charAt(index) == 'R') {
                before = start.substring(0, 2);
                middle = start.substring(2, 4);
                sb.append(start.charAt(5)).append(start.charAt(4))
                        .append(middle).append(before);
                start = sb.toString();
                index++;
                continue;
            }

            if (str.charAt(index) == 'L') {
                middle = start.substring(2, 4);
                after = start.substring(4, 6);
                sb.append(after).append(middle).append(start.charAt(1)).append(start.charAt(0));
                start = sb.toString();
                index++;
                continue;
            }

            if (str.charAt(index) == 'A') {
                before = start.substring(0, 2);
                after = start.substring(4, 6);
                sb.append(start.charAt(3)).append(start.charAt(2)).append(before).append(after);
                start = sb.toString();
                index++;
                continue;
            }

            if (str.charAt(index) == 'C') {
                middle = start.substring(2, 4);
                after = start.substring(4, 6);
                sb.append(middle).append(start.charAt(1)).append(start.charAt(0)).append(after);
                start = sb.toString();
                index++;
                continue;
            }
            if (str.charAt(index) == 'F') {
                before = start.substring(0, 2);
                after = start.substring(4, 6);
                sb.append(before).append(after).append(start.charAt(3)).append(start.charAt(2));
                start = sb.toString();
                index++;
                continue;
            }
            if (str.charAt(index) == 'B') {
                before = start.substring(0, 2);
                middle = start.substring(2, 4);
                sb.append(before).append(start.charAt(5)).append(start.charAt(4)).append(middle);
                start = sb.toString();
                index++;
                continue;
            }

        }
        return start;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String start = "123456";
        String str = in.nextLine();
        System.out.println(touShaiZi(start, str));
    }
}
