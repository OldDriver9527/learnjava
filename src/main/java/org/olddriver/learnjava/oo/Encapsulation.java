package org.olddriver.learnjava.oo;

/**
 * 20200428
 * part 2
 */
public class Encapsulation {
    /*
     * 封装	Encapsulation
     * i.将成员变量，成员方法包裹在类中，隐藏成员变量，仅对外暴露公共成员方法
     * ii.封装实现方式
     * 将成员变量使用private修饰
     * 提供公共get，set方法获取和修改成员变量值
     * iii.封装好处
     * 类的使用者无法触及类中隐藏的部分
     * 类的开发者对类中隐藏部分进行修改不会影响类的使用者
     *
     * 访问权限修饰符
     * java中存在三种访问权限修饰符，public，protected，private
     * 将访问权限分为四种，私有访问权限，包访问权限，继承访问权限，公共访问权限
     * 私有访问权限		被private修饰的成员具有私有访问权限，私有访问权限的成员仅能在当前类中被调用
     * 					内部类中private成员，可以在外部类及内部类中被调用？？？
     * 包访问权限		不使用访问权限修饰符修饰的成员具有包访问权限，
     *                  包访问权限的成员能够在当前类中被调用，在当前包中被调用
     * 继承访问权限		被protected修饰的成员具有继承访问权限，
     *                  继承访问权限的成员能够在当前类中被调用，在当前包中被调用，在当前类的子孙类中被调用
     * 公共访问权限		被public修饰的成员具有公共访问权限，公共访问权限的成员能够在任意位置被调用
     *
     * 包 package
     * 相关类型的分组
     * i.创建包
     * 包使用package语句声明，package语句必须是源文件中第一行非注释代码；每个源文件中只能包含一个package语句
     * package语句会应用于源文件中所有类型，源文件中可以包含多个类型，即类，接口，枚举，注解，但只能有一个被public修饰
     * 且public成员必须与源文件同名
     * ii.使用包成员
     * 在类中使用包成员可以通过三种方式，
     * 1.通过全限定名引用成员
     * 2.使用import语句导入指定包成员
     * 3.使用import语句导入包中所有成员
     * 方式3只能导入指定包中所有成员，不能导入成员子集，不能导入子包中所有成员
     * java编译器在源文件中自动导入两个包中的所有成员，即java.lang包及当前包
     * iii.静态导入
     * 使用import static语句，可以导入类中常量和静态方法
     * 使用静态导入不便于阅读
     *
     * classpath
     * 编译器和java虚拟机寻找字节码文件的根目录
     * 不建议设置classpath环境变量，而是将classpath作为参数传入
     *
     * jar
     * 实际是zip压缩文件
     * jar包中/META-INF/MANIFEST.MF文件可以定义启动类名称，不再需要运行jar文件时指定启动类名称
     */
}