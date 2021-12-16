package org.olddriver.learnjava.concurrency;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 * synchronized
 * 20210809
 * 第三部分
 */
public class Synchronized {
    /**
     * java并发程序存在的问题
     * java并发程序可能存在原子性问题，可见性问题，有序性问题
     *
     * 原子性问题
     * 多个线程执行对同一共享数据的操作指令时，指令的执行顺序出现重叠，导致线程间互相干扰
     * 可见性问题
     * 每个线程均有各自的工作内存，多线程对同一共享变量进行读写，会在工作内存中存储共享变量的副本，
     * 若工作内存中副本值无法及时更新，会导致多个线程工作内存中同一数据不一致
     * 有序性问题
     * cpu为提高执行效率乱序执行指令，cpu保证乱序执行不对单线程情况产生影响，但会对多线程情况产生影响
     *
     * 同步机制
     * synchronized可解决原子性问题，可见性问题，无法解决有序性问题
     * 线程执行synchronized方法前需获取指定的锁对象，任意时刻一个锁对象只能被一个线程持有
     * 线程获取同步锁，会把工作内存置为无效，重新从主内存中读取；
     * 线程释放同步锁，会把共享数据同步到主内存中
     * synchronized修饰的实例方法以this对象作为同步锁，synchronized修饰的类方法以Class对象作为同步锁
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
     * 偏向锁失效
     * identity hash code 与偏向锁的线程id都要存储在对象头中
     * 在无锁状态下计算identity hash code后，会将identity hash code记录在对象头中，
     * 此后不能使用线程id覆盖，获取锁时会跳过偏向锁的阶段
     * 在偏向锁状态下计算identity hash code，会将偏向锁撤销，变为轻量级锁或重量级锁
     *
     * volatile
     * volatile关键字可解决可见性问题，有序性问题，无法解决原子性问题
     *
     * cas操作(compare and swap)
     * cas操作可解决一个共享变量原子性问题，无法解决可见性问题，有序性问题
     * 对数据进行修改前，使用旧值和内存值进行一次比较，若两者一致将内存值修改为新值
     * aba问题
     * 当一个线程执行cas操作期间，其他线程对同一数据进行操作，线程A先将a修改为b，线程B再将b修改为a，那么cas操作不再具有原子性
     * aba问题要通过比较版本号解决
     */

    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        o.hashCode();
        Thread t1 = new Thread(()->{
            synchronized (o){

                System.out.println(ClassLayout.parseInstance(o).toPrintable());

            }
        });
//        Thread t2 = new Thread(()->{
//            synchronized (o){
//                System.out.println("222");
//                System.out.println(ClassLayout.parseInstance(o).toPrintable());
//            }
//        });
        t1.start();
        //t2.start();


    }


    public static synchronized void test(){
        System.out.println(Thread.currentThread().getName()+" hello");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
