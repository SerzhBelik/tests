package com.company;

public class Main {
    public static void main(String[] args) {
        long timeStart;
        long timeFinish;
        MyArrayList list = new MyArrayList<>(100000);
        MyArrayList testList;

        fillList(list);

//        для чистоты эксперемента в каждой сортировке используется копия массива list
        testList = list.clone();
        timeStart = System.currentTimeMillis();
        testList.insertSort();
        timeFinish = System.currentTimeMillis();
        System.out.println("insertSort result = " + (timeFinish-timeStart));

        testList = list.clone();
        timeStart = System.currentTimeMillis();
        testList.selectSort();
        timeFinish = System.currentTimeMillis();
        System.out.println("selectSort result = " + (timeFinish-timeStart));

        testList = list.clone();
        timeStart = System.currentTimeMillis();
        testList.bubbleSort();
        timeFinish = System.currentTimeMillis();
        System.out.println("bubbleSort result = " + (timeFinish-timeStart));


    }

    private static void fillList(MyArrayList list){
        for (int i =0; i < list.getCapacity(); i++){
            list.add((int)(Math.random()*100000));
        }
    }

}
