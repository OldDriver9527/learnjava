package org.olddriver.learnspringcloud.spring;

/**
 * RestTemplates
 * 20210820
 * 第四部分
 */
public class RestTemplates {
    /**
     * restful风格接口规范
     *
     * 远程服务调用组件
     * 使用负载均衡客户端
     * 注入RestTemplate对象时使用@LoadBalanced注解修饰，使用负载均衡客户端根据服务名选择服务
     * 使用@LoadBalanced注解以后，url中需指定服务名，不能指定主机名端口号
     *
     * RestTemplate提供了各种请求方法的api
     *
     * 拦截器
     * 可以对RestTemplate发送的请求接收的响应进行拦截
     * 实现ClientHttpRequestInterceptor接口，重写intercept方法
     * 初始化RestTemplate时，加入自定义拦截器
     *
     * 传递请求头
     * RestTemplate中exchange方法可以传递请求头
     */
}
