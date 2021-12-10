package org.olddriver.learnjava.db;

/**
 * redis 集合
 * 20211207
 * 第六部分
 */
public class RedisSet {
    /**
     * 集合中元素不可重复，不保证顺序
     * set组命令
     * 向集合中添加value
     * sadd key value
     *
     * 求两集合交集
     * sinter key key
     *
     * 求两集合交集，存入目的地集合
     * sinterstore destination key key
     *
     * 求两集合并集
     * sunion key key
     *
     * 求两集合并集，存入目的地集合
     * sunionstore destination key key
     *
     * 求两集合差集
     * sdiff
     *
     * 获取集合中随机成员
     * srandmember key count
     * count--成员个数，可正可负可0
     *        正数时，元素不重复。当count大于集合中元素个数，返回整个集合
     *        负数时，元素可重复。返回count个元素
     *        为0时，不返回
     *
     * 获取集合中随机成员，并移除
     * spop key
     */
}
