package org.olddriver.learnjava.collections;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 链式存储结构的二叉树
 */
public class LinkedBinaryTree<T> {

    Node<T> root;

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    private class Node<T>{
        T data;
        Node<T> lchild;
        Node<T> rchild;
        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getLchild() {
            return lchild;
        }

        public void setLchild(Node<T> lchild) {
            this.lchild = lchild;
        }

        public Node<T> getRchild() {
            return rchild;
        }

        public void setRchild(Node<T> rchild) {
            this.rchild = rchild;
        }
    }

    /**
     * 辅助队列实现层次遍历
     * @param node
     */
    public void levelOrder(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node temp = queue.remove();
            System.out.print(temp.getData());
            if(temp.lchild != null){
                queue.add(temp.lchild);
            }
            if(temp.rchild != null){
                queue.add(temp.rchild);
            }
        }
    }

    /**
     * 辅助栈式中序遍历
     * @param node
     */
    public void inOrder(Node node){
        Node cur = node;
        LinkedList<Node> stack = new LinkedList<>();

        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.addFirst(cur);
                //System.out.print(cur.getData());
                cur = cur.getLchild();
            }else{
                Node temp = stack.removeFirst();
                //System.out.print(temp.getData());
                cur = temp.getRchild();
            }
        }
    }

    /**
     * 递归式先序遍历
     * @param node
     */
    public void preOrderTraverse(Node node){
        if(node == null){
            return;
        }else{
            //访问根节点
            System.out.print(node.getData());
            //先序遍历左子树
            preOrderTraverse(node.getLchild());
            //先序遍历右子树
            preOrderTraverse(node.getRchild());
        }
    }

    /**
     * 递归式中序遍历
     * @param node
     */
    public void inOrderTraverse(Node node){
        if(node == null){
            return;
        }else{
            inOrderTraverse(node.getLchild());
            System.out.print(node.getData());
            inOrderTraverse(node.getRchild());
        }
    }

    /**
     * 递归式后序遍历
     * @param node
     */
    public void postOrderTraverse(Node node){
        if(node == null){
            return;
        }else{
            postOrderTraverse(node.getLchild());
            postOrderTraverse(node.getRchild());
            System.out.print(node.getData());
        }

    }

    @Test
    public void testLevelOrderTraverse(){
        Node<String> a = new Node<>("A");
        Node<String> b = new Node<>("B");
        Node<String> c = new Node<>("C");
        Node<String> d = new Node<>("D");
        Node<String> e = new Node<>("E");

        a.setLchild(b);
        a.setRchild(c);
        b.setLchild(d);
        d.setLchild(e);
        levelOrder(a);

    }

    @Test
    public void testPostOrderTraverse(){
        Node<String> a = new Node<>("A");
        Node<String> b = new Node<>("B");
        Node<String> c = new Node<>("C");
        Node<String> d = new Node<>("D");
        Node<String> e = new Node<>("E");

        a.setLchild(b);
        a.setRchild(c);
        b.setLchild(d);
        d.setLchild(e);
        postOrderTraverse(a);

    }

    @Test
    public void testInOrderTraverse(){
        Node<String> a = new Node<>("A");
        Node<String> b = new Node<>("B");
        Node<String> c = new Node<>("C");
        Node<String> d = new Node<>("D");
        Node<String> e = new Node<>("E");

        a.setLchild(b);
        a.setRchild(c);
        b.setLchild(d);
        d.setLchild(e);
        inOrderTraverse(a);
        inOrder(a);
    }

    @Test
    public void testPreOrderTraverse(){
        Node<String> a = new Node<>("A");
        Node<String> b = new Node<>("B");
        Node<String> c = new Node<>("C");
        Node<String> d = new Node<>("D");
        Node<String> e = new Node<>("E");

        a.setLchild(b);
        a.setRchild(c);
        b.setRchild(d);
        d.setLchild(e);
        preOrderTraverse(a);
        inOrder(a);
    }


}
