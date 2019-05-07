package com.vps;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Array<Integer> arr = new Array<>();
        for (int i = 0;i<10 ;i++){
            arr.addLast(i);
        }
        System.out.println(arr.toString());

        arr.addFirst(-1);
        System.out.println(arr.toString());


        arr.add(1,88);
        System.out.println(arr.toString());

        Integer get1 = arr.get(1);
        System.out.println(get1);

        arr.set(0,-99);
        System.out.println(arr.toString());

        if (arr.contains(-99)) {
            int i = arr.find(-99);
            arr.remove(i);
        }

        System.out.println(arr.toString());

        arr.remove(1);
        System.out.println(arr.toString());
        arr.removeFirst();
        System.out.println(arr.toString());
        arr.removeLast();
        System.out.println(arr.toString());
        arr.removeElement(5);
        System.out.println(arr.toString());
    }
}
