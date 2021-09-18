package org.olddriver.learndeployment;

/**
 * docker项目
 * 20210917
 * 第一部分
 */
public class Docker {
    /**
     * docker项目是一个cs结构应用，使用docker将应用与依赖资源整体打包生成镜像，便于迁移到其他linux平台
     * 与虚拟机相比，docker镜像中不包含操作系统内核，虚拟机中包含完整操作系统
     * 镜像   Image   构建容器的只读模板，镜像可以基于其他镜像。
     * 容器   Container   根据镜像创建的运行环境，可运行进程
     * 仓库   Repository  存放镜像
     *
     * docker命令
     * docker pull  拉取镜像
     * docker images    查看本地镜像，镜像存放在/var/lib/docker
     * docker run   创建容器，在docker容器中运行应用进程，将应用进程与宿主机进程相互隔离
     *              -p选项将宿主机端口与容器中应用进程端口映射
     *              -d选项后台运行应用进程
     *              --name选项指定容器名称
     * docker ps    查看docker容器，默认查看含有运行进程的容器
     *              -a选项查看所有容器
     * docker rm    删除容器
     *              -f选项强制删除
     * docker rmi   删除本地镜像
     * docker build 指定Dockerfile文件所在路径，根据Dockerfile文件构建镜像
     *              -t选项指定镜像名称，按机构/镜像:版本格式
     *
     * Dockerfile
     * 通过一系列指令创建自定义镜像
     * Dockerfile指令
     * FROM 指定自定义镜像的基础镜像，必须是文件中首条指令
     * MAINTAINER   指定维护者
     * LABEL    指定key-value标签
     * WORKDIR  指定工作目录，相当于cd作用。若指定的工作目录不存在会自动创建
     * ADD  将宿主机文件加入到容器中
     *      宿主机路径需从Dockerfile所在路径开始
     * ENV  设置docker容器中的环境变量
     * EXPOSE
     * ENTRYPOINT   指定容器启动后执行的命令，一定会执行。当Dockerfile中有多个ENTRYPOINT，只会执行最后一个
     * CMD  指定容器启动后执行的默认命令，可以被docker run参数覆盖，不一定会执行
     * RUN  在创建镜像时执行指定命令
     *
     * RUN，CMD，ENTRYPOINT命令格式
     * shell格式
     * exec格式
     *
     * 虚拟ip
     * docker容器创建完毕天生具有一个虚拟ip
     * 通过docker inspect命令查看容器元数据，可以获取容器虚拟ip
     *
     * 单主机容器间通信
     * 单主机上的容器可以通过虚拟ip或容器名通信，但虚拟ip会发生变化
     * 在创建容器时通过--link选项在hosts文件中添加容器名和虚拟ip的映射，实现通过容器名的单向通信
     * 使用相同网桥与外界通信的容器彼此之间互通，可以实现通过容器名的双向通信
     * 跨主机容器间通信
     *
     * 容器数据持久化
     * 数据卷是宿主机的一个目录，将数据卷挂载到容器中的一个目录后，容器中的数据可以存储在宿主机上，也可实现多个容器间数据共享
     * 创建容器时通过-v选项将数据卷挂载到容器中的一个目录
     * 也可以创建一个数据卷容器，通过-v选项将数据卷挂载到容器中的一个目录。之后所有容器通过--volumes-from选项共享数据卷容器的配置
     *
     * docker compose
     * 单主机多容器部署工具
     */
}
