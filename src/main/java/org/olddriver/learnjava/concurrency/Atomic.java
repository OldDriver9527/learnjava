package org.olddriver.learnjava.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 20210810
 * 原子类
 * 第四部分
 */
public class Atomic {
    /**
     * 源自类
     * AtomicLong
     * 使用cas操作修改数据，当修改失败会不断尝试修改，直到修改成功为止。效率高于重量级锁
     * LongAdder
     * 在并发量巨大的情况下，效率高于AtomicLong
     * LongAdder将对一个值的cas操作分解为对多个值的cas操作，最终将多个值求和
     */

    static AtomicInteger integer = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(()->{
            for(int i = 0 ; i < 100000 ; i++){
                integer.incrementAndGet();
            }
        }).runAfterBoth(CompletableFuture.runAsync(()->{
            for(int i = 0 ; i < 100000 ; i++){
                integer.incrementAndGet();
            }
        }),()->{
            System.out.println(integer.get());
        });

        TimeUnit.SECONDS.sleep(1);
    }
}
