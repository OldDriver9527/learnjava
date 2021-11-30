package org.olddriver.learnjava.introduction;

/**
 * 20210630
 * java 导论
 * 第一部分
 */
public class Java {
    /**
     * 计算机语言发展历史
     * 机器语言
     * 汇编语言
     * 高级语言
     *
     * java核心优势
     * 跨平台，不依赖于操作系统。
     * java编译器将java源文件编译为字节码文件，不同平台之上的JVM实例将字节码解释成机器码，在cpu上运行。
     *
     * JVM java virtual machine
     * jvm是一种规范，存在多种实现。jvm实例是一个虚拟的计算机，将字节码解释为机器码在操作系统上执行
     *
     * jdk安装
     * jdk12不会提示安装jre，可手动安装
     * 进入jdk安装目录，执行
     * bin\jlink.exe --module-path jmods --add-modules java.desktop --output jre
     * 在jdk安装目录下生成jre目录
     *
     * helloworld
     * javac命令编译源文件
     * -d选项指定生成字节码文件路径
     * 若指定，生成文件位置为path/packagename
     * 若不指定，字节码文件与源文件位于相同目录中
     * java命令指定字节码文件
     * -cp选项指定classpath(寻找字节码文件路径)
     * 若不指定classpath，在当前路径/packagename下寻找字节码文件
     * 若指定classpath，按classpath/packagename下寻找字节码文件
     *
     * .java文件称为一个编译单元，其中包含package声明，import声明，类型声明
     * 一个编译单元中可声明多个类型，但只能有一个类型使用public修饰
     * 编译单元的名称必须和公共类型名称一致
     */
}
