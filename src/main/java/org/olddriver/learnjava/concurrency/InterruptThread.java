package org.olddriver.learnjava.concurrency;

import java.util.concurrent.TimeUnit;

public class InterruptThread {
    public static void main(String[] args) {
        Runnable task = () -> {
            try {
                Thread thread = Thread.currentThread();
                System.out.println(thread.getName()+" run ---");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(task);
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" run ---");
        thread.interrupt();
        try {
            System.out.println(Thread.currentThread().getName()+" wait ---");
            thread.join();
        }catch (Exception e){
            e.printStackTrace();
        }



        Runnable r = ()-> {
            System.out.println(Thread.currentThread().getName()+" hello!!!");
            Thread.currentThread().interrupt();
            System.out.println("1"+Thread.currentThread().isInterrupted());
            System.out.println("2"+Thread.interrupted());
            System.out.println("3"+Thread.currentThread().isInterrupted());
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();

    }
}
