package org.olddriver.learnjava.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 20210809
 * synchronized
 * 第三部分
 */
public class Synchronized {
    /**
     * 线程通信引发的问题
     * 多线程通过主内存交互，可能存在原子性问题，可见性问题，有序性问题
     *
     * 原子性问题
     * 多个线程对同一数据的操作指令执行上出现重叠
     * 可见性问题
     * 多个线程工作内存中同一数据不一致
     * 有序性问题
     * cpu乱序执行指令或编译器对指令重新排序
     *
     * 同步
     * synchronized可解决原子性问题，可见性问题，无法解决有序性问题
     * 线程执行synchronized方法前需获取指定的锁对象，任意时刻一个锁对象只能被一个线程持有
     * 执行synchronized方法前获取this对象，执行static synchronized方法获取Class对象
     * synchronized使用的锁对象可重入，可以被一个线程多次获取
     * 锁就是普通对象，所有对象都可以作为锁
     *
     * synchronized优化
     * jdk1.6 对synchronized进行优化，使用cas操作获取锁释放锁并引入锁升级概念。从偏向锁升级到轻量级锁升级到重量级锁
     *
     * 锁升级过程
     * 一个线程执行synchronized方法，先获取偏向锁，通过cas操作将线程id记录在锁对象头中
     * 当有线程竞争偏向锁，申请失败会发生偏向锁撤销。持有锁的线程会暂停执行，竞争线程将偏向锁升级为自旋锁，唤醒持有锁的线程继续执行。
     * 竞争线程开始申请自旋锁。自旋锁申请失败线程不会阻塞，会进行循环，再次申请自旋锁
     * 当自旋锁申请10次后，自旋锁升级为重量级锁。竞争线程阻塞
     *
     * volatile
     * volatile关键字可解决可见性问题，有序性问题，无法解决原子性问题
     *
     * cas操作 compare and swap
     * cas操作可解决一个共享变量原子性问题，无法解决可见性问题，有序性问题
     * 对数据进行修改前，使用旧值和内存值进行一次比较，若两者一致将内存值修改为新值
     * aba问题
     * 当一个线程执行cas操作期间，其他线程对同一数据进行操作，线程A先将a修改为b，线程B再将b修改为a，那么cas操作不再具有原子性
     * aba问题要通过比较版本号解决
     */

    static AtomicInteger integer = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(()->{
            for(int i = 0 ; i < 100000 ; i++){
                integer.incrementAndGet();
            }
        }).runAfterBoth(CompletableFuture.runAsync(()->{
            for(int i = 0 ; i < 100000 ; i++){
                integer.incrementAndGet();
            }
        }),()->{
            System.out.println(integer.get());
        });

        TimeUnit.SECONDS.sleep(1);
    }
}
