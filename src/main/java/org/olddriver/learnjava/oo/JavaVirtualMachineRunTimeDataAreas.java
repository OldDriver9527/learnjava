package org.olddriver.learnjava.oo;

public class JavaVirtualMachineRunTimeDataAreas {
	/**
	 * java虚拟机运行时数据区划分为6部分
	 * i.pc寄存器 pc(program counter) Register 
	 * ii.栈 Stack 
	 * java虚拟机线程私有，随着虚拟机线程的创建而创建，随着虚拟机线程的销毁而销毁
	 * iii.堆 Heap 
	 * java虚拟机线程共享，随着虚拟机的启动而创建，随着虚拟机的停止而消失
	 * 堆中包含方法区
	 * 堆中存储对象
	 * iiii.方法区 Method Area
	 * java虚拟机线程共享，随着虚拟机的启动而创建，随着虚拟机的停止而消失
	 * 方法区中存储类中常量池，成员变量数据，方法，构造器代码
	 * iiiii.常量池
	 * 常量池包含在方法区中
	 * iiiiii.本地方法栈
	 */
}
