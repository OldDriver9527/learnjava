package org.olddriver.learnjava.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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


        int num = 0;
        char character = 'a';
        for(int i = 0 ; i < 26 ; i ++){
            int temp = i;
            CompletableFuture cf1 =  CompletableFuture.runAsync(() -> {
                System.out.println(num + temp);
            },executorService).thenRunAsync(()->{
                System.out.println((char)(character + temp));
            },executorService);

            CompletableFuture.allOf(cf1).join();
        }

        executorService.shutdown();
    }
}
