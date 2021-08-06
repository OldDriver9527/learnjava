package org.olddriver.learnjava.designpattern.singleton;

/**
 * 20201108
 * 饿汉式
 */
public class Singleton {

    /**
     * 单例设计模式
     * 程序执行过程中，类仅存在一个实例。类自行创建该实例，自行管理该实例
     * 多例设计模式
     * 对单例模式的拓展，允许类存在有限个实例，多个实例由类自行创建，自行管理
     */


    private static Singleton instance = new Singleton();

    private Singleton() {
        super();
    }

    public static Singleton getInstance(){
        return instance;
    }
}
