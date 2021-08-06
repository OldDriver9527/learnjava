package org.olddriver.learnjava.designpattern.singleton;

public class SingletonStatic {

    /**
     * 静态单例写法，延迟创建实例
     */

    private static class Holder{
        private static final SingletonStatic instance = new SingletonStatic();
    }

    private SingletonStatic() {
    }

    public static SingletonStatic getInstance(){
        return Holder.instance;
    }
}
