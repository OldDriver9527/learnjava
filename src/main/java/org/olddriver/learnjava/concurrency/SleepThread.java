package org.olddriver.learnjava.concurrency;

import java.util.concurrent.TimeUnit;

public class SleepThread {


    public static void main(String[] args) {
        Object lock = new Object();

        Runnable runnable = () -> {
            synchronized (lock) {
                System.out.println("[" + Thread.currentThread().getName() + "]-[synchronized begin]");
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("[" + Thread.currentThread().getName() + "]-[synchronized end]");
            }
        };

        Thread thread1 = new Thread(runnable, "thread-1");
        thread1.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread2 = new Thread(runnable, "thread-2");
        thread2.start();

        System.out.println("[" + Thread.currentThread().getName() + "]-[" + thread1.getName() + ":" + thread1.getState() + "]");
        System.out.println("[" + Thread.currentThread().getName() + "]-[" + thread2.getName() + ":" + thread2.getState() + "]");
    }
}
