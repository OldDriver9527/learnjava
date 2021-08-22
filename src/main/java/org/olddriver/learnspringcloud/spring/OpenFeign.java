package org.olddriver.learnspringcloud.spring;

/**
 * OpenFeign
 * 20210820
 * 第五部分
 */
public class OpenFeign {
    /**
     * OpenFeign在Feign基础上升级，通过springmvc注解组装请求
     *
     * 使用方式
     * i.类似RestTemplate方式
     * 消费方声明api接口，使用@FeignClient修饰。接口中抽象方法使用springmvc注解修饰。接口实现由框架实现，
     * 进行远程调用时直接注入实现对象
     * @FeignClient的url方法指定访问的服务提供方url。使用url时不使用eureka服务列表，不进行负载均衡
     * @FeignClient的name方法指定服务提供方名称
     * ii.服务方提供api接口，消费方面向接口开发
     * 服务方使用一个独立模块定义对外暴露的api接口，接口中定义方法规则
     * 消费方添加api模块依赖，feign客户端直接继承api接口，不需自己开发
     *
     * feign请求参数，请求方法组装
     * feign根据springmvc注解组装请求
     * 无参方法，此时根据Mapping注解决定请求方法
     * 无参数注解时，默认为参数添加@RequestBody注解将请求参数加入body中，使用post请求方法
     * 使用@RequestParam注解时将请求参数加入uri中，根据Mapping注解决定请求方法
     * 使用@RequestBody注解时将请求参数加入body中，会参考Mapping注解，若Mapping注解是post，put等方法，会根据Mapping注解决定；
     * 若Mapping注解是get等方法，会使用post方法
     *
     * 切换feignclient实现
     * 将feignclient默认实现替换为apache实现，会根据Mapping注解决定请求方法，根据参数注解封装参数，两者互不影响
     *
     * 重试机制
     * 超时后进行重试，超时分为连接超时，业务逻辑超时
     * feign默认关闭自己的重试机制，使用ribbon的重试机制
     * ribbon.ConnectTimeout    指定连接超时时间
     * ribbon.ReadTimeout   指定业务逻辑超时时间
     * ribbon.MaxAutoRetries    同一服务上最大重试次数，不包括首次调用
     * ribbon.MaxAutoRetriesNextServer  切换实例次数
     * ribbon.OkToRetryOnAllOperations  是否所有请求方法均重试，false时仅对get方法重试
     * 当首次请求发生超时，会在当前服务上尝试MaxAutoRetries次，若均超时会切换MaxAutoRetriesNextServer次服务，每个实例上尝试
     * MaxAutoRetries+1次
     *
     * 日志
     */
}
