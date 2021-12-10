package org.olddriver.learnjava.db;

/**
 * redis
 * 20211204
 * 第二部分
 */
public class Redis {
    /**
     * 磁盘
     * 一个磁盘中包含若干盘片，每个盘片上划分出若干同心圆，即磁道。
     * 一个磁道中包含若干扇区，一扇区可存储512byte数据。
     * os进行一次磁盘io，交互最小数据单元称为块(簇)。块由若干扇区组成，一般是8个扇区，4K数据
     *
     * 数据页(data page)
     * 数据库进行磁盘内存交互的最小单位
     *
     * redis value的数据类型
     * string，hash，list，set，sorted set
     * value存在类型，可以获取value中部分数据，不必获取全量数据后解析
     *
     * redis安装(参考readme文件)
     * i.通过make命令对源文件进行编译，完成后会在src目录下生成可执行文件
     * ii.通过make install安装redis。将可执行文件加入指定目录，默认加入/usr/local/bin下
     *    配置环境变量
     * iii.执行utils下install_server.sh脚本，将redis配置为系统服务。
     * 在/etc/init.d目录下添加了redis脚本
     *
     * redis速度快的原因
     * socket从阻塞升级为非阻塞
     * select系统调用出现，通过select可以从多个文件描述符中选择可以读取数据的文件描述符读取数据
     *
     * 管道
     * 客户端将多个命令通过一次请求发送给服务端，服务端将多个响应一次返回
     * 通过管道可批量执行文件中命令
     *
     * 发布订阅
     * 作为消息中间件，实现发布订阅模型
     * 命令在pubsub组中
     *
     * 事务
     * 命令在transactions组中
     * 开启事务后，向服务端发送的命令会被加入队列，不会立即执行。当提交事务时，所有命令一同执行
     * 开启事务前可以监视value，当执行事务时若监视的值发生变化事务不执行
     *
     * 布隆过滤器
     *
     * 缓存数据回收策略
     * redis作为缓存，当内存不足会回收冷数据，使用lru，lfu两种算法
     * lru  最近最少使用，按时间淘汰
     * lfu  最近不经常使用，按频率淘汰
     *
     * key有效期
     * 为key设置有效期，读取数据不影响有效期，对数据进行修改会将有效期清空
     *
     * 缓存击穿，雪崩，穿透
     *
     * redis持久化方式
     * rdb(Redis Database)
     * 生成某个时点的内存数据快照，通过fork系统调用创建子进程。父子进程数据可见，但父进程对数据的修改子进程不可见
     * aof(Append Only File)
     * 将日志追加到文件进行持久化
     * aof与rdb同时开启时，会使用aof恢复数据
     * 为保证aof文件不会过大可以对文件进行重写，4.0之前会删除一些相互抵消的命令；4.0后会将rdb写入aof，之后再记录增量操作日志
     * 记录操作日志会进行磁盘io，拖慢redis速度
     *
     * save bgsave bgrewriteaof
     */
}
