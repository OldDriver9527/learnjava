package org.olddriver.learnjava.essentialclasses;

import java.time.LocalDateTime;

/**
 * 20200527
 * part 1
 */
public class Times {
    /*
     * jdk8前日期时间API问题
     * 日期时间不方便计算
     * Date，Calendar，SimpleDateFormat线程不安全，多个线程使用同一实例会发生潜在并发问题
     * SimpleDateFormat 中 calendar字段存储操作时间，在执行操作过程中会将calendar清空，多线程情况下
     * 会影响其他线程执行
     * 设置Calendar时间可以使用未定义的魔法数字，不符合开发规范
     *
     * jdk8中新增日期时间API
     * 线程安全
     *
     * 常用类
     * Instant  表示时间线上一点
     * Duration 表示秒或纳秒的时间间隔
     * Period   表示一段时间
     * LocalDate    表示不可变日期时间对象，存储年月日
     * LocalTime    表示不可变日期时间对象，存储时分秒
     * LocalDateTime    表示不可变日期时间对象，存储年月日时分秒
     */

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getDayOfMonth());
    }
}
