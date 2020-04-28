package org.olddriver.learnjava.oo;

/**
 * 20200425
 * part 6
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
	 * protected，private，static仅适用于成员接口，不能修饰顶级接口
	 * 顶级接口仅有两种访问权限，public及package
	 * public接口可以在任意位置使用，package access接口只能在当前包中使用
	 * 接口隐式使用abstract修饰
	 *
	 * 接口相关概念
	 * 顶级接口(top level interface) 非嵌套接口
	 * 嵌套接口(nested interface) 定义在类或接口中的接口，嵌套接口又分为
	 *                              成员接口(member interface)
	 *                              局部接口(local interface)
	 *                              匿名接口(anonymous interface)
	 *
	 * 接口成员
	 * 若接口没有直接父接口，会在接口中隐式声明多个public abstract方法，这些方法与Object类中public实例方法对应，
	 * 若接口中显式定义抽象方法与Object类中public实例方法对应，不会再隐式声明
	 * 若接口中声明方法与Object类中final方法声明一致，编译不通过
	 * 若接口中非抽象方法与Object类中public方法具有相同方法签名，仅返回值类型不同或异常列表不同，编译不通过
     *
	 * 字段声明
	 * modifier type fieldName
	 * 字段只能用public static final修饰，接口中字段隐式使用public static final修饰
	 * 字段继承，隐藏
	 * 子接口会继承父接口中字段，只要该字段未被子接口中字段隐藏
	 * 子接口可以继承多个父接口中同名字段，若该字段定义在同一父接口中，不会导致歧义继承
	 * (A接口中定义某个字段，BC接口继承A，D继承BC)
	 * 若该字段定义在多个父接口中，会导致歧义继承，通过字段名直接调用编译无法通过
	 * 子接口中字段会隐藏父接口中可访问的同名字段
	 * 字段初始化
	 * 字段必须进行初始化，但初始化表达式中不能出现当前字段及后面声明字段
	 * 使用常量值进行初始化的字段优先于接口中其他字段进行初始化
	 *
	 * 方法声明
	 * 接口中方法可以使用public，private(jdk9)，abstract，default，static修饰
	 * 方法隐式使用public abstract修饰
	 * 默认方法(default method)
	 * 默认方法使用default修饰，包含方法体，是接口中的实例方法
	 * 当希望在接口中添加新方法，又不修改接口实现时，可以使用默认方法
	 * 通过interface.super.defaultMethod的形式可在实现类中访问接口中默认方法
	 * 静态方法(static method)
	 * 静态方法使用static修饰，包含方法体，只能通过接口名访问
	 * 静态方法中不能使用接口上声明的类型参数
	 * jdk9中静态方法可以使用private修饰，private static方法仅供static方法使用
	 * 私有方法
	 * jdk9中，可声明私有方法，私有方法有方法体，仅在接口中供default方法使用
	 * abstract，default，static关键字无法共存
	 * 方法继承，重写
	 * 子接口继承父接口中所有抽象方法，默认方法，只要该方法未被子接口方法重写
	 * 子接口中不能定义多个声明一致的方法，但可以继承多个声明一致的抽象方法
	 * 当子接口继承AB两个接口中默认方法冲突，B接口继承A接口，B接口中默认方法优先于A接口中默认方法
     * 当子接口继承多个独立接口中默认方法冲突，必须在子接口中对默认方法进行重写
	 * 子接口中的实例方法可以重写父接口中的实例方法
	 *
	 * 成员类，成员接口继承，隐藏
	 * 成员类，成员接口只能使用public，static修饰，成员类，成员接口隐式使用public static修饰
	 * 子接口会继承父接口中所有非private修饰的成员类，成员接口，只要其未被子接口中的成员类，成员接口隐藏
	 * 子接口可以继承多个父接口中同名成员类，成员接口，当该成员定义在同一父接口中不会导致歧义继承，
	 * 若该成员定义在多个父接口中，会导致歧义继承，通过类名或接口名直接调用编译无法通过
	 *
	 * 注解声明
	 * modifier @interface annotationName{
	 *      field,method,class,interface
	 * }
	 * 为了与普通接口声明区分，注解在interface关键字前添加@
	 * 注解直接父接口为Annotation
	 * 注解元素声明
	 * 定义在注解体中的抽象方法称为注解元素，可以定义0个或多个注解元素
	 * 注解元素不能定义形参，异常列表，不能使用类型参数
	 * 注解元素类型可以是基本数据类型，String，Class，枚举，注解，及以上类型数组，注解不能为当前注解，数组不能是多维数组
	 * 注解元素方法签名不能与Object类或Annotation接口中的方法签名冲突
	 * 无注解元素的注解称为标记注解
	 * 只有一个注解元素注解称为单元素注解，单元素注解注解元素名称为value
	 * 注解元素默认值
	 * 通过default关键字在注解元素参数列表后定义默认值，默认值类型要与注解元素类型匹配
	 * 重复注解(Repeatable Annotation)
	 * 声明中包含@Repeatable，@Repeatable的value元素指定容器注解(容器注解用于存放重复注解)
	 * 容器注解中value元素类型必须是重复注解的数组
	 * 容器注解中的其他元素必须定义默认值
	 * 容器注解保留时间至少大于重复注解
	 * ？？？？
	 * 若重复注解包含@Documented，容器注解必须包含@Documented；若容器注解包含@Documented，重复注解可以不包含@Documented
	 * 若重复注解包含@Inherited，容器注解必须包含@Inherited；若容器注解包含@Inherited，重复注解可以不包含@Inherited
	 * 预定义注解
	 * @Target
	 * 指定注解适用的上下文
	 * @Retention
	 * 指定注解保留的时间长度
	 * @Inherited
	 * 指定使用在类C上的注解是否被C子类继承
	 * @Override
	 * 在编译时检测方法是否重写父类或父接口中方法
	 *
	 * 函数式接口
	 * 仅有一个抽象方法的接口，接口中与Object类中方法声明一致的方法除外
	 */


}
