package org.olddriver.learnjava.concurrency;

import java.util.concurrent.TimeUnit;

public class ThreadState {
    public static void main(String[] args) {
        Thread main = Thread.currentThread();

        Runnable task = () -> {
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName() +" ---- "+ thread.getState());

            try {
//                main.join();
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            test(thread);
        };

        Thread thread = new Thread(task);
        System.out.println(thread.getName() +" ---- "+ thread.getState());
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(thread.getName() +" ---- "+ thread.getState());

        test(thread);
    }


    public static synchronized void test(Thread thread){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(thread.getName() +" ---- "+ thread.getState());
    }


}
