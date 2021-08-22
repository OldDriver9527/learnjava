package org.olddriver.learnspringcloud.spring;

/**
 * Sleuth
 * 20210820
 * 第八部分
 */
public class Sleuth {
    /**
     * sleuth，zipkin
     * sleuth进行链路追踪，zipkin收集链路追踪数据进行可视化展示
     *
     * 搭建方式
     * i.在所有服务中添加sleuth，zipkin依赖
     * ii.https://zipkin.io/pages/quickstart.html下载zipkin ui服务
     * iii.修改配置文件
     * spring.zipkin.base-url   指定zipkin ui服务url
     * spring.sleuth.sampler.rate   ???
     *
     * 通过hostname:9411/zipkin访问ui平台
     */
}
