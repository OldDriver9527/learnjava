package org.olddriver.learnjava.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 20200520
 * 异常
 * 第一部分
 */
public class Exceptions{
    /**
     * 异常
     * 程序运行中遇到违反java语法约束情况，jvm将创建异常对象。
     * 线程从异常发生的位置转移到能够处理异常的catch子句中，若不存在程序退出
     *
     * 异常层次结构
     * Throwable是所有异常类的父类
     * Exception和Error是Throwable子类
     * Exception是普通程序希望恢复异常的父类
     * Error是普通程序不指望恢复异常的父类，称为错误类
     * RuntimeException是Exception子类，称为运行时异常
     *
     * 异常分类
     * 非受检异常类指运行时异常以及错误类
     * 受检异常指除了非受检异常以外的异常类
     *
     * 异常成因
     * i.执行throw语句
     * ii.java虚拟机同步探测到反常执行情况，抛出异常对象
     * iii.发生异步异常
     *
     * 异常处理方式
     * 要么使用throws语句声明方法可能抛出的受检异常，要么使用try语句捕获异常
     *
     * 异常编译时检测
     * 编译时会对受检异常进行检测。若程序中可能抛出受检异常，必须对受检异常进行处理，否则编译不通过
     * 当方法或构造器中throw受检异常，若该异常未在throws语句中声明，编译不通过
     * 当lambda体throw受检异常，若该异常未在抽象方法throws语句中声明，编译不通过
     * 当静态初始化器或类变量初始化器中throw受检异常，编译不通过
     * 当实例初始化器或实例变量初始化器中throw受检异常，除非所有构造器均throws声明该异常，否则编译不通过
     *
     * 异常运行时处理
     * 程序运行时抛出异常，控制流从异常发生的位置转移到能够处理该异常最近的catch子句中
     *
     * try语句
     * 由try子句，catch子句，finally子句构成
     * catch子句中定义异常参数，jdk7之前只能定义一个异常类型，jdk7以后可以定义多个异常类型，多个类型间使用|分隔
     *
     * try-catch执行
     * 先执行try子句，
     * 若try子句正常结束，不执行catch子句，try语句正常结束
     * 若try子句抛出异常，
     * 当异常类型与catch子句参数类型匹配，控制流转移到catch子句。
     * 当异常类型与catch子句类型参数不匹配，不执行catch子句。将异常向上层抛出
     *
     * try-catch-finally执行
     * 先执行try子句，
     * 若try子句是正常结束，不执行catch子句，执行finally子句。
     * 若try子句抛出异常，
     * 当异常类型与catch子句参数类型匹配，控制流转移到catch子句。无论catch子句是否抛出异常之后都会执行finally子句。
     * 当异常类型与catch子句类型参数不匹配，执行finally块。
     *
     * try子句，catch子句，finally子句中return语句
     * catch子句，finally子句中return语句会覆盖之前return语句
     * return语句会将返回值存储到新局部变量中返回，
     * 若在try子句中使用return返回返回值，在finally子句中对返回值进行修改
     * 当返回值类型是基本类型，不影响返回值
     * 当返回值类型是引用类型，可能影响返回值
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

    public static void main(String[] args) {
        try(FileInputStream inputStream = new FileInputStream(new File(""))){

            if(true){
                throw new RuntimeException("");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
