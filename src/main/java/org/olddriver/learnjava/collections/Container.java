package org.olddriver.learnjava.collections;

/**
 * 容器
 * 20200822
 * 第一部分
 */
public class Container {
    /**
     * 容器
     * 用于存储对象引用(容器只能存储引用数据类型)
     * 容器分为两大分支，
     * 一个分支继承Collection，引用指向实际对象；
     * 一个分支继承Map，其中存储的引用指向Entry对象，Entry对象中包含key value引用，分别指向键值对对象
     * Collection分支又存在三个分支List，Set，Queue。多线程优先考虑Queue，Queue中方法比List中方法更加友好
     *
     * 容器从最早线程安全版本(Vector，HashTable)发展到线程不安全版本(Arraylist，LinkedList)，之后又出现线程安全的版本以及并发版本
     * 新版本容器效率未必一定高于旧版本，需要通过实验验证
     *
     */
}
