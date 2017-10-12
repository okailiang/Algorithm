package com.nowcoder.wangyi;

import java.util.Scanner;

/**
 * @author oukailiang
 * @create 2017-09-09 下午4:21
 */

public class Shulie {

    private static String check(int a[]) {
        if (a == null || a.length == 0) {
            return "NO";
        }
        //偶数个数大于一般
        int twoNum = 0;
        int fourNum = 0;
        int t = 0;
        for (int i = 0; i < a.length; i++) {
            if(a[i]%2 ==0){
                twoNum++;
            }
            if(a[i] ==2){
                t++;
            }
            if(a[i]%4 ==0){
                fourNum++;
            }
        }
        if(fourNum >= a.length/2){
            return "YES";
        }
        if((twoNum-t)<a.length/2){
            return "NO";
        }

        return "YES";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int a[] = new int[m];
            for (int j = 0; j < m; j++) {
                a[j] = sc.nextInt();
            }
            System.out.println(check(a));
        }

    }

}
