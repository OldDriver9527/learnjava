package org.olddriver.learnjava.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TransferQueue;

/**
 * 20210810
 * 并发容器
 * 第七部分
 */
public class ConcurrentCollection {
    /**
     * 线程不安全集合size值不能保证对其他线程可见
     *
     * ConcurrentHashMap
     * 并发HashMap
     * ConcurrentSkipListMap
     * 元素有序
     * CopyOnWriteArrayList
     * CopyOnWriteArraySet
     * ConcurrentLinkedQueue
     * LinkedBlockingQueue
     * 无界
     * ArrayBlockingQueue
     * 有界
     * DelayQueue
     * 元素按延迟时间排序
     * SynchronousQueue
     * 两个线程交换数据
     * 线程执行put方法阻塞，直到其他线程将数据从队列中取出
     * LinkedTransferQueue
     * 线程执行transfer方法阻塞，直到其他线程将数据从队列中取出
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

    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args) {

        TransferQueue<String> queue = new LinkedTransferQueue<>();

        Runnable r = ()->{
            try {
                queue.put("hello");
                System.out.println("----------");
                queue.put("world");
                System.out.println("----------");
                queue.transfer("good luck");
                System.out.println("----------");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };


        new Thread(r).start();

        Runnable rr = ()->{
            try {
                System.out.println(queue.take());
                System.out.println(queue.take());
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(rr).start();




        /*ReentrantLock lock = new ReentrantLock();
        Condition numCondition = lock.newCondition();
        Condition characterCondition = lock.newCondition();

        Runnable printNum = () -> {
            lock.lock();
            try {
                for(int i = 0 ; i < 26 ; i++){
                    System.out.println(i + 1 + "");
                    characterCondition.signal();
                    numCondition.await();
                }
                characterCondition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        };

        Runnable printCharacter = () -> {
            lock.lock();
            try {
                for(int i = 0 ; i < 26 ; i++){
                    System.out.println((char)(i + 65) + "");
                    numCondition.signal();
                    characterCondition.await();
                }
                numCondition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        };

        new Thread(printNum).start();
        new Thread(printCharacter).start();*/

        /*Runnable printNum = ()->{
            try {
                for(int i = 0 ; i < 26 ; i++){
                    System.out.println(i + 1 + "");
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
            }catch (Exception e){

            }

        };

        Runnable printCharacter = ()->{
            for(int i = 0 ; i < 26 ; i++){
                System.out.println((char)(i + 65) + "");
                LockSupport.park();
                LockSupport.unpark(t1);
            }
        };


        t1 = new Thread(printNum);
        t2 = new Thread(printCharacter);

        t1.start();
        t2.start();*/

        /*ConcurrentCollection c = new ConcurrentCollection();

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
        new Thread(r).start();*/


    }
}
