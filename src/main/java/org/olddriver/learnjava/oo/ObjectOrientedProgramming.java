package org.olddriver.learnjava.oo;

import org.olddriver.learnjava.oo.ObjectOrientedProgramming.Bicycle.Inner;

public class ObjectOrientedProgramming {
	/*
	 * 对象 Object
	 * 软件对象和现实中对象对应，对象是一种奇特变量，由属性和行为构成，类成员变量存储对象属性，方法暴露对象行为
	 * 
	 * 类 	Class
	 * 类是对具有相同属性和行为的对象的抽象，类是创建对象的蓝图
	 * 类是java程序的基本单元
	 * 
	 * 面向对象思想
	 * 将现实中对象抽象为类，在java程序中使用类的实例解决问题
	 * 
	 * 面向对象程序特点
	 * java程序是对象的集合
	 * 
	 * 面向对象特征
	 * 封装	Encapsulation
	 * i.将成员变量，成员方法包裹在类中，隐藏成员变量，仅对外暴露公共成员方法
	 * ii.封装实现方式
	 * 将成员变量使用private修饰
	 * 提供公共get，set方法获取和修改成员变量值
	 * iii.封装好处
	 * 类的使用者无法触及类中隐藏的部分
	 * 类的开发者对类中隐藏部分进行修改不会影响类的使用者
	 * 继承	Inheritance
	 * 在现有类的基础上派生出新类称为继承，是复用代码的一种方式
	 * 派生类称为子类，派生子类的类称为父类
	 * 子类继承父类，子类会继承父类的部分成员，如成员变量，成员方法，内部类？？？
	 * i.类层次结构
	 * java中类支持单继承，不支持多继承
	 * Object类是所有类的父类，定义类的通用行为；创建类时若不显式指明父类，默认继承Object类
	 * ii.子类中的操作
	 * 1.子类必定会继承父类public，protected成员；当子父类位于同一个包中，子类会继承父类中包访问权限的成员；
	 * 子类不会继承父类中private成员
	 * 2.子类中能够直接调用继承自父类的成员变量
	 * 3.子类中能够再次定义父类中的成员变量，将父类中的成员变量隐藏，不推荐
	 * 4.子类中能够定义父类中不存在的成员变量
	 * 5.子类中能够直接调用继承自父类的成员方法
	 * 6.子类中能够再次定义父类中非static，非final成员方法，将父类方法覆盖
	 * 7.子类中能够再次定义父类中的static成员方法，将父类方法隐藏
	 * 8.在子类中定义父类中不存在的成员方法
	 * 
	 * 多态	Polymorphism
	 */
	
	String temmp = "sss";
	class Bicycle{
		
		public String field1= "Bicycle";
		void test() {
			System.out.println("Bicycle");
		}
		
		class Inner{
			String i = "iii";
		}
	}
	
	class AE86 extends Bicycle{
		public String field1= "AE86";
	}
	
	public static void main(String[] args) {
		ObjectOrientedProgramming oop = new ObjectOrientedProgramming();
		AE86 ae86 = oop.new AE86();
		System.out.println(ae86.field1);
		
		Inner i = ae86.new Inner();
		System.out.println(i.i);
	}
}
