package org.olddriver.learnjava.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 聚合操作
 * 20200823
 * 第八部分
 */
public class AggregateOperations {
    /**
     * 聚合操作(Aggregate Operations)
     * jdk8新增特性，提供一种新的对集合元素操作方式，不再通过迭代器操作元素
     *
     * 流水线(Pipelines)，流(Streams)
     * 流水线是聚合操作的序列，一个流水线由源，0个或多个中间操作，终结操作构成
     * 流水线中若无终结操作，整个流水线不会执行
     * 流是元素序列，不是一种数据结构，它只是某种数据源的一个视图。
     * 针对double，long，int类型存在DoubleStream，LongStream，IntStream
     * 源(source)可以是集合，数组等
     * 中间操作(intermediate operations)产生新Stream，常用中间操作包括过滤，截取，映射
     * 终结操作(terminal operation)产生非流结果，常用终结操作包括化简，收集，遍历，查找，匹配
     *
     * 归约操作
     * i.reduce方法
     * 将Stream中的多个值合并成一个值，参数列表中
     * identity表示化简操作初始值
     * accumulator表示累加器，将流中元素进行累加
     * combiner表示组合器，并行模式下将产生的多个中间结果合并
     * ii.collect方法
     * 将Stream中的多个值加入结果结果容器，参数列表中
     * supplier表示提供商，用于提供存储元素的容器
     * accumulator表示累加器，用于将流中元素加入容器
     * combiner表示组合器，并行模式下将产生的多个容器中的元素合并
     * collector表示收集器，将输入元素累加到容器中
     * iii.Collectors
     * Collector工具类，创建预定义Collector对象
     *
     * parallelism
     * 并行流，执行时被划分为若干子流，采用多线程执行聚合操作
     */


    @Test
    public void test() {
        String[] arr = {"1", "2", "3"};

        Optional<String> max = Stream.of(arr).max((x, y) -> {
            return x.compareTo(y);
        });

        System.out.println(max.get());

    }


    @Test
    public void testReduction() {
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(2);
        temp.add(3);

        Optional<Integer> reduce = temp.stream().reduce((x, y) -> {
            return x + y;
        });
        System.out.println(reduce.get());

    }

    /**
     * 并行Stream
     */
    @Test
    public void testCollect1() {
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(2);
        temp.add(3);

        temp.parallelStream()
                .filter((ele) -> {
                    System.out.println(Thread.currentThread().getName());
                    return true;
                }).forEach((ele) -> {
                    System.out.println(ele);
                });


    }

    /**
     * Stream中collect   将Stream中元素收集到集合中
     */
    @Test
    public void testCollect() {
        List<String> temp = new ArrayList<>();
        temp.add("2021-11-07");
        temp.add("星期日");
        temp.add("雪");

        List<String> collect = temp.stream().collect(Collectors.toList());
        System.out.println(collect);
    }


    /**
     * Stream中map   将Stream中元素按指定规则映射成新Stream流中的新元素
     */
    @Test
    public void testMap() {
        List<String> temp = new ArrayList<>();
        temp.add("2021-11-07");
        temp.add("星期日");
        temp.add("雪");

        temp.stream().map((ele) -> {
            return ele.length();
        }).forEach((ele) -> {
            System.out.println(ele);
        });
    }


    /**
     * Stream中skip  跳过Stream中若干元素后进行截取，创建新的Stream对象
     */
    @Test
    public void testSkip() {
        List<String> temp = new ArrayList<>();
        temp.add("2021-11-07");
        temp.add("星期日");
        temp.add("雪");

        temp.stream().skip(1).forEach((ele) -> {
            System.out.println(ele);
        });

    }

    /**
     * Stream中limit 对Stream中元素从头开始截取，创建新Stream对象
     * 当新流的元素个数大于原流中元素个数，不截取
     */
    @Test
    public void testLimit() {
        List<String> temp = new ArrayList<>();
        temp.add("2021-11-07");
        temp.add("星期日");
        temp.add("雪");

        temp.stream().limit(1).forEach((ele) -> {
            System.out.println(ele);
        });
    }


    /**
     * Stream中filter    对Stream中元素进行过滤，创建新的Stream对象，新Stream中仅包含满足过滤条件的元素
     */
    @Test
    public void testFilter() {
        List<String> temp = new ArrayList<>();
        temp.add("2021-11-07");
        temp.add("星期日");
        temp.add("雪");


        temp.stream().filter((ele) -> {
            System.out.println("1111111111111111");
            return ele.length() > 2;
        }).forEach((ele) -> {
            System.out.println(ele);
        });
    }

    /**
     * Stream中count 统计Stream流中元素个数
     */
    @Test
    public void testCount() {
        List<String> temp = new ArrayList<>();
        temp.add("2021-11-07");
        temp.add("星期日");
        temp.add("雪");

        long count = temp.stream().count();
        System.out.println(count);

    }


    /**
     * Stream中forEach   对Stream中每个元素执行指定操作
     */
    @Test
    public void testForEach() {
        String[] arr = {"北京", "上海", "广州", "江苏"};
        Stream.of(arr).forEach((ele) -> {
            System.out.println(ele);
        });
    }

    /**
     * Stream中of    创建包含指定元素的Stream对象
     */
    @Test
    public void testOf() {
        String[] arr = {"1", "2", "3"};
        Stream.of(arr).forEach((ele) -> {
            System.out.println(ele);
        });
    }


    @Test
    public void streamApi() {

        List<String> name = new ArrayList<>();
        name.add("唐僧");
        name.add("孙悟空");
        name.add("猪八戒");
        name.add("沙和尚");

        name.stream().filter((ele) -> {
            return ele.length() == 3;
        }).forEach((ele) -> {
            System.out.println(ele);
        });

        System.out.println("-------------------");

        name.stream().filter((ele) -> {
            return ele.startsWith("唐");
        }).forEach((ele) -> {
            System.out.println(ele);
        });


        double average = name.stream().mapToInt((ele) -> {
            return ele.length();
        }).average().getAsDouble();
        System.out.println(average);
        System.out.println("-------------------");

        Stream t = name.stream().filter((ele) -> {
            System.out.println("hello");
            return ele.length() == 3;
        });

        System.out.println(t);
    }
}
