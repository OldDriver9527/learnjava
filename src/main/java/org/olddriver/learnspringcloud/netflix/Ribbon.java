package org.olddriver.learnspringcloud.netflix;
/**
 * Ribbon
 * 20210817
 * 第二部分
 */
public class Ribbon {
    /**
     * 服务端负载均衡
     * 客户端已知负载均衡服务器地址，由负载均衡服务器分发请求
     * 客户端负载均衡
     * 客户端维护服务列表，通过负载均衡算法分发请求
     * ribbon是一种客户端负载均衡器
     *
     * 负载均衡策略
     * RoundRobinRule   轮询策略
     *
     * 修改ribbon负载均衡策略
     * 注解方式
     * 向ioc容器中注册IRule接口实现对象
     * 配置文件方式
     * 被调用方应用名.ribbon.NFLoadBalancerRuleClassName属性指定使用的负载均衡策略实现类
     *
     * 自定义负载均衡策略
     * 在Controller中实现负载均衡
     *
     * ribbon脱离eureka
     * ribbon.eureka.enabled和被调用方应用名.ribbon.listOfServers属性配合使用
     * ribbon不使用注册中心服务列表，使用本地服务列表
     */
}
