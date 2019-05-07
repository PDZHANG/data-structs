package com.vps.queue;

import com.vps.Array;

public class ArrayQueue<E> implements Queue<E> {
    private Array<E> array;

    public ArrayQueue(){
        array = new Array<>();
    }

    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }


    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue : front [");
        for (int i = 0; i<array.getSize() ; i++){
            res.append(array.get(i));
            if (i != array.getSize()- 1)
                res.append(", ");

        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        for (int i = 0; i< 1000 ;i++)
            arrayQueue.enqueue(i);
        System.out.println(arrayQueue.toString());
        arrayQueue.dequeue();
        System.out.println(arrayQueue.toString());

    }
}
