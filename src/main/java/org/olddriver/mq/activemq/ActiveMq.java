package org.olddriver.mq.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Before;
import org.junit.Test;

import javax.jms.*;
import java.util.Objects;
import java.util.concurrent.locks.LockSupport;

/**
 * ActiveMq
 * 20211124
 * 第一部分
 */
public class ActiveMq {
    /**
     * 安装
     * 依赖于jdk，不同版本对jdk版本要求不同(activemq.jar META-INF/MANIFEST.MF中记录环境相关信息)
     * 无需安装，开箱即用
     *
     * jms(Java MessageService)
     * 一套抽象规范，一些消息中间件实现jms规范
     *
     * jms角色
     * broker   消息服务器，对外提供服务
     * producer 生产者
     * consumer 消费者
     *
     * 消息传递模型
     * 点对点模型
     * 使用queue作为消息目的地，消息会被持久化，消费者从queue中获取消息
     * 不支持消息重复消费
     * 发布订阅模型
     * 使用topic作为消息目的地，不对消息进行持久化，正在监听此topic的消费者会接收到消息，未监听此topic的消费者不会接收到消息
     * 支持消息重复消费
     *
     * jms消息格式
     * 消息由消息头，消息属性，消息体组成
     *
     * 幂等性
     * 使用相同参数调用一次或重复调用多次接口，造成的后果一样
     *
     * 应用场景
     * 程序间异步通信
     *
     * 控制台页面安全认证
     * jetty-realm.properties文件中配置安全认证的账户，密码，角色
     *
     * broker安全认证
     * activemq.xml中配置认证插件，指定连接broker的认证信息，包括用户名，密码，分组
     *
     * 消息持久化策略
     * 对未处理消息进行持久化，防止消息丢失。消息被处理后移除
     * activemq提供多种持久化策略，不同目的地可以使用不同持久化策略
     * i.kahadb存储
     * activemq默认使用kahadb对未处理消息持久化，但服务重启后消息丢失。
     * ii.jdbc存储
     * 使用关系型数据库存储未处理消息，效率低，服务重启未处理消息不丢失
     * iii.内存存储
     * 未处理消息存储在内存中，不稳定
     * iiii.JDBC Message store with ActiveMQ Journal
     *
     * activemq.xml中配置jdbc消息持久化策略
     * i.配置jdbc数据源
     * ii.替换持久化适配器
     * iii.在activemq lib目录中增加需要依赖
     * iiii.重启mq
     *
     * 消息事务
     * 事务偏向生产者
     * 类似mysql事务，保证producer到broker或broker到consumer间消息传递的原子性
     * 生产者开启消息事务后，只有提交事务，消息才会添加到目的地；事务回滚，消息不会添加到目的地
     * 消费者开启消息事务后，只有提交事务，消息才会被确认接收；事务回滚，消息不会被确认接收
     *
     * 消息确认模式
     * 确认偏向消费者
     * 在事务会话中，使用事务模式，消费者提交事务，确认自动发生
     * 在非事务会话中，确认模式分为自动确认(AUTO_ACKNOWLEDGE)，手动确认(CLIENT_ACKNOWLEDGE)，(DUPS_OK_ACKNOWLEDGE)
     * 自动确认 消费者成功接收消息后，自动确认
     * 手动确认，调用方法确认消息，会将之前的消息一并确认
     * 被消费者接收但未确认的消息不会被其他消费者消费，除非消费者失去连接
     *
     * 消息优先级
     * 优先级高的消息被优先消费，优先级从1~9逐渐升高
     * 需在activemq.xml中开启优先级配置
     *
     * MessageListener
     * 消费者可以通过MessageListener获取消息，MessageListener与消费者线程绑定，消费者线程一旦进入终止状态
     * 监听器就无法工作(其他版本可能不适用)
     *
     * 消息类型
     * 对象类型消息
     * 发送对象类型消息，需使用ObjectMessage封装对象
     * 需要在连接工厂中添加信任包信息
     *
     * 消息存活时间
     * 生产者发送消息时可以指定消息的存活时间，超过存活时间消费之无法消费此消息，
     * 此消息会进入死信队列DLQ中，DLQ队列中的消息不会自动清除可能产生消息堆积
     * 消费者可以监听死信队列，获取一些消息(如发布订阅模式下丢失的消息)
     *
     * 死信队列
     * 可在activemq.xml中配置队列对应的死信队列
     * DeliveryMode采用非持久化时，超时消息默认不进入死信队列，
     * 通过配置processNonPersistent=true，可将非持久化模式下超时消息加入死信队列
     * 通过配置processExpired=false，超时消息不加入死信队列
     *
     * 独占消费
     * 创建目的地时可开启独占消费，demo?consumer.exclusive=true
     * 开启后，目的地中的消息只会被一个消费者消费，当此消费者断开连接后才能由另一个消费者消费
     *
     * 分组消费
     * 对消息分组，不同消费者消费不同组的消息
     * 创建消费者时通过指定分组条件确定分组
     * 不生效时使用setxxProperty方式
     *
     * 消息发送方式(同步，异步)
     * 同步发送是指生产者发送消息后，会在收到broker肯定确认之后才发下一个消息
     * 异步发送是指生产者发出消息后，不等接broker响应，接着发送下个消息，性能较高
     * DeliveryMode采用持久化时，开启事务采用异步发送，关闭事务采用同步发送
     * DeliveryMode采用非持久化时，采用异步发送
     *
     * 窗口尺寸？？
     * 定时发送
     * 在配置文件中配置broker支持调度，schedulerSupport=true
     * 为消息设置发送时间
     *
     * 整合springboot
     * MessageListenerContainer？？
     * @JmsListener 修饰监听方法，当方法有返回值，会将返回值再次发送到队列中
     * 可通过@SendTo注解指定目的地
     *
     */

    private Connection connection = null;

    private Session session = null;

    @Test
    public void testConsumer(){
        try {
            connection.start();
            session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

            Queue user = session.createQueue("user");

            MessageConsumer consumer = session.createConsumer(user);

            consumer.setMessageListener((message)->{
                System.out.println(message);
            });
            LockSupport.park();

        } catch (JMSException e) {
            e.printStackTrace();
        }  finally {
            if(Objects.nonNull(session)){
                try {
                    session.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
            if(Objects.nonNull(connection)){
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Before
    public void testConnection(){
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(
                "admin",
                "admin",
                "tcp://127.0.0.1:61616"
        );

        try {
            connection = factory.createConnection();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTopicConsumer(){
        try {
            connection.start();
            session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

            Destination test = session.createTopic("test");
            MessageConsumer consumer = session.createConsumer(test);


            consumer.setMessageListener((message)->{

                System.out.println(message);

            });

            LockSupport.park();

        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
                session.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testTopicProducer(){
        try {
            connection.start();
            session = connection.createSession(true,Session.AUTO_ACKNOWLEDGE);

            Destination test = session.createTopic("test");

            MessageProducer producer = session.createProducer(test);

            TextMessage hello = session.createTextMessage("hello");

            for(int i = 0 ; i < 100 ; i++){
                producer.send(hello);
            }
            session.commit();

        } catch (JMSException e) {
            e.printStackTrace();

            try {
                session.rollback();
            } catch (JMSException ex) {
                ex.printStackTrace();
            }

        } finally {
            try {
                session.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testProducer(){
        try {
            connection.start();

            session = connection.createSession(true,Session.AUTO_ACKNOWLEDGE);

            Queue user = session.createQueue("user");

            MessageProducer producer = session.createProducer(user);
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);
            producer.setTimeToLive(1000);
            for(int i = 0 ; i < 100 ; i++){
                TextMessage textMessage = session.createTextMessage("hello activemq");
                producer.send(textMessage);
            }
            //session.commit();
        } catch (JMSException e) {
            e.printStackTrace();
            try {
                session.rollback();
            } catch (JMSException ex) {
                ex.printStackTrace();
            }
        }  finally {
            if(Objects.nonNull(session)){
                try {
                    session.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
            if(Objects.nonNull(connection)){
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
