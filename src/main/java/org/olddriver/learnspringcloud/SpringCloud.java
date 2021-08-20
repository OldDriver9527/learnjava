package org.olddriver.learnspringcloud;

/**
 * SpringCloud生态
 * 20210815
 */
public class SpringCloud {
    /**
     * springcloud中controller和service通过rest调用
     *
     * 服务治理组件
     * 网关
     * 业务网关。用户请求最先到达网关，网关实现负载均衡，权限控制
     * 返回用户的数据都会经过网关，存在瓶颈
     *
     * 注册中心
     * 维护集群中所有服务列表
     *
     * 配置中心
     * 管理集群中服务配置信息
     *
     * 远程服务调用组件
     * 早期使用netflix Feign，替代方案有OpenFeign，RestTemplate
     *
     * 客户端负载均衡器
     * 客户端维护服务列表，根据负载均衡算法分发请求
     *
     * 熔断器
     * 进行熔断和服务降级
     *
     * 分布式事务组件
     * 保证集群中各服务数据一致性
     *
     * 分布式锁组件
     *
     * 链路追踪组件
     * 分析服务调用路径
     *
     * 监控中心
     *
     * 监控端点组件
     */
}
