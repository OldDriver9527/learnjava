package org.olddriver.learnalgorithm;

/**
 * 20200809
 * part 1
 */
public class Algorithm {
    /*
     * 算法(algorithm)
     * 求解特定问题的方法和步骤，是一系列指令集合。
     *
     * 算法特性
     * i.有穷性
     * 算法中包含步骤必须有穷，每个步骤执行的时间必须是有穷
     * ii.确定性
     * 算法中每条指令必须具有确切含义
     * iii.可行性
     * 算法可执行
     * iiii.输入
     * 算法必须有0个或多个输入
     * iiiii.输出
     * 算法必须有输出
     *
     * 度量算法时间效率
     * 度量算法时间效率分为事后统计，事前分析两种方式，多采用事前分析方法
     *
     * 算法运行时间
     * 算法运行时间大致等于算法执行简单操作次数乘以计算机执行简单操作的时间，
     * 假设程序中每条语句都是简单操作，算法执行时间就转换为每条语句执行的次数乘以每条语句的执行时间最后求和，
     * 而语句的执行时间与计算机软硬件有关，与算法无关，所以算法执行时间再次简化为每条语句的执行次数乘以单位时间1后求和，
     * 即算法执行时间等于每条语句的频度之和，可用一个关于n的函数表示，记作T(n)，n表示问题规模
     *
     * 算法渐进时间复杂度
     * 为了便于比较不同算法的运行时间，仅比较运行时间的数量级。运行时间数量级表示为O(f(n))，f(n)与运行时间同数量级的函数，
     * O(f(n))称为算法渐进时间复杂度，简称时间复杂度
     * 同数量级函数
     * 若存在辅助函数f(n)，当n趋于无穷大，T(n)/f(n)等于不为0常数，称f(n)为T(n)的同数量级函数，存在T(n)=O(f(n))(Big O表示数量级)
     *
     * 计算时间复杂度
     * 计算时间复杂度时，一般情况不需计算算法中所有语句的频度之和，只需计算算法中基本语句的频度，基本语句指算法中执行次数最多的语句，
     * 若基本语句频度为g(n)，n表示问题规模，忽略低阶项和最高阶项系数后为f(n)，那么算法的时间复杂度为O(f(n))
     * for嵌套的时间复杂度可以使用级数进行计算
     * 算法中基本语句的执行次数除了与问题规模有关，还与输入数据集有关。
     * 考虑时间复杂度时需考虑最坏时间复杂度，平均时间复杂度，最好时间复杂度
     * 最坏时间复杂度 在最糟糕情况下，时间复杂度
     * 平均时间复杂度 所有输入在等概率出现情况下，时间复杂度
     * 最好时间复杂度 在最理想情况下，时间复杂度
     *
     * big O 加法规则，乘法规则
     * T(n) = T1(n) + T2(n) = O(f(n)) + O(g(n)) = O(max(f(n),g(n)))
     * T(n) = T1(n) * T2(n) = O(f(n)) * O(g(n)) = O(f(n)*g(n))
     *
     * 算法占据空间
     * 算法占用空间S(n)等于算法本身占据空间加算法要使用的辅助空间。
     *
     * 算法渐进空间复杂度
     * 算法占用空间为S(n)，与S(n)同数量级的函数为f(n)，则算法占用空间的数量级标识为O(f(n))，称为算法空间复杂度
     *
     * 计算空间复杂度
     * 将算法使用的辅助空间表示为问题规模n的函数，即f(n)，算法的空间复杂度为O(f(n))
     *
     * 空间复杂度为O(1)的操作称为原地操作
     */
}
