package org.olddriver.learnes;

/**
 * 分词器
 * 20211121
 * 第八部分
 */
public class Tokenizer {
    /**
     * 分析器(analyzer)
     * 包含字符过滤器(character filters)，分词器(tokenizer)，分词过滤器(token filters)
     * 字符过滤器负责对字符序列中的内容进行添加，移除，修改。一个分析器中可以有0个或多个字符过滤器
     * 分词器负责对字符序列进行拆分，分解为若干分词
     * 分词过滤器负责对分词序列进行添加，修改，移除分词
     * 在对文本字段创建索引时及分析查询字符串时会使用分析器
     *
     * 字符过滤器种类
     * html_strip   移除文本中html标签
     * mapping      替换文本中指定字符
     * pattern_replace  替换文本中匹配正则的部分
     *
     * 分词过滤器种类
     * lowercase
     * stop 停用词
     * ngram
     *
     * 分词器种类
     * standard 默认分词器，中文逐字拆分
     *
     * ik分析器插件，用于中文分词
     * i.在es plugins目录下创建ik目录
     * ii.打包ik项目，将releases目录下压缩包中的内容拷贝到ik目录
     * iii.重启es
     * ik分析器config目录中包括中文词库，英文词库等配置文件
     * ik分析器中包含两种分析器，ik_max_word(细粒度)，ik_smart(粗粒度)
     * 可以将数据库中数据添加到拓展词库中
     *
     * 配置内置分析器
     * /index
     * {
     *     "settings":{
     *          "analysis":{
     *              "analyzer":{
     *                  "analyzer_name":{
     *                      "tokenizer":"",
     *                      "filter":[]
     *                  }
     *              }
     *          }
     *     }
     * }
     * analysis--用于配置分析器，其中可以配置字符过滤器，分词器，分词过滤器，分析器
     *          analyzer用于配置分析器
     *          char_filter用于配置字符过滤器
     * tokenizer--配置分词器
     * filter--配置分词过滤器
     *
     * 对指定文本进行分析，返回结果
     * /index/_analyze
     * {
     *     "analyzer":"analyzer_name",
     *     "text":""
     * }
     *
     * 配置自定义分析器
     * /index
     * {
     *     "settings":{
     *          "analysis":{
     *              "analyzer":{
     *                  "analyzer_name":{
     *                      "type":"custom",
     *                      "tokenizer":"",
     *                      "filter":[]
     *                  }
     *              }
     *          }
     *     }
     * }
     * 配置自定义分析器需要添加type属性
     *
     */
}
