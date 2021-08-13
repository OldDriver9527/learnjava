package org.olddriver.learnjava.concurrency;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

/**
 * 20210810
 * 锁
 * 第五部分
 */
public class Locks {
    /**
     * ReentrantLock
     * 可重入锁，也叫递归锁。可以被同一个线程多次获取
     * 与synchronized相比，ReentrantLock获取锁失败可以立即返回
     * lock()   获取锁，阻塞式。获取锁失败后线程阻塞
     * lockInterruptibly()  获取锁，阻塞式。获取锁失败线程进入等待状态，可以被其他线程中断
     * tryLock()    尝试获取锁，非阻塞式。获取锁失败会立即返回
     * tryLock(timeout) 指定等待时间，在等待时间内尝试获取锁。若超过等待时间立即返回
     * 获取锁的策略
     * 公平策略按线程申请锁的顺序获取锁；非公平策略线程间相互竞争
     * ReentrantLock默认采用非公平策略
     *
     * ReentrantReadWriteLock
     * 可重入读写锁
     * 读锁可以被多个线程持有，写锁只能被一个线程持有。读锁写锁不能被同时持有
     *
     * StampedLock
     *
     * Semaphore
     * 计数信号量，维护着许可集。线程获取到许可集中的许可才能执行，任务结束要释放许可。未获取到许可的线程只能等待，起到限流作用
     * acquire  获取许可
     * release  释放许可
     * 获取许可的策略
     * 公平策略按线程获取许可的顺序获取；非公平策略
     * Semaphore默认非公平策略
     *
     * LockSupport
     * 用于阻塞唤醒线程，可实现唤醒指定线程
     * 线程执行LockSupport的park方法进入等待状态
     * 当其他线程执行LockSupport的unpark方法唤醒指定线程，unpark方法可在park方法之前调用
     */

    static Lock lock = new ReentrantLock();

    static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    static ReentrantReadWriteLock.ReadLock  readLock = readWriteLock.readLock();
    static ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

    static Semaphore semaphore = new Semaphore(2);

    static StampedLock stampedLock = new StampedLock();

    public static void main(String[] args)  {






        /*Runnable r = ()->{
            LockSupport.park();
            System.out.println("run");
        };

        Thread t = new Thread(r);
        t.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(t.getState());

        LockSupport.unpark(t);*/

        /*Runnable r = ()->{
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName()+" acquire permit at "+System.currentTimeMillis());
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        };


        for(int i = 0 ; i < 10; i++){
            new Thread(r).start();
        }*/

        /*Runnable read = ()->{
            try {
                readLock.lock();
                System.out.println("read");
            } finally {
                readLock.unlock();
            }
        };

        Runnable write = ()->{
            try {
                writeLock.lock();
                System.out.println("write");
            } finally {
                writeLock.unlock();
            }
        };



        for(int i = 0 ; i < 10 ; i++){
            new Thread(read).start();
        }*/
//        for(int i = 0 ; i < 2 ; i++){
//            new Thread(write).start();
//        }

        /*Runnable r = Locks::test;

        Thread t1 = new Thread(r, "t1");
        Thread t2 = new Thread(r, "t2");

        t1.start();
        t2.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(t1.getState());
        System.out.println(t2.getState());

        t2.interrupt();*/
    }


    public static void test() {
        try {
            lock.lockInterruptibly();
            System.out.println(Thread.currentThread().getName() + " hello");
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
