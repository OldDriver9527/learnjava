package org.olddriver.learnjava.designpattern.singleton;

/**
 * 20201108
 * 懒汉式，双重检验锁
 */
public class SingletonDCL {

    /**
     * 懒汉式实例引用volatile修饰禁止cpu乱序执行指令或编译器在编译时对指令重新排序，防止创建对象指令被重新排序，其他线程获取到未初始化完毕实例
     * synchronized无法禁止指令重排序
     */
    private static volatile SingletonDCL instance;

    private SingletonDCL() {
        super();
    }

    public static SingletonDCL getInstance(){
        if(instance == null){
            synchronized (SingletonDCL.class){
                if(instance == null){
                    instance = new SingletonDCL();
                }
            }
        }
        return instance;
    }
}
