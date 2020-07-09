package com.nowcoder.program2;

import java.util.Scanner;

/**
 * class:StringClassification   <br/>
 * Description:nowcoder网->17年校招统一模拟二: 字符串分类 <br/>
 * 题目描述：牛牛有N个字符串，他想将这些字符串分类，他认为两个字符串A和B属于同一类需要满足条件： <br/>
 * A中交换任意位置的两个字符，最终可以得到B,交换的次数不限。比如：abc与bca就是同一类字符串  <br/>
 * 现在牛牛想知道这N个字符串可以分成几类 <br/>
 * 输入描述：首先输入一个正整数N(1<=N<=50),接下来输入N个字符串，每个字符串长度不超过50. <br/>
 * 输出描述：输入一个整数分类的个数。 <br/>
 * 输入例子： <br/>
 * 4 <br/>
 * abcd <br/>
 * abdc <br/>
 * dabc <br/>
 * bacd <br/>
 * 输出例子： <br/>
 * 1 <br/>
 * <p>
 * 题目分析：
 * 解题思路：
 *
 * @author oukailiang
 * @create 2017-03-23 下午9:25
 */

public class StringClassification {

    private static int strClassification(String[] strArray) {
        int len = strArray.length;
        if (len == 1) {
            return 1;
        }
        String firstStr = strArray[0];
        while (len > 0) {

        }


        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] strArray = new String[n];
        for (int i = 0; i < n; i++) {
            strArray[i] = in.next();
        }
        System.out.println(strClassification(strArray));

    }
}
