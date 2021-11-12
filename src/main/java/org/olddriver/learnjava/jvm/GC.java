package org.olddriver.learnjava.jvm;

/**
 * gc
 * 20210808
 * 第六部分
 */
public class GC {
    /**
     * 垃圾
     * 没有引用指向的对象属于垃圾(特例为循环引用)
     *
     * 垃圾搜集算法
     * 引用计数 Reference Count
     * 对象中包含引用计数器，记录指向当前对象的指针个数，对象自行维护引用计数器。当引用计数器为0，认为无引用指向对象，对象可以被
     * 视为垃圾。引用计数算法简单但无法找出循环依赖的垃圾
     * 根可达算法 Root Searching
     * 从一系列根对象向下查找引用的对象，直到叶子对象为止，未被查到的对象就属于垃圾
     *
     * gc算法(垃圾回收算法，均是对根可达算法的拓展)
     * i.标记清除 mark-sweep
     * 利用根可达算法标记出存活对象，垃圾。之后再遍历所有对象，将垃圾占用内存回收
     * 进行两次遍历，垃圾回收后内存不再连续，存在碎片
     * ii.拷贝   copying
     * 将内存划分为两块，活动区间，空闲区间。利用根可达算法找到活动区间中存活的对象，将存活对象复制到空闲区间，之后修改引用地址。
     * 对象查找完毕，释放所有活动区间空间
     * 浪费一半内存，但只需遍历依次，内存连续不存在碎片
     * iii.标记压缩 mark-compact
     * 利用根可达算法标记存活对象，垃圾。遍历所有对象，将存活对象移动到内存首端连续排列，之后回收所有尾端空间
     * 进行两次遍历，垃圾回收后内存连续，不产生碎片
     * iiii.分代搜集算法
     * 为对象引入年龄概念，存储在对象头中(4 bit)。针对不同年龄对象使用不同gc算法。
     * 对新生代(young generation)对象使用拷贝算法，对老年代(old generation)对象使用标记清除或标记压缩算法
     * hotspot使用分代收集算法
     *
     * heap分代模型
     * 使用分代收集算法虚拟机会对heap分代，包括新生代，老年代
     * 新生代分为伊甸区eden，两个幸存区s0，s1，按8:1:1分配
     * ygc  针对新生代进行垃圾回收，使用拷贝算法，将eden和一个幸存区作为活动区间，另一个幸存区作为空闲区间
     * fullgc   针对老年代，新生代，方法区进行垃圾回收
     *
     * 对象内存分配
     * i.尝试栈上分配
     * ii.尝试直接进入老年代，大对象直接进入老年代
     * iii.尝试线程本地分配，每个线程占用eden一块空间，防止并发申请相同空间
     * iiii.分配到eden
     *
     * 分配担保
     *
     * 常见垃圾回收器
     * i.serial
     * 单线程回收新生代的垃圾回收器，清理时所有工作线程停止，即stw(stop the world)。较少使用
     * ii.serial old
     * 单线程回收老年代的垃圾回收器，清理时所有工作线程停止。较少使用
     * iii.parallel scavenge ps
     * 多线程回收新生代的垃圾回收器，清理时所有工作线程停止。默认使用
     * iiii.parallel old po
     * 多线程回收老年代的垃圾回收器，清理时所有工作线程停止。默认使用
     * iiiii.parnew
     * 回收新生代的垃圾回收器。对ps在某方面进行增强，配合cms使用
     * iiiiii.concurrent mark sweep cms
     * 回收老年代的垃圾回收器
     * iiiiiii.g1
     * 不使用分代收集算法
     *
     * 垃圾回收器组合参数
     * -XX:+UseSerialGC 使用serial和serial old
     * -XX:+UseParNewGC 使用parnew和serial old
     * -XX:+UseConc[urrent]MarkSweepGC  使用parnew和cms和serial old
     * -XX:+UseParallelGC   使用ps和po
     * -XX:+UseG1GC 使用g1
     */
}
