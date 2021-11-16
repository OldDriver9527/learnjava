package org.olddriver.learnjava.concurrency;

import java.util.concurrent.TimeUnit;

public class JoinThread {

    static Thread t1 = null ,t2 = null;


    public static void main(String[] args){
        Runnable r1 = ()->{
            synchronized(t2){
                System.out.println(Thread.currentThread().getName()+" begin");
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" end");
            }
        };

        Runnable r2 = ()->{
            synchronized(t2) {
                System.out.println(Thread.currentThread().getName() + " begin");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " end");
            }
        };

        t1 = new Thread(r1,"t1");
        t2 = new Thread(r2,"t2");


        t1.start();
        t2.start();

    }

}
