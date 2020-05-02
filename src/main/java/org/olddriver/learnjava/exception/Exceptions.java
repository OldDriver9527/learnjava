package org.olddriver.learnjava.exception;
/**
 * 20200520
 * part 1
 */
public class Exceptions {
    /*
     * 异常种类
     * Throwable及其子类表示异常
     * Exception和Error是Throwable子类
     * Exception是普通程序希望恢复异常的父类
     * RuntimeException是Exception子类，称为运行时异常，是在计算表达式期间因各种原因抛出的异常
     * Error是普通程序不指望恢复异常的父类，统称为错误类
     * 非受检异常类指运行时异常以及错误类
     * 受检异常指除了非受检异常以外的异常类
     * 异常成因
     * 异步异常
     *
     *
     */

    public static void main(String[] args) {
        throw new OutOfMemoryError();
    }
}
