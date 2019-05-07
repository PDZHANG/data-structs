package com.vps.queue;

public class LoopQueue<E> implements Queue<E> {

    private E[] data;

    private int front,tail;

    private int size;

    public LoopQueue(){
        this(10);
    }

    public LoopQueue(int capacity){
        data = (E[]) new Object[capacity+1];
        front=0;
        tail =0;
        size =0;
    }


    @Override
    public void enqueue(E e) {
        if ((tail +1)%data.length == front){
            resize(getCapacity()*2);
        }
        data[tail] =e;
        tail = (tail+1)%data.length;
        size++;
    }

    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity+1];
        for (int i = 0; i< size ;i++){
            newData[i]  = data[(i+front)%data.length];
        }
        data = newData;
        front = 0;
        tail = size;

    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue..");
        E e = data[front];
        data[front] = null;
        front = (front+1)%data.length;
        size--;
        if (size == getCapacity() /4 && getCapacity()/2!=0)
            resize(getCapacity()/2);

        return e;
    }

    public E getFront(){
        if (front == 0)
            throw new IllegalArgumentException("Queue is null");
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return tail==front;
    }

    @Override
    public int getCapacity() {
        return data.length-1;
    }
}
