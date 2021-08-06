package org.olddriver.learnjava.jvm;

public class JVM {
    /**
     * jvm
     * 一套抽象规范，存在多种实现。hotspot为oracle实现。
     *
     * class文件(字节码文件)
     * 二进制字节流，存储源文件中所有信息，会将方法中语句转换为jvm指令(汇编语言)
     *
     * 文件结构
     * 魔数 magic
     * 表示当前文件为字节码文件，字节码文件魔数为0xCAFEBABE。占4byte
     * 副版本号 minor_version
     * 表示jdk小版本，占用2byte，jdk8对应minor_version为0
     * 主版本号 major_version
     * 表示jdk大版本，，占用2byte，jdk8对应major version为52
     * 常量池计数器 constant_pool_count
     * 表示常量池中元素个数，常量池中共 constant_pool_count - 1个元素
     * 占2字节，常量池中最多65535个元素
     * 常量池表
     * 实际为数组，索引值从1开始，到constant_pool_count - 1结束
     * 常量池中每个元素首字节表示元素类型，元素所占字节不一致
     * 访问标志 access_flags
     * 表示一些关键字的类型，占2byte
     * 类索引 this_class
     * 为常量池索引，索引对应成员为当前类型名称。占2byte
     * 父类索引 super_class
     * 为常量池索引，索引对应成员为当前类型父类型名称。占2byte
     * 接口计数器 interfaces_count
     * 当前类型实现接口个数，占2byte
     * 接口表
     * 域计数器 fields_count
     * 当前类型中包含的域个数，占2byte
     * 域表
     * 方法计数器 methods_count
     * 当前类型中包含的方法个数，占2byte
     * 方法表
     * 存储方法信息，方法语句对应jvm指令存储在属性表中
     * 属性计数器 attributes_count
     * 当前类型属性表中元素个数，占2byte
     * 属性表
     *
     * 常量池元素标志
     * 10   方法应用信息 methodref_info
     * 7    类信息 class_info
     * 1    字符串 utf8_info，字符串<init>表示构造器名称
     *
     * 类加载
     * 类加载过程包括加载，连接，初始化三步
     * 加载
     * 通过类加载器将字节码文件中二进制字节流读取到方法区，并创建一个Class对象，通过Class对象访问方法区中的内容
     * 类加载器分为四个层次
     * Bootstrap类加载器位于顶层，加载rt.jar，charset.jar等核心类，使用cpp编写
     * 当获取类加载器为null时，类就是由Bootstrap类加载器加载
     * Extension类加载器位于第二层，加载jdk扩展包中的类(jre\lib\ext)
     * App类加载器位于第三层，加载classpath中的类
     * 自定义类加载器位于第四层
     * 上层类加载器称为下层类加载器的父加载器，与继承无关
     * 类加载的双亲委派机制
     * 加载类时，会按类加载器的层次自底向上判断是否已经加载当前类。若所有类加载器均没有加载当前类，顶层类加载器会尝试加载此类，
     * 若加载不成功，委托给下一级类加载器，直到委托到最后一级类加载器。若所有类加载器均没有加载成功，抛出异常
     * 双亲委派机制增加了类加载的安全性，重写loadClass方法可以打破双亲委派
     * 自定义类加载器
     * i.继承ClassLoader，重写findClass方法
     * 连接
     * 校验   检查字节码文件结构是否正确
     * 准备   声明类变量，使用默认值初始化
     * 解析   将常量池表中符号引用(类名，方法名)解析成地址
     * 初始化
     * 执行类中类变量初始化器，静态初始化器为类变量初始化
     *
     * bytecode解释器，jit
     * jvm执行引擎中包含解释器和即时编译器，解释器将字节码解释为机器码，效率较低。当一段代码执行频率很高，jvm会将其使用jit编译为
     * 机器码提高运行速度
     * 可通过jvm参数控制运行模式，混合模式，解释模式，编译模式
     */
}
