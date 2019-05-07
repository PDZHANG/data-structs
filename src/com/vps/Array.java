package com.vps;

public class Array<T> {

    private int size;

    private Object[] data;

    public Array (int capacity) {
        data = new Object[capacity];
        size = 0;
    }

    public Array(){
        this(10);
    }

    public int getSize(){
        return this.size;
    }

    public int getCapacity(){
        return data.length;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void addFirst(T e){
        add(0,e);
    }

    public void addLast(T e){
        add(size,e);
    }

    public T get(int idx){
        if (idx >= size) throw  new IllegalArgumentException("index error");
        if (idx<0 || idx>size) throw  new IllegalArgumentException("index error");

        return (T)data[idx];
    }
    public void set(int idx,T e){
        if (idx >= size) throw  new IllegalArgumentException("index error");
        if (idx<0 || idx>size) throw  new IllegalArgumentException("index error");

        data[idx] =e ;
    }

    public T remove(int index){
        if (index<0 || index>=size) throw  new IllegalArgumentException("index error");
//        for (int i = index ;i <size-1;i++){
//            data[i] = data[i+1];
//        }
        System.arraycopy(data, index + 1, data, index, size - 1 - index);
        T e = (T) data[index];
        size--;
        if (size == data.length/4 && data.length /2 != 0 ){
            resize(data.length/2);
        }
        return e;
    }

    public T removeFirst(){
        return remove(0);
    }

    public void removeLast(){
       remove(size-1);
    }

    public void removeElement(T e){
        int i = find(e);
        if (i!=-1){
            remove(i);
        }
    }

    public void add(int index,T e){
        if (size == data.length) {
            resize(2*data.length);
        }
        if (index<0 || index>size) throw  new IllegalArgumentException("index error");
//        for (int i = size-1;i>=index ;i--)
//            data[i+1] = data[i];

        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = e;
        size++;
    }

    public boolean contains(T e){
        for (int i =0; i< size ;i++){
            if (data[i] == e){
                return true;
            }
        }
        return false;
    }

    public int find(T e){
        for (int i =0; i< size ;i++){
            if (data[i] == e){
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Array size : %d ,Array capacity : %d \n",size,getCapacity()));
        stringBuilder.append("[");
        for (int i = 0; i<size ;i++){
            stringBuilder.append(data[i]);
            if (i<size-1){
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private void resize(int capacity){
        T[] newData = (T[]) new Object[capacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;

    }
}
