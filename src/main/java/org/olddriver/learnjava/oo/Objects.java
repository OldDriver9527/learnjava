package org.olddriver.learnjava.oo;

/**
 * 20200428
 * part 4
 */
public class Objects{
	/*
	 * 类的实例和数组都是对象
	 * 通过类实例创建表达式(class instance creation expression)显式创建类实例
	 * 通过数组创建表达式(array creation expression)显式创建数组
	 *
	 * 创建对象过程
	 * 加载类和接口
	 * 类加载器根据指定名称查找类，父类，父接口字节码文件，在方法区中分配空间存储类和接口相关字节码内容
	 * 链接类和接口
	 * 链接涉及三种行为：校验，准备，解析
	 * 校验阶段检查类和接口字节码文件结构正确性
	 * 准备阶段创建类，父类，父接口中static字段，并使用默认值对其进行初始化
	 * 解析阶段解析类和接口中其他类和接口的引用，确定具体地址值
	 * 初始化类
	 * 执行类中静态初始化器，类变量初始化器
	 * 子类初始化前，必须对其父类进行初始化，父接口不在此时初始化
	 * 创建类实例
	 * 在堆内存中分配空间，创建类及父类中所有实例变量，并用默认值对其进行初始化，
	 * 执行父类及类的实例初始化器，实例变量初始化器，构造器对对象进行初始化
	 * 先执行父类中内容，再执行类中内容
	 */
}
