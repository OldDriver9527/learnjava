package org.olddriver.learnes;

/**
 * Elasticsearch
 * 20211114
 * 第二部分
 */
public class Elasticsearch {
    /**
     * 搜索引擎
     * 全文搜索引擎
     * 垂直搜索引擎
     *
     * luence
     * 倒排索引
     * 在检索过程中，
     * 正排索引需遍历全部数据，逐一判断数据中是否包含检索内容
     * 而倒排索引预先对字段中的内容进行拆分，拆分为词项(Term)。对词项建立索引，通过词项最终定位到完整数据
     * 倒排索引由词项字典(Term Dictionary)，倒排文件，词项索引(Term Index)组成
     * 词项字典中维护词项和对应倒排列表(Posting List)的地址
     * 倒排列表存储在倒排文件中，由倒排项组成的列表。
     * 倒排项中可以包含词项所在文档id及词项在文档中出现的频率及词项在文档中出现的若干个具体位置
     *
     * 倒排列表的压缩算法
     * Frame Of Reference
     * i.使用增量编码(delta-encoding，相邻数据相减，后一个数据减去前一个数据)的方式将存储的数据变小
     * ii.将差值分割为若干组
     * iii.计算每组差值中最大值需占用的bit位数，作为头信息使用1byte存储在首部，将组中差值使用指定bit数存储
     * Roaring bitmaps
     * 将一个Integer类型数据分为高16位和低16位两个Short类型数值，
     * 使用高16位作为索引决定低16位存储的Container，Container中存储低16位值
     * 高16位索引和Container均存储在数组中且一一对应
     * Container分为array container，bitmap container，run container
     * 当Container中元素个数小于4096，使用array container
     * 当Container中元素个数大于4096，使用bitmap container
     * run container存储连续元素
     *
     * fst(Finite State Transducers)
     * 有限状态转换器，luence中使用的一种存储键值对数据结构
     *
     * 搜索引擎类数据库
     */
}
