package org.olddriver.learndatastructure;

public class Tree {
    /**
     * b树(多路平衡查找树)
     * b树是一种多叉(一个结点可以对应多个子节点)平衡树(子树高度差小于等于1)。m阶(度)b树特点
     * i.每个结点最多m个子节点
     * ii.结点最多可以存储m-1个键值对，按key升序排序。key为索引，data为数据
     * iii.结点中的第i个key大于等于其第i个子结点的所有key，小于等于其第i+1个子节点的所有key
     *
     * b+树
     * b+树是b树的变形形式。
     * 数据仅存储在叶子结点，非叶子结点中不存储数据
     * 查找时一个数据页可以包含更多索引
     */
}
