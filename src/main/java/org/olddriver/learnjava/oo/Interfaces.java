package org.olddriver.learnjava.oo;

public interface Interfaces{
	/*
	 * i.声明接口
	 * modifier interface InterfaceName extends interface list{
	 * 		constant，abstract method
	 * }
	 * 接口仅有两种访问权限，public及package；
	 * public修饰的接口可以在任意位置使用，package权限接口只能在当前包中使用
	 * 接口中所有抽象方法，默认方法，静态方法默认public修饰，public修饰符可省略
	 * 
	 * ii.默认方法 default method
	 * 默认方法用于在接口中定义方法的默认实现，使用default关键字修饰，默认方法包含方法体
	 * 当希望在接口中添加新方法，但又不想修改接口实现时，可以使用默认方法
	 * 若父接口中包含默认方法，子接口中可以对父接口中的默认方法进行重新定义，对其进行覆盖或将其变为抽象方法
	 * 通过interface.super.defaultMethod的形式可在实现类中访问接口中默认方法
	 * 
	 * iii.静态方法 static method
	 * 使用static关键字修饰，只能通过接口名访问
	 * 静态方法不被子接口，实现类继承
	 * 
	 * iiii.解决默认方法冲突方式
	 * 当接口中默认方法与父类中成员方法冲突，父类中成员方法优先于接口中默认方法
	 * 当父接口与子接口中默认方法冲突，子接口中默认方法优先于父接口中默认方法
	 * 当多个独立接口中默认方法冲突，必须在实现类中对默认方法进行覆盖
	 * 
	 * iiiii.实现接口
	 * 类使用implements关键字实现接口，类可以实现多个接口，
	 * 按照惯例，implements关键字位于extends关键字之后
	 * 
	 * iiiiii.多继承
	 * java中接口支持多继承，因为接口中不存在成员变量，多个父接口中常量冲突能够在编译时发现
	 */
}
