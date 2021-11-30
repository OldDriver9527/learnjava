package org.olddriver.learnelkb.es;

/**
 * es 脚本
 * 20211119
 * 第七部分
 */
public class Script {
    /**
     * 通过脚本操作数据更加方便
     * es支持多种脚本语言，painless，expression(Lucene)，mustache，java
     *
     * 执行修改操作
     * /index/_update/id
     * {
     *     "script":{
     *         "lang":"",
     *         "source":"",
     *         "params":{
     *             "param_name":"param_value"
     *         }
     *     }
     * }
     * lang--指定脚本类型，painless
     * source--具体内容
     *         脚本中通过ctx获取字段，ctx._source.fieldname
     * params--参数，在source中通过params.param_name获取参数值
     *
     * 执行删除操作
     * /index/_update/id
     * {
     *     "script":{
     *         "lang":"painless",
     *         "source":"ctx.op='delete'",
     *     }
     * }
     *
     * 新增和修改脚本二选一执行
     * /index/_update/id
     * {
     *     "script":{
     *         "lang":"",
     *         "source":"",
     *         "params":{
     *             "param_name":"param_value"
     *         }
     *     },
     *     "upsert":{
     *          "fieldname":"value"
     *     }
     * }
     * 若指定id存在执行脚本修改
     * 若指定id不存在执行新增操作
     *
     * 执行查询操作，返回自定义字段
     * {
     *     "script_fields":{
     *         "fieldname":{
     *             "script":{
     *                 "lang":"painless",
     *                 "source":"doc['price'].value*params.discount",
     *                 "params":{
     *                     "discount":0.9
     *                 }
     *             }
     *         }
     *     }
     * }
     * 通过doc['fieldname']方式获取字段值，对于text类型字段使用doc['fieldname.keyword']方式获取字段值
     * params['_source']['fieldname']???
     * 使用painless脚本时需添加value属性获取字段值
     * 可以在script_fields中定义多个字段
     * 可以在脚本中计算多个字段，使用，分割
     *
     * 创建公共脚本，整个集群有效
     * _scripts/script_id
     * {
     *     "script":{
     *          "lang":"painless",
     *          "source":"doc['price'].value*params.discount"
     *     }
     * }
     *
     * 使用公共脚本查询
     * {
     *     "script_fields":{
     *         "fielaname":{
     *             "script":{
     *                 "id":"script_id",
     *                 "params":{
     *                     "param_name":""
     *                 }
     *             }
     *         }
     *     }
     * }
     *
     * 获取时间字段内容
     * {
     *     "script_fields":{
     *         "fieldname":{
     *             "script":{
     *                 "lang":"painless",
     *                 "source":"doc['createtime'].value.year"
     *             }
     *         },
     *         "fieldname":{
     *             "script":{
     *                 "lang":"painless",
     *                 "source":"doc['createtime'].value.dayOfWeek"
     *             }
     *         },
     *     }
     * }
     *
     * 在source中使用""" """定义多行脚本，语法类似java
     *
     * 聚合查询中使用脚本
     *
     * es写入原理
     *
     */
}
