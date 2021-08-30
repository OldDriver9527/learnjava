package org.olddriver.learnspringcloud.spring;

/**
 * Config
 * 20210820
 * 第十部分
 */
public class Config {
    /**
     * spring cloud提供的配置中心，管理集群中各个服务配置
     * 使用git，svn管理配置文件
     * config服务端从git拉取配置文件，config客户端从服务端拉取配置
     * git上配置文件以服务名-profile方式命名
     *
     * 单节点搭建方式
     * 服务端搭建
     * i.添加config服务端相关依赖
     * ii.启动类上添加@EnableConfigServer，激活Config配置
     * iii.修改配置文件
     * spring.cloud.config.server.git.uri   指定配置文件仓库地址
     * spring.cloud.config.server.git.username  指定用户名
     * spring.cloud.config.server.git.password  指定密码
     * spring.cloud.config.label    指定配置文件仓库分支
     * 客户端搭建
     * i.添加config客户端相关依赖
     * ii.修改配置文件
     * 配置文件名称修改为bootstrap
     * spring.cloud.config.uri  指定config服务端url
     * spring.cloud.config.profile  指定profile
     * spring.cloud.config.label    指定拉取分支
     *
     * ha模式搭建
     * 客户端从eureka拉取服务列表，获取config服务端地址
     * spring.cloud.config.discovery.enabled
     * spring.cloud.config.discovery.service-id 指定config服务端服务名
     *
     * config服务端启动后，以/分支/服务名-profile.yml作为url查看配置文件
     *
     * 手动更新客户端配置
     * config服务端配置修改后，手动更新客户端配置
     * i.修改配置文件，开启监控端点refresh
     * ii.在注入动态配置的类上添加@RefreshScope注解
     * iii.向客户端发出/actuator/refresh post请求，更新配置。每个客户端都需要执行一次
     *
     * 通过消息总线自动更新其他服务配置????
     * i.添加消息总线依赖
     * ii.添加消息总线配置
     * spring.rabbitmq.host mq主机名
     * spring.rabbitmq.port mq端口
     * spring.rabbitmq.username mq用户名
     * spring.rabbitmq.password mq密码
     * iii.向当前服务发出/actuator/bus-refresh post请求，更新配置。只需要执行一次，其他服务配置同步更新
     * 可以在config服务端配置，也可在客户端配置
     */
}
