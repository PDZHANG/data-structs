package com.vps.linkedlist;

public class LinkedList<E> {

    private Node dummyHead;
    private int size;

    private class Node{
        public E e;
        public Node next;
        public Node(E e,Node next){
            this.e =e;
            this.next = next;
        }

        public Node(E e){
            this.e =e;
            this.next = null;
        }

        public Node(){
            this.e =null;
            this.next = null;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public LinkedList(){
        size=0;
        dummyHead= new Node(null,null);
    }

    public int getSize(){
        return size;
    }

    public void addFirst(E e){
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
//        dummyHead = new Node(e,dummyHead);
//        size++;
        add(0,e);
    }

    public void add(int index,E e ){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("index error.");

        Node prev = dummyHead;
        for (int i = 0 ; i<index ;i++)
            prev = prev.next;
        prev.next = new Node(e ,prev.next);
        size++;

    }
    public void addLast(E e){
        add(size,e);
    }


    public E get(int index){

        Node cur = dummyHead.next;
        for (int i =0; i <index ; i ++) {
            cur = cur.next;
        }
        return cur.e;
    }
    public void set(int index,E e){

        Node cur = dummyHead.next;
        for (int i =0; i <index ; i ++) {
            cur = cur.next;
        }
        cur.e = e;
    }


    public boolean contains(E e){

        Node cur = dummyHead.next;
        for (; cur !=null ; cur = cur.next) {
            if (e.equals(cur.e)){
                return true;
            }
        }
        return false;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size-1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            sb.append(cur).append("->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }


    public E remove(int index){

        Node prev = dummyHead;
        for (int i = 0 ; i <index ;i++)
            prev = prev.next;

        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next =null;

        return retNode.e;
    }

    public E removeFirst( ){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

}
