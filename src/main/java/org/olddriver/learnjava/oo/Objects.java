package org.olddriver.learnjava.oo;

public class Objects {
	/**
	 * 创建对象
	 * Type referenceName = new Constructor;
	 * 创建对象可分为三部分，声明对象引用，对象实例化，对象初始化
	 * i.声明对象引用
	 * Type referenceName;
	 * 声明对象引用并不会创建对象
	 * ii.实例化对象
	 * 通过new操作符为对象分配内存空间，并返回对象的地址
	 * new操作符后需要调用构造器
	 * iii.初始化对象
	 * 通过构造器初始化对象
	 *
	 * 创建指定类对象在内存中的过程
	 * i.在方法区寻找是否存在指定类字节码数据。若不存在，加载指定类字节码文件
	 * 加载字节码文件后，会在堆内存中创建类的Class对象，对类中类中静态变量进行声明，默认初始化，显式初始化
	 * 若指定类存在父类，优先加载父类字节码文件
	 * ii.通过new创建对象，为对象分配内存空间，完成成员变量声明；对象所占存储空间在加载完字节码文件后就会确定；
	 * 之后将存储空间归零，完成默认初始化
	 * iii.执行子类构造器中super语句，进行父类初始化。先执行父类成员变量初始化，之后执行父类构造器内容
	 * iiii.执行子类成员变量初始化，然后执行子类构造器内容
	 */
}
