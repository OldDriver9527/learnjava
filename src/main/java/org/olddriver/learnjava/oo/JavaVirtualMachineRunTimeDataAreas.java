package org.olddriver.learnjava.oo;

/**
 * 20200428
 * part 5
 */
public class JavaVirtualMachineRunTimeDataAreas {
	/*
	 * java虚拟机运行时数据区划分为6部分
	 * i.pc寄存器 pc(program counter) Register 
	 * ii.虚拟机栈 Stack
	 * java虚拟机线程私有，随着虚拟机线程的创建而创建，随着虚拟机线程的销毁而销毁
	 * iii.堆 Heap 
	 * java虚拟机线程共享，随着虚拟机的启动而创建，随着虚拟机的停止而消失
	 * 堆中包含方法区
	 * 堆中存储对象
	 * iiii.方法区 Method Area
	 * java虚拟机线程共享，随着虚拟机的启动而创建，随着虚拟机的停止而消失
	 * 方法区中存储每个类或接口结构信息，如字段，方法，构造器，运行时常量池字节码内容
	 * iiiii.运行时常量池
	 * 运行时常量池是字节码文件中每个类或接口常量池表的运行时表示形式，每个类或接口都对应一个运行时常量池，
	 * 包括各种类型常量，如编译时已知的字面常量以及运行时才能获取的方法或字段的引用
	 * 运行时常量池包含在方法区中
	 * iiiiii.本地方法栈
	 */

}
