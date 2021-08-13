package org.olddriver.learnjava.concurrency;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 20210810
 * AQS
 * 第八部分
 */
public class AQS {
    /**
     * AbstractQueuedSynchronizer
     * 实现锁和屏障的工具，内部维护一个volatile字段和一个双向链表
     *
     */

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(true);
        try {
            lock.lock();
        }finally {
            lock.unlock();
        }

    }
}
