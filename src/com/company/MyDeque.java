package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MyDeque<Item> {
    private Item[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private int leftMark = 0;
    private int rightMark = 0;
    private final double overloadFactor = 0.75;
    private final double underloadFactor = 0.25;

    public MyDeque(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("bad size " + capacity);
        } else {
            list = (Item[]) new Object[capacity];
        }
        setMarks();
    }

    public MyDeque() {
        list = (Item[]) new Object[DEFAULT_CAPACITY];
        setMarks();
    }

    private void setMarks() {
        this.leftMark = list.length / 2;
        this.rightMark = list.length / 2 + 1;
    }

    public void insertRight(Item item){
        if (isOverload()){
            resize(size*2);
        }
        size++;
        list[rightMark]=item;
        rightMark = nextIndex(rightMark);
    }

    public void insertLeft(Item item){
        if (isOverload()){
            resize(size*2);;
        }
        size++;
        list[leftMark]=item;
        leftMark = lastIndex(leftMark);
    }

    public Item removeLeft(){
        Item temp = peekLeft();
        size--;
        list[nextIndex(leftMark)] = null;
        leftMark = nextIndex(leftMark);
        return temp;
    }

    public Item removeRight(){
        if (isUndeload()){
            resize((int) (size * 1.5));
        }
        Item temp = peekRight();
        size--;
        list[lastIndex(rightMark)] = null;
        rightMark = lastIndex(rightMark);
        return temp;
    }

    public Item peekRight(){
        if (isEmpty()){
            throw new StackOverflowError("size == 0");
        }
        return list[lastIndex(rightMark)];
    }
    public Item peekLeft(){
        if (isEmpty()){
            throw new StackOverflowError("size == 0");
        }
        return list[nextIndex(leftMark)];
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

    public int lastIndex(int index){
        return  (index + list.length - 1)%(list.length);
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

    private void resize(int newSize) {
        Item[] tempArr = (Item[]) new Comparable[newSize];

        for (int i = 0; i < Math.min(newSize - 1, size); i++){
            tempArr[i] = peekLeft();
            leftMark = nextIndex(leftMark);
        }
        leftMark = newSize-1;
        rightMark = size;
        String s = Arrays.toString(list);
//        System.out.println(s);
        list = tempArr;
        s = Arrays.toString(list);
        System.out.println("resized to new size " + newSize);
//        System.out.println(s);


    }


}
