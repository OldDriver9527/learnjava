package org.olddriver.learnjava.oo;

/**
 * 20200425
 * 接口 概念
 * 第六部分
 */
@CopyRight(value="hello")
public interface Interfaces{
	/**
	 * 声明接口
	 * 声明接口会创建新引用类型，接口声明分为普通接口声明和注解声明
	 * 普通接口声明格式
	 * modifier interface InterfaceName extends Interface List{
	 * 		field,method,class,interface
	 * }
     *
     * 接口分类
     * 顶级接口(top level interface)
     * 非嵌套接口，顶级接口仅有两种访问权限
     * 嵌套接口(nested interface)
     * 声明在类或接口中的接口，嵌套接口又分为成员接口，局部接口，匿名接口
     * 成员接口(member interface)
     * 局部接口(local interface)
     * 声明和实例化动作同时进行，实例化出匿名接口实现类对象
     *
     * 接口修饰符
	 * 接口可以使用public，protected，private，abstract，static修饰
	 * protected，private仅适用于类中的成员接口
     * static仅适用于类或接口中成员接口
	 * 接口隐式使用abstract修饰
     *
	 * 接口中隐式成员
	 * 若接口没有直接父接口，会在接口中隐式声明多个public abstract方法，这些方法与Object类中public实例方法对应(hashCode，equals，toString)，
	 * 若接口中显式声明抽象方法与Object类中public实例方法方法签名一致，不会再隐式声明
     *
	 * 字段声明
	 * modifier type fieldName
     * 字段修饰符
	 * 字段只能用public static final修饰，接口中字段隐式使用public static final修饰
	 * 字段初始化
     * 字段必须在声明时进行显式初始化，但初始化器中不能出现当前字段及其后声明字段
     * 使用常量值进行初始化的字段优先于接口中其他字段进行初始化
	 * 字段继承
	 * 子接口会继承父接口中字段，只要该字段未被子接口中字段隐藏
     * 字段歧义继承
	 * 多个父接口中字段同名，
	 * 若多个父接口之间存在继承关系(接口B继承接口A)，会导致歧义继承
	 * 若多个父接口之间无继承关系但存在共同父接口，在共同父接口中声明同名字段，不会导致歧义继承；
	 * 若多个父接口之间无继承关系不存在共同父接口，在多个接口中声明同名字段，会导致歧义继承，通过简单名直接调用编译无法通过
	 * 字段隐藏
     * 子接口中字段会隐藏父接口中可访问的同名字段
	 *
	 * 方法声明
     * 方法修饰符
	 * 方法可以使用public，private(jdk9)，abstract，default，static修饰
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
	 * 方法继承
	 * 子接口继承父接口中所有抽象方法，默认方法，只要该方法未被子接口方法重写
	 * 方法歧义继承
     * 多个父接口中实例方法冲突，
	 * 若AB两接口中实例方法冲突，B继承于A，不会导致歧义继承，B中实例方法优先于A中实例方法
	 * 若BC两接口中实例方法冲突，B，C继承于A，在A中声明实例方法，不会导致歧义继承；若B中对该方法重写，已重写方法有限
	 * 若在BC中分别定义实例方法，若默认方法与默认方法冲突或默认方法与抽象方法冲突，会导致歧义继承
     * 方法歧义继承会导致编译无法通过，必须在子接口中对此方法进行重写
	 * 方法重写
     * 子接口中的实例方法可以重写父接口中可访问的实例方法
	 * 默认方法不能重写接口中与Object类中等价的方法
     * 抽象方法不能重写接口中与Object类中等价的final方法
     * 抽象方法重写接口中与Object类中等价方法时返回值类型必须相同
     *
     * 成员类，成员接口修饰符
	 * 接口中成员类，成员接口只能使用public，static修饰，隐式使用public static修饰
	 * 成员类型继承
     * 子接口会继承父接口中所有可访问的成员类，成员接口，只要其未被子接口中的成员类，成员接口隐藏
	 * 成员类型歧义继承
     * 多个父接口中成员类，成员接口同名，
	 * 若多个父接口之间存在继承关系，会导致歧义继承
	 * 若多个父接口之间无继承关系但存在共同父接口，在共同父接口中定义类型，不会导致歧义继承；
	 * 若多个父接口之间无继承关系不存在共同父接口，在多个接口中定义同名类型，会导致歧义继承0，0通过简单名直接调用编译无法通过
	 * 成员类型隐藏
     * 子接口中的类型会隐藏父接口中可访问的同名类型
	 *
	 * 注解类型声明
	 * 注解是一种特殊接口，为程序提供解释说明的信息，程序通过反射获取注解信息
	 * modifier @interface annotationName{
	 *      field,method,class,interface
	 * }
	 * 注解类型中显式声明的方法与一个注解元素关联
     * 为了与普通接口声明区分，注解类型在interface关键字前添加@
     * 注解类型无继承的接口列表，注解类型直接父接口为Annotation
	 *
     * 注解类型分类
     * 普通注解类型
     * 标记注解类型
     * 单元素注解类型
     *
     * 注解类型修饰符
     * 注解类型修饰符与接口一致，隐式abstract修饰
	 *
     * 注解类型中方法修饰符
     * public abstract
     *
     * 注解类型中方法说明
     * 注解类型中方法只能是抽象方法，且不能包含形参，异常列表，不能使用类型变量。
     * 返回值类型是基本数据类型，String，Class，枚举，注解类型，及以上类型数组，注解类型不能为当前注解，数组不能是多维数组
	 * 方法签名不能与Object类或Annotation接口中的方法签名冲突
	 * 单元素注解方法名称建议为value
	 * 在参数列表后通过default关键字定义注解元素默认值，默认值类型要与返回值类型匹配
     *
     * 重复注解(Repeatable Annotation)类型声明
     * 使用@Repeatable修饰，@Repeatable的value方法指定容器注解(容器注解用于存放重复注解)
     * 容器注解中必须定义value方法，value方法返回值类型必须是重复注解的数组
     * 容器注解中的其他方法必须定义默认值
     * 容器注解保留时间至少大于重复注解
     * ？？？？
     * 若重复注解包含@Documented，容器注解必须包含@Documented；若容器注解包含@Documented，重复注解可以不包含@Documented
     * 若重复注解包含@Inherited，容器注解必须包含@Inherited；若容器注解包含@Inherited，重复注解可以不包含@Inherited
     *
     * 预定义注解类型
     * @Target
     * 指定注解适用的上下文
     * @Retention
     * 指定注解保留的时长
     * @Inherited
     * 指定注解是否被所在类的子类继承，在接口上不生效
     * @Override
     * 在编译时检测实例方法是否重写父类或父接口中实例方法
     *
     * 注解
     * 对具体注解类型的调用。使用注解时，必须为没有默认值的方法指定返回值
	 * spring中通过应用上下文可以获取具有指定注解的bean
     *
	 * 函数式接口
	 * 仅有一个抽象方法的接口，接口中与Object类中等价抽象方法除外；函数式接口中可以包含默认方法，静态方法
	 * 函数式接口可以使用@FunctionalInterface标识
	 *
	 * 内置函数式接口，位于java.util.function包中
	 * Supplier 供给型接口，用于存储数据，提供给其他方法使用；
	 *          抽象方法get方法返回存储数据
	 * Consumer 消费型接口，对输入执行指定操作无输出。类型变量为输入类型
	 *          抽象方法accept方法对输入执行操作
	 *          默认方法andThen返回组合Consumer对象，返回对象中accept方法 先调用当前对象accept方法，再调用参数对象accept方法，对同一输入先后执行不同操作
	 * Function 功能型接口，对输入执行操作后返回输出。第一个类型变量为输入类型，第二个类型变量为返回值类型
	 *          抽象方法apply方法对输入执行操作，返回结果
	 *          默认方法andThen返回合并Function对象，返回对象中apply方法 先调用当前对象apply方法，再将返回值传参数对象apply方法
	 *          默认方法compose返回合并Function对象，返回对象中apply方法 先调用参数对象apply方法，再将返回值传给当前对象apply方法
	 *          静态方法identity返回Function对象，回对象中apply方法 不对输入进行操作
	 * Predicate 断言型接口，对输入执行判断，返回booelan类型结果
	 *           抽象方法test对输入进行判断，返回boolean类型结果
	 *           默认方法and返回组合Predicate对象，返回对象中test方法 对当前对象test方法和参数对象test方法结果进行&&运算
	 *           默认方法or返回组合Predicate对象，返回对象中test方法 对当前对象test方法和参数对象test方法结果进行||运算
	 *           默认方法negate返回新Predicate对象，返回对象中test方法 对当前对象test方法结果进行!运算
	 *           静态方法isEqual返回新Predicate对象，返回对象中test方法 中将test输入参数与isEqual输入参数进行比较
	 */
}
