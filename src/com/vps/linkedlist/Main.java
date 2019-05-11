package com.vps.linkedlist;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++){
            linkedList.addFirst(i);
            System.out.println(linkedList.toString());
        }
        linkedList.add(1,8880);
        System.out.println(linkedList.toString());
    }
}
