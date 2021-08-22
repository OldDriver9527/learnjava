package org.olddriver.learnspringcloud.netflix;

/**
 * Zuul
 * 20210820
 * 第七部分
 */
public class Zuul {
    /**
     * netflix 提供的业务网关组件，使用隧道模式。用户所有请求首先到达网关，网关通过服务名/资源路径转发请求，最终响应再次经过网关到达用户
     *
     * 搭建方式
     * i.添加zuul依赖
     * ii.启动类上添加@EnableZuulProxy注解，启动zuul相关配置
     *
     * zuul默认将服务名解析成小写，通过/服务名/资源路径访问时应将服务名写成小写
     *
     * 功能
     * 身份认证
     * 服务熔断
     * 负载均衡 使用ribbon做负载均衡
     */
}
