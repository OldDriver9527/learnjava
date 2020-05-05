package org.olddriver.learnjava.oo;

/**
 * 20200505
 * part 11
 */
public class MoreOnClasses {
    /*
     * this
     * this关键字只能用于实例方法，默认方法，构造器，实例初始化器，实例变量初始化器，接收器参数？？？
     * this用作基本表达式时，表示当前对象引用
     * this还能用于构造器调用语句，表示类或接口类型
     *
     * super
     * super作为基本表达式使用时，表示当前对象引用，但对象当作父类类型对待，不能输出super
     * super还能用于父类构造器调用语句，表示父类类型
     *
     * Lambda表达式(Lambda Expression)
     * Lambda表达式计算会创建函数式接口实例，不会导致Lambda体执行
     * LambdaParameters -> LambdaBody
     * Lambda参数对应函数式接口中抽象方法参数列表，参数类型可以显式声明，也可以推断，不能混合使用
     * Lambda参数仅包有一个时，括号可选
     * Lambda体对应函数式接口中抽象方法实现，Lambda体可以是单个表达式或块
     *
     * Object类中方法
     * equals	判断当前对象与参数对象是否相同，Object类中eqauls方法使用==运算符进行判断；
     * 			子类可重写Object类中方法，自定义相等条件，但必须同时重写hashCode方法，确保对象相等时，散列值也相等
     * hashCode	返回对象散列值，Object类中hashCode方法返回对象内存地址的十六进制表现形式
     *
     * 可变参数
     * 当无法确定方法参数列表中某种类型参数个数时可以使用可变参数
     * 可变参数在参数类型后添加省略号，是数组参数的简写
     * 可变参数必须是参数列表中最后一个参数
     */
}
