package org.olddriver.learnjava.oo;

/**
 * 20200505
 * 类 补充
 * 第十部分
 */
public class MoreOnClasses {
    /**
     * this
     * this关键字只能用于实例方法，默认方法，构造器，实例初始化器，实例变量初始化器，接收器参数？？？
     * this用作基本表达式时，表示当前对象引用
     * this还能用于构造器调用语句，表示当前类型
     *
     * super
     * super作为基本表达式使用时，表示当前对象转型为父类类型引用，不能输出super
     * super还能用于父类构造器调用语句，表示父类类型
     *
     * Lambda表达式(Lambda Expression)
     * LambdaParameters -> LambdaBody
     * 执行Lambda表达式会创建函数式接口实现类实例，不会导致Lambda体执行
     * Lambda参数对应函数式接口中抽象方法形参列表，参数类型可以显式声明，也可以推断，不能混合使用
     * Lambda参数仅有一个，括号可选
     * Lambda体对应函数式接口中抽象方法实现，Lambda体可以是单个表达式或块
     * Lambda表达式在运行时，会在当前类中添加private static方法，方法体为LambdaBody；并且生成新类，新类中调用新增方法
     *
     * 方法引用(Method References)表达式
     * Lambda Expression简写形式，用于创建函数式接口子类对象
     * 方法引用分类
     * i.通过实例引用实例方法 instance::instanceMethod
     * 若LambdaBody中仅通过实例调用实例方法，LambdaExpression可以简化成 instance::instanceMethod
     * 实例方法参数列表，返回值类型要与FunctionalInterface中抽象方法参数列表，返回值类型一致
     * ii.通过类名引用类方法 ClassName::staticMehtod
     * 若LambdaBody中仅通过类名调用类方法，LambdaExpression可以简化成 ClassName::staticMehtod
     * 类方法参数列表，返回值类型要与FunctionalInterface中抽象方法参数列表，返回值类型一致
     * iii.通过类名引用实例方法 ClassName::instanceMethod
     * 若LambdaBody中仅调用第一个参数的实例方法，其他参数传入实例方法，LambdaExpression可以简化成 ClassName::instanceMethod，类名为第一个参数类名
     * 实例方法参数列表，返回值类型与FunctionalInterface中抽象方法参数列表，返回值类型对应
     * iiii.通过类名引用构造器 ClassName::new
     * 若LambdaBody中仅创建指定类型对象并返回，LambdaExpression可以简化成 ClassName::new
     * 构造器参数列表要与FunctionalInterface中抽象方法参数列表一致，通过参数列表确定调用构造器
     *
     * Object类中方法
     * equals	判断当前对象与参数对象是否相同，Object类中eqauls方法使用==运算符进行判断；
     * 子类可重写Object类中方法，自定义相等条件，但必须同时重写hashCode方法，确保对象相等时，散列值也相等
     * hashCode	返回对象散列值，Object类中hashCode方法返回对象内存地址的十六进制表现形式
     *
     * 可变参数
     * 当无法确定方法参数列表中某种类型参数个数时可以使用可变参数
     * 可变参数在参数类型后添加省略号，等价于数组类型参数
     * 可变参数必须是参数列表中最后一个参数
     * 当不传递可变参数时，编译器会将null作为实际参数
     */
}
