package com.vps.stack;

public class ArrayStack<E> implements Stack<E> {

    private static int DEFAULT_CAPACITY = 10;
    private int size;

    private E[] data;

    public ArrayStack(){
       this(DEFAULT_CAPACITY);
    }

    public ArrayStack(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
    }

    @Override
    public void push(E e) {
        if (size == data.length)
            resize(data.length*2);
        data[size] = e;
        size++;
    }

    private void remove(int index){
        if (size == data.length/4)
            resize(data.length/2);
        System.arraycopy(data, index + 1, data, index, size - 1 - index);
        size--;
    }

    @Override
    public E pop() {
        if (size == 0 ){
            throw new IllegalArgumentException("Stack is null");
        }
        E e = data[size - 1];
        remove(size-1);
        return e;
    }

    @Override
    public E peek() {
        if (size == data.length/4)
            resize(data.length/2);
        return data[size - 1];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return data.length == 0;
    }

    private void resize(int capacity){
        E[] newData = (E[]) new Object[capacity];
        System.arraycopy(data,0,newData,0,size);
        data = newData;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append("[");
        for (int i = 0; i < size ; i++){
            res.append(i);
            if (i != size -1 ){
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();

    }
}
