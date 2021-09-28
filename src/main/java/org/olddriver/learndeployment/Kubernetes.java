package org.olddriver.learndeployment;
/**
 * 集群容器编排工具
 * 20210918
 * 第二部分
 */
public class Kubernetes {
    /**
     * kubernetes master    管理kubernetes集群中节点
     * node
     * pod  豆荚，k8s的最小控制单元。其中可以包含多个container
     *      每个pod拥有一个虚拟ip
     *      一个pod中包含一个pause容器，其他业务容器与pause容器共享网络和数据卷
     * label    pod的标签
     * service  进行pod间通信
     * replication controller   对pod进行监控，控制pod数量
     *
     * minikube
     *
     * kubeadmin安装kubernetes
     *
     */
}
