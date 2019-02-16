package com.company;

public class MyQueue<T> {
    private MyLinkedList<T> stack = new MyLinkedList<>();

    public void enqueue(T item){
        stack.insertFirst(item);
    }

    public T dequeue(){
        return stack.deleteLast();
    }

    public T peek(){
        return stack.getLast();
    }

    public int size(){
        return stack.size();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

}
