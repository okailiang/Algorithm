package com.base;

/**
 * 分割字符
 *
 * @author oukailiang
 * @create 2017-10-10 下午5:57
 */

public class SplitChar {

    private static void splitChar(String str, String limit) {
        int len = str.length();
        if (len < limit.length()) {
            System.out.println(str);
            return;
        }
        int start = 0, end = 0;

        for (int i = 0; i < len; ) {
            char c = str.charAt(i);
            char lc = limit.charAt(start);
            if (c == lc) {
                if (start == (limit.length() - 1)) {
                    System.out.println(str.substring(end, i - start));
                    end = i + 1;
                    start = 0;
                } else {
                    start++;
                }

            } else {
                start = 0;
            }
            i++;
        }

        if (end < len) {
            System.out.println(str.substring(end, len));
        }


    }

    public static void main(String[] args) {
        splitChar("12m459mm88mm990mm0", "m");
    }
}
