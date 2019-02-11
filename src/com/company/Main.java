package com.company;

public class Main {
    private final static int CAPACITY = 100000;
    public static void main(String[] args) {

        MyDeque<Integer> deque = new MyDeque<>(5);
        for (int i = 0; i < 20; i++){
            if (i % 2 == 0){
                deque.insertRight(i);
            } else {
                deque.insertLeft(i);
            }

        }
        System.out.println(deque);

        for (int i = 0; i < 18; i++){
            if (i % 2 == 0){
                deque.removeRight();
            } else {
                deque.removeLeft();
            }

        }

        System.out.println(deque);

}


}
