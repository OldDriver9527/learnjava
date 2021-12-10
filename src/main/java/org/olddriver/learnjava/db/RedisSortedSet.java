package org.olddriver.learnjava.db;

/**
 * redis 有序集合
 * 20211207
 * 第七部分
 */
public class RedisSortedSet {
    /**
     * 集合中元素不允许重复，对元素按score升序排序
     * sorted set组命令
     * 向集合中添加元素
     * zadd key score member
     *
     * 正向获取value
     * zrange key start end
     *
     * 反向获取value
     * zrevrange key start end
     *
     * 集合操作中相同成员的分值进行聚合，可以求和或取较小值或取较大值
     * sorted set使用skip list实现
     *
     *
     */
}
