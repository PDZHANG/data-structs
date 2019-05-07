package com.vps.stack;

public class StackMain {

    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();

        for (int i = 0; i < 15; i++){
            arrayStack.push(i);
            System.out.println(arrayStack.toString());
        }
        arrayStack.pop();
        System.out.println(arrayStack.toString());

        arrayStack.pop();
        System.out.println(arrayStack.toString());

        arrayStack.pop();
        System.out.println(arrayStack.toString());
        arrayStack.pop();
        System.out.println(arrayStack.toString());
        arrayStack.pop();
        System.out.println(arrayStack.toString());
        arrayStack.pop();
        System.out.println(arrayStack.toString());
    }
}
