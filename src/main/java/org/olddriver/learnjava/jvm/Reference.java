package org.olddriver.learnjava.jvm;

import java.lang.ref.WeakReference;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 引用
 * 20211113
 * 第八部分
 */
public class Reference {
    /**
     * 强软弱虚
     * 强引用 普通引用
     * 若对象被强引用指向，不会被垃圾回收器清除
     * 通过将引用赋值为null，可以中断强引用与对象关联
     * 软引用(soft reference)
     * 若对象被软引用指向，内存不够时对象会被垃圾回收器清除
     * 弱引用(weak reference)
     * 若对象被弱引用指向，只要发生垃圾回收，对象就会被清除
     * WeakHashMap  Entry中key属于弱引用，当key指向的对象被回收，整个键值对会被删除
     * ThreadLocalMap
     * 虚引用(phantom reference)
     * 虚引用指向的对象被垃圾回收器清除，被回收的对象会被添加到指定队列中
     * 虚引用主要用来跟踪对象被垃圾回收的活动
     * 常用于管理直接内存(堆外内存)
     *
     * 操作缓存时考虑使用soft reference或weak reference
     */

    public static void main(String[] args) {

        Deque<WeakReference> deque = new LinkedList<>();

        while(true){
            WeakReference garbage = new WeakReference(new Garbage());
            deque.addFirst(garbage);
        }
    }
}
