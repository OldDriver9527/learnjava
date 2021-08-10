package org.olddriver.learnjava.concurrency;

/**
 * 20200907
 * future模式
 * 第二部分
 */
public class FuturePattern {
    /**
     * future模式
     * 一种多线程设计模式，可以将算法中比较耗时的步骤异步执行，先获取虚拟结果，之后通过虚拟结果获取实际结果。
     * 缩短总体执行时间
     * jdk中future模式实现
     * Future   未来虚拟结果
     * RunnableFuture   既是线程任务也是虚拟结果
     * FutureTask   RunnableFuture实现类，其中封装Runnable或Callable任务。Callable相比于Runnable具有返回值，可以抛异常，更易操作
     * CompletableFuture    Future，CompletionStage实现类，jdk1.8中推出，
     *                      通过函数式编程方式构建异步执行的阶段，一个阶段完成触发下一阶段执行。
     *                      具有Async后缀的方法创建的阶段交给线程池执行，不具有Async后缀的方法创建的阶段由线程池执行或当前线程执行
     *                      阶段返回值就是函数式接口的返回值。
     *                      supplyAsync 构建异步执行阶段
     *                      thenCompose 将前一个阶段结果作为后一个阶段输入进行处理，下一个阶段中再委托其他阶段进行处理。
     *                                  Function接口返回值必须是CompletableFuture，通过CompletableFuture获取处理结果。
     *                                  涉及三个阶段
     *
     *                      thenCombine 将两个阶段的结果进行合并处理，处理结果通过CompletableFuture获取。
     *                                  两个阶段不具有先后顺序，可以并发执行
     *                      thenAcceptBoth  将两个阶段的结果进行合并处理，不再产生结果
     *                      runAfterBoth    在两个阶段执行结束后执行，不再产生结果
     *
     *                      thenApply   将前一个阶段的结果作为下一个阶段的输入再次进行处理，Function接口返回值无具体要求
     *                                  两个阶段具有先后顺序
     *                      thenAccept  将前一个阶段的结果作为后一个阶段输入，不再产生结果
     *                      thenRun     前一个阶段结束后执行后一个阶段，不产生结果
     *
     *                      applyToEither   对两个阶段中任意一个的结果进行处理，对先结束的阶段结果进行处理
     *                      acceptEither    对两个阶段中任意一个的结果进行处理，不再产生结果
     *                      runAfterEither  在两个阶段中任意一个阶段完成后执行，不再产生结果
     *
     *                      exceptionally   对前一个阶段的异常进行处理
     *                      handle          对前一个阶段的结果进行处理，产生结果
     *                      whenComplete    对前一个阶段的结果进行处理，不再产生结果
     */
}
