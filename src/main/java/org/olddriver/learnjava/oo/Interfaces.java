package org.olddriver.learnjava.oo;

/**
 * 20200425
 * part 3
 */
public interface Interfaces{
	/*
	 * 声明接口
	 * 声明接口会创建新引用类型，接口声明分为普通接口声明和注解声明
	 * i.普通接口声明格式
	 * modifier interface InterfaceName extends Interface List{
	 * 		field,method,class,interface
	 * }
	 * 接口可以使用public，protected，private，abstract，static修饰
	 * protected，private，static仅适用于成员接口
	 * 顶级接口仅有两种访问权限，public及package
	 * public修饰的接口可以在任意位置使用，package access接口只能在当前包中使用
	 * 接口隐式使用abstract修饰
	 * 接口相关概念
	 * 顶级接口(top level interface) 非嵌套接口
	 * 嵌套接口(nested interface) 定义在类或接口中的接口，嵌套接口又分为
	 *                              成员接口(member interface)
	 *                              局部接口(local interface)
	 *                              匿名接口(anonymous interface)
	 *
	 * 字段声明
	 * modifier type fieldName
	 * 字段只能用public static final修饰，接口中字段隐式使用public static final修饰
	 * 字段继承，隐藏
	 * 子接口会继承父接口中字段，只要该字段未被子接口中字段隐藏
	 * 子接口中字段会隐藏父接口中可访问的同名字段
	 * 子接口可以继承多个父接口中同名字段，若该字段定义在同一父接口中，不会造成含糊继承
	 * (A接口中定义某个字段，BC接口继承A，D继承BC)
	 * 若该字段定义在多个父接口中，会造成含糊继承，通过字段名直接调用编译无法通过
	 * 字段必须进行初始化，但初始化表达式中不能出现当前字段及后面声明字段
	 * 通过常量值进行初始化的字段优先于接口中其他字段进行初始化
	 *
	 * 方法声明
	 * 接口中方法可以使用public，private(jdk9)，abstract，default，static修饰
	 * 方法隐式使用public abstract修饰
	 * 默认方法(default method)
	 * 默认方法使用default修饰，包含方法体，是接口中的实例方法
	 * 当希望在接口中添加新方法，又不修改接口实现时，可以使用默认方法
	 * 通过interface.super.defaultMethod的形式可在实现类中访问接口中默认方法
	 * 静态方法(static method)
	 * 静态方法使用static修饰，只能通过接口名访问
	 * 静态方法中不能使用接口上声明的类型参数
	 * jdk9中静态方法可以使用private修饰private static方法仅供static方法使用
	 * 私有方法
	 * jdk9中，可声明私有方法，私有方法有方法体，仅在接口中使用
	 * abstract，default，static关键字无法共存
	 * 方法继承，重写
	 * 子接口继承父接口中所有抽象方法，默认方法
	 * 子接口中不能定义多个声明一致的方法，但可以继承多个声明一致的抽象方法
	 * 子接口中的实例方法可以重写父接口中的实例方法
	 * 当接口中默认方法与父类中成员方法冲突，父类中成员方法优先于接口中默认方法
     * 当父接口与子接口中默认方法冲突，子接口中默认方法优先于父接口中默认方法
     * 当多个独立接口中默认方法冲突，必须在实现类中对默认方法进行覆盖
	 *
	 * 成员类，成员接口继承，隐藏
	 * 成员类，成员接口只能使用public，static修饰，成员类，成员接口隐式使用public static修饰
	 * 子接口会继承父接口中所有非private修饰的成员类，成员接口，只要其未被子接口中的成员类，成员接口隐藏
	 * 子接口可以继承多个父接口中同名成员类，成员接口，当该成员定义在同一父接口中不会导致含糊继承，
	 * 若该成员定义在多个父接口中，会导致含糊继承，通过类名或接口名直接调用编译无法通过
	 * 
	 * iiiii.实现接口
	 * 类使用implements关键字实现接口，类可以实现多个接口
	 * 实现类从接口中继承常量，抽象方法，默认方法？？？
	 * 按照惯例，implements关键字位于extends关键字之后
	 *
	 */

}
