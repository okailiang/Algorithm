package com.nowcoder.wangyi;

import java.util.Scanner;

/**
 * class:ReverseAdd   <br/>
 * Description:nowcoder网->17年校招网易: 调整队形 <br/>
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
 *
 * @author oukailiang
 * @create 2017-03-25 下午2:51
 */
public class TiaoZhengDuiXing {

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
            System.out.println(reset(str));
        }
    }
}
