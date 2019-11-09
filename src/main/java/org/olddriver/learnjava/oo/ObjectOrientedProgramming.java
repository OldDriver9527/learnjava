package org.olddriver.learnjava.oo;

import java.util.Arrays;
import java.util.Base64;

public class ObjectOrientedProgramming{
	/*
	 * 对象 Object
	 * 软件对象和现实中对象对应，对象可理解为是一种奇特变量，由属性和行为构成
	 * 
	 * 类 	Class
	 * 类是对具有相同属性和行为的对象的抽象，类是创建对象的蓝图；
	 * 类包含成员变量，成员方法，构造器，内部类，内部接口，构造块，静态块，？？？
	 * 类是java程序的基本单元
	 * 
	 * 接口	Interface
	 * 接口定义类与外界交互的规则，接口中可以包含常量，抽象方法，默认方法，static方法，内部类，内部接口
	 * 
	 * 面向对象思想
	 * 将现实中对象抽象为类，在java程序中使用类的实例解决问题
	 * 
	 * 面向对象程序特点
	 * java程序是对象的集合
	 * 
	 * 封装	Encapsulation
	 * i.将成员变量，成员方法包裹在类中，隐藏成员变量，仅对外暴露公共成员方法
	 * ii.封装实现方式
	 * 将成员变量使用private修饰
	 * 提供公共get，set方法获取和修改成员变量值
	 * iii.封装好处
	 * 类的使用者无法触及类中隐藏的部分
	 * 类的开发者对类中隐藏部分进行修改不会影响类的使用者
	 * 
	 * 继承	Inheritance
	 * 在现有类的基础上派生出新类称为继承，是复用代码的一种方式
	 * 派生类称为子类，派生子类的类称为父类
	 * 子类会继承父类部分成员变量，成员方法，内部类？？？
	 * 子类继承父类，子类必定会继承父类public，protected成员；当子父类位于同一个包中，子类会继承父类中包访问权限的成员；
	 * 子类不会继承父类中private成员
	 * i.类层次结构
	 * Object类是所有类的父类，定义类的通用行为；创建类时若不显式指明父类，默认继承Object类
	 * java中类支持单继承，不支持多继承，避免多个父类中成员变量冲突
	 * ii.子类中的操作
	 * 1.子类中能够直接调用继承自父类的成员变量
	 * 2.子类中能够再次定义父类中的成员变量，将父类中的成员变量隐藏，不推荐
	 * 子类中名称相同的成员变量即可隐藏父类成员变量，类型不必相同
	 * 3.子类中能够定义父类中不存在的成员变量
	 * 4.子类中能够直接调用继承自父类的成员方法
	 * 5.子类中能够再次定义父类中非static，非final成员方法，将父类方法覆盖
	 * 子类方法若想覆盖父类中方法，
	 * 子类方法方法签名要与父类方法保持一致，子类方法返回值类型可以是父类方法返回值类型的子类；
	 * 子类方法访问权限要大于等于父类方法访问权限；
	 * 子类方法的异常列表必须是父类方法异常列表的子类或子集；
	 * 子类方法上可以添加@Override注解,告知编译器
	 * 6.子类中能够再次定义父类中的static成员方法，将父类方法隐藏
	 * 子类方法若想隐藏父类中方法，子类方法方法签名及返回值类型要与父类方法一致
	 * 7.在子类中定义父类中不存在的成员方法
	 * iii.对象转型
	 * 子类对象由子类类型转型为父类类型，称为向上转型
	 * 子类对象由父类类型转型为子类类型，称为向下转型
	 * 向下转型前可以使用instanceof操作符进行判断，避免运行时异常
	 * 
	 * 多态	Polymorphism
	 * 多态指子类中既能定义特有内容，又能分享父类中共有内容
	 * i.多态体现
	 * 将子类对象地址赋值给父类或接口类型引用
	 * ii.成员方法动态绑定
	 * 子类对象向上转型后，通过子类对象，调用父类中非static，非final，非private方法。编译器在编译时期不会判断对象
	 * 实际类型，仅会根据引用变量类型检查方法参数及返回值类型；在运行时，编译器会判断对象实际类型建立方法调用与
	 * 真正方法体的关联
	 * iii.成员方法静态绑定
	 * 子类对象向上转型后，通过子类对象，调用父类中static，private，final成员方法，编译器在编译时期根据引用变量类型
	 * 建立方法调用与方法体之间的关联
	 */
}
