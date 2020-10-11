package org.olddriver.learnjava.concurrency;

/**
 * 20200907
 * part 1
 */
public class Threads {
    /*
     * 进程和线程(Processes and Threads)
     * 进程
     * 操作系统分配系统资源的最小单位。每个进程都有独立运行环境和资源，
     * 一个运行的应用程序中至少包含一个进程，一个进程中至少包含一个线程。大多数JVM都是单进程
     * 线程
     * 操作系统调度的最小单位。线程位于进程当中。线程共享进程资源
     * 进程间切换及进程间通信的开销大于线程间切换及线程间通信的开销，引入线程提高计算机并发性能
     *
     * 使用线程策略
     * i.直接控制线程创建和管理
     * ii.间接控制线程
     *
     * 创建并开启线程
     * i.使用Runnable接口中run方法封装线程执行的代码，将Runnable对象传递给Thread类构造器创建Thread对象
     * ii.继承Thread类，重写run方法，之后创建子类对象
     * 通过线程对象start方法启动线程
     *
     * java线程状态
     * NEW  新建
     * 线程对象刚刚创建完毕，还未调用start方法启动的线程的状态
     * RUNNABLE 可运行
     * 线程启动后，正在占用CPU资源或正在等待CPU资源的线程的状态
     * BLOCKED 阻塞
     * 执行同步方法，还未获取到锁的线程的状态
     * WAITING 等待
     * 执行不具有等待时间方法的线程的状态，方法包括
     * wait()
     * Thread.join()
     * LockSupport.park
     * 等待状态的线程需依靠其他线程的通知才能恢复可运行状态
     * TIMED_WAITING 定时等待
     * 执行带有指定正等待时间方法的线程的状态，方法包括
     * 具有等待时间的Thread.sleep()
     * 具有等待时间的Thread.join()
     * 具有等待时间的wait()
     * LockSupport.parkNanos
     * LockSupport.parkUntil
     * 定时等待状态的线程当时间超过定时时间后恢复可运行状态
     * TERMINATED 终止
     * 执行完run()的线程的状态
     *
     * 后台(Daemon)线程
     * 当JVM进程中只包含后台进程，JVM进程会自动结束
     * 后台线程执行的run()中finally块不保证一定执行
     *
     * 暂停执行
     * 通过Thread类中sleep方法可以让当前线程暂停执行指定时间
     * TimeUnit枚举可选择暂停时间的单位
     *
     * 中断
     * 线程支持中断的方式
     * i.当线程执行run方法中调用抛出InterruptedException方法，可在catch子句中返回，进行中断
     * ii.当线程执行run方法中未调用抛出InterruptedException方法。
     * 可使用Thread.interrupted()作为循环条件，用于判断线程是否已经中断；当返回true后，会清除线程中断状态
     * 中断状态
     * Thread类中interrupt方法，通过一个线程为另一个线程设置中断状态
     * Thread.interrupted()用于判断当前线程是否已经中断，返回true后会清除中断状态
     * Thread类中isInterrupted方法，用于一个线程判断另一个线程中断状态，不会清除线程中断状态
     *
     * Joins
     * Thread类中join方法，用于将当前线程暂停执行，直至指定线程执行完毕
     *
     * Yield
     * Thread类中yield方法，用于使当前线程释放cpu资源，重新竞争cpu资源
     *
     * 线程间通信
     * 同步Synchronization
     * 线程访问共享字段及共享对象可能会导致线程干扰(thread interference)和内存一致性错误(memory consistency errors)
     * 同步可以阻止这两种错误
     * 线程干扰
     * 当两线程操作同一数据，但每个线程执行不同操作，并且一个操作又可以被分解为多个步骤组成，不同操作的步骤间出现交叠
     * 内存一致性错误
     * 不同线程对同一数据具有不同可见性，避免内存一致性错误可以建立happens-before关系
     * happens-before
     * happens-before关系用于指定两个操作的执行顺序，并不保证一个操作在另一个操作之前执行，仅保证一个操作的结果对另一个操作可见
     * 具体规则包括
     * i.单线程规则  一个线程的每个语句都happens-before于该线程的后续语句
     * ii.监视器锁规则    解锁happens-before于后续加锁
     * iii.volatile变量规则 对volatile字段写操作happens-before于后续对该字段的所有读操作
     * iiii.传递性 A happens-before B, B happens-before C, A happens-before C
     * iiiii.线程启动规则 线程A执行线程B的start方法happens-before于线程B的所有操作，在线程B中对线程A的start语句及之前的所有语句都具有可见性
     * iiiiii.线程join规则  线程A执行线程B的join方法，线程B的所有操作happens-before于线程A的join返回及后续操作
     *
     *
     * 同步习惯用法
     * i.同步方法   在方法声明中添加synchronized关键字
     * 同步方法保证一个线程执行同步方法时，其他要执行同一对象同步方法的线程会阻塞
     * 同步方法的一次执行 happens-before 于同一对象该方法的后续调用
     * 构造器不能使用synchronized修饰
     */
}
