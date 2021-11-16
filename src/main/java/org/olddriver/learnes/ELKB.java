package org.olddriver.learnes;

/**
 * elastic技术栈
 * 20211113
 * 第一部分
 */
public class ELKB {
    /**
     * elastic stack
     * Elasticsearch    基于json数据格式的分布式搜索分析引擎，提供搜索，聚合，大数据存储服务
     * Logstash         数据处理管道
     * Kibana           提供可视化界面
     * Beats            轻量级数据采集器
     *
     * Elasticsearch
     * 无需安装，运行bin目录下elasticsearch文件启动
     * 7.0以后的版本，在jdk目录中会包含jdk
     * 启动时参数
     * -E cluster.name  指定集群名称
     * -E node.name 指定节点名称
     * -E path.data 指定存放数据目录
     * -E path.logs 指定存放日志目录
     * Elasticsearch集群搭建
     * i.在一个项目中启动多个节点，多个节点共享配置文件
     * ii.将项目复制，一个项目对应一个节点，各个节点配置互不影响
     *
     * Kibana
     * 无需安装，运行bin目录下kibana文件启动
     * Kibana服务依赖于Elasticsearch服务，启动前需启动Elasticsearch服务
     *
     * elasticsearch-head
     * Elasticsearch客户端工具
     * elasticsearch-head依赖于node.js需提前安装node.js
     * 安装grunt-cli  npm install -g grunt-cli
     * 安装grunt  npm install grunt --save-dev
     * 克隆elasticsearch-head代码
     * 修改Gruntfile.js文件
     * 在elasticsearch-head目录下执行cnpm install(npm install过慢)
     * npm run start
     *
     * 基本概念
     * 索引   index   类比于关系型数据库中数据库
     * 类型   type    类比于关系型数据库中表，存储在index中
     * 文档   document    类比于关系型数据库中行，同一type下的document具有相同字段。es中的最小数据单元
     * 字段   field   类比于关系型数据库中字段，存储在document中
     * 分片   shard   es将一个index划分为多个shard
     *               shard分为primary shard(主分片)，replica shard(副本分片)
     *               replica shard是primary shard的副本，primary shard可以进行读写操作，replica shard只能进行读操作
     *
     * elasticsearch-head中集群健康值
     * green    集群健康，表示所有primary shard，replica shard均可用
     * yellow   所有primary shard可用，至少一个replica shard不可用
     * red      至少一个primary shard不可用
     */
}
