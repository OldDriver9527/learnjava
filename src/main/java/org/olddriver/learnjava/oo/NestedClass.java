package org.olddriver.learnjava.oo;

/**
 * 20200808
 * 嵌套类
 * 第十一部分
 */
public class NestedClass {
    /**
     * 嵌套类
     * 嵌套类字节码文件以OuterClass$NestedClass命名
     *
     * 创建嵌套类对象
     * 创建静态嵌套类对象时不需要外部类对象
     * OuterClass.StaticNestedClass nestedObject = new OuterClass.StaticNestedClass();
     * 创建内部类对象需要依赖外部类对象
     * OuterClass.InnerClass innerObject = outerObject.new InnerClass();
     *
     * 继承嵌套类
     * 子类继承非static嵌套类，嵌套类依赖于外部类对象，必须在子类构造器参数列表中传入外部类对象，在构造器中通过外部类对象调用super方法访问嵌套类构造器
     *
     * 匿名类
     * 匿名类声明和实例化同时进行。匿名类是指定类或接口的子类
     *
     * 内部类中不能声明static成员，除非将内部类转换成static嵌套类
     */

    static class StaticInner{

    }

    class Inner{

    }


    class Demo extends NestedClass.Inner{
        public Demo(NestedClass o) {
            o.super();
        }
    }


    public static void main(String[] args) {
        NestedClass.StaticInner inner = new NestedClass.StaticInner();

        NestedClass.Inner i = new NestedClass().new Inner();

    }
}
