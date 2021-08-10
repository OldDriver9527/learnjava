package org.olddriver.learnjava.jvm;

/**
 * hotspot参数
 * 20210808
 * 第七部分
 */
public class HotSpotOptions {
    /**
     * 参数分类
     * -    标准参数，所有hotspot均支持
     * -X   非标准参数，部分版本hotspot支持
     * -XX  不稳定参数，下个版本可能取消
     *
     * 内存泄漏 内存被无用对象占用，浪费现象
     * 内存溢出
     *
     * -XX:+PrintFlagsFinal 打印所有参数最终值
     * -XX:+PrintCommandLineFlags   打印程序通过命令行指定的参数
     * -Xmn 指定新生代大小
     * -Xms 指定heap最小值
     * -Xmx 指定heap最大值，防止heap弹性变换，一般将heap最大值最小值保持一致
     * -XX:+PrintGC  打印gc回收信息
     * -XX:+PrintGCDetails  打印gc详细信息
     * -XX:+PrintGCTimeStamps
     */
}
