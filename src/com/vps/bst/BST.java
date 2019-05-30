package com.vps.bst;

public class BST<E extends Comparable<E>> {

    private class Node<E> {
        E e;
        Node<E> left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;

        }

        public Node(E e, Node<E> left, Node<E> right) {
            this.e = e;
            this.left = left;
            this.right = right;

        }
    }

    public Node<E> root;

    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


//    public void add(E e){
//        if (root == null){
//            root = new Node(e);
//            size++;
//        }else {
//            add(e);
//        }
//
//    }
//
//    private void add(Node<E> node , E e){
//        if (node.e.equals(e)){
//            return;
//        }else  if (e.compareTo(node.e) < 0 && node.left == null){
//            node.left = new Node<E>(e);
//        }else if (e.compareTo(node.e) < 0 && node.right == null){
//            node.right =new Node<E>(e);
//        }
//
//        if(e.compareTo(node.e) < 0) {
//            add(node.left, e);
//        } else //e.compareTo(node.e) > 0
//        {
//            add(node.right, e);
//        }
//    }

    public void add(E e) {
        root = add(root, e);
    }

    private Node<E> add(Node<E> node, E e) {
        if (node == null) {
            return new Node<E>(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else //e.compareTo(node.e) > 0
        {
            node.right = add(node.right, e);
        }

        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node<E> node, E e) {
        if (node == null) {
            return false;
        }
        if (node.e.compareTo(e) < 0) {
            return contains(node.left, e);
        } else if (node.e.compareTo(e) > 0) {
            return contains(node.right, e);
        } else {
            return node.e.compareTo(e) == 0;
        }

    }


    // 二分搜索树的前序遍历
    public void preOrder(){
        preOrder(root);
    }

    // 前序遍历以node为根的二分搜索树, 递归算法
    private void preOrder(Node node){
        if(node == null) {
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res){

        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++) {
            res.append("--");
        }
        return res.toString();
    }

}
