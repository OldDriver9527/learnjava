package org.olddriver.learnjava.oo;

/**
 * 20200808
 * part 12
 */
public class NestedClass {
    /*
     * 嵌套类
     * 嵌套类字节码文件以OuterClass$NestedClass命名
     *
     * 创建嵌套类对象
     * 静态嵌套类创建对象时不需要外部类对象
     * OuterClass.StaticNestedClass nestedObject = new OuterClass.StaticNestedClass();
     * 内部类创建对象需要依赖外部类对象
     * OuterClass.InnerClass innerObject = outerObject.new InnerClass();
     *
     * 继承嵌套类
     * 子类继承嵌套类，必须在子类构造器参数列表中传入外部类对象引用，通过外部类对象引用调用嵌套类构造器
     *
     * 匿名类
     * 匿名类是一表达式，可以用于创建类子类对象或接口实现类对象
     * 匿名类由new操作符，接口名或类名，参数列表，类体构成
     *
     * 内部类中不能声明static成员，除非将内部类转换成static嵌套类
     */
}
