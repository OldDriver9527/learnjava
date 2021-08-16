package org.olddriver.learnspringcloud.netflix;

/**
 * Eureka
 * 20210815
 */
public class Eureka {
    /**
     * 早期使用的注册中心，分为服务端和客户端
     *
     * 单节点模式搭建
     * 服务端搭建
     * i.添加eureka服务端相关依赖
     * ii.修改服务端配置文件，仅包含必要配置
     * eureka.instance.hostname eureka  主机名
     * eureka.client.registerWithEureka=false   当前服务是否向指定url注册，默认为true，服务端在单节点模式关闭此行为
     * eureka.client.fetchRegistry=false    当前服务是否从指定url拉取服务列表，默认为true，服务端在单节点模式关闭此行为
     * eureka.client.serviceUrl.defaultZone=http://${eureka.instance.hostname}:${server.port}/eureka/   指定注册服务地址
     * 服务端启动会根据eureka主机名判断注册地址中是否包含当前主机，包含则剔除当前主机。使用ip地址会影响判断，导致信息显式有误
     * iii.启动类上添加 @EnableEurekaServer，启用eureka服务端相关配置
     * 客户端搭建
     * i.添加eureka客户端相关依赖
     * ii.修改客户端配置文件
     * eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka/   指定注册服务地址
     * iii.启动类上添加 @EnableEurekaClient，启用eureka客户端相关配置
     *
     * ha模式搭建
     * 多个eureka服务端之间进行交互，服务端向指定url注册，也从指定url拉取列表
     * 多个服务端使用相同application name，防止unavailable-replicas显式错误。多个服务端使用不同hostname，根据hostname区分
     * 服务端指定url中不需包含当前服务端的注册地址
     * 客户端指定url中包含所有服务端的注册地址
     * eureka牺牲一致性保证高可用
     *
     * eureka服务端，客户端通信类型
     * 服务注册 register
     * 客户端向服务端注册，使用主机名:应用名:端口号作为服务唯一标识
     * 续租   renew
     * 客户端每隔30s向服务端发送一次心跳进行续租，一致性很低。服务端90s内未收到心跳，会将服务从列表中删除
     * 拉取列表 fetch register
     * 客户端从服务端拉取服务列表，在本地缓存。之后可以增量或全量更新缓存
     * 取消注册 cancel
     *
     * 同步延迟
     * 通信机制
     * eureka使用rest请求
     *
     * 客户端配置选项，不推荐修改
     * eureka.instance.lease-renewal-interval-in-seconds    指定客户端发送心跳时间间隔，s为单位
     * 服务端置选项，不推荐修改
     *
     * eureka rest接口
     * /eureka/apps 查看所有注册服务信息
     *
     * 元数据
     * eureka元数据分为标准元数据和自定义元数据
     * 通过eureka.instance.metadata-map.key=value方式指定自定义元数据
     *
     * DiscoveryClient
     * 客户端抽象接口，可以获取服务信息，对服务进行一些操作(获取元数据自定义负载均衡策略，配合Ribbon实现负载均衡)
     */
}
