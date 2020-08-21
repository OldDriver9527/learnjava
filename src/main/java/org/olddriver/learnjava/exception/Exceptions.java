package org.olddriver.learnjava.exception;

/**
 * 20200520
 * part 1
 */
public class Exceptions{
    /*
     * 异常
     * 当程序违反java语法约束，jvm将该错误标识为异常
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
     * 异常编译时检测
     * java要求若程序中抛出受检异常，必须包含受检异常处理器，即throws语句或catch子句
     * 当方法或构造器中throw受检异常，若该异常未在throws语句中声明，编译不通过
     * 当lambda体throw受检异常，若该异常未在抽象方法throws语句中声明，编译不通过
     * 当静态初始化器或类变量初始化器中throw受检异常，编译不通过
     * 当实例初始化器或实例变量初始化器中throw受检异常，除非所有构造器均throws该异常，否则编译不通过
     *
     * 异常运行时处理
     * 抛出异常时，控制流从导致异常的代码转移到能够处理该异常最近的catch子句中
     *
     * try语句
     * catch子句中仅包含一个异常参数，异常参数类型可以是单一类型或联合类型，联合类型使用|分隔
     * 联合类型表示多种类型并集，联合类型的异常参数隐式final修饰
     * try-catch执行
     * 先执行try块，
     * 若try块正常结束，不执行catch子句
     * 若try块抛出异常，当异常类型与catch子句参数类型匹配，控制流转移到catch子句
     * 当异常类型与catch子句类型参数不匹配，try语句猝然结束
     * try-catch-finally执行
     * 先执行try块，
     * 若try块是否正常结束，不执行catch子句，执行finally子句
     * 若try块抛出异常，当异常类型与catch子句参数类型匹配，控制流转移到catch子句，再执行finally子句
     * 当异常类型与catch子句类型参数不匹配，执行finally子句，try语句猝然结束
     * try块，catch子句中return语句
     * return语句会将返回值存储到新局部变量中返回，
     * 当返回值类型是基本类型，在finally子句中对原局部变量进行修改，不影响新局部变量值
     * 当返回值类型是引用类型，在finally子句中对原局部变量进行修改，影响新局部变量值
     * 带资源的try语句
     * try(ResourceList){}
     * 资源列表中可以定义一个或多个局部变量
     * 资源隐式final修饰
     * 资源必须实现AutoCloseable接口
     * 资源会在try块执行前，按找声明顺序初始化；在try块执行完毕后，按照初始化相反顺序自动关闭
     * 异常链(Chained Exceptions)
     * 捕获旧异常后，希望抛出新类型异常同时保留旧异常信息，使用到异常链
     * Throwable类中initCause方法以及接收Throwable类型参数构造器可用于创建链式异常
     * 栈轨迹
     * 从方法调用处到异常发生位置的方法调用序列
     */
}
