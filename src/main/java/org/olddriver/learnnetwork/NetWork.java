package org.olddriver.learnnetwork;

/**
 * 20210709
 * 网络
 * 第一部分
 */
public class NetWork {
    /**
     * 网络
     * 通过通信链路将若干结点连接形成网络。
     * 网络和网络之间连通，构成互联网，internet。
     *
     * 分组
     * 网络应用通过互联网传输数据，发送主机会将数据分为若干段，每段上添加首部信息形成分组
     *
     * 因特网
     * Internet，全球最大互联网
     * 因特网由主机，通信链路，分组交换机等因特网组件组成
     * 因特网是网络应用传输数据的基础设施。
     * 主机提供套接字接口，运行在主机上的程序通过socket api请求因特网将数据传输到目标主机的程序上
     *
     * 网络协议
     * 简称协议，定义两个或多个通信实体交换报文的规定。因特网中最重要的协议为tcp协议和ip协议
     *
     * 因特网结构
     * 网络边缘 所有连接在因特网上的主机组成网络边缘，主机上运行网络应用
     * 接入网络 将主机连接到核心网络中的边缘路由器，可以是简单通信链路或复杂网络
     *         家庭一般通过电话线路，有线电视线路接入核心网络
     *         企业一般通过局域网(LAN)，无线局域网(WLAN)接入核心网络
     *         以太网是一个局域网
     * 网络核心 由分组交换机和链路组成，连接各个端系统，实现分组交换
     *
     * 通信链路和分组交换机移动数据方式
     * 分组交换
     * 分组交换机采用存储转发机制移动分组，在分组交换机完全接收分组数据后才会转发分组
     * 分组交换的问题
     * 延时和丢失
     * 排队延时 分组在链路输出队列中等待的时间
     * 处理延时 分组交换机处理分组的时间
     * 传输延时 分组交换机发送分组的时间，等于分组长度L/链路带宽R
     * 传播延时 分组在链路中传播的时间，等于传播距离/传播速度
     * 分组丢失
     * 分组在输出过程中，当分组交换机输出队列已满，分组会丢失
     * 电路交换
     * 主机传输数据过程中会占用路径中资源
     *
     * 协议分层
     * 网络设计者以分层方式描述网络协议及实现网络协议的软件硬件
     * Internet协议栈包括物理层，链路层，网络层，传输层，应用层
     * 应用层  应用层中分组称为报文，提供在源进程与目标进程间的数据传输的服务
     * 传输层  传输层中分组称为报文段(segment)，提供可靠的在源主机到目标主机之间传输数据服务
     * 网络层  网络层中分组称为数据报，提供在源主机到目标主机之间传输数据的服务
     * 链路层  链路层中分组称为帧，提供在相邻结点间传输数据的服务
     * 物理层  提供将帧中数据转换为物理信号在相邻结点间传输的服务
     *
     * 封装
     * 两个进程间交换报文，源进程要对报文进行一次封装，目标进程最后要进行一次解封装。在传输路径中会进行若干次解封装和封装
     */
}
