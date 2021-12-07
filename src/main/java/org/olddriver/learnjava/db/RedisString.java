package org.olddriver.learnjava.db;
/**
 * redis string
 * 20211206
 * 第三部分
 */
public class RedisString {
    /**
     * select index
     * 通过索引切换库，redis分为16个库，index从0到15
     * flushall
     * 移除所有数据库中key
     *
     *
     * string组命令
     * 设置键值对(添加键值对或覆盖键值对)
     * set key value [nx|xx]
     * nx--key不存在才允许设置
     * xx--key存在才允许设置
     *
     * 批量设置键值对
     * mset key value key value
     *
     * 获取值  get key
     * 批量获取值    mget key key
     *
     * 追加(对旧value进行追加)
     * append key value
     *
     * 获取指定范围内value
     * getrange key start end
     *
     * 设置部分value值
     * setrange key offset value
     *
     * 计算value长度(占用字节数)
     * strlen key
     *
     * 覆盖value值并返回旧值
     * getset key
     *
     * 批量新增键值对，具有原子性
     * msetnx key value key value
     *
     * 通用组命令
     * type key
     * 查看对应value类型
     *
     * string组中数值操作
     * 加一操作 incr
     * 减一操作 decr
     *
     * string组中位图操作，操作二进制位
     * 设置value的部分二进制位
     * setbit key offset value
     *
     * 查找指定位在value中第一次出现的位置
     * bitpos
     *
     * 统计value中位1的个数
     * bitcount
     *
     * 位运算，结果存入指定key
     * bitop
     */
}
