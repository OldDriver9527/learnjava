package org.olddriver.learnjava.jvm;

/**
 * java并发内存模型
 * 20210806
 * 第二部分
 */
public class JMM {
    /**
     * java memory model
     * java多线程内存模式，规定多线程之间如何通过内存交互。
     * java线程共享主内存，每个线程具有独立的工作内存(类似于cpu和内存间的高速缓存)
     *
     * volatile
     * 每个线程都具有工作内存，防止工作内存中数据不一致，可以使用volatile关键字
     * 实现原理
     * 一个线程对volatile变量进行写操作，会立即将数据写入主内存。其他cpu核心会通过嗅探总线中数据发觉工作内存中数据已无效，
     * 其他线程读工作内存中数据时会从主内存中读取。实际依赖cpu缓存一致性协议实现，intel cpu使用mesi缓存一致性协议
     * volatile禁止指令重排序通过在读写操作前后添加内存屏障实现
     *
     * synchronized
     * 执行通过方法前需获取同步锁
     */
}
