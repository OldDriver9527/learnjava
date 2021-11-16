package org.olddriver.learnjava.concurrency;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;

public class YieldThread {

    @Test
    public void test() {
        CompletableFuture.runAsync(()->System.out.println("hello hello"));
        Thread.yield();
    }
}
