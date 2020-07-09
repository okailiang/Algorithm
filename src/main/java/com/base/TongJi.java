package com.base;

import java.util.*;

/**
 * @author oukailiang
 * @create 2017-10-18 下午7:49
 */

public class TongJi {


    //    public static void test(List<Integer> list) {
//
//        Map<Integer, Integer> map = new HashMap<>();
//        Integer max = 0L, result = 0L;
//        //统计每个用户访问个数
//        for (Integer id : list) {
//            if (map.get(id) == null) {
//                map.put(id, 1L);
//            } else {
//                map.put(id, map.get(id) + 1);
//            }
//        }
//
//        //找到访问最大的
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getValue() > max) {
//                result = entry.getKey();
//                max = entry.getValue();
//            }
//        }
//        System.out.println(result);
//    }
    public static void test(List<Integer> list) {

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        List<Integer> list = new ArrayList<>();
        int[] a = new int[n];
        int m;
        for (int i = 0; i < n; i++) {
            m = scanner.nextInt();
            if (a[m] > 0) {
                a[m] = a[m] + 1;
            } else {
                a[m] = 1;
            }
//            list.add(scanner.nextInt() % 16);
        }
//        test(list);
        int max = 0,result = 0;
        for (int i = 0; i < a.length; i++) {
            if(a[i] > max){
                max = a[i];
                result = i;
            }
        }
        System.out.println(result);

    }
}
