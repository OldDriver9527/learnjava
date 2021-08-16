package org.olddriver.learnjava.concurrency;

/**
 * 20210814
 * Disruptor队列
 * 第十一部分
 */
public class Disruptor {
    /**
     * 线程安全的环形队列
     * 效率由于jdk队列。
     *
     * 使用方式
     * i.创建Event类，即消息
     * ii.创建事件工厂，实现EventFactory接口，重写newInstance方法。提供创建事件的方法
     * 创建Disruptor时会创建所有Event对象，不再需要向队列中添加事件，只需覆盖原事件数据
     * iii.创建EventHandler，实现EventHandler接口，重写onEvent方法，定义消费消息逻辑。EventHandler对象个数决定消费者线程个数
     * iiii.创建Disruptor，指定事件工厂，队列长度(2的n次幂)，线程工厂(用于创建消费者线程)
     * iiiii.通过队列next方法获取下一个可用事件序列；get方法获取事件，对事件中数据进行覆盖；通过publish发布事件
     *
     * EventTranslator接口
     * 将参数转换成Event对象
     *
     * 等待策略(队列填满后添加消息的策略)
     *
     * 消费者异常处理
     * 创建异常处理器，实现ExceptionHandler接口，重写指定方法处理异常
     */
}
