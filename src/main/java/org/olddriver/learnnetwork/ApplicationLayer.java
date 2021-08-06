package org.olddriver.learnnetwork;

public class ApplicationLayer {
    /**
     * 网络应用体系结构
     * 客户服务器模式
     * 对等模式
     *
     * 进程通信
     * 标识进程 使用ip地址和tcp或udp端口号标识进程
     * socket api
     * 应用进程使用os提供的socket api使用传输层服务，发送或接收报文
     * socket
     * 使用传输层功能的工具，是通信的一端。
     * tcp udp安全性
     * tcp udp均使用明文传输，应用进程可通过ssl(安全套接字层)库对报文加密
     *
     * http协议
     * 使用tcp连接传输数据，在发送http请求之前，需建立tcp连接。
     * http1.0版本，使用非持久连接，一个连接只能传输一个响应数据
     * http1.1版本，使用持久连接，一个连接可以传输多个响应数据
     * http报文为ascii码，可读
     * cookie   由服务端生成，记录客户端状态
     *
     * ftp协议
     * 控制命令和数据传输在两个不同连接上进行
     * 客户端与服务器建立连接传输控制命令
     * 服务器和客户端建立连接传输数据
     *
     * email相关协议
     * 发送协议 smtp
     * 拉取协议 pop3
     *
     * dns domain name system
     * 域名系统用于将域名映射为ip，域名解析请求使用udp协议
     * 域名解析过程
     * 主机请求本地域名服务器解析域名，当本地域名服务器不知道对应ip时，本地域名服务器请求根域名服务器。属于递归查询
     * 当根域名服务器不知道对应ip时，会通知本地域名服务器下一级域名服务器地址，本地域名服务器再去请求下一级域名服务器。属于迭代查询
     *
     * CDN 内容分发网络
     *
     * tcp socket api
     * 提供可靠传输字节流的服务
     * 使用方式
     * 服务端
     * i.服务器进程运行后创建监听socket
     * ii.监听socket绑定本地ip，端口
     * iii.监听socket开始监听端口
     * iiii.当有客户端请求建立连接，监听socket会创建连接socket
     * 客户端
     * i.创建连接socket，隐式绑定通信双方ip，端口
     * ii.连接socket连接服务器，当获取到服务器应答后，连接建立完成
     * iii.开始发送数据
     *
     * udp socket api
     * 提供不可靠服务
     * 使用方式
     * 服务端
     * i.服务端进程运行后创建socket
     * ii.socket绑定ip，端口
     * iii.服务器进程从socket中读取数据
     * 客户端
     * i.客户端创建socket，隐式绑定ip，端口
     * ii.通过socket发送数据
     */
}
