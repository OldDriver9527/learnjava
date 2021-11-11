package org.olddriver.learnjava.jvm;

/**
 * 对象模型
 * 20210806
 * 第三部分
 */
public class ObjectModel {
    /**
     * 64位hotspot对象模型
     * 普通对象由四部分组成
     * 对象头  markword，占8byte
     * ClassPointer 指向Class对象指针，开启UseCompressedClassPointers选项占4byte，否则占8byte
     * 实例数据 即实例变量。对于引用数据类型，若开启UseCompressedOops选项，普通对象指针占4byte，否则占8byte
     * padding  确保对象大小为8倍数
     *
     * 数组对象由五部分组成
     * 对象头  markword，占8byte
     * ClassPointer 指向Class对象指针，开启UseCompressedClassPointers选项占4byte，否则占8byte
     * 数组长度，占4byte
     * 数组数据
     * padding  确保对象大小为8倍数
     *
     * 对象头内容
     * 2bit表示锁状态，表示无锁，轻量级锁，重量级锁，GC 标记，偏向锁
     * 对象头中其余内容根据锁状态的不同而不同
     */
}
