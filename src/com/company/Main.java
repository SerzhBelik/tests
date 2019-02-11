package com.company;

public class Main {
    private final static int CAPACITY = 100000;
    public static void main(String[] args) {
        long timeStart;
        long timeFinish;

        MyArrayList list = new MyArrayList<>(CAPACITY);
        MyArrayList testList;

        fillList(list);

//


}

    private static void fillList(MyArrayList list){
        for (int i =0; i < list.getCapacity(); i++){
            list.add((int)(Math.random()*CAPACITY));
        }
    }

}
