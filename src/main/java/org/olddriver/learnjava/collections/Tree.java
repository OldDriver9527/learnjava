package org.olddriver.learnjava.collections;

/**
 * 树
 * 20200822
 * 第六部分
 */
public class Tree {
    /**
     * 树
     * 一种非线性结构，由n个数据元素组成的集合。
     * n等于0时，称为空树；n大于0时，集合由根及若干不相交子树组成，子树又由根和若干不相交子树组成
     * 树中元素最多有一个直接前趋，可以有多个直接后继
     *
     * 结点   结点中包含数据元素及若干直接后继的地址
     * 根结点  无前趋的结点
     * 结点度    结点直接后继的个数
     * 树度  结点度的最大值
     * 叶子结点 度为0的结点
     * 孩子   当前结点的后继结点称为当前结点的孩子
     * 双亲   当前结点的前趋结点称为当前结点的双亲
     * 兄弟   具有相同双亲的结点称为兄弟
     * 祖先   从根结点到当前结点所经历的结点都是当前结点的祖先
     * 子孙   以当前结点为根的子树中的子树上任意结点都是当前结点的子孙
     * 树深度   树的最大层次
     * 有序树  树中子树具有次序
     * 无序树  树中子树不具有次序
     * 森林   由m个不相交树组成森林
     *
     * 二叉树(特殊类型的树)
     * 普通树为多叉树，难以实现。可将普通树转化为唯一对应的二叉树
     * 二叉树由根和不相交左右子树组成，子树又由根和不相交左右子树组成
     * 左右子树具有次序，不能颠倒。左右子树可以为空
     *
     * 二叉树的基本形态
     * 空树
     * 左右子树为空
     * 左子树不为空，右子树为空
     * 左子树为空，右子树不为空
     * 左子树不为空，右子树不为空
     *
     * 满二叉树
     * 二叉树达到最大结点数称为满二叉树
     *
     * 完全二叉树
     * 深度为k的二叉树编号与深度为k的满二叉树编号完全一致时为完全二叉树
     *
     * 二叉树特点
     * 二叉树中第i层最多2^(i-1)个结点
     * i层二叉树中最多2^i-1个结点(等比数列求和)，最少i个结点
     * 叶子结点个数等于度为二的结点个数加一
     * n个结点的完全二叉树深度为floor(log2n)
     * n个结点的完全二叉树，编号为i的结点，其双亲结点编号为floor(i/2)，左孩子编号为2i，右孩子编号为2i+1
     *
     * 二叉树的顺序存储结构
     * 使用一组连续空间存储元素，元素按满二叉树中的编号进行存储，空位也需要占位
     * 对于编号不连续的二叉树会浪费存储空间，适用于满二叉树，完全二叉树
     *
     * 二叉树的链式存储结构
     * 使用一组任意存储空间存储元素，元素间逻辑关系通过指针确定
     * 二叉链表
     * 结点中包含数据域，两个指针域分别指向左右孩子
     * n个结点的二叉链表中，共n+1个空指针
     * 三叉链表
     * 结点中包含数据域，三个指针域分别指向左右孩子，双亲
     *
     * 遍历二叉树(适用于顺序存储结构和链式存储结构)
     * 定义L，D，R表示左子树，根，右子树。遍历二叉树共DLR，LDR，LRD，DRL，RLD，RDL六种
     * DLR称为先根遍历
     * LDR称为中根遍历
     * LRD称为后根遍历
     * 递归实现二叉树遍历
     * 栈实现二叉树先序遍历，中序遍历
     * 指针沿树的结点滑动，指针只向左侧滑动，将指针经过的结点压栈。
     * 当指针滑动到末端，取栈顶元素，指针指向栈顶元素的右孩子，将右孩子压栈继续滑动。
     * 当指针为空且栈为空时就遍历了所有结点
     * 需循环修改指针的值，
     * 当指针不为空，将指向结点入栈，指针指向当前结点左孩子
     * 当指针为空，取栈顶元素，指针栈顶元素的右孩子
     * 当指针为空且栈为空时，退出循环。
     * 栈实现二叉树后序遍历
     * 指针沿树的结点滑动，指针只向左侧滑动，将指针经过的结点压栈。
     * 当指针滑动到末端，指针指向栈顶元素但不弹栈，
     * 只有在当前结点无右孩子或此右孩子已经遍历过(此右孩子不是已遍历结点变量中记录的值)的情况下，弹出栈顶元素(相当于遍历完)，此结点记录为已遍历过的结点，指针清空
     * 否则指针指向右孩子，将右孩子压栈继续滑动。
     * 二叉树层次遍历
     * 从上到下，从左到右遍历树中每个结点
     * 使用辅助队列实现
     * 先将根结点入队，之后队尾元素出队，出队同时将左右孩子入队
     * 当队列为空就遍历的所有结点
     *
     * 二叉树深度计算(递归)
     * 结点为null时深度为0，
     * 结点不为null时树深度等于左右子树深度较大值加一，采用递归方式计算左右子树深度
     * 二叉树结点个数(递归)
     * 结点为null时个数为0，
     * 结点不为null时个数等于左子树个数加右子树个数加一，采用递归方式计算左右子树结点个数
     * 二叉树叶子结点个数(递归)
     * 结点为null时个数为0，
     * 结点为叶子结点时个数为1，
     * 结点不为叶子结点时个数等于左子树叶子结点个数加右子树叶子结点个数，采用递归方式计算左右子树叶子结点个数
     *
     * 线索二叉树
     * 使用结点中的空指针存储先序或中序或后序序列中的前序及后继的地址
     * 在结点中添加标记区分指针类型(0-表示左右孩子地址，1-前序后继地址)
     * 左指针存储左孩子地址或前序地址，使用标记区分
     * 右指针存储右孩子地址或后继地址，使用标记区分
     * 线索二叉树中存在2个空指针，都可存储头结点地址
     * 头结点中不存数据，左孩子指向根结点，后继指向序列中最后一个结点
     *
     * 二叉查找树
     * 左子树上的结点均小于根，右子树上的结点均大于等于根
     * 左右子树又均为二叉查找树
     *
     * 平衡二叉树
     * 左右子树深度差小于等于一的二叉查找树
     * 左右子树也为平衡二叉树
     *
     * 红黑树
     * 近似平衡二叉树，左右子树深度差可不小于一
     * 树中结点分为红黑两种
     * 根结点为黑色
     * 叶子结点为不存储数据的黑色结点(叶子结点可省略)
     * 红结点的孩子为黑色
     * 从任意结点出发到叶子结点包含的黑结点数量相同
     * 左旋
     * 对结点x左旋，x的右孩子记为y
     * y替代x位置，x替代y的左孩子位置，y的左孩子作为x的右孩子
     * 右旋
     * 对结点x右旋，x的左孩子记为y
     * y替代x位置，x替代y的右孩子，y的原右孩子作为x的左孩子
     *
     * b树(多叉平衡查找树)
     * b树中一个结点数据域可以包含多个元素，指针域包含多个孩子的地址
     *

     *
     * 树的双亲表示法
     * 使用数组存储树中结点，结点中除了元素外，还包括双亲的位置
     * 树的孩子链表表示法
     * 使用数组存储树中结点，结点中除了元素外，还包括
     */
}
