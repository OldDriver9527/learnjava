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
     * 数据文件中存储数据页，数据库以数据页为单位进行读写操作，数据包含在数据页中
     * 索引文件也存储数据页，内存中b+树的叶子节点会指向索引文件中的数据页
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
     *
     */
}
