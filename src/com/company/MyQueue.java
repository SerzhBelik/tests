package com.company;

public class MyQueue<Item> {
    private Item[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private int begin = 0;
    private int end = 0;

    public MyQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("bad size " + capacity);
        } else {
            list = (Item[]) new Object[capacity];
        }
    }

    public MyQueue() {
        list = (Item[]) new Object[DEFAULT_CAPACITY];
    }

    public void insert(Item item){
        if (isFull()){
            throw new StackOverflowError();
        }
        size++;
        list[end]=item;
        end = nextIndex(end);
    }

    public Item remove(){
        Item temp = peek();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return temp;
    }

    public Item peek(){
        if (isEmpty()){
            throw new StackOverflowError("size == 0");
        }
        return list[begin];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == list.length;
    }

    private int nextIndex(int index) {

        return (index + 1) % list.length;
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < list.length ; i++) {
            s.append(list[i]+" ");
        }
        return s.toString();
    }
}
