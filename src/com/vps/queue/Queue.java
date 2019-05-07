package com.vps.queue;

public interface Queue<E> {

    void enqueue(E e);

    E dequeue();

    int getSize();

    boolean isEmpty();

    int getCapacity();
}
