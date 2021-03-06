package org.olddriver.learnjava.oo;

/**
 * 20200425
 * part 3
 */
public interface Interfaces{
	/*
	 * 声明接口
	 * 声明接口会创建新引用类型，接口声明分为普通接口声明和注解声明
	 *
	 * 普通接口声明格式
	 * modifier interface InterfaceName extends Interface List{
	 * 		field,method,class,interface
	 * }
	 * 接口可以使用public，protected，private，abstract，static修饰
	 * static仅适用于成员接口，不能修饰顶级接口，局部接口，匿名接口
	 * protected，private仅适用于类中的成员接口
	 * 接口隐式使用abstract修饰
	 * 顶级接口仅有两种访问权限，public及package
	 * public接口可以被任意位置代码访问，package access接口只能被其所在包中代码访问
	 *
	 * 接口相关概念
	 * 顶级接口(top level interface) 非嵌套接口
	 * 嵌套接口(nested interface) 定义在类或接口中的接口，嵌套接口又分为
	 *                              成员接口(member interface)
	 *                              具有名称，定义在构造器，方法，块以外嵌套接口
	 *                              局部接口(local interface)
	 *                              具有名称，定义在构造器，方法，块以内嵌套接口
	 *                              匿名接口(anonymous interface)
	 *                              没有名称嵌套接口
	 * 接口成员
	 * 若接口没有直接父接口，会在接口中隐式声明多个public abstract方法，这些方法与Object类中public实例方法对应(hashCode，equals，toString)，
	 * 若接口中显式定义抽象方法与Object类中public实例方法对应，不会再隐式声明
	 * 默认方法不能重写Object类中方法，抽象方法不能重写Object类中final方法
	 * 抽象方法重写Object类中方法时返回值类型必须相同
     *
	 * 字段声明
	 * modifier type fieldName
	 * 字段只能用public static final修饰，接口中字段隐式使用public static final修饰
	 * 字段初始化
     * 字段必须在声明时进行显式初始化，但初始化器中不能出现当前字段及其后声明字段
     * 使用常量值进行初始化的字段优先于接口中其他字段进行初始化
	 * 字段继承，隐藏
	 * 子接口会继承父接口中字段，只要该字段未被子接口中字段隐藏
	 * 多个父接口中字段同名，若字段定义在一个接口中，不会导致歧义继承；若字段定义在多个接口中，会导致歧义继承，通过简单名直接调用编译无法通过
	 * 子接口中字段会隐藏父接口中可访问的同名字段
	 *
	 * 方法声明
	 * 接口中方法可以使用public，private(jdk9)，abstract，default，static修饰
	 * 方法隐式使用public abstract修饰
	 * 默认方法(default method)
	 * 默认方法使用default修饰，包含方法体，是接口中的实例方法
	 * 当希望在接口中添加新方法，又不修改接口实现时，可以使用默认方法
	 * 静态方法(static method)
	 * 静态方法使用static修饰，包含方法体，只能通过接口名访问
	 * 静态方法中不能使用接口上声明的类型变量
	 * jdk9中静态方法可以使用private修饰，private static方法仅供static方法使用
	 * 私有方法
	 * jdk9中，可声明私有方法，私有方法有方法体，仅在接口中供default方法使用
	 * abstract，default，static关键字无法共存
	 * 方法继承，重写
	 * 子接口继承父接口中所有抽象方法，默认方法，只要该方法未被子接口方法重写
	 * 多个父接口中实例方法冲突，
	 * 若AB两接口中实例方法冲突，B继承于A，不会导致歧义继承，B中实例方法优先于A中实例方法
	 * 若BC两接口中实例方法冲突，B，C继承于A，在A中声明实例方法，不会导致歧义继承；
	 * 若在BC中分别定义实例方法，若BC中默认方法冲突或BC中默认方法与实例方法冲突，必须在子接口中对此方法进行重写
	 * 子接口中的实例方法可以重写父接口中可访问的实例方法
	 *
	 * 成员类，成员接口继承，隐藏
	 * 接口中成员类，成员接口只能使用public，static修饰，成员类，成员接口隐式使用public static修饰
	 * 子接口会继承父接口中所有可访问的成员类，成员接口，只要其未被子接口中的成员类，成员接口隐藏
	 * 多个父接口中成员类，成员接口同名，若定义在同一接口中，不会导致歧义继承；若定义在多个接口中，会导致歧义继承，通过简单名直接调用编译无法通过
	 * 子接口中的类型会隐藏父接口中可访问的同名类型
	 *
	 * 注解声明
	 * modifier @interface annotationName{
	 *      field,method,class,interface
	 * }
	 * 为了与普通接口声明区分，注解在interface关键字前添加@
	 * 注解无继承的接口列表，注解直接父接口为Annotation
	 * 注解体中方法只能是抽象方法
	 * 注解修饰符与接口一致，注解隐式abstract声明
	 * 注解元素声明
	 * 定义在注解体中的抽象方法称为注解元素，可以定义0个或多个注解元素
	 * 注解元素不能定义形参，异常列表，不能使用类型变量
	 * 注解元素类型可以是基本数据类型，String，Class，枚举，注解，及以上类型数组，注解不能为当前注解，数组不能是多维数组
	 * 注解元素方法签名不能与Object类或Annotation接口中的方法签名冲突
	 * 无注解元素的注解称为标记注解
	 * 只有一个注解元素注解称为单元素注解，单元素注解注解元素名称建议为value
	 * 注解元素默认值
	 * 通过default关键字在注解元素参数列表后定义默认值，默认值类型要与注解元素类型匹配
	 * 重复注解(Repeatable Annotation)
	 * 声明中包含@Repeatable，@Repeatable的value元素指定容器注解(容器注解用于存放重复注解)
	 * 容器注解中必须定义value注解元素，value元素类型必须是重复注解的数组
	 * 容器注解中的其他元素必须定义默认值
	 * 容器注解保留时间至少大于重复注解
	 * ？？？？
	 * 若重复注解包含@Documented，容器注解必须包含@Documented；若容器注解包含@Documented，重复注解可以不包含@Documented
	 * 若重复注解包含@Inherited，容器注解必须包含@Inherited；若容器注解包含@Inherited，重复注解可以不包含@Inherited
	 * 预定义注解
	 * @Target
	 * 指定注解适用的上下文
	 * @Retention
	 * 指定注解保留的时长
	 * @Inherited
	 * 指定使用在类上的注解是否被子类继承
	 * @Override
     * 在编译时检测实例方法是否重写父类或父接口中实例方法
	 *
	 * 函数式接口
	 * 仅有一个抽象方法的接口，接口中与Object类中对应方法除外；函数式接口中可以包含默认方法，静态方法
	 * 函数式接口可以使用@FunctionalInterface标识
	 *
	 * 内置函数式接口，位于java.util.function包中
	 * Supplier 供给型接口，用于存储数据，提供给其他方法使用；
	 *          get方法返回存储数据
	 * Consumer 消费型接口，对输入执行指定操作。类型变量为输入类型
	 *          accept方法对输入执行操作
	 *          andThen方法返回组合Consumer对象，对象中accept方法先执行当前Consumer对象accept方法，再执行参数Consumer对象accept方法
	 *          对同一输入先后执行不同操作
	 * Function 功能型接口，对输入执行操作后返回结果。第一个类型变量为输入类型，第二个类型变量为返回值类型
	 *          apply方法对输入执行操作，返回结果
	 *          andThen方法返回合并Function对象，先对输入执行当前对象apply方法，再对返回结果执行参数对象apply方法
	 *          compose方法返回合并Function对象，先对输入执行参数对象apply方法，再对返回结果执行当前对象apply方法
	 *          identity方法返回Function对象，对象的apply方法总是返回输入
	 * Predicate 断言型接口，对输入执行判断，返回booelan类型结果
	 *           test方法对输入进行判断，返回boolean类型结果
	 *           and方法返回组合Predicate对象，test方法中对当前对象test方法和参数对象test方法结果进行&&运算
	 *           or方法返回组合Predicate对象，test方法中对当前对象test方法和参数对象test方法结果进行||运算
	 *           negate方法返回新Predicate对象，test方法中对当前对象test方法结果进行!运算
	 *           isEqual静态方法，创建Predicate对象，test方法中将test输入参数与isEqual输入参数进行比较
	 */



}
