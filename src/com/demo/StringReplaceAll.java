package com.demo;

/**
 * @author oukailiang
 * @create 2017-03-22 下午4:31
 */

public class StringReplaceAll {
    public static void main(String[] args) {
        String str = new String("com.jd.");
        String classFile = str.replaceAll(".", "/") + "MyClass.class";
        System.out.println(classFile);
        System.out.println(str.codePointAt(1));
        System.out.println(str.contentEquals(new String("com.jd.")));
        System.out.println(str.concat("kol"));
        System.out.println(str.intern());

    }
}
