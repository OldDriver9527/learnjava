package org.olddriver.learnjava.concurrency;

import java.util.concurrent.CompletableFuture;

public class YieldThread {
    public static void main(String[] args) {

        CompletableFuture.runAsync(()->System.out.println("hello hello"));
        Thread.yield();
    }
}
