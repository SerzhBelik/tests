package com.company;

public class MyPriorityQueue<Item extends Comparable> {
    private Item[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;

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
        if (isFull()) {
            throw new StackOverflowError("queue full");
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
        if (isEmpty()) {
            System.out.println("queue empty");
            return null;
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
        Item[] tempArr = (Item[]) new Object[newSize];
        System.arraycopy(list, 0, tempArr, 0, list.length);
        list = tempArr;
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

