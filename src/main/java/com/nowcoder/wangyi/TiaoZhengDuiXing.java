package com.nowcoder.wangyi;

import java.util.Scanner;

/**
 * class:TiaoZhengDuiXing   <br/>
 * Description:nowcoder网->17年校招网易: 调整队形 <br/>
 * 题目描述：在幼儿园有n个小朋友排列为一个队伍，从左到右一个挨着一个编号为(0~n-1)。其中有一些是男生，有一些是女生，男生用'B'表示，女生用'G'表示。
 * 小朋友们都很顽皮，当一个男生挨着的是女生的时候就会发生矛盾。作为幼儿园的老师，你需要让男生挨着女生或者女生挨着男生的情况最少。
 * 你只能在原队形上进行调整，每次调整只能让相邻的两个小朋友交换位置，现在需要尽快完成队伍调整，你需要计算出最少需要调整多少次可以让上述情况最少。
 * 例如：
 * GGBBG -> GGBGB -> GGGBB
 * 这样就使之前的两处男女相邻变为一处相邻，需要调整队形2次 。<br/>
 * <br/>
 * <p>
 * 输入描述：输入数据包括一个长度为n且只包含G和B的字符串.n不超过50.
 * <p>
 * <br/>
 * <p>
 * 输出描述：输出一个整数，表示最少需要的调整队伍的次数。 <br/>
 * <br/>
 * <p>
 * 输入例子:GGBBG  <br/>
 * 输出例子:2  <br/>
 * 题目分析：
 * 解题思路：
 * <br/>
 *
 * @author oukailiang
 * @create 2017-03-25 下午2:51
 */
public class TiaoZhengDuiXing {

    /**
     * 由于我们只有目标状态只可能是两种,形如: BBBBBGGGGG GGGGGBBBBB BBGBGB
     * 于是我们对于串中第一个'B'然后计算把它swap到第一个位置需要多少次,
     * 第二个'B'swap到第二个位置需要多少次...依次类推.. 然后对于'G'同理,最后取个较小值即为答案。
     * @param str
     * @return
     */
    private static int reset1(String str) {
        int resultB = 0, resultG = 0;
        int b = 0, g = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'B') {
                resultB += g;
                ++b;
            } else {
                resultG += b;
                ++g;
            }
        }
        return resultB >= resultG ? resultG : resultB;
    }


    private static int reset(String str) {
        int n = str.length();
        if (n <= 2) {
            return 0;
        }
        int resultB, resultG;
        char first = str.charAt(0);
        if (first == 'B') {
            resultB = move('B', 'G', str); //移动后B做开头
            resultG = otherMove('B', 'G', str);//移动后G做开头
        } else {
            resultB = move('G', 'B', str);//移动后B做开头
            resultG = otherMove('G', 'B', str);//移动后G做开头

        }
        return resultB <= resultG ? resultB : resultG;
    }

    /**
     * 移动
     *
     * @param start 字符串的开始字符
     * @param other 字符串的另外字符
     * @param str   字符串
     * @return
     */
    private static int move(char start, char other, String str) {
        int n = str.length();
        int result = 0, startCount = 0, otherCount = 0;
        int index = 0;
        while (index < n - 1) {
            //跳过第一个
            index++;
            //遇到开始的字符
            if (str.charAt(index) == start && otherCount == 0) {
                continue;
            } else if (str.charAt(index) == start && otherCount != 0) {
                startCount++;
                if (index != n - 1) {//最后一个和第一个相同
                    continue;
                }
            }
            //遇到另外一个字符
            if (str.charAt(index) == other && startCount == 0) {
                if (startCount == 0) {//还没有遇到开始的那个
                    otherCount++;
                    continue;
                }
            }
            //遇到另外一个或循环结束
            if (startCount != 0 || index == n - 1) {
                result = result + startCount * otherCount;
                startCount = 0;
                otherCount++;
            }
        }
        return result;
    }

    /**
     * 如果是B开头，就将另外一个G移到开头
     *
     * @param start 字符串的开始字符
     * @param other 字符串的另外字符
     * @param str   字符串
     * @return
     */
    private static int otherMove(char start, char other, String str) {
        int n = str.length();
        int result = 0, otherCount = 0;
        int startCount = 1;//第一个已取出
        int index = 0;
        while (index < n - 1) {
            index++;
            if (str.charAt(index) == start && otherCount == 0) {
                startCount++;
                continue;
            }

            if (str.charAt(index) == other) {
                otherCount++;
                if (index != n - 1) {//另外一个在最后
                    continue;
                }
            }
            if (otherCount != 0 || index == n - 1) {
                result = result + startCount * otherCount;
                otherCount = 0;
                startCount++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            System.out.println(reset1(str));
        }
    }
}
