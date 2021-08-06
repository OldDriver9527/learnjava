package org.olddriver.learnjava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建线程任务，通过线程池使用线程
 * 实例2
 */
public class ThreadTask {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            System.out.println("2222222");
        };

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(runnable);
    }
}
