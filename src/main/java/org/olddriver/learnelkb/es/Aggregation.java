package org.olddriver.learnelkb.es;

/**
 * 聚合操作
 * 20211119
 * 第五部分
 */
public class Aggregation {
    /**
     * 聚合操作分为三类
     * 指标(Metric)聚合 计算平均数，合计等指标
     * 桶(Bucket)聚合  对数据进行分组
     * 管道(Pipeline)聚合   一个聚合的结果作为另一个聚合的输入
     *
     * 聚合操作
     * {
     *     "aggs":{
     *          "agg_name":{
     *              "agg_type":{
     *
     *              }
     *          }
     *     }
     * }
     *
     * 聚合类型
     * 桶聚合操作
     * terms    按字段值分组，相同词项的文档为一组
     * range    按字段值范围分组
     * histogram    按字段值区间分组
     * date_histogram   按日期区间分组
     * 指标聚合操作
     * value_count  计算值总数
     *
     * 子聚合
     * 在聚合操作中嵌套聚合操作，如在桶聚合中嵌套指标聚合
     *
     * 在聚合操作前添加query查询，可减小聚合操作的数据范围
     * 设置 "size":0，不返回查询结果，仅返回聚合操作结果
     */
}
