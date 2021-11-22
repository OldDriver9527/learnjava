package org.olddriver.learnjava.concurrency;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * 创建线程任务，通过线程池使用线程
 * 实例2
 */
public class ThreadTask {

    @Test
    public void testThreadPool(){
        Callable<String> callable = ()->{
            System.out.println(Thread.currentThread().getName()+" state is "+Thread.currentThread().getState());
            return "hello";
        };

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> submit = executorService.submit(callable);

        try {
            System.out.println(submit.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRunnable(){
        Runnable runnable = ()->{
            System.out.println(Thread.currentThread().getName()+" state is "+Thread.currentThread().getState());
        };

        CompletableFuture.runAsync(runnable);
    }

    @Test
    public void testCallable(){
        Callable<String> callable = ()->{
            if(true){
                throw new RuntimeException("good");
            }
            return "hello";
        };

        FutureTask<String> task = new FutureTask<>(callable);

        Thread thread = new Thread(task);
        thread.start();
    }
}
