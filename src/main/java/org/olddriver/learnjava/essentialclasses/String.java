package org.olddriver.learnjava.essentialclasses;

import java.util.Arrays;

/**
 * 20200510
 * part 1
 */
public class String {
    /*
     * String类表示字符串
     * String类中提供操作字符串方法，返回新String对象
     * charAt(int)  获取指定索引处字符
     * substring(int)   从起始索引处开始，到当前字符串结尾结束，截取当前字符串，返回子串
     * substring(int,int)   从起始索引处开始，到结束索引结束，截取当前字符串，返回子串
     *                      包含起始索引，不包含结束索引
     * split(String)    使用匹配正则的子串分割当前字符串，返回字符串数组
     *                  返回结果中不包含匹配正则的子串
     *
     *
     *
     */

    public static void main(java.lang.String[] args) {

        java.lang.String str = "hello java";
        System.out.println(str.charAt(1));
        System.out.println(str.substring(1));
        System.out.println(str.substring(1,5));

        System.out.println(Arrays.toString(str.split("l")));


    }
}
