package org.olddriver.learnjava.collections;

import org.junit.Test;
import org.olddriver.learnjava.oo.Enumeration;

import java.util.*;
import java.util.concurrent.*;

/**
 * 集合
 * 20200822
 * 第七部分
 */
public class Container {
    /**
     * 集合
     * 用于存储对象引用(容器只能存储引用数据类型)的数据结构
     * 集合分为两大分支，
     * 一个分支继承Collection，引用指向实际对象；
     * Collection接口重要子接口包括List，Set，Queue。
     * List集合中元素有序，允许重复元素
     * Set集合中不允许重复元素，SortedSet为Set子接口，会对集合中元素排序
     * Queue集合通常从一端添加元素，另一端移除元素。
     * Deque是Queue子接口，为双端队列，可从两端添加元素，两端移除元素
     * BlockingQueue是Queue子接口，阻塞队列，线程安全
     * 另一个分支继承Map，引用指向Entry对象，Entry对象中包含key value引用，分别指向键值对对象
     * Map中key不允许重复，SortedMap为Map子接口，会对键值对按key进行排序
     *
     * List实现
     * List接口存在两个重要实现，ArrayList和LinkedList
     * ArrayList    使用顺序表实现，随机访问元素的速度高，但添加移除元素的速度低
     * LinkedList   使用链表实现，随机访问元素的速度低，但添加移除元素的速度高
     * CopyOnWriteArrayList 线程安全的ArrayList，添加元素时会复制所有元素性能较差，适合读多写少的场景
     *
     * Set实现
     * Set接口存在三个重要实现，HashSet，TreeSet，LinkedHashSet
     * HashSet  使用哈希表实现
     * TreeSet  使用树实现
     * LinkedHashSet    使用哈希表和树实现
     * EnumSet  存储枚举的集合
     * CopyOnWriteArraySet  线程安全的set
     *
     * Map实现
     * Map接口存在三个重要实现，HashMap，TreeMap，LinkedHashMap
     * EnumMap  存储枚举的Map
     * WeakHashMap  Map中key为弱引用
     * IdentityHashMap  添加键值对时使用==判断key是否相同
     * ConcurrentHashMap    线程安全Map
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
