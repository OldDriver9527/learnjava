package org.olddriver.learnes;

/**
 * es 脚本
 * 20211119
 * 第七部分
 */
public class Script {
    /**
     * 通过脚本操作数据更加方便
     * es支持多种脚本语言，Painless，Expression
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
     */
}
