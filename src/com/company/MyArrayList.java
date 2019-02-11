package com.company;

import java.util.Arrays;

public class MyArrayList<Item extends Comparable> {

    private int size = 0;
    private int capacity;
    private final int DEFAULT_SIZE = 100;
    private Item[] list;

    public MyArrayList(){
        list = (Item[]) new Comparable[DEFAULT_SIZE];
        this.capacity = DEFAULT_SIZE;
    }

    public MyArrayList(int capacity){
        list = (Item[]) new Comparable[capacity];
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean delete(Item item){
        int i = 0;
        while (i < size && !item.equals(list[i])){
            i++;
        }
        if (i == size) return false;
        for (int j = i; j < size - 1; j++){
            list[j] = list[j+1];
        }
        size--;
        list[size] = null;

        return true;
    }

    public void add(Item item){
        list[size] = item;
        size++;
    }

    public void add(int index, Item item){
        for (int i = size; i > index; i--){
            list[i] = list [i-1];
        }
        list[index] = item;
        size++;

    }

    public void set(int index, Item item){
        if (index > size){
            throw new IllegalArgumentException("wrong index");

        } else list[index] = item;

    }

    public boolean linearFind(Item item){
        for (int i = 0; i < size; i++){
            if (list[i].equals(item)) return true;
        }
        return false;
    }


    public boolean binaryFind(Item item){
        int min = 0;
        int max = size - 1;
        while (min <= max){
            int mid = min + (max - min)/2;
            if (item.compareTo(this.get(mid)) < 0){
                max = mid - 1;
            } else if (item.compareTo(this.get(mid)) > 0){
                min = mid + 1;
            } else {
                return true;
            }

        }
        return  false;
    }

    public void bubbleSort(){
        for (int i = size-1; i > 0; i--){
            for (int j = 0; j < i; j++){
                if (!less(list[j] , list[j + 1])) swap(j, j + 1);
            }

        }
    }

    public void selectSort(){
        int iMin;
        for (int i = 0; i < size - 1; i++){
            iMin  = i;
            for (int j = i+ 1; j < size; j++){
                if (less(list[j], list[iMin])) iMin = j;
            }
            swap(i, iMin);
        }
    }

    public void insertSort(){
        Item key;
        for (int i = 0; i < size; i++){
            int j = i;
            key = list[i];
            while (j > 0 && less(key, list[j-1])){
                list[j] = list[j-1];
                j--;
            }
            list[j] = key;
        }
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < list.length ; i++) {
            s.append(list[i]+" ");
        }
        return s.toString();
    }

    public int getSize() {
        return size;
    }

    public Item get(int index){
        return list[index];
    }

    private boolean less(Item item1, Item item2){
        return item1.compareTo(item2) < 0;
    }

    private void swap(int index1, int index2){
        Item temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    public MyArrayList clone(){
        MyArrayList clone = new MyArrayList(this.getCapacity());
        for(int i = 0; i < this.getCapacity(); i++){
            clone.add(this.get(i));
        }
        return clone;
    }
}
