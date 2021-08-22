package org.olddriver.learnspringcloud.netflix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * Hystrix
 * 20210820
 * 第六部分
 */
public class Hystrix extends HystrixCommand {
    /**
     * netflix提供的容错组件，用于服务降级，隔离，熔断
     *
     * 服务降级
     * 客户端调用服务端时，当服务端出现异常或超时，使用托底数据，即服务降级
     * 服务隔离
     * 针对每个服务的请求使用独立的有限资源处理，当资源用尽，不再发送请求，请求直接降级。
     * 限制对服务并发请求数，防止对一个服务的请求占用过多线程影响对其他服务调用
     * 服务熔断
     * 对一个服务的请求失败次数达到阈值，不再发送请求，请求直接降级。当服务正常后恢复调用
     *
     * hystrix脱离spring cloud使用
     * 创建HystrixCommand子类，重写run方法，getFallback方法
     * run方法封装逻辑，getFallback方法提供托底数据。通过execute方法执行run方法，当run方法抛出异常，会返回getFallback方法返回值
     *
     * 整合Feign
     * feign默认不使用hystrix进行服务降级，需手动开启
     * feign.hystrix.enabled属性开启hystrix
     * 方式1  使用Fallback类声明Fallback方法，但无法获取服务端异常
     * i.创建Fallback类，实现feign接口，重写接口中抽象方法提供托底数据
     * ii.通过@FeignClient的fallback方法指定Fallback类
     * 方式2  使用FallbackFactory，获取服务端异常信息
     * i.实现FallbackFactory，重写create方法，根据异常决定降级行为
     * ii.通过@FeignClient的fallbackFactory方法指定FallbackFactory类
     * feign整合hystrix时，若feign接口上使用Mapping注解，会导致url重复
     *
     * 整合RestTemplate
     * i.在service中声明fallback方法
     * ii.在service方法上使用@HystrixCommand注解指定fallback方法，以便进行服务降级
     * iii.启动类上添加@EnableCircuitBreaker，启用hystrix配置
     *
     * 服务隔离策略
     * 线程池隔离
     * 对每个服务的请求使用独立的线程池处理，异步发出远程调用请求
     * 信号量隔离
     * 通过juc中Semaphore限制对每个服务的并发请求数，当并发请求数达到上限，直接降级，不创建独立的线程池
     * 使用hystrix.command.default.execution.isolation.strategy切换hystrix隔离策略，对所有调用有效，
     * ?????使用hystrix.command.方法名.execution.isolation.strategy可针对方法进行配置?????
     *
     * hystrix控制面板，查看线程池信息
     * i.添加dashboard和actuator相关依赖
     * ii.启动类上添加@EnableHystrixDashboard注解，@EnableCircuitBreaker注解
     * iii.对外暴露hystrix.stream端点
     * iiii.hystrix.dashboard.proxy-stream-allow-list   指定
     * iiiii.通过 /actuator/hystrix.stream 查看相关信息
     *      通过 /hystrix 查看图形化页面
     */

    protected Hystrix(HystrixCommandGroupKey group) {
        super(group);
    }

    @Override
    protected Object run() throws Exception {
        if (true) {
            throw new RuntimeException("error");
        }
        return "success";
    }

    @Override
    protected Object getFallback() {
        return "fallback";
    }

    public static void main(String[] args) {
        Hystrix hystrix = new Hystrix(HystrixCommandGroupKey.Factory.asKey("ext"));
        System.out.println(hystrix.execute());
    }
}
