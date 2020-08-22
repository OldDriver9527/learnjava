package org.olddriver.learnjava.exception;

/**
 * 20200520
 * part 1
 */
public class Exceptions{
    /*
     * 异常
     * 程序运行时违反java语法约束，jvm将该错误标识为异常，抛出异常对象
     *
     * 异常种类
     * Throwable及其子类表示异常
     * Exception和Error是Throwable子类
     * Exception是普通程序希望恢复异常的父类
     * RuntimeException是Exception子类，称为运行时异常，是在计算表达式期间因各种原因抛出的异常
     * Error是普通程序不指望恢复异常的父类，称为错误类
     * 非受检异常类指运行时异常以及错误类
     * 受检异常指除了非受检异常以外的异常类
     *
     * 异常成因
     * i.执行throw语句
     * ii.java虚拟机同步探测到反常执行情况，异常作为表达式计算结果或语句执行结果被抛出
     * iii.发生异步异常
     *
     * 异常处理方式
     * 要么使用throws语句声明方法可能抛出的受检异常，要么使用try语句捕获异常
     *
     * 异常编译时检测
     * java要求若程序中抛出受检异常，程序中必须存在异常处理器，否则编译不通过
     * 当方法或构造器中throw受检异常，若该异常未在throws语句中声明，编译不通过
     * 当lambda体throw受检异常，若该异常未在抽象方法throws语句中声明，编译不通过
     * 当静态初始化器或类变量初始化器中throw受检异常，编译不通过
     * 当实例初始化器或实例变量初始化器中throw受检异常，除非所有构造器均throws该异常，否则编译不通过
     *
     * 异常运行时处理
     * 程序运行时抛出异常，控制流从异常发生的位置转移到能够处理该异常最近的catch子句中
     *
     * try语句
     * 由try块，catch子句，finally块构成
     * catch子句中定义异常参数，jdk7之前只能定义一个异常类型，jdk7以后可以定义多个异常类型，多个类型间使用|分隔
     *
     * try-catch执行
     * 先执行try块，
     * 若try块正常结束，不执行catch子句，try语句正常结束
     * 若try块抛出异常，
     * 当异常类型与catch子句参数类型匹配，控制流转移到catch子句。若catch子句正常结束，try语句正常结束；若catch子句猝然结束，try语句猝然结束
     * 当异常类型与catch子句类型参数不匹配，try语句猝然结束
     *
     * try-catch-finally执行
     * 先执行try块，
     * 若try块是正常结束，不执行catch子句，执行finally块。finally块正常结束，try语句正常结束；finally块猝然结束，try语句猝然结束
     * 若try块抛出异常，
     * 当异常类型与catch子句参数类型匹配，控制流转移到catch子句。
     * 若catch子句正常结束，执行finally块，finally块正常结束，try语句正常结束；finally块猝然结束，try语句猝然结束
     * 若catch猝然结束，执行finally块。若finally正常结束，try语句因catch子句原因猝然结束；若finally猝然结束，try语句因为finally块的原因猝然结束
     * 当异常类型与catch子句类型参数不匹配，执行finally块。
     * 若finally块正常结束，try语句因为try块原因猝然结束；若finally块猝然结束，try语句因为finally块原因猝然结束
     *
     * try块，catch子句，finally块中return语句
     * catch子句，finally块中return语句会覆盖之前return语句
     * 在try块中使用return返回返回值，在catch子句，finally块中对返回值进行修改
     * return语句会将返回值存储到新局部变量中返回，
     * 当返回值类型是基本类型，在catch子句，finally块中对原局部变量进行修改，不影响新局部变量值
     * 当返回值类型是引用类型，在catch子句，finally块中对原局部变量进行修改，影响新局部变量值
     *
     * 带资源的try语句
     * try(ResourceList){}，catch子句，finally块可省略
     * 资源列表中可以定义一个或多个局部变量，资源隐式final修饰
     * 资源在try块执行之前初始化，在try块执行完毕后自动关闭
     * 资源必须实现AutoCloseable接口
     *
     * 异常链(Chained Exceptions)
     * 捕获旧异常后，希望抛出新类型异常同时保留旧异常信息，使用到异常链
     * Throwable类中initCause方法以及接收Throwable类型参数构造器可用于创建链式异常
     *
     * 栈轨迹
     * 从方法调用处到异常发生位置的方法调用序列
     */
}
