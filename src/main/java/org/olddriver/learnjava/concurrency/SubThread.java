package org.olddriver.learnjava.concurrency;

/**
 * 创建线程匿名子类对象使用线程
 * 实例1
 */
public class SubThread extends Thread{
    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"----"+thread.getState()+"----"+thread.isDaemon());
    }

    public static void main(String[] args) {
        new SubThread().start();
    }
}
