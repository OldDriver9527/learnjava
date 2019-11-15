package org.olddriver.learnjava.oo;

public class Polymorphism {
    /**
     * 多态	Polymorphism
     * 多态指子类中既能定义特有内容，又能分享父类中共有内容
     *
     * 多态体现
     * 将子类对象地址赋值给父类或接口类型引用
     *
     * 成员方法动态绑定
     * 子类对象向上转型后，通过子类对象，调用父类中非static，非final，非private方法。编译器在编译时期不会判断对象
     * 实际类型，仅会根据引用变量类型检查方法参数及返回值类型；在运行时，编译器会判断对象实际类型建立方法调用与
     * 真正方法体的关联
     *
     * 成员方法静态绑定
     * 子类对象向上转型后，通过子类对象，调用父类中static，private，final成员方法，编译器在编译时期根据引用变量类型
     * 建立方法调用与方法体之间的关联
     */
}