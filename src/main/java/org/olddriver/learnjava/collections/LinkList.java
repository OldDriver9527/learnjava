package org.olddriver.learnjava.collections;

/**
 * 带头结点，不循环，单链表
 */
public class LinkList<T> {

    private class Node<T> {
        private T data;
        private Node<T> next;

        public Node() {
            super();
        }

        public Node(T data, Node<T> next) {
            super();
            this.data = data;
            this.next = next;
        }
    }

    private Node<T> head;
    private int length;

    public LinkList() {
        super();
        Node<T> node = new Node<>(null, null);
        head = node;
        length = 0;
    }

    public boolean insert(T elem) {
        Node<T> node = new Node<>(elem, null);

        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
        length++;
        return true;
    }

    public boolean insert(T elem, int index) {
        if (index < 0 || index > length) {
            throw new RuntimeException("Index out of bounds.");
        }

        Node<T> node = new Node<>(elem, null);

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        node.next = current.next;
        current.next = node;
        length++;
        return true;
    }

    public boolean remove() {
        Node<T> current = head;

        for (int i = 0; i < length - 1; i++) {
            current = current.next;
        }

        current.next = null;
        length--;
        return true;
    }

    public T get(int index) {
        if (index < 0 || index > length - 1) {
            throw new RuntimeException("Index out of bounds.");
        }

        Node<T> current = head.next;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (length != 0) {
            sb.append("(");
            Node current = head.next;
            while (current != null) {
                sb.append(current.data).append(",");
                current = current.next;
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(")");
        } else {
            sb.append("()");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkList<String> linkList = new LinkList<>();

        String[] arr = {"hello", "world", "qqq", "www"};

        for (int i = 0; i < arr.length; i++) {
            linkList.insert(arr[i]);
        }

        System.out.println(linkList);

        linkList.insert("java", 2);
        System.out.println(linkList);

        linkList.remove();
        System.out.println(linkList);
        linkList.remove();
        System.out.println(linkList);

        System.out.println(linkList.get(linkList.length - 1));
        System.out.println(linkList.get(0));
    }
}
