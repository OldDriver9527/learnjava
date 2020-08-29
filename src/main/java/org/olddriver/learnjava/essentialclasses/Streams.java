package org.olddriver.learnjava.essentialclasses;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * 20200823
 * part 1
 */
public class Streams {
    /*
     * Stream<T>
     * 泛型，表示元素序列，元素类型只能是引用数据类型
     * 执行终结操作的流不能再次使用
     * 中间操作会返回新流
     * 仅调用中间操作，不会执行
     *
     * 常用方法
     * of(T t) 静态工厂方法，用于创建具有指定元素的Stream对象
     * of(T... values) 用于创建具有指定元素的Stream对象
     * forEach(Consumer<? super T> action)  遍历流中元素，对流中所有元素执行同一操作
     * count()  统计流中元素个数
     * filter(Predicate<? super T> predicate)   返回新流，新流中元素满足指定断言
     * limit(long maxSize) 返回新流，对当前流进行截取，截取前maxSize个元素
     * skip(long n) 返回新流，对当前流进行截取，跳过n个元素进行截取
     * map(Function<? super T, ? extends R> mapper) 返回新流，对当前流中所有元素执行同一操作后加入新流
     * sorted() 返回新流，按照自然顺序对当前流中元素进行排序
     * sorted(Comparator<? super T> comparator) 返回新流，按照比较器对当前流中元素进行排序
     * distinct() 返回新流，去除当前流中重复元素；根据元素equals方法判断元素是否重复
     * allMatch(Predicate<? super T> predicate) 终结操作，判断流中所有元素是否满足指定断言
     * anyMatch(Predicate<? super T> predicate) 终结操作，判断流中某一个元素是否满足指定断言
     * noneMatch(Predicate<? super T> predicate) 终结操作，判断流中所有元素是否都不满足指定断言
     * findFirst() 返回Optional对象，封装流中第一个元素
     * findAny() 返回Optional对象，封装流中第一个元素
     * max(Comparator<? super T> comparator) 返回Optional对象，按照比较器规则封装流中最大元素
     * min(Comparator<? super T> comparator) 返回Optional对象，按照比较器规则封装流中最小元素
     * reduce 归约操作
     *
     *
     *
     */

    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1,2,3,4);

        Optional<Integer> o =  stream.max((Integer i1 , Integer i2) -> {
            return i1 - i2;
        });

        System.out.println(o.get());

        Stream<Integer> stream1 = Stream.of(1,2,3,4);

        Optional<Integer> o1 =  stream1.min((Integer i1 , Integer i2) -> {
            return i1 - i2;
        });

        System.out.println(o1.get());


    }
}
