package org.olddriver.learnnetwork;

/**
 * 20210709
 * 应用层
 * 第二部分
 */
public class ApplicationLayer {
    /**
     * 网络应用体系结构
     * 客户端服务器结构
     * 对等模式
     *
     * 进程通信
     * 程序通信实际为进程间通信。两个运行在不同主机上的进程通过因特网交换报文
     * 应用进程通过套接字接口向网络发送报文和从网络接收报文
     * 套接字是通信的端点
     *
     * 应用层可使用的传输层服务
     * 可靠数据传输服务
     * 发送进程将数据交给套接字后，接收进程一定会接收到正确的数据
     * 确保吞吐量服务
     * 定时服务
     * 保证分组数据在一定时间内到达接收进程
     * 安全服务
     * 对分组数据进行加密
     *
     * tcp服务
     * tcp协议提供面向连接的服务和可靠数据传输服务
     * 面向连接的服务
     * 在应用层开始交换报文前，tcp协议要求通信双方在传输层交换控制信息，握手完成后就建立了tcp连接
     * 可靠数据传输服务
     * 发送进程将数据交给套接字后，接收进程一定会收到正确的数据
     * udp服务
     * udp协议提供不可靠数据传输服务
     * 无连接，不保证接收方一定能收到数据
     *
     * 应用层协议
     * http协议
     * web应用使用http协议。http协议由客户端程序和服务器程序双方实现
     * http协议使用tcp协议作为支撑，在发送http请求之前，需建立tcp连接。
     * 服务器端不存储客户端任何信息，http协议为无状态协议
     * http存在持续连接模式，非持续连接模式
     * 非持续连接模式    一个请求/响应对通过一个tcp连接传递
     * 持续连接模式     相同客户的多个请求/响应对通过一个tcp连接传递
     * http1.0版本使用非持续连接模式；http1.1版本，使用持续连接模式
     * http请求报文
     * 包括请求行，请求头，请求体
     * 请求行中包括请求方法，资源uri，http版本
     * 请求头包含客户端请求
     * 请求体与请求头之间存在一空行
     * http响应报文
     * 包括响应行，响应头，响应体
     * 响应行包括http版本，响应码，响应码描述
     * 响应头可以控制浏览器行为
     * 响应体与响应头之间存在一空行
     *
     * smtp，pop3
     * 发送协议 smtp
     * 拉取协议 pop3
     *
     * dns协议
     * dns协议基于udp协议
     * 域名系统(dns)提供域名与ip转换的目录服务
     * dns服务器分类
     * 根dns服务器  维护顶级域和顶级域dns服务器ip
     * 顶级域dns服务器    维护权威域和权威dns服务器ip
     * 权威dsn服务器
     * 本地dns服务器 位于isp网络中，起到代理作用
     * 域名解析过程
     * 主机请求本地dns服务器
     * 本地dns服务器请求根dns服务器，获取顶级域dns服务器
     * 本地dns服务器请求顶级域dns服务器，获取权威dsn服务器
     * 本地dns服务器请求权威dsn服务器，获取ip地址
     * dns缓存
     * dns服务器会将响应缓存，减少dns查询次数
     *
     * CDN 内容分发网络
     *
     * tcp套接字编程
     * 服务端
     * i.服务器进程运行后创建欢迎socket(serverSocket)
     * ii.欢迎socket绑定ip，端口
     * iii.欢迎socket开始等待客户端的tcp连接请求
     * iiii.当有客户端请求建立tcp连接，服务端会创建连接socket(connectionSocket)与客户端通信
     * 客户端
     * i.创建连接socket，隐式绑定通信双方ip，端口。向服务端发送tcp连接请求
     * ii.当获取到服务器应答后，连接建立完成
     * iii.开始发送数据
     *
     * udp套接字编程
     * udp协议无连接，每个分组中包含目标进程的ip，端口
     * 服务端
     * i.服务端进程运行后创建socket，绑定ip，端口
     * ii.服务器等待接客户端发送的分组
     * 客户端
     * i.客户端创建socket，隐式绑定ip，端口
     * ii.通过socket发送分组
     */
}
