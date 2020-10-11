package org.olddriver.learnjava.collections;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 20200822
 * part 1
 */
public class Interfaces {
    /*
     * 集合
     * 用于存储对象的容器，集合只能存储引用数据类型
     * 集合长度可变
     * 集合是java自定义的数据结构，使用现有数据结构实现
     *
     * 集合核心接口
     * Collection接口 集合框架顶层接口，定义集合基本操作
     * size()   返回集合中元素个数
     * isEmpty()    判断集合是否为空
     * contains(Object o)   判断集合中是否包含与指定元素相等的元素，集合实现不同判断相等条件可能不同
     * add(E e) 向集合中添加指定元素，集合实现不同添加位置可能不同
     * remove(Object o) 移除集合中与指定元素相等的元素，集合实现不同判断相等条件可能不同
     * iterator()   获取在集合元素上迭代的迭代器
     * containsAll(Collection<?> c) 判断集合中是否包含所有与指定集合中元素相等的元素，集合实现不同判断相等条件可能不同
     * addAll(Collection<? extends E> c) 向集合中添加指定集合中的所有元素，集合实现不同添加位置可能不同
     * removeAll(Collection<?> c) 移除全部与指定集合中元素相等的元素，集合实现不同判断相等条件可能不同
     * retainAll(Collection<?> c) 保留两个集合中共有元素，移除非共有元素，集合实现不同判断相等条件可能不同
     * toArray() 将集合中元素转型为Object类型，添加进数组并返回
     * toArray(T[] a)   将集合中元素类型转型为指定类型T，添加进指定数组a中
     * clear() 清空集合，删除集合中所有元素
     *
     * 遍历集合方式
     * i.jdk8以后，推荐使用聚合操作遍历集合
     * ii.使用forEach语句遍历集合
     * iii.使用迭代器遍历集合
     *
     * Set接口 表示不允许重复元素的集合，元素无序
     * Set接口中未添加特有方法，仅继承Collection接口中方法
     * Set接口中基本操作
     * size() 返回集合中元素个数
     * isEmpty() 判断集合是否为空
     * add(E e) 向集合中添加指定元素，若指定元素与集中元素不重复可进行添加，集合实现不同添加位置可能不同
     * remove(Object o) 移除集合中与指定元素相等的元素，集合实现不同判断相等条件可能不同
     * containsAll(Collection<?> c) 判断集合中是否包含所有与指定集合中元素相等的元素，集合实现不同判断相等条件可能不同
     * addAll(Collection<? extends E> c) 向集合中添加指定集合中的所有元素，集合实现不同添加位置可能不同
     * retainAll(Collection<?> c) 保留两集合中共有元素，移除非共有元素，集合实现不同判断相等条件可能不同
     * removeAll(Collection<?> c) 移除所有与指定集合中元素相等的元素，集合实现不同判断相等条件可能不同
     *
     * List接口 表示有序集合，元素允许重复，称为列表
     * 列表基本操作
     * add(E e)，addAll(Collection<? extends E> c) 向列表尾部添加元素
     * remove(Object o) 移除列表中与指定元素相等的第一个元素
     * get(int index) 获取列表中指定索引处元素
     * set(int index, E element) 使用指定元素替换列表中指定索引处元素
     * add(int index, E element) 在列表指定索引处插入指定元素
     * remove(int index) 移除列表中指定索引处元素
     * indexOf(Object o) 获取列表中与指定元素相等元素第一次出现的索引
     * lastIndexOf(Object o) 获取列表中与指定元素相等元素最后一次出现的索引
     * 迭代操作
     * List除了提供Iterator迭代器以外，还提供了功能更加丰富的ListIterator
     * ListIterator是Iterator子类，可以双向迭代，迭代过程中维护列表中元素，获取当前迭代位置
     * 迭代器游标位于列表元素之间
     * next() 返回游标后的元素，游标后移一位
     * hasNext() 判断游标后是否存在元素
     * previous() 返回游标前元素，游标前移一位
     * hasPrevious() 判断游标前是否存在元素
     * nextIndex() 返回游标后元素索引
     * previousIndex() 返回游标前元素索引
     * add(E e) 将元素插入游标之前
     * set(E e) 使用指定元素替换列表中next方法或previous方法最近返回的元素
     * remove() 移除列表中next方法或previous方法最近返回的元素
     * 范围视图
     * subList(int fromIndex, int toIndex)方法返回当前列表的范围视图，视图中元素索引从fromIndex开始，到toIndex-1结束
     * 对视图修改会反映到列表上
     * 范围视图中元素索引从0开始计算
     * 获取范围视图后对列表进行修改，会导致范围视图失效，不能继续使用
     * 列表算法
     * Collections中提供操作列表算法
     * sort(List<T> list) 按照自然顺序，升序排序列表中元素。使用并归排序，稳定
     * shuffle(List<?> list) 随机排列列表中元素
     * reverse(List<?> list) 反转列表中元素顺序
     * rotate(List<?> list, int distance) 使用指定距离distance轮转列表中所有元素
     * swap(List<?> list, int i, int j) 置换列表中两个元素
     * replaceAll(List<T> list, T oldVal, T newVal) 使用新元素替换列表中所有与旧元素相等的元素
     * fill(List<? super T> list, T obj) 使用指定元素重写列表中所有元素
     * copy(List<? super T> dest, List<? extends T> src) 将目标列表中首部元素替换成源列表中的元素，目标列表长度需大于等于源列表长度
     * binarySearch(List<? extends Comparable<? super T>> list, T key) 使用二分查找算法在有序列表中查找指定元素
     * indexOfSubList(List<?> source, List<?> target) 查找目标列表在源列表中第一次出现的位置
     * lastIndexOfSubList(List<?> source, List<?> target) 查找目标列表在源列表中最后一次出现的位置
     *
     * Queue接口 称为队列
     * Queue接口中方法存在两种形式，操作失败时一种抛出异常，一种返回特殊值
     * 队列通常以FIFO的顺序存储元素，优先级队列除外。队列的头元素总是调用remove()，poll()移除的元素
     * FIFO队列中，新元素总是插入到队尾
     * java.util.concurrent包中队列实现为有界队列
     * add方法向队列中添加元素；offer方法同样用于添加元素，倾向于在有界队列上使用
     * remove方法，poll方法都用于移除头元素
     * element方法，peek方法用于获取头元素
     * 队列中通常不允许null作为元素，但由于历史原因LinkedList中可以添加null元素，应避免此情况
     *
     * Deque接口 双端队列(double-ended-queue)
     * Deque可以操作两端元素，实现类有ArrayDeque和LinkedList
     * Deque接口可作为LIFO栈使用及FIFO队列使用
     * 插入
     * addfirst方法，offerFirst方法向队列头部添加元素；addLast方法，offerLast方法在队列尾部添加元素
     * 对于有界队列倾向于使用offerFirst，offerLast
     * 移除
     * removeFirst方法，pollFirst方法移除队列中头元素；removeLast方法，pollLast方法移除队列尾元素
     * 检索
     * getFirst方法，peekFirst方法获取队列头元素；getLast方法，peekLast方法获取队列尾元素
     * removeFirstOccurence 移除队列中第一次出现且与指定元素相等的元素
     * removeLastOccurrence 移除队列中最后一次出现且与指定元素相等的元素
     *
     * Map接口 称为映射，将键映射到值。存储键值对的集合
     * 映射中键不能重复
     * Map接口基本操作
     * put(K key, V value) 向映射中添加键值对，若键在映射中已存在，使用新值覆盖旧值
     * get(Object key) 返回key映射的值
     * containsKey(Object key) 判断映射中是否包含与指定键相等的键
     * containsValue(Object value) 判断映射中是否包含与指定值相等的值
     * size() 返回映射中键值对数量
     * isEmpty() 判断映射是否为空
     * clear() 移除映射中所有键值对
     * putAll(Map<? extends K, ? extends V> m) 添加指定映射中所有键值对
     * 集合视图
     * keySet() 返回包含映射中所有键的set视图
     * values() 返回包含映射中所有值的collection视图
     * entrySet() 返回包含映射中所有映射关系的set视图
     * 在迭代过程中，通过Map.Entry的setValue修改值是唯一安全的方法
     * 三种集合视图不支持添加操作
     *
     * SortedSet接口 Set子接口，称为有序集
     * SortedSet根据元素自然顺序升序排序或按照比较器顺序升序排序
     * 范围视图
     * subSet(E fromElement, E toElement) 返回范围视图，视图中元素大于等于fromElement元素，小于toElement元素
     * headSet(E toElement) 返回范围视图，视图中元素小于toElement元素
     * tailSet(E fromElement) 返回范围视图，视图中元素大于等于fromElement元素
     * 获取范围视图后，对set进行修改，范围视图仍有效
     * 端点操作
     * first() 返回集合中最小元素
     * last() 返回集合中最大元素
     *
     * SortedMap接口 有序映射
     * SortedMap按照key的自然顺序或比较器顺序升序排序
     * 范围视图
     * subMap(K fromKey, K toKey) 返回范围视图映射，视图中key大于等于fromKey，小于toKey
     * headMap(K toKey) 返回范围视图映射，视图中键小于toKey
     * tailMap(K fromKey) 返回范围视图映射，视图中键大于等于fromKey
     * 获取范围视图后，对map进行修改，范围视图仍有效
     * 端点操作
     * firstKey() 获取映射中最小的key
     * lastKey() 获取映射中最大的key
     */

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        Collections.addAll(set,"a","b");

        System.out.println(set.size());

        System.out.println(set.isEmpty());

        System.out.println(set.add("a"));

        System.out.println(set.remove("a"));




    }
}
