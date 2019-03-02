package com.company;


public class Main {

    public static void main(String[] args) {
        ChainingHashST<Integer, String> chst = new ChainingHashST<>(8);
        for (int i = 0; i < 21; i++) {
            chst.put(i, "i =" + i);
        }

        System.out.println(chst);

        chst.delete(10);
        chst.put(24, "24");

        System.out.println(chst);
    }
}


