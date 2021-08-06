package org.olddriver.learnjava.concurrency;

import java.util.ArrayList;
import java.util.concurrent.*;

public class CompletableFutures {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletableFuture<String> completableFuture = null;
        /*completableFuture = CompletableFuture.supplyAsync(()->{
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName()+"---"+thread.getState()+"---"+thread.isDaemon());
            return "hello completableFuture";
        }).thenCompose((str)-> {
            return CompletableFuture.supplyAsync(()->{
                Thread thread = Thread.currentThread();
                System.out.println(thread.getName()+"---"+thread.getState()+"---"+thread.isDaemon());
                String s = str + " and thenCompose";
                return s;
            });
        });
        System.out.println(completableFuture.get());*/

        /*completableFuture = CompletableFuture.supplyAsync(()->{
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName()+"---"+thread.getState()+"---"+thread.isDaemon());
            return "hello step1";
        }).thenCombine(CompletableFuture.supplyAsync(()->{
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName()+"---"+thread.getState()+"---"+thread.isDaemon());
            return "hello step2";
        }),(str1,str2)->{
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName()+"---"+thread.getState()+"---"+thread.isDaemon());
            return str1 +" "+ str2;
        });
        System.out.println(completableFuture.get());*/


        /*completableFuture = CompletableFuture.supplyAsync(()->{
            Thread thread = Thread.currentThread();
            System.out.println(System.currentTimeMillis()+"---"+thread.getName()+"---"+thread.getState()+"---"+thread.isDaemon());

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello step1";
        }).thenApplyAsync((str)->{
            Thread thread = Thread.currentThread();
            System.out.println(System.currentTimeMillis()+"---"+thread.getName()+"---"+thread.getState()+"---"+thread.isDaemon());
            return str + " hello step2";
        });
        System.out.println(completableFuture.get());*/

        /*completableFuture = CompletableFuture.supplyAsync(()->{
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName()+"---"+thread.getState()+"---"+thread.isDaemon());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello step1";
        }).applyToEither(CompletableFuture.supplyAsync(()->{
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName()+"---"+thread.getState()+"---"+thread.isDaemon());
            if(false){
                throw new RuntimeException();
            }
            return "hello step2";
        }),(str)->{
            return str.toUpperCase();
        }).exceptionally((e)->{
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName()+"---"+thread.getState()+"---"+thread.isDaemon());
            e.printStackTrace();
            return "exception";
        });
        System.out.println(completableFuture.get());*/

        /*CompletableFuture.supplyAsync(()->{
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName()+"---"+thread.getState()+"---"+thread.isDaemon());
            return "hello step1";
        }).thenAccept((str)->{
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName()+"---"+thread.getState()+"---"+thread.isDaemon()+"---"+str);
        });*/

        /*CompletableFuture.supplyAsync(()->{
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName()+"---"+thread.getState()+"---"+thread.isDaemon());
            return "hello step1";
        }).thenRun(()->{
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName()+"---"+thread.getState()+"---"+thread.isDaemon());
        });*/

        ArrayList<CompletableFuture<String>> list = new ArrayList<>();
        long start = System.nanoTime();
        for(int i = 0 ; i < 30 ; i++){
            CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {

                Thread thread = Thread.currentThread();
                System.out.println(thread.getName()+"---"+thread.getState()+"---"+thread.isDaemon());

                return "hello";
            });
            list.add(cf);
        }

        for(int i = 0 ; i < list.size() ;i++){
            CompletableFuture<String> stringCompletableFuture = list.get(i);
            stringCompletableFuture.get();
        }
        long end = System.nanoTime();
        System.out.println(end-start);


        executorService.shutdown();
    }
}
