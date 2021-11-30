package org.olddriver.learnelkb.es;

/**
 * 批量操作
 * 20211119
 * 第六部分
 */
public class BatchOperation {
    /**
     * mget 根据id批量查询
     * /index/_mget
     * {
     *   "docs": [
     *     {
     *       "_id": "1"
     *     },
     *     {
     *       "_id": "2"
     *     }
     *   ]
     * }
     *
     * bulk 根据id批量增删改操作
     * create   强制创建，若数据存在返回异常
     * delete   删除
     * index    创建或全量修改
     * update   全量修改或部分修改
     * /_bulk
     * {"create":{"_index":"test","_id":"1"}}
     * {"fieldname":"value","fieldname":"value"}
     * {"create":{"_index":"test","_id":"2"}}
     * {"fieldname":"value","fieldname":"value"}
     * /_bulk
     * {"delete":{"_index":"test","_id":"1"}}
     * /_bulk
     * {"index":{"_index":"test","_id":"1"}}
     * {"fieldname":"value","fieldname":"value"}
     * /_bulk
     * {"update":{"_index":"test","_id":"1","retry_on_conflict":""}}
     * {"doc":{"fieldname":"value"}}
     * retry_on_conflict    冲突时重试次数
     */
}
