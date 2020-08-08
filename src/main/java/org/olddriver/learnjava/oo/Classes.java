package org.olddriver.learnjava.oo;

/**
 * 20200421
 * part 2
 */
public class Classes{
	/*
	 * 声明类
	 * 声明类会定义一个新引用类型，声明类分为普通类声明，枚举声明
	 * 类声明格式
	 * modifier class ClassName extends SuperClassName implements Interface List{
	 * 		field,method,class,interface
	 * }
	 * 类修饰符包括public，protected，private，abstract，static，final，strictfp
	 * protected，private仅适用于类中成员类
	 * static只用于修饰成员类，不能修饰顶级类，局部类，匿名类
	 * abstract类
	 * 抽象类认为是不完整类，无法实例化。抽象类中可以定义抽象方法，非抽象方法
	 * 抽象类的子类必须实现所有抽象方法才能实例化
	 * final类
	 * final类不能被继承
	 * 顶级类仅有两种访问权限，public及package
	 * 被public修饰类能够被任意位置代码使用，package access类仅能被其所在包中代码访问
	 *
	 * 类相关概念
	 * 顶级类(top level class) 非嵌套类的类
	 * 嵌套类(nested class) 声明在类或接口内的类，嵌套类又分为
	 *                      成员类(member class)   具有名称，定义在块，方法，构造器以外的类
	 *                      局部类(local class)    具有名称，定义在块，方法，构造器内的类
	 *                      匿名类(anonymous class)    不具有名称
	 *                      内部类(inner class) 非static的嵌套类
	 *
	 * 声明字段
	 * modifier type fieldName;
	 * 字段修饰符包括public，protected，private，static，final，transient，volatile
	 * static字段
	 * 类变量被类的所有实例共享，内存中仅存在一份
	 * final字段
	 * 被final修饰的字段必须进行显式初始化
	 * 被final修饰类变量，必须在声明时初始化或在静态初始化器中初始化
	 * 被final修饰实例变量，必须在声明时初始化或在实例初始化器，构造器中初始化
	 * transient字段
	 * 被transient修饰的字段不参与序列化
	 * volatile字段
	 * 字段继承，隐藏
	 * 子类继承父类，父接口中所有对子类可见字段，只要字段未被子类字段隐藏
	 * 若子类继承父类中字段和父接口中字段同名，会导致歧义继承，子类中通过简单名引用该字段编译无法通过
	 * 若子类继承AB两个接口中字段同名，B接口继承A接口，B接口中字段优先于A接口中字段
	 * 若子类继承多个独立接口中字段同名，若该字段定义在同一接口中，不会导致歧义继承(A接口中定义某个字段，BC接口继承A，D类实现BC)
	 * 若该字段定义在多个接口中，会导致歧义继承，子类中通过简单名引用该字段编译不通过
     * 子类中字段会隐藏父类，父接口中所有可访问同名字段
     * 字段隐藏与static无关，与字段类型无关
	 * 实例变量与局部变量区别
     * i.实例变量随对象的创建而创建，随对象的销毁而销毁
     * 	 局部变量随所属区域的执行而创建，随所属区域的结束而消失
     * ii.实例变量存储在堆内存中，局部变量存储在栈内存中
     * iii.实例变量存在默认初始化值；局部变量不存在默认初始化值，在使用局部变量之前要确保其已经初始化完毕，否则编译不通过
     * iiii.实例变量定义在块，方法，构造器以外，局部变量定义在块，方法，构造器以内
     *
	 * 声明方法
	 * 方法修饰符包括public，protected，private，abstract，static，final，native，synchronized
	 * abstract方法
	 * 抽象方法仅有方法声明，无方法体
	 * 抽象方法必须定义在抽象类，枚举，接口中
	 * abstract方法不能使用private，static，final修饰
	 * static方法
	 * 类方法中不能通过简单名称调用本类中实例变量，实例方法
	 * final方法
	 * final方法不能在子类中重写，隐藏
	 * private方法及final类中方法行为同final方法
	 * native方法
	 * native方法使用平台相关代码实现，native方法不需定义方法体，表示忽略方法体
	 * 方法返回值
     * 方法返回值类型为void，方法不返回返回值
     * 子类重写父类，父接口方法时，方法返回值类型可以是原返回值类型的子类
     * 方法异常
     * 使用throws关键字声明受查异常，这些异常可能来自构造器或方法
     * 方法继承，重写，隐藏
     * 子类继承父类中对子类可见方法，只要该方法未被子类方法重写和隐藏
     * 子类继承父接口中abstract，default方法，只要该方法未被子类方法重写，不继承static方法
     * 当子类继承父接口中实例方法与父类中实例方法冲突，父类中实例方法优先于父接口中实例方法
     * 当子类继承AB两个接口中实例方法冲突，B接口继承A接口，B接口中实例方法优先于A接口中实例方法
     * 当子类继承多个独立接口中实例方法冲突，若该方法定义在同一接口中，不会导致歧义继承(A接口中定义某个方法，BC接口继承A，D类实现BC)
     * 若该方法定义在不同接口中，必须在子类中对此方法进行重写
     * 子类中实例方法可以重写父类，父接口中可访问的实例方法，子类实例方法方法签名要与父类，父接口实例方法保持一致，
     * 子类实例方法返回值类型可以是父类，父接口实例方法返回值类型的子类，
     * 子类实例方法访问权限要大于等于父类，父接口实例方法访问权限，
     * 子类实例方法异常列表必须是父类，父接口实例方法异常列表子类或子集
     * 子类中非抽象方法重写父类，父接口中抽象方法称为实现
     * @Override注解用于表示子类方法重写父类，父接口中实例方法
     * 子类中类方法可以隐藏父类中可访问类方法
     *
     * 成员类，成员接口继承，隐藏
     * 子类继承父类，父接口中所有对子类可见成员类，成员接口，只要该成员未被子类隐藏
     * 若子类继承父类中类型和父接口中类型同名，会导致歧义继承，子类中通过简单名引用该类型编译无法通过
     * 若子类继承AB两个接口中类型同名，B接口继承A接口，会导致歧义继承，子类中通过简单名引用该类型编译无法通过
     * 子类继承多个独立接口中类型同名，若该类型定义在同一接口中，不会导致歧义继承(A接口中定义某个类型，BC接口继承A，D类实现BC)
     * 若该类型定义在多个接口中，会导致歧义继承，子类中通过简单名引用该字段编译不通过
     * 子类中成员类和成员接口，会隐藏父类，父接口中可访问的同名成员类和成员接口
     * 可以使用static修饰类中成员类，类中成员接口隐式static修饰
     * 静态成员类，静态成员接口与静态方法类似，不能在其中使用简单名称调用当前类中实例变量，实例方法
     *
     * 实例初始化器(Instance Initializers)
     * 专门用于对象初始化，每当创建类实例时执行一次；
     * 实例初始化器中的语句会被编译器移动到不含this语句构造器中
     * 实例初始化器中能够使用this，super访问当前对象
     *
     * 静态初始化器(Static Initializers)
     * 用于类初始化，在初始化类时执行一次
     *
	 * 构造器(Constructor)
	 * 类中特殊方法，专门用于为对象进行初始化，在创建对象时被调用执行
	 * 构造器特点
	 * i.构造器名称与类名一致
	 * ii.构造器不需定义返回值类型
	 * 默认构造器
	 * 当类中没有显式定义构造器，编译器会自动为类提供一个无参构造器作为默认构造器
	 * 当类中显式定义过构造器，编译器不会向类中添加默认构造器
	 * Object类中的默认构造器方法体为空，其他类默认构造器中默认调用父类无参构造器
	 * 默认构造器与类具有相同访问修饰符
	 * 构造器与方法对比
	 * 构造器在创建对象时被调用执行，创建一个对象执行一次
	 * 方法在对象创建完毕被调用执行，调用几次执行几次
	 * 构造器重载
	 * 类中允许存在多个同名构造器，只要其方法签名不同即可
	 * 构造器说明
	 * i.构造器与赋值作用的set方法不冲突
	 * 构造器用于为对象进行初始化
	 * set方法在对象创建完毕，为字段赋值
	 * ii.构造器中能够调用方法，方法中不能直接调用构造器
	 * iii.构造器不需定义返回值类型，无返回值，但存在return语句
	 * iiii.当为构造器定义返回值类型，构造器就转变为方法
	 * iiiii.构造器只能使用public，protected，private修饰
	 * iiiiii.构造器能够声明异常列表
	 *
	 * 为方法或构造器传值
	 * i.方法或构造器参数类型可以是基本数据类型，引用数据类型，形参和实参是两个独立变量，最初储存相同值
	 * ii.当形参类型为基本数据类型，形式参数的修改不会影响到实际参数
	 * iii.当形参类型为引用数据类型，
	 * 将形式参数存储的对象地址修改，不会影响实参
	 * 将形参指向对象中的字段修改，会影响实参指向的对象
	 * iiii.对于boolean以外的七种基本数据类型值，当实参数据类型等级低于形参数据类型等级时，实参会进行自动类型提升
	 *
	 * 声明枚举
	 * modifier enum EnumName implements Interfaces List{
	 *      ENUMCONSTANT,ENUMCONSTANT;
	 * }
	 * 修饰符包含public，protected，private，static，枚举不能使用abstract，final修饰
	 * protected，private仅适用于类中成员枚举
	 * static仅能修饰成员枚举，嵌套枚举隐式static修饰
	 * 不存在局部枚举
	 * 枚举直接父类是Enum类
	 * 枚举仅能通过枚举常量创建对象，不能通过其他方式创建枚举对象
	 * 枚举常量(Enum Constants)
	 * 枚举常量定义枚举对象，枚举常量标识符所有字母大写，不允许使用修饰符修饰枚举常量
	 * 枚举常量标识符后可以定义参数列表及类体，采用匿名类的形式创建枚举常量，当使用无参构造器创建枚举常量，参数列表可省
	 * 类体中不能定义构造器，抽象方法
	 * 由于每个枚举常量仅创建唯一一个实例，枚举常量之间比较时可以使用==替代equals方法
	 * 枚举体
	 * 枚举体中可以定义字段，方法，类，接口，构造器，静态初始化器，实例初始化器
	 * 枚举体中构造器只能private修饰，默认构造器使用private修饰
	 * 枚举体中的构造器不能使用super访问父类构造器
	 * 枚举体中隐式声明public static final字段，名称与枚举常量一致，初始化隐式字段时创建枚举常量
	 * 枚举体中隐式声明public static 的 values()，获取封装枚举常量的数组
	 * 枚举体中隐式声明public static 的 valueOf()，获取指定名称枚举常量
	 */
}
