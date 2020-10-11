package org.olddriver.learnjava.collections;

/**
 * 20200829
 * part 3
 */
public class Implementations {
    /*
     * Set实现
     * 通用实现
     * Set接口具有三个通用实现，HashSet，TreeSet，LinkedHashSet。HashSet为最佳实现
     * HashSet
     * 通过HashMap实现
     * HashSet使用hashCode方法，equals方法判断元素是否相等
     * TreeSet
     * TreeSet中元素必须实现Comparable接口或创建TreeSet时传入比较器
     * TreeSet使用元素compareTo方法或比较器compare方法判断元素是否相等
     * LinkedHashSet
     * LinkedHashSet使用元素hashCode方法，equals方法判断元素是否相等
     * 特殊实现
     * EnumSet
     * 用于存储同一枚举类型的枚举常量，为抽象类不能实例化，只能通过工厂方法创建EnumSet对象
     * CopyOnWriteArraySet
     * 线程安全
     *
     * List实现
     * 通用实现
     * List接口具有两个通用实现，ArrayList 和 LinkedList
     * ArrayList
     * 线程不安全，效率高，扩容时扩大为原来1.5倍。使用顺序表实现
     * ArrayList中使用元素equals方法判断元素是否相等
     * LinkedList 使用双向链表数据结构实现
     * LinkedList中使用元素equals方法判断元素是否相等
     * 特殊实现
     * CopyOnWriteArrayList
     * Vector
     * 线程安全，效率低，扩容时默认扩大为原容量2倍，也可指定扩大容量
     *
     * Map实现
     * 通用实现
     * Map接口具有三种通用实现，HashMap，TreeMap，LinkedHashMap
     * HashMap
     * 使用key的hashCode，equals方法判断key是否相等
     * jdk8中HashMap使用数组，链表，红黑树实现，HashMap中Node表示链表结点，TreeNode表示红黑树结点
     * HashMap构造器没有创建存储结点的数组，当第一次调用put方法添加元素时，对数组进行扩容完成创建数组.
     * 扩容完毕，计算元素在数组中的存放位置，根据散列码与数组长度求模的结果确定。由于数组长度必须是2的幂次，模运算简化为散列码&(数组长度-1)，
     * 若该位置无元素，直接创建链表结点存放到数组中
     * 若该位置存在元素，判断结点配型为链表结点还是红黑树结点，不同类型执行不同操作
     *
     * 特殊实现
     * EnumMap key可用于存放同一枚举类型的枚举常量，
     * WeakHashMap
     * IdentityHashMap
     * 并发实现
     * ConcurrentHashMap
     *
     * Queue实现
     * LinkedList
     * PriorityQueue
     * 并发实现
     * LinkedBlockingQueue
     * ArrayBlockingQueue
     * PriorityBlockingQueue
     * DelayQueue
     * SynchronousQueue
     * LinkedTransferQueue
     *
     * Deque实现
     * 通用实现
     * LinkedList
     * ArrayDeque
     * 并发实现
     * LinkedBlockingDeque
     *
     * 包裹实现
     * Synchronization包裹实现
     * Collections中synchronizedCollection方法，synchronizedSet方法，synchronizedList方法，synchronizedMap方法，
     * synchronizedSortedSet方法，synchronizedSortedMap方法用于创建线程安全的集合实现
     * Unmodifiable包裹实现
     * Collections中unmodifiableCollection方法，unmodifiableSet方法，unmodifiableList方法，
     * unmodifiableMap方法，unmodifiableSortedSet方法，unmodifiableSortedMap方法用于创建不可修改的集合视图
     */
}
