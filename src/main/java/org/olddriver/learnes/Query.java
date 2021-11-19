package org.olddriver.learnes;

/**
 * Elasticsearch查询
 * 20211117
 * 第三部分
 */
public class Query {
    /**
     * 查询超时机制
     * 当查询用时超过设置的超时事件，会停止查询，返回部分数据
     * 通过 _search?timeout=1s(get)设置超时时间
     *
     * 通过query string查询
     * 指定查询条件
     * index/_search?q=querycondition
     * q--查询条件
     * 指定分页，排序
     * index/_search?from=0&size=2&sort=name:asc
     * from--起始位置
     * size--每页数据数量
     * sort--排序字段
     *
     * 通过dsl(Domain Specific Language)查询，参数位于请求体中
     * match all    匹配所有
     * index/_search
     * {
     *     "query":{
     *         "match_all":{}
     *     }
     * }
     * match    匹配查询，会对查询内容进行分词，分词后的内容作为词项进行全文检索(针对整个字段进行搜索)
     * index/_search
     * {
     *     "query":{
     *         "match":{
     *             "fieldname":""
     *         }
     *     }
     * }
     * multi match  多字段匹配查询，任意一个字段匹配即满足条件。规则与match一致
     * index/_search
     * {
     *     "query":{
     *         "multi_match":{
     *             "query":"content",
     *             "fields":["fieldname","fieldname"]
     *         }
     *     }
     * }
     *
     * sort 排序
     * index/_search
     * {
     *     "sort":{
     *         "fieldname":{
     *             "order":"asc"
     *         }
     *     }
     * }
     * source   指定结果中字段
     * {
     *     "_source":["fieldname","fieldname"]
     * }
     * from size    分页查询
     * {
     *     "from":0,
     *     "size":10
     * }
     *
     * term 词项查询，不对查询内容进行分词，将搜索内容作为词项
     * {
     *     "query":{
     *         "term":{
     *             "fieldname":{
     *                 "value":""
     *             }
     *         }
     *     }
     * }
     * terms    多词项查询，将多个搜索内容作为词项进行查询。规则与term一致
     * {
     *     "query":{
     *         "terms":{
     *             "fieldname":["",""]
     *         }
     *     }
     * }
     *
     * match phrase  短语匹配，将查询内容作为短语并非词项进行全文检索
     * {
     *     "query":{
     *         "match_phrase":{
     *             "fielaname":""
     *         }
     *     }
     * }
     * range    范围查询
     * {
     *     "query":{
     *         "range":{
     *             "fieldname":{
     *                 "gt":xx
     *             }
     *         }
     *     }
     * }
     * gt   大于
     * lt   小于
     * gte  大于等于
     * lte  小于等于
     *
     * bool 复合查询
     * must 必须满足的条件，指定的若干条件必须同时满足(相当于多个条件and连接)
     * filter   过滤器，不计算相关度分数，比query性能高
     * should   应当满足的条件，指定的若干条件满足一个即可(相当于多个条件or连接)
     * minimum_should_match 配置should条件中最少匹配的条件个数
     * must not 必须不满足的条件
     *
     * constant score   包裹filter的一种查询
     *
     * highlight    高亮查询，将搜索关键字在指定字段中进行高亮处理
     * {
     *     "highlight":{
     *         "fields":{
     *             "fieldname":{}
     *         }
     *     }
     * }
     *
     * deep paging  深度分页问题
     * 进行分页查询时，若文档分散在不同节点的分片中。会在每个节点上取0 ~ from+size个文档，
     * 最终进行汇总取size条数据。十分消耗性能，数据量大时不建议使用()
     * scroll search
     * 通过scroll search可解决深度查询
     *
     * filter缓存？？？
     * filter执行一定次数后会进行缓存，缓存为一个数组，记录词项在文档中是否存在
     * filter一般在query之前执行，过滤部分数据，提高query速度
     */
}
