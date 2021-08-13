package org.olddriver.learnjava.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 20210810
 * 并发容器
 * 第七部分
 */
public class ConcurrentCollection {
    /**
     * 线程不安全集合size值不能保证对其他线程可见
     *
     */


    List lists = new ArrayList();



    /*public static void main(String[] args) {
        ConcurrentCollection c = new ConcurrentCollection();

        new Thread(() -> {
            for(int i=0; i<10; i++) {
                c.add(new Object());
                System.out.println("add " + i);

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();

        new Thread(() -> {
            while(true) {
                if(c.size() == 5) {
                    break;
                }
            }
            System.out.println("t2 结束");
        }, "t2").start();
    }*/

    BlockingQueue<String> arrayList = new PriorityBlockingQueue<>();

    public void add(String o) {
        arrayList.add(o);
    }

    public int size() {
        return arrayList.size();
    }

    public static void main(String[] args) {

        ConcurrentCollection c = new ConcurrentCollection();

        Runnable r = ()->{
            for(int i = 0 ; i < 10 ; i++){
                c.add("hello");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("quit");
        };

        Runnable r1 = ()->{
            while(true){
//                System.out.println(c.size());
                if(c.size() == 5){
                    break;
                }
            }
            System.out.println("break");
        };
        new Thread(r1).start();
        new Thread(r).start();


    }
}
