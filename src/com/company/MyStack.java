package com.company;

public class MyStack<Item> {
    private Item[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    private int capacity;
    private final double overloadFactor = 0.75;
    private final double underloadFactor = 0.25;


    public MyStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("wrong capacity!");
        }
        list = (Item[]) new Object[capacity];
        this.capacity = capacity;
    }
    public MyStack(){
        list = (Item[]) new Object[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
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
        if (isOverload()) resize(size * 2);
        list[size] = item;
        size++;
    }

    public Item pop(){
        if (isUndeload()) resize((int)(size * 1.5));

        Item tempItem = peek();
        size--;
        list[size] = null;
        return tempItem;
    }

    public int getSize() {
        return size;
    }

    public int getCapcity() {
        return capacity;
    }

    public boolean isOverload(){
        return  (double)size / list.length > overloadFactor;
    }

    public boolean isUndeload(){
        return (double)size / list.length < underloadFactor;
    }

    private void resize(int newSize) {
        Item[] tempArr = (Item[]) new Comparable[newSize];

        list = tempArr;
        System.out.println("resized to new size " + newSize);
    }

}
