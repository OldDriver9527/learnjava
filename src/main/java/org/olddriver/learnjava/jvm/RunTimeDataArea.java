package org.olddriver.learnjava.jvm;

/**
 * jvm数据区划分
 * 20200428
 * 第四部分
 */
public class RunTimeDataArea {
	/**
	 * java虚拟机内存划分
	 * program counter
	 * 每个线程都占用程序计数器的一块空间，存放线程执行的指令位置。线程之间互不影响
     *
	 * jvm stack
     * 每个线程都占用jvm stack的一块空间，存放栈帧，每个线程互不影响
     * 栈帧对应方法，栈帧中存储局部变量表，操作数栈，动态连接，返回值地址
	 * 方法返回值会加入操作数栈
     *
     * native method stack
     * 每个线程占用本地方法栈的一块空间，作用与jvm stack相同。线程执行本地方法时使用
     *
	 * heap
	 * 线程共享堆空间
	 *
	 * method area
     * 存储字节码文件中的字节流。
     * jdk1.8版本前，方法区通过perm space(永久代，位于heap中)实现，需在启动时指定
     * jdk1.8之后，方法区通过meta space(元数据区，存在于本地内存Native memory)实现，
     * 运行时常量池(runtime constant pool)位于方法区中，存储字节码文件中常量池表
	 * jdk1.8之前方法区不会被垃圾回收
     * 字符串常量池不是运行时常量池，jdk1.8之后字符串常量池位于堆中
	 *
     * direct memory
     * jdk1.4后增加直接内存，与nio相关
	 * 并不属于运行时数据区的一部分
	 */
}
