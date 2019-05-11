package com.vps.queue;

public class LinkedListQueue<E> implements Queue<E> {
    private int size;

    private Node head,tail;

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
    @Override
    public void enqueue(E e) {
        if (tail==null){
            tail = new Node(e);
            head = tail;
        }else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from empty queue");
        Node resNode = head;
        head = head.next;
        resNode.next = null;
        if (head == null)
            tail=null;
        size--;
        return resNode.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int getCapacity() {
        return size;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Queue front : ");
        Node cur = head;
        while (cur !=null){
            stringBuilder.append(cur).append("->");
            cur = cur.next;
        }
        stringBuilder.append(" tail ");
        return stringBuilder.toString();


    }
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列不能为空！");
        }
        return head.e;
    }
    public static void main(String[] args) {
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        for (int i = 0; i< 10 ;i++){
            linkedListQueue.enqueue(i);
            System.out.println(linkedListQueue.toString());
        }
        linkedListQueue.dequeue();
        System.out.println(linkedListQueue.toString());


    }
}
