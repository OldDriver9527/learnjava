package org.olddriver.learnjava.concurrency;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 20200907
 * 线程
 * 第一部分
 */
public class Threads {
    /**
     * 并发
     * 多个线程在逻辑上同时运行称为并发。程序只需关心并发，不需关心能否并行
     *
     * 进程和线程(Processes and Threads)
     * 进程
     * 操作系统中资源分配的最小单位。每个进程都有独立运行环境和资源，
     * 一个运行的应用程序就是一个进程，一个进程中至少包含一个线程。大多数JVM都是单进程
     * 线程
     * 操作系统中任务调度的最小单位。线程位于进程当中。线程共享进程资源
     * 进程间切换及进程间通信的开销大于线程间切换及线程间通信的开销，引入线程提高计算机并发性能
     *
     * 使用线程方式
     * i.创建线程任务对象，将线程任务对象传递给线程，开启线程。线程可以接收Runnable，FutureTask任务。
     * ii.继承Thread类，重写run方法，之后创建子类对象，通过线程对象start方法启动线程。
     * 启动一个新线程时，Java虚拟机都会为它分配一个Java栈
     * iii.创建线程任务对象，将线程任务对象传递给线程池。线程池可以接收Runnable，Callable，FutureTask任务。
     *
     * java线程状态
     * NEW  新建
     * 线程对象刚刚创建完毕，还未调用start方法启动的线程的状态
     * RUNNABLE 可运行
     * 线程启动后，正在占用CPU资源或正在等待CPU资源的线程的状态
     * BLOCKED 阻塞
     * 执行同步方法，还未获取到锁的线程的状态
     * WAITING 等待
     * 执行不具有等待时间方法的线程的状态，方法包括
     * wait()
     * Thread.join()
     * LockSupport.park
     * 等待状态的线程需依靠其他线程的通知才能恢复可运行状态
     * TIMED_WAITING 定时等待
     * 执行带有指定正等待时间方法的线程的状态，方法包括
     * 具有等待时间的Thread.sleep()
     * 具有等待时间的Thread.join()
     * 具有等待时间的wait()
     * LockSupport.parkNanos
     * LockSupport.parkUntil
     * 定时等待状态的线程当时间超过定时时间后恢复可运行状态
     * TERMINATED 终止
     * 执行完run()的线程的状态
     * NEW -> RUNNABLE -> TERMINATED
     *           |
     *        BLOCKED
     *           |
     *        WAITING
     *           |
     *        TIMED_WAITING
     *
     * 后台(Daemon)线程
     * 当JVM进程中只包含后台进程，JVM进程会自动结束
     * 后台线程执行的run()中finally块不保证一定执行
     * 在启动线程前设置后台线程才会生效
     *
     * Sleep
     * 通过Thread类中sleep方法可以让当前线程暂停执行指定时间，休眠时间过后，线程自动恢复为可运行状态。sleep方法不会导致线程释放锁
     * TimeUnit枚举可选择暂停时间的单位
     *
     * Joins
     * 在当前线程前插入另一个线程，使当前线程暂停执行，直至另一个线程执行完毕后，当前线程恢复可运行状态。
     * 可用于等待指定线程结束
     * join方法大多数情况不会导致线程释放锁。
     * 在某些情况下可以导致线程释放锁资源，当前线程以等待线程作为锁，等待的线程又以自身作为锁，这种情况当前线程执行join方法释放锁
     *
     * Yield
     * 使当前线程释放cpu资源，重新竞争cpu资源。yeild方法不会使线程释放锁
     *
     * 中断线程
     * interrupt    为指定线程设置中断状态，并不会使线程立刻停止
     * isInterrupted    判断指定线程是否处于中断状态，不清除线程中断状态
     * interrupted  判断当前线程是否处于中断状态，会清除线程中断状态
     * 处于WAITING，TIMED_WAITING状态的线程，被中断时会抛出InterruptedException，并清除中断状态
     * 通过中断可以取消线程任务
     *
     * 线程通信引发的问题
     * 线程通过访问共享字段及共享对象进行通信，可能会导致线程干扰(thread interference)和内存一致性错误(memory consistency errors)
     * 同步可以阻止这两种错误
     * 线程干扰
     * 当两线程操作同一数据，但每个线程执行不同操作，并且一个操作又可以被转换为多个jvm指令，不同jvm指令间出现交叠
     * 内存一致性错误
     * 不同线程对同一共享数据的视图(备份)不一致。堆内存中共享字段被线程共享，每个线程会持有共享字段的副本。当一个线程对共享字段进行修改，
     * 修改内容会立刻写回堆中，但其他线程未必会立刻读取修改后的内容，可能仍然使用之前的副本
     * 同步synchronized
     * synchronized使用对象的监视器锁解决线程干扰和内存一致性问题，监视器锁可重入(Reentrant)
     * 线程执行synchronized方法或代码块之前，必须先获取对象的监视器锁
     * 线程执行synchronized方法同时可以执行非synchronized方法
     * synchronized方法中抛出异常会释放锁
     * synchronized不能使用String，Integer，Long类型对象，防止同源码使用相同锁导致死锁
     * synchronized优化
     * jdk1.6中对synchronized进行优化，锁分为四种状态，根据竞争情况逐步升级，无法降级？？？？
     *
     * 原子操作
     * 不可以被中断的一系列操作，如
     * 对引用类型变量及基本类型变量(long，double除外)的读写
     * 对volatile修饰字段的读写
     * 原子操作不必担心线程干扰，但仍存在内存一致性问题
     *
     * volatile
     * volatile可以保证线程可见性及禁止指令重排序，可以解决内存一致性问题
     * synchronized无法禁止指令重排序
     *
     * CAS算法(compare and swap)
     * java原子类使用cas算法实现同步，是乐观锁的一种实现方式。cas操作需三个值，内存值(V)，预期原值(A)，新值(B)
     * 当内存值与预期原值相等，才进行交换操作，否则修改预期原值重新尝试
     * cas存在的问题
     * ABA
     *
     * 原子类
     * 提供一些线程安全的更新变量值方法
     * AtomicInteger
     * AtomicLong
     *
     * ReentrantLock(重入锁)
     * ReentrantLock可以替代synchronized，功能比synchronized强大
     *
     *
     *
     *
     */

    public static void main(String[] args) {




    }

    public static void testReentrantLock(){
        Threads t = new Threads();
        Runnable runnable = t::reentrantLock;

        Thread thread1 = new Thread(runnable,"thread-1");
        Thread thread2 = new Thread(runnable,"thread-2");

        thread1.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        thread2.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("["+thread1.getName()+"]-["+thread1.getState()+"]");
        System.out.println("["+thread2.getName()+"]-["+thread2.getState()+"]");

    }

    private ReentrantLock lock = new ReentrantLock();
    public void reentrantLock(){

        lock.lock();
        try{
            System.out.println("["+Thread.currentThread().getName()+"]-[get reentrantlock]");
            try {
                TimeUnit.SECONDS.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    private AtomicInteger count = new AtomicInteger(0);

    public void testAtomic() {

        Runnable runnable = () -> {
            for (int i = 0; i < 10000; i++) {
                count.incrementAndGet();
            }
        };

        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(runnable, "thread-" + i);
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        System.out.println(count);

    }

    private volatile boolean running = true;

    public void testVolatile() {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("[" + Thread.currentThread().getName() + "]-[start]");
                while (running) {
                    //System.out.println("["+Thread.currentThread().getName()+"]-[running]");
                }
                System.out.println("[" + Thread.currentThread().getName() + "]-[end]");
            }
        };

        Thread thread1 = new Thread(runnable, "thread-1");
        thread1.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("[" + Thread.currentThread().getName() + "]-[set cancel]");
        this.running = false;
        System.out.println("[" + Thread.currentThread().getName() + "]-[set cancel]");
    }

    public static void testYeild() {
        Object lock = new Object();
        Runnable runnable1 = () -> {
            synchronized (lock) {
                while (true) {
                    Thread.yield();
                }
            }
        };

        Runnable runnable2 = () -> {
            synchronized (lock) {
                System.out.println("[" + Thread.currentThread().getName() + "]-[in synchronized]");
            }
        };

        Thread thread1 = new Thread(runnable1, "thread-1");
        thread1.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread2 = new Thread(runnable2, "thread-2");
        thread2.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("[" + thread1.getName() + "]-[" + thread1.getState() + "]");
        System.out.println("[" + thread2.getName() + "]-[" + thread2.getState() + "]");

    }

    class Thread1 extends Thread {

        @Override
        public void run() {
            synchronized (this) {
                System.out.println("[" + Thread.currentThread().getName() + "]-[in synchronized]");
            }
        }
    }

    public void join2() {
        Thread1 t = new Thread1();

        synchronized (t) {
            System.out.println("[" + Thread.currentThread().getName() + "]-[in synchronized]");
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("[" + Thread.currentThread().getName() + "]-[synchronized end]");
        }

    }

    public static void join1() {
        Object lock = new Object();

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock) {
                    System.out.println("[" + Thread.currentThread().getName() + "]-[in synchronized]");
                }
            }
        };

        Thread thread1 = new Thread(runnable1, "thread-1");
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("[" + Thread.currentThread().getName() + "]-[in synchronized]");
                    try {
                        thread1.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("[" + Thread.currentThread().getName() + "]-[synchronized end]");
                }
            }
        };

        Thread thread2 = new Thread(runnable2, "thread-2");
        thread1.start();
        thread2.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("[" + thread1.getName() + "]-[" + thread1.getState() + "]");
        System.out.println("[" + thread2.getName() + "]-[" + thread2.getState() + "]");

    }


}
