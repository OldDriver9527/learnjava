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
	 * 默认方法用于在接口中定义方法的默认实现，使用default关键字修饰
	 * 默认方法包含方法体
	 * 当希望在接口中添加新方法，但又不想修改接口实现时，可以使用默认方法
	 * 若父接口中包含默认方法，子接口中可以对父接口中的默认方法进行重新定义，对其进行覆盖或将其变为抽象方法
	 * 
	 * iii.静态方法 static method
	 * 使用static关键字修饰
	 * 静态方法不被继承
	 */
}
