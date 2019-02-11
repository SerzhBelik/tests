package com.company;

public class MyStack<Item> {
    private Item[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public MyStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("wrong capacity!");
        }
        list = (Item[]) new Object[capacity];
    }
    public MyStack(){
        list = (Item[]) new Object[DEFAULT_CAPACITY];
    }

    public Item peek(){
        return list[size];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == list.length;
    }

    public void push(Item item){
        if (isFull()) throw new StackOverflowError("stack is full!");
        list[size] = item;
        size++;
    }

    public Item pop(){
        if (isEmpty()){
            System.out.println("stack is empty!");
            return null;
        }

        Item tempItem = peek();
        size--;
        list[size] = null;
        return tempItem;
    }

}
