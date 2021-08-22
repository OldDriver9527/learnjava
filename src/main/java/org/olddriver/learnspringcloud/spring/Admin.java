package org.olddriver.learnspringcloud.spring;

/**
 * Admin
 * 20210820
 * 第九部分
 */
public class Admin {
    /**
     * 监控中心
     *
     * 搭建方式
     * 服务端搭建
     * i.添加admin服务端相关依赖
     * ii.启动类上添加@EnableAdminServer
     * 客户端搭建
     * i.添加admin客户端，actuator相关依赖
     * ii.添加客户端配置
     * management.endpoints.web.exposure.include    暴露监控端点
     * management.endpoint.health.show-details
     * spring.boot.admin.client.url 指定服务端url提交信息
     *
     * 通过hostname:port访问admin监控页面
     *
     * 邮件通知
     * 当服务出现问题发送邮件通知
     * 钉钉群通知
     */
}
