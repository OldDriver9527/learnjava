package org.olddriver.learncpu;

public class Cpu {

    /**
     * cpu组成
     * pc 程序计数器
     * 存储当前指令在内存中地址
     * register 寄存器
     * 存储cpu计算时所需数据
     * alu 运算单元
     * cu 控制单元
     * mmu 内存管理单元
     * cache 缓存
     * 存储cpu计算所需数据，减少cpu访问内存次数
     *
     * cpu三级缓存
     * cpu缓存分为三级
     * 多核cpu中，每核拥有独立的一级缓存，二级缓存，多核共享第三级缓存
     * 读写缓存时以缓存行为单位，intel cpu 缓存行为64byte。
     * 缓存一致性
     * 不同cpu拥有独立一级缓存，二级缓存。不同cpu使用到同一级缓存中同一缓存行，需保证缓存一致。
     * 通过缓存一致性协议实现(intel cpu缓存一致性协议称为mesi)
     * 伪共享 false sharing
     * 多个线程操作独立变量，若变量位于同一缓存行，会相互影响，称为伪共享
     * 缓存行对齐
     * 通过缓存行对齐方式可以解决伪共享。使数据独占一个缓存行，线程读写不同缓存行，不需保证不同cpu中缓存行一致
     * jdk8中使用@Contented保证数据独占一个缓存行，需指定-XX:-RestrictContended参数
     *
     * cpu内存屏障
     * 为保证cpu有序执行某些指令，使用内存屏障
     * sfence   在sfence前写操作必须在sfence后的写操作之前完成
     * lfence   在lfence前读操作必须在lfence后的读操作之前完成
     * mfence   在mfence前读写操作必须在lfence后的读写操作之前完成
     *
     */
}
