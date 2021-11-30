package org.olddriver.learnjava.db;

/**
 * 20210709
 * 数据库
 *
 */
public class MySql {
    /**
     * 关系型数据库
     * 使用表存储记录，不同表中记录根据一些冗余字段关联
     *
     * 术语
     * 列    存储的数据片段
     * 行    列的集合
     * 表    行的集合，可分为永久表，临时表，虚拟表
     *       永久表    使用ddl语句创建的表
     *       临时表    select语句返回结果
     *       虚拟表    视图
     * 主键   标识行唯一性的字段
     * 外键   用于关联其他表中记录的字段
     *
     * sql(sequel)
     * 用于操作关系表中数据语言，可以为分ddl(数据定义语言)，dql(数据查询语言)，...
     *
     * mysql中数据类型
     * 字符串类型
     * 定长字符串    char，最大长度为255字节，使用空格填充空位，保证长度固定
     * 变长字符串    varchar，最大长度为65535字节
     * 文本类型      text，最大存储65535字节
     * 中文本类型    mediumtext，最大存储16M
     * 长文本类型    longtext，最大存储4G
     * 同一个字符使用不同编码规则编码，占用字节数不同
     * 数值类型
     * 整数型
     * tinyint      取值范围[-128，127]
     * smallint     取值范围[-2^15，2^15-1]
     * mediumint
     * int      取值范围[-2^31，2^31-1]
     * bigint   取值范围[-2^63，2^63-1]
     * 浮点数型
     * float，double
     * 浮点数型实际存储近似值
     * 定点数型
     * decimal  decimal(m,d)    m指定数字位长度，范围是0~65；d指定小数位长度，范围是0~30；d不能超过m
     * 数值类型对应存在无符号类型
     * 日期时间类型
     * timestamp    时间戳
     * datetime
     *
     * sql书写规范
     * 关键字大写，其余标识符小写
     * 字符串常量使用'标识
     *
     * select语句(DQL)
     * 由select子句，from子句，where子句，group by子句，having子句，order by子句六部分构成
     * select子句
     * 确定结果集中包含的列
     * 除指定指定列以外，还可以指定字符串常量，表达式，函数调用
     * null值参与计算时结果是null
     * 使用AS关键字指定列别名
     * 使用DISTINCT关键字去除结果集中重复行，去重前对整个结果集排序，比较耗时
     *
     * from子句
     * 指定查询的表及表之间的关联关系
     * from子句中表可以是永久表，临时表，虚拟表
     * 使用AS关键字指定表别名
     * 使用JOIN关键字连接表，使用ON关键字指定连接条件。连接分为内连接，外连接，交叉连接
     * 内连接 inner join
     * 结果集中只会包含连接成功的数据
     * 外连接 outer join
     * 分为左外连接 left outer join ，右外连接 right outer join
     * 左外连接，结果集中包含左表所有数据
     * 右外连接，结果集中包含右表所有数据
     * 交叉连接 cross join
     * 两张表中数据两两组合，结果称为笛卡尔积
     *
     * where子句
     * 指定过滤条件，过滤提取的数据。当数据满足过滤条件会被包含在结果集中
     * 通过and，or，not关键字连接过滤条件，and优先级高于or
     * 过滤条件分类
     * 相等条件，使用=运算符
     * 不等条件，使用!=运算符
     * 范围条件，使用>，<，>=，<=，between and运算符
     * between and运算符指定闭区间范围
     * 成员条件，使用in，not in运算符
     * 匹配条件，使用like运算符。配合通配符使用，_表示一个任意字符，%表示0个或多个任意字符
     * 数据中null常量值参与除is null，is not null以外过滤条件运算时结果都是false
     *
     * group by子句
     * 指定分组字段，对过滤后数据按列值分组。
     * 若指定分组，聚合函数对一组中数据进行操作；若不指定分组，聚合函数对结果集中所有数据进行操作
     * count函数统计一组中行数，count(*)会包含组中值为null的行，count(field)不会包含组中值为null的行
     *
     * having子句
     * 定义在group by子句之后，对分组数据进行过滤
     *
     * order by子句
     * 指定排序列，对结果集中数据排序
     * order by子句中可以指定函数或表达式，按函数或表达式的计算结果排序
     * order by进行全排序
     *
     * 集合操作
     * 并集   union，将两个结果集合并，去除重复数据
     * 全集   union all，将两个结果集合并，不去重
     * 交集
     * 差集
     *
     * select语句执行顺序
     * 读取from子句中指定表的数据，生成中间结果集
     * 根据where子句指定的条件过滤数据，生成过滤后结果集
     * 按group by子句指定的列值进行分组，此后以组为单位进行操作
     * 按having子句指定的条件对分组进行过滤
     * 选取select子句中定义的列进行合并，分组列直接合并，非分组列通过聚合函数合并，最终将一组数据转换为一行数据加入结果集
     * 对最终结果集按order by子句指定的顺序进行排序
     *
     * 子查询
     * 嵌套在sql中的查询语句。被当作一张临时表使用。
     * 子查询返回的结果可以是单列单行，单列多行，多列多行
     * 子查询分类
     * 非关联子查询   可以独立运行
     * 单列单行子查询可以用于>,<,>=,<=,=,!=过滤条件
     * 单列多行子查询可用于in，not in过滤条件，比较运算符和all，any构建过滤条件中
     * 多行多列子查询也可用于过滤条件中
     * 关联子查询    不可以独立运行，为每行数据执行一次
     * 可用于构建相等条件，范围条件，exists，not exists条件
     * exists后子查询结果集不为空为true
     *
     * 条件判断
     * case表达式
     * case表达式使用场景
     * i.行转列
     * 通过分组划分数据，通过case表达式将一组中类型字段转换成对应值，再进行聚合
     *
     * 视图
     * 虚拟表
     * 可修改视图
     * 视图满足一定条件时，通过视图可以增删改基础表中数据
     *
     * DML
     * insert语句
     * insert into table(column,column,column) values(value,value,value)
     * update语句
     * update table set column=value,column=value where condition
     * delete语句
     * delete from table where condition
     *
     * 事务
     * 一些操作的集合，是一个不可分割的逻辑工作单元。事务保证数据一致性。事务不能嵌套
     * 自动管理事务
     * mysql默认自动管理事务，为每条dml语句自动开启事务，自动提交事务。每条语句相互独立
     * 手动管理事务
     * 事务起始于dml语句，start transaction语句
     * 事务结束于commit语句，rollback语句，服务崩溃，ddl语句，start transaction语句
     * commit语句提交事务
     * rollback语句回滚事务
     * 服务崩溃事务结束，重启后回滚事务
     * start transaction语句开启新事务，将旧事务提交
     * 保存点
     * 在事务中创建保存点，可以回滚到指定保存点。保存点之前操作保留
     * savepoint name   创建保存点
     * rollback to name 回滚到保存点，回滚至保存点事务不会结束，需手动提交
     * 事务特性acid atomicity consistency isolation durability
     * 原子性  事务中操作要么全发生，要么全失败
     * 一致性(正确性) 事务执行前后，数据均正确
     * 隔离性  多用户并发操作数据库，在事务隔离级别设置得当前提下，并发事务互不干扰
     * 持久性  事务一旦提交不能恢复
     * 并发事务问题
     * 脏读   一个用户事务读到另一个用户事务未提交数据
     * 不可重复读    一个用户事务读到另一个用户事务提交的数据。
     *              在一个事务中多次读取同一数据，前后数据内容不一致。由update语句导致
     * 幻读   在一个事务中多次读取同一数据，前后数据数量不一致。由insert，delete导致
     * 事务隔离级别
     * read uncommitted 读未提交，无法解决任何问题
     * read committed   读已提交，解决脏读
     * repeatable read  可重复读，解决脏读，不可重复度
     * serializable     串行化，解决脏读，不可重复度，幻读。一个事务执行时会在行上添加共享锁，其他事务只能读，不能写
     *
     * 死锁
     * 并发事务相互请求锁定
     *
     * mysql编码规则
     * mysql中utf8编码规则最多使用三字节表示一个字符，生僻字符可能无法表示。
     * utf8mb4编码规则最多使用四个字节表示一个字符，能表示的字符多于utf8
     *
     * 约束
     * 用于限制表中列值，分为非空约束，唯一约束，主键约束，外键约束，检查约束
     * 非空约束 列值不能为null
     * 唯一约束 列值不能重复
     * 主键约束 非空约束+唯一约束
     * 外键约束
     * 检查约束 自定义列值限制
     *
     * 存储引擎
     * mysql与磁盘交互的组件，负责数据存储和提取。使用不同存储引擎，数据存取和索引技术都不相同
     * innodb存储引擎主键索引默认采用聚簇索引，主键索引中存储数据，非主键索引中存储主键，要查询两次b+树获取数据(回表)
     * myisam存储引擎主键索引默认采用非聚簇索引
     * 存储引擎包括缓冲池、redo log缓冲池以及额外的内存池
     *
     * 索引
     * 一种数据结构，用于加快查询速度。索引中可能存储数据，也可能存储数据地址，根据索引类型决定
     * 聚簇索引中包含行数据，非聚簇索引中不包含行数据。mysql中索引使用b+树结构
     * 索引分类
     * 主键索引 默认创建，非自增主键在存储时会进行排序，效率低。
     * 唯一索引
     * 普通索引
     * 文本索引 适用于varchar，char，text类型
     * 组合索引 多列组成一个索引，相当于创建多个索引，从左向右一次组合。最左匹配
     *
     * 索引下推
     *
     * 数据库设计原则
     * i.列不可分
     * ii.表中最好仅包含描述一个事物的字段，无关字段拆分到其他表中
     * iii.表中不应包含其他表中非主键
     *
     * jdbc
     * java程序集成数据库规范，由数据库厂商实现
     *
     * mysql架构
     * mysql由连接器，分析器，优化器，执行器，存储引擎，客户端组成
     * 连接器与客户端连接
     * 分析器对sql进行词法分析，语法分析，生成语法树
     * 优化器决定sql最优执行路径，形成执行计划
     *
     * 数据页
     * mysql读写数据的基本单位
     *
     * 日志
     * mysql包含bin log，redo log，undo log
     * redo log
     * innodb存储引擎生成，用于持久化事务，防止已提交的事务丢失。记录对数据页的修改内容
     * 数据库非正常停止，再次重启后会使用到redo log
     * 对数据页执行修改之前，生成redo log加入log buffer。默认在事务提交时，将buffer中日志写入磁盘log file中
     * redo log存在3种刷新策略，对应innodb_flush_log_at_trx_commit变量值
     * 0    事务提交将redo log保留在log buffer。延迟写
     * 1    事务提交将redo log写入磁盘log file。实时写，实时刷
     * 2    事务提交将redo log写入操作系统缓冲。实时写，延时刷
     * undo log
     * innodb存储引擎生成，用于事务回滚
     * 在修改数据页之前，生成undo log加入log buffer
     * bin log
     * 数据库服务层生成，记录所有对数据进行更改的操作。用于数据恢复和备份
     *
     * 执行计划
     * SELECT语句中每个表对应执行计划中一行信息
     * id   select语句标识符，表明select语句执行顺序
     *      id越大优先级越高，id相同从上到下执行
     * select_type  查询类型
     * SIMPLE   简单查询，不使用子查询和union
     * PRIMARY  嵌套查询中外层查询
     * UNION    使用并集时，第二个或以后select语句
     * DEPENDENT UNION  ？？？
     * UNION RESULT 并集结果集合
     * SUBQUERY 子查询
     * DEPENDENT SUBQUERY   ？？？
     * DERIVED  临时表，from子句中子查询
     * MATERIALIZED
     * UNCACHEABLE SUBQUERY 子查询的结果不能被缓存
     * UNCACHEABLE UNION
     * table    提取数据的表名
     * 可以是表名或别名或<derivedN>(临时表名)或<subqueryN>(子查询名)或<unionM,N>(并集名)
     * partitions   分区
     * type 访问类型，从system到all，效率依次降低
     * system
     * const
     * eq_ref   使用唯一索引查找
     * ref  使用非唯一索引查找
     * fulltext
     * ref_or_null
     * index_merge
     * unique_subquery
     * index_subquery
     * range    使用索引查找，并限制范围
     * index    全索引扫描
     * ALL  全表扫描
     * possible_keys    可能使用的索引列
     * key  实际使用的索引列
     * key_len  使用到的索引列长度
     * ref  与索引列进行比较的列，最好是使用常量与索引比较
     * rows 估算需要读取的数据行数，越小越好
     * filtered 读取行数占全表数据百分比
     * Extra    额外信息
     * Using filesort  无法使用索引排序，只能使用排序算法排序
     * Using temporary  建立临时表保存中间结果，查询结束删除临时表
     * Using index  使用覆盖索引
     * Using where  使用过滤条件
     * Using join buffer    使用连接缓存
     * impossible where 过滤条件均为false
     *
     * mysql锁
     * 多用户同时操作数据库，每个连接在mysql服务端产生一个线程，通过锁协调多个线程并发访问同一资源
     * 不同存储引擎支持不同锁机制
     * myisam支持表级锁；innodb支持表级锁，行级锁，默认使用行级锁
     * myisam表级锁
     * 表读共享锁，表写独占锁
     * 共享锁可以被多个线程同时持有，独占锁只能被一个线程持有。共享锁和独占锁不能同时被占用
     * myisam存储引擎，执行dql语句前需获取读锁，执行dml语句需获取写锁，自动释放锁
     * 线程获取到写独占锁后，只有当前线程可以对表进行操作，其他线程操作该表会阻塞
     * 线程获取到读共享锁后，当前线程只能进行读操作，其他线程可以申请读共享锁进行读操作，进行写操作会阻塞
     * myisam中为语句隐式加锁，也可使用lock table，unlock tables显式获取锁，不建议
     * myisam存储引擎，线程获取某张表锁之后，不能操作其他表
     * myisam读写是串行执行，但一定条件下，可以读写并行。通过变量concurrent_insert控制，使用read local锁？？？？？
     * innodb行级锁
     * 读共享锁，写排他锁
     * 行读锁可以授予多个线程，行写锁只能授予一个线程。行读锁，行写锁不能同时被占用
     * 获取行写锁前会获取表写锁，获取行读锁前会获取表读锁。
     * 行锁通过索引实现，不通过索引查询不会获取行锁，仅获取到表锁
     * innodb存储引擎，执行dml语句前需获取写锁，执行dql语句前不需获取锁，事务提交释放锁
     * 线程获取到行写锁后，只有当前线程可以对行进行操作，其他线程操作该行会阻塞
     * 线程获取到行读锁后，当前线程只能对行进行读操作，其他线程可以申请读共享锁对行进行读操作，进行写操作会阻塞
     * innodb中为事务隐式加锁，可在select语句中显式占用锁，不建议
     *
     * 主从复制
     * 采用异步方式将数据从mysql主节点复制到若干从节点。可以复制全部数据或指定数据
     * 步骤
     * i.主节点会将所有对数据更改的操作记录在bin log中
     * 主从复制延迟问题 mts
     *
     * 读写分离
     * master结点处理写操作，slave结点处理读操作。master结点将变更操作同步到slave结点
     * 使用mysql-proxy实现读写分离，切换读取数据结点需手动切换，不推荐
     * 使用amoeba(阿里开源)实现读写分离
     * amoeba依赖jdk
     * 安装amoeba后修改dbServers.xml，amoeba.xml
     * 使用mycat实现读写分离
     */
}
