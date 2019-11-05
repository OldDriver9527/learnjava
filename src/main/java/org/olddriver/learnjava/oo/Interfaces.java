package org.olddriver.learnjava.oo;

public interface Interfaces{
	/*
	 * i.声明接口
	 * modifier interface InterfaceName extends interface list{
	 * 		constant，abstract method
	 * }
	 * 接口仅有两种访问权限，public及package；
	 * public修饰的接口可以在任意位置使用，package权限接口只能在当前包中使用
	 * 
	 * ii.默认方法 default method
	 * 默认方法用于在接口中定义方法的默认实现，使用default关键字修饰，默认方法包含方法体
	 * 当希望在接口中添加新方法，但又不想修改接口实现时，可以使用默认方法
	 * 若父接口中包含默认方法，子接口中可以对父接口中的默认方法进行重新定义，对其进行覆盖或将其变为抽象方法
	 * 
	 * iii.静态方法 static method
	 * 使用static关键字修饰
	 * 静态方法不被继承
	 * 
	 * iiii.解决默认方法冲突方式
	 * 当接口中默认方法与父类中成员方法冲突，父类中成员方法优先于接口中默认方法
	 * 当父接口与子接口中默认方法冲突，子接口中默认方法优先于父接口中默认方法
	 * 当多个独立接口中默认方法冲突，必须在实现类中对默认方法进行覆盖
	 * 
	 * 
	 * 
	 * java中类能够实现多个接口，通过接口.super.member的形式在实现类中访问接口成员
	 * java中接口支持多继承，因为接口中不存在成员变量，多个父接口中常量冲突能够在编译时发现
	 */
}
