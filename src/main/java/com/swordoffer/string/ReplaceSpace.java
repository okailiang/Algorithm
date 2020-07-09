package com.swordoffer.string;

import com.Timing;

/**
 * class:ReplaceSpace   <br/>
 * Description:nowcoder网->剑指offer: 替换空格 <br/>
 * 题目描述：请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。 <br/>
 * 题目分析：找到空格替换为20%
 * 解题思路：1.找到空格字符代替为字符串 2.转化为字符操作
 *
 * @author oukailiang
 * @create 2017-03-23 下午3:09
 */

public class ReplaceSpace {
    public static String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        return str.toString().replace(" ", "%20");
    }

    public static String replaceSpace1(StringBuffer str) {
        if (str == null) {
            return null;
        }
        int len = str.length();
        char[] charArr = {'%', '2', '0'};
        while (--len >= 0) {
            if (str.charAt(len) == ' ') {
                str.deleteCharAt(len);
                str.insert(len, charArr);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Timing.startNanoTime();
        System.out.println(replaceSpace1(new StringBuffer("We Are Happy")));
        Timing.printNanoTime();
    }
}
