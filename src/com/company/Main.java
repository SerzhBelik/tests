package com.company;

public class Main {
    private final static int CAPACITY = 100000;
    public static void main(String[] args) {

        MyDeque<Integer> deque = new MyDeque<>(10);
        for (int i = 0; i < 5; i++){
            deque.insertRight(i);
        }

        for (int i = 5; i < 10; i++){
            deque.insertLeft(i);
        }

        deque.removeRight();
        deque.removeRight();
        deque.removeLeft();
        deque.insertRight(44);
        deque.insertRight(55);

        System.out.println(deque);







}


}
