package com.company;

public class MyStack<Item> {
    private Item[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    private int capcity;


    public MyStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("wrong capacity!");
        }
        list = (Item[]) new Object[capacity];
        this.capcity = capacity;
    }
    public MyStack(){
        list = (Item[]) new Object[DEFAULT_CAPACITY];
        this.capcity = DEFAULT_CAPACITY;
    }

    public Item peek(){
        return list[size-1];
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

    public int getSize() {
        return size;
    }

    public int getCapcity() {
        return capcity;
    }

}
