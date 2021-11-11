package org.olddriver.learnjava.jvm;

import java.util.concurrent.TimeUnit;

/**
 * java并发内存模型
 * 20210806
 * 第二部分
 */
public class JMM {
    /**
     * java memory model
     * java内存模式，规范主内存(heap)和工作内存(jvm栈)间数据交互
     * jmm规定共享变量都存储在主内存中，线程共享主内存，每个线程具有独立的工作内存
     * 工作内存中的变量是主内存中的副本，线程只对工作内存中变量进行读写操作，而不直接操作主内存中的变量，操作完毕将工作内存中变量回写到主内存中
     * 不同线程间无法直接访问对方的工作内存
     *
     * volatile
     * 可见性问题
     * 每个线程都具有工作内存，若工作内存中数据不一致，导致线程可见性问题，可以使用volatile关键字解决
     * 实现原理
     * 一个线程对volatile变量进行写操作，操作完毕会立即将工作内存中变量值回写到主内存。
     * 一个线程对volatile变量进行读操作，该线程会把工作内存中变量副本置为无效，从主内存中读取共享变量最新值
     * 实际依赖cpu缓存一致性协议实现，intel cpu使用mesi缓存一致性协议
     * 乱序性问题
     * cpu为优化性能而乱序执行指令，可以使用volatile关键字解决
     * 通过在读写操作前后添加内存屏障实现
     *
     * synchronized
     * 执行通过方法前需获取同步锁
     */

    boolean i = true;

    void test() {
        while (i) {

        }
        System.out.println("end");
    }


    public static void main(String[] args) {
        JMM jmm = new JMM();

        new Thread(jmm::test).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        jmm.i = false;

    }
}
