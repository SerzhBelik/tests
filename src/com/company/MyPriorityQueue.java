package com.company;

public class MyPriorityQueue<Item extends Comparable> {
    private Item[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private final double overloadFactor = 0.75;
    private final double underloadFactor = 0.25;

    public MyPriorityQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("bad size " + capacity);
        } else {
            list = (Item[]) new Comparable[capacity];
        }
    }

    public MyPriorityQueue() {
        list = (Item[]) new Comparable[DEFAULT_CAPACITY];
    }

    public void insert(Item item) {
        if (isOverload()) {
            resize(size*2);
        }
        list[size] = item;
        size++;
        int i = size - 1;
        while ((i > 0) && (list[i].compareTo(list[i - 1]) < 0)) {
            swap(i, i - 1);
            i--;
        }
    }

    public Item remove() {
        if (isUndeload()) {
            resize((int) (size * 1.5));
        }
        Item temp = peek();
        size--;
        list[size] = null;
        return temp;
    }

    public Item peek() {
        return list[size - 1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == list.length;
    }

    private void swap(int index1, int index2) {
        Item temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    private void resize(int newSize) {
        Item[] tempArr = (Item[]) new Comparable[newSize];

        list = tempArr;
        System.out.println("resized to new size " + newSize);
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < list.length ; i++) {
            s.append(list[i]+" ");
        }
        return s.toString();
    }

    public boolean isOverload(){
        return  (double)size / list.length > overloadFactor;
    }

    public boolean isUndeload(){
        return (double)size / list.length < underloadFactor;
    }

}

