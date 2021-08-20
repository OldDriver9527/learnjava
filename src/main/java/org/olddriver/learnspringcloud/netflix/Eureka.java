package org.olddriver.learnspringcloud.netflix;

/**
 * Eureka
 * 20210815
 * 第一部分
 */
public class Eureka {
    /**
     * 早期使用的注册中心，分为服务端和客户端
     *
     * 单节点模式搭建
     * 服务端搭建
     * i.添加eureka服务端相关依赖
     * ii.修改服务端配置文件，仅包含必要配置
     * eureka.instance.hostname eureka主机名(域名，虚拟主机名)，服务端主机名在集群中要保证唯一
     * eureka.client.registerWithEureka=false   当前服务是否向指定url注册，默认为true，服务端在单节点模式关闭此行为
     * eureka.client.fetchRegistry=false    当前服务是否从指定url拉取服务列表，默认为true，服务端在单节点模式关闭此行为
     * eureka.client.serviceUrl.defaultZone=http://${eureka.instance.hostname}:${server.port}/eureka/   指定注册服务地址
     * 服务端启动会根据主机名判断指定url是否为当前主机上的url，若是不将此url作为副本。
     * 若使用prefer-ip-address将ip作为主机名，defaultZone中应该使用ip；若未使用prefer-ip-address，defaultZone中应该使用域名
     * iii.启动类上添加 @EnableEurekaServer，启用eureka服务端相关配置
     * 客户端搭建
     * i.添加eureka客户端相关依赖
     * ii.修改客户端配置文件
     * eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka/   指定注册服务地址
     * 客户端defaultZone，主机名都无固定要求
     * iii.启动类上添加 @EnableEurekaClient，启用eureka客户端相关配置
     *
     * ha模式搭建
     * 方式1
     * 多个eureka服务端之间进行交互，服务端向指定url注册，也从指定url拉取列表
     * 多个服务端使用相同application name，使用不同hostname。application name决定分组，hostname决定实例
     * 服务端指定url中不需包含当前服务端的注册地址
     * 客户端指定url中包含所有服务端的注册地址
     * eureka牺牲一致性保证高可用
     * 方式2
     * 多个服务端之间相互不注册，不拉取服务列表。每个服务端维护各自服务列表
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
     *
     * 自我保护机制
     * 服务端触发自我保护机制后不会再移除服务列表中服务
     * eureka.server.enable-self-preservation属性关闭自我保护机制
     *
     * 手动修改服务上下线状态
     * i.开启客户端健康检测，向服务端汇报actuator中健康状态。
     * eureka.client.healthcheck.enabled    开启客户端健康检测
     * ii.实现HealthIndicator接口，重写health方法，health方法返回值决定健康状况。
     * 修改health方法返回值实现手动修改服务上下线状态
     *
     * eureka安全认证
     * 客户端向服务端注册增加认证
     * i.添加security相关依赖
     * ii.在配置文件中指定用户名，密码
     * iii.在注册服务的url中添加用户名，密码
     * iiii.添加配置类，禁用csrf，防止控制台报错
     */
}
