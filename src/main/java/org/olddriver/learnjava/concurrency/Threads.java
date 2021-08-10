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
     * 进程和线程
     * 进程
     * 一个运行的应用程序就是一个进程，一个进程中至少包含一个线程。每个进程都有独立运行环境和资源，
     * 大多数JVM都是单进程
     * 线程
     * 进程中的独立运行单元，cpu的调度单位。线程共享进程资源。
     * 一个线程可以执行一个独立任务，实际情况是cpu切换执行线程任务，但理解为线程执行各自任务更简单
     *
     * 并发
     * 多个线程在逻辑上同时运行称为并发。程序只需关心并发，不需关心能否并行
     *
     * 使用线程方式
     * i.继承Thread类，重写run方法，之后创建子类对象，通过线程对象start方法启动线程。
     * 启动一个新线程时，Java虚拟机都会为它分配一个Java栈
     * ii.创建线程任务对象，将线程任务对象传递给线程，开启线程。线程可以接收Runnable，FutureTask任务。
     * iii.创建线程任务对象，将线程任务对象传递给线程池。线程池可以接收Runnable，Callable，FutureTask任务。
     *
     * java线程状态
     * NEW  新建
     * 线程对象刚刚创建完毕，还未调用start方法启动的线程的状态
     * RUNNABLE 可运行
     * 启动后进入可运行状态。线程等待运行或线程正在运行
     * BLOCKED 阻塞
     * 执行同步方法，还未获取到锁对象的线程的状态
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
     * 线程执行完run()的线程的状态
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
