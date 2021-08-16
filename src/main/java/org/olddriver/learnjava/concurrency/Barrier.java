package org.olddriver.learnjava.concurrency;

import java.util.concurrent.*;

/**
 * 20210811
 * 屏障
 * 第六部分
 */
public class Barrier {
    /**
     * CountDownLatch
     * 倒数屏障，线程执行了屏障的await方法会进入等待状态，通过其它线程减少计数，
     * 当计数减为0线程恢复运行，只能使用一次
     *
     * CyclicBarrier
     * 循环屏障，线程执行CyclicBarrier的await方法进入等待状态，当循环屏障上等待的线程数量达到指定数量，线程恢复执行
     * 适合用在线程循环执行相同操作多次，一轮操作结束后再开始下一轮操作。若一轮操作未结束就开始下一轮操作，不适合使用CyclicBarrier
     * CyclicBarrier可以重复使用，线程在执行多轮操作过程中都使用同一个循环屏障对象
     * 屏障动作指在每轮操作结束后执行一个动作再开始下一轮操作
     *
     * Phaser
     * 阶段屏障，与CyclicBarrier功能类似。线程执行Phaser的arriveAndAwaitAdvance方法在屏障上等待前进，进入等待状态。当屏障上等待线程到达指定数量，线程恢复执行。
     * 适合用在线程任务被划分为多个阶段，一个阶段完成后再执行下一阶段。
     * Phaser也可以重复使用，在一轮任务多个阶段中可使用同一个Phaser对象，在多轮任务中也可使用同一个Phaser对象。但要保证Phaser有效
     * Phaser可以在线程运行中修改屏障上等待的线程个数
     * onAdvance    重写此方法定义屏障动作，每个阶段完成执行一次屏障动作。
     *              一旦此方法返回true会导致Phaser失效
     *
     * Exchanger
     * 交换器，实现两个线程间数据交换。可重复使用
     * 线程执行exchange方法等待与其他线程交换数据，数据交换完毕线程恢复执行
     * 适合两个线程交替执行
     */

    static CountDownLatch latch = new CountDownLatch(10);

    static CyclicBarrier barrier = new CyclicBarrier(2);

    static Phaser phaser = new Phaser(5);

    static Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args)  {


        /*Runnable r = ()->{
            try {
                System.out.println(Thread.currentThread().getName()+"---"+exchanger.exchange(Thread.currentThread().getName()));
                System.out.println(Thread.currentThread().getName()+"---"+exchanger.exchange(Thread.currentThread().getState().toString()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        for(int i = 0 ; i < 2; i++){
            new Thread(r,i+"").start();
        }*/

//        for(int i = 0 ; i < 2; i++){
//            new Thread(r,i+2+"").start();
//        }


        /*Runnable r = () -> {
            System.out.println("phase 1---" + System.currentTimeMillis());
            phaser.arriveAndAwaitAdvance();
            System.out.println("phase 2---" + System.currentTimeMillis());
            phaser.arriveAndAwaitAdvance();
            System.out.println("phase 3---" + System.currentTimeMillis());
            phaser.arriveAndAwaitAdvance();
        };


        for(int i = 0 ; i < 5 ; i++){
            new Thread(r,i+"").start();
        }*/


        /*Thread[] treads = new Thread[5];

        Runnable r = () -> {
            try {
                System.out.println(System.currentTimeMillis() + "--" + Thread.currentThread().getName() + "--" + Thread.currentThread().getState());
                barrier.await();
                System.out.println(System.currentTimeMillis() + "--" + Thread.currentThread().getName() + "--" + Thread.currentThread().getState());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        };
        for (int i = 0; i < 5; i++) {
            treads[i] = new Thread(r, i + "");
            treads[i].start();
        }

        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("----------------------------");
        for (int i = 0; i < 5; i++) {
            treads[i] = new Thread(r, i + 5 + "");
            treads[i].start();
        }*/

        /*Thread main = Thread.currentThread();

        Runnable r = ()->{
            System.out.println(main.getName()+"---"+main.getState());
            latch.countDown();

        };

        for(int i = 0 ; i < 10 ; i++){
            new Thread(r).start();
        }

        try {
            latch.await();
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(main.getName()+"---"+main.getState()+"---"+latch.getCount());*/
    }
}
