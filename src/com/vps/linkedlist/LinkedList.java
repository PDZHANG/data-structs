package com.vps.linkedlist;

public class LinkedList<E> {

    private Node head;
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
        head=null;
    }

    public int getSize(){
        return size;
    }

    public void addFirst(E e){
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
        head = new Node(e,head);
        size++;
    }

    public void add(int index,E e ){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("index error.");
        if (index ==0 )
            addFirst(e);
        else {
            Node prev = head;
            for (int i = 0 ; i<index -1 ;i++)
                prev = prev.next;
            prev.next = new Node(e ,prev.next);
            size++;
        }
    }
    public void addLast(E e){
        add(size,e);
    }



}
