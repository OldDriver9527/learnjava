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

    }
}
