package org.olddriver.learnelkb.es;

/**
 * Elasticsearch
 * 20211114
 * 第二部分
 */
public class Elasticsearch {
    /**
     * Elasticsearch
     * 基于lucene开发的搜索引擎类数据库
     *
     * 倒排索引？？？
     * es中核心概念，通过倒排索引可减少查找次数实现高速检索
     * 倒排索引预先对字段中的内容进行拆分，拆分为词项(Term)。对词项建立索引，通过词项定位文档id最终定位到完整数据
     * 倒排索引由词项字典(Term Dictionary)，倒排文件，词项索引(Term Index)组成
     * 词项字典中维护词项和对应倒排列表(Posting List)的地址
     * 倒排列表存储在倒排文件中，由倒排项组成的列表。
     * 倒排项中可以包含词项所在文档id及词项在文档中出现的频率及词项在文档中出现的若干个具体位置
     *
     * 基本概念
     * 集群   cluster
     * 节点   node
     * 字段   field
     * 文档   document    es中的最小数据单元，包含多个字段。
     * 类型   type    逻辑上的数据分类。type相同的document具有相同字段
     *                7.0版本每个索引只有一种类型，可以省略。8.0版本中将移除
     * 索引   index   相同或相似的文档集合
     * 分片   shard   es将一个index划分为多个shard
     *               shard分为primary shard(主分片)，replica shard(副本分片)
     *               7.0之前一个索引默认对应5个主分片，7.0之后一个索引默认对应1个主分片
     *               索引创建后，主分片个数不能修改，副本分片个数可以修改
     *               replica shard是primary shard的副本，primary shard可以进行读写操作，replica shard只能进行读操作
     *               每个分片都是一个lucene实例，都会创建倒排索引
     *               一个doc不可能同时存在于多个主分片中
     *
     * 开发模式，生产模式
     * es使用默认配置时为开发模式
     * 当修改集群相关配置时使用生产模式。生产模式下，会触发引导检查，检查不通过无法启动
     *
     * 集群健康值
     * green    集群健康，表示所有primary shard，replica shard均可用
     * yellow   所有primary shard可用，至少一个replica shard不可用
     * red      至少一个primary shard不可用
     * 集群健康信息
     * relocating_shards    迁移中分片数
     * initializing_shards  初始化分片数
     * unassigned_shards    未分配分片数
     *
     * 基本操作
     * 创建索引     index_name?param
     * 删除索引     index_name?param
     * 查询索引     _cat/indices
     * 插入文档     index_name/_doc/id {}
     * 添加数据，自动生成id  index_name/_doc {}
     * 查询文档     index_name/_doc/id
     * 查询所有文档   index_name/_doc/_search
     * 全字段替换数据  index_name/_doc/id {}
     * 修改指定字段   index_name/_doc/id/_update {"doc":{}}
     * 删除文档     index_name/_doc/id
     *
     * es高可用实现机制
     * 索引分片尽可能分配到多个节点
     * 同一索引内容相同的主分片和副本分片，同一索引内容相同的副本分片和副本分片不能同时位于同一节点
     * 不同索引分片可以位于同一节点
     *
     * 节点角色
     * master
     * 候选主节点，参与master选举
     * 集群中只能有一个主节点，尽量避免主节点作为数据节点使用，减轻主节点压力
     * node.master设置为true，将节点设置为候选主节点
     * voting_only
     * 仅投票节点，不参与master选举
     * 具有master角色的节点才能被标记为voting_only角色
     * coordinating
     * 协调节点，可转发请求，默认每个节点都是协调节点
     * data
     * 数据节点
     * node.data设置为true，将节点设置为数据节点
     * data_content
     * data_hot
     * data_warm
     * data_cold
     * data_frozen
     * ingest
     * 具有ingest角色的节点为预处理节点
     * ml
     * 机器学习节点
     * remote_cluster_client
     * transform
     * 转换节点
     *
     * 容灾机制(节点宕机，es开启容灾机制)
     * i.master选举(master节点宕机才会进行)
     * 在剩余节点中选举新master节点
     * ii.replica容错
     * master节点将丢失的主分片对应的副本分片提升为主分片
     * iii.尝试重启
     * master节点尝试重启故障节点
     * iiii.数据同步
     * 宕机节点重启完毕后，master节点将故障期间丢失的数据同步到故障节点
     *
     * master选举？？？
     * 触发条件
     * 投票过程
     * 参与投票的节点对候选主节点中clusterStateVersion最大的节点投票，
     * 当出现clusterStateVersion相同情况，对id最小的节点投票
     * 当票数超过一半选举成功
     *
     * 脑裂？？？
     * 由于网络原因，导致集群中出现两个master节点
     *
     * elasticsearch目录结构
     * bin目录下包含可执行文件
     * config目录存放elasticsearch配置文件
     * elasticsearch.yml中可配置集群名(默认为elasticsearch)，节点名(默认为主机名)
     * data目录存放数据文件，应配置到es项目以外防止数据丢失
     * log目录存放日志文件，应配置到es项目以外防止数据丢失
     * modules目录存放模块
     * plugins目录存放插件
     * 搜索引擎
     * 全文搜索引擎
     * 垂直搜索引擎
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
     */
}
