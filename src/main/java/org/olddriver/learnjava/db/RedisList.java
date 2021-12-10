package org.olddriver.learnjava.db;

/**
 * redis 线性表
 * 20211207
 * 第四部分
 */
public class RedisList {
    /**
     * 用于作为栈，队列使用
     *
     * list组命令
     * 表左端添加value
     * lpush key ele ele
     *
     * 表右端添加value
     * rpush key ele ele
     *
     * 弹出表左侧元素
     * lpop key
     *
     * 弹出表右侧元素
     * rpop key
     *
     * 查看表中部分元素
     * lrange key start end
     *
     * 获取指定索引处value
     * lindex key index
     *
     * 修改指定索引处value
     * lset key index value
     *
     * 移除表中指定数量的特定元素
     * lrem key num ele
     * num--数量可正可负可0，正数从左侧开始计算，负数从右侧开始计算，等于0移除所有
     *
     * 在指定元素前后插入value
     * linsert key before|after ele value
     * ele--出现重复元素时，只会在一个元素前后插入
     *
     * 阻塞式弹出表左侧元素
     * blpop key timeout
     * timeout--超时时间
     * 连同key一同返回
     *
     * 移除指定范围外的元素
     * ltrim
     */
}
