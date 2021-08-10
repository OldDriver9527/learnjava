package org.olddriver.learnjava.jvm;

/**
 * jvm指令
 * 20210807
 * 第五部分
 */
public class Instructions {
    /**
     * bipush   将字节数据压入操作数栈
     * istore_n 将操作数栈栈顶数据弹栈，存入局部变量表中下标为n的局部变量
     * iload_n  获取局部变量表中下标为n的局部变量值，压入操作数栈
     * iinc n by 1  对局部变量表中下标为n的局部变量值加1
     * new  创建对象并将对象地址压入操作数栈
     * dup  复制操作数栈栈顶元素，复制的栈顶元素供构造器使用，调用构造器，实例方法会使栈顶元素弹栈
     * iconst_<i>   将常量值压入操作数栈
     * invokestatic     调用类方法
     * invokevirtual    调用实例方法
     * invokeinterface  调用接口中方法
     * invokespecial    调用可直接定位，不存在多态情况的方法。如private方法，构造器
     * invokedynamic    与lambda相关
     */
}
