package org.olddriver.learnjava.collections;

import org.junit.Test;
import org.olddriver.learnjava.oo.Enumeration;

import java.util.*;
import java.util.concurrent.*;

/**
 * 集合
 * 20200822
 * 第八部分
 */
public class Container {
    /**
     * 集合
     * 用于存储对象引用(容器只能存储引用数据类型)的数据结构
     *
     * 集合层次结构
     * 集合分为两大分支，
     * 一个分支继承Collection，存储对象引用；
     * Collection接口重要子接口包括List，Set，Queue。
     * List集合中元素有序，允许重复元素
     * Set集合中不允许重复元素，SortedSet为Set子接口，会对集合中元素排序
     * Queue集合通常从一端添加元素，另一端移除元素。
     * Deque是Queue子接口，为双端队列，可从两端添加元素，两端移除元素
     * BlockingQueue是Queue子接口，阻塞队列，线程安全
     * 另一个分支继承Map，存储Entry，Entry中包含key value映射关系。Entry可以是链表中的结点也可以是红黑树中的结点
     * Map中key不允许重复，SortedMap为Map子接口，会对键值对按key进行排序
     *
     * List实现
     * List接口存在两个重要实现，ArrayList和LinkedList
     * ArrayList    对顺序表的实现，使用数组存储元素，用变量记录表长
     *              jdk1.7 ArrayList默认数组容量是10，也可指定初始容量。扩容时默认扩容1.5倍，当1.5倍容量仍比元素个数小，扩容成元素个数长度。扩容后将原表中数据移动到新表中
     *              jdk1.8 ArrayList默认数组容量是0，延迟申请内存空间
     *              首次添加元素扩容，若通过无参构造器创建，容量最少扩容到10
     *              若通过指定容量的构造器创建，尝试扩容1.5倍
     *              Vector扩容时尝试扩容2倍
     * LinkedList   对链表实现，随机访问元素的速度低，但添加移除元素的速度高
     *              jdk1.8 中获取指定索引处元素，判断索引是否超过长度一半，未超过正向访问，超过反向访问
     * CopyOnWriteArrayList 线程安全的ArrayList，添加元素时会复制所有元素性能较差，适合读多写少的场景
     *
     * Set实现
     * Set接口存在三个重要实现，HashSet，TreeSet，LinkedHashSet
     * HashSet  使用HashMap实现
     * TreeSet  使用TreeMap实现
     * LinkedHashSet    使用LinkedHashMap实现
     * EnumSet  存储枚举的集合
     * CopyOnWriteArraySet  线程安全的set
     *
     * Map实现
     * Map接口存在三个重要实现，HashMap，TreeMap，LinkedHashMap
     * HashMap  对哈希表的实现，采用链地址法解决冲突
     *          哈希数组的元素类型为内部类Map.Entry，初始长度为16(1<<4)
     *          哈希冲突时，
     *          jdk7中会进一步判断链表结点中的key，key存在不新建结点，key不存在新建结点进行头插
     *          jdk8中会进一步判断链表结点中的key，key存在不新建结点，key不存在新建结点进行尾插
     *          当HashMap中元素个数大于阈值，进行扩容，以2倍扩容。扩容后将元素再次散列到新数组
     *          jdk8中当HashMap中某个散列地址的链表长度超过8且散列数组长度大于树化最小长度进行树化
     * TreeMap  对红黑树的实现
     * EnumMap  存储枚举的Map
     * WeakHashMap  Map中key为弱引用
     * IdentityHashMap  添加键值对时使用==判断key是否相同
     * ConcurrentHashMap    线程安全HashMap
     *
     * Queue实现
     * Queue接口重要实现，LinkedList，PriorityQueue
     *
     * Deque实现
     * Deque接口重要实现，LinkedList，ArrayDeque
     *
     * 容器从最早线程安全版本(Vector，HashTable)发展到线程不安全版本(Arraylist，LinkedList)，之后又出现线程安全的版本以及并发版本
     * 新版本容器效率未必一定高于旧版本，需要通过实验验证
     */

    @Test
    public void testDeque(){
        Deque<String> linkedList = new LinkedList<>();
        linkedList.addLast("hello");
        linkedList.addLast("world");
        linkedList.addLast("hello");
        linkedList.addLast("java");

        linkedList.removeFirst();
        linkedList.removeFirst();

        linkedList.stream().forEach((ele)->{
            System.out.println(ele);
        });

        Deque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.addLast("hello");
        arrayDeque.addLast("world");
        arrayDeque.addLast("hello");
        arrayDeque.addLast("java");

        arrayDeque.stream().forEach((ele)->{
            System.out.println(ele);
        });
    }

    @Test
    public void testQueue(){
        Queue<String> linkedList = new LinkedList<>();
        linkedList.offer("good");
        linkedList.offer("luck");
        linkedList.offer("hello");
        linkedList.offer("world");
        linkedList.poll();
        linkedList.stream().forEach((ele)->{
            System.out.println(ele);
        });

        Queue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer("hello");
        priorityQueue.offer("java");
        priorityQueue.offer("good");
        priorityQueue.offer("luck");

        priorityQueue.stream().forEach((ele)->{
            System.out.println(ele);
        });

        Queue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(10);
        arrayBlockingQueue.offer("hello");
        arrayBlockingQueue.offer("world");
        arrayBlockingQueue.offer("good");
        arrayBlockingQueue.offer("luck");

        arrayBlockingQueue.stream().forEach((ele)->{
            System.out.println(ele);
        });
    }

    @Test
    public void testMap(){
        Map<String,String> hashMap = new HashMap<>();

        hashMap.put("hello","world");
        hashMap.put("good","luck");

        hashMap.entrySet().stream().forEach((ele)->{
            System.out.println(ele.getKey()+"----"+ele.getValue());
        });

        Map<String,String> treeMap = new TreeMap<>();
        treeMap.put("hello","world");
        treeMap.put("good","luck");
        treeMap.entrySet().stream().forEach((ele)->{
            System.out.println(ele.getKey()+"---"+ele.getValue());
        });


        Map<String,String> identityHashMap = new IdentityHashMap<>();

        identityHashMap.put(new String("hello"),"world");
        identityHashMap.put(new String("hello"),"java");

        identityHashMap.put(new String("hello"),"hello");

        identityHashMap.entrySet().stream().forEach((ele)->{
            System.out.println(ele.getKey()+"---"+ele.getValue());
        });

        Map<String,String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("hello","java");
        concurrentHashMap.put("good","luck");

        concurrentHashMap.entrySet().stream().forEach((ele)->{
            System.out.println(ele.getKey()+"--"+ele.getValue());
        });

    }


    @Test
    public void testSet(){
        Set<String> hashSet = new HashSet<>();

        hashSet.add("hello");
        hashSet.add("world");
        hashSet.add("good");
        hashSet.add("luck");

        hashSet.stream().forEach((ele)->{
            System.out.println(ele);
        });


        Set<String> treeSet = new TreeSet<>();
        treeSet.add("hello");
        treeSet.add("world");
        treeSet.add("good");
        treeSet.add("luck");

        treeSet.stream().forEach((ele)->{
            System.out.println(ele);
        });

        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.add("hello");
        copyOnWriteArraySet.add("world");
        copyOnWriteArraySet.add("good");
        copyOnWriteArraySet.add("luck");

        copyOnWriteArraySet.stream().forEach((ele)->{
            System.out.println(ele);
        });

        EnumSet<Enumeration> enumSet = EnumSet.allOf(Enumeration.class);
        enumSet.stream().forEach((ele)->{
            System.out.println(ele);
        });


    }



    @Test
    public void testList(){
        List<String> arrayList = new ArrayList<>();
        arrayList.add("hello");
        arrayList.add("world");
        arrayList.add("good");
        arrayList.add("luck");

        arrayList.stream().forEach((ele)->{
            System.out.println(ele);
        });

        List<String> linkedList = new LinkedList<>();
        linkedList.add("hello");
        linkedList.add("world");
        linkedList.add("good");
        linkedList.add("luck");

        linkedList.stream().forEach((ele)->{
            System.out.println(ele);
        });


        List<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add("hello");
        copyOnWriteArrayList.add("world");
        copyOnWriteArrayList.add("good");
        copyOnWriteArrayList.add("luck");

        Runnable task = ()->{
            copyOnWriteArrayList.stream().forEach((ele)->{
                System.out.println(Thread.currentThread().getName() + " print " + ele);
            });
        };

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.submit(task);
        executorService.submit(task);


    }

    @Test
    public void test() {
        List<String> list = Collections.singletonList("hello");

        System.out.println(list+"---"+list.getClass());

        Set<String> set = Collections.singleton("java");
        System.out.println(set+"---"+set.getClass());


        Map<String, String> map = Collections.singletonMap("good", "luck");
        System.out.println(map+"---"+map.getClass());
    }
}
