package org.olddriver.learnjava.collections;

import java.util.Random;

/**
 * 顺序表
 *
 * 顺序表相关操作
 * 创建
 * 销毁
 * 清空   表长归0
 */
public class SequenceList<T> {

    private final int DEFAULT_CAPACITY = 100;
    private int capacity;
    private Object[] squenceList;
    private int length;

    public SequenceList() {
        super();
        squenceList = new Object[DEFAULT_CAPACITY];
        length = 0;
        capacity = DEFAULT_CAPACITY;
    }

    public SequenceList(Integer capacity) {
        super();
        squenceList = new Object[capacity];
        length = 0;
        this.capacity = capacity;
    }

    public boolean clear() {
        length = 0;
        return true;
    }

    public int length() {
        return length;
    }

    public boolean insert(T elem, int index) {
        if (index < 0 || index > length) {
            throw new RuntimeException("Index out of bounds.");
        }

        if (length == capacity) {
            throw new RuntimeException("SquenceList is full.");
        }

        for (int i = length - 1; i >= index; i--) {
            squenceList[i + 1] = squenceList[i];
        }
        squenceList[index] = elem;
        length++;
        return true;
    }

    public boolean remove(int index) {
        if (index < 0 || index > length - 1) {
            throw new RuntimeException("Index out of bounds.");
        }

        for (int i = index + 1; i < length; i++) {
            squenceList[i - 1] = squenceList[i];
        }
        length--;
        return true;
    }

    public T get(int index) {
        if (index < 0 || index > length - 1) {
            throw new RuntimeException("Index out of bounds.");
        }
        return (T) squenceList[index];
    }

    public int indexOf(T target) {
        int i;
        for (i = 0; i < length && !squenceList[i].equals(target); i++) {
        }
        if (i < length) {
            return i;
        }
        return -1;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        if (length != 0) {
            sb.append("(");
            for (int i = 0; i < length; i++) {
                sb.append((T) squenceList[i]).append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(")");
        } else {
            sb.append("()");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        SequenceList<String> sqList = new SequenceList<>();
        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            sqList.insert(String.valueOf((char)(random.nextInt(10)+97)),0);
        }
        System.out.println(sqList);
        System.out.println(sqList.get(0));

        sqList.remove(0);
        System.out.println(sqList);

        int index = sqList.indexOf("hello");
        System.out.println(index);

    }
}
