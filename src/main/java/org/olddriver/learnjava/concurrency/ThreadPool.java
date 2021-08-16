package org.olddriver.learnjava.concurrency;

/**
 * 20210814
 * ThreadPool
 * 第十部分
 */
public class ThreadPool {
    /**
     * Executor
     * 任务执行器，将线程任务的定义与执行分离
     *
     * ExecutorService
     * 继承Executor，增加管理线程池生命周期的方法。线程池基于ExecutorService实现
     *
     * ThreadPoolExecutor线程池
     * 构造器参数
     * corePoolSize 核心线程数
     * maximumPoolSize  最大线程数
     * keepAliveTime    空闲时间
     * unit 空闲时间单位
     * workQueue    任务队列
     * threadFactory    线程工厂，规定常见线程方式
     * 线程名需具备含义  From UserThreadFactory work-x
     * handler  拒绝策略
     * 默认拒绝策略，简单情况下使用
     * Abort    抛出异常
     * Discard  丢弃任务
     * DiscardOldest    丢弃队列中排队时间最长任务
     * CallerRuns   提交任务者执行任务
     * 自定义拒绝策略，使用redis，kafka存储任务
     *
     * 现有线程池
     * SingleThreadExecutor 单线程线程池
     * CachedThreadPool 使用SynchronousQueue作为任务队列，提交任务时如果没有空闲线程就创建新线程
     * FixedThreadPool  固定线程池
     * ScheduledThreadPool  使用DelayWorkQueue作为任务队列，延迟执行任务
     * 现有线程池弊端
     * FixedThreadPool，SingleThreadExecutor 任务队列长度为Integer最大值，可能导致任务堆积
     * CachedThreadPool 允许创建Integer最大值个线程
     *
     * ThreadPoolExecutor字段
     * ctl  control，表示线程池状态和线程个数。高3位bit表示线程池状态，低29位bit表示线程个数
     * RUNNING  正常运行状态
     * SHUTDOWN 调用shutdown方法，进入该状态
     * STOP 调用shutdownNow方法，进入该状态
     * TIDYING  整理状态
     * TERMINATED   终止状态
     *
     * 任务执行过程
     * 当线程池中线程数小于核心线程数，会创建核心新线程执行任务。
     * 当线程数达到核心线程数，且无空闲线程会将任务加入队列，
     * 当线程数达到核心线程数，且队列已满，创建非核心线程
     *
     * ForkJoinPool
     * 将任务划分为若干小任务，小任务执行后再进行汇总
     * ForkJoinPool执行的任务类型为RecursiveAction
     * WorkStealingPool
     * 一种ForkJoinPool。每个线程具有一个任务队列，当某个线程任务队列为空，会从其他线程的队列中获取任务
     */
}
