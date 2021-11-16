package org.olddriver.learnos;

/**
 * 20211112
 * 进程
 * 第二部分
 */
public class Process {
    /**
     * 进程
     * 在多道批处理系统中，内存中允许同时存在多个程序和相关数据，为了对内存中多个程序进行区分引入进程概念
     * 进程是一个正在运行的程序。每个进程对应一个数据结构，称为pcb(process control block)；
     * 程序段，数据段，pcb组成进程实体
     *
     * pcb组成
     * i.进程描述信息 pid进程标识符(进程创建时产生)
     * ii.进程控制和管理信息
     * iii.资源清单
     * iiii.cpu相关信息，各种寄存器的值
     *
     * 进程状态
     * RUNNING  运行态，正在占用cpu资源，正在运行
     * READY    就绪态，已具备运行条件，正在等待cpu资源
     * BLOCKED  阻塞态，因等待某一事件的发生暂时不能运行
     * NEW      新建态 进程正在被os创建
     * TERMINATED   终结态 进程正在被os撤销
     *
     * 进程通信
     * 一个进程无法直接访问其他进程的内存空间，需通过共享存储，管道通信，消息传递等方式完成进程通信
     * i.共享存储
     * 进程通过共享数据结构或共享存储空间进行交互
     * ii.管道通信
     * 管道为一个大小固定的缓冲区
     * 一个进程向管道中写入，另一个进程从管道中读取
     * 管道只能实现半双工通信，在任意时刻只能单向通信。通过两个管道可实现双向通信
     * iii.消息传递
     * 进程之间交换格式化信息进行通信，分为直接通信和间接通信
     * 直接通信方式，发送进程直接将消息加入接收进程的消息缓冲队列中
     *
     * 线程
     * 一种抽象模型，提高程序的并发程度
     * 引入线程模型之前，程序只能串行执行，无法并发实现多个功能。
     * 引入线程模型之后，程序可以并发实现多个功能
     * 每个线程拥有一个线程id和线程控制块(tcb)
     *
     * 线程实现
     * 用户级线程(user-level thread)
     * 应用程序通过线程库实现，应用程序自行管理线程切换。os无法感知用户级线程存在
     * 内核级线程(kernal-level thread)
     * 内核级线程由os管理
     *
     * 多线程模型
     * 多对一模型
     * 多个用户级线程对应一个内核级线程
     * 一对一模型
     * 一个用户级线程对应一个内核级线程
     * 多对多模型
     * n个用户级线程对应m个内核级线程
     */
}
