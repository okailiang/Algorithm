package com.nowcoder.program1;

import java.util.Scanner;

/**
 * class:StringClassification   <br/>
 * Description:nowcoder网->17年校招统一模拟一: 循环单词 <br/>
 * 题目描述：如果一个单词通过循环右移获得的单词，我们称这些单词都为一种循环单词。 <br/>
 * 例如：picture 和 turepic 就是属于同一种循环单词。 现在给出n个单词，需要统计这个n个单词中有多少种循环单词。  <br/>
 * 输入描述：输入包括n+1行：
 * 第一行为单词个数n(1 ≤ n ≤ 50)
 * 接下来的n行，每行一个单词word[i]，长度length(1 ≤ length ≤ 50)。由小写字母构成 <br/>
 * 输出描述：输出循环单词的种数 <br/>
 * 输入例子： <br/>
 * 5  <br/>
 * picture  <br/>
 * turepic  <br/>
 * icturep  <br/>
 * word  <br/>
 * ordw  <br/>
 * 输出例子： <br/>
 * 2 <br/>
 * <p>
 * 题目分析：
 * 解题思路：
 *
 * @author oukailiang
 * @create 2017-03-24 上午12:32
 */

public class CycleWord {

    private static int cycleWord(int len, String[] word) {
        int result = 0;
        for (int i = 0; i < len; i++) {
            if (word[i].equals("0")) {
                continue;
            }
            String firstWord = word[i];
            int wordLen = firstWord.length();
            for (int j = i + 1; j < len; j++) {
                boolean cycleWordFlag = false;
                //同等长度则可比较
                if (wordLen == word[j].length()) {
                    int index = wordLen;
                    //找到和第一个单词第一个字母相等的字母
                    while (--index >= 0) {
                        int flag = 0;
                        int flag1;//标记被比较字符串下标
                        if (firstWord.charAt(flag) == word[j].charAt(index)) {
                            flag1 = index;
                            while (flag < wordLen) {
                                //循环比较该单词
                                if (firstWord.charAt(flag) != word[j].charAt(flag1 % wordLen)) {
                                    break;
                                }
                                flag++;
                                flag1++;
                            }
                        }
                        if (flag == wordLen) {
                            cycleWordFlag = true;
                        }
                    }
                }
                if (cycleWordFlag) {
                    word[j] = "0";
                }
            }
        }

        for (int k = 0; k < len; k++) {
            if (!word[k].equals("0")) {
                result++;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] strArray = new String[n];
        for (int i = 0; i < n; i++) {
            strArray[i] = in.next();
        }
        System.out.println(cycleWord(n, strArray));
    }

}
