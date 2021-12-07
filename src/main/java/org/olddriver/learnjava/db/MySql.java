package org.olddriver.learnjava.db;

/**
 * 20210709
 * 数据库
 * 第一部分
 */
public class MySql {
    /**
     * 关系型数据库
     * 使用表存储记录，不同表中记录根据一些冗余字段关联
     *
     * 表
     * 性质相同的行的集合，可分为永久表，临时表，虚拟表
     * 永久表    使用ddl语句创建的表
     * 临时表    select语句返回结果
     * 虚拟表    视图
     *
     * 行
     * 完整的数据单元，由列组成
     *
     * 列
     * 数据片段
     *
     * 主键
     * 行在表中的唯一标识
     *
     * 外键
     * 用于关联其他表中记录的字段
     *
     * sql(sequel)
     * 用于操作关系表中数据语言，可以为分ddl(数据定义语言)，dql(数据查询语言)，...
     *
     * mysql中数据类型
     * 数值类型
     * 整数型(精确值型)
     * tinyint  占1byte，有符号存储范围[-2^7，2^7-1]
     *          boolean类型以tinyint(1)形式存储
     * smallint 占2byte，有符号存储范围[-2^15，2^15-1]
     * mediumint 占3byte，有符号存储范围[-2^23，2^23-1]
     * int 占4byte，有符号存储范围[-2^31，2^31-1]
     * bigint 占8byte，有符号存储范围[-2^63，2^63-1]
     * 整数类型宽度为显式的最小宽度，数据宽度不足最小宽度会使用空格填补，不会影响类型的存储范围
     *
     * 浮点数类型(近似值型)
     * float    占4byte
     * double   占8byte
     * 浮点数类型宽度为整数位数与小数位数之和，影响存储范围
     *
     * 定点类型(精确值型)
     * decimal
     * 定点类型宽度为整数位数与小数位数之和，影响存储范围
     *
     * 日期时间类型
     * date 日期，包含年月日，范围是'1000-01-01'到'9999-12-31'
     * datetime 日期时间，范围是'1000-01-01 00:00:00.000000'到'9999-12-31 23:59:59.999999'
     *          可以指定默认初始化值(DEFAULT CURRENT_TIMESTAMP)及更改时间(UPDATE CURRENT_TIMESTAMP)
     *          时间部分中，可以包含小数秒
     * timestamp 时间戳，范围是'1970-01-01 00:00:01.000000'到'2038-01-19 03:14:07.999999'
     *           可以指定默认初始化值及更改时间
     *           时间部分中，可以包含小数秒
     * time 时间，范围是'-838:59:59'到'838:59:59'，时间部分中可以包含小数秒
     * year 年份，范围是1901到2155
     *
     * 字符串类型
     * char 固定长度字符串，字符个数是0到255(新版本)
     * varchar  可变长度的字符串，字符个数是0到一定上限，上限受字符集影响
     * binary   固定长度二进制字节序列
     * varbinary    可变长度二进制字节序列
     * tinytext，text，mediumtext，longtext    存储字符文本字符串，存储字符上限逐渐增加
     * tinyblob，blob，mediumblob，longblob    存储字节序列，存储字节上限逐渐增减
     *
     * sql书写规范
     * 关键字大写，其余标识符小写
     * 字符串常量使用'标识
     *
     * select语句
     * 由select子句，from子句，where子句，group by子句，having子句，order by子句，
     * limit子句，for update子句等组成
     *
     * select子句
     * 确定结果集中包含的字段。除定义字段以外，还可以定义字符串常量，表达式
     * 使用AS关键字为字段定义别名，别名可以在group by，having，order by子句中使用(仅限mysql)，不能在where子句中使用
     * 使用DISTINCT关键字去除结果集中重复行，去重前对整个结果集排序，比较耗时
     *
     * from子句
     * 指检索数据的一个或多个表，多个表之间需进行连接
     * 表DUAL是一张不存在的表
     * 使用AS关键字指定表别名
     * 使用JOIN关键字连接表，使用ON关键字指定连接条件。连接分为内连接，外连接，交叉连接
     * 内连接 inner join
     * 结果集中只会包含连接成功的数据
     * 外连接 outer join
     * 分为左外连接 left outer join ，右外连接 right outer join
     * 左外连接，结果集中包含左表所有数据
     * 右外连接，结果集中包含右表所有数据
     * 交叉连接 cross join
     * 交叉连接的结果称为笛卡尔积，是两张表中数据两两组合而成
     * USING关键字简化相等连接条件，当连接字段在两表中同名，同类型时使用，结果集中连接字段只会有一个，一般不使用
     *
     * where子句
     * 指定行过滤条件，当行数据满足过滤条件会被包含在结果集中
     * 通过and，or，not关键字连接过滤条件，and优先级高于or
     * 过滤条件分类
     * 相等条件，使用=进行检索
     * 不等条件，使用!=进行检索
     * 范围条件，使用>，<，>=，<=，between and进行检索
     * between and运算符指定闭区间范围
     * 成员条件，使用in，not in进行检索
     * 匹配条件，使用like进行模糊查询。配合通配符使用，_表示一个任意字符，%表示0个或多个任意字符
     * 数据中null常量值参与除is null，is not null以外过滤条件运算时结果都是false
     *
     * group by子句
     * 对过滤后数据按列值分组，相同字段值为一组。
     * 若指定分组，聚合函数对一组中数据进行操作；若不指定分组，聚合函数对结果集中所有数据进行操作
     * count函数统计一组中行数，count(*)会包含组中值为null的行，count(field)不会包含组中值为null的行
     *
     * having子句
     * 定义在group by子句之后，对分组数据进行过滤
     *
     * order by子句
     * 对结果集中数据排序
     * order by子句中可以指定函数或表达式，按函数或表达式的计算结果排序
     * order by进行全排序
     *
     * limit子句
     * 用于对结果集分页，可接收一个或两个参数
     * 接收两个参数时，参数为偏移量，检索行数
     * 接收一个参数时，参数为检索行数，从头开始检索
     *
     * for update子句
     * for update显式添加互斥锁
     * for share显式添加共享锁
     *
     * 集合操作
     * 并集   union，将两个结果集合并，去除重复数据
     * 全集   union all，将两个结果集合并，不去重
     * 交集
     * 差集
     *
     * select语句执行顺序
     * 执行from子句，获取一张表或多张表中数据，若存在连接情况，先两表连接之后再与其他表一一连接
     * 根据where子句指定的条件过滤数据，生成过滤后结果集
     * 按group by子句指定的列值进行分组，此后以组为单位进行操作
     * 按having子句指定的条件对分组进行过滤
     * 选取select子句中定义的列进行合并，分组列直接合并，非分组列通过聚合函数合并，最终将一组数据转换为一行数据加入结果集
     * 对最终结果集按order by子句指定的顺序进行排序
     * 之后执行limit子句获取部分行
     *
     * 子查询(subquery)
     * 嵌套在sql中的select语句，被当作一张临时表使用。
     * 子查询返回的结果可以是单个值，一列，一行，表
     * 子查询分类
     * 非关联子查询   可以独立运行
     * 返回单个值子查询可以用于>,<,>=,<=,=,!=过滤条件
     * 返回一列子查询可用于in，not in过滤条件，比较运算符和all，any构建过滤条件中
     * 返回一行子查询可用于构建多个字段相等的条件
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
     * insert语句
     * insert into table(column,column,column) values(value,value,value)
     * update语句
     * 单表操作
     * update table set column=value,column=value where condition [order by] [limit]
     * delete语句
     * 单表操作
     * delete from table where condition [order by] [limit]
     *
     * 事务
     * 一些操作的集合，是一个不可分割的逻辑工作单元。事务保证数据一致性。事务不能嵌套
     *
     * 自动提交模式(autocommit mode)
     * mysql默认运行在自动提交模式下，每条语句都像是被start transaction 和 commit包裹。
     * start transaction语句会隐式禁用自动提交模式，使用commit或roll back后隐式恢复自动提交模式
     * SET autocommit=0 关闭自动提交模式，每个会话中有效
     *
     * 只读事务(start transaction read only) 读写事务(start transaction read write)
     * 事务中不能包含写动作，数据库会对只读事务进行优化
     *
     * start transaction会隐式提交之前未提交的旧事务，导致锁被释放
     * ddl语句隐式提交之前未提交的旧事务
     *
     * 保存点
     * 在事务中创建保存点，可以回滚到指定保存点。保存点之前操作保留
     * 保存点同名，新保存点会覆盖旧保存点
     * savepoint name   创建保存点
     * rollback to name 回滚到保存点，回滚至保存点事务不会结束，需手动提交
     *
     * 事务特性acid atomicity consistency isolation durability
     * 原子性  事务中操作要么全发生，要么全失败
     * 一致性(正确性) 事务执行前后，数据均正确
     * 隔离性  多用户并发操作数据库，在事务隔离级别设置得当前提下，并发事务互不干扰
     * 持久性  事务一旦提交不能恢复
     *
     * 并发事务读写冲突
     * 脏读   一个用户事务读到另一个用户事务未提交数据
     * 不可重复读    一个用户事务读到另一个用户事务提交的数据。
     *              在一个事务中多次读取同一数据，前后数据内容不一致。由update语句导致
     * 幻读   在一个事务中多次读取同一数据，前后数据数量不一致。由insert，delete导致
     *
     * 事务隔离级别(由低到高)
     * read uncommitted 读未提交，无法解决任何问题
     * read committed   读已提交，解决脏读
     * repeatable read  可重复读，解决脏读，不可重复度。
     * serializable     串行化，解决脏读，不可重复度，幻读。读加共享锁，写加排它锁
     * 事务隔离级别针对mysql快照读，不适用于当前读
     *
     * 快照读(一致性非锁定读)
     * 基于版本链和readview读取数据，不涉及锁，普通select查询为快照读
     * 若读取的行正在其他事务中执行DELETE或UPDATE操作，快照读不会因锁而阻塞，会读取数据的旧版本
     * 当前读(锁定读)
     * 操作数据最新版本。加锁查询，增删改均属于当前读，通过锁实现
     *
     * mvcc(Multi-Version Concurrency Control)
     * 读已提交，可重复读隔离级别依赖mvcc实现快照读
     * 修改数据会使数据形成版本链，
     * 在可重复读的隔离级别下，第一次执行快照读生成的readView，会被其后快照读同享。若其后存在当前读，readView会更新
     * 在读已提交的隔离级别下，每次执行快照读都会生成readView
     * readView中记录当前事务id creator_trx_id ，活跃事务id集合 m_ids，最小活跃事务id min_trx_id，即将产生的最大事务id max_trx_id
     * 若数据的事务id trx_id 小于 最小活跃事务id min_trx_id，数据在当前事务之前已存在，可见
     * 若数据的事务id trx_id 等于 当前事务id creator_trx_id，可见
     * 若数据的事务id trx_id 位于 min_trx_id，max_trx_id之间。位于m_ids中，不可见；不位于m_ids中，可见
     * 若数据的事务id trx_id 大于 max_trx_id，不可见
     *
     * innodb锁类型
     * 排他锁，共享锁(写锁，读锁)
     * 行级锁
     * 持有共享锁的事务可以对行进行读操作。持有排他锁的事务可以对行进行update，delete操作
     * 若事务t1持有行的共享锁，事务t2申请行的共享锁会被立即赋予，事务t2申请行的排他锁会阻塞
     * 若事务t1持有行的排他锁，事务t2申请行的任意类型锁都是阻塞
     * 意向共享锁IS，意向排他锁IX
     * 表级别锁
     * 事务在获取共享锁前需先获取意向共享锁。事务在获取排他锁前需先获取意向排他锁
     * 意向锁只会阻塞全表请求
     *
     * 行级别锁实现
     * 记录锁
     * 锁定某个唯一索引字段的一个值(即锁定一行)
     * 间隙锁
     * 锁定某个非唯一索引字段的一个开区间，区间根据已存在字段值进行划分
     * 锁定某行之前的区间
     * 间隙锁仅能阻塞insert操作
     * 临键锁
     * 一种特殊间隙锁
     * 锁定某个非唯一索引字段的一个区间，锁定某行及某行前的一个区间
     *
     * 查看数据库锁
     * select * from performance_schema.data_locks;(8.0.13版本以后)
     *
     * sql语句上设置的锁
     * 对于快照读语句，不设置锁
     * 对于当前读语句，优先设置临键锁，临键锁可以进一步退化成间隙锁，记录锁
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
