package org.olddriver.learnjava.concurrency;

import java.lang.ref.WeakReference;

/**
 * 20210810
 * ThreadLocal
 * 第九部分
 */
public class ThreadLocals {
    /**
     * 一个ThreadLocal对象用于存储一个变量值。
     * 多个线程操作同一个ThreadLocal对象，可以人为保证每个线程在ThreadLocal中存储的值互不相同，
     * 但如果多个线程向ThreadLocal中存储的值是同一个对象，此时线程间仍是相互影响的
     * 每个线程拥有一个ThreadLocalMap容器(线程私有)，key为弱引用，弱引用指向ThreadLocal对象；value是强引用，指向ThreadLocal中存储的值
     * 内存泄漏问题
     * 若在线程执行过程中，没有强引用指向ThreadLocal，ThreadLocal可能被回收。但ThreadLocalMap中的Entry存在强引用指向具体值，导致具体值不会被回收
     * 若线程迟迟不结束任务，会导致内存泄漏。
     * 在ThreadLocal使用完毕后应调用remove方法移除ThreadLocalMap中内容
     */

    static ThreadLocal<Integer> age = new ThreadLocal<>();

    static ThreadLocal<String> name = new ThreadLocal<>();

    public static void main(String[] args) {

        WeakReference<byte[]> weakReference = new WeakReference<>(new byte[1024*1024*2]);
        System.out.println(weakReference);
        System.out.println(weakReference.get());

        System.gc();
        System.out.println(weakReference);
        System.out.println(weakReference.get());



        /*SoftReference<byte[]> softReference = new SoftReference<>(new byte[1024*1024*2]);
        System.out.println(softReference);
        System.out.println(softReference.get());

        byte[] bytes = new byte[1024*1024*2];
        System.out.println(softReference);
        System.out.println(softReference.get());*/

    }
}
