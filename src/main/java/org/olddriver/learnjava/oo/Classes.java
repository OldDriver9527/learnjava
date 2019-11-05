package org.olddriver.learnjava.oo;

public class Classes {
	/*
	 * 声明类
	 * 声明类会定义一个新引用类型， 声明类分为普通类声明，枚举声明
	 * i.类声明格式
	 * modifier class ClassName{
	 * 		constructor,field,method
	 * }
	 * 类仅有两种访问权限，public及package
	 * 
	 * 成员变量与局部变量区别
	 * i.成员变量随对象的创建而创建，随对象的销毁而销毁
	 * 	 局部变量随所属区域的执行而创建，随所属区域的结束而消失
	 * ii.成员变量存储在堆内存中，局部变量存储在栈内存中
	 * iii.成员变量存在默认初始化值，局部变量不存在默认初始化值
	 * iiii.成员变量定义在类中，局部变量定义在方法中
	 * 
	 * 构造器	Constructor
	 * 类中特殊方法，专门用于为对象进行初始化，在创建对象时被调用执行
	 * 构造器特点
	 * i.构造器名称与类名一致
	 * ii.构造器不需定义返回值类型
	 * 默认构造器
	 * 当类中没有显式定义构造器，编译器会自动为类提供一个无参构造器作为默认构造器
	 * 当类中显式定义过构造器，编译器不会向类中添加默认构造器
	 * 默认构造器中默认调用父类默认构造器
	 * 构造器与成员方法对比
	 * 构造器在创建对象时被调用执行，创建一个对象执行一次
	 * 成员方法在对象创建完毕被调用执行，调用几次执行几次
	 * 构造器重载
	 * 类中允许存在多个同名构造器，只要其参数列表不同即可，参数列表不同指参数个数不同，参数类型不同，参数顺序不同
	 * 构造器说明
	 * i.构造器与赋值作用的set方法不冲突
	 * 构造器用于为对象进行初始化
	 * set方法在对象创建完毕，为成员变量赋值
	 * ii.构造器中能够调用成员方法，成员方法中不能直接调用构造器
	 * iii.构造器不需定义返回值类型，无返回值，但存在return语句
	 * iiii.当为构造器定义返回值类型，该方法就转变为成员方法
	 * 
	 * 为成员方法或构造器传值
	 * i.方法或构造器参数类型可以是基本数据类型，引用数据类型
	 * ii.当形参类型为基本数据类型，形式参数的修改不会影响到实际参数
	 * iii.当形参类型为引用数据类型，形式参数的修改影响实参
	 * iiii.对于boolean以外的七种基本数据类型值，当实参数据类型等级低于形参数据类型等级时，实参会进行自动类型提升
	 * 
	 * 可变参数
	 * 当无法确定方法参数列表中某种类型参数个数时可以使用可变参数
	 * 可变参数在参数类型后添加省略号，是数组参数的简写
	 * 可变参数必须是参数列表中最后一个参数
	 * 
	 * Lambda表达式  Lambda Expression
	 * lambda表达式用于创建匿名方法，是创建函数式接口子类对象的简写形式；匿名方法能够作为方法参数传递
	 * （函数式接口指仅包含一个抽象方法的接口）
	 * i.语法格式
	 * (argument list) -> {statement} 或 (argument list) -> expression
	 * 参数列表为形式参数列表，其中参数类型可省略
	 * 参数列表中仅包含一个参数小括号可省略
	 * ii.lambda表达式中使用局部变量，局部变量要使用final修饰
	 * iii.lambda表达式类型由编译器推断，lambda表达式上下文期望的类型称为目标类型
	 * 只有在目标类型明确的情况下才能使用lambda表达式，如引用类型变量声明，赋值，return语句，方法及构造器实参，，，
	 */
}
