package org.olddriver.learnelkb.es;

/**
 * 映射
 * 20211118
 * 第四部分
 */
public class Mapping {
    /**
     * 映射是定义字段的过程，决定字段一系列元数据
     * 查看索引mapping方式    index/_mapping
     *
     * 动态映射 Dynamic mapping
     * 添加数据时，es自动分析数据类型等属性
     * 字符串会被定义为text类型
     * 不带小数点整数会被定义为long类型，选取范围较大的类型
     * 带小数点实数会被定义为double类型(实际会被定义为float类型)
     * true，false会被定义为boolean类型
     * 日期会被定义date类型
     *
     * 数据类型分类
     * exact value  精确值，不进行分词，整个字段作为整体建立索引
     *              keyword类型属于精确值
     * full text    全文
     *
     * 数据类型
     * text
     * keyword
     * 数字类型
     * date
     * Object   对象类型
     * Nested   数组类型
     *
     * 显式映射 Explicit mapping
     * 手动创建mapping
     * index
     * {
     *     "mappings":{
     *         "properties":{
     *             "fielaname":{
     *                 "mapping_parameter":""
     *             }
     *         }
     *     }
     * }
     * mapping parameter
     * index    是否对当前字段创建索引，默认为true
     *          若不创建索引，不能通过当前字段进行搜索
     * analyzer 分析器
     * boost
     * coerce   是否允许类型转换，字符串转数字
     * copy_to  将当前字段中值拷贝到指定字段中，对指定字段进行查询相当于查询多个字段
     * doc_values   是否创建正排索引，排序及聚合查询时使用正排索引
     *              text类型doc_values默认值为false，不支持排序和聚合查询
     * dynamic  是否可以动态添加字段
     *          true
     *          false
     *          strict
     * eager_global_ordinals
     * enable   是否创建倒排索引
     * fielddata    text类型字段默认不支持排序，聚合。
     *              将fielddata修改为true后，临时在内存中创建正排索引，可进行排序，聚合操作。
     *              但性能较差
     * fields   创建多字段，不同字段使用方式不同
     *          text类型字段默认创建keyword类型的多字段
     *          text类型用于全文检索
     *          keyword类型用于排序，聚合操作
     * norms    是否禁用评分
     * search analyzer  设置查询时分析器
     * similarity   设置相关度算法
     * ignore above 超长忽略
     *
     * 正排索引
     */
}
